package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class SimpleCodedTypeXmlParser extends AbstractSimpleXmlParser<CS, Code> implements SimpleXmlParser<CS> {
	
	SimpleCodedTypeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Code value) throws ParserException {
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Code code) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();

		if (code.getCodeValue()!=null) {
			attributes.put("code", code.getCodeValue());	
		}
		
        return attributes;
	}

	@Override
	protected boolean closeStartElement(CS dataTypeInstance) {
		return true;
	}

}
