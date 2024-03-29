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
import static ca.infoway.messagebuilder.util.iterator.NodeListIterator.elementIterable;
import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.MifProcessingException;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifVocabularyModel;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.VocabularyMifMarshaller;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.ImportedPackage;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;

class Mif2Processor extends BaseMifProcessorImpl implements MifProcessor {
	
	private static final AttributeComparator ATTRIBUTE_COMPARATOR = new AttributeComparator();
	private static final AssociationComparator ASSOCIATION_COMPARATOR = new AssociationComparator(true);
	
	private DocumentFactory factory = new DocumentFactory();
	private Mif2VocabularyProcessor vocabularyProcessor = new Mif2VocabularyProcessor();
	private Map<String,String> rimTypeMap = new HashMap<String,String>();
	
	public Mif2Processor(File mifTransform, OutputUI outputUI) throws GeneratorException {
		this(new MifRegistry(mifTransform, outputUI), outputUI);
	}
	
	public Mif2Processor(MifRegistry mifRegistry, OutputUI outputUI) {
		super(mifRegistry, outputUI, new Mif2XPathHelper());
	}

	@Override
	protected void addMessagePartsFromMifs(MessageSet messageSet,
			List<MifReference> mifs, StopWatch watch) throws IOException,
			GeneratorException {
		
		List<MifReference> coreMifs = extractCoreMifs(mifs);
		this.outputUI.log(INFO, "MIF pre-processing - processing static model interface packages (" + coreMifs.size() + " files)");
		List<MifVocabularyModel> vocabularyModels = new ArrayList<MifVocabularyModel>();
		for (MifReference reference : coreMifs) {
			processCoreMif(reference, vocabularyModels);
		}
		vocabularyProcessor.createVocabularyInformation(messageSet, vocabularyModels);
		this.outputUI.log(INFO, "MIF pre-processing - completed (" + renderTime(watch) + ")");
		
		super.addMessagePartsFromMifs(messageSet, mifs, watch);
	}
	
	@Override
	protected List<MifReference> extractInteractionMifs(List<MifReference> mifs) {
		return Lists.newArrayList(Iterables.filter(mifs, new Predicate<MifReference>(){
			public boolean apply(MifReference reference) {
				return "mif".equals(FilenameUtils.getExtension(reference.asFile().getName())) &&
						PackageLocationDeriver.derive(reference.asFile()).isInteraction();
			}
		}));
	}

	@Override
	protected void processInteractions(MessageSet messageSet,
			List<MifReference> interactionMifs) throws GeneratorException, IOException {
		
		for (MifReference mifReference : interactionMifs) {
			Interaction interaction = Mif2InteractionDefinition.create(mifReference, this.mifRegistry, this.outputUI).extract(messageSet);
			messageSet.getInteractions().put(interaction.getName(), interaction);
		}
	}
	
	@Override
	protected Element getEntryPointElement(MifReference reference) throws IOException, GeneratorException {
		return this.helper.getOwnedEntryPointElement(this.mifRegistry.getMif(reference).asDocument());
	}

	@Override
	protected List<MifReference> extractPartMifs(List<MifReference> mifs) {
		return Lists.newArrayList(Iterables.filter(mifs, new Predicate<MifReference>(){
			public boolean apply(MifReference reference) {
				return "mif".equals(FilenameUtils.getExtension(reference.asFile().getName())) &&
						!PackageLocationDeriver.derive(reference.asFile()).isInteraction();
			}
		}));
	}
	
	@Override
	protected void processRelationships(MessageSet messageSet, Mif mif) throws GeneratorException {
		processAttributes(messageSet, Mif2XPathHelper.getContainedClasses(mif.asDocument()));
		processAssociations(messageSet, Mif2XPathHelper.getAssociations(mif.asDocument()));
	}

