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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;


public class AnyElementParserTest extends CeRxDomainValueTestCase {

	@SuppressWarnings("unchecked")
	@Test
	public void testParse() throws Exception {
		Node node = createNode(
				"<range xsi:type=\"URG\" specializationType=\"URG_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<low value=\"123\" unit=\"kg\" />" +
					"<high value=\"567\" unit=\"kg\" />" +
				"</range>");
		UncertainRange<PhysicalQuantity> range = 
			(UncertainRange<PhysicalQuantity>)new AnyElementParser().parse(
				ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY), 
				node, null).getBareValue();
		assertNotNull("null", range);
	
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseAbsentSpecializationTypeUrgExampleFromChiDocs() throws Exception {
		Node node = createNode(
				"<range xsi:type=\"URG_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<low xsi:type=\"PQ\" specializationType=\"PQ.HEIGHTWEIGHT\" value=\"123\" unit=\"kg\" />" +
					"<high xsi:type=\"PQ\" specializationType=\"PQ.HEIGHTWEIGHT\" value=\"567\" unit=\"kg\" />" +
				"</range>");
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		BareANY parseResult = new AnyElementParser().parse(
			ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY), 
			node, xmlToModelResult);
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>)parseResult.getBareValue();
		
		assertTrue("no errors", xmlToModelResult.getHl7Errors().isEmpty());
		assertNotNull("null", range);
		assertEquals("type", StandardDataType.URG_PQ, parseResult.getDataType());
	
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@Test
	public void testParseRetainsProperDatatype() throws Exception {
		Node node = createNode(
				"<value xsi:type=\"PQ\" specializationType=\"PQ.LAB\" value=\"80\" unit=\"mg/dL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		BareANY result = new AnyElementParser().parse(
				ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY), 
				node, null);
		
		assertNotNull("null", result);
		assertEquals("type", StandardDataType.PQ_LAB, result.getDataType());
		
		
		assertNotNull("null", result.getBareValue());
	
		assertEquals("unit", "mg/dL", ((PhysicalQuantity) result.getBareValue()).getUnit().getCodeValue());
		assertEquals("unit", new BigDecimal(80), ((PhysicalQuantity) result.getBareValue()).getQuantity());
	}
	
	@Test
	public void testParseWithMissingSpecializationType() throws Exception {
		Node node = createNode(
		"<value xsi:type=\"PQ\" value=\"80\" unit=\"mg/dL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		BareANY result = new AnyElementParser().parse(
				ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY), 
				node, xmlToModelResult);

		assertNotNull(result);
		assertNull(result.getBareValue());
		assertEquals("has error", 1, xmlToModelResult.getHl7Errors().size());
		assertEquals("error message", "Cannot support properties of type \"PQ\" for \"ANY.LAB\"", xmlToModelResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testReportErrorForMissingSpecializationType() throws Exception {
		XmlToModelResult xmlResult = new XmlToModelResult();
		
		Node node = createNode(
		"<range><low value=\"123\" unit=\"m\" /><high value=\"567\" unit=\"HOUR\" /></range>");
		Object range = new AnyElementParser().parse(null, node, xmlResult).getBareValue();
		
		assertNull("null", range);
		assertFalse("has error", xmlResult.getHl7Errors().isEmpty());
		assertEquals("error", 
				Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
				xmlResult.getHl7Errors().get(0).getHl7ErrorCode());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseRetainsProperDatatypeForSpecializationTypeWhenAnyOnlySpecifiesOkToUseAbstractType() throws Exception {
		Node node = createNode(
                "<value xsi:type=\"IVL_PQ\" specializationType=\"IVL_PQ.LAB\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
	                "<low specializationType=\"PQ.LAB\" value=\"0.0\" unit=\"mg/dL\"/>" + 
	                "<high specializationType=\"PQ.LAB\" value=\"0.5\" unit=\"mg/dL\"/>" +
                "</value>"
				);
		
		BareANY result = new AnyElementParser().parse(
				ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY), 
				node, null);
		
		assertNotNull("null", result);
		assertEquals("type", StandardDataType.IVL_PQ, result.getDataType());
		
		assertNotNull("null", result.getBareValue());
	
		Interval<PhysicalQuantity> interval = (Interval<PhysicalQuantity>) result.getBareValue();
		assertEquals("low unit", "mg/dL", interval.getLow().getUnit().getCodeValue());
		assertEquals("low quantity", new BigDecimal(0).setScale(1), interval.getLow().getQuantity());
		assertEquals("high unit", "mg/dL", interval.getHigh().getUnit().getCodeValue());
		assertEquals("high quantity", new BigDecimal(0.5), interval.getHigh().getQuantity());
	}
	
}
