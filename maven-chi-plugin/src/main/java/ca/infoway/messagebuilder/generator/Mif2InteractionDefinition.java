package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.WARN;
import static ca.infoway.messagebuilder.generator.Namespaces.MIF2_NAMESPACE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
import ca.infoway.messagebuilder.xml.Relationship;

class Mif2InteractionDefinition implements InteractionDefinition {
	
	private XPathHelper xPath = new XPathHelper();
	private final Document document;
	private final OutputUI outputUI;
	private final MifRegistry registry;

	Mif2InteractionDefinition(Document document, MifRegistry mifRegistry, OutputUI outputUI) {
		this.document = document;
		this.registry = mifRegistry;
		this.outputUI = outputUI;
	}
	
	public static InteractionDefinition create(MifReference mifReference, MifRegistry mifRegistry, OutputUI outputUI) throws GeneratorException, IOException {
		try {
			Document document = new DocumentFactory().createFromFile(mifReference.asFile());
			return new Mif2InteractionDefinition(document, mifRegistry, outputUI);
		} catch (SAXException e) {
			throw new GeneratorException(e.getMessage());
		}
	}

	public Interaction extract(MessagePartResolver resolver) throws GeneratorException {
		try {
			Interaction interaction = new Interaction();

			Element packageLocation = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:packageLocation", MIF2_NAMESPACE);
			interaction.setName(EntryPointAssembler.getEntryPoint(packageLocation));
			
			Element message = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:argumentMessage", MIF2_NAMESPACE);
			interaction.setSuperTypeName(
					resolver.getPackageLocationRootType(EntryPointAssembler.getEntryPoint(message)));
			
			Element interactionName = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:businessName", MIF2_NAMESPACE);
			interaction.setBusinessName(interactionName.getAttribute("name"));
			
			addArguments(interaction.getArguments(), message, resolver);
			
			return interaction;
		} catch (XPathExpressionException e) {
			throw new GeneratorException(e.getMessage());
		}
	}

	private void addArguments(List<Argument> arguments, Element element, MessagePartResolver resolver) throws XPathExpressionException {
		NodeList list = this.xPath.getNodes(element, "./mif2:parameterModel", Namespaces.MIF2_NAMESPACE);
		for (Element parameter : NodeListIterator.elementIterable(list)) {
			Argument argument = new Argument();
			String packageName = EntryPointAssembler.getEntryPoint(parameter);
			argument.setName(resolver.getPackageLocationRootType(packageName));
			argument.setTraversalName(parameter.getAttribute("traversalName"));
			argument.setTemplateParameterName(parameter.getAttribute("parameterName"));
			arguments.add(argument);
			
			// handle choices
			NodeList nodes = this.xPath.getNodes(parameter, "./mif2:specialization", Namespaces.MIF2_NAMESPACE);
			List<Relationship> choices = extractChoices(resolver, packageName, nodes);
			argument.getChoices().addAll(choices);
			
			addArguments(argument.getArguments(), parameter, resolver);
		}
	}
	
	private List<Relationship> extractChoices(MessagePartResolver resolver, String packageName, NodeList nodes) throws XPathExpressionException {
		List<Relationship> choices = new ArrayList<Relationship>();
		for (int i = 0, length = nodes == null ? 0 : nodes.getLength(); i < length; i++) {
			Element specialization = (Element) nodes.item(i);
			Relationship relationship = new Relationship();
			String attribute = specialization.getAttribute("className");
			
			String nestedPackageName = packageName;

			String type = packageName + "." + attribute;
			if (resolver.getMessagePart(type) != null) {
				relationship.setType(type);
				relationship.setName(specialization.getAttribute("traversalName"));
				choices.add(relationship);
			} else if (this.registry.isMifRegistered(packageName)) {
				String referenceType = this.registry.getMifIdFromAlias(attribute);
				type = referenceType == null ? null : resolver.getPackageLocationRootType(referenceType);
				if (StringUtils.isNotBlank(type)) {
					nestedPackageName = referenceType;
					relationship.setType(type);
					relationship.setName(specialization.getAttribute("traversalName"));
					choices.add(relationship);
				} else {
					this.outputUI.log(WARN, "Name " + packageName + "." + attribute + " seems to resolve to " + referenceType + " but we can't resolve that.");
				}
			} else {
				this.outputUI.log(WARN, "Cannot find type : " + attribute + " related to " + packageName);
			}
			
			// find nested choices
			NodeList subNodes = this.xPath.getNodes(specialization, "./mif2:choiceItem", Namespaces.MIF2_NAMESPACE);
			if (subNodes.getLength() > 0) {
				List<Relationship> subChoices = extractChoices(resolver, nestedPackageName, subNodes);
				relationship.getChoices().addAll(subChoices);
			}
		}
		
		
		return choices;
	}
	
}
