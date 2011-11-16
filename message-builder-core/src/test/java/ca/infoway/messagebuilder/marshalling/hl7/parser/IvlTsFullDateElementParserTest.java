/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;

public class IvlTsFullDateElementParserTest extends CeRxDomainValueTestCase {

	private XmlToModelResult result;
	private IvlTsElementParser parser;

	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlTsElementParser();
		CodeResolverRegistry.registerResolver(x_TimeUnitsOfMeasure.class, new EnumBasedCodeResolver(DefaultTimeUnit.class));
	}
	
	private Interval<Date> parse(Node node, String type) throws XmlToModelTransformationException {
		return (Interval<Date>) this.parser.parse(ParserContextImpl.create(type, Interval.class, SpecificationVersion.V02R02, null, null, null), 
				Arrays.asList(node), 
				this.result).getBareValue();
	}
	
	@Test
	public void testParseLowHigh() throws Exception {
        Node node = createNode(
                "<effectiveTime><low value=\"20060810\" /><high value=\"20060812\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2006-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE,parseDate("2006-08-12"), interval.getHigh());
        assertDateEquals("centre", FULL_DATE_TIME, parseDate("2006-08-11T00:00:00"), interval.getCentre());
        assertEquals("width", DateUtils.MILLIS_PER_DAY * 2L, interval.getWidth().getValue().getTime());
    }

	@Test
    public void testParseLowWidth() throws Exception {
        Node node = createNode(
            "<effectiveTime><low value=\"20050810\" /><width value=\"10\" unit=\"d\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertDateEquals("high", FULL_DATE, parseDate("2005-08-20"), interval.getHigh());
        assertDateEquals("centre", FULL_DATE_TIME, parseDate("2005-08-15T00:00:00"), interval.getCentre());
        assertEquals("width", new BigDecimal("10"), ((DateDiff) interval.getWidth()).getValueAsPhysicalQuantity().getQuantity());
    }
    
	@Test
    public void testParseLow() throws Exception {
        Node node = createNode(
                "<effectiveTime><low value=\"20050810\" /></effectiveTime>");
        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNotNull("null", interval);
        assertDateEquals("low", FULL_DATE, parseDate("2005-08-10"), interval.getLow());
        assertNull("high", interval.getHigh());
        assertNull("centre", interval.getCentre());
        assertNull("width", interval.getWidth());
    }
    
	@Test
    public void testParseLowFullDateTime() throws Exception {
    	Node node = createNode(
    	"<effectiveTime><low value=\"20050810230327\" /></effectiveTime>");
    	Interval<Date> interval = parse(node, "IVL<TS.FULLDATETIME>");
    	assertNotNull("null", interval);
    	assertDateEquals("low", FULL_DATE_TIME, parseDate("2005-08-10T23:03:27"), interval.getLow());
    	assertNull("high", interval.getHigh());
    	assertNull("centre", interval.getCentre());
    	assertNull("width", interval.getWidth());
    }
    
	@Test
    public void testParseWidthFailureValue() throws Exception {
        Node node = createNode(
                "<effectiveTime>" +
                "   <width value=\"1.d\" unit=\"d\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 3, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"d\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
    
	@Test
    public void testParseWidthFailureUnit() throws Exception {
        resolver.addDomainValue(null, UnitsOfMeasureCaseSensitive.class);
    	
        Node node = createNode(
                "<effectiveTime>" +
                "   <width unit=\"monkeys\" value=\"1\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 3, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "Unit \"monkeys\" is not valid (<width unit=\"monkeys\" value=\"1\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
    
	@Test
    public void testParseWidthFailureValueAndUnit() throws Exception {
        resolver.addDomainValue(null, UnitsOfMeasureCaseSensitive.class);

        Node node = createNode(
                "<effectiveTime>" +
                "   <width unit=\"monkey\" value=\"1.d\"/>" +
                "</effectiveTime>");

        Interval<Date> interval = parse(node, "IVL<TS.FULLDATE>");
        assertNull("null", interval);
        assertFalse("not valid", this.result.isValid());
        assertEquals("error count", 4, this.result.getHl7Errors().size());
        
        Hl7Error hl7Error = this.result.getHl7Errors().get(0);
        assertEquals("message", "value \"1.d\" is not a valid decimal value (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());

        hl7Error = this.result.getHl7Errors().get(1);
        assertEquals("message", "Unit \"monkey\" is not valid (<width unit=\"monkey\" value=\"1.d\"/>)", hl7Error.getMessage());
        assertEquals("error type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }

    private Date parseDate(String date) throws ParseException {
        return DateUtils.parseDate(date, new String[] {"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"});
    }	
}
