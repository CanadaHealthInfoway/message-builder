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

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public abstract class AbstractSingleElementParser<V> extends AbstractElementParser {
	
	private final Log log = LogFactory.getLog(getClass());

    protected static final String EMPTY_STRING = "";
    
    protected abstract BareANY doCreateDataTypeInstance(String typeName);

    @Override
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
        if (nodes == null || nodes.size() == 0) {
            return null;
        } else if (nodes.size() == 1) {
            return parse(context, nodes.get(0), xmlToModelResult);
        } else {
            throw new XmlToModelTransformationException("Expected a single element and found " + nodes.size());
        }
    }

    public BareANY parse(ParseContext context, Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	BareANY result = createDataTypeInstance(context != null ? getType(context) : null);
        
        if (hasValidNullFlavorAttribute(context, node, xmlToModelResult)) {
            NullFlavor nullFlavor = parseNullNode(context, node, xmlToModelResult);
            result.setNullFlavor(nullFlavor);
        } else {
            V value = parseNonNullNode(context, node, result, getReturnType(context), xmlToModelResult);
            ((BareANYImpl) result).setBareValue(value);
        }
        return result;
    }

	protected abstract V parseNonNullNode(ParseContext context, Node node, BareANY result, Type returnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException;

	private BareANY createDataTypeInstance(String typeName) {
		BareANY dataTypeInstance = doCreateDataTypeInstance(typeName);
		setDataType(typeName, dataTypeInstance);
		return dataTypeInstance;
	}

	protected void setDataType(String dataTypeName, BareANY dataTypeInstance) {
		if (dataTypeName!=null) {
			StandardDataType dataType = StandardDataType.getByTypeName(dataTypeName);
			if (dataType != null) {
				dataTypeInstance.setDataType(dataType);
			} else {
				this.log.error("missing data type! " + dataTypeName);
			}
		}
	}

	protected boolean hasValidNullFlavorAttribute(ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		return new NullFlavorHelper(
				context!=null ? context.getConformance() : null, 
				node, 
				xmlToModelResult,
				false).hasValidNullFlavorAttribute();
	}

	protected NullFlavor parseNullNode(ParseContext context, Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		return new NullFlavorHelper(
				context!=null ? context.getConformance() : null, 
				node, 
				xmlToModelResult,
				false).parseNullNode();
    }

    protected Node getNamedChildNode(Node node, String childNodeName) {
        Node result = null;
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength() && result == null; i++) {
            Node childNode = childNodes.item(i);
            if (childNodeName.equals(NodeUtil.getLocalOrTagName(childNode))) {
                result = childNode;
            }
        }
        return result;
    }

    protected String getMandatoryAttributeValue(Node node, String attributeName, XmlToModelResult parsingResult) 
    		throws XmlToModelTransformationException {
        String result = getAttributeValue(node, attributeName);
        if (StringUtils.isBlank(result)) {
        	parsingResult.addHl7Error(
        			new Hl7Error(DATA_TYPE_ERROR, 
        						 "Attribute " + attributeName + " is mandatory for node " + XmlDescriber.describePath(node) + " (" + XmlDescriber.describeSingleElement((Element) node) + ")",
        						 (Element) node)
        	);
        }
        return result;
    }

	protected <S extends NamePartType> S getNamePartType(Class<S> type, String value) throws XmlToModelTransformationException {
		for (S partType : EnumPattern.<S>values(type)) {
			if (partType.getValue().equals(value)) {
				return partType;
			}
		}
	    throw new XmlToModelTransformationException("Unexpected part of type: " + value);
	}

	protected void validateUnallowedAttributes(StandardDataType type, Element node, XmlToModelResult result, String attribute) {
		if (StringUtils.isNotBlank(getAttributeValue(node, attribute))) {
			result.addHl7Error(
					new Hl7Error(
							DATA_TYPE_ERROR, 
							type.getType() + " should not include the '" + attribute + "' property. (" + XmlDescriber.describeSingleElement(node) + ")", 
							node));
		}
	}
	
	protected void validateUnallowedChildNode(String type, Element node, XmlToModelResult result, String childNodeName) {
		
		Node child = getNamedChildNode(node, childNodeName);
		if (child != null) {
			result.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, type + " should not include the '" +
					childNodeName + "' property. (" + XmlDescriber.describeSingleElement(node) + ")", node));
		}
	}

	protected void validateNoChildren(ParseContext context, Node node) throws XmlToModelTransformationException {
		NodeList childNodes = node.getChildNodes();
		for (int i=0; i < childNodes.getLength(); ++i) {
			Node item = childNodes.item(i);
			if (isNonTrivialChildNode(item)) {
				throw new XmlToModelTransformationException("Expected " + getType(context) + " node to have no children");
			}
		}
	}

	protected void validateMaxChildCount(ParseContext context, Node node, int maxChildren) throws XmlToModelTransformationException {
		NodeList childNodes = node.getChildNodes();
		int numNontrivialChildNodes = 0;
		for (int i=0; i < childNodes.getLength(); ++i) {
			Node item = childNodes.item(i);
			if (isNonTrivialChildNode(item)) {
				numNontrivialChildNodes++;
			}
		}
		if (numNontrivialChildNodes > maxChildren) {
			throw new XmlToModelTransformationException("Expected " + getType(context) + " node to have no more than " + maxChildren + " child nodes");
		}
	}

	private boolean isNonTrivialChildNode(Node child) {
		return (child instanceof Text && StringUtils.isNotBlank(((Text) child).getData()))
			|| (child instanceof Element);
	}
	
	private String getType(ParseContext context) {
		return context == null ? "" : context.getType();
	}
	
	protected String getOriginalText(Element element) {
        NodeList children = element.getChildNodes();
        String result = null;
        int length = children == null ? 0 : children.getLength();
        for (int i = 0; i < length; i++) {
            Node node = children.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
            } else if ("originalText".equals(NodeUtil.getLocalOrTagName(node))) {
                result = NodeUtil.getTextValue(node);
            }
        }
        return result;
    }

    protected final boolean hasOriginalText(Element element) {
    	return StringUtils.isNotBlank(getOriginalText(element));
    }

}
