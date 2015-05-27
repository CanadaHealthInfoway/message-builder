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
 * Last modified: $LastChangedDate: 2014-05-22 15:54:32 -0400 (Thu, 22 May 2014) $
 * Revision:      $LastChangedRevision: 8676 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RtoPqPqR2ElementParserTest extends CeRxDomainValueTestCase {

	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		RTO<PhysicalQuantity, PhysicalQuantity> rto = (RTO<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNull("value", rto.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, rto.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParseContextImpl.create("RTO<PQ,PQ>", Ratio.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("Numerator is mandatory"));
		assertTrue(this.xmlResult.getHl7Errors().get(1).getMessage().contains("Denominator is mandatory"));
		assertNotNull("ratio", ratio);
		assertNull("numerator", ratio.getNumerator());
		assertNull("denominator", ratio.getDenominator());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something xsi:type=\"RTO_PQ_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><numerator value=\"1234.45\" unit=\"mg\"/><denominator value=\"2345.67\" unit=\"mL\" /></something>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertTrue(this.xmlResult.isValid());
        assertNotNull("ratio", ratio);
        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator().getQuantity());
        assertEquals("numerator unit", MILLIGRAM.getCodeValue(), ratio.getNumerator().getUnit().getCodeValue());
        assertEquals("denominator", new BigDecimal("2345.67"), ratio.getDenominator().getQuantity());
        assertEquals("denominator unit", MILLILITRE.getCodeValue(), ratio.getDenominator().getUnit().getCodeValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseValuesDefaultProperly() throws Exception {
		Node node = createNode("<something><numerator/><denominator/></something>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertTrue(this.xmlResult.isValid());
        assertNotNull("ratio", ratio);
        assertNull("numerator", ratio.getNumerator());
        assertNull("denominator", ratio.getDenominator());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseErrorIfDenominatorZero() throws Exception {
		Node node = createNode("<something><numerator value=\"1234.45\" unit=\"mg\"/><denominator value=\"0\" unit=\"mL\" /></something>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("Denominator value can not be zero."));
        assertNotNull("ratio", ratio);
        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator().getQuantity());
        assertEquals("numerator unit", MILLIGRAM.getCodeValue(), ratio.getNumerator().getUnit().getCodeValue());
        assertEquals("denominator", new BigDecimal("0"), ratio.getDenominator().getQuantity());
        assertEquals("denominator unit", MILLILITRE.getCodeValue(), ratio.getDenominator().getUnit().getCodeValue());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something><numerator value=\"monkey\" /><denominator value=\"2345.67\" /></something>");
		new RtoPqPqR2ElementParser().parse(createContext(), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
	}
}
