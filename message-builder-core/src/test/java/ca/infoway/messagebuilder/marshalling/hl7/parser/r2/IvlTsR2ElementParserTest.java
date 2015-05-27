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

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.TimeZoneUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlTsR2ElementParserTest extends CeRxDomainValueTestCase {

	private XmlToModelResult result;
	private IvlTsR2ElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlTsR2ElementParser();
		CodeResolverRegistry.registerResolver(x_TimeUnitsOfMeasure.class, new EnumBasedCodeResolver(DefaultTimeUnit.class));
	}
	
	private Interval<Date> parse(Node node, String type) throws XmlToModelTransformationException {
		return parse(node, type, null);
	}
	
	private Interval<Date> parse(Node node, String type, ConformanceLevel conformanceLevel) throws XmlToModelTransformationException {
		TimeZone timeZone = TimeZoneUtil.getTimeZone("America/Toronto");
		DateInterval dateInterval = (DateInterval) this.parser.parse(
				ParseContextImpl.create(type, Interval.class, SpecificationVersion.V02R02, timeZone, timeZone, conformanceLevel, null, null, false), 
				Arrays.asList(node), 
				this.result).getBareValue();
		return dateInterval == null ? null : dateInterval.getInterval();
	}
	
	@Test
    public void testParseLowHigh() throws Exception {
		Date expectedResultLow = DateUtil.getDate(2006, 7, 10, 12, 0, 0, 0, TimeZoneUtil.getTimeZone("America/Toronto"));
		Date expectedResultHigh = DateUtil.getDate(2006, 7, 12, 15, 0, 0, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		int offset = TimeZoneUtil.getUTCOffset("America/Toronto", expectedResultLow);
		int hours = -1 * offset/(1000*60*60);
		
		Node node = createNode(
                "<effectiveTime><low value=\"20060810120000-0" + hours + "00\" /><high value=\"20060812150000-0" + hours + "00\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE_TIME, expectedResultLow, interval.getLow());
        assertDateEquals("high", FULL_DATE_TIME, expectedResultHigh, interval.getHigh());
    }

	@Test
	public void testParseLowHighAlt() throws Exception {
		Date expectedResultCenter = DateUtil.getDate(2006, 7, 11, 0, 0, 0, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

        Node node = createNode(
                "<effectiveTime><low value=\"20060810\" /><high value=\"20060812\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2006-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE,parseDate("2006-08-12"), interval.getHigh());
        assertDateEquals("center", FULL_DATE_TIME, expectedResultCenter, interval.getCentre());
        assertEquals("width", DateUtils.MILLIS_PER_DAY * 2L, interval.getWidth().getValue().getTime());
    }

	@Test
    public void testParseEffectiveTimeDate() throws Exception {
    	Node node = createNode("<effectiveTime><low value=\"20080918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    }

	@Test
    public void testParseEffectiveTimeDate2() throws Exception {
    	Node node = createNode("<effectiveTime><low value=\"20080918\"/><high value=\"20090918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    	assertDateEquals("high", FULL_DATE, parseDate("2009-09-18"), interval.getHigh());
    }

	@Test
    public void testParseEffectiveTimeDate3() throws Exception {
		Date expectedResultLow = DateUtil.getDate(2013, 2, 11, 16, 44, 2, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		int offset = TimeZoneUtil.getUTCOffset("America/Toronto", expectedResultLow);
		int hours = -1 * offset/(1000*60*60);
		
    	Node node = createNode("<effectiveTime><low value=\"20130311164402.7530-0" + hours + "00\"/><high nullFlavor=\"NA\" /></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
    	
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE_TIME, expectedResultLow, interval.getLow());
    	assertNull(interval.getHigh());
    	assertEquals(NullFlavor.NOT_APPLICABLE.getCodeValue(), interval.getHighNullFlavor().getCodeValue());
    }
	
	@Test
    public void testParsePartTimeDate() throws Exception {
		Date expectedResultLow = DateUtil.getDate(2013, 2, 11, 16, 0, 0, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		int offset = TimeZoneUtil.getUTCOffset("America/Toronto", expectedResultLow);
		int hours = -1 * offset/(1000*60*60);
		
    	Node node = createNode("<effectiveTime><low value=\"2013031116-0" + hours + "00\"/><high nullFlavor=\"NA\" /></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
    	
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE_TIME, expectedResultLow, interval.getLow());
    	assertNull(interval.getHigh());
    	assertEquals(NullFlavor.NOT_APPLICABLE.getCodeValue(), interval.getHighNullFlavor().getCodeValue());
    }
	
	@Test
    public void testParseEffectiveTimeDate4() throws Exception {
    	Node node = createNode("<effectiveTime><low value=\"20080918\"/><high value=\"20090918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    	assertDateEquals("high", FULL_DATE, parseDate("2009-09-18"), interval.getHigh());
    }

	@Test
	public void testParseMissingMandatoryEffectiveTimeDate() throws Exception {
		Node node = createNode("<effectiveTime/>");
		parse(node, "IVL<TS>", ConformanceLevel.MANDATORY);
        assertFalse("not valid", this.result.isValid());
		List<Hl7Error> hl7Errors = this.result.getHl7Errors();
		assertFalse("has error", hl7Errors.isEmpty());
	}
    
	@Test
    public void testRegistered() throws Exception {
		assertNotNull("parser", ParserRegistry.getInstance().get("IVL<TS>"));
	}
    
	@Test
    public void testParseLowWidthInvalidUnits() throws Exception {
        Node node = createNode(
            "<effectiveTime><low value=\"20050810\" /><width value=\"10\" unit=\"s\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue("not valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE, parseDate("2005-08-10"), interval.getHigh());  // width of 10 seconds changes nothing
    }
    
	@Test
    public void testParseCaseThatLooksLikeSetComponent() throws Exception {
    	Node node = createNode(
    			"<effectiveTime value=\"20050810\"></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertTrue(this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("value", FULL_DATE, parseDate("2005-08-10"), interval.getValue());
    	assertEquals(Representation.SIMPLE, interval.getRepresentation());
    }
    
	@Test
    public void testParseLow() throws Exception {
		Date expectedResultLow = DateUtil.getDate(2005, 7, 10, 14, 34, 56, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		int offset = TimeZoneUtil.getUTCOffset("America/Toronto", expectedResultLow);
		int hours = -1 * offset/(1000*60*60);
		
        Node node = createNode(
                "<effectiveTime><low value=\"20050810143456-0" + hours + "00\" /></effectiveTime>");
        
        Interval<Date> interval = parse(node, "IVL.LOW<TS>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE_TIME, expectedResultLow, interval.getLow());
        assertNull("high", interval.getHigh());
        assertNull("centre", interval.getCentre());
        assertNull("width", interval.getWidth());
    }
    
	@Test
    public void testParseLow2() throws Exception {
        Node node = createNode(
                "<effectiveTime><low value=\"20050810\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertNull("high", interval.getHigh());
        assertNull("centre", interval.getCentre());
        assertNull("width", interval.getWidth());
    }
    
	@Test
    public void testParseWidth() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1\" unit=\"d\"/>" +
                "</effectiveTime>");
        Interval<Date> interval = parse(node, "IVL.WIDTH<TS>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertNull("low", interval.getLow());
        assertNull("high", interval.getHigh());
        assertNull("centre", interval.getCentre());
        assertNotNull("width", interval.getWidth());
        
        DateDiff diff = (DateDiff) interval.getWidth();
        UnitsOfMeasureCaseSensitive unit = diff.getUnit();
        assertEquals("unit", "d", unit.getCodeValue());
        assertNull("null flavor", diff.getNullFlavor());

        node = createNode(
                    "<effectiveTime>" +
                    "   <low nullFlavor=\"OTH\"/>" +
                    "   <width nullFlavor=\"OTH\"/>" +
                    "</effectiveTime>");
        interval = parse(node, "IVL<TS>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertNull("low", interval.getLow());
        assertNull("high", interval.getHigh());
        assertNull("centre", interval.getCentre());
        assertNotNull("width", interval.getWidth());
        
        diff = (DateDiff) interval.getWidth();
        assertEquals("nullFlavor", "OTH", diff.getNullFlavor().getCodeValue());
        assertNull("unit", diff.getUnit());
    }
	
	@Test
	public void testParseInvalidNullFlavor() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <low nullFlavor=\"NINF\"/>" +
                "   <width nullFlavor=\"PINF\"/>" +
                "</effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNotNull(interval);
        assertNull(interval.getLow());
        assertNull(interval.getHigh());
        assertNull(interval.getWidth().getValue());
        assertEquals(NullFlavor.NEGATIVE_INFINITY, interval.getLowNullFlavor());
        assertEquals(NullFlavor.POSITIVE_INFINITY, interval.getWidth().getNullFlavor());
        assertTrue(this.result.isValid());
	}
    
	@Test
	public void testParseOtherInvalidNullFlavors() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <center nullFlavor=\"MSK\"/>" +
                "   <high nullFlavor=\"ASKU\"/>" +
                "</effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNotNull(interval);
        assertNull(interval.getLow());
        assertNull(interval.getCentre());
        assertNull(interval.getHigh());
        assertNull(interval.getWidth());
        assertEquals(NullFlavor.MASKED, interval.getCentreNullFlavor());
        assertEquals(NullFlavor.ASKED_BUT_UNKNOWN, interval.getHighNullFlavor());
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size()); // center/high combo not allowed by schema
	}
    
	@Test
    public void testParseWidthFailureValue() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1.d\" unit=\"d\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 1, this.result.getHl7Errors().size()); // width invalid
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"d\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
	
	@Test
    public void testParseWidthFailureUnit() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <width unit=\"monkeys\" value=\"1\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        // error: units are not valid
        assertEquals("error count", 1, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "Unit \"monkeys\" is not valid for type PQ (<width unit=\"monkeys\" value=\"1\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
    
	@Test
    public void testParseWidthFailureValueAndUnit() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1.d\" unit=\"monkey\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count",2, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());

        hl7Error = this.result.getHl7Errors().get(1);
        assertEquals("message", "Unit \"monkey\" is not valid for type PQ (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }

	@Test
    public void testParseEmptyValue() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <value/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 2, this.result.getHl7Errors().size());
    }
    
	@Test
    public void testParseLowWidth() throws Exception {
		Date expectedResultCenter = DateUtil.getDate(2005, 7, 15, 0, 0, 0, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		Node node = createNode(
            "<effectiveTime><low value=\"20050810\" /><width value=\"10\" unit=\"d\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE, parseDate("2005-08-20"), interval.getHigh());
        assertDateEquals("center", FULL_DATE_TIME, expectedResultCenter, interval.getCentre());
        assertEquals("width", new BigDecimal("10"), ((DateDiff) interval.getWidth()).getValueAsPhysicalQuantity().getQuantity());
    }
    
	@Test
    public void testParseLowFullDateTime() throws Exception {
		Date expectedResultlow = DateUtil.getDate(2005, 7, 10, 23, 3, 27, 0, TimeZoneUtil.getTimeZone("America/Toronto"));

		Node node = createNode(
    	"<effectiveTime><low value=\"20050810230327\" /></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS>");
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE_TIME, expectedResultlow, interval.getLow());
    	assertNull("high", interval.getHigh());
    	assertNull("centre", interval.getCentre());
    	assertNull("width", interval.getWidth());
    }
    
    private Date parseDate(String date) throws ParseException {
        return DateUtils.parseDate(date, new String[] {"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"});
    }

}
