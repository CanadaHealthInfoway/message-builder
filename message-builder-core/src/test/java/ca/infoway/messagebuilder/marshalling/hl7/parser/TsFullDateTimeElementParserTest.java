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

import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TsFullDateTimeElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		TS ts = (TS) new TsElementParser().parse(createContext(), node, this.xmlJavaResult);
		
		assertNull("null returned", ts.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ts.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("TS.FULLDATETIME", Date.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValidValueAttribute() throws Exception {
		Date calendar = DateUtil.getDate(1999, 2, 3, 10, 11, 12, 0);
		Node node = createNode("<something value=\"19990303101112\" />");
		assertDateEquals("correct value returned", FULL_DATE_TIME,  
				calendar, 
				(Date) new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueInWrongFormat() throws Exception {
		Node node = createNode("<something value=\"19990303\" />");
		assertNotNull("correct value returned", new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
		assertEquals("error", 1, this.xmlJavaResult.getHl7Errors().size());
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseValidValueAttributePlusExtraAttribute() throws Exception {
		Date calendar = DateUtil.getDate(1999, 2, 3, 10, 11, 12, 0);
		Node node = createNode("<something extra=\"extra\" value=\"19990303101112\" />");
		assertDateEquals("correct value returned", FULL_DATE_TIME,  
				calendar, 
				(Date) new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
    public void testParseValidValueAttributeWithTimeZoneMinus() throws Exception {
		Date calendar = DateUtil.getDate(2008, 2, 31, 15, 58, 57, 862);
		Node node = createNode("<something extra=\"extra\" value=\"20080331155857.8620-0400\" />");
		assertDateEquals("correct value returned", FULL_DATE_TIME,  
				calendar, 
				(Date) new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
    }
    
	@Test
    public void testParseValidValueAttributeWithTimeZonePlus() throws Exception {
		Date expectedCalendar = DateUtil.getDate(2008, 2, 31, 10, 58, 57, 862);
		Node node = createNode("<something extra=\"extra\" value=\"20080331155857.8620+0100\" />");
		assertDateEquals("correct value returned", FULL_DATE_TIME,  
				expectedCalendar, 
				(Date) new TsElementParser().parse(createContext(), node, this.xmlJavaResult).getBareValue());
    }
    
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"19990355101112\" />");
		
        new TsElementParser().parse(createContext(), node, this.xmlJavaResult);

        assertFalse("valid date", this.xmlJavaResult.isValid());
        assertEquals("one error", 1, this.xmlJavaResult.getHl7Errors().size());
        
        Hl7Error hl7Error = this.xmlJavaResult.getHl7Errors().get(0);
        assertEquals("error message", "The timestamp 19990355101112 in element <something value=\"19990355101112\"/> cannot be parsed.", hl7Error.getMessage());
        assertEquals("error message type", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
	}
}
