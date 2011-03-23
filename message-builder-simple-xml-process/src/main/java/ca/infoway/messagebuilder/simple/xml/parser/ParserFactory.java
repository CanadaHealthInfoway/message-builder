package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public interface ParserFactory {
	public SimpleXmlParser<?> create(StandardDataType dataType) throws ParserException;
}
