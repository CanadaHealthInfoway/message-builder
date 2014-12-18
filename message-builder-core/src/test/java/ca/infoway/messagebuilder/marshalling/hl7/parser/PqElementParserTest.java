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

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_03;
import static ca.infoway.messagebuilder.SpecificationVersion.V01R04_3;
import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.X_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;

public class PqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PQ pq = (PQ) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("PhysicalQuantity", pq.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pq.getNullFlavor());
	}

	@Test
	public void testParseNullNodeForPqLab() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PQ pq = (PQ) new PqElementParser().parse(createContext("PQ.LAB", V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("PhysicalQuantity", pq.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pq.getNullFlavor());
	}

	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, PhysicalQuantity.class, version, null, null, null, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("PhysicalQuantity", physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
	}

	@Test
	public void testParseNoCorrectAttributeNodes() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("PhysicalQuantity", physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
	}

	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesWithDifferentUnitsAndTypes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", UnitsOfMeasureCaseSensitive.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		
		node = createNode("<something value=\"1234.45\" unit=\"mg\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DRUG", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_DrugUnitsOfMeasure.MILLIGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.TIME", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", DefaultTimeUnit.MONTH.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		
		node = createNode("<something value=\"1234.45\" unit=\"[lb_av]\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.HEIGHTWEIGHT", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_HeightOrWeightObservationUnitsOfMeasure.POUND.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		
		node = createNode("<something value=\"1234.45\" unit=\"km\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DISTANCE", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_DistanceObservationUnitsOfMeasure.KILOMETER.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		
		node = createNode("<something value=\"1234.45\" unit=\"any_units\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.LAB", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", "any_units", physicalQuantity.getUnit().getCodeValue());  // no MB-provided enum for units; code lookup will allow any value
	}
	
	@Test
	public void testParseInvalidAttributesWithDifferentUnitsAndTypes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"xyzabc\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DRUG", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		
		node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.TIME", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.HEIGHTWEIGHT", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DISTANCE", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		
	}
	
	@Test
	public void testParseInvalidValue() throws Exception {
		Node node = createNode("<something value=\"-1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("-1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesWithElementClosure() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\"></something>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesNoUnit() throws Exception {
		Node node = createNode("<something value=\"1234.45\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertNotNull("value", physicalQuantity.getQuantity());
		assertNull("value", physicalQuantity.getUnit());
		assertTrue("result", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult);
		assertFalse("result", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseTooManyIntegerDigitsValueAttribute() throws Exception {
		String element = "<something value=\"123456789012.12\" unit=\"kg\"/>";
		Node node = createNode(element);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertNotNull(physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity for MR2007/PQ.BASIC can contain a maximum of 11 integer places (<something unit=\"kg\" value=\"123456789012.12\"/>)", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseTooManyIntegerDigitsValueAttributeForCeRx() throws Exception {
		String element = "<something value=\"123456789.12\" unit=\"kg\"/>";
		Node node = createNode(element);
		
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());

		// CeRx only allows 8 digits before the decimal 
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V01R04_3), node, this.xmlResult).getBareValue();
		assertNotNull(physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity for CERX/PQ.BASIC can contain a maximum of 8 integer places (<something unit=\"kg\" value=\"123456789.12\"/>)", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseTooManyDecimalDigitsValueAttribute() throws Exception {
		String element = "<something value=\"12345678901.1234\" unit=\"kg\"/>";
		Node node = createNode(element);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.BASIC", V02R02), node, this.xmlResult).getBareValue();
		assertNotNull(physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity for MR2007/PQ.BASIC can contain a maximum of 2 decimal places (<something unit=\"kg\" value=\"12345678901.1234\"/>)", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseTooManyDecimalDigitsValueAttributeForPQDRUG() throws Exception {
		String element = "<something value=\"12345678901.1234\" unit=\"kg\"/>";
		Node node = createNode(element);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DRUG", R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue("result", this.xmlResult.isValid());
		
		element = "<something value=\"12345678901.12345\" unit=\"kg\"/>";
		node = createNode(element);
		physicalQuantity = (PhysicalQuantity) new PqElementParser().parse(createContext("PQ.DRUG", R02_04_03), node, this.xmlResult).getBareValue();
		assertNotNull(physicalQuantity);
		assertFalse("result", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("PhysicalQuantity for MR2009/PQ.DRUG can contain a maximum of 4 decimal places (<something unit=\"kg\" value=\"12345678901.12345\"/>)", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
}
