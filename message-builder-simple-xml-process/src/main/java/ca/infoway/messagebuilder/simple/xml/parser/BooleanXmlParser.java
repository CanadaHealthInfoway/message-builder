package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class BooleanXmlParser extends AbstractSimpleXmlParser<BL, Boolean> implements SimpleXmlParser<BL> {
	
	BooleanXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Boolean value) {
		builder.append(value.toString());
	}

	@Override
	protected boolean closeStartElement(BL dataTypeInstance) {
		return false;
	}

}
