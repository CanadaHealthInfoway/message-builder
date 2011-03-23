package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.math.BigDecimal;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * RTO<QTY,QTY> - Ratio (quantity, quantity)
 * 
 * Parses into a Ratio of quantities. The element looks like this:
 * 
 * <unitQuantity>
 *    <numerator value="1.0" xsi:type="QTY"/>
 *    <denominator value="64.0" xsi:type="QTY"/>
 * </unitQuantity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<QTY,QTY>")
class RtoQtyQtyElementParser extends AbstractRtoElementParser<BigDecimal, BigDecimal> {

    protected BigDecimal getNumeratorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }
    protected BigDecimal getDenominatorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }

    private BigDecimal getValue(Element element) throws XmlToModelTransformationException {
        return new BigDecimal(getAttributeValue(element, "value"));
    }
}
