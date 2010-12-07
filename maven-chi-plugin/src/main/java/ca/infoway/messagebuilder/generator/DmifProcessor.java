package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;
import static ca.infoway.messagebuilder.generator.LogLevel.ERROR;
import static ca.infoway.messagebuilder.generator.LogLevel.WARN;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

class DmifProcessor {
	
	private XPathHelper xpath = new XPathHelper();
	private final MifRegistry registry;
	private final OutputUI outputUI;
	
	public DmifProcessor(OutputUI outputUI, File mifTransform) throws GeneratorException {
		this(new MifRegistry(mifTransform, outputUI), outputUI);
	}
	public DmifProcessor(MifRegistry registry, OutputUI outputUI) {
		this.registry = registry;
		this.outputUI = outputUI;
	}

	private List<Interaction> extractInteractions(MessageSet messageSet, File file) throws SAXException, IOException, XPathExpressionException {
		FileInputStream input = new FileInputStream(file);
		try {
			return extractInteractions(messageSet, file.getName(), input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	private List<Interaction> extractInteractions(MessageSet messageSet, String name, InputStream input) throws SAXException, IOException, XPathExpressionException {
		Document dmif = new DocumentFactory().createFromStream(input);
		return extractInteractions(messageSet, name, dmif);
	}

	private List<Interaction> extractInteractions(MessageSet messageSet, String name, Document dmif) throws XPathExpressionException {
		List<Interaction> result = new ArrayList<Interaction>();
		NodeList list = dmif.getElementsByTagNameNS(Namespaces.MIF_NAMESPACE.getNamespace(), "hl7Interaction");
		for (int i = 0, length = list == null ? 0 : list.getLength(); i < length; i++) {
			result.add(extractInteraction(messageSet, name, (Element) list.item(i)));
		}
		return result;
	}

	private Interaction extractInteraction(MessageSet messageSet, String name, Element element)
			throws XPathExpressionException {
		Interaction interaction = new Interaction();
		Element packageLocation = (Element) new XPathHelper().getSingleNode(element, "./mif:packageLocation", Namespaces.MIF_NAMESPACE);
		Element parameterTypeModel = (Element) new XPathHelper().getSingleNode(element, "./mif:parameterTypeModel", Namespaces.MIF_NAMESPACE);
		List<Annotation> documentationForInteraction = new MifXPathHelper().getDocumentationForInteraction(element);
		String businessName = new XPathHelper().getAttributeValue(element, "./mif:businessName/@name", Namespaces.MIF_NAMESPACE);

		interaction.setName(EntryPointAssembler.getEntryPoint(packageLocation));
		String parent = EntryPointAssembler.getEntryPoint(parameterTypeModel);
		interaction.setSuperTypeName(messageSet.getPackageLocationRootType(parent));
		interaction.setBusinessName(businessName);
		if (documentationForInteraction != null && !documentationForInteraction.isEmpty()) {
			interaction.setDocumentation(new Documentation(documentationForInteraction));
		}
		
		List<Argument> arguments = getArguments(messageSet, parameterTypeModel);
		if (!CollectionUtils.isEmpty(arguments)) {
			interaction.getArguments().addAll(arguments);
		}
		
		return interaction;
	}

	private List<Argument> getArguments(MessageSet messageSet, Element parent) throws XPathExpressionException {
		List<Argument> result = new ArrayList<Argument>();
		NodeList list = this.xpath.getNodes(parent, "./mif:supplierBindingArgument", Namespaces.MIF_NAMESPACE);
		
		for (int i = 0, length = list == null ? 0 : list.getLength(); i < length; i++) {
			Argument argument = new Argument();
			Element element = (Element) list.item(i);
			String packageName = EntryPointAssembler.getEntryPoint(element);
			
			String rootType = messageSet.getPackageLocationRootType(packageName);
			
			if (rootType == null) {
				this.outputUI.log(ERROR, "Could not find a root type for package location (location will be skipped): "+ packageName);
			} else {
				argument.setName(rootType);
				argument.setTemplateParameterName(element.getAttribute("templateParameterName"));
				argument.setTraversalName(element.getAttribute("traversalName"));
				
				if (messageSet.getMessagePart(argument.getName()) == null) {
					throw new IllegalStateException("Cannot find argument type " + argument.getName());
				} else {
					List<Argument> arguments = getArguments(messageSet, element);
					if (!CollectionUtils.isEmpty(arguments)) {
						argument.getArguments().addAll(arguments);
					}
					result.add(argument);
				}
				
				NodeList nodes = this.xpath.getNodes(element, "./mif:participantClassSpecialization", Namespaces.MIF_NAMESPACE);
				List<Relationship> choices = extractChoices(messageSet, packageName, nodes);
				argument.getChoices().addAll(choices);
			}
		}
		return result;
	}

	private List<Relationship> extractChoices(MessageSet messageSet, String packageName, NodeList nodes)
			throws XPathExpressionException {
		List<Relationship> choices = new ArrayList<Relationship>();
		for (int i = 0, length = nodes == null ? 0 : nodes.getLength(); i < length; i++) {
			Element specialization = (Element) nodes.item(i);
			Relationship relationship = new Relationship();
			String className = specialization.getAttribute("className");
			
			String nestedPackageName = packageName;
			
			String type = packageName + "." + className;
			if (messageSet.getMessagePart(type) != null) {
				relationship.setType(type);
				relationship.setName(specialization.getAttribute("traversalName"));
				choices.add(relationship);
			} else if (this.registry.isMifRegistered(packageName)) {
				Mif mif = this.registry.getMif(packageName);
				String referenceType = MifXPathHelper.getExternalReferenceType(mif.asDocument().getDocumentElement(), className);
				if (referenceType == null) {
					referenceType = MifXPathHelper.getExternalReferenceType(mif.asDocument().getDocumentElement(), i);
					mif = this.registry.getMif(referenceType);
					type = referenceType + "." + className;
				} else {
					type = messageSet.getPackageLocationRootType(referenceType);
				}
				
				if (StringUtils.isNotBlank(type)) {
					nestedPackageName = referenceType;
					relationship.setType(type);
					relationship.setName(specialization.getAttribute("traversalName"));
					choices.add(relationship);
				} else {
					this.outputUI.log(WARN, "Name " + packageName + "." + className + " seems to resolve to " + referenceType + " but we can't resolve that.");
				}
			} else {
				this.outputUI.log(WARN, "Cannot find type : " + className + " related to " + packageName);
			}
			
			// find nested choices
			NodeList subNodes = this.xpath.getNodes(specialization, "./mif:specialization", Namespaces.MIF_NAMESPACE);
			if (subNodes.getLength() > 0) {
				List<Relationship> subChoices = extractChoices(messageSet, nestedPackageName, subNodes);
				relationship.getChoices().addAll(subChoices);
			}
			
		}
		return choices;
	}

	public void addInteractionsFromDmifs(MessageSet messageSet, List<MifReference> list) throws IOException, XPathExpressionException, SAXException {
		for (MifReference reference : list) {
			this.outputUI.log(DEBUG, "DMIF - now processing file " + reference.asFile().getName());
			List<Interaction> interactions = extractInteractions(messageSet, reference.asFile());
			for (Interaction interaction : interactions) {
				messageSet.getInteractions().put(interaction.getName(), interaction);
			}
		}
	}
}