	@Override
	protected List<MessagePart> extractMessageParts(MessageSet messageSet, Mif mif) throws IOException, GeneratorException {
		List<MessagePart> result = new ArrayList<MessagePart>();
		Document document = mif.asDocument();
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(document);
		String qualifier = createPackageLocation(messageSet, ownedEntryPoint);
		
		updatePackageLocation(messageSet, qualifier, document);
		processContainedClasses(messageSet, result, qualifier, Mif2XPathHelper.getContainedClasses(ownedEntryPoint.getOwnerDocument()));
		
		for (MessagePart messagePart : result) {
			this.outputUI.log(LogLevel.DEBUG, "Entry point " + qualifier + " contains complex type " + messagePart.getName());
			messageSet.addMessagePart(messagePart);
		}
		
		return result;
	}

	private void processCoreMif(MifReference reference, List<MifVocabularyModel> vocabularyModels) throws GeneratorException, IOException {
		try {
			Document document = this.factory.createFromFile(reference.asFile());
			if ("staticModelInterfacePackage".equals(getLocalOrTagName(document.getDocumentElement()))) {
				this.outputUI.log(LogLevel.INFO, "Processing static model information in " + reference.asFile().getName());
				processStaticModel(document);
			} else if ("vocabularyModel".equals(getLocalOrTagName(document.getDocumentElement()))) {
				this.outputUI.log(LogLevel.INFO, "Processing vocabulary information in " + reference.asFile().getName());
				processVocabularyModel(reference.asFile(), vocabularyModels);
			} else if ("staticModel".equals(getLocalOrTagName(document.getDocumentElement()))) {
				this.outputUI.log(LogLevel.INFO, "Processing RIM information in " + reference.asFile().getName());
				processRimModel(document);
			}
		} catch (SAXException e) {
			throw new GeneratorException(e);
		}
	}

	private void processVocabularyModel(File xmlFile, List<MifVocabularyModel> vocabularyModels) throws IOException {
		vocabularyModels.add(new VocabularyMifMarshaller().unmarshallVocabularyModel(xmlFile));
	}

