package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class RatioMoneyPerUnitXmlFormatter extends AbstractSimpleXmlFormatter {

	protected RatioMoneyPerUnitXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public RTO<Money, PhysicalQuantity> format(FormatContext formatContext, Element element) throws FormatterException {
		RTO<Money, PhysicalQuantity> result = null;
		
		Element moneyElement = getSingleElement(element, "money");
		Element unitElement = getSingleElement(element, "unit");
		
		if (moneyElement != null && unitElement != null) {
			Money money = parseMoney(formatContext, moneyElement);
			PhysicalQuantity unit = parseQuantity(formatContext, unitElement);
			// a later process will validate that the two quantities are appropriate
			Ratio<Money, PhysicalQuantity> ratio = new Ratio<Money, PhysicalQuantity>(money, unit);
			result = new RTOImpl<Money, PhysicalQuantity>(ratio);
		} else {
			processError(formatContext, "Invalid ratio format. Both money and unit are required.", element);
		}
		return result;
	}

	private PhysicalQuantity parseQuantity(FormatContext formatContext, Element quantityElement) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ_BASIC, null), quantityElement).getValue();
	}
	
	private Money parseMoney(FormatContext formatContext, Element moneyElement) throws FormatterException {
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(StandardDataType.MO_CAD, null), moneyElement).getValue();
	}
}
