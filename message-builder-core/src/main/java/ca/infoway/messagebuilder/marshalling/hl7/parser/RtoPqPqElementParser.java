package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.math.BigDecimal;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

/**
 * RTO<PQ, PQ> - Ratio (physical quantity, physical quantity)
 * 
 * Parses into a Ratio of physical quantities. The elements looks like this:
 * 
 * <unitQuanity>
 *    <numerator value="1.0" xsi:type="PQ"/>
 *    <denominator value="64.0" xsi:type="/>
 * </unitQuanity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<PQ,PQ>")
class RtoPqPqElementParser extends AbstractRtoElementParser<PhysicalQuantity, PhysicalQuantity> {

    @Override
	protected PhysicalQuantity getNumeratorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }
    @Override
	protected PhysicalQuantity getDenominatorValue(Element element) throws XmlToModelTransformationException {
        return getValue(element);
    }

    private PhysicalQuantity getValue(Element element) throws XmlToModelTransformationException {
        return new PhysicalQuantity(
                    new BigDecimal(getAttributeValue(element, "value")), 
                    CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, getAttributeValue(element, "unit")));
    }
}
