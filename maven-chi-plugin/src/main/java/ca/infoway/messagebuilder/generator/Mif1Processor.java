package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.MifXPathHelper.getClassElement;
import static ca.infoway.messagebuilder.generator.MifXPathHelper.getTemplateParameterName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;


class Mif1Processor extends BaseMifProcessorImpl implements MifProcessor {
	
	public Mif1Processor(MifRegistry mifRegistry, OutputUI outputUI) {
		super(mifRegistry, outputUI, new MifXPathHelper());
	}

	@Override
	protected List<MifReference> extractPartMifs(List<MifReference> mifs) {
		return filterFiles(mifs, "mif");
	}

	@Override
	protected List<MifReference> extractInteractionMifs(List<MifReference> mifs) {
		return filterFiles(mifs, "dmif");
	}
	
	protected void processInteractions(MessageSet messageSet, List<MifReference> list) throws IOException,
			GeneratorException {
		try {
			new DmifProcessor(this.mifRegistry, this.outputUI).addInteractionsFromDmifs(messageSet, list);
		} catch (XPathExpressionException e) {
			throw new GeneratorException("Problem analyzing file", e);
		} catch (SAXException e) {
			throw new GeneratorException("Problem parsing file", e);
		}
	}
	
	protected Element getEntryPointElement(MifReference reference) throws IOException, GeneratorException {
		return this.helper.getOwnedEntryPointElement(this.mifRegistry.getMif(reference).asDocument());
	}

	protected void processRelationships(MessageSet messageSet, Mif mif) {
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(mif.asDocument());
		processRelationships(messageSet, MifXPathHelper.getSpecializedClasses(ownedEntryPoint));
		processRelationships(messageSet, MifXPathHelper.getParticipantClasses(ownedEntryPoint));
	}

	private void processRelationships(MessageSet messageSet, 
			List<Element> specializedClasses) {
		for (Element element : specializedClasses) {
			if (MifXPathHelper.isMifClassPresent(element)) {
				Element classElement = MifXPathHelper.getClassElement(element);
				String name = NameHelper.qualifiyName(element, classElement.getAttribute("name"));
				MessagePart part = messageSet.getMessagePart(name);
				
				if (part == null) {
					throw new MifProcessingException("Cannot find part named " + name);
				} else {
					addRelationships(messageSet, element, part);
				}
			}
		}
	}

	protected List<MessagePart> extractMessageParts(MessageSet messageSet, Mif mif) throws GeneratorException, IOException {
		List<MessagePart> result = new ArrayList<MessagePart>();
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(mif.asDocument());
		String qualifier = createPackageLocation(messageSet, ownedEntryPoint);
		
		processSpecializedClasses(messageSet, result, qualifier, MifXPathHelper.getSpecializedClasses(ownedEntryPoint));
		processSpecializedClasses(messageSet, result, qualifier, MifXPathHelper.getParticipantClasses(ownedEntryPoint));
		
		for (MessagePart messagePart : result) {
			messageSet.addMessagePart(messagePart);
		}
		
		return result;
	}

	private void processSpecializedClasses(MessageSet messageSet, List<MessagePart> result,
			String qualifier, List<Element> specializedClasses) {
		
		for (Element element : specializedClasses) {
			if (MifXPathHelper.isMifClassPresent(element)) {
				MessagePart part = createPart(result, qualifier, element);
				addDocumentation(getClassElement(element), part);
				processChilds(messageSet, element, part);
				result.add(part);
			}
		}
	}

	private void processChilds(MessageSet messageSet, Element element, MessagePart part) {
		List<Element> children = MifXPathHelper.getSpecializationChilds(element);
		for (Element child : children) {
			Element classElement = MifXPathHelper.getChildClassElement(child);
			if (classElement != null) {
				String name = classElement.getAttribute("name");
				part.getSpecializationChilds().add(NameHelper.qualifiyName(child, name));
			} else if (isReference(child)) {
				String name = MifXPathHelper.getMifReferenceType(child);
				if (MifXPathHelper.isExternalReferenceType(child)) {
					String externalLocation = MifXPathHelper.getExternalReferenceType(child, name);
					String rootType = messageSet.getPackageLocationRootType(externalLocation);
					part.getSpecializationChilds().add(rootType);
				} else {
					part.getSpecializationChilds().add(NameHelper.qualifiyName(child, name));
				}
			} else {
				String packageLocationName = MifXPathHelper.getGeneralizationTarget(child);
				PackageLocation packageLocation = messageSet.getPackageLocations().get(packageLocationName);
				String root = packageLocation == null ? null : packageLocation.getRootType();
				if (StringUtils.isNotBlank(root)) {
					part.getSpecializationChilds().add(root);
				} else {
					throw new MifProcessingException("Cannot find the packageLocation : " 
							+ packageLocationName + " while processing " + part.getName());
				}
			}
		}
	}

	private boolean isReference(Element child) {
		return MifXPathHelper.isMifReferenceElementPresent(child);
	}

