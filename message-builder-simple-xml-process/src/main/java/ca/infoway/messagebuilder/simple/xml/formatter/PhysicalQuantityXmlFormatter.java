package ca.infoway.messagebuilder.simple.xml.formatter;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PhysicalQuantityXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected PhysicalQuantityXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public PQ format(FormatContext formatContext, Element value) throws FormatterException {
		String pqValue = value.getAttribute("value");
		String pqUnit = value.getAttribute("unit");
		
		// numerous validations done in PqElementParser are _not_ duplicated here - formatter will hopefully catch for now,
		// and we can refactor out common validation at a later date
		
		if (StringUtils.isBlank(pqValue)) {
			processError(formatContext, "Mandatory attribute \"value\" not provided", value);
			return null;
		} else if (StringUtils.isBlank(pqUnit)) {
			processError(formatContext, "Mandatory attribute \"unit\" not provided", value);
			return null;
		}
		
		BigDecimal quantity = null;
		try {
			quantity = new BigDecimal(pqValue);
		} catch(NumberFormatException e) {
			processError(formatContext, "Mandatory attribute \"value\" not a number", value);
			return null;
		}
		
		UnitsOfMeasureCaseSensitive units = CodeResolverRegistry.lookup(UnitsOfMeasureCaseSensitive.class, pqUnit);
		return new PQImpl(new PhysicalQuantity(quantity, units));
	}
}
