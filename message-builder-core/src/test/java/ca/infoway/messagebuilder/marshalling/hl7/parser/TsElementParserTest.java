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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * @author administrator
 */
public class TsElementParserTest extends MarshallingTestCase { 

	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\" />");
        
        TS ts = (TS) new TsElementParser().parse(createContext(), node, this.xmlResult);
        
        assertNull("null returned", ts.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, ts.getNullFlavor());
        assertTrue(this.xmlResult.getHl7Errors().isEmpty());
    }

    private ParseContext createContext() {
		return ParserContextImpl.create("TS", Date.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED);
	}

	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
    }

	@Test
    public void testParseNoValueAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
    }
    
	@Test
    public void testParseEmptyValueAttributeNode() throws Exception {
        Node node = createNode("<something value=\"\" />");
        assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
    }
    
	@Test
    public void testParseValidValueAttribute() throws Exception {
		Date calendar = DateUtil.getDate(1999, 2, 3, 9, 11, 10, 867);
        assertValidValueAttribute(calendar, "19990303091110.867");
        
        assertValidValueAttribute(DateUtil.getDate(1999, 2, 3, 9, 11, 10, 0), "19990303091110");
        assertValidValueAttribute(DateUtil.getDate(1999, 2, 3, 9, 11, 0, 0), "199903030911");
        assertValidValueAttribute(DateUtil.getDate(1999, 2, 3, 18, 11, 0, 0), "199903031811");
        assertValidValueAttribute(DateUtil.getDate(1999, 2, 3, 9, 0, 0, 0), "1999030309");
        assertValidValueAttribute(DateUtil.getDate(1999, 2, 3, 0, 0, 0, 0), "19990303");
    }
    
	/**
	 * @sharpen.remove
	 */
	@Test
    public void testParseValidValueAttributeWithTimeZoneMinus() throws Exception {
		Date calendar = DateUtil.getDate(2008, 2, 31, 15, 58, 57, 862);
		String expectedValue = "20080331155857.8620" + getCurrentTimeZone(calendar);
		
        assertValidValueAttribute(calendar, expectedValue);
    }
    
	/**
	 * @sharpen.remove
	 */
	@Test
	public void testParseValidValueAttributeWithTimeZonePlusHasCorrectDatePattern() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date calendar = format.parse("2008-03-31_10:58:57.862");

		String value = "20080331155857.8620+0100";
		assertValidValueAttribute(calendar, value);
        Node node = createNode("<something value=\"" + value + "\" />");
        Date parsedDate = (Date) (new TsElementParser()).parse(createContext(), node, this.xmlResult).getBareValue();
        assertTrue("is messagebuilder date", parsedDate instanceof DateWithPattern);
        assertEquals("correct date pattern", "yyyyMMddHHmmss.SSS0ZZZZZ", ((DateWithPattern)parsedDate).getDatePattern());		
	}
    
    private void assertValidValueAttribute(Date expectedResult, String value) throws Exception {
        Node node = createNode("<something value=\"" + value + "\" />");
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(createContext(), node, this.xmlResult).getBareValue());
    }
    
	@Test
    public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something value=\"19990355\" />");
    	XmlToModelResult result = new XmlToModelResult();
        new TsElementParser().parse(null, node, result);
        assertFalse("valid date", result.isValid());
        assertEquals("one error", 1, result.getHl7Errors().size());
        
        Hl7Error hl7Error = result.getHl7Errors().get(0);
        assertEquals("error message", "The timestamp 19990355 in element <something value=\"19990355\"/> cannot be parsed.", hl7Error.getMessage());
        assertEquals("error message type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
    }
	
	@Test
    public void testParseValidDateForExceptionCase() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 10, 0);
		
		String value = "20080625141610" + getCurrentTimeZone(expectedResult);
        Node node = createNode("<something value=\"" + value + "\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATETIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertEquals("no error", 0, this.xmlResult.getHl7Errors().size());
        
		context = ParserContextImpl.create("TS.FULLDATETIME", Date.class, SpecificationVersion.V01R04_3, null, null, ConformanceLevel.POPULATED);
		assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
		assertEquals("one error", 1, this.xmlResult.getHl7Errors().size());
    }
	
	@Test
    public void testParseDateTimeWithMissingTimezoneForNonCeRx() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 00, 0);
		
		String value = "200806251416";
        Node node = createNode("<something value=\"" + value + "\" />");
        
        ParseContext context = ParserContextImpl.create("TS.DATETIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertEquals("has timezone missing error", 1, this.xmlResult.getHl7Errors().size());
    }
	
	@Test
    public void testParseDateTimeWithMissingTimezoneForCeRx() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 00, 0);
		
		String value = "200806251416";
        Node node = createNode("<something value=\"" + value + "\" />");
        
        ParseContext context = ParserContextImpl.create("TS.DATETIME", Date.class, SpecificationVersion.V01R04_3, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertEquals("no timezone missing error", 0, this.xmlResult.getHl7Errors().size());
    }
	
	@Test
    public void testParseNoFullDateTimeSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 10, 0);
		String value = "20080625141610" + getCurrentTimeZone(expectedResult);
        Node node = createNode("<something value=\"" + value + "\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
//        assertTrue("no errors after relaxing validation", this.xmlResult.getHl7Errors().isEmpty());
        assertFalse("no errors after relaxing validation", this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
    }
	
	@Test
    public void testParseNoFullDateSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 0, 0, 0, 0);
		String value = "20080625";
        Node node = createNode("<something value=\"" + value + "\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
//        assertTrue("no errors after relaxing validation", this.xmlResult.getHl7Errors().isEmpty());
        assertFalse("no errors after relaxing validation", this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
    }
	
	@Test
    public void testParseInvalidSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 0, 0, 0, 0);
		String value = "20080625";
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.DATETIME\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertEquals("one error", 1, this.xmlResult.getHl7Errors().size());
        assertTrue("specialization type error", this.xmlResult.getHl7Errors().get(0).getMessage().startsWith("Invalid specialization type TS.DATETIME"));
    }
	
	@Test
    public void testParseValidFullDateSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 0, 0, 0, 0);
		String value = "20080625";
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATE\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertTrue("no errors", this.xmlResult.getHl7Errors().isEmpty());
    }
	
	@Test
    public void testParseValidFullDateTimeSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 10, 0);
		String value = "20080625141610" + getCurrentTimeZone(expectedResult);
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATETIME\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertTrue("no errors", this.xmlResult.getHl7Errors().isEmpty());
    }
	
	@Test
    public void testParseValidFullDateTimeButWithFullDateSpecificationTypeForAbstractFullDateWithTime() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25, 14, 16, 10, 0);
		String value = "20080625141610" + getCurrentTimeZone(expectedResult);
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATE\" />");
        
        ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.POPULATED);
        assertDateEquals("correct value returned " + value, FULL_DATE_TIME, expectedResult, (Date) (new TsElementParser()).parse(context, node, this.xmlResult).getBareValue());
        assertEquals("one error", 1, this.xmlResult.getHl7Errors().size());
        String expectedErrorMsg = "The timestamp element <something specializationType=\"TS.FULLDATE\" " 
        								+ "value=\"20080625141610" + getCurrentTimeZone(expectedResult) 
        								+ "\"/> appears to be formatted as type TS.FULLDATETIME, " 
        								+ "but should be TS.FULLDATE.";
        assertTrue("specialization type error", this.xmlResult.getHl7Errors().get(0).getMessage().equals(expectedErrorMsg));
    }
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void dateShouldBeUnaffectedByDateTimeTimeZone() throws Exception {
		Date expectedResult = DateUtil.getDate(2008, 5, 25);
		String value = "20080625";
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATE\" />");
		ParseContext context = ParserContextImpl.create("TS.FULLDATE", Date.class, SpecificationVersion.R02_04_02, null, TimeZone.getTimeZone("GMT-3"), ConformanceLevel.POPULATED, null, null);
		Date date = (Date)new TsElementParser().parse(context, node, this.xmlResult).getBareValue();
		assertDateEquals("should not be different even though different time zone", FULL_DATE, expectedResult, date);
	}
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void shouldBeConvertedDueToTimeZone() throws Exception {
		//Date expectedResult = DateUtil.getDate(2008, 5, 24, 23, 0, 0, 0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date expectedResult = format.parse("2008-06-24_23:00:00.000");

		String value = "20080625";
		Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATEWITHTIME\" />");
		ParseContext context = ParserContextImpl.create("TS.FULLDATEWITHTIME", Date.class, SpecificationVersion.R02_04_02, null, TimeZone.getTimeZone("GMT-3"), ConformanceLevel.POPULATED, null, null);
		Date date = (Date)new TsElementParser().parse(context, node, this.xmlResult).getBareValue();
		assertDateEquals("should have been converted due to time zone", FULL_DATE_TIME, expectedResult, date);
	}
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void dateShouldBeAffectedByDateTimeZone() throws Exception {
		//Date expectedResult = DateUtil.getDate(2008, 5, 24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date expectedResult = format.parse("2008-06-24_23:00:00.000");
		
		String value = "20080625";
        Node node = createNode("<something value=\"" + value + "\" specializationType=\"TS.FULLDATE\" />");
		ParseContext context = ParserContextImpl.create("TS.FULLDATE", Date.class, SpecificationVersion.R02_04_02, TimeZone.getTimeZone("GMT-3"), null, ConformanceLevel.POPULATED, null, null);
		Date date = (Date)new TsElementParser().parse(context, node, this.xmlResult).getBareValue();
		assertDateEquals("should not be different even though different time zone", FULL_DATE, expectedResult, date);
	}
	
	private String getCurrentTimeZone(Date calendar) {
		SimpleDateFormat tzformat = new SimpleDateFormat("Z");
		String currentTimeZone = tzformat.format(calendar);
		return currentTimeZone;
	}
}
