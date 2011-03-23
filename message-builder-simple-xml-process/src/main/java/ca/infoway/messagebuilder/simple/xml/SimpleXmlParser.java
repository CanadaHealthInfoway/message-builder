package ca.infoway.messagebuilder.simple.xml;

import ca.infoway.messagebuilder.datatype.ANY;

/**
 * Parses an HL7 data type into XML.
 */
public interface SimpleXmlParser<T extends ANY<?>> {

    public String parse(SimpleXmlParseContext context, T dataTypeInstance) throws ParserException;
	
}
