package ca.infoway.messagebuilder.simple.xml.parser;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PhysicalQuantityXmlParser extends AbstractSimpleXmlParser<PQ, PhysicalQuantity> implements SimpleXmlParser<PQ> {

    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";
	
	PhysicalQuantityXmlParser() {
		super();
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, PhysicalQuantity value) throws ParserException {
	}

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, PhysicalQuantity physicalQuantity) {
		Map<String, String> result = new LinkedHashMap<String, String>();
        if (physicalQuantity.getQuantity() != null) {
            result.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
            if (physicalQuantity.getUnit() != null) {
                result.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
            }
        }
        return result;
    }

    private String formatQuantity(BigDecimal quantity) {
        return quantity.toString();
    }

	@Override
	protected boolean closeStartElement(PQ dataTypeInstance) {
		return true;
	}
	
}
