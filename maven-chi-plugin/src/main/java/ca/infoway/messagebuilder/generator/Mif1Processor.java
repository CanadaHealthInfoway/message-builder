/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.LogLevel.INFO;
import static ca.infoway.messagebuilder.generator.MifXPathHelper.getClassElement;
import static ca.infoway.messagebuilder.generator.MifXPathHelper.getTemplateParameterName;
import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.ImportedPackage;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

class Mif1Processor extends BaseMifProcessorImpl implements MifProcessor {
	
	private static final AttributeComparator ATTRIBUTE_COMPARATOR = new AttributeComparator();
	private static final AssociationComparator ASSOCIATION_COMPARATOR = new AssociationComparator(false);
	
	private DocumentFactory factory = new DocumentFactory();

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
	
	@Override
	protected void addMessagePartsFromMifs(MessageSet messageSet,
			List<MifReference> mifs, StopWatch watch) throws IOException,
			GeneratorException {
		
		List<MifReference> coreMifs = extractCoreMifs(mifs);
		this.outputUI.log(INFO, "MIF pre-processing - processing static model interface packages (" + coreMifs.size() + " files)");
		for (MifReference reference : coreMifs) {
			processCoreMif(reference);
		}
		this.outputUI.log(INFO, "MIF pre-processing - completed (" + renderTime(watch) + ")");
		
		super.addMessagePartsFromMifs(messageSet, mifs, watch);
	}
	
	@Override
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
	
	@Override
	protected Element getEntryPointElement(MifReference reference) throws IOException, GeneratorException {
		return this.helper.getOwnedEntryPointElement(this.mifRegistry.getMif(reference).asDocument());
	}

	@Override
	protected void processRelationships(MessageSet messageSet, Mif mif) {
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(mif.asDocument());
		processRelationships(messageSet, MifXPathHelper.getSpecializedClasses(ownedEntryPoint));
		processRelationships(messageSet, MifXPathHelper.getParticipantClasses(ownedEntryPoint));
	}

	@Override
	protected List<MessagePart> extractMessageParts(MessageSet messageSet, Mif mif) throws GeneratorException, IOException {
		List<MessagePart> result = new ArrayList<MessagePart>();
		Document document = mif.asDocument();
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(document);
		String qualifier = toQualifier(messageSet, mif);
		
		updatePackageLocation(messageSet, qualifier, document);

		processSpecializedClasses(messageSet, result, qualifier, MifXPathHelper.getSpecializedClasses(ownedEntryPoint));
		processSpecializedClasses(messageSet, result, qualifier, MifXPathHelper.getParticipantClasses(ownedEntryPoint));
		
		for (MessagePart messagePart : result) {
			this.outputUI.log(LogLevel.DEBUG, "Adding message part: " + messagePart.getName());
			messageSet.addMessagePart(messagePart);
		}
		
		return result;
	}
	
	private List<MifReference> extractCoreMifs(List<MifReference> mifs) {
		return filterFiles(mifs, "coremif");
	}

	private void processCoreMif(MifReference reference) throws GeneratorException, IOException {
		try {
			Document document = this.factory.createFromFile(reference.asFile());
			if ("commonModelElementPackage".equals(getLocalOrTagName(document.getDocumentElement()))) {
				this.outputUI.log(LogLevel.INFO, "Processing static model information in " + reference.asFile().getName());
				processStaticModel(document);
			}
		} catch (SAXException e) {
			throw new GeneratorException(e);
		}
	}

