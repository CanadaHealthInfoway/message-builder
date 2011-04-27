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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.UpdateModeType;

class MifXPathHelper extends BaseMifXPathHelper {
	
	public Element getOwnedEntryPointElement(Document document) {
		Element element = getSingleElement(document.getDocumentElement(), "/mif:serializedStaticModel/mif:ownedEntryPoint");
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
		Element element = getSingleElement(start, "/mif:serializedStaticModel/mif:ownedEntryPoint");
		if (element != null) {
			return element.getAttribute("id");
		} else {
			throw new MifProcessingException("Document does not contain an owned entry point.");
		}
	}
	
	public static Element getClassElement(Element specializedClass) {
		Element element = getSingleElement(specializedClass, "./mif:class");
		if (element != null) {
			return element;
		} else {
			throw new MifProcessingException(specializedClass.getTagName() + " should have had a mif:class as a sub-element");
		}
	}
	
	public static List<Element> getSpecializedClasses(Element ownedEntryPoint) {
		NodeList nodes = getNodes(ownedEntryPoint, ".//mif:specializedClass");
		return toElementList(nodes);
	}

	public static boolean isSpecializedChild(Element specializedClass) {
		Element parent = (Element) specializedClass.getParentNode();
		return "specializationChild".equals(parent.getLocalName());
	}
	
	public List<UpdateModeType> getAllowedUpdateModes(Element element) {
		List<UpdateModeType> updateModeTypes = new ArrayList<UpdateModeType>();
		NodeList nodes = getNodes(element, ".//mif:updateModesAllowed");
		for (int i=0; i<nodes.getLength(); i++) {
			updateModeTypes.add(EnumPattern.valueOf(UpdateModeType.class, nodes.item(i).getNodeValue()));
		}
		return updateModeTypes;
	}	

	List<Annotation> getDocumentation(Element classElement) {
		return getDocumentation(classElement, "./mif:annotations//mif:", "//mif:p/mif:p");
	}
	
	List<Annotation> getDocumentationForInteraction(Element classElement) {
		return getDocumentation(classElement, "./mif:annotations//mif:", "//mif:p");
	}
	
	public static String getSuperTypeName(Element element) {
		return getAttribute(element, "../../@name");
	}

	public static List<Element> getAttributes(Element specializedClass) {
		return toElementList(getNodes(specializedClass, "./mif:class/mif:attribute"));
	}

	public static String getAttributeType(Element attribute) {
		Element element = getSingleElement(attribute, "./mif:type");
		String type = element.getAttribute("name");
		type += getDatatypeArguments(element);
		return type;
	}

	private static String getDatatypeArguments(Element start) {
		StringBuilder builder = new StringBuilder();
		List<Element> elements = toElementList(getNodes(start, "./mif:supplierBindingArgumentDatatype"));
		for (Element element : elements) {
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(element.getAttribute("name"));
			builder.append(getDatatypeArguments(element));
		}
		return builder.length() == 0 ? "" : ("<" + builder.toString() + ">");
	}

	public static String getDomainType(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@codeSystemName");
		if (StringUtils.isBlank(result)) {
			result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@domainName");
		}
		if (StringUtils.isBlank(result)) {
			result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@valueSetName");
		}
		return result;
	}

