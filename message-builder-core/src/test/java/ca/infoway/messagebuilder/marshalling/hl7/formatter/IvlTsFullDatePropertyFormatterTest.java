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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlTsFullDatePropertyFormatterTest extends FormatterTestCase {

	private IvlTsPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.formatter = new IvlTsPropertyFormatter();
	}

	@Override
	protected FormatContext getContext(String name) {
		return getContext(name, "IVL<TS.FULLDATE>", SpecificationVersion.R02_04_03);
	}

	protected FormatContext getContext(String name, String type, VersionNumber version) {
		return new FormatContextImpl(this.result, null, name, type, ConformanceLevel.POPULATED, null, false, version, null, null, null, false);
	}
	
	@Test
	public void testBasic() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2006-12-25"), parseDate("2007-01-02"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20061225\"/><high value=\"20070102\"/></name>", result);
	}

	@Test
	public void testInvalidIntervalLow() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><low value=\"20061225\"/></name>", result);
	}

	@Test
	public void testInvalidIntervalLow2() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name", "IVL.HIGH<TS.FULLDATE>", SpecificationVersion.R02_04_02), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(2, this.result.getHl7Errors().size()); // low invalid; must supply high
		assertXml("result", "<name><low value=\"20061225\"/></name>", result);
	}

	@Test
	public void testInvalidIntervalHigh() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createHigh(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name", "IVL.WIDTH<TS.FULLDATE>", SpecificationVersion.R02_04_02), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(2, this.result.getHl7Errors().size()); // high invalid; must supply width
		assertXml("result", "<name><high value=\"20061225\"/></name>", result);
	}

	@Test
	public void testIntervalWidthWithDecimals() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(new PhysicalQuantity(new BigDecimal("1.5"), DefaultTimeUnit.MONTH)));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // must have 2 of width/low/high
		assertXml("result", "<name><width unit=\"mo\" value=\"1.5\"/></name>", result);
	}
	
	@Test
	public void testIntervalSimple() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createSimple(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // must have 2 of width/low/high
		assertXml("result", "<name value=\"20061225\"/>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Date>, Interval<Date>>());
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}

	@Test
	public void testNullCaseMasked() throws Exception {
		IVLImpl<QTY<Date>, Interval<Date>> dataType = new IVLImpl<QTY<Date>, Interval<Date>>();
		dataType.setNullFlavor(NullFlavor.MASKED);
		String result = this.formatter.format(getContext("name"), dataType);
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"MSK\"/>", result);
	}

	@Test
	public void testInvalidIntervalWidth() throws Exception {
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> interval = IntervalFactory.<Date>createWidth(diff);
		String result = this.formatter.format(getContext("name"), 				
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><width unit=\"d\" value=\"15\"/></name>", result);
	}

	@Test
	public void testIntervalWidth() throws Exception {
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> interval = IntervalFactory.<Date>createWidth(diff);
		String result = this.formatter.format(getContext("name", "IVL.WIDTH<TS.FULLDATE>", SpecificationVersion.R02_04_03), 				
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><width unit=\"d\" value=\"15\"/></name>", result);
	}

	@Test
	public void testIntervalLow() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name", "IVL.LOW<TS.FULLDATE>", SpecificationVersion.R02_04_03), 				
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20061225\"/></name>", result);
	}

	@Test
	public void testIntervalHigh() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createHigh(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name", "IVL.HIGH<TS.FULLDATE>", SpecificationVersion.R02_04_03), 				
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><high value=\"20061225\"/></name>", result);
	}

	@Test
	public void testIntervalLowWidth() throws Exception {
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> interval = IntervalFactory.<Date>createLowWidth(parseDate("2007-02-20T15:34:22"), diff);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20070220\"/><width unit=\"d\" value=\"15\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowHighWithNullFlavor() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2007-02-20T15:34:22"), null, null, NullFlavor.MASKED);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20070220\"/><high nullFlavor=\"MSK\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowHighWithInvalidNullFlavor() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2007-02-20T15:34:22"), null, null, NullFlavor.POSITIVE_INFINITY);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><low value=\"20070220\"/><high nullFlavor=\"PINF\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowHighWithInvalidNullFlavor2() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2007-02-20T15:34:22"), null, null, NullFlavor.NEGATIVE_INFINITY);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><low value=\"20070220\"/><high nullFlavor=\"NINF\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowWidthInvalidUnits() throws Exception {
		PhysicalQuantity quantity = new PhysicalQuantity(new BigDecimal(15), DefaultTimeUnit.MINUTE);
		Diff<Date> diff = new DateDiff(quantity);
		Interval<Date> interval = IntervalFactory.<Date>createLowWidth(parseDate("2007-02-20T15:34:22"), diff);
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><low value=\"20070220\"/><width unit=\"min\" value=\"15\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowMissingOther() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2007-02-20T15:34:22"));
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<name><low value=\"20070220\"/></name>", result);
	}
	
	@Test
	public void testIntervalLowMissingOther2() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2007-02-20T15:34:22"));
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // must have 2 of width/low/high
		assertXml("result", "<name><low value=\"20070220\"/></name>", result);
	}

	@Test
	public void testBasicAbstract() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2006-12-25"), parseDate("2007-01-02"));
		IVLImpl<QTY<Date>, Interval<Date>> hl7DataType = new IVLImpl<QTY<Date>, Interval<Date>>(interval);
		hl7DataType.setDataType(StandardDataType.IVL_FULL_DATE);
		
		String result = this.formatter.format(new FormatContextImpl(this.result, null, "name", "IVL<TS.FULLDATEWITHTIME>", ConformanceLevel.POPULATED, null, false, SpecificationVersion.R02_04_03, null, null, null, false), 
				hl7DataType);
		assertTrue(this.result.isValid());
		assertXml("result", "<name specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\"><low value=\"20061225\"/><high value=\"20070102\"/></name>", result);
	}

}
