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
 * Last modified: $LastChangedDate: 2014-08-11 11:35:13 -0400 (Mon, 11 Aug 2014) $
 * Revision:      $LastChangedRevision: 8844 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.IVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class IvlTsCdaElementParserTest extends MarshallingTestCase {

	private IvlTsCdaElementParser parser = new IvlTsCdaElementParser();
	
	@Test
	public void testIvlTs() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
        Node node = createNode("<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>");
		ParseContext context = ParseContextImpl.create("IVLTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), null, true);
		
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), result);
		
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> expectedIvl = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);

		assertTrue(result.isValid());
		assertTrue(parseResult instanceof IVLTSCDAR1);
		DateInterval ivl = (DateInterval) parseResult.getBareValue();
		assertEquals(expectedIvl, ivl.getInterval());
	}
	
	@Test
	public void testIvlTsConstraintsValid() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
        Node node = createNode("<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>");
        
		ConstrainedDatatype constraints = new ConstrainedDatatype("ivl", "IVL<TS>");
		constraints.getRelationships().add(new Relationship("low", "TS", Cardinality.create("1")));
		constraints.getRelationships().add(new Relationship("high", "TS", Cardinality.create("1")));
        
		ParseContext context = ParseContextImpl.create("IVLTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), constraints, true);
		
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), result);
		
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> expectedIvl = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);

		assertTrue(result.isValid());
		assertTrue(parseResult instanceof IVLTSCDAR1);
		DateInterval ivl = (DateInterval) parseResult.getBareValue();
		assertEquals(expectedIvl, ivl.getInterval());
	}
	
	@Test
	public void testIvlTsConstraintsInvalid() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
        Node node = createNode("<ivl><low value=\"20120503\"/><high value=\"20120708\"/></ivl>");
        
		ConstrainedDatatype constraints = new ConstrainedDatatype("ivl", "IVL<TS>");
		constraints.getRelationships().add(new Relationship("low", "TS", Cardinality.create("0")));
		constraints.getRelationships().add(new Relationship("high", "TS", Cardinality.create("0")));
        
		ParseContext context = ParseContextImpl.create("IVLTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), constraints, true);
		
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), result);
		
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> expectedIvl = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);

		assertFalse(result.isValid());
		assertEquals(2, result.getHl7Errors().size());
		assertTrue(parseResult instanceof IVLTSCDAR1);
		DateInterval ivl = (DateInterval) parseResult.getBareValue();
		assertEquals(expectedIvl, ivl.getInterval());
	}
	
}
