package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class BoundedPeriodicIntervalOfTimeXmlParserTest extends AbstractXmlParserTest<GTS> {
	
	public BoundedPeriodicIntervalOfTimeXmlParserTest() {
		super(new BoundedPeriodicIntervalOfTimeXmlParser(), "gts", new GTSImpl());
	}
	
	@Test
	public void shouldParseValueWithFrequencyPeriodictInterval() throws Exception {
		GTSImpl gts = new GTSImpl(new GeneralTimingSpecification(
				IntervalFactory.createLowHigh(parseDate("19990330"), parseDate("20001015")),
				PeriodicIntervalTime.createFrequency(4, new PhysicalQuantity(new BigDecimal("7"), DefaultTimeUnit.DAY))));
		assertEquals(
				 "<gts>" +
				 	"<overallTimePeriod><from value=\"19990330\"/><to value=\"20001015\"/></overallTimePeriod>" +
				 	"<frequency numberOfOccurrences=\"4\"><every unit=\"d\" value=\"7\"/></frequency>" +
				 "</gts>", 
				 this.parser.parse(createContext(), gts));
	}
	
	private static Date parseDate(String textualDate) {
		try {
			return DateUtils.parseDate(textualDate, new String[] {"yyyyMMdd"});
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected GTS createAnyWithNullFlavor(NullFlavor nullFlavor) {
		GTSImpl gts = new GTSImpl();
		gts.setNullFlavor(nullFlavor);
		return gts;
	}

}
