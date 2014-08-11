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

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;


public class AnyR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void shouldParseStTextNodeAsCdata() throws Exception {
		Node node = createNode("<something xsi:type=\"ST\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><![CDATA[<cats think they're > humans & dogs 99% of the time/>]]></something>");
		ParseContext context = ParserContextImpl.create("ANY", Object.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.MANDATORY, null);
		BareANY parseResult = new AnyR2ElementParser().parse(context, node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertEquals(StandardDataType.ST, parseResult.getDataType());
		assertTrue("noted as cdata", ((ANYMetaData) parseResult).isCdata());
		assertEquals("proper text returned", 
				"<cats think they're > humans & dogs 99% of the time/>", 
				parseResult.getBareValue());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseAnyWithTypeInOuterElement() throws Exception {
		Node node = createNode(
				"<range xsi:type=\"IVL_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<low value=\"123\" unit=\"kg\" />" +
					"<high value=\"567\" unit=\"kg\" />" +
				"</range>");
		Interval<PhysicalQuantity> range = 
			(Interval<PhysicalQuantity>)new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.MANDATORY, null), 
				node, this.xmlResult).getBareValue();
		assertNotNull("null", range);
		assertTrue(this.xmlResult.isValid());
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseAnyIvlTypeInInnerElements() throws Exception {
		Node node = createNode(
				"<range xsi:type=\"IVL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<low xsi:type=\"PQ\" value=\"123\" unit=\"kg\" />" +
					"<high xsi:type=\"PQ\" value=\"567\" unit=\"kg\" />" +
				"</range>");
		
		BareANY parseResult = new AnyR2ElementParser().parse(
			ParserContextImpl.create("ANY", Object.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.MANDATORY, null), 
			node, this.xmlResult);
		Interval<PhysicalQuantity> range = (Interval<PhysicalQuantity>)parseResult.getBareValue();
		
		System.out.println(this.xmlResult.getHl7Errors());
		assertTrue(this.xmlResult.isValid());
		assertNotNull("null", range);
		assertEquals("type", StandardDataType.IVL_PQ, parseResult.getDataType());
	
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@Test
	public void testParseRetainsProperDatatype() throws Exception {
		Node node = createNode(
				"<value xsi:type=\"PQ\" value=\"80\" unit=\"pg/mL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		BareANY result = new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNotNull("null", result);
		assertEquals("type", StandardDataType.PQ, result.getDataType());
		
		
		assertNotNull("null", result.getBareValue());
	
		assertEquals("unit", "pg/mL", ((PhysicalQuantity) result.getBareValue()).getUnit().getCodeValue());
		assertEquals("unit", new BigDecimal(80), ((PhysicalQuantity) result.getBareValue()).getQuantity());
	}
	
	@Test
	public void testParseStWithLanguage() throws Exception {
		Node node = createNode(
				"<value xsi:type=\"ST\" language=\"fr-CA\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">some text</value>");
		
		BareANY result = new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNotNull("null", result);
		assertEquals("type", StandardDataType.ST, result.getDataType());
		
		
		assertNotNull("null", result.getBareValue());
	
		assertEquals("string", "some text", ((String) result.getBareValue()));
		assertEquals("language", "fr-CA", ((ANYImpl<?>) result).getLanguage());
	}
	
	@Test
	public void testParseWithMissingSpecializationType() throws Exception {
		Node node = createNode(
		"<value xsi:type=\"PQ\" value=\"80\" unit=\"pg/mL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		BareANY result = new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY.LAB", Object.class, null, null, null, ConformanceLevel.MANDATORY, null), 
				node, this.xmlResult);

		assertNotNull(result);
		assertNull(result.getBareValue());
		assertEquals("has error", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("error message", "Cannot support properties of type \"PQ\" for \"ANY.LAB\"", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testReportErrorForMissingSpecializationType() throws Exception {
		XmlToModelResult xmlResult = new XmlToModelResult();
		
		Node node = createNode(
		"<range><low value=\"123\" unit=\"m\" /><high value=\"567\" unit=\"HOUR\" /></range>");
		Object range = new AnyR2ElementParser().parse(null, node, xmlResult).getBareValue();
		
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
                "<value xsi:type=\"IVL_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
	                "<low value=\"0.0\" unit=\"pg/mL\"/>" + 
	                "<high value=\"0.5\" unit=\"pg/mL\"/>" +
                "</value>"
				);
		
		BareANY result = new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				node, new XmlToModelResult());
		
		assertNotNull("null", result);
		assertEquals("type", StandardDataType.IVL_PQ, result.getDataType());  
		
		assertNotNull("null", result.getBareValue());
	
		Interval<PhysicalQuantity> interval = (Interval<PhysicalQuantity>) result.getBareValue();
		assertEquals("low unit", "pg/mL", interval.getLow().getUnit().getCodeValue());
		assertEquals("low quantity", new BigDecimal(0).setScale(1), interval.getLow().getQuantity());
		assertEquals("high unit", "pg/mL", interval.getHigh().getUnit().getCodeValue());
		assertEquals("high quantity", new BigDecimal(0.5), interval.getHigh().getQuantity());
	}
	
//	@Test
//	public void testParseCdWithAllMetadata() throws Exception {
//		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" displayName=\"a display name\" specializationType=\"CD.LAB\">" +
//				"<originalText>some original text</originalText>" +
//				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
//				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
//				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" />" +
//				"<translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\" /></something>");
//		
//		BareANY cdAny = new AnyR2ElementParser().parse(
//				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
//				node, this.xmlResult);
//
//		assertTrue(this.xmlResult.isValid());
//		assertNotNull(cdAny.getBareValue());
//		assertTrue(cdAny.getBareValue() instanceof Code);
//		
//        Code value = (Code) cdAny.getBareValue();
//		assertNotNull("main enum found", value);
//		assertEquals("main code", "BARNEY", value.getCodeValue());
//		
//		ANYMetaData cd = (ANYMetaData) cdAny;
//		assertFalse("translation enums found", cd.getTranslations().isEmpty());
//		assertTrue("translation enums found", cd.getTranslations().size() == 4);
//		assertEquals("error message count", 0, this.xmlResult.getHl7Errors().size());
//		assertEquals("translation", "FRED", cd.getTranslations().get(0).getValue().getCodeValue());
//		assertEquals("translation", "WILMA", cd.getTranslations().get(1).getValue().getCodeValue());
//		assertEquals("translation", "BETTY", cd.getTranslations().get(2).getValue().getCodeValue());
//		assertEquals("translation", "BAM_BAM", cd.getTranslations().get(3).getValue().getCodeValue());
//	}
//	
//	@Test
//	public void testParseCdWithNullFlavorAndMetaData() throws Exception {
//		Node node = createNode("<something nullFlavor=\"UNK\" specializationType=\"CD.LAB\">" +
//				"<originalText>some original text</originalText>" +
//				"</something>");
//		
//		BareANY cdAny = new AnyR2ElementParser().parse(
//				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null), 
//				node, this.xmlResult);
//
//		assertTrue(this.xmlResult.isValid());
//		assertNull(cdAny.getBareValue());
//		assertEquals(NullFlavor.UNKNOWN, cdAny.getNullFlavor());
//		
//		ANYMetaData cd = (ANYMetaData) cdAny;
//		assertEquals("some original text", cd.getOriginalText());
//	}
	
	@Test
	public void testParsePqWithNullFlavor() throws Exception {
		Node node = createNode("<something nullFlavor=\"ASKU\" xsi:type=\"PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" />");
		
		BareANY pqAny = new AnyR2ElementParser().parse(
				ParserContextImpl.create("ANY", Object.class, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.POPULATED, null), 
				node, this.xmlResult);

		assertTrue(this.xmlResult.isValid());
		assertNull(pqAny.getBareValue());
		assertEquals(NullFlavor.ASKED_BUT_UNKNOWN, pqAny.getNullFlavor());
	}
	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testParseAnyAsRtoPqPq() throws Exception {
//		// only ANY (i.e. no ANY sub-variants) supports RTO
//		// note that this test is not correct in the way it specifies ST and XT
//		Node node = createNode("<something specializationType=\"RTO_PQ.DRUG_PQ.DRUG\" xsi:type=\"RTO_PQ_PQ\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><numerator value=\"1234.45\" unit=\"mg\"/><denominator value=\"2345.67\" unit=\"mL\" /></something>");
//		ParseContext context = ParserContextImpl.create("ANY", Object.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.MANDATORY, null);
//		
//		Object anyResult = new AnyR2ElementParser().parse(context, node, this.xmlResult).getBareValue();
//		
//		assertTrue(this.xmlResult.isValid());
//        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) anyResult;
//        
//        assertNotNull("ratio", ratio);
//        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator().getQuantity());
//        assertEquals("numerator unit", MILLIGRAM.getCodeValue(), ratio.getNumerator().getUnit().getCodeValue());
//        assertEquals("denominator", new BigDecimal("2345.67"), ratio.getDenominator().getQuantity());
//        assertEquals("denominator unit", MILLILITRE.getCodeValue(), ratio.getDenominator().getUnit().getCodeValue());
//	}
	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testParseAnyWithSpecializationTypeInOuterElement() throws Exception {
//		Node node = createNode(
//				"<range xsi:type=\"URG_PQ\" specializationType=\"URG_PQ.BASIC\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
//					"<low value=\"123\" unit=\"kg\" />" +
//					"<high value=\"567\" unit=\"kg\" />" +
//				"</range>");
//		UncertainRange<PhysicalQuantity> range = 
//			(UncertainRange<PhysicalQuantity>)new AnyR2ElementParser().parse(
//				ParserContextImpl.create("ANY.LAB", Object.class, SpecificationVersion.R02_04_02, null, null, ConformanceLevel.MANDATORY, null), 
//				node, this.xmlResult).getBareValue();
//		assertNotNull("null", range);
//		assertTrue(this.xmlResult.isValid());
//		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
//		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
//		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
//		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
//		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
//	}
	
}
