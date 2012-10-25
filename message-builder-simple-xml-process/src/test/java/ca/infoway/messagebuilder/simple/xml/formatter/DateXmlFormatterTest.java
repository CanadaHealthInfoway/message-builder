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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ErrorMessage;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class DateXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test(expected=FormatterException.class)
    public void testParseEmptyElement() throws Exception {
        Element element = createElement("<something" + ns  + "/>");
        assertNull("null returned", new DateXmlFormatter(new FormatterConfiguration()).format(createContext(StandardDataType.TS_DATETIME), element).getValue());
    }

	@Test(expected=FormatterException.class)
    public void testParseNoValueAttributeElement() throws Exception {
        Element element = createElement("<something" + ns  + " notvalue=\"\" />");
        assertNull("null returned", new DateXmlFormatter(new FormatterConfiguration()).format(createContext(StandardDataType.TS_DATETIME), element).getValue());
    }
    
	@Test
    public void testParseValidValueAttribute() throws Exception {
        Calendar calendar = new GregorianCalendar(1999, 2, 3, 9, 11, 10);
        calendar.set(Calendar.MILLISECOND, 867);
        assertValidValueAttribute(calendar.getTime(), "19990303091110.867");
        
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 3, 9, 11, 10).getTime(), "19990303091110");
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 3, 9, 11, 0).getTime(), "199903030911");
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 3, 18, 11, 0).getTime(), "199903031811");
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 3, 9, 0, 0).getTime(), "1999030309");
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 3, 0, 0, 0).getTime(), "19990303");
        
        // the calendar constructor needs a "24" in the hours slot to make sense of wacky dates
        assertValidValueAttribute(new GregorianCalendar(1999, 2, 0, 24, 0, 0).getTime(), "199903");
        assertValidValueAttribute(new GregorianCalendar(1999, 0, 0, 24, 0, 0).getTime(), "1999");
    }
    
	@Test
    public void testParseValidValueAttributeWithTimeZoneMinus() throws Exception {
        Calendar calendar = new GregorianCalendar(2008, 2, 31, 15, 58, 57);
        calendar.set(Calendar.MILLISECOND, 862);
        calendar.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        assertValidValueAttribute(calendar.getTime(), "20080331155857.8620-0400");
    }
    
	@Test
    public void testParseValidValueAttributeWithTimeZonePlus() throws Exception {
        Calendar calendar = new GregorianCalendar(2008, 2, 31, 15, 58, 57);
        calendar.set(Calendar.MILLISECOND, 862);
        // CET is +0100. And set DST offset to get numbers that make sense
        calendar.set(Calendar.DST_OFFSET, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("CET"));
        assertValidValueAttribute(calendar.getTime(), "20080331155857.8620+0100");
    }
    
	@Test
	public void testParseValidValueAttributeWithTimeZonePlusHasCorrectDatePattern() throws Exception {
		Calendar calendar = new GregorianCalendar(2008, 2, 31, 15, 58, 57);
		calendar.set(Calendar.MILLISECOND, 862);
		// CET is +0100. And set DST offset to get numbers that make sense
		calendar.set(Calendar.DST_OFFSET, 0);
		calendar.setTimeZone(TimeZone.getTimeZone("CET"));
		String value = "20080331155857.8620+0100";
        Element element = createElement("<something" + ns  + " value=\"" + value + "\" />");
        Date parsedDate = (new DateXmlFormatter(new FormatterConfiguration())).format(createContext(StandardDataType.TS_DATETIME), element).getValue();
        Assert.assertTrue("is messagebuilder Date", parsedDate instanceof ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern);
		assertEquals("correct date pattern", "yyyyMMddHHmmss.SSSZZZZZ", ((ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern)parsedDate).getDatePattern());		
	}
	
    private void assertValidValueAttribute(Date expectedResult, String value) throws Exception {
        Element element = createElement("<something" + ns  + " value=\"" + value + "\" />");
        assertEquals("correct value returned " + value, expectedResult, (new DateXmlFormatter(new FormatterConfiguration())).format(createContext(StandardDataType.TS_DATETIME), element).getValue());
    }
    
	@Test
    public void testParseInvalidValueAttribute() throws Exception {
		FormatContext context = createContext(StandardDataType.TS_DATETIME);
        Element element = createElement("<something" + ns  + " value=\"19990355\" />");
        new DateXmlFormatter(new FormatterConfiguration(true)).format(context, element);
        assertFalse("valid date", context.getErrors().isEmpty());
        assertEquals("one error", 1, context.getErrors().size());
        
        ErrorMessage errorMessage = context.getErrors().get(0);
        assertEquals("error message", "The timestamp 19990355 in element <something value=\"19990355\"" + ns  + "/> cannot be parsed.", errorMessage.getMessage());
    }
	
    private Element createElement(String string) throws SAXException {
		Document document = new DocumentFactory().createFromString(string);
		return document.getDocumentElement();
	}

	private FormatContext createContext(StandardDataType type) {
		return new FormatterContextImpl(type, null);
	}

}
