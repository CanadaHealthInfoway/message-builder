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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class IvlTsCdaPropertyFormatterTest extends FormatterTestCase {
	
	private IvlTsCdaPropertyFormatter formatter = new IvlTsCdaPropertyFormatter();
	
	@Test
	public void testIvlTs() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> ivlTs = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);
		DateInterval dateInterval = new DateInterval(ivlTs);
		BareANY dataType = new IVLTSCDAR1Impl(dateInterval);
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "ivl", "IVLTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, null, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		String expected = "<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>";
		assertXml("pivl output", expected, xml, true);
	}
	
	@Test
	public void testIvlTsWithConstraintsValid() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> ivlTs = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);
		DateInterval dateInterval = new DateInterval(ivlTs);
		BareANY dataType = new IVLTSCDAR1Impl(dateInterval);
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("ivl", "IVL<TS>");
		constraints.getRelationships().add(new Relationship("low", "TS", Cardinality.create("1")));
		constraints.getRelationships().add(new Relationship("high", "TS", Cardinality.create("1")));
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "ivl", "IVLTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, constraints, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		String expected = "<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>";
		assertXml("ivl output", expected, xml, true);
	}
	
	@Test
	public void testIvlTsWithConstraintsInValid() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> ivlTs = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);
		DateInterval dateInterval = new DateInterval(ivlTs);
		BareANY dataType = new IVLTSCDAR1Impl(dateInterval);
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("ivl", "IVL<TS>");
		constraints.getRelationships().add(new Relationship("low", "TS", Cardinality.create("0")));
		constraints.getRelationships().add(new Relationship("high", "TS", Cardinality.create("0")));
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "ivl", "IVLTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, constraints, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertFalse(result.isValid());
		assertEquals(2, result.getHl7Errors().size());
		String expected = "<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>";
		assertXml("ivl output", expected, xml, true);
	}
	
}
