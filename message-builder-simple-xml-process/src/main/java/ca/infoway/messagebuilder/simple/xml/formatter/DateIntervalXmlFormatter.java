package ca.infoway.messagebuilder.simple.xml.formatter;

import java.util.Date;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class DateIntervalXmlFormatter extends AbstractSimpleXmlFormatter {

	protected DateIntervalXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public IVL<TS,Interval<Date>> format(FormatContext formatContext, Element element) throws FormatterException {
		
		IVL<TS,Interval<Date>> result = null;
		
		Element from = getSingleElement(element, "from");
		Element to = getSingleElement(element, "to");
		Element duration = getSingleElement(element, "duration");
		
		// TODO: BCH: consider the handling of nullFlavor parts, here?
		
		if (from != null && to != null) {
			TS fromDate = parseDate(formatContext, from);
			TS toDate = parseDate(formatContext, to);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createLowHigh(fromDate.getValue(), toDate.getValue()));
		} else if (from != null && duration != null) {
			TS fromDate = parseDate(formatContext, from);
			PQ durationQuantity = parseQuantity(formatContext, duration);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createLowWidth(fromDate.getValue(), new DateDiff(durationQuantity.getValue())));
		} else if (to != null && duration != null) {
			TS toDate = parseDate(formatContext, to);
			PQ durationQuantity = parseQuantity(formatContext, duration);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createWidthHigh(new DateDiff(durationQuantity.getValue()), toDate.getValue()));
		} else if (from != null) {
			TS fromDate = parseDate(formatContext, from);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createLow(fromDate.getValue()));
		} else if (to != null) {
			TS toDate = parseDate(formatContext, to);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createHigh(toDate.getValue()));
		} else if (duration != null) {
			PQ durationQuantity = parseQuantity(formatContext, duration);
			result = new IVLImpl<TS, Interval<Date>>(IntervalFactory.createWidth(new DateDiff(durationQuantity.getValue())));
		} else {
			processError(formatContext, "Invalid interval format", element);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ_TIME, null), duration);
	}

	private TS parseDate(FormatContext formatContext, Element from) throws FormatterException {
		DateXmlFormatter formatter = new DateXmlFormatter(new FormatterConfiguration(true));
		StandardDataType type = formatContext.getType();
		return formatter.format(new FormatterContextImpl(getIntervalDataType(type), null), from);
	}

	private StandardDataType getIntervalDataType(StandardDataType type) {
		return StandardDataType.getByTypeName(type.getTypeName().getParameters().get(0).toString());
	}
}
