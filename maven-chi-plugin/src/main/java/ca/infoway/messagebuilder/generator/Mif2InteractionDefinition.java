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

import static ca.infoway.messagebuilder.generator.Namespaces.HTML_NAMESPACE;
import static ca.infoway.messagebuilder.generator.Namespaces.MIF2_NAMESPACE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
import ca.infoway.messagebuilder.xml.ReceiverResponsibility;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

class Mif2InteractionDefinition implements InteractionDefinition {
	
	private XPathHelper xPath = new XPathHelper();
	private final Document document;
	private final OutputUI outputUI;
	private final MifRegistry registry;
	private final String category;

	Mif2InteractionDefinition(Document document, String category, MifRegistry mifRegistry, OutputUI outputUI) {
		this.document = document;
		this.category = category;
		this.registry = mifRegistry;
		this.outputUI = outputUI;
	}
	
	public static InteractionDefinition create(MifReference mifReference, MifRegistry mifRegistry, OutputUI outputUI) throws GeneratorException, IOException {
		try {
			Document document = new DocumentFactory().createFromFile(mifReference.asFile());
			return new Mif2InteractionDefinition(document, mifReference.getCategory(), mifRegistry, outputUI);
		} catch (SAXException e) {
			throw new GeneratorException(e.getMessage());
		}
	}

	public Interaction extract(MessagePartResolver resolver) throws GeneratorException {
		try {
			Interaction interaction = new Interaction();
			interaction.setDocumentation(new Documentation());
			
			interaction.setCategory(this.category);

			Element packageLocation = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:packageLocation", MIF2_NAMESPACE);
			interaction.setName(EntryPointAssembler.getEntryPoint(packageLocation));
			
			Element triggerEvent = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:invokingTriggerEvent", MIF2_NAMESPACE);
			interaction.setTriggerEvent(EntryPointAssembler.getEntryPoint(triggerEvent));
			
			Element message = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:argumentMessage", MIF2_NAMESPACE);
			interaction.setSuperTypeName(resolveType(interaction, resolver, message));
			
			Element interactionElement = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction", MIF2_NAMESPACE);
			interaction.getDocumentation().setBusinessName(new Mif2XPathHelper().getBusinessName(interactionElement));
			interaction.getDocumentation().setTitle(new Mif2XPathHelper().getTitle(interactionElement));
			List<Annotation> annotations = new Mif2XPathHelper().getDocumentation(interactionElement);
			interaction.getDocumentation().setAnnotations(annotations);
			
			addArguments(interaction, interaction.getArguments(), message, resolver);
			
			NodeList list = this.xPath.getNodes(this.document, "/mif2:interaction/mif2:receiverResponsibilities", MIF2_NAMESPACE);
			for (Element responsibilityNode : NodeListIterator.elementIterable(list)) {
				ReceiverResponsibility responsibility = new ReceiverResponsibility();
				
				Element targetInteraction = (Element) this.xPath.getSingleNode(responsibilityNode, "./mif2:invokeInteraction", MIF2_NAMESPACE);
				responsibility.setInvokeInteraction(EntryPointAssembler.getEntryPoint(targetInteraction));
				
				Element targetTriggerEvent = (Element) this.xPath.getSingleNode(responsibilityNode, "./mif2:invokeTriggerEvent", MIF2_NAMESPACE);
				responsibility.setIncludeTriggerEvent(targetTriggerEvent != null);

				String reasonValue = null;
				Element reasonElement = (Element) this.xPath.getSingleNode(responsibilityNode, "./mif2:reason", MIF2_NAMESPACE);
				Element reasonText = (Element) this.xPath.getSingleNode(reasonElement, "./html:text", HTML_NAMESPACE);
				if (reasonText != null) {
					reasonValue = new Mif2XPathHelper().convertElementToText(reasonText);
				} else if (reasonElement != null) {
					// according to the current schema, the content is a direct child of the reason element. 
					// However, we still need to support the old style with a text element for parsing older published versions of the standard.
					//  -- JR 20130522
					reasonValue = new Mif2XPathHelper().convertElementToText(reasonElement);
				}
				if (reasonValue != null) {
					// The outermost tag of the reason will either be <reason> or <text>. In either case, we should discard it and keep only the filling.
					int headTag = reasonValue.indexOf('>');
					int tailTag = reasonValue.lastIndexOf('<');
					if (headTag < tailTag) {
						reasonValue = reasonValue.substring(headTag+1, tailTag).trim();
						if (reasonValue.length() > 0) {
							responsibility.setReason(reasonValue);
						}
					}
				}
				interaction.addResponsibility(responsibility);
			}
			
			return interaction;
		} catch (XPathExpressionException e) {
			throw new GeneratorException(e.getMessage());
		}
	}

