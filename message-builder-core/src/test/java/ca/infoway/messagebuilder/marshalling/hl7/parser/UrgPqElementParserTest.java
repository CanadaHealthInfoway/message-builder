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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.domainvalue.x_LabUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;

public class UrgPqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" unit=\"kg\" /><high value=\"567\" unit=\"kg\" /></range>");
		
		@SuppressWarnings("unchecked")
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
		assertNull(range.getLowInclusive());
		assertNull(range.getHighInclusive());
	}
	
	@Test
	public void testParseWithInclusive() throws Exception {
		Node node = createNode(
				"<range><low inclusive=\"true\" value=\"123\" unit=\"kg\" /><high inclusive=\"false\" value=\"567\" unit=\"kg\" /></range>");
		
		@SuppressWarnings("unchecked")
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
		assertTrue(range.getLowInclusive().booleanValue());
		assertFalse(range.getHighInclusive().booleanValue());
	}

	@Test
	public void testParseUrgForBC() throws Exception {
		ParseContext context = ParseContextImpl.create("URG<PQ.LAB>", null, SpecificationVersion.V02R04_BC, null, null, null, null, null, null, null, false);
		
		String xml = "<value specializationType=\"URG_PQ.LAB\" unit=\"1\" xsi:type=\"URG_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
						 + "<originalText mediaType=\"text/plain\" representation=\"TXT\">&lt;124</originalText>"
						 + "<low inclusive=\"true\" nullFlavor=\"NI\" specializationType=\"PQ.LAB\" value=\"1\" />"
						 + "<high inclusive=\"false\" specializationType=\"PQ.LAB\" unit=\"g/L\" value=\"124\"/>"
				   + "</value>";
		
		Node node = createNode(xml);
		
		BareANY URG = new UrgPqElementParser().parse(context, node, this.xmlResult);
		@SuppressWarnings("unchecked")
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) URG.getBareValue();
		
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
		
		assertEquals("OT", "<124", ((ANYMetaData) URG).getOriginalText());

		assertTrue("low inclusive", range.getLowInclusive().booleanValue());
		assertEquals("low NF", NullFlavor.NO_INFORMATION, range.getLowNullFlavor());
		assertEquals("low value", BigDecimal.ONE, range.getLow().getQuantity());
		assertNull("low unit", range.getLow().getUnit());
		
		assertFalse("high inclusive", range.getHighInclusive().booleanValue());
		assertNull("high NF", range.getHighNullFlavor());
		assertEquals("high value", new BigDecimal("124"), range.getHigh().getQuantity());
		assertEquals("high units", "g/L", range.getHigh().getUnit().getCodeValue());
		assertTrue(range.getHigh().getUnit() instanceof x_LabUnitsOfMeasure);
	}
	
	@Test
	public void testParseUrgForBCAlt() throws Exception {
		ParseContext context = ParseContextImpl.create("URG<PQ.LAB>", null, SpecificationVersion.V02R04_BC, null, null, null, null, null, null, null, false);
		
		String xml = "<value specializationType=\"URG_PQ.LAB\" unit=\"1\" xsi:type=\"URG_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
						 + "<originalText mediaType=\"text/plain\" representation=\"TXT\">&lt;124</originalText>"
						 + "<low inclusive=\"true\" nullFlavor=\"NI\" specializationType=\"PQ.LAB\" unit=\"1\" />"
						 + "<high inclusive=\"false\" specializationType=\"PQ.LAB\" unit=\"g/L\" value=\"124\"/>"
				   + "</value>";
		
		Node node = createNode(xml);
		
		BareANY URG = new UrgPqElementParser().parse(context, node, this.xmlResult);
		@SuppressWarnings("unchecked")
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) URG.getBareValue();
		
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
		
		assertEquals("OT", "<124", ((ANYMetaData) URG).getOriginalText());

		assertTrue("low inclusive", range.getLowInclusive().booleanValue());
		assertEquals("low NF", NullFlavor.NO_INFORMATION, range.getLowNullFlavor());
		assertNull("low value", range.getLow().getQuantity());
		assertEquals("low unit", "1", range.getLow().getUnit().getCodeValue());
		assertNull("low unit", range.getLow().getUnit().getCodeSystem());
		
		assertFalse("high inclusive", range.getHighInclusive().booleanValue());
		assertNull("high NF", range.getHighNullFlavor());
		assertEquals("high value", new BigDecimal("124"), range.getHigh().getQuantity());
		assertEquals("high units", "g/L", range.getHigh().getUnit().getCodeValue());
		assertTrue(range.getHigh().getUnit() instanceof x_LabUnitsOfMeasure);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReportError() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" unit=\"m\" /><high value=\"567\" unit=\"h\" /></range>");
		
		UncertainRange<PhysicalQuantity> range = null; 
		
		try {
			range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
			fail("Should fail trying to add quantities of different units");
		} catch(IllegalArgumentException e) {
			// expected
			assertEquals("syntax error", 
					"Can't add two quantities of different units: m and h",
					e.getMessage());
		}
		
		assertNull("null", range);
	}

	private ParseContext createContext() {
		return ParseContextImpl.create("URG<PQ.BASIC>", null, SpecificationVersion.R02_04_02, null, null, null, null, null, null, null, false);
	}
	
}
