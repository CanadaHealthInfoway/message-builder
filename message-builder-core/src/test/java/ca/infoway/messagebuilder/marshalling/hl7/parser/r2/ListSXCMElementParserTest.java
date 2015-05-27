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
 * Last modified: $LastChangedDate: 2014-05-01 12:47:02 -0400 (Thu, 01 May 2014) $
 * Revision:      $LastChangedRevision: 8550 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;

public class ListSXCMElementParserTest extends ParserTestCase {
	
	private ParserR2Registry parserR2Registry = ParserR2Registry.getInstance();
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:hl7-org:v3\" " +
				"xmlns:cda=\"urn:hl7-org:v3\" xmlns:sdtc=\"urn:hl7-org:sdtc\">" +
				"<effectiveTime xsi:type=\"IVL_TS\"><low value=\"20120512\"/><high value=\"20120512\"/></effectiveTime>" +
				"<effectiveTime xsi:type=\"PIVL_TS\" institutionSpecified=\"true\" operator=\"A\"><period value=\"1\" unit=\"h\"/></effectiveTime>" +
				"</top>");

		ParseContext parseContext = ParseContextImpl.create("LIST<SXCM<TS>>", null, SpecificationVersion.CCDA_R1_1, null, 
				null, null, Cardinality.create("0-4"), null, true);
		BareANY result = new ListR2ElementParser(this.parserR2Registry).parse(parseContext, asList(node.getChildNodes()), this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		@SuppressWarnings("unchecked")
		List<MbDate> list = ((LIST<SXCM_R2<MbDate>, MbDate>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		
		DateInterval firstValue = (DateInterval) list.get(0);
		assertDateEquals("low", "yyyyMMdd", parseDate("2012-05-12"), firstValue.getInterval().getLow());
		assertDateEquals("high", "yyyyMMdd", parseDate("2012-05-12"), firstValue.getInterval().getHigh());
		
		PeriodicIntervalTimeR2 secondValue = (PeriodicIntervalTimeR2) list.get(1);
		assertEquals(true, secondValue.getInstitutionSpecified());
		assertEquals(new BigDecimal("1"), secondValue.getPeriod().getQuantity());
		assertEquals("h", secondValue.getPeriod().getUnit().getCodeValue());
	}

    private Date parseDate(String date) throws ParseException {
        return DateUtils.parseDate(date, new String[] {"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"});
    }

}