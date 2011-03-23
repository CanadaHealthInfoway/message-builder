package ca.infoway.messagebuilder.simple.xml.parser;

import static java.lang.String.format;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class BoundedPeriodicIntervalOfTimeXmlParser extends AbstractSimpleXmlParser<GTS, GeneralTimingSpecification> implements SimpleXmlParser<GTS> {
	
	private final DateIntervalXmlParser dateIntervalXmlParser = new DateIntervalXmlParser();
	private final PhysicalQuantityXmlParser physicalQuantityXmlParser = new PhysicalQuantityXmlParser();

	BoundedPeriodicIntervalOfTimeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, GeneralTimingSpecification value) throws ParserException {
		renderOveralTimePeriod(builder, dataType, value.getDuration());
		renderFrequency(builder, dataType, value.getFrequency());
    }

	private void renderFrequency(StringBuilder builder, StandardDataType dataType, PeriodicIntervalTime frequency) throws ParserException {
		builder.append(format("<frequency numberOfOccurrences=\"%s\">", frequency.getRepetitions()));
		builder.append(this.physicalQuantityXmlParser.parse(new SimpleXmlParseContextImpl("every"), new PQImpl(frequency.getQuantity())));
		builder.append("</frequency>");
	}

	private void renderOveralTimePeriod(StringBuilder builder, StandardDataType dataType, Interval<Date> duration) throws ParserException {
		builder.append(this.dateIntervalXmlParser.parse(
				new SimpleXmlParseContextImpl("overallTimePeriod"), 
				createIvlTs(duration)));
	}

	private IVLImpl<TS, Interval<Date>> createIvlTs(Interval<Date> duration) {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>(duration);
		ivl.setDataType(StandardDataType.IVL_FULL_DATE);
		return ivl;
	}

	@Override
	protected boolean closeStartElement(GTS dataTypeInstance) {
		return false;
	}

}
