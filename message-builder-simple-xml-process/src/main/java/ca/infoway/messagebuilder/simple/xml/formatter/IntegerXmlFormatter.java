package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.math.NumberUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class IntegerXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected IntegerXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public INT format(FormatContext formatContext, Element value) throws FormatterException {
		INT result = null;
		
		String intString = value.getTextContent();
		try {
			
			// numerous validations done in IntElementParser are _not_ duplicated here - formatter will hopefully catch for now,
			// and we can refactor out common validation at a later date
			
			Integer integer = NumberUtils.createInteger(intString);
			result = new INTImpl(integer);
		} catch(NumberFormatException e) {
			processError(formatContext, "Value not an integer", value);
		}
		return result;
	}
}
