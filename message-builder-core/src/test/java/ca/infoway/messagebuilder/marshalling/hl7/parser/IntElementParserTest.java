package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IntElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		
		INT parsedInt = (INT) new IntElementParser().parse(createContext(), node, this.xmlJavaResult);
		
		assertNull("null returned", parsedInt.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, parsedInt.getNullFlavor());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("Int", Integer.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}
	
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValid() throws Exception {
		Node node = createNode("<something value=\"1345\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidZero() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		assertEquals("correct value returned", new Integer("0"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidNegative() throws Exception {
		Node node = createNode("<something value=\"-1\" />");
		assertEquals("correct value returned", new Integer("-1"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"value\" value=\"1345\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseEmptyValue() throws Exception {
		Node node = createNode("<something value=\"\" />");
		assertEquals("correct value returned", null, new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
		assertFalse("error", this.xmlJavaResult.isValid());
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseElementWithTextNodes() throws Exception {
		Node node = createNode("<something value=\"3\" >\n</something>");
		assertEquals("correct value returned", new Integer(3), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new IntElementParser().parse(new TrivialContext("INT"), node, this.xmlJavaResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected INT node to have no children", e.getMessage());
		}
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new IntElementParser().parse(null, node, this.xmlJavaResult);
		assertFalse("error", this.xmlJavaResult.isValid());
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseValueAttributeValidIntgerWithDecimal() throws Exception {
		Node node = createNode("<something value=\"1345.000\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
		assertFalse("error", this.xmlJavaResult.isValid());
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseValueAttributeValidIntgerWithOtherDecimal() throws Exception {
		Node node = createNode("<something value=\"1345.999\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntElementParser().parse(null, node, this.xmlJavaResult).getBareValue());
		assertFalse("error", this.xmlJavaResult.isValid());
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
}