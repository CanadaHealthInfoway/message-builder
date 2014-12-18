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
 * Last modified: $LastChangedDate: 2014-02-26 13:53:15 -0500 (Wed, 26 Feb 2014) $
 * Revision:      $LastChangedRevision: 8415 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Abstract parser class for all name parsers.
 * @param <V>
 * 
 */
abstract class AbstractNameR2ElementParser<V extends EntityName> extends AbstractSingleElementParser<V> {

	private static final String USE_ATTRIBUTE = "use";
	private static final String VALID_TIME_ELEMENT = "validTime";
	private static final String ORGANIZATION_NAME_TYPE = "ON";
	private static final String QUALIFIER_ATTRIBUTE = "qualifier";
	private static final String NULLFLAVOR_ATTRIBUTE = "nullFlavor";
	
	private final IvlTsR2ElementParser ivlTsParser = new IvlTsR2ElementParser();

	protected abstract V createEntityName(); 
	
	@Override
	protected V parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		// parse parts (including qualifier)
		List<EntityNamePart> parts = parseNameParts(context, node.getChildNodes(), xmlToModelResult);
		
		// parse uses
		Set<EntityNameUse> nameUses = parseNameUses(getAttributeValue(node, USE_ATTRIBUTE), (Element) node, xmlToModelResult);
		
		// parser valid time
		Interval<Date> validTime = parseValidTime((Element) node, context, xmlToModelResult);
		
		V entityName = createEntityName();
		entityName.getParts().addAll(parts);
		entityName.getUses().addAll(nameUses);
		entityName.setValidTime(validTime);
		
