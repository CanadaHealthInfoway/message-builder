package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PhysicalQuantityIntervalXmlFormatter extends AbstractSimpleXmlFormatter {

	protected PhysicalQuantityIntervalXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public IVL<PQ,Interval<PhysicalQuantity>> format(FormatContext formatContext, Element element) throws FormatterException {
		
		IVL<PQ,Interval<PhysicalQuantity>> result = null;
		
		Element fromElement = getSingleElement(element, "from");
		Element toElement = getSingleElement(element, "to");
		
		// TODO: BCH: consider the handling of nullFlavor parts, here?
		
		if (fromElement != null && toElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			PQ to = parseQuantity(formatContext, toElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createLowHigh(from.getValue(), to.getValue()));
		} else if (fromElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createLow(from.getValue()));
		} else if (toElement != null) {
			PQ to = parseQuantity(formatContext, toElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createHigh(to.getValue()));
		} else {
			processError(formatContext, "Invalid interval format", element);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ, null), duration);
	}
}
