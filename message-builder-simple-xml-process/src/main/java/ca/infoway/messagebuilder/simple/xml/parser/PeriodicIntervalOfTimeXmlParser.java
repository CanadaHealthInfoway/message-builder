package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PeriodicIntervalOfTimeXmlParser extends AbstractSimpleXmlParser<PIVL, PeriodicIntervalTime> implements SimpleXmlParser<PIVL> {
	
	private final PhysicalQuantityXmlParser physicalQuantityXmlParser = new PhysicalQuantityXmlParser();

	PeriodicIntervalOfTimeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, PeriodicIntervalTime value) throws ParserException {
		builder.append(this.physicalQuantityXmlParser.parse(new SimpleXmlParseContextImpl("every"), new PQImpl(value.getQuantity())));
    }

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, PeriodicIntervalTime value) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();
		if (value.getRepetitions()!=null) {
			attributes.put("numberOfOccurrences", ""+value.getRepetitions());
		}
		return attributes;
	}	
	
	@Override
	protected boolean closeStartElement(PIVL dataTypeInstance) {
		return false;
	}

}
