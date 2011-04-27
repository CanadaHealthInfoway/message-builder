/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.java.GeneratorInternalException;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

class Mif2Processor extends BaseMifProcessorImpl implements MifProcessor {
	
	private DocumentFactory factory = new DocumentFactory();
	
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
		for (MifReference reference : coreMifs) {
			processCoreMif(reference);
		}
		this.outputUI.log(INFO, "MIF pre-processing - completed (" + renderTime(watch) + ")");
		
		super.addMessagePartsFromMifs(messageSet, mifs, watch);
	}
	
	private void processCoreMif(MifReference reference) throws GeneratorException, IOException {
		try {
			Document document = this.factory.createFromFile(reference.asFile());
			if ("staticModelInterfacePackage".equals(getLocalOrTagName(document.getDocumentElement()))) {
				this.outputUI.log(LogLevel.DEBUG, "Processing static model information in " + reference.asFile().getName());
				processStaticModel(document);
			}
		} catch (SAXException e) {
			throw new GeneratorException(e);
		}
	}

	private void processStaticModel(Document document) {
		NodeList nodes = BaseMifXPathHelper.getNodes(document.getDocumentElement(), 
				"/mif2:staticModelInterfacePackage/mif2:commonModelElementDefinition/mif2:boundStaticModel");
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			Element parent = (Element) element.getParentNode();
			String name = parent.getAttribute("name");
			String entryPoint = EntryPointAssembler.getEntryPoint(element);

			this.outputUI.log(LogLevel.DEBUG, "Alias " + name + " is associated with " + entryPoint);
			this.mifRegistry.addAlias(name, entryPoint);
		}
	}

	private List<MifReference> extractCoreMifs(List<MifReference> mifs) {
		return filterFiles(mifs, "coremif");
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
	
	protected void processRelationships(MessageSet messageSet, Mif mif) throws GeneratorException {
		processAttributes(messageSet, Mif2XPathHelper.getContainedClasses(mif.asDocument()));
		processAssociations(messageSet, Mif2XPathHelper.getAssociations(mif.asDocument()));
	}

	private void processAssociations(MessageSet messageSet, List<Element> associations) throws GeneratorException {
		for (Element association : associations) {
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

	private void processAttributes(MessageSet messageSet, 
			List<Element> containedClasses) {
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

	protected List<MessagePart> extractMessageParts(MessageSet messageSet, Mif mif) throws IOException, GeneratorException {
		List<MessagePart> result = new ArrayList<MessagePart>();
		Element ownedEntryPoint = this.helper.getOwnedEntryPointElement(mif.asDocument());
		String qualifier = createPackageLocation(messageSet, ownedEntryPoint);
		
		processContainedClasses(messageSet, result, qualifier, Mif2XPathHelper.getContainedClasses(ownedEntryPoint.getOwnerDocument()));
		
		for (MessagePart messagePart : result) {
			this.outputUI.log(LogLevel.DEBUG, "Entry point " + qualifier + " contains complex type " + messagePart.getName());
			messageSet.addMessagePart(messagePart);
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
				part.getSpecializationChilds().add(NameHelper.qualifiyName(element, childClassName));
			} else {
				String name = reference.getAttribute("cmetName");
				Mif mif = this.mifRegistry.getMifByName(name);
				if (mif != null) {
					String rootType = messageSet.getPackageLocationRootType(mif.getPackageLocation());
					part.getSpecializationChilds().add(rootType);
					this.outputUI.log(LogLevel.DEBUG, "Complex type " + part.getName() + " has a child class " + rootType);
				} else {
					throw new GeneratorException("Cannot resolve child class cmetName " + name);
				}
			}
		}
	}

	private void addRelationships(MessageSet messageSet, Element specializedClass, MessagePart part) {
		NodeList nodes = Mif2XPathHelper.getClassElement(specializedClass).getChildNodes();
		for (Element element : elementIterable(nodes)) {
			if ("attribute".equals(element.getLocalName())) {
				createAttribute(part, element);
			}
		}
	}

	private void createChoice(MessageSet messageSet, MessagePart part,
			Element element) throws GeneratorException {
		Element targetConnection = Mif2XPathHelper.getTraversableConnection(element);
		Relationship choice = new Relationship();
		choice.setName(targetConnection.getAttribute("name"));
		choice.setCardinality(createCardinality(targetConnection));
		choice.setUpdateMode(createUpdateMode(targetConnection));
		choice.setConformance(createConformance(targetConnection));
		choice.setType(determineType(targetConnection.getAttribute("participantClassName"), messageSet, targetConnection));

		addChoiceItems(messageSet, targetConnection, choice);
		choice.setSortOrder(part.getRelationships().size());
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
			addChoiceItem(messageSet, choice, choiceItem, choiceType);
		}
	}

	private String getSpecializationChild(MessagePart part, int i, MifChoiceItem choiceItem) {
		if (part.getSpecializationChilds().size() > i) {
			return part.getSpecializationChilds().get(i);
		} else {
			throw new GeneratorInternalException("Part type : " + part.getName() 
					+ " should have had a choice type at index " + i 
					+ " corresponding to " + choiceItem.getClassName());
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

	private void createStandardAssociation(MessageSet messageSet,
			MessagePart part, Element element) throws GeneratorException {
		Relationship relationship = new Relationship();
		relationship.setSortOrder(part.getRelationships().size());
		Element targetConnection = Mif2XPathHelper.getTraversableConnection(element);
		relationship.setName(targetConnection.getAttribute("name"));
		
		if (isTemplateParameter(targetConnection)) {
			String parameterName = targetConnection.getAttribute("participantClassName");
			if (StringUtils.isBlank(parameterName)) {
				throw new GeneratorException("Cannot determine the template parameter name for relationship " + part.getName() + "." + relationship.getName());
			} else {
				relationship.setTemplateParameterName(parameterName);
			}
		} else {
			String type = determineType(messageSet, targetConnection);
			if (StringUtils.isBlank(type)) {
				throw new GeneratorException("Cannot determine the type name for relationship " + part.getName() + "." + relationship.getName());
			} else {
				relationship.setType(type);
			}
		}
		
		relationship.setCardinality(createCardinality(targetConnection));
		relationship.setConformance(createConformance(targetConnection));
		relationship.setUpdateMode(createUpdateMode(targetConnection));
		part.getRelationships().add(relationship);
		addDocumentation(targetConnection, relationship);
	}

	private void createAttribute(MessagePart part, Element element) {
		Relationship relationship = new Relationship();
		relationship.setSortOrder(part.getRelationships().size());
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
		if (TypeConverter.isCodedType(relationship.getType()) || TypeConverter.isCodedCollectionType(relationship.getType())) {
			relationship.setDomainType(Mif2XPathHelper.getDomainType(element));
			relationship.setCodingStrength(Mif2XPathHelper.getCodingStrength(element));
			relationship.setDomainSource(Mif2XPathHelper.getDomainSource(element));
		}
		relationship.setConformance(createConformance(element));
		part.getRelationships().add(relationship);
		addDocumentation(element, relationship);
	}

	String determineType(MessageSet messageSet, Element targetConnection) throws GeneratorException {
		String partName = targetConnection.getAttribute("participantClassName");
		return determineType(partName, messageSet, targetConnection);
	}

	private String determineType(String name, MessageSet messageSet,
			Element element) throws GeneratorException {
		if (isInternalReference(messageSet, element, name)) {
			return getPart(messageSet, name, element).getName();
		} else if (isCmetReference(element, name)) {
			Mif mif = this.mifRegistry.getMifByName(name);
			if (mif == null) {
				throw new GeneratorException("Cannot resolve MIF name " + name);
			} else {
				String packageLocation = mif.getPackageLocation();
				return messageSet.getPackageLocationRootType(packageLocation);
			}
		} else if (isTemplateParameter(element)) {
			return null;
		} else if (isChoiceOfExternalCmet(name, element)) {
			return resolveChoiceOfExternalCmet(name, messageSet, element);
		} else {
			throw new MifProcessingException("Can't determine the type: " + name);
		}
	}

	private String resolveChoiceOfExternalCmet(String name, MessageSet messageSet,
			Element choiceItem) throws GeneratorException {
		String externalCmetName = getParentClassName(choiceItem);
		
		Mif externalCmet = this.mifRegistry.getMifByName(externalCmetName);
		if (externalCmet == null) {
			throw new GeneratorException("Cannot resolve mif name \"" + externalCmetName + "\"");
		} else {
			String packageLocation = externalCmet.getPackageLocation();
			MessagePart messagePart = messageSet.getMessagePart(packageLocation);
			
			int index = XmlDescriber.getIndexOf(choiceItem);
			if (index < 1 || index > messagePart.getSpecializationChilds().size()) {
				throw new GeneratorException("Trying to resolve choice " + name + " (#" + index + ") against " + messagePart.getName());
			} else {
				return messagePart.getSpecializationChilds().get(index-1);
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

	private static boolean isTemplateParameter(Element targetConnection) {
		return Mif2XPathHelper.getTemplateParameter(targetConnection) != null;
	}

	static boolean isParticipantClass(Element targetConnection) {
		return StringUtils.isNotBlank(MifXPathHelper.getParticipantClassName(targetConnection));
	}

	private boolean isChoice(Element element) {
		return Mif2XPathHelper.isChoiceItemPresent(element);
	}

	private MessagePart createPart(List<MessagePart> result, String qualifier,
			Element element) {
		Element classElement = Mif2XPathHelper.getClassElement(element);
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
