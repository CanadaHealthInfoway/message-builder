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
 * Last modified: $LastChangedDate: 2012-08-30 17:31:02 -0400 (Thu, 30 Aug 2012) $
 * Revision:      $LastChangedRevision: 6041 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;

public class UrgTsElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode(
			"<effectiveTime xsi:type=\"URG_TS\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
				"<center xsi:type=\"TS\" specializationType=\"TS.DATE\" value=\"200404\"/>" +
				"<width xsi:type=\"PQ\" specializationType=\"PQ.TIME\" value=\"4\" unit=\"mo\"/>" +
			"</effectiveTime>");
		
		@SuppressWarnings("unchecked")
		UncertainRange<Date> range = (UncertainRange<Date>) new UrgTsElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("low", DateUtil.getDate(2004, 1, 1), range.getLow());	
		assertEquals("centre", DateUtil.getDate(2004, 3, 1), range.getCentre());
		assertEquals("high", DateUtil.getDate(2004, 5, 1), range.getHigh());
		assertEquals("width", new BigDecimal("4"), ((DateDiff) range.getWidth()).getValueAsPhysicalQuantity().getQuantity());
		assertEquals("width units", DefaultTimeUnit.MONTH.getCodeValue(), ((DateDiff) range.getWidth()).getValueAsPhysicalQuantity().getUnit().getCodeValue());
		assertEquals("representation", Representation.CENTRE_WIDTH, range.getRepresentation());
		assertNull(range.getLowInclusive());
		assertNull(range.getHighInclusive());
	}
	
	@Test
	public void testParseWithLowHighInclusiveAttributes() throws Exception {
		Node node = createNode(
			"<effectiveTime>" +
				"<low inclusive=\"true\" value=\"20040101\"/>" +
				"<high inclusive=\"true\" value=\"20040501\"/>" +
			"</effectiveTime>");
		
		@SuppressWarnings("unchecked")
		UncertainRange<Date> range = (UncertainRange<Date>) new UrgTsElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		Date lowDate = DateUtil.getDate(2004, 0, 1);
		Date highDate = DateUtil.getDate(2004, 4, 1);
		

		// inclusive usage is not allowed in this case as per pan-Canadian specs
		assertNotNull("null", range);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
	
		assertEquals("low", lowDate, range.getLow());	
		assertEquals("centre", new Date(lowDate.getTime() + (highDate.getTime()-lowDate.getTime())/2), range.getCentre());
		assertEquals("high", highDate, range.getHigh());
		assertEquals("width", highDate.getTime()-lowDate.getTime(), range.getWidth().getValue().getTime());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
		assertTrue(range.getLowInclusive().booleanValue());
		assertTrue(range.getHighInclusive().booleanValue());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("URG<TS.DATE>", null, SpecificationVersion.R02_04_02, null, null, null, null, null, null);
	}
	
}
