package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class EncapsulatedDataSignatureXmlParser extends AbstractSimpleXmlParser<ED<String>, String> implements SimpleXmlParser<ED<String>> {
	
	EncapsulatedDataSignatureXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, String value) {
		builder.append(value);
	}

	@Override
	protected boolean closeStartElement(ED<String> dataTypeInstance) {
		return false;
	}
	
}

