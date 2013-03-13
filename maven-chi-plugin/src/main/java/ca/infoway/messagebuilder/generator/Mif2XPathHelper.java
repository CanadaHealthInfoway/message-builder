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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.UpdateModeType;

public class Mif2XPathHelper extends BaseMifXPathHelper {
	
	static class ChoiceItemImpl implements MifChoiceItem {

		private final Element choiceItem;
		private final List<MifChoiceItem> subChoices;

		ChoiceItemImpl(Element choiceItem, List<MifChoiceItem> subChoices) {
			this.choiceItem = choiceItem;
			this.subChoices = subChoices;
		}
		public String getClassName() {
			return this.choiceItem.getAttribute("className");
		}
		public String getTraversalName() {
			return this.choiceItem.getAttribute("traversalName");
		}
		public Element getElement() {
			return this.choiceItem;
		}
		public List<MifChoiceItem> getChoiceItems() {
			return this.subChoices;
		}
	}
	
	public Element getOwnedEntryPointElement(Document document) {
		Element element = MifXPathHelper.getSingleElement(document.getDocumentElement(), "/mif2:staticModel/mif2:entryPoint");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException("Document does not contain an owned entry point.");
		}
	}
	
	public String getOwnedEntryPoint(Document document) {
		return getOwnedEntryPoint(document.getDocumentElement());
	}
	
	public static String getOwnedEntryPoint(Element start) {
		Element element = getSingleElement(start, "/mif2:staticModel/mif2:entryPoint");
		if (element != null) {
			return element.getAttribute("id");
		} else {
			throw new MifProcessingException("Document does not contain an owned entry point.");
		}
	}
	
	public static Element getClassElement(Element specializedClass) {
		Element element = getSingleElement(specializedClass, "./mif2:class");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException(specializedClass.getTagName() + " should have had a mif:class as a sub-element");
		}
	}
	
	public static Element getTemplateParameterElement(Element specializedClass) {
		Element element = getSingleElement(specializedClass, "./mif2:templateParameter");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException(specializedClass.getTagName() + " should have had a mif:templateParameter as a sub-element");
		}
	}
	
	public static Element getDerivationMetadata(Element element) {
		return getSingleElement(element, "./mif2:derivedFrom");
	}

	public static List<Element> getContainedClasses(Document document) {
		NodeList nodes = getNodes(document.getDocumentElement(), ".//mif2:containedClass");
		return MifXPathHelper.toElementList(nodes);
	}
	
	public static List<Element> getGraphicRepresentationClasses(Document document) {
		NodeList nodes = getNodes(document.getDocumentElement(), ".//mif2:graphicRepresentation/mif2:class");
		return MifXPathHelper.toElementList(nodes);
	}
	
	public List<UpdateModeType> getAllowedUpdateModes(Element element) {
		List<UpdateModeType> updateModeTypes = new ArrayList<UpdateModeType>();
		NodeList nodes = getNodes(element, ".//mif2:updateModesAllowed");
		for (int i=0; i<nodes.getLength(); i++) {
			updateModeTypes.add(EnumPattern.valueOf(UpdateModeType.class, nodes.item(i).getNodeValue()));
		}
		return updateModeTypes;
	}

	public String getRootType(Element ownedEntryPoint) {
		return ownedEntryPoint.getAttribute("className");
	}

	public static boolean isMifClassPresent(Element element) {
		return null != getSingleElement(element, "./mif2:class");
	}

	public static boolean isTemplateParameterPresent(Element element) {
		return null != getSingleElement(element, "./mif2:templateParameter");
	}
	
	String getBusinessName(Element element) {
		return removeNonAsciiCharacters(getAttribute(element, "./mif2:businessName/@name"));
	}
	
	String getTitle(Element element) {
		return removeNonAsciiCharacters(getAttribute(element, "./@title"));
	}
	
	List<Annotation> getDocumentation(Element classElement) {
		// this leaves text wrapped in <text>
		return getDocumentation(classElement, "./mif2:annotations//mif2:", ".//mif2:text/html:p", ".//mif2:text", ".");
	}

	public static String getAttributeType(Element attribute) {
		Element element = getSingleElement(attribute, "./mif2:type");
		String type = element.getAttribute("name");
		type += getDatatypeArguments(element);
		return type;
	}
	
	private static String getDatatypeArguments(Element start) {
		StringBuilder builder = new StringBuilder();
		List<Element> elements = toElementList(MifXPathHelper.getNodes(start, "./mif2:argumentDatatype"));
		for (Element element : elements) {
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(element.getAttribute("name"));
			builder.append(getDatatypeArguments(element));
		}
		return builder.length() == 0 ? "" : ("<" + builder.toString() + ">");
	}

	public static String getDomainType(Element element) {
		String domain = getAttribute(element, "./mif2:vocabulary/mif2:code/@codeSystemName");
		if (StringUtils.isBlank(domain)) {
			domain = getAttribute(element, "./mif2:vocabulary/mif2:conceptDomain/@name");
		} 
		if (StringUtils.isBlank(domain)) {
			domain = getAttribute(element, "./mif2:vocabulary/mif2:valueSet/@name");
		}
		return domain;
	}

	public static DomainSource getDomainSource(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif2:vocabulary/mif2:code/@codeSystemName");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.CODE_SYSTEM;
		}
		result = getAttribute(mifAttribute, "./mif2:vocabulary/mif2:conceptDomain/@name");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.CONCEPT_DOMAIN;
		}
		result = getAttribute(mifAttribute, "./mif2:vocabulary/mif2:valueSet/@name");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.VALUE_SET;		
		}
		return null;
	}
	
	public static String getMnemonic(Element mifAttribute) {
		return getAttribute(mifAttribute, "./mif2:vocabulary/mif2:code/@mnemonic");
	}

	public static CodingStrength getCodingStrength(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif2:supplierDomainSpecification/@codingStrength");
		if (StringUtils.isBlank(result)) {
			result = getAttribute(mifAttribute, "./mif2:vocabulary/mif2:valueSet/@codingStrength");
		}
		return StringUtils.isBlank(result) ? null : EnumPattern.valueOf(CodingStrength.class, result);
	}

	public static List<Element> getAssociations(Document document) {
		return toElementList(getNodes(
				document.getDocumentElement(), "./mif2:association"));
	}

	public static Element getTraversableConnection(Element association) {
		Element connection = getSingleElement(association, "./mif2:traversableConnection");
		if (connection != null) {
			return connection;
		} else {
			throw new MifProcessingException("No traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}

	public static Element getTraversableConnectionDerivationMetadata(Element association) {
		Element connection = getSingleElement(association, "./mif2:traversableConnection/mif2:derivedFrom");
		if (connection != null) {
			return connection;
		} else {
			throw new MifProcessingException("No non-traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}
	
	public static Element getNonTraversableConnectionDerivationMetadata(Element association) {
		Element connection = getSingleElement(association, "./mif2:nonTraversableConnection/mif2:derivedFrom");
		if (connection != null) {
			return connection;
		} else {
			throw new MifProcessingException("No non-traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}
	
	public static String getNonTraversableConnectionClassName(Element association) {
		String connection = getAttribute(association, "./mif2:nonTraversableConnection/@participantClassName");
		if (StringUtils.isNotBlank(connection)) {
			return connection;
		} else {
			throw new MifProcessingException("No traversable connection element found (" + XmlDescriber.describePath(association) + ")");
		}
	}

	public static boolean isChoiceItemPresent(Element element) {
		return getNodes(element, "./mif2:choiceItem").getLength() > 0;
	}

	public Element getTemplateParameter(Element targetConnection) {
		String name = targetConnection.getAttribute("participantClassName");
		return getSingleElement(targetConnection, "//mif2:containedClass/mif2:templateParameter[@name='" + name + "']");
	}

	public static Element findCmetReference(Element element, String partName) {
		return getSingleElement(element, "/.//mif2:containedClass/mif2:commonModelElementRef[@name='" + partName + "']");
	}

	public static List<MifChoiceItem> getChoiceItems(Element parent) {
		List<Element> temp = toElementList(getNodes(parent, "./mif2:choiceItem"));
		List<MifChoiceItem> result = new ArrayList<MifChoiceItem>();
		for (Element element : temp) {
			List<MifChoiceItem> subChoices = getChoiceItems(element);
			result.add(new ChoiceItemImpl(element, subChoices));
		}
		return result;
	}

	public static List<Element> getSpecializationChilds(Element element) {
		return toElementList(getNodes(element, "./mif2:class/mif2:childClass"));
	}

	public static String getTemplateParameterName(Element targetConnection) {
		return getAttribute(targetConnection, "./mif2:participantClass/mif2:templateParameter/@name");
	}

	public static Element getTargetStaticModel(Document document) {
		return getSingleElement(document.getDocumentElement(), "//mif2:derivedFrom/mif2:targetStaticModel");
	}
	public static Element getDatatypeModel(Document document) {
		return getSingleElement(document.getDocumentElement(), "//mif2:importedDatatypeModelPackage");
	}
	public static Element getVocabularyModel(Document document) {
		return getSingleElement(document.getDocumentElement(), "//mif2:importedVocabularyModelPackage");
	}
	public static Element getCommonModelElementPackage(Document document) {
		return getSingleElement(document.getDocumentElement(), "//mif2:importedCommonModelElementPackage");
	}
	public String determineRimClassForChoiceElement(Element classElement) {
		return getAttribute(classElement, "mif2:derivedFrom/@className");
	}

}
