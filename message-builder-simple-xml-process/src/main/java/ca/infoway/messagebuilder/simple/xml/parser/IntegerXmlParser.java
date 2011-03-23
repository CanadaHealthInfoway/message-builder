package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class IntegerXmlParser extends AbstractSimpleXmlParser<INT, Integer> implements SimpleXmlParser<INT> {
	
	IntegerXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Integer value) {
		builder.append(value.toString());
    }

	@Override
	protected boolean closeStartElement(INT dataTypeInstance) {
		return false;
	}

}
