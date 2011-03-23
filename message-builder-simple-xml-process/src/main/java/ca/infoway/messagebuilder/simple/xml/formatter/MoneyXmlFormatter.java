package ca.infoway.messagebuilder.simple.xml.formatter;

import java.math.BigDecimal;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class MoneyXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected MoneyXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public MO format(FormatContext formatContext, Element value) throws FormatterException {
		MO result = null;
		String amountString = value.getAttribute("value");
		String currencyCode = value.getAttribute("currency");
		
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
		if (currency == null) {
			processError(formatContext, "Currency not found", value);
		} else {
			try {
				BigDecimal amount = new BigDecimal(amountString);
				result = new MOImpl(new Money(amount, currency));
			} catch(NumberFormatException e) {
				processError(formatContext, "Currency amount is not a number", value);
			}
		}
		
		return result;
	}
}
