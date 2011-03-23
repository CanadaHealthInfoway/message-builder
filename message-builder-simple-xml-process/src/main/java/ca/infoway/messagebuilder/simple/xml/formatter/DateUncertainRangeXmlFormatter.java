package ca.infoway.messagebuilder.simple.xml.formatter;

import java.util.Date;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class DateUncertainRangeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected DateUncertainRangeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public URG<TS,Date> format(FormatContext formatContext, Element element) throws FormatterException {
		
		URG<TS,Date> result = null;
		
		Element fromElement = getSingleElement(element, "from");
		Element toElement = getSingleElement(element, "to");
		Element centerElement = getSingleElement(element, "center");
		Element durationElement = getSingleElement(element, "duration");
		
		// TODO: BCH: consider the handling of nullFlavor parts, here?
		
		if (fromElement != null && toElement != null) {
			TS from = parseDate(formatContext, fromElement);
			TS to = parseDate(formatContext, toElement);
			result = new URGImpl<TS, Date>(UncertainRange.createLowHigh(from.getValue(), to.getValue()));
		} else if (fromElement != null && centerElement != null) {
			TS from = parseDate(formatContext, fromElement);
			TS center = parseDate(formatContext, centerElement);
			result = new URGImpl<TS, Date>(UncertainRange.createLowCenter(from.getValue(), center.getValue()));
		} else if (fromElement != null && durationElement != null) {
			TS from = parseDate(formatContext, fromElement);
			PQ duration = parseQuantity(formatContext, durationElement);
			result = new URGImpl<TS, Date>(UncertainRange.createLowWidth(from.getValue(), new DateDiff(duration.getValue())));
		} else if (toElement != null && centerElement != null) {
			TS to = parseDate(formatContext, toElement);
			TS center = parseDate(formatContext, centerElement);
			result = new URGImpl<TS, Date>(UncertainRange.createCentreHigh(center.getValue(), to.getValue()));
		} else if (toElement != null && durationElement != null) {
			TS to = parseDate(formatContext, toElement);
			PQ duration = parseQuantity(formatContext, durationElement);
			result = new URGImpl<TS, Date>(UncertainRange.createWidthHigh(new DateDiff(duration.getValue()), to.getValue()));
		} else if (fromElement != null) {
			TS from = parseDate(formatContext, fromElement);
			result = new URGImpl<TS, Date>(UncertainRange.createLow(from.getValue()));
		} else if (toElement != null) {
			TS toDate = parseDate(formatContext, toElement);
			result = new URGImpl<TS, Date>(UncertainRange.createHigh(toDate.getValue()));
		} else if (durationElement != null) {
			PQ durationQuantity = parseQuantity(formatContext, durationElement);
			result = new URGImpl<TS, Date>(UncertainRange.createWidth(new DateDiff(durationQuantity.getValue())));
		} else if (centerElement != null) {
			TS center = parseDate(formatContext, centerElement);
			result = new URGImpl<TS, Date>(UncertainRange.createCentre(center.getValue()));
		} else {
			processError(formatContext, "Invalid uncertain range format", element);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ_TIME, null), duration);
	}

	private TS parseDate(FormatContext formatContext, Element from) throws FormatterException {
		DateXmlFormatter formatter = new DateXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.TS_DATE, null), from);
	}
}