	private void processStaticModel(Document document) {
		NodeList nodes = BaseMifXPathHelper.getNodes(document.getDocumentElement(), 
				"/mif:commonModelElementPackage/mif:ownedCommonModelElement");
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			Element boundStaticModel = BaseMifXPathHelper.getSingleElement(element, "mif:specializationChildStaticModel");
			Element entryClass = BaseMifXPathHelper.getSingleElement(element, "mif:specializationChildEntryClass");
			
			String boundClassName = EntryPointAssembler.getEntryPoint(boundStaticModel);
			if (entryClass != null) {
				boundClassName += "." + entryClass.getAttribute("name");
			}
			
			CmetDefinition cmetDefinition = new CmetDefinition();
			cmetDefinition.setDefinitionPackage("cmetinfo");
			cmetDefinition.setCmetName(element.getAttribute("name"));
			cmetDefinition.setAttributionLevel(element.getAttribute("attributionLevel"));
			cmetDefinition.setCode(BaseMifXPathHelper.getAttribute(element, "mif:supplierStructuralDomain/@mnemonic"));
			addDocumentationForCmetBinding(element, cmetDefinition);
			cmetDefinition.setBoundClass(boundClassName);
			
			this.outputUI.log(LogLevel.DEBUG, "Alias " + cmetDefinition.getCmetName() + " is associated with " + cmetDefinition.getBoundClass());
			
			this.mifRegistry.registerCmet(cmetDefinition);
		}
	}

	private void processRelationships(MessageSet messageSet, List<Element> specializedClasses) {
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

	private void updatePackageLocation(MessageSet messageSet, String packageName, Document document) {
		PackageLocation packageLocation = messageSet.getPackageLocations().get(packageName);
		packageLocation.setDerivedFromStaticModel(processImportedPackage(MifXPathHelper.getTargetStaticModel(document)));

		List<CmetDefinition> cmetListByPackageName = this.mifRegistry.getCmetByPackageName("cmetinfo", packageName);
		if (cmetListByPackageName != null) {
			for (CmetDefinition cmetDefinition : cmetListByPackageName) {
				CmetBinding cmetBinding = new CmetBinding();
				cmetBinding.setCmetName(cmetDefinition.getCmetName());
				cmetBinding.setAttributionLevel(cmetDefinition.getAttributionLevel());
				cmetBinding.setCode(cmetDefinition.getCode());
				cmetBinding.setCodeSystemOid(cmetDefinition.getCodeSystemOid());
				cmetBinding.setDocumentation(cmetDefinition.getDocumentation());
				
				packageLocation.addCmetBinding(cmetBinding);
			}
		}
	}
	
	private ImportedPackage processImportedPackage(Element packageElement) {
		if (packageElement == null) {
			return null;
		}
		
		ImportedPackage result = new ImportedPackage();
		result.setRoot(packageElement.getAttribute("root"));
		result.setArtifact(packageElement.getAttribute("artifact"));
		result.setVersion(packageElement.getAttribute("version"));
		if (packageElement.hasAttribute("realmNamespace")) {
			result.setRealm(packageElement.getAttribute("realmNamespace"));
		}
		
		return result;
	}

	private String toQualifier(MessageSet messageSet, Mif mif) {
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(mif.asDocument());
		return createPackageLocation(messageSet, ownedEntryPoint);
	}

	private void processSpecializedClasses(MessageSet messageSet, List<MessagePart> result,
			String qualifier, List<Element> specializedClasses) {
		
		for (Element element : specializedClasses) {
			MessagePart part = null;
			Element containedElement = null;
			if (MifXPathHelper.isMifClassPresent(element)) {
				containedElement = MifXPathHelper.getClassElement(element);
				part = createPart(result, qualifier, containedElement);
				processChilds(messageSet, element, part);
			} else if (MifXPathHelper.isTemplateParameterPresent(element)) {
				containedElement = MifXPathHelper.getTemplateParameterElement(element);
				part = createTemplateParameter(result, qualifier, containedElement);
			}
			
			if (part != null) {
				addDocumentation(containedElement, part);
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
				part.getSpecializationChilds().add(new SpecializationChild(NameHelper.qualifiyName(child, name)));
			} else if (isReference(child)) {
				String name = MifXPathHelper.getMifReferenceType(child);
				if (MifXPathHelper.isExternalReferenceType(child)) {
					String externalLocation = MifXPathHelper.getExternalReferenceType(child, name);
					String rootType = messageSet.getPackageLocationRootType(externalLocation);
					part.getSpecializationChilds().add(new SpecializationChild(rootType, name, null));
				} else {
					part.getSpecializationChilds().add(new SpecializationChild(NameHelper.qualifiyName(child, name)));
				}
			} else {
				String packageLocationName = MifXPathHelper.getGeneralizationTarget(child);
				PackageLocation packageLocation = messageSet.getPackageLocations().get(packageLocationName);
				String root = packageLocation == null ? null : packageLocation.getRootType();
				String cmetSymbolicName = MifXPathHelper.getCmetSymbolicName(child);
				String cmetDerivationClassName = MifXPathHelper.getCmetDerivationClassName(child);
				if (StringUtils.isNotBlank(root)) {
					if (StringUtils.isBlank(cmetSymbolicName)) {
						part.getSpecializationChilds().add(new SpecializationChild(root));
					} else {
						part.getSpecializationChilds().add(new SpecializationChild(root, cmetSymbolicName, cmetDerivationClassName));
					}
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
		
		List<Element> sortedAttributes = new ArrayList<Element>();
		List<Element> sortedAssociations = new ArrayList<Element>();
		
		NodeList nodes = getClassElement(specializedClass).getChildNodes();
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			if ("attribute".equals(element.getLocalName())) {
				sortedAttributes.add(element);
			} else if ("association".equals(element.getLocalName())) {
				sortedAssociations.add(element);
			}
		}
		
		Collections.sort(sortedAttributes, ATTRIBUTE_COMPARATOR);
		Collections.sort(sortedAssociations, ASSOCIATION_COMPARATOR);
		
		for (Element element : sortedAttributes) {
			createAttribute(part, element);
		}
		
		for (Element element : sortedAssociations) {
			if (isChoice(element)) {
				createChoice(messageSet, part, element);
			} else {
				createStandardAssociation(messageSet, part, element);
			}
		}
		
	}

	private void createChoice(MessageSet messageSet, MessagePart part, Element element) {
		Element targetConnection = MifXPathHelper.getTargetConnection(element);
		Relationship choice = new Relationship();
		choice.setName(targetConnection.getAttribute("name"));
		
		ChoiceTypeStrategy strategy = ChoiceTypeStrategy.getChoiceTypeStrategy(targetConnection);
		choice.setType(strategy.getHighLevelType(messageSet));
		choice.setCardinality(createCardinality(targetConnection));
		choice.setUpdateMode(createUpdateMode(targetConnection));		
		choice.setConformance(createConformance(targetConnection));
		
		if (MifXPathHelper.isReferenceToOtherModelType(targetConnection)) {
			choice.setCmetBindingName(MifXPathHelper.getCmetSymbolicName(targetConnection));
			choice.setCmetDerivationClassName(MifXPathHelper.getCmetDerivationClassName(targetConnection));
		}
		if (isExternalReference(targetConnection)) {
			choice.setCmetBindingName(MifXPathHelper.getMifReferenceType(targetConnection));
		}
		
		
		Element derivationMetadata = MifXPathHelper.getDerivationMetadata(targetConnection);
		choice.setTraversableDerivationClassName(derivationMetadata.getAttribute("className"));
		choice.setTraversableAssociationName(derivationMetadata.getAttribute("associationEndName"));
		choice.setNontraversableDerivationClassName(MifXPathHelper.getNontraversableDerivationClassName(element));
		choice.setNontraversableAssociationName(MifXPathHelper.getNontraversableAssociationName(element));

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

	private void createStandardAssociation(MessageSet messageSet, MessagePart part, Element element) {
		Element targetConnection = MifXPathHelper.getTargetConnection(element);
		Relationship relationship = new Relationship();
		relationship.setSortOrder(Integer.valueOf(element.getAttribute("sortKey")));
		relationship.setAssociationSortKey(StringUtils.replaceChars(targetConnection.getAttribute("sortKey"), '#', '_'));
		relationship.setName(targetConnection.getAttribute("name"));
		
		relationship.setType(determineType(messageSet, targetConnection));
		if (isTemplateParameter(targetConnection)) {
			relationship.setTemplateParameterName(getTemplateParameterName(targetConnection));
		}
		if (MifXPathHelper.isReferenceToOtherModelType(targetConnection)) {
			relationship.setCmetBindingName(MifXPathHelper.getCmetSymbolicName(targetConnection));
			relationship.setCmetDerivationClassName(MifXPathHelper.getCmetDerivationClassName(targetConnection));
		}
		if (isExternalReference(targetConnection)) {
			relationship.setCmetBindingName(MifXPathHelper.getMifReferenceType(targetConnection));
		}
		
		relationship.setCardinality(createCardinality(targetConnection));
		relationship.setConformance(createConformance(targetConnection));
		part.getRelationships().add(relationship);
		addDocumentation(targetConnection, relationship);
		
		Element derivationMetadata = MifXPathHelper.getDerivationMetadata(targetConnection);
		relationship.setTraversableDerivationClassName(derivationMetadata.getAttribute("className"));
		relationship.setTraversableAssociationName(derivationMetadata.getAttribute("associationEndName"));
		relationship.setNontraversableDerivationClassName(MifXPathHelper.getNontraversableDerivationClassName(element));
		relationship.setNontraversableAssociationName(MifXPathHelper.getNontraversableAssociationName(element));
	}

	private void createAttribute(MessagePart part, Element element) {
		Relationship relationship = new Relationship();
		relationship.setSortOrder(Integer.valueOf(element.getAttribute("sortKey")));
		relationship.setName(element.getAttribute("name"));
		relationship.setStructural("true".equals(element.getAttribute("isStructural")));
		relationship.setFixedValue(StringUtils.trimToNull(element.getAttribute("fixedValue")));
		relationship.setDefaultValue(StringUtils.trimToNull(element.getAttribute("defaultValue")));
		relationship.setType(MifXPathHelper.getAttributeType(element));
		relationship.setLength(element.hasAttribute("maximumLength") 
				? Integer.valueOf(element.getAttribute("maximumLength")) 
				: null);
		
		relationship.setUpdateMode(createUpdateMode(element));
		relationship.setCardinality(createCardinality(element));
		relationship.setConformance(createConformance(element));
		
		if (TypeConverter.isCodedType(relationship.getType()) || TypeConverter.isCodedCollectionType(relationship.getType())) {
			DomainSource domainSource = MifXPathHelper.getDomainSource(element);
			String domainType = MifXPathHelper.getDomainType(element);
			relationship.setDomainSource(domainSource);
			relationship.setDomainType(domainType);
			
			if (DomainSource.VALUE_SET == domainSource) {
				relationship.setCodingStrength(MifXPathHelper.getCodingStrength(element));
			} else if (DomainSource.CONCEPT_DOMAIN == domainSource) {
				relationship.setCodingStrength(MifXPathHelper.getCodingStrength(element));	// In MIF2, we source this from the vocab mif. What's the equivalent rule for MIF1? -- JR 20130430
			} else if (DomainSource.CODE_SYSTEM == domainSource && !relationship.hasFixedValue()) {
				relationship.setNonFixedVocabularyBinding(MifXPathHelper.getAttribute(element, "./mif:vocabulary/mif:code/@code"));
			}
		}
/*

 */
		part.getRelationships().add(relationship);
		addDocumentation(element, relationship);
	}

	private String determineType(MessagePartResolver messagePartResolver, Element targetConnection) {
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

	private boolean isExternalReference(Element targetConnection) {
		return MifXPathHelper.isExternalReferenceType(targetConnection);
	}

	private boolean isChoice(Element element) {
		return MifXPathHelper.isParticipantClassSpecializationPresent(element);
	}

	private boolean isParticipantClass(Element targetConnection) {
		return StringUtils.isNotBlank(MifXPathHelper.getParticipantClassName(targetConnection));
	}

	protected MessagePart createPart(List<MessagePart> result, String qualifier, Element element) {
		String name = NameHelper.createName(qualifier, element.getAttribute("name"));
		MessagePart messagePart;
		if (isAbstract(element)) {
			messagePart = MessagePart.createAbstractPart(name);
		} else {
			messagePart = new MessagePart(name);
		}
		
		Element derivationMetadata = MifXPathHelper.getDerivationMetadata(element);
		if (derivationMetadata != null) {
			messagePart.setDerivedFromClass(derivationMetadata.getAttribute("className"));
		}
		
		addRimClass(element, messagePart);
		return messagePart;
	}
	
	protected MessagePart createTemplateParameter(List<MessagePart> result, String qualifier, Element element) {
		String name = NameHelper.createName(qualifier, element.getAttribute("name"));
		MessagePart messagePart = MessagePart.createTemplateParameter(name);

		Element derivationMetadata = Mif2XPathHelper.getDerivationMetadata(element);
		if (derivationMetadata != null) {
			messagePart.setDerivedFromClass(derivationMetadata.getAttribute("className"));
		}

		addRimClass(element, messagePart);
		return messagePart;
	}
	
	private void addRimClass(Element classElement, MessagePart messagePart) {
		String rimClassName = BaseMifXPathHelper.getAttribute(classElement, "mif:graphicRepresentation/mif:graphElement/@shapeTemplate");
		messagePart.setRimClass(determineRimClass(classElement,	rimClassName));
	}

	private boolean isAbstract(Element classElement) {
		return "true".equals(classElement.getAttribute("isAbstract"));
	}
}
