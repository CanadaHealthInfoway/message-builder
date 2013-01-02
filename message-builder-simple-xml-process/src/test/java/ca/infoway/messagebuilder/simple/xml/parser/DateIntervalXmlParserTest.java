/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class DateIntervalXmlParserTest extends AbstractXmlParserTest<IVL<TS,Interval<Date>>> {
	
	@DataPoint public static final IvlAndExpectedXml XML_LOW_HIGH = new IvlAndExpectedXml(
			createIvlLowHigh("20100218", "20100222", StandardDataType.IVL_DATE), 
			"<interval><from value=\"20100218\"/><to value=\"20100222\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_LOW = new IvlAndExpectedXml(
			createIvlLow("20100218", StandardDataType.IVL_DATE), 
			"<interval><from value=\"20100218\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_HIGH = new IvlAndExpectedXml(
			createIvlHigh("20100222", StandardDataType.IVL_DATE),
			"<interval><to value=\"20100222\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_LOW_DURATION = new IvlAndExpectedXml(
			createIvlLowWidth("20100218", new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), StandardDataType.IVL_DATE), 
			"<interval><from value=\"20100218\"/><duration value=\"5\" unit=\"d\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_HIGH_DURATION = new IvlAndExpectedXml(
			createIvlHighWidth(new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), "20100218", StandardDataType.IVL_DATE), 
			"<interval><duration value=\"5\" unit=\"d\"/><to value=\"20100218\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_DURATION = new IvlAndExpectedXml(
			createIvlWidth(new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), StandardDataType.IVL_DATE), 
			"<interval><duration value=\"5\" unit=\"d\"/></interval>");
	
	public DateIntervalXmlParserTest() {
		super(new DateIntervalXmlParser(), "interval", new IVLImpl<TS, Interval<Date>>());
	}
	
	@Theory
	public void shouldParseValue(IvlAndExpectedXml ivlAndXml) throws Exception {
		 assertEquals(ivlAndXml.expectedXml, this.parser.parse(createContext(), ivlAndXml.ivl));
	}
	
	static class IvlAndExpectedXml {
		private final IVL<TS, Interval<Date>> ivl;
		private final String expectedXml;
		public IvlAndExpectedXml(IVL<TS, Interval<Date>> ivl, String expectedXml) {
			this.ivl = ivl;
			this.expectedXml = expectedXml;
		}
		public IVL<TS, Interval<Date>> getIvl() { 
			return this.ivl;
		}
		public String getExpectedXml() {
			return this.expectedXml;
		}
	}

	private static IVL<TS, Interval<Date>> createIvlLowHigh(String low, String high, StandardDataType dataType) {
		return createIvl(dataType, IntervalFactory.createLowHigh(parseDate(low), parseDate(high)));
	}

	private static IVL<TS, Interval<Date>> createIvl(StandardDataType dataType, Interval<Date> interval) {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>(interval);
		ivl.setDataType(dataType);
		return ivl;
	}

	private static IVL<TS, Interval<Date>> createIvlLow(String low, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createLow(parseDate(low)));
	}

	private static IVL<TS, Interval<Date>> createIvlHigh(String high, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createHigh(parseDate(high)));
	}

	@SuppressWarnings({ "unchecked" })
	private static IVL<TS, Interval<Date>> createIvlLowWidth(String low, Diff width, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createLowWidth(parseDate(low), width));
	}

	@SuppressWarnings({ "unchecked" })
	private static IVL<TS, Interval<Date>> createIvlHighWidth(Diff width, String high, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createWidthHigh(width, parseDate(high)));
	}

	@SuppressWarnings({ "unchecked" })
	private static IVL<TS, Interval<Date>> createIvlWidth(Diff width, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createWidth(width));
	}
	
	private static Date parseDate(String textualDate) {
		try {
			return DateUtils.parseDate(textualDate, new String[] {"yyyyMMdd"});
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected IVL<TS, Interval<Date>> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>();
		ivl.setNullFlavor(nullFlavor);
		return ivl;
	}

}
