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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.PnValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

/**
 * PN - Personal Name
 * 
 * Parses a PN element into a PersonName. The element looks like this:
 * 
 * <element-name use="L">
 *   <prefix>Mr.</prefix>
 *   <given>John</given>
 *   <given>Jimmy</given>
 *   <family>Smith</family>
 *   <suffix>Sr.</suffix>
 * </element-name>
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PN
 *
 */
@DataTypeHandler({"PN", "PN.BASIC", "PN.FULL", "PN.SEARCH", "PN.SIMPLE"})
class PnElementParser extends AbstractEntityNameElementParser {

    private static final String NAME_PART_TYPE_QUALIFIER = "qualifier";

    private static final PnValidationUtils PN_VALIDATION_UTILS = new PnValidationUtils();
    
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PNImpl();
	}

	@Override
	protected void validateName(EntityName result, ParseContext context, Element element, Hl7Errors errors) {
		String personNameType = context.getType();
		// some jurisdictions make use of PN, even though it is not strictly defined (allowed?) in the datatype specifications
		if ("PN".equals(personNameType)) {
			String specializationType = getSpecializationType(element);
			if (StringUtils.isNotBlank(specializationType)) {
				personNameType = specializationType;
			}
		}
		PN_VALIDATION_UTILS.validatePersonName((PersonName) result, personNameType, context.getVersion().getBaseVersion(), element, null, errors);
	}
	
    @Override
	protected EntityName parseNode(Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
        PersonName result = new PersonName();
        handlePersonName(xmlToModelResult, result, node.getChildNodes());
        return result;
    }

	private void handlePersonName(XmlToModelResult xmlToModelResult, PersonName result, NodeList childNodes) throws XmlToModelTransformationException {
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			if (childNode instanceof Element) {
				Element element = (Element) childNode;
				String name = NodeUtil.getLocalOrTagName(element);
				String value = getTextValue(element, xmlToModelResult);
				String qualifierString = getAttributeValue(element, NAME_PART_TYPE_QUALIFIER);
				EntityNamePartQualifier qualifier = CodeResolverRegistry.lookup(EntityNamePartQualifier.class, qualifierString);

				if (StringUtils.isNotBlank(value)) {
					result.addNamePart(new EntityNamePart(value, getPersonalNamePartType(name), qualifier));
				}
			//GN: Added in fix similar to what was done for AD.BASIC.  Issue with XML containing mixture of elements and untyped text nodes.
			} else if (isNonBlankTextNode(childNode)) {	
	        	// validation will catch if this type does not allow for a free-form name
				result.addNamePart(new EntityNamePart(childNode.getNodeValue().trim(), null));
			}
		}
	}

	private boolean isNonBlankTextNode(Node childNode) {
		return childNode.getNodeValue() != null 
				&& childNode.getNodeType() == Node.TEXT_NODE 
				&& !StringUtils.isBlank(childNode.getNodeValue());
	}
    
    private String getTextValue(Element element, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	String result = NodeUtil.getTextValue(element, true);
        if (StringUtils.isBlank(result)) {
        	xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
        			"Expected PN child node \"" + element.getNodeName() + "\" to have a text node", element));
        }
        return result;
    }
    
    private NamePartType getPersonalNamePartType(String value) throws XmlToModelTransformationException {
    	return getNamePartType(PersonNamePartType.class, value);
    }

}
