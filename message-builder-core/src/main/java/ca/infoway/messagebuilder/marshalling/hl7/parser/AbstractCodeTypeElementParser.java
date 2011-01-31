package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

public abstract class AbstractCodeTypeElementParser extends AbstractSingleElementParser<Code> {

    @Override
	public BareANY parse(ParseContext context, Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
    	BareANY cd = doCreateDataTypeInstance(context.getType());
        
        populateNullFlavor(cd, context, node, xmlToJavaResult); 
        populateValue(cd, context, node, xmlToJavaResult);
        populateOriginalText(cd, context, (Element) node, getReturnType(context), xmlToJavaResult);
        
        return cd;
    }

	private void populateNullFlavor(BareANY dataType, ParseContext context, Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		if (hasValidNullFlavorAttribute(context, node, xmlToJavaResult)) {
            NullFlavor nullFlavor = parseNullNode(context, node, xmlToJavaResult);
            dataType.setNullFlavor(nullFlavor);
        }
	}

	private void populateValue(BareANY dataType, ParseContext context, Node node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		Code value = parseNonNullNode(context, node, dataType, getReturnType(context), xmlToJavaResult);
        ((BareANYImpl) dataType).setBareValue(value);
	}
	
	private void populateOriginalText(BareANY dataType, ParseContext context, Element element, Type returnType, XmlToModelResult xmlToJavaResult) {
		if (hasOriginalText(element)) {
        	((CD) dataType).setOriginalText(getOriginalText(element));
        }
    }

	private String getOriginalText(Element element) {
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

	protected Hl7Error createHl7Error(Node node, Class<? extends Code> type, String code) {
		String message = "The code, \"" + code + "\", in element <" + NodeUtil.getLocalOrTagName(node) 
			+ "> is not a valid value for domain type \"" 
	    	+ ClassUtils.getShortClassName(type) + "\"";
		return new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, message, (Element) node);
	}

	@SuppressWarnings("unchecked")
	protected Class<? extends Code> getReturnTypeAsCodeType(Type type) {
		if (type instanceof Class) {
			return (Class<? extends Code>) type;
		} else if (Generics.isCollectionParameterizedType(type)) {
			// this case should only happen if the original property was inlined
			return (Class<? extends Code>) Generics.getParameterType(type);
		} else {
			throw new IllegalArgumentException("Can't determine the domain type of " + type);
		}
	}
	
}