	void processStaticModel(Document document) {
		Element packageLocation = BaseMifXPathHelper.getSingleElement(document.getDocumentElement(), 
				"/mif2:staticModelInterfacePackage/mif2:packageLocation");
		String packageName = processPackageName(packageLocation).toTextRepresentation();
		NodeList nodes = BaseMifXPathHelper.getNodes(document.getDocumentElement(), 
				"/mif2:staticModelInterfacePackage/mif2:commonModelElementDefinition");
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			Element boundStaticModel = Mif2XPathHelper.getSingleElement(element, "mif2:boundStaticModel");
			Element entryClass = Mif2XPathHelper.getSingleElement(element, "mif2:entryClass");
			
			String boundClassName = EntryPointAssembler.getEntryPoint(boundStaticModel);
			if (entryClass != null) {
				boundClassName += "." + entryClass.getAttribute("name");
			}
			
			CmetDefinition cmetDefinition = new CmetDefinition();
			cmetDefinition.setDefinitionPackage(packageName);
			cmetDefinition.setCmetName(element.getAttribute("name"));
			cmetDefinition.setAttributionLevel(element.getAttribute("attributionLevel"));
			cmetDefinition.setCode(BaseMifXPathHelper.getAttribute(element, "mif2:definingVocabulary/mif2:code/@code"));
			cmetDefinition.setCodeSystemOid(BaseMifXPathHelper.getAttribute(element, "mif2:definingVocabulary/mif2:code/@codeSystem"));
			addDocumentationForCmetBinding(element, cmetDefinition);
			cmetDefinition.setBoundClass(boundClassName);
			
			this.outputUI.log(LogLevel.DEBUG, "Alias " + cmetDefinition.getCmetName() + " is associated with " + cmetDefinition.getBoundClass());
			
			this.mifRegistry.registerCmet(cmetDefinition);
		}
	}
	
	private void processRimModel(Document document) {
		registerRimTypes(document, "Act");
		registerRimTypes(document, "Entity");
		registerRimTypes(document, "Role");
	}

	private void registerRimTypes(Document document, String rootType) {
		registerRimTypes(document, rootType, rootType);
	}
	
	private void registerRimTypes(Document document, String rootType, String type) {
		NodeList types = BaseMifXPathHelper.getNodes(document.getDocumentElement(),
				"/mif2:staticModel/mif2:containedClass/mif2:class[@name=\"" + type + "\"]/mif2:childClass");
		for (Element element : NodeListIterator.elementIterable(types)) {
			String childClassName = element.getAttribute("name");
			rimTypeMap.put(childClassName, rootType);
			registerRimTypes(document, rootType, childClassName);
		}
	}

	private List<MifReference> extractCoreMifs(List<MifReference> mifs) {
		return filterFiles(mifs, "coremif");
	}

	private void processAssociations(MessageSet messageSet, List<Element> associations) throws GeneratorException {
		
		List<Element> sortedAssociations = new ArrayList<Element>(associations);
		Collections.sort(sortedAssociations, ASSOCIATION_COMPARATOR);
		
		for (Element association : sortedAssociations) {
			Element traversableConnection = Mif2XPathHelper.getTraversableConnection(association);
			String partName = Mif2XPathHelper.getNonTraversableConnectionClassName(association);
			MessagePart part = getPart(messageSet, partName, association);

			if (isChoice(traversableConnection)) {
				createChoice(messageSet, part, association);
			} else {
				createStandardAssociation(messageSet, part, association);
			}
		}		
	}

	private MessagePart getPart(MessageSet messageSet, String partName, Element element) {
		String qualifiedName = NameHelper.createName(new Mif2XPathHelper().getOwnedEntryPoint(element.getOwnerDocument()), partName);
		return messageSet.getMessagePart(qualifiedName);
	}

	private void processAttributes(MessageSet messageSet, List<Element> containedClasses) {
		for (Element element : containedClasses) {
			if (Mif2XPathHelper.isMifClassPresent(element)) {
				Element classElement = Mif2XPathHelper.getClassElement(element);
				String name = NameHelper.qualifiyName(
						element, 
						classElement.getAttribute("name"));
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
		
		packageLocation.setDerivedFromStaticModel(processPackageName(Mif2XPathHelper.getTargetStaticModel(document)));
		packageLocation.setDatatypeModel(processPackageName(Mif2XPathHelper.getDatatypeModel(document)));
		packageLocation.setVocabularyModel(processPackageName(Mif2XPathHelper.getVocabularyModel(document)));
		ImportedPackage cmetDefiningPackage = processPackageName(Mif2XPathHelper.getCommonModelElementPackage(document));
		packageLocation.setCommonModelElement(cmetDefiningPackage);
		
		List<CmetDefinition> cmetListByPackageName = this.mifRegistry.getCmetByPackageName(cmetDefiningPackage.toTextRepresentation(), packageName);
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

	private ImportedPackage processPackageName(Element packageElement) {
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

	private void processContainedClasses(MessageSet messageSet, List<MessagePart> result,
			String qualifier, List<Element> containedClasses) throws GeneratorException {
		
		for (Element element : containedClasses) {
			if (Mif2XPathHelper.isMifClassPresent(element)) {
				MessagePart part = createPart(result, qualifier, element);
				addDocumentation(Mif2XPathHelper.getClassElement(element), part);
				processChilds(messageSet, element, part);
				result.add(part);
			} else if (Mif2XPathHelper.isTemplateParameterPresent(element)) {
				result.add(createTemplateParameter(qualifier, element));
			}
		}
	}

	private void processChilds(MessageSet messageSet, Element element, MessagePart part) throws GeneratorException {
		List<Element> children = Mif2XPathHelper.getSpecializationChilds(element);
		for (Element child : children) {
			String childClassName = child.getAttribute("name");

			// two situations: either the child type is defined internally, or its defined in another CMET
			
			Element reference = Mif2XPathHelper.findCmetReference(element, childClassName);
			if (reference == null) {
				// BCH: assume that it's internal
				this.outputUI.log(LogLevel.DEBUG, "Complex type " + part.getName() + " has a child class " + childClassName);
				part.getSpecializationChilds().add(new SpecializationChild(NameHelper.qualifiyName(element, childClassName)));
			} else {
				PackageLocation parentPackage = messageSet.getPackageLocation(TypeName.determineRootName(part.getName()));
				String name = reference.getAttribute("cmetName");
				CmetDefinition cmetDefinition = this.mifRegistry.getCmetByAlias(parentPackage.getCommonModelElement().toTextRepresentation(), name);
				if (cmetDefinition != null) {
					Element cmetReference = Mif2XPathHelper.findCmetReference(child, name);
					part.getSpecializationChilds().add(new SpecializationChild(cmetDefinition.getBoundClass(), cmetDefinition.getCmetName(), Mif2XPathHelper.getAttribute(cmetReference, "./mif2:derivedFrom/@className")));
					this.outputUI.log(LogLevel.DEBUG, "Complex type " + part.getName() + " has a child class " + cmetDefinition.getBoundClass());
				} else {
					this.outputUI.log(LogLevel.SEVERE, part.getName() + ": Cannot resolve child class cmetName " + name);
//					throw new GeneratorException("Cannot resolve child class cmetName " + name);
				}
			}
		}
	}

	private void addRelationships(MessageSet messageSet, Element specializedClass, MessagePart part) {
		NodeList nodes = Mif2XPathHelper.getClassElement(specializedClass).getChildNodes();
		
		List<Element> sortedAttributes = new ArrayList<Element>();
		
		for (Element element : elementIterable(nodes)) {
			if ("attribute".equals(element.getLocalName())) {
				sortedAttributes.add(element);
			}
		}
		
		Collections.sort(sortedAttributes, ATTRIBUTE_COMPARATOR);

		for (Element element : sortedAttributes) {
			createAttribute(part, element);
		}
	}

	private void createChoice(MessageSet messageSet, MessagePart part, Element element) throws GeneratorException {
		PackageLocation packageLocation = messageSet.getPackageLocation(TypeName.determineRootName(part.getName()));
		Element targetConnection = Mif2XPathHelper.getTraversableConnection(element);
		Element targetConnectionDerivation = Mif2XPathHelper.getTraversableConnectionDerivationMetadata(element);
		Element reverseConnectionDerivation = Mif2XPathHelper.getNonTraversableConnectionDerivationMetadata(element);
		
		Relationship choice = new Relationship();
		choice.setName(targetConnection.getAttribute("name"));
		choice.setCardinality(createCardinality(targetConnection));
		choice.setUpdateMode(createUpdateMode(targetConnection));
		choice.setConformance(createConformance(targetConnection));
		choice.setType(determineType(packageLocation.getCommonModelElement().toTextRepresentation(), targetConnection.getAttribute("participantClassName"), messageSet, targetConnection));
		choice.setAssociationSortKey(targetConnection.getAttribute("sortKey"));
		choice.setTraversableDerivationClassName(targetConnectionDerivation.getAttribute("className"));
		choice.setTraversableAssociationName(targetConnectionDerivation.getAttribute("associationEndName"));
		choice.setNontraversableDerivationClassName(reverseConnectionDerivation.getAttribute("className"));
		choice.setNontraversableAssociationName(reverseConnectionDerivation.getAttribute("associationEndName"));

		String partName = targetConnection.getAttribute("participantClassName");
		Element cmetReference = Mif2XPathHelper.findCmetReference(targetConnection, partName);
		if (cmetReference != null) {
			choice.setCmetBindingName(partName);
			choice.setCmetDerivationClassName(Mif2XPathHelper.getAttribute(cmetReference, "./mif2:derivedFrom/@className"));
		}

		addChoiceItems(messageSet, targetConnection, choice);
		choice.setSortOrder(Integer.valueOf(element.getAttribute("sortKey")));
		part.getRelationships().add(choice);
	}

	private void addChoiceItems(MessageSet messageSet, Element targetConnection, Relationship choice) throws GeneratorException {
		addChoiceItems(messageSet, choice, Mif2XPathHelper.getChoiceItems(targetConnection));
	}

	private void addChoiceItems(MessageSet messageSet, 
			Relationship choice, List<MifChoiceItem> choices) {
		String parentType = choice.getType();
		MessagePart part = messageSet.getMessagePart(parentType);
		int i = 0;
		for (MifChoiceItem choiceItem : choices) {
			String choiceType = getSpecializationChild(part, i++, choiceItem);
			if (choiceType != null) {
				addChoiceItem(messageSet, choice, choiceItem, choiceType);
			}
		}
	}

	private String getSpecializationChild(MessagePart part, int i, MifChoiceItem choiceItem) {
		if (part.getSpecializationChilds().size() > i) {
			return part.getSpecializationChilds().get(i).getName();
		} else {
			this.outputUI.log(LogLevel.ERROR, "Part type : " + part.getName() 
					+ " should have had a choice type at index " + i 
					+ " corresponding to " + choiceItem.getClassName());
			return null;
		}
	}

	private void addChoiceItem(MessageSet messageSet, 
			Relationship choice, MifChoiceItem choiceItem, String choiceType) {
		
		Relationship relationship = new Relationship();
		relationship.setName(choiceItem.getTraversalName());
		try {
			relationship.setType(choiceType);
			addChoiceItems(messageSet, relationship, choiceItem.getChoiceItems());
			choice.getChoices().add(relationship);
		} catch (MifProcessingException e) {
			this.outputUI.log(LogLevel.ERROR, e.getMessage());
		}
	}

	private void createStandardAssociation(MessageSet messageSet, MessagePart part, Element element) {
		PackageLocation packageLocation = messageSet.getPackageLocation(TypeName.determineRootName(part.getName()));
		Element targetConnection = Mif2XPathHelper.getTraversableConnection(element);
		Element targetConnectionDerivation = Mif2XPathHelper.getTraversableConnectionDerivationMetadata(element);
		Element reverseConnectionDerivation = Mif2XPathHelper.getNonTraversableConnectionDerivationMetadata(element);

		Relationship relationship = new Relationship();
		relationship.setSortOrder(Integer.valueOf(element.getAttribute("sortKey")));
		relationship.setName(targetConnection.getAttribute("name"));
		
		if (isTemplateParameter(targetConnection)) {
			String parameterName = targetConnection.getAttribute("participantClassName");
			if (StringUtils.isBlank(parameterName)) {
				this.outputUI.log(LogLevel.ERROR, "Cannot determine the template parameter name for relationship " + part.getName() + "." + relationship.getName());
//				throw new GeneratorException("Cannot determine the template parameter name for relationship " + part.getName() + "." + relationship.getName());
			} else {
				relationship.setTemplateParameterName(parameterName);
			}
		} else {
			String type = determineType(packageLocation.getCommonModelElement().toTextRepresentation(), messageSet, targetConnection);
			if (StringUtils.isBlank(type)) {
				this.outputUI.log(LogLevel.ERROR, "Cannot determine the type name for relationship " + part.getName() + "." + relationship.getName());
//				throw new GeneratorException("Cannot determine the type name for relationship " + part.getName() + "." + relationship.getName());
			} else {
				relationship.setType(type);
			}
			
			String partName = targetConnection.getAttribute("participantClassName");
			Element cmetReference = Mif2XPathHelper.findCmetReference(targetConnection, partName);
			if (cmetReference != null) {
				relationship.setCmetBindingName(partName);
				relationship.setCmetDerivationClassName(Mif2XPathHelper.getAttribute(cmetReference, "./mif2:derivedFrom/@className"));
			}
		}
		
		relationship.setCardinality(createCardinality(targetConnection));
		relationship.setConformance(createConformance(targetConnection));
		relationship.setUpdateMode(createUpdateMode(targetConnection));
		relationship.setAssociationSortKey(targetConnection.getAttribute("sortKey"));
		relationship.setTraversableDerivationClassName(targetConnectionDerivation.getAttribute("className"));
		relationship.setTraversableAssociationName(targetConnectionDerivation.getAttribute("associationEndName"));
		relationship.setNontraversableDerivationClassName(reverseConnectionDerivation.getAttribute("className"));
		relationship.setNontraversableAssociationName(reverseConnectionDerivation.getAttribute("associationEndName"));
		part.getRelationships().add(relationship);
		addDocumentation(targetConnection, relationship);
	}

	private void createAttribute(MessagePart part, Element element) {
		Relationship relationship = new Relationship();
		relationship.setAttribute(true);
		relationship.setSortOrder(Integer.valueOf(element.getAttribute("sortKey")));
		relationship.setName(element.getAttribute("name"));
		relationship.setStructural("true".equals(element.getAttribute("isImmutable")));
		relationship.setFixedValue(StringUtils.trimToNull(element.getAttribute("fixedValue")));
		relationship.setDefaultValue(StringUtils.trimToNull(element.getAttribute("defaultValue")));
		relationship.setType(Mif2XPathHelper.getAttributeType(element));
		relationship.setLength(element.hasAttribute("maximumLength") 
				? Integer.valueOf(element.getAttribute("maximumLength")) 
				: null);
		relationship.setUpdateMode(createUpdateMode(element));	
		relationship.setCardinality(createCardinality(element));
		relationship.setConformance(createConformance(element));

		// It turns out that some non-coded attributes have domain bindings as well. Don't know why, but we have to preserve it if it's present
		DomainSource domainSource = Mif2XPathHelper.getDomainSource(element);
		String domainType = Mif2XPathHelper.getDomainType(element);
		relationship.setDomainSource(domainSource);
		relationship.setDomainType(domainType);
		
		if (DomainSource.VALUE_SET == domainSource) {
			relationship.setCodingStrength(Mif2XPathHelper.getCodingStrength(element));
		} else if (DomainSource.CONCEPT_DOMAIN == domainSource) {
			String codingStrength = this.vocabularyProcessor.getCodingStrengthForDomain(domainType);
			relationship.setCodingStrength(StringUtils.isBlank(codingStrength) ? null : EnumPattern.valueOf(CodingStrength.class, codingStrength));
		} else if (DomainSource.CODE_SYSTEM == domainSource && !relationship.hasFixedValue()) {
			relationship.setNonFixedVocabularyBinding(Mif2XPathHelper.getAttribute(element, "./mif2:vocabulary/mif2:code/@code"));
		}

		part.getRelationships().add(relationship);
		addDocumentation(element, relationship);
	}

	private String determineType(String definingPackage, MessageSet messageSet, Element targetConnection) throws GeneratorException {
		String partName = targetConnection.getAttribute("participantClassName");
		return determineType(definingPackage, partName, messageSet, targetConnection);
	}

	private String determineType(String definingPackage, String name, MessageSet messageSet, Element element) {
		if (isInternalReference(messageSet, element, name)) {
			return getPart(messageSet, name, element).getName();
		} else if (isCmetReference(element, name)) {
			CmetDefinition cmetDefinition = this.mifRegistry.getCmetByAlias(definingPackage, name);
			if (cmetDefinition == null) {
				this.outputUI.log(LogLevel.ERROR, "Cannot resolve MIF name " + name + " (check coremif files for possible missing MIF file)");
				return null;
//				throw new GeneratorException("Cannot resolve MIF name " + name);
			} else {
				return cmetDefinition.getBoundClass();
			}
		} else if (isTemplateParameter(element)) {
			return null;
		} else if (isChoiceOfExternalCmet(name, element)) {
			return resolveChoiceOfExternalCmet(definingPackage, name, messageSet, element);
		} else {
			throw new MifProcessingException("Can't determine the type: " + name);
		}
	}

	private String resolveChoiceOfExternalCmet(String definingPackage, String name, MessageSet messageSet,
			Element choiceItem) throws GeneratorException {
		String externalCmetName = getParentClassName(choiceItem);
		
		CmetDefinition cmetDefinition = this.mifRegistry.getCmetByAlias(definingPackage, externalCmetName);
		if (cmetDefinition == null) {
			throw new GeneratorException("Cannot resolve mif name \"" + externalCmetName + "\"");
		} else {
			MessagePart messagePart = messageSet.getMessagePart(cmetDefinition.getBoundClass());
			
			int index = XmlDescriber.getIndexOf(choiceItem);
			if (index < 1 || index > messagePart.getSpecializationChilds().size()) {
				throw new GeneratorException("Trying to resolve choice " + name + " (#" + index + ") against " + messagePart.getName());
			} else {
				return messagePart.getSpecializationChilds().get(index-1).getName();
			}
		}
	}

	private String getParentClassName(Element element) throws GeneratorException {
		Element parent = (Element) element.getParentNode();
		String parentTagName = getLocalOrTagName(parent);
		if ("traversableConnection".equals(parentTagName)) {
			return parent.getAttribute("participantClassName");
		} else if ("choiceItem".equals(parentTagName)) {
			return parent.getAttribute("className");
		} else {
			throw new GeneratorException("The specified element is not valid");
		}
	}

	/**
	 * <p>Either, the parent is a traversableConnection that references an external class,
	 * or the parent is, itself, a choiceItem that references an external class.
	 * @param name
	 * @param element
	 * @return
	 */
	private boolean isChoiceOfExternalCmet(String name, Element element) {
		Element parent = (Element) element.getParentNode();
		String parentTagName = getLocalOrTagName(parent);
		if ("traversableConnection".equals(parentTagName)) {
			String externalCmetName = parent.getAttribute("participantClassName");
			return isCmetReference(element, externalCmetName);
		} else if ("choiceItem".equals(parentTagName)) {
			String externalCmetName = parent.getAttribute("className");
			return isCmetReference(element, externalCmetName);
		} else {
			return false;
		}
	}

	private boolean isCmetReference(Element targetConnection, String partName) {
		return Mif2XPathHelper.findCmetReference(targetConnection, partName) != null;
	}

	private boolean isInternalReference(MessageSet messageSet, Element targetConnection, String partName) {
		return getPart(messageSet, partName, targetConnection) != null;
	}

	private boolean isChoice(Element element) {
		return Mif2XPathHelper.isChoiceItemPresent(element);
	}

	private MessagePart createPart(List<MessagePart> result, String qualifier,
			Element element) {
		Element classElement = Mif2XPathHelper.getClassElement(element);
		String name = NameHelper.createName(qualifier, classElement.getAttribute("name"));
		
		MessagePart msgPart = null;
		if (isAbstract(classElement)) {
			msgPart = MessagePart.createAbstractPart(name);
		} else {
			msgPart = new MessagePart(name);
		}
		
		Element derivationMetadata = Mif2XPathHelper.getDerivationMetadata(classElement);
		if (derivationMetadata != null) {
			String derivedClassName = derivationMetadata.getAttribute("className");
			msgPart.setDerivedFromClass(derivedClassName);
			addRimClass(derivedClassName, msgPart);
		}
		
		return msgPart;
	}

	private MessagePart createTemplateParameter(String qualifier,
			Element element) {
		Element templateParameterElement = Mif2XPathHelper.getTemplateParameterElement(element);
		String name = NameHelper.createName(qualifier, templateParameterElement.getAttribute("name"));
		
		MessagePart msgPart = MessagePart.createTemplateParameter(name);
		
		Element derivationMetadata = Mif2XPathHelper.getDerivationMetadata(templateParameterElement);
		if (derivationMetadata != null) {
			String derivedClassName = derivationMetadata.getAttribute("className");
			msgPart.setDerivedFromClass(derivedClassName);
			addRimClass(derivedClassName, msgPart);
		}

		addDocumentation(templateParameterElement, msgPart);
		return msgPart;
	}
	
	private void addRimClass(String derivedClassName, MessagePart msgPart) {
		try {
			msgPart.setRimClass(getRimClassFromCode(derivedClassName));
		} catch (IllegalArgumentException e) {
			if (this.rimTypeMap.containsKey(derivedClassName)) {
				msgPart.setRimClass(getRimClassFromCode(this.rimTypeMap.get(derivedClassName)));
			} else {
				msgPart.setRimClass(RimClass.OTHER_CLASS);
			}
		}
	}

	private boolean isAbstract(Element classElement) {
		return "true".equals(classElement.getAttribute("isAbstract"));
	}
}
