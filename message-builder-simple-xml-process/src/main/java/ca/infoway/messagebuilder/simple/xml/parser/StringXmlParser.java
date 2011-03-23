package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class StringXmlParser extends AbstractSimpleXmlParser<ST, String> implements SimpleXmlParser<ST> {
	
	StringXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, String value) {
		builder.append(value);
	}

	@Override
	protected boolean closeStartElement(ST dataTypeInstance) {
		return false;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(ST dataTypeValue) {
		Map<String, String> attributes = Collections.emptyMap();
		if (StandardDataType.ST_LANG.equals(dataTypeValue.getDataType())) {
			attributes = new LinkedHashMap<String,String>();
			String language = dataTypeValue.getLanguage();
			// currently not throwing exception when language not provided - plug in a default value instead
			attributes.put("language", StringUtils.isBlank(language) ? "en-CA" : language);
		}
		return attributes;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, String value) {
		throw new UnsupportedOperationException("Different toNameValuePairs handler used for ST");
	}

}

