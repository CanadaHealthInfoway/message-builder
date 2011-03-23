package ca.infoway.messagebuilder.simple.xml.formatter;

import java.util.Date;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class BoundedPeriodicIntervalOfTimeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected BoundedPeriodicIntervalOfTimeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public GTS format(FormatContext formatContext, Element element) throws FormatterException {
		
		GTS result = null;
		
		Element frequencyElement = getSingleElement(element, "overallTimePeriod");
		Element periodicIntervalElement = getSingleElement(element, "frequency");
		
		if (frequencyElement != null && periodicIntervalElement != null) {
			IVL<TS,Interval<Date>> ivl = parseDateInterval(formatContext, frequencyElement, StandardDataType.IVL_FULL_DATE);
			PIVL pivl = parsePeriodicInterval(formatContext, periodicIntervalElement, StandardDataType.PIVL_TS_DATETIME);
			GeneralTimingSpecification boundedPeriodicIntervalTime = new GeneralTimingSpecification(ivl.getValue(), pivl.getValue());
			result = new GTSImpl(boundedPeriodicIntervalTime);
		} else {
			processError(formatContext, "Invalid bounded periodic interval format. Both overallTimePeriod and frequency must be specified", element);
		}
		return result;
	}

	private IVL<TS, Interval<Date>> parseDateInterval(FormatContext formatContext, Element frequencyElement, StandardDataType datatype) throws FormatterException {
		DateIntervalXmlFormatter formatter = new DateIntervalXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), frequencyElement);
	}

	private PIVL parsePeriodicInterval(FormatContext formatContext, Element periodicInterval, StandardDataType datatype) throws FormatterException {
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), periodicInterval);
	}
}
