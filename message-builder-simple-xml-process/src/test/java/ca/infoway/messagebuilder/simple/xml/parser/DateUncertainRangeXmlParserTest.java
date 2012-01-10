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
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class DateUncertainRangeXmlParserTest extends AbstractXmlParserTest<URG<TS, Date>> {
	
	@DataPoint public static final UrgAndExpectedXml XML_LOW_HIGH = new UrgAndExpectedXml(
			createUrgLowHigh("20100218", "20100222", StandardDataType.URG_TS_DATE), 
			"<range><from value=\"20100218\"/><to value=\"20100222\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_LOW = new UrgAndExpectedXml(
			createUrgLow("20100218", StandardDataType.URG_TS_DATE), 
			"<range><from value=\"20100218\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_LOW_DURATION = new UrgAndExpectedXml(
			createUrgLowWidth("20100218", new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), StandardDataType.URG_TS_DATE), 
			"<range><from value=\"20100218\"/><duration value=\"5\" unit=\"d\"/></range>");
	
	@DataPoint public static final UrgAndExpectedXml XML_HIGH = new UrgAndExpectedXml(
			createUrgHigh("20100222", StandardDataType.URG_TS_DATE),
			"<range><to value=\"20100222\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_HIGH_DURATION = new UrgAndExpectedXml(
			createUrgHighWidth(new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), "20100218", StandardDataType.URG_TS_DATE), 
			"<range><duration value=\"5\" unit=\"d\"/><to value=\"20100218\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_DURATION = new UrgAndExpectedXml(
			createUrgWidth(new DateDiff(new PhysicalQuantity(new BigDecimal(5), DefaultTimeUnit.DAY)), StandardDataType.URG_TS_DATE), 
			"<range><duration value=\"5\" unit=\"d\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_CENTRE = new UrgAndExpectedXml(
			createUrgCentre("20100220", StandardDataType.URG_TS_DATE), 
			"<range><centre value=\"20100220\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_CENTRE_HIGH = new UrgAndExpectedXml(
			createUrgCentreHigh("20100220", "20100222", StandardDataType.URG_TS_DATE), 
			"<range><centre value=\"20100220\"/><to value=\"20100222\"/></range>");
	
	public DateUncertainRangeXmlParserTest() {
		super(new DateUncertainRangeXmlParser(), "range", new URGImpl<TS, Date>());
	}
	
	@Theory
	public void shouldParseValue(UrgAndExpectedXml urgAndXml) throws Exception {
		 assertEquals(urgAndXml.expectedXml, this.parser.parse(createContext(), urgAndXml.ivl));
	}
	
	static class UrgAndExpectedXml {
		private final URG<TS, Date> ivl;
		private final String expectedXml;
		public UrgAndExpectedXml(URG<TS, Date> ivl, String expectedXml) {
			this.ivl = ivl;
			this.expectedXml = expectedXml;
		}
		public URG<TS, Date> getIvl() { 
			return this.ivl;
		}
		public String getExpectedXml() {
			return this.expectedXml;
		}
	}

	private static URG<TS, Date> createUrgLowHigh(String low, String high, StandardDataType dataType) {
		return createUrg(dataType, UncertainRange.createLowHigh(parseDate(low), parseDate(high)));
	}

	private static URG<TS, Date> createUrg(StandardDataType dataType, UncertainRange<Date> uncertainRange) {
		URGImpl<TS, Date> ivl = new URGImpl<TS, Date>(uncertainRange);
		ivl.setDataType(dataType);
		return ivl;
	}

	private static URG<TS, Date> createUrgLow(String low, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createLow(parseDate(low)));
	}

	private static URG<TS, Date> createUrgCentre(String centre, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createCentre(parseDate(centre)));
	}

	private static URG<TS, Date> createUrgCentreHigh(String centre, String high, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createCentreHigh(parseDate(centre), parseDate(high)));
	}
	
	private static URG<TS, Date> createUrgHigh(String high, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createHigh(parseDate(high)));
	}

	@SuppressWarnings({ "unchecked" })
	private static URG<TS, Date> createUrgLowWidth(String low, Diff width, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createLowWidth(parseDate(low), width));
	}

	@SuppressWarnings({ "unchecked" })
	private static URG<TS, Date> createUrgHighWidth(Diff width, String high, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createWidthHigh(width, parseDate(high)));
	}

	@SuppressWarnings({ "unchecked" })
	private static URG<TS, Date> createUrgWidth(Diff width, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createWidth(width));
	}
	
	private static Date parseDate(String textualDate) {
		try {
			return DateUtils.parseDate(textualDate, new String[] {"yyyyMMdd"});
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected URG<TS, Date> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		URGImpl<TS, Date> ivl = new URGImpl<TS, Date>();
		ivl.setNullFlavor(nullFlavor);
		return ivl;
	}

}
