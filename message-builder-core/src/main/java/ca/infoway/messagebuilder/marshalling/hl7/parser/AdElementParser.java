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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.x_BasicPostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
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

	private static final int MAX_DELIMITED_LINES = 4;
	private static final int MAX_PART_LENGTH = 80;
	private static final int MAX_USES = 3;

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ADImpl();
	}
    
    @Override
    protected PostalAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
        PostalAddress result = parseNode(node, xmlToModelResult);
        result.setUses(getNameUses(getAttributeValue(node, "use"), node, xmlToModelResult));
        // FIXME - VALIDATION - TM - missing useablePeriod (only for MR2009 AD.FULL)

        validatePostalAddress(context, result, (Element) node, xmlToModelResult);
        
        return result;
    }
    
    private void validatePostalAddress(ParseContext context, PostalAddress postalAddress, Element element, XmlToModelResult xmlToModelResult) {
    	validatePostalAddressUses(context, postalAddress, element, xmlToModelResult);
    	validatePostalAddressParts(context, postalAddress, element, xmlToModelResult);
	}

	private void validatePostalAddressParts(ParseContext context, PostalAddress postalAddress, Element element, XmlToModelResult xmlToModelResult) {
		int countBlankParts = 0;
    	boolean isBasic = StandardDataType.AD_BASIC.getType().equals(context.getType());
    	boolean isSearch = StandardDataType.AD_SEARCH.getType().equals(context.getType());
    	boolean isFull = StandardDataType.AD_FULL.getType().equals(context.getType());
    	
    	Set<PostalAddressPartType> partTypesTracking = new HashSet<PostalAddressPartType>();
    	for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
			int partLength = StringUtils.length(postalAddressPart.getValue());
			if (partLength > MAX_PART_LENGTH) {
				// value max length of 80
    			recordError("Address part types have a maximum allowed length of " + MAX_PART_LENGTH + " (length found: " + partLength + ")", element, xmlToModelResult);
			}

			// error if part type not allowed
	    	PostalAddressPartType partType = postalAddressPart.getType();
			if (partType == null) {
				countBlankParts++;
				// no part type : only allowed for BASIC (max 4, plus max 4 delimiter)
	    		if (!isBasic) {
	    			recordError("Text without an address part only allowed for AD.BASIC", element, xmlToModelResult);
	    		}
			} else if (partType == PostalAddressPartType.DELIMITER) {
	    		if (!isBasic) {
	    			recordError("Part type " + partType.getValue() + " is only allowed for AD.BASIC", element, xmlToModelResult);
	    		}
	    	} else if (isFull) {
	    		if (!PostalAddressPartType.isFullAddressPartType(partType)) {
	    			recordError("Part type " + partType.getValue() + " is not allowed for AD.FULL", element, xmlToModelResult);
	    		}
			} else if (!PostalAddressPartType.isBasicAddressPartType(partType)) {
    			recordError("Part type " + partType.getValue() + " is not allowed for AD.BASIC or AD.SEARCH", element, xmlToModelResult);
			}
	    	
			// code/codesystem are only for state/country
			if (postalAddressPart.getCode() != null) {
				if (partType != PostalAddressPartType.STATE && partType != PostalAddressPartType.COUNTRY) {
	    			recordError("Part type " + partType.getValue() + " is not allowed to specify code or codeSystem", element, xmlToModelResult);
				}
			}
			
	        // only one occurrence of each type allowed except for delimiter (is this correct?); delimiter only for BASIC (max 4)
			if (partType != null && partType != PostalAddressPartType.DELIMITER && !partTypesTracking.add(partType)) {
    			recordError("Part type " + partType.getValue() + " is only allowed to occur once", element, xmlToModelResult);
			}
		}

    	if (isBasic && countBlankParts > MAX_DELIMITED_LINES) {
			recordError("AD.BASIC is only allowed a maximum of " + MAX_DELIMITED_LINES + " delimited-separted address lines (address lines without an address part type)", element, xmlToModelResult);
    	}
    	
    	if (isSearch && CollectionUtils.isEmpty(postalAddress.getParts())) {
			recordError("AD.SEARCH must specify at least one part type", element, xmlToModelResult);
    	}
    	
    	// city/state/postalCode/country mandatory for AD.FULL
    	if (isFull) {
    		validatePartTypeProvided(PostalAddressPartType.CITY, postalAddress.getParts(), element, xmlToModelResult);
    		validatePartTypeProvided(PostalAddressPartType.STATE, postalAddress.getParts(), element, xmlToModelResult);
    		validatePartTypeProvided(PostalAddressPartType.POSTAL_CODE, postalAddress.getParts(), element, xmlToModelResult);
    		validatePartTypeProvided(PostalAddressPartType.COUNTRY, postalAddress.getParts(), element, xmlToModelResult);
    	}
	}

	private void validatePartTypeProvided(PostalAddressPartType partType, List<PostalAddressPart> parts, Element element, XmlToModelResult xmlToModelResult) {
		boolean found = false;
		for (PostalAddressPart postalAddressPart : parts) {
			if (postalAddressPart.getType() == partType) {
				found = true;
				break;
			}
		}
		if (!found) {
			recordError("Part type '" + partType + "' is mandatory for AD.FULL", element, xmlToModelResult);
		}
	}

	private void validatePostalAddressUses(ParseContext context, PostalAddress postalAddress, Element element, XmlToModelResult xmlToModelResult) {
		int numUses = postalAddress.getUses().size();
    	boolean isSearch = StandardDataType.AD_SEARCH.getType().equals(context.getType());
		if (isSearch && numUses > 0) {
    		// error if > 0 and SEARCH
			recordError("PostalAddressUses are not allowed for AD.SEARCH", element, xmlToModelResult);
    	} else {
			if (numUses > MAX_USES) {
				// error if more than 3 uses
				recordError("A maximum of 3 PostalAddressUses are allowed (number found: " + numUses + ")", element, xmlToModelResult);
			}
		}
    	
    	if (SpecificationVersion.isVersion(context.getVersion(), Hl7BaseVersion.CERX)) {
    		// error if CONF/DIR and CeRx
    		for (x_BasicPostalAddressUse postalAddressUse : postalAddress.getUses()) {
				if (X_BasicPostalAddressUse.CONFIDENTIAL.getCodeValue().equals(postalAddressUse.getCodeValue())
						|| X_BasicPostalAddressUse.DIRECT.getCodeValue().equals(postalAddressUse.getCodeValue())) {
					recordError("PostalAddressUses 'CONF' and 'DIR' are not valid for CeRx AD datatypes", element, xmlToModelResult);
				}
			}
    	}
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
