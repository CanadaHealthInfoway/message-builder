package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RealElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		REAL real = (REAL) new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult);
		assertNull("null returned", real.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, real.getNullFlavor());
	}
	
	private ParseContext createContext(String type) {
		return ParserContextImpl.create(type, BigDecimal.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValid() throws Exception {
		Node node = createNode("<something value=\"0.2345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("0.2345"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidRealCoord() throws Exception {
		Node node = createNode("<something value=\"78.2345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("78.2345"), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidZero() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		assertEquals("correct value returned", 
				new BigDecimal(0), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidNegative() throws Exception {
		Node node = createNode("<something value=\"-1\" />");
		assertEquals("correct value returned", 
				new BigDecimal("-1"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}

	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"value\" value=\"1345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1345"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected REAL.CONF node to have no children", e.getMessage());
		}
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult);
		assertEquals("errors", 1, this.xmlJavaResult.getHl7Errors().size());
		assertEquals("error message", 
				"Value \"monkey\" of type REAL.CONF is not a valid number", 
				this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseInvalidValueAttribute1() throws Exception {
		Node node = createNode("<something value=\"1.11\" />");
		new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult);
		assertEquals("errors", 1, this.xmlJavaResult.getHl7Errors().size());
		assertEquals("error message", 
				"Value 1.11 of type REAL.CONF must be between 0 and 1.", 
				this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseInvalidValueAttribute2() throws Exception {
		Node node = createNode("<something value=\".11\" />");
		new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlJavaResult);
		assertEquals("errors", 0, this.xmlJavaResult.getHl7Errors().size());
	}
}
