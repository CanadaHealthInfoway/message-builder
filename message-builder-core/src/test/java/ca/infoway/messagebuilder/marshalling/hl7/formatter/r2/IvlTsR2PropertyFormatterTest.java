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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-12-30 09:20:19 -0500 (Mon, 30 Dec 2013) $
 * Revision:      $LastChangedRevision: 8261 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlTsR2PropertyFormatterTest extends FormatterTestCase {
	
	public static class CustomUnit extends EnumPattern implements UnitsOfMeasureCaseSensitive {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
		private static final long serialVersionUID = -8455773998578575019L;
		public static final CustomUnit SANDWICH = new CustomUnit("SANDWICH"); 
		public static final CustomUnit COFFEE = new CustomUnit("COFFEE");
		public static final CustomUnit NEWSPAPER = new CustomUnit("NEWSPAPER");
		private CustomUnit(String name) {
			super(name);
		}
		public String getCodeSystem() {
			return null;
		}
		public String getCodeValue() {
			return name();
		}
	}
    
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomUnit() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(1, CustomUnit.SANDWICH));
        String result = new IvlTsR2PropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width unit=\"SANDWICH\" value=\"1\"/></name>", result);
    }
    
	@Test
	public void testNullable() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(NullFlavor.OTHER));
        String result = new IvlTsR2PropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width nullFlavor=\"OTH\"/></name>", result);
    }
    
	/**
	 * 
	 * @sharpen.remove timezone handling
	 */
	@Test
	public void testBasicAbstract() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("America/Toronto");
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				DateUtil.getDate(2006, 11, 25, 11, 12, 13, 0, timeZone),
				DateUtil.getDate(2007, 0, 2, 10, 11, 12, 0, timeZone));
				
		IVLImpl<QTY<Date>, Interval<Date>> hl7DataType = new IVLImpl<QTY<Date>, Interval<Date>>(interval);
		hl7DataType.setDataType(StandardDataType.IVL_TS);
		
		String result = new IvlTsR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "IVL<TS>", ConformanceLevel.POPULATED, null, false, SpecificationVersion.V02R02, timeZone, timeZone, null), 
				hl7DataType);
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20061225111213.0000-0500\"/><high value=\"20070102101112.0000-0500\"/></name>", result);
	}

	/**
	 * 
	 * @sharpen.remove timezone handling
	 */
	@Test
	public void testBasicPartTime() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("America/Toronto");
		Date lowDate = new DateWithPattern(DateUtil.getDate(2006, 11, 25, 11, 12, 13, 0, timeZone), "yyyyMMddHHZZZZZ");
		Date highDate = new DateWithPattern(DateUtil.getDate(2007, 0, 2, 10, 11, 12, 0, timeZone), "yyyyMMddHHZZZZZ");
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				lowDate,
				highDate);
				
		IVLImpl<QTY<Date>, Interval<Date>> hl7DataType = new IVLImpl<QTY<Date>, Interval<Date>>(interval);
		hl7DataType.setDataType(StandardDataType.IVL_TS);
		
		String result = new IvlTsR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "IVL<TS>", ConformanceLevel.POPULATED, null, false, SpecificationVersion.V02R02, timeZone, timeZone, null), 
				hl7DataType);
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"2006122511-0500\"/><high value=\"2007010210-0500\"/></name>", result);
	}

	/**
	 * 
	 * @sharpen.remove timezone handling
	 */
	@Test
	public void testBasic() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("America/Toronto");
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				DateUtil.getDate(2006, 11, 25, 11, 12, 13, 0, timeZone),
				DateUtil.getDate(2007, 0, 2, 10, 11, 12, 0, timeZone));
		IVLImpl<QTY<Date>, Interval<Date>> hl7DataType = new IVLImpl<QTY<Date>, Interval<Date>>(interval);
		hl7DataType.setDataType(StandardDataType.TS);
		
		String result = new IvlTsR2PropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "IVL<TS>", ConformanceLevel.POPULATED, null, false, SpecificationVersion.V02R02, timeZone, timeZone, null), 
				hl7DataType);
		assertTrue(this.result.isValid());
		assertXml("result", "<name><low value=\"20061225111213.0000-0500\"/><high value=\"20070102101112.0000-0500\"/></name>", result);
	}

	@Override
    protected FormatContext getContext(String name) {
    	return new FormatContextImpl(new ModelToXmlResult(), null, name, "IVL<TS>", null, null);
    }
}