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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TsFullDateElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		TS ts = (TS) new TsElementParser().parse(createContext(), node, this.xmlResult);
		assertNull("null returned", ts.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ts.getNullFlavor());
	}
	private ParseContext createContext() {
		return ParserContextImpl.create("TS.FULLDATE", Date.class, SpecificationVersion.NEWFOUNDLAND, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
	}

	@Test
	public void testParseValidValueAttribute() throws Exception {
		Date calendar = DateUtil.getDate(1999, 2, 3, 0, 0, 0, 0);
		Node node = createNode("<something value=\"19990303\" />");
		assertDateEquals("correct value returned", FULL_DATE,
				calendar,
				(Date) new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
	}

	@Test
	public void testParseValidValueAttributePlusExtraAttribute() throws Exception {
		Date calendar = DateUtil.getDate(1999, 2, 3, 0, 0, 0, 0);
		Node node = createNode("<something extra=\"extra\" value=\"19990303\" />");
		assertDateEquals("correct value returned", FULL_DATE,
				calendar,
				(Date) new TsElementParser().parse(createContext(), node, this.xmlResult).getBareValue());
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

    /**
     *
     * @sharpen.remove
     */
	@Test
	public void dateInterpretedAsSaskShouldBeGreaterThanSameTimeInterpretedAsOntario() throws Exception {
		Node node = createNode("<something value=\"19990303000000\" />");
		Date saskDate = ((Date)new TsElementParser().parse(createContextWithTimeZone(TimeZone.getTimeZone("Canada/Saskatchewan")), node, this.xmlResult).getBareValue());
		Date ontarioDate = ((Date)new TsElementParser().parse(createContextWithTimeZone(TimeZone.getTimeZone("Canada/Ontario")), node, this.xmlResult).getBareValue());
		assertTrue(saskDate.compareTo(ontarioDate) > 0);
	}

	private ParseContext createContextWithTimeZone(TimeZone timeZone) {
		return ParserContextImpl.create("TS.FULLDATE", Date.class, SpecificationVersion.NEWFOUNDLAND, timeZone, null, ConformanceLevel.POPULATED, null, null);
	}
}