		return entityName;
	}
    
	private List<EntityNamePart> parseNameParts(ParseContext context, NodeList childNodes, XmlToModelResult xmlToModelResult) {
		List<EntityNamePart> parts = new ArrayList<EntityNamePart>();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			if (childNode instanceof Element) {
				Element element = (Element) childNode;
				String name = NodeUtil.getLocalOrTagName(element);
				if (!StringUtils.equals(VALID_TIME_ELEMENT, name)) {
					if (StringUtils.equals("TN", context.getType())) {
						recordError("TN fields only support text and a single (optional) validTime element. Found element: " + name, element, xmlToModelResult);
					} else {
						NullFlavor nullFlavor = getNullFlavor(element, xmlToModelResult);
						String value = getTextValue(element, xmlToModelResult);
						EntityNamePartQualifier qualifier = getQualifier(context, element, xmlToModelResult);
						if (StringUtils.isNotBlank(value) || nullFlavor != null) {
							NamePartType namePartType = getNamePartType(name, context.getType(), element, xmlToModelResult);
							if (namePartType != null) {
								parts.add(new EntityNamePart(value, namePartType, qualifier, nullFlavor));
							}
						}
					}
				}
			} else if (isNonBlankTextNode(childNode)) {	
				parts.add(new EntityNamePart(childNode.getNodeValue().trim(), null));
			}
		}
		return parts;
	}

	private NullFlavor getNullFlavor(Element element, XmlToModelResult xmlToModelResult) {
		NullFlavor result = null;
		if (element.hasAttribute(NULLFLAVOR_ATTRIBUTE)) {
			String nullFlavorString = getAttributeValue(element, NULLFLAVOR_ATTRIBUTE);
			if (StringUtils.isNotBlank(nullFlavorString)) {
				NullFlavor nullFlavor = CodeResolverRegistry.lookup(NullFlavor.class, nullFlavorString);
				if (nullFlavor == null) {
					recordError("Invalid nullFlavor detected in name part: " + nullFlavorString, element, xmlToModelResult);
				}
				result = nullFlavor;
			} else {
				recordError("NullFlavor may not be blank.", element, xmlToModelResult);
			}
		}
		return result;
	}

	private EntityNamePartQualifier getQualifier(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		EntityNamePartQualifier result = null;
		if (element.hasAttribute(QUALIFIER_ATTRIBUTE)) {
			String qualifierString = getAttributeValue(element, QUALIFIER_ATTRIBUTE);
			if (StringUtils.isNotBlank(qualifierString)) {
				EntityNamePartQualifier qualifier = CodeResolverRegistry.lookup(EntityNamePartQualifier.class, qualifierString);
				if (qualifier == null) {
					recordError("Invalid qualifier detected in name part: " + qualifierString, element, xmlToModelResult);
				}
				result = qualifier;
				
				if (StringUtils.equals("PN", context.getType()) && StringUtils.equals(ca.infoway.messagebuilder.domainvalue.basic.EntityNamePartQualifier.LEGALSTATUS.getCodeValue(), qualifierString)) {
					recordError("Invalid qualifier for PN name part: " + qualifierString, element, xmlToModelResult);
				}
			} else {
				recordError("Qualifier may not be blank.", element, xmlToModelResult);
			}
		}
		return result;
	}

	private boolean isNonBlankTextNode(Node childNode) {
		return childNode.getNodeValue() != null 
				&& childNode.getNodeType() == Node.TEXT_NODE 
				&& !StringUtils.isBlank(childNode.getNodeValue());
	}
    
    private String getTextValue(Element element, XmlToModelResult xmlToModelResult) {
    	String result = NodeUtil.getTextValue(element, true);
        if (StringUtils.isBlank(result)) {
        	result = null;
        	if (!element.hasAttribute(NULLFLAVOR_ATTRIBUTE)) {
        		recordError("Expected PN child node \"" + element.getNodeName() + "\" to have a text node", element, xmlToModelResult);
        	}
        }
        return result;
    }
    
    private NamePartType getNamePartType(String value, String type, Element element, XmlToModelResult xmlToModelResult) {
    	NamePartType partType = null;
    	try {
    		partType = getNamePartType(StringUtils.equals(ORGANIZATION_NAME_TYPE, type) ? OrganizationNamePartType.class : PersonNamePartType.class, value);
    	} catch(XmlToModelTransformationException e) {
    		recordError(e.getMessage(), element, xmlToModelResult);
    	}
    	return partType;
    }
    
	private Set<EntityNameUse> parseNameUses(String usesString, Element element, XmlToModelResult xmlToModelResult) {
        Set<EntityNameUse> uses = new TreeSet<EntityNameUse>();
        if (StringUtils.isNotBlank(usesString)) {
            StringTokenizer tokenizer = new StringTokenizer(usesString);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                EntityNameUse nameUse = CodeResolverRegistry.lookup(EntityNameUse.class, token);
                if (nameUse != null) {
                    uses.add(nameUse);
                } else {
                	recordError("Name use '" + token + "' not recognized.", element, xmlToModelResult);
                }
            }
        }
        return uses;
    }
	
	private Interval<Date> parseValidTime(Element node, ParseContext context, XmlToModelResult xmlToModelResult) {
		Interval<Date> validTime = null;

		boolean foundValidTime = false;
        boolean loggedValidTimeError = false;
        
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            String childElementName = NodeUtil.getLocalOrTagName(childNode);
            boolean isValidTime = VALID_TIME_ELEMENT.equals(childElementName);
            
            if (!loggedValidTimeError && foundValidTime) {
            	loggedValidTimeError = true;
            	recordError("Only one validTime is allowed, and it must come after all name parts", (Element) node, xmlToModelResult);
            }
            
            if (childNode instanceof Element) {
				if (isValidTime) {
                	foundValidTime = true;
                	ParseContext newContext = ParseContextImpl.create("IVL<TS>", context);
                	BareANY ivlTsAny = this.ivlTsParser.parse(newContext, Arrays.asList(childNode), xmlToModelResult);
                	if (ivlTsAny != null && ivlTsAny.getBareValue() != null) {
                		DateInterval dateInterval = (DateInterval) ivlTsAny.getBareValue();
						validTime = dateInterval == null ? null : dateInterval.getInterval();
                	}
                }
            }
        }
        return validTime;
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
