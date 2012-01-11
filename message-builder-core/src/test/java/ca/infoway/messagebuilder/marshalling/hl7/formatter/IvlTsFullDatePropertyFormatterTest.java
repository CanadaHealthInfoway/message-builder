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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlTsFullDatePropertyFormatterTest extends FormatterTestCase {

	private IvlTsPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.formatter = new IvlTsPropertyFormatter();
	}

	@Override
	protected FormatContext getContext(String name) {
		return new FormatContextImpl(name, "IVL<TS.FULLDATE>", ConformanceLevel.POPULATED);
	}

	@Test
	public void testBasic() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2006-12-25"), parseDate("2007-01-02"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name><low value=\"20061225\"/><high value=\"20070102\"/></name>", result);
	}

	@Test
	public void testIntervalLow() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLow(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name><low value=\"20061225\"/></name>", result);
	}

	@Test
	public void testIntervalWidthWithDecimals() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(new PhysicalQuantity(new BigDecimal("1.5"), DefaultTimeUnit.MONTH)));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name><width unit=\"mo\" value=\"1.5\"/></name>", result);
	}
	
	@Test
	public void testIntervalSimple() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createSimple(parseDate("2006-12-25"));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name value=\"20061225\"/>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Date>, Interval<Date>>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}

	@Test
	public void testIntervalWidth() throws Exception {
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> interval = IntervalFactory.<Date>createWidth(diff);
		String result = this.formatter.format(getContext("name"), 				
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name><width unit=\"d\" value=\"15\"/></name>", result);
	}

	@Test
	public void testIntervalLowWidth() throws Exception {
		Diff<Date> diff = new Diff<Date>(new Date(15 * DateUtils.MILLIS_PER_DAY));
		Interval<Date> interval = IntervalFactory.<Date>createLowWidth(parseDate("2007-02-20T15:34:22"), diff);
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Date>, Interval<Date>>(interval));
		assertXml("result", "<name><low value=\"20070220\"/><width unit=\"d\" value=\"15\"/></name>", result);
	}
	
	@Test
	public void testBasicAbstract() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(parseDate("2006-12-25"), parseDate("2007-01-02"));
		IVLImpl<QTY<Date>, Interval<Date>> hl7DataType = new IVLImpl<QTY<Date>, Interval<Date>>(interval);
		hl7DataType.setDataType(StandardDataType.TS_FULLDATEWITHTIME);
		
		String result = this.formatter.format(new FormatContextImpl("name", "IVL<TS.FULLDATE>", ConformanceLevel.POPULATED, true, null, null, null), 
				hl7DataType);
		assertXml("result", "<name specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\"><low specializationType=\"TS.FULLDATE\" value=\"20061225\" xsi:type=\"TS\"/><high specializationType=\"TS.FULLDATE\" value=\"20070102\" xsi:type=\"TS\"/></name>", result);
	}

}
