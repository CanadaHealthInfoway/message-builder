package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.util.List;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

public interface ElementParser {
	public BareANY parse(ParseContext context, List<Node> node, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException;
}
