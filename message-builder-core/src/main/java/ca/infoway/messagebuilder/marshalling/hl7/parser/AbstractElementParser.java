package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.schema.XmlSchemas;

abstract class AbstractElementParser implements ElementParser {

	protected static final String SPECIALIZATION_TYPE = "specializationType";

	public abstract BareANY parse(ParseContext context, List<Node> node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException;
	
	protected String getAttributeValue(Node node, String attributeName) {
		return node != null && node instanceof Element ? getAttributeValue((Element) node, attributeName) : null;
	} 

	protected String getAttributeValue(Element node, String attributeName) {
		return node != null && node.hasAttribute(attributeName) ? node.getAttribute(attributeName) : null;
	}

	protected String getXsiType(Node node) {
		return node != null && node instanceof Element ? getXsiType((Element)node) : null;
	}
	
	protected String getXsiType(Element element) {
		return element.getAttributeNS(XmlSchemas.SCHEMA_INSTANCE, "type");
	}

	protected Type getReturnType(ParseContext context) {
		return context == null ? null : context.getExpectedReturnType();
	}
}
