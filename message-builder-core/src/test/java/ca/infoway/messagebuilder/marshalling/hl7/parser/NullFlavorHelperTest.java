package ca.infoway.messagebuilder.marshalling.hl7.parser;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class NullFlavorHelperTest {
	
	public static final Object[] POPULATED = {ConformanceLevel.POPULATED, true}; 
	public static final Object[] MANDATORY = {ConformanceLevel.MANDATORY, false}; 
	public static final Object[] REQUIRED = {ConformanceLevel.REQUIRED, false}; 

	@Test
	public void testConformanceHandlingForNullFlavorIsErrorFree() throws Exception {
		assertConformance(POPULATED);
		assertConformance(MANDATORY);
		assertConformance(REQUIRED);
	}

	private void assertConformance(Object[] arguments) throws SAXException {
		Node node = createNode("<effectiveTime><low nullFlavor=\"NI\"/></effectiveTime>");
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		new NullFlavorHelper((ConformanceLevel)arguments[0], node, xmlToJavaResult, false).
			parseNullNode();
		assertEquals(arguments[1], xmlToJavaResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void shouldHandleXsiNilAttributeForAssociation() throws SAXException {
		Node node = createNode("<patient nullFlavor=\"NI\" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		new NullFlavorHelper(ConformanceLevel.POPULATED, node, xmlToJavaResult, true).
			parseNullNode();
		assertTrue(xmlToJavaResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void shouldCatchXsiNilAttributeErrorForAssociation() throws SAXException {
		Node node = createNode("<patient nullFlavor=\"NI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		new NullFlavorHelper(ConformanceLevel.POPULATED, node, xmlToJavaResult, true).
			parseNullNode();
		assertFalse(xmlToJavaResult.getHl7Errors().isEmpty());
		assertEquals(1, xmlToJavaResult.getHl7Errors().size());
		assertTrue(xmlToJavaResult.getHl7Errors().get(0).getMessage().contains("does not specify xsi:nil=\"true\""));
	}
	
	private Node createNode(String xml) throws SAXException {
		return new DocumentFactory().createFromString(xml).getDocumentElement();
	}

}
