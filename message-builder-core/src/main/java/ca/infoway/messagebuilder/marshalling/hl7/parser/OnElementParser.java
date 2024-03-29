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

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlNodeListIterable;

/**
 * ON - OrganizationName
 * 
 * Parses an ON element into a OrganizationName. The element looks like this:
 * 
 * <element-name><prefix>prefix</prefix>Intelliware Development<delimiter>,</delimiter><suffix>Inc.</suffix></element-name>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ON
 */
@DataTypeHandler("ON")
class OnElementParser extends AbstractEntityNameElementParser {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ONImpl();
	}
    
    @Override
	protected EntityName parseNode(Node node, XmlToModelResult xmlToModelResult) {
        OrganizationName result = new OrganizationName();
        NodeList childNodes = node.getChildNodes();
        for (Node childNode : new XmlNodeListIterable(childNodes)) {
            if (childNode.getNodeType() == Node.TEXT_NODE) {
                String value = childNode.getNodeValue();
                result.addNamePart(new EntityNamePart(value));
                
            } else if (childNode instanceof Element) {
                Element element = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(element);
                String value = getTextValue(element, xmlToModelResult);
                result.addNamePart(new EntityNamePart(value, getOrganizationNamePartType(name)));
            }
        }
        return result;
    }
    
    private String getTextValue(Element element, Hl7Errors errors) {
        Node childNode = element.getFirstChild();
        if (childNode.getNodeType() != Node.TEXT_NODE) {
        	errors.addHl7Error(new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, "Expected ON child node to have a text node", element));
        }
        return childNode.getNodeValue();
    }
    
    private NamePartType getOrganizationNamePartType(String value) {
    	return getNamePartType(OrganizationNamePartType.class, value);
    }

}
