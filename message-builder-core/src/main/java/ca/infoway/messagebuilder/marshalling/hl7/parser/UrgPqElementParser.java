package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.math.BigDecimal;
import java.text.ParseException;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

@DataTypeHandler({"URG<PQ>", "URG<PQ.DRUG>", "URG<PQ.TIME>", "URG<PQ.BASIC>"})
class UrgPqElementParser extends UrgElementParser<PQ, PhysicalQuantity> {
	
	@Override
	protected PhysicalQuantity createType(Element element) throws ParseException, XmlToModelTransformationException {
		String quantity = element.getAttribute("value");
		String unitString = element.getAttribute("unit");
		UnitsOfMeasureCaseSensitive unit = (CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, unitString));
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
