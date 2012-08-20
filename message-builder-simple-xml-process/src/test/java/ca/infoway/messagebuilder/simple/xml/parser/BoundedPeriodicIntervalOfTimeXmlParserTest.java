/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
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
