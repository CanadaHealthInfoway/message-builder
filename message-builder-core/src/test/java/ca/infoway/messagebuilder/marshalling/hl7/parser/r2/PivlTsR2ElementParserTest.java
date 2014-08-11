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
 * Last modified: $LastChangedDate: 2012-07-25 20:18:41 -0300 (Wed, 25 Jul 2012) $
 * Revision:      $LastChangedRevision: 5990 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

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
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.util.CalendarCycle;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;

public class PivlTsR2ElementParserTest extends MarshallingTestCase {
	
	@Test
	public void testParseFull() throws Exception {
		Date lowDate = DateUtil.getDate(1999, 0, 23);
		Date highDate = DateUtil.getDate(2013, 4, 7);

		Node node = createNode(
				"<periodicInterval alignment=\"D\" institutionSpecified=\"true\"><phase><low value=\"19990123\"/><high value=\"20130507\"/></phase><period unit=\"d\" value=\"11\"/></periodicInterval>");

		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) new PivlTsR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertTrue(this.xmlResult.isValid());
		
		assertEquals(CalendarCycle.DAY_OF_THE_MONTH, pivl.getAlignment());
		assertTrue(pivl.getInstitutionSpecified());
		assertEquals(lowDate, pivl.getPhase().getLow());
		assertEquals(highDate, pivl.getPhase().getHigh());
		assertEquals(new BigDecimal(11), pivl.getPeriod().getQuantity());
		assertEquals("d", pivl.getPeriod().getUnit().getCodeValue());
	}

	@Test
	public void testParseEmpty() throws Exception {
		Node node = createNode(
				"<periodicInterval/>");

		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) new PivlTsR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertTrue(this.xmlResult.isValid());
		
		assertNull(pivl.getAlignment());
		assertFalse(pivl.getInstitutionSpecified());
		assertNull(pivl.getPhase());
		assertNull(pivl.getPeriod());
	}

	@Test
	public void testParseNullFlavor() throws Exception {
		Node node = createNode(
				"<periodicInterval nullFlavor=\"NAV\"/>");

		BareANY pivlTsAny = new PivlTsR2ElementParser().parse(createContext(), node, this.xmlResult);
		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) pivlTsAny.getBareValue();
		
		assertNull(pivl);
		assertTrue(this.xmlResult.isValid());
		assertEquals(NullFlavor.TEMPORARILY_UNAVAILABLE, pivlTsAny.getNullFlavor());
	}

	@Test
	public void testParseFailsInvalidAlignment() throws Exception {
		Node node = createNode(
				"<periodicInterval alignment=\"INVALIDVALUE\"/>");

		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) new PivlTsR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("CalendarCycle"));
		
		assertNull(pivl.getAlignment());
		assertFalse(pivl.getInstitutionSpecified());
		assertNull(pivl.getPhase());
		assertNull(pivl.getPeriod());
	}

	@Test
	public void testParseFailsInvalidInstitutionSpecified() throws Exception {
		Node node = createNode(
				"<periodicInterval institutionSpecified=\"NOTABOOLEAN\"/>");

		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) new PivlTsR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("institutionSpecified"));
		
		assertNull(pivl.getAlignment());
		assertFalse(pivl.getInstitutionSpecified());
		assertNull(pivl.getPhase());
		assertNull(pivl.getPeriod());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("PIVL<TS>", null, SpecificationVersion.R02_04_02, null, null, null, null, null, null);
	}
	
}
