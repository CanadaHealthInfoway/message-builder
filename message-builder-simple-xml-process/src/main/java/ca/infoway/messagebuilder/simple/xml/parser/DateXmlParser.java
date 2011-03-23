package ca.infoway.messagebuilder.simple.xml.parser;

import static ca.infoway.messagebuilder.datatype.StandardDataType.TS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_DATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_DATETIME;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TS_FULLDATETIME;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class DateXmlParser extends AbstractSimpleXmlParser<TS, Date> implements SimpleXmlParser<TS> {
	
	DateXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Date value) {
    }
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Date value) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
		attributes.put("value", renderDate(dataType, value));
		return attributes;
	}

	private String renderDate(StandardDataType type, Date date) {
		String datePattern = lookUpDateFormat(type);
		if (date instanceof ca.infoway.messagebuilder.datatype.lang.DateWithPattern) {
			datePattern = ((ca.infoway.messagebuilder.datatype.lang.DateWithPattern)date).getDatePattern();
		}
		return new SimpleDateFormat(datePattern).format(date);
	}

	private static String lookUpDateFormat(StandardDataType type) {
		if (TS_DATE.equals(type) || TS_FULLDATE.equals(type)) {
			return "yyyyMMdd";
		} else if (TS.equals(type) ||TS_DATETIME.equals(type) || TS_FULLDATETIME.equals(type)) {
			return "yyyyMMddHHmmssZ";
		}
		return null;
	}

	@Override
	protected boolean closeStartElement(TS dataTypeInstance) {
		return true;
	}
	
}
