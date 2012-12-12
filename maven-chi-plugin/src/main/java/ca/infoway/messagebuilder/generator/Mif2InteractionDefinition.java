/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.generator.Namespaces.MIF2_NAMESPACE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
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
			
			interaction.setCategory(this.category);

			Element packageLocation = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:packageLocation", MIF2_NAMESPACE);
			interaction.setName(EntryPointAssembler.getEntryPoint(packageLocation));
			
			Element message = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction/mif2:argumentMessage", MIF2_NAMESPACE);
			interaction.setSuperTypeName(resolveType(interaction, resolver, message));
			
			Element interactionElement = (Element) this.xPath.getSingleNode(this.document, "/mif2:interaction", MIF2_NAMESPACE);
			interaction.setBusinessName(new Mif2XPathHelper().getBusinessName(interactionElement));
			List<Annotation> annotations = new Mif2XPathHelper().getDocumentationForInteraction(interactionElement);
			interaction.getDocumentation().setAnnotations(annotations);
			
			addArguments(interaction, interaction.getArguments(), message, resolver);
			
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
		
		if (messagePart == null) {
			this.outputUI.log(LogLevel.ERROR, "Mif2InteractionDefinition.getAllChoices(): Could not find message part (likely due to an earlier error)");
			return Collections.<MifChoiceItem>emptyList();
		} else if (messagePart.getSpecializationChilds().size() == nodes.getLength()) {
			List<MifChoiceItem> result = new ArrayList<MifChoiceItem>();
			for (int i = 0, length = nodes.getLength(); i < length; i++) {
				TypeName child = new TypeName(messagePart.getSpecializationChilds().get(i));
				
				Element element = (Element) nodes.item(i);
				List<MifChoiceItem> subChoices = getAllChoices(child, element, "choiceItem", resolver); 
				
				result.add(new Mif2ChoiceItem(child, element, subChoices));
			}
			return result;
		} else {
			throw new GeneratorException("Expecting message part " + currentContext.getName() + " to have " + nodes.getLength() + " specializations");
		}
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
