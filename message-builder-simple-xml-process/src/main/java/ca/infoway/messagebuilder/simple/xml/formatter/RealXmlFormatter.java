package ca.infoway.messagebuilder.simple.xml.formatter;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class RealXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected RealXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public REAL format(FormatContext formatContext, Element value) throws FormatterException {
		REAL result = null;
		
		String realString = value.getTextContent();
		try {
			
			// numerous validations done in RealElementParser are _not_ duplicated here - formatter will hopefully catch for now,
			// and we can refactor out common validation at a later date
			
			BigDecimal real = NumberUtils.createBigDecimal(realString);
			result = new REALImpl(real);
		} catch(NumberFormatException e) {
			processError(formatContext, "Value not a number", value);
		}
		return result;
	}
}
