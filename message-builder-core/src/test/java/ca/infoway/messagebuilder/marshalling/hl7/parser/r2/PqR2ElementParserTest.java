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
 * Last modified: $LastChangedDate: 2013-10-22 09:43:15 -0400 (Tue, 22 Oct 2013) $
 * Revision:      $LastChangedRevision: 7996 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

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
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.X_DistanceObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.basic.X_HeightOrWeightObservationUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;

public class PqR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PQ pq = (PQ) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("PhysicalQuantity", pq.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pq.getNullFlavor());
	}

	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, PhysicalQuantity.class, version, null, null, null, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertNull("quantity", physicalQuantity.getQuantity());
		assertEquals("unit", "1", physicalQuantity.getUnit().getCodeValue());
	}

	@Test
	public void testParseNoCorrectAttributeNodes() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertNull("quantity", physicalQuantity.getQuantity());
		assertEquals("unit", "1", physicalQuantity.getUnit().getCodeValue());
	}

	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesWithTranslation() throws Exception {
		Node node = createNode(
				"<something value=\"1234.45\" unit=\"kg\">" +
					"<translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/>" +
					"<translation code=\"active\" codeSystem=\"2.16.840.1.113883.5.14\"/>" +
				"</something>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		assertEquals(2, physicalQuantity.getTranslation().size());
		assertEquals("M", physicalQuantity.getTranslation().get(0).getCodeValue());
		assertEquals("2.16.840.1.113883.5.1", physicalQuantity.getTranslation().get(0).getCodeSystem());
		assertEquals("active", physicalQuantity.getTranslation().get(1).getCodeValue());
		assertEquals("2.16.840.1.113883.5.14", physicalQuantity.getTranslation().get(1).getCodeSystem());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorNotAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1234.45\" unit=\"kg\" />");
		BareANY pqAny = new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) pqAny.getBareValue();
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		assertNull("no operator", ((ANYMetaData) pqAny).getOperator());
		assertFalse(this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1234.45\" unit=\"kg\" />");
		BareANY pqAny = new PqR2ElementParser().parse(createContext("SXCM<PQ>", V02R02), node, this.xmlResult);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) pqAny.getBareValue();
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.PERIODIC_HULL, ((ANYMetaData) pqAny).getOperator());
	}
	
	@Test
	public void testParseValueAttributeValidWithDefaultOperator() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		BareANY pqAny = new PqR2ElementParser().parse(createContext("SXCM<PQ>", V02R02), node, this.xmlResult);
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) pqAny.getBareValue();
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.INCLUDE, ((ANYMetaData) pqAny).getOperator());
	}

	@Test
	public void testParseValidAttributesWithDifferentUnitsAndTypes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", UnitsOfMeasureCaseSensitive.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"mg\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_DrugUnitsOfMeasure.MILLIGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", DefaultTimeUnit.MONTH.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"[lb_av]\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_HeightOrWeightObservationUnitsOfMeasure.POUND.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"km\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", X_DistanceObservationUnitsOfMeasure.KILOMETER.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"any_units\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("unit", physicalQuantity.getUnit());
		this.xmlResult.clearErrors();
	}
	
	@Test
	public void testParseInvalidAttributesWithDifferentUnitsAndTypes() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"xyzabc\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNull("unit", physicalQuantity.getUnit());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"mo\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", UnitsOfMeasureCaseSensitive.MONTH, physicalQuantity.getUnit());
		this.xmlResult.clearErrors();
		
		node = createNode("<something value=\"1234.45\" unit=\"kg\" />");
		physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("unit", UnitsOfMeasureCaseSensitive.KILOGRAM, physicalQuantity.getUnit());
		this.xmlResult.clearErrors();
	}
	
	@Test
	public void testParseValue() throws Exception {
		Node node = createNode("<something value=\"-1234.45\" unit=\"kg\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("-1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesWithElementClosure() throws Exception {
		Node node = createNode("<something value=\"1234.45\" unit=\"kg\"></something>");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("quantity", new BigDecimal("1234.45"), physicalQuantity.getQuantity());
		assertEquals("unit", CeRxDomainTestValues.KILOGRAM.getCodeValue(), physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseValidAttributesNoUnit() throws Exception {
		Node node = createNode("<something value=\"1234.45\" />");
		PhysicalQuantity physicalQuantity = (PhysicalQuantity) new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PhysicalQuantity", physicalQuantity);
		assertEquals("value", "1234.45", physicalQuantity.getQuantity().toString());
		assertEquals("unit", "1", physicalQuantity.getUnit().getCodeValue());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new PqR2ElementParser().parse(createContext("PQ", V02R02), node, this.xmlResult);
		assertFalse("result", this.xmlResult.isValid());
	}
	
}