	public static DomainSource getDomainSource(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@codeSystemName");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.CODE_SYSTEM;
		}
		result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@domainName");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.CONCEPT_DOMAIN;
		}
		result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@valueSetName");
		if (!StringUtils.isBlank(result)) {
			return DomainSource.VALUE_SET;		
		}
		return null;
	}

	public static String getMnemonic(Element mifAttribute) {
		return getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@mnemonic");
	}

	public static CodingStrength getCodingStrength(Element mifAttribute) {
		String result = getAttribute(mifAttribute, "./mif:supplierDomainSpecification/@codingStrength");
		return StringUtils.isBlank(result) ? null : EnumPattern.valueOf(CodingStrength.class, result);
	}
	
	public static List<Element> getParticipantClasses(Element ownedEntryPoint) {
		NodeList nodes = getNodes(ownedEntryPoint, ".//mif:participantClass");
		return toElementList(nodes);
	}

	public static boolean isMifClassPresent(Element element) {
		return null != getSingleElement(element, "./mif:class");
		
	}

	public static boolean isParticipantClassSpecializationPresent(
			Element element) {
		NodeList list =  getNodes(element, "./mif:targetConnection/mif:participantClassSpecialization");
		return list.getLength() > 0;
	}

	public static Element getTargetConnection(Element element) {
		return getSingleElement(element, "./mif:targetConnection");
	}

	public static String getParticipantClassName(Element targetConnection) {
		return getAttribute(targetConnection, "./mif:participantClass/mif:class/@name");
	}

	public String getRootType(Element ownedEntryPoint) {
		return getAttribute(ownedEntryPoint, "./mif:specializedClass/mif:class/@name");
	}
	
	public static boolean isReferenceToOtherModelType(Element targetConnection) {
		if (isMifReferenceElementPresent(targetConnection)) {
			return true; 
		} else if (isTargetConnection(targetConnection)) {
			return null != getSingleElement(targetConnection, "./mif:participantClass/mif:commonModelElementRef");
		} else if (isParticipantClassSpecialization(targetConnection)) {
			String className = targetConnection.getAttribute("className");
			return null != getSingleElement(targetConnection, "../mif:participantClass//mif:commonModelElementRef[@name='" +
					className + "']");
		} else {
			return null != getSingleElement(targetConnection, "./mif:specializedClass/mif:commonModelElementRef");
		}
	}

	public static boolean isParticipantClassSpecialization(Element element) {
		return "participantClassSpecialization".equals(NodeUtil.getLocalOrTagName(element));
	}

	public static boolean isMifReferenceElementPresent(Element targetConnection) {
		if (isTargetConnection(targetConnection)) {
			return null != getSingleElement(targetConnection, "./mif:participantClass/mif:reference");
		} else if ("specializationChild".equals(targetConnection.getLocalName())) {
			return null != getSingleElement(targetConnection, "./mif:specializedClass/mif:reference");
		} else if (isParticipantClassSpecialization(targetConnection)) {
			String className = targetConnection.getAttribute("className");
			return null != getSingleElement(targetConnection, "../mif:participantClass//mif:reference[@name='" +
					className + "']");
		} else {
			throw new MifProcessingException("cannot use this type: " + targetConnection.getLocalName());
		}
	}

	static boolean isTargetConnection(Element targetConnection) {
		return "targetConnection".equals(targetConnection.getLocalName());
	}
	
	public static String getGeneralizationTarget(Element targetConnection) {
		if (isMifReferenceElementPresent(targetConnection)) {
			String reference = getMifReferenceType(targetConnection);
			String referenceType = getExternalReferenceType(targetConnection, reference);
			return StringUtils.isNotBlank(referenceType) ? referenceType : getOwnedEntryPoint(targetConnection); 
		} else if (isTargetConnection(targetConnection)) {
			return getAttribute(targetConnection, "./mif:participantClass/mif:commonModelElementRef/mif:generalizationParent/@name");
		} else if (isParticipantClassSpecialization(targetConnection)) {
			String className = targetConnection.getAttribute("className");
			return getAttribute(targetConnection, "../mif:participantClass//mif:commonModelElementRef[@name='" + className + "']/mif:generalizationParent/@name");
		} else {
			return getAttribute(targetConnection, "./mif:specializedClass/mif:commonModelElementRef/mif:generalizationParent/@name");
		}
	}

	public static boolean isExternalReferenceType(Element targetConnection) {
		if (!isMifReferenceElementPresent(targetConnection)) {
			return false; // TODO: BCH: I think?
		} else {
			String reference = getMifReferenceType(targetConnection);
			return StringUtils.isNotBlank(getExternalReferenceType(targetConnection, reference));
		}
	}
	
	public static String getExternalReferenceType(Element targetConnection,
			String reference) {
		return getAttribute(targetConnection, "//mif:commonModelElementRef[@name='" + reference + "']/mif:generalizationParent/@name");
	}

	public static Element getTemplateParameter(Element targetConnection) {
		return getSingleElement(targetConnection, "./mif:participantClass/mif:templateParameter");
	}

	public static String getMifReferenceType(Element targetConnection) {
		if (isTargetConnection(targetConnection)) {
			return getAttribute(targetConnection, "./mif:participantClass/mif:reference/@name");
		} else if (isParticipantClassSpecialization(targetConnection)) {
			return targetConnection.getAttribute("className");
		} else {
			return getAttribute(targetConnection, "./mif:specializedClass/mif:reference/@name");
		}
	}

	public static boolean isTypeDefinedInMif(String type, Element targetConnection) {
		Element element = getSingleElement(targetConnection, "//mif:class[@name='" + type +"']");
		return element != null;
	}

	String getBusinessName(Element element) {
		return getAttribute(element, "./mif:businessName/@name");
	}

	public static List<Element> getParticipantSpecializations(Element targetConnection) {
		return getParticipantSpecializations(targetConnection, null);
	}

	public static List<Element> getParticipantSpecializations(Element targetConnection, String referenceName) {
		String searchCriteria = StringUtils.isBlank(referenceName) ? "" : "[@className='" + referenceName + "']";
		return toElementList(getNodes(targetConnection, "./mif:participantClassSpecialization" + searchCriteria));
	}

	public static List<Element> getSpecializationChilds(Element element) {
		return toElementList(getNodes(element, "./mif:class/mif:specializationChild"));
	}

	public static Element getChildClassElement(Element element) {
		return getSingleElement(element, "./mif:specializedClass/mif:class");
	}

	public static List<Element> getParticipantClassSpecializationChilds(Element targetConnection) {
		return toElementList(getNodes(targetConnection, "./mif:participantClass/mif:class/mif:specializationChild"));
	}

	public static String getSpecializedClass(Element specializationChild) {
		return getAttribute(specializationChild, "./mif:specializedClass/mif:class/@name");
	}

	public static List<Element> getSubspecializations(Element specialization) {
		return toElementList(getNodes(specialization, "./mif:specialization"));
	}

	public static String getTemplateParameterName(Element targetConnection) {
		return getAttribute(targetConnection, "./mif:participantClass/mif:templateParameter/@name");
	}

	public static boolean isSpecializationChildReference(Element specializationChild) {
		return null != getSingleElement(specializationChild, "./mif:reference");
	}
	
	public static String getExternalReferenceType(Element element, int i) {
		List<Element> specializationChilds = toElementList(getNodes(element, ".//mif:class/mif:specializationChild"));
		if (specializationChilds != null && i < specializationChilds.size()) {
			Element child = specializationChilds.get(i);
			return getAttribute(child, "./mif:specializedClass/mif:commonModelElementRef/mif:generalizationParent/@name");
		} else {
			throw new MifProcessingException("Tried to access specialization child at index " + i + " but only found " + (specializationChilds == null ? 0 : specializationChilds.size()));
		}
	}

}