	private String resolveType(Interaction interaction, MessagePartResolver resolver, Element message) {
		return resolveType(interaction, resolver, EntryPointAssembler.getEntryPoint(message));
	}

	private String resolveType(Interaction interaction, MessagePartResolver resolver, String packageName) {
		String type = resolver.getPackageLocationRootType(packageName);
		if (type != null) {
			return type;
		} else {
			MifDependencyException mifDependencyException = new MifDependencyException(interaction, packageName);
			this.outputUI.log(LogLevel.SEVERE, mifDependencyException.getMessage());
			return null;
		}
	}
	
	List<MifChoiceItem> getAllChoices(TypeName currentContext, Element parameterModel, String childElementName, MessagePartResolver resolver) throws XPathExpressionException {

		MessagePart messagePart = resolver.getMessagePart(currentContext.getName());
		NodeList nodes = Mif2XPathHelper.getNodes(parameterModel, "./mif2:" + childElementName);
		
		List<MifChoiceItem> result = new ArrayList<MifChoiceItem>();
		if (messagePart == null) {
			this.outputUI.log(LogLevel.ERROR, "Mif2InteractionDefinition.getAllChoices(): Could not find message part (likely due to an earlier error)");
		} else if (messagePart.getSpecializationChilds().size() == nodes.getLength()) {
			for (int i = 0, length = nodes.getLength(); i < length; i++) {
				TypeName child = new TypeName(messagePart.getSpecializationChilds().get(i).getName());
				
				Element element = (Element) nodes.item(i);
				List<MifChoiceItem> subChoices = getAllChoices(child, element, "choiceItem", resolver); 
				
				result.add(new Mif2ChoiceItem(child, element, subChoices));
			}
		} else {
			outputUI.log(LogLevel.ERROR, "Expecting message part " + currentContext.getName() + " to have " + nodes.getLength() + " specializations, but it had " + messagePart.getSpecializationChilds().size());
		}
		return result;
	}

	private void addArguments(Interaction interaction, List<Argument> arguments, Element element, MessagePartResolver resolver) throws XPathExpressionException {
		NodeList list = this.xPath.getNodes(element, "./mif2:parameterModel", Namespaces.MIF2_NAMESPACE);
		for (Element parameter : NodeListIterator.elementIterable(list)) {
			Argument argument = new Argument();
			argument.setName(resolveType(interaction, resolver, parameter));
			argument.setTraversalName(parameter.getAttribute("traversalName"));
			argument.setTemplateParameterName(parameter.getAttribute("parameterName"));
			arguments.add(argument);
			
			argument.getChoices().addAll(toRelationships(getAllChoices(new TypeName(argument.getName()), parameter, "specialization", resolver)));
			
			addArguments(interaction, argument.getArguments(), parameter, resolver);
		}
	}
	
	private List<Relationship> toRelationships(List<MifChoiceItem> choices) {
		List<Relationship> result = new ArrayList<Relationship>();
		for (MifChoiceItem choice : choices) {
			Relationship relationship = new Relationship();
			relationship.setName(choice.getTraversalName());
			relationship.setType(choice.getClassName());
			result.add(relationship);
			relationship.getChoices().addAll(toRelationships(choice.getChoiceItems()));
		}
		return result;
	}

}
