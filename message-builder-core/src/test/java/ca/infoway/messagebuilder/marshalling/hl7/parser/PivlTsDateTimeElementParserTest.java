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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;

public class PivlTsDateTimeElementParserTest extends MarshallingTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode(
				"<periodicInterval><frequency><numerator value=\"3\"/><denominator value=\"1\" unit=\"d\"/></frequency></periodicInterval>");

		PeriodicIntervalTime pivl = (PeriodicIntervalTime) new PivlTsDateTimeElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertTrue(this.xmlResult.isValid());
		assertNull(pivl.getOperator());
		assertNull(pivl.getPeriod());
		assertNull(pivl.getPhase());
		assertNull(pivl.getValue());
		
		assertEquals(Representation.FREQUENCY, pivl.getRepresentation());
		assertEquals("qty", new BigDecimal("1"), pivl.getQuantity().getQuantity());
		assertEquals("units", "d", pivl.getQuantity().getUnit().getCodeValue());
		assertEquals("reps", (Integer) 3, pivl.getRepetitions());
	}

	@Test
	public void testParseFailsWithMissingElements() throws Exception {
		Node node = createNode(
				"<periodicInterval><frequency></frequency></periodicInterval>");

		PeriodicIntervalTime pivl = (PeriodicIntervalTime) new PivlTsDateTimeElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNull("null", pivl);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseFailsWithEmptyElements() throws Exception {
		Node node = createNode(
				"<periodicInterval><frequency><numerator/><denominator/></frequency></periodicInterval>");

		PeriodicIntervalTime pivl = (PeriodicIntervalTime) new PivlTsDateTimeElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", pivl);
		assertNull(pivl.getRepetitions());
		assertNull(pivl.getQuantity());
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("PIVL<TS.DATETIME>", null, SpecificationVersion.R02_04_02, null, null, null, null, null);
	}
	
}
