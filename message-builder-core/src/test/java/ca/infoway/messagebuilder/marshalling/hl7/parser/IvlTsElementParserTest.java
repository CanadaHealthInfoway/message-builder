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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlTsElementParserTest extends CeRxDomainValueTestCase {

	private XmlToModelResult result;
	private IvlTsElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlTsElementParser();
		CodeResolverRegistry.registerResolver(x_TimeUnitsOfMeasure.class, new EnumBasedCodeResolver(DefaultTimeUnit.class));
	}
	
	private Interval<Date> parse(Node node, String type) throws XmlToModelTransformationException {
		return parse(node, type, null);
	}
	
	@SuppressWarnings("unchecked")
	private Interval<Date> parse(Node node, String type, ConformanceLevel conformanceLevel) throws XmlToModelTransformationException {
		return (Interval<Date>) this.parser.parse(
				ParserContextImpl.create(type, Interval.class, SpecificationVersion.V02R02, null, null, conformanceLevel), 
				Arrays.asList(node), 
				this.result).getBareValue();
	}
	
	@Test
    public void testParseLowHigh() throws Exception {
		int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
		int hours = -1 * offset/(1000*60*60);
        Node node = createNode(
                "<effectiveTime><low value=\"20060810120000-0" + hours + "00\" /><high value=\"20060812150000-0" + hours + "00\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.DATETIME>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE_TIME, parseDate("2006-08-10T12:00:00"), interval.getLow());
        assertDateEquals("high", FULL_DATE_TIME, parseDate("2006-08-12T15:00:00"), interval.getHigh());
    }

	@Test
    public void testParseEffectiveTimeDate() throws Exception {
    	Node node = createNode("<effectiveTime><low value=\"20080918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL.LOW<TS.DATE>");
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    }

	@Test
    public void testParseEffectiveTimeDateWithSpecializationType() throws Exception {
    	Node node = createNode("<effectiveTime specializationType=\"IVL&lt;TS.FULLDATE&gt;\"><low value=\"20080918\"/><high value=\"20090918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS.FULLDATEWITHTIME>");
        assertTrue("valid", this.result.isValid());
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    	assertDateEquals("high", FULL_DATE, parseDate("2009-09-18"), interval.getHigh());
    }

	@Test
    public void testParseEffectiveTimeDateWithMissingSpecializationType() throws Exception {
    	Node node = createNode("<effectiveTime><low value=\"20080918\"/><high value=\"20090918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS.FULLDATEWITHTIME>");
        assertFalse("valid", this.result.isValid());
        assertEquals(3, this.result.getHl7Errors().size()); // no ST; low and high should be datetimes 
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    	assertDateEquals("high", FULL_DATE, parseDate("2009-09-18"), interval.getHigh());
    }

	@Test
    public void testParseEffectiveTimeDateWithInvalidSpecializationType() throws Exception {
    	Node node = createNode("<effectiveTime specializationType=\"IVL&lt;TS.DATE&gt;\"><low value=\"20080918\"/><high value=\"20090918\"/></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS.FULLDATEWITHTIME>");
        assertFalse("valid", this.result.isValid());
        assertEquals(3, this.result.getHl7Errors().size()); // invalid ST; low and high should be datetimes 
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE, parseDate("2008-09-18"), interval.getLow());
    	assertDateEquals("high", FULL_DATE, parseDate("2009-09-18"), interval.getHigh());
    }

	@Test
	public void testParseMissingMandatoryEffectiveTimeDate() throws Exception {
		Node node = createNode("<effectiveTime/>");
		parse(node, "IVL.LOW<TS.DATE>", ConformanceLevel.MANDATORY);
        assertFalse("not valid", this.result.isValid());
		List<Hl7Error> hl7Errors = this.result.getHl7Errors();
		assertFalse("has error", hl7Errors.isEmpty());
	}
    
	@Test
    public void testRegistered() throws Exception {
		assertNotNull("parser", ParserRegistry.getInstance().get("IVL.LOW<TS.DATE>"));
	}
    
	@Test
    public void testParseLowWidth() throws Exception {
        Node node = createNode(
            "<effectiveTime><low value=\"20050810\" /><width value=\"10\" unit=\"d\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE, parseDate("2005-08-20"), interval.getHigh());
    }
    
	@Test
    public void testParseLowWidthInvalidUnits() throws Exception {
        Node node = createNode(
            "<effectiveTime><low value=\"20050810\" /><width value=\"10\" unit=\"s\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertFalse("not valid", this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size()); // seconds not valid for width for this type
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE, parseDate("2005-08-10"), interval.getHigh());  // width of 10 seconds changes nothing
    }
    
	@Test
    public void testParseCaseThatLooksLikeSetComponent() throws Exception {
    	Node node = createNode(
    			"<effectiveTime value=\"20050810\"></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS>");
        assertFalse("not valid", this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size()); // IVL<TS> must have two of low/high/width provided (even though this example is a correct representation of a "simple" interval)
    	assertNotNull("null", interval);
    	assertDateEquals("value", FULL_DATE, parseDate("2005-08-10"), interval.getValue());
    }
    
	@Test
    public void testParseLow() throws Exception {
		int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
		int hours = -1 * offset/(1000*60*60);
        Node node = createNode(
                "<effectiveTime><low value=\"20050810143456-0" + hours + "00\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL.LOW<TS>");
        assertTrue("valid", this.result.isValid());
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE_TIME, parseDate("2005-08-10T14:34:56"), interval.getLow());
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
        NullFlavor nullFlavor = (diff).getNullFlavor();
        assertEquals("nullFlavor", "OTH", nullFlavor.getCodeValue());
        assertNull("unit", diff.getUnit());
    }
	
	@Test
	public void testParseInvalidNullFlavor() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <low nullFlavor=\"NINF\"/>" +
                "   <width nullFlavor=\"PINF\"/>" +
                "</effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNotNull(interval);
        assertNull(interval.getLow());
        assertNull(interval.getHigh());
        assertNull(interval.getWidth().getValue());
        assertEquals(ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.POSITIVE_INFINITY.getCodeValue(), interval.getWidth().getNullFlavor().getCodeValue());
        assertFalse(this.result.isValid());
        assertEquals(2, this.result.getHl7Errors().size()); // PINF and NINF are not legal null flavors
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
        System.out.println(this.result.getHl7Errors().get(1));
        assertEquals("error count", 2, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(1);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"d\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
	
	@Test
    public void testParseWidthFailureUnit() throws Exception {
        resolver.addDomainValue(null, UnitsOfMeasureCaseSensitive.class);
    	
        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1\" unit=\"monkeys\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 2, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(1);
        assertEquals("message", "Unit \"monkeys\" is not valid (<width unit=\"monkeys\" value=\"1\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
    
	@Test
    public void testParseWidthFailureValueAndUnit() throws Exception {
        resolver.addDomainValue(null, UnitsOfMeasureCaseSensitive.class);

        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1.d\" unit=\"monkey\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 3, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(1);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());

        hl7Error = this.result.getHl7Errors().get(2);
        assertEquals("message", "Unit \"monkey\" is not valid (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
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
        assertEquals("error count", 3, this.result.getHl7Errors().size());
    }
    
    private Date parseDate(String date) throws ParseException {
        return DateUtils.parseDate(date, new String[] {"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"});
    }
}
