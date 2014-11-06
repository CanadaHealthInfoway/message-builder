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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * AD - Address (R2)
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
@DataTypeHandler("AD")
class AdR2ElementParser extends AbstractSingleElementParser<PostalAddress> {

	private final TsR2ElementParser tsParser = new TsR2ElementParser();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ADImpl();
	}
    
    @Override
    protected PostalAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
        PostalAddress address = parseAddressPartTypes(node, xmlToModelResult);
        
        Map<Date, SetOperator> useablePeriods = parseUseablePeriods((Element) node, context, xmlToModelResult);
        Set<PostalAddressUse> uses = parseAddressUses(getAttributeValue(node, "use"), node, xmlToModelResult);
        Boolean isNotOrdered = parseIsNotOrdered((Element) node);

		address.getUseablePeriods().putAll(useablePeriods);
		address.setUses(uses);
		address.setIsNotOrdered(isNotOrdered);

        return address;
    }
    
	private Map<Date, SetOperator> parseUseablePeriods(Element node, ParseContext context, XmlToModelResult xmlToModelResult) {
		Map<Date, SetOperator> useablePeriods = new HashMap<Date, SetOperator>();
        NodeList childNodes = node.getChildNodes();
        boolean foundUseablePeriod = false;
        boolean loggedUseablePeriodError = false;
        
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            String childElementName = NodeUtil.getLocalOrTagName(childNode);
            boolean isUseablePeriod = "useablePeriod".equals(childElementName);
            
            if (foundUseablePeriod && !isUseablePeriod && !loggedUseablePeriodError) {
            	loggedUseablePeriodError = true;
            	recordError("Useable periods must come after all address part types.", (Element) node, xmlToModelResult);
            }
            
            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;
                
				if (isUseablePeriod) {
                	foundUseablePeriod = true;
                	ParseContext newContext = ParserContextImpl.create("SXCM<TS>", context);
                	BareANY tsAny = this.tsParser.parse(newContext, childElement, xmlToModelResult);
                	if (tsAny != null && tsAny.getBareValue() != null) {
	                	SetOperator operator = ((ANYMetaData) tsAny).getOperator();
	                	MbDate ts = (MbDate) tsAny.getBareValue();
	                	useablePeriods.put(ts.getValue(), operator);
                	}
                }
            }
        }
        return useablePeriods;
	}

	private Boolean parseIsNotOrdered(Element element) {
		Boolean isNotOrdered = null;
		if (element.hasAttribute("isNotOrdered")) {
			isNotOrdered = Boolean.valueOf(element.getAttribute("isNotOrdered"));
		}
		return isNotOrdered;
	}

	private Set<PostalAddressUse> parseAddressUses(String nameUseAttribute, Node node, XmlToModelResult xmlToModelResult) {
        Set<PostalAddressUse> uses = new HashSet<PostalAddressUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                PostalAddressUse postalAddressUse = CodeResolverRegistry.lookup(PostalAddressUse.class, token);
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
    
    private PostalAddress parseAddressPartTypes(Node node, XmlToModelResult xmlToModelResult) {
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
                if (!"useablePeriod".equals(name)) {
					PostalAddressPartType postalAddressPartType = getPostalAddressPartType(name, element, xmlToModelResult);
	                
	                String value = getTextValue(name, element, xmlToModelResult);
	                
	                if (postalAddressPartType != null) {
						result.addPostalAddressPart(new PostalAddressPart(postalAddressPartType, value));
	                }
                }
            }
        }
        return result;
    }

	private boolean isNonBlankTextNode(Node childNode) {
		return childNode.getNodeType() == Node.TEXT_NODE && !StringUtils.isBlank(childNode.getNodeValue());
	}
    
    private PostalAddressPartType getPostalAddressPartType(String type, Element element, XmlToModelResult xmlToModelResult) {
    	PostalAddressPartType postalAddressPartType = null;
    	try {
    		postalAddressPartType = getNamePartType(PostalAddressPartType.class, type);
            if (postalAddressPartType != null && element.hasAttribute("partType")) {
            	String partTypeCode = element.getAttribute("partType");
            	String correctPartTypeCode = postalAddressPartType.getCodeValue();
				if (!StringUtils.equals(correctPartTypeCode, partTypeCode)) {
					String message = MessageFormat.format("Address partType attribute for element {0} must have a fixed value of {1}", type, correctPartTypeCode);
            		recordError(message, element, xmlToModelResult);
            	}
            }
    	} catch (XmlToModelTransformationException e) {
    		// don't re-throw exception (seems like overkill)!
    	}
    	if (postalAddressPartType == null) {
    		// error if part type not found
    		recordError("Address part type not valid: " + type, element, xmlToModelResult);
    	}
    	return postalAddressPartType;
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