	private void addRelationships(MessageSet messageSet, Element specializedClass, MessagePart part) {
		NodeList nodes = getClassElement(specializedClass).getChildNodes();
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			
			if ("attribute".equals(element.getLocalName())) {
				createAttribute(part, element);
			} else if ("association".equals(element.getLocalName()) && !isChoice(element)) {
				createStandardAssociation(messageSet, part, element);
			} else if ("association".equals(element.getLocalName())) {
				createChoice(messageSet, part, element);
			}
		}
	}

	private void createChoice(MessageSet messageSet, MessagePart part,
			Element element) {
		Element targetConnection = MifXPathHelper.getTargetConnection(element);
		Relationship choice = new Relationship();
		choice.setName(targetConnection.getAttribute("name"));
		
		ChoiceTypeStrategy strategy = ChoiceTypeStrategy.getChoiceTypeStrategy(targetConnection);
		choice.setType(strategy.getHighLevelType(messageSet));
		choice.setCardinality(createCardinality(targetConnection));
		choice.setUpdateMode(createUpdateMode(targetConnection));		
		choice.setConformance(createConformance(targetConnection));
		
		List<ChoiceOption> choiceOptions = strategy.getChoiceOptions(messageSet);
		for (ChoiceOption choiceOption : choiceOptions) {
			Relationship relationship = new Relationship();
			relationship.setName(choiceOption.getRelationshipName());
			relationship.setType(choiceOption.getType());
			
			for (ChoiceOption subOption : choiceOption.getOptions()) {
				Relationship subRelationship = new Relationship();
				subRelationship.setName(subOption.getRelationshipName());
				subRelationship.setType(subOption.getType());
				relationship.getChoices().add(subRelationship);
			}
			
			choice.getChoices().add(relationship);
		}
		choice.setSortOrder(part.getRelationships().size());
		part.getRelationships().add(choice);
	}

	private void createStandardAssociation(MessageSet messageSet,
			MessagePart part, Element element) {
		Relationship relationship = new Relationship();
		relationship.setSortOrder(part.getRelationships().size());
		Element targetConnection = MifXPathHelper.getTargetConnection(element);
		relationship.setName(targetConnection.getAttribute("name"));
		
		relationship.setType(determineType(messageSet, targetConnection));
		if (isTemplateParameter(targetConnection)) {
			relationship.setTemplateParameterName(getTemplateParameterName(targetConnection));
		}
		
		relationship.setCardinality(createCardinality(targetConnection));
		relationship.setConformance(createConformance(targetConnection));
		part.getRelationships().add(relationship);
		addDocumentation(targetConnection, relationship);
	}

	private void createAttribute(MessagePart part, Element element) {
		Relationship relationship = new Relationship();
		relationship.setSortOrder(part.getRelationships().size());
		relationship.setName(element.getAttribute("name"));
		relationship.setStructural("true".equals(element.getAttribute("isStructural")));
		relationship.setFixedValue(StringUtils.trimToNull(element.getAttribute("fixedValue")));
		relationship.setType(MifXPathHelper.getAttributeType(element));
		relationship.setLength(element.hasAttribute("maximumLength") 
				? Integer.valueOf(element.getAttribute("maximumLength")) 
				: null);
		
		relationship.setUpdateMode(createUpdateMode(element));
		relationship.setCardinality(createCardinality(element));
		relationship.setConformance(createConformance(element));
		
		if (TypeConverter.isCodedType(relationship.getType()) || TypeConverter.isCodedCollectionType(relationship.getType())) {
			relationship.setDomainType(MifXPathHelper.getDomainType(element));
			relationship.setCodingStrength(MifXPathHelper.getCodingStrength(element));
			relationship.setDomainSource(MifXPathHelper.getDomainSource(element));
		}
		relationship.setConformance(createConformance(element));
		part.getRelationships().add(relationship);
		addDocumentation(element, relationship);
	}

	static String determineType(MessagePartResolver messagePartResolver, Element targetConnection) {
		if (MifXPathHelper.isMifReferenceElementPresent(targetConnection) && !isExternalReference(targetConnection)) {
			String type = MifXPathHelper.getMifReferenceType(targetConnection);
			if (MifXPathHelper.isTypeDefinedInMif(type, targetConnection)) {
				return NameHelper.qualifiyName(targetConnection, type);
			} else {
				throw new MifProcessingException("Cannot resolve internal <mif:reference> to type \"" + type + "\"");
			}
		} else if (MifXPathHelper.isReferenceToOtherModelType(targetConnection)) {
			String generalizationTarget = MifXPathHelper.getGeneralizationTarget(targetConnection);
			return TypeResolver.getExternalType(messagePartResolver, targetConnection,
					generalizationTarget);
		} else if (isParticipantClass(targetConnection)) {
			String unqualifiedName = MifXPathHelper.getParticipantClassName(targetConnection);
			return NameHelper.qualifiyName(targetConnection, unqualifiedName);
		} else if (isTemplateParameter(targetConnection)) {
			return null;
		} else {
			throw new MifProcessingException("Can't determine the type for relationship: " + targetConnection.getAttribute("name") + " " + targetConnection.getAttribute("className") + " " + targetConnection.getAttribute("traversalName"));
		}
	}

	private static boolean isExternalReference(Element targetConnection) {
		return MifXPathHelper.isExternalReferenceType(targetConnection);
	}

	private static boolean isTemplateParameter(Element targetConnection) {
		return MifXPathHelper.getTemplateParameter(targetConnection) != null;
	}

	static boolean isParticipantClass(Element targetConnection) {
		return StringUtils.isNotBlank(MifXPathHelper.getParticipantClassName(targetConnection));
	}

	private boolean isChoice(Element element) {
		return MifXPathHelper.isParticipantClassSpecializationPresent(element);
	}

	private MessagePart createPart(List<MessagePart> result, String qualifier, Element element) {
		Element classElement = MifXPathHelper.getClassElement(element);
		String name = NameHelper.createName(qualifier, classElement.getAttribute("name"));
		if (isAbstract(classElement)) {
			return MessagePart.createAbstractPart(name);
		} else {
			return new MessagePart(name);
		}
	}

	private boolean isAbstract(Element classElement) {
		return "true".equals(classElement.getAttribute("isAbstract"));
	}
}
