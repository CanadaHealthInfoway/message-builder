package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * RTO&lt;PQ, PQ&gt; - Ratio (physical quantity, physical quantity)
 *
 * Represents a Ratio of physical quantities as an element:
 *
 * &lt;unitQuanity&gt;
 *    &lt;numerator value="1.0" xsi:type="PQ"/&gt;
 *    &lt;denominator value="64.0" xsi:type="/&gt;
 * &lt;/unitQuanity&gt;
 */
 //http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
@DataTypeHandler("RTO<PQ,PQ>")
public class RtoPqPqPropertyFormatter extends AbstractRtoPropertyFormatter<PhysicalQuantity, PhysicalQuantity> {

    @Override
    protected Map<String, String> getDenominatorAttributeMap(PhysicalQuantity value) {
        return getAttributeMap(value);
    }
    @Override
    protected Map<String, String> getNumeratorAttributeMap(PhysicalQuantity value) {
        return getAttributeMap(value);
    }

    private Map<String, String> getAttributeMap(PhysicalQuantity value) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("value", value.getQuantity().toString());
        result.put("unit", value.getUnit().getCodeValue());
        result.put("xsi:type", "PQ");
        return result;
    }
}
