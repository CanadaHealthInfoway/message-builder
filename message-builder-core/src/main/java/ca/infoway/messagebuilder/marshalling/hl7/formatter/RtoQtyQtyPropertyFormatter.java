package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * RTO<QTY,QTY> - Ratio (quantity, quantity)
 * 
 * Represents a Ratio of quantities as an element:
 * 
 * <unitQuantity>
 *    <numerator value="1.0" xsi:type="QTY"/>
 *    <denominator value="64.0" xsi:type="QTY"/>
 * </unitQuantity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<QTY,QTY>")
public class RtoQtyQtyPropertyFormatter extends AbstractRtoPropertyFormatter<BigDecimal, BigDecimal> {

    @Override
    protected Map<String, String> getDenominatorAttributeMap(BigDecimal value) {
        return getAttributeMap(value);
    }
    @Override
    protected Map<String, String> getNumeratorAttributeMap(BigDecimal value) {
        return getAttributeMap(value);
    }

    private Map<String, String> getAttributeMap(BigDecimal value) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("value", value.toString());
        result.put("xsi:type", "QTY");
        return result;
    }
}
