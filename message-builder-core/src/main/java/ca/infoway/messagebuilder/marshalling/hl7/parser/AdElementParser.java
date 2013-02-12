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

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.x_BasicPostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.AdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.CodeUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * AD - Address
 * 
 * Parses a AD element into an Address. The element looks like this:
 * 
 * <addr use='WP'>
 *    <houseNumber>1050</houseNumber>
 *    <direction>W</direction>
 *    <streetName>Wishard Blvd</streetName>,
 *    <additionalLocator>RG 5th floor</additionalLocator>,
 *    <city>Indianapolis</city>, <state>IN</state>
 *    <postalCode>46240</postalCode>
 * </addr>
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 */
@DataTypeHandler({"AD", "AD.BASIC", "AD.FULL", "AD.SEARCH"})
class AdElementParser extends AbstractSingleElementParser<PostalAddress> {

	private static final AdValidationUtils AD_VALIDATION_UTILS = new AdValidationUtils();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ADImpl();
	}
    
    @Override
    protected PostalAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
        PostalAddress result = parseNode(node, xmlToModelResult);
        result.setUses(getNameUses(getAttributeValue(node, "use"), node, xmlToModelResult));
        // FIXME - VALIDATION - TM - missing useablePeriod (only for MR2009 AD.FULL)

        AD_VALIDATION_UTILS.validatePostalAddress(result, context.getType(), context.getVersion(), (Element) node, null, xmlToModelResult);
        
        return result;
    }
    
	private Set<x_BasicPostalAddressUse> getNameUses(String nameUseAttribute, Node node, XmlToModelResult xmlToModelResult) {
        Set<x_BasicPostalAddressUse> uses = new HashSet<x_BasicPostalAddressUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                x_BasicPostalAddressUse postalAddressUse = CodeResolverRegistry.lookup(x_BasicPostalAddressUse.class, token);
                if (postalAddressUse == null) {
                	// error if a use is not found
                	recordError("PostalAddressUse '" + token + "' is not valid", (Element) node, xmlToModelResult);
                } else {
                    uses.add(postalAddressUse);
                }
            }
        }
        return uses;
    }
    
    private PostalAddress parseNode(Node node, XmlToModelResult xmlToModelResult) {
        PostalAddress result = new PostalAddress();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (isNonBlankTextNode(childNode)) {
                String value = childNode.getNodeValue();
                result.addPostalAddressPart(new PostalAddressPart(value));
                
            } else if (childNode instanceof Element) {
                Element element = (Element) childNode;
                
                String name = NodeUtil.getLocalOrTagName(element);
                PostalAddressPartType postalAddressPartType = getPostalAddressPartType(name);
                
                String value = getTextValue(name, element, xmlToModelResult);
                
                String codeAsString = getAttributeValue(childNode, "code");  // only for state/country
                String codeSystem = getAttributeValue(childNode, "codeSystem");  // only for state/country
                Code code = CodeUtil.convertToCode(codeAsString, codeSystem);
                
                if (postalAddressPartType == null) {
                	// error if part type not found
                	recordError("Address part type not valid: " + name, element, xmlToModelResult);
                } else {
					result.addPostalAddressPart(new PostalAddressPart(postalAddressPartType, code, value));
                }
            }
        }
        return result;
    }

	private boolean isNonBlankTextNode(Node childNode) {
		return childNode.getNodeType() == Node.TEXT_NODE && !StringUtils.isBlank(childNode.getNodeValue());
	}
    
    private PostalAddressPartType getPostalAddressPartType(String type) {
    	// don't allow exception (seems like overkill)!
    	try {
    		return getNamePartType(PostalAddressPartType.class, type);
    	} catch (XmlToModelTransformationException e) {
    		return null;
    	}
    }

    private String getTextValue(String name, Element element, XmlToModelResult xmlToModelResult) {
        Node childNode = element.getFirstChild();
        String result = null;
        if (childNode != null) {
        	if (childNode.getNodeType() != Node.TEXT_NODE) {
                recordError("Expected AD child node '" + name  + "' to have a text node", element, xmlToModelResult);
            } else {
            	result = childNode.getNodeValue(); 
            }
        }
        return result; 
    }

	private void recordError(String message, Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
			new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR,
					message + " (" + XmlDescriber.describeSingleElement(element) + ")",
					element)
		);
	}
}
