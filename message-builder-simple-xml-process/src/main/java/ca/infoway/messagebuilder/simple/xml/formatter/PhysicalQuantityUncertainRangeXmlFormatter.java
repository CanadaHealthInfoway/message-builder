package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PhysicalQuantityUncertainRangeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected PhysicalQuantityUncertainRangeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public URG<PQ,PhysicalQuantity> format(FormatContext formatContext, Element element) throws FormatterException {
		
		URG<PQ,PhysicalQuantity> result = null;
		
		Element fromElement = getSingleElement(element, "from");
		Element toElement = getSingleElement(element, "to");
		
		// TODO: BCH: consider the handling of nullFlavor parts, here?
		
		if (fromElement != null && toElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			PQ to = parseQuantity(formatContext, toElement);
			result = new URGImpl<PQ,PhysicalQuantity>(UncertainRange.createLowHigh(from.getValue(), to.getValue()));
		} else if (fromElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			result = new URGImpl<PQ, PhysicalQuantity>(UncertainRange.createLow(from.getValue()));
		} else if (toElement != null) {
			PQ to = parseQuantity(formatContext, toElement);
			result = new URGImpl<PQ, PhysicalQuantity>(UncertainRange.createHigh(to.getValue()));
		} else {
			processError(formatContext, "Invalid uncertain range format", element);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ, null), duration);
	}
}
