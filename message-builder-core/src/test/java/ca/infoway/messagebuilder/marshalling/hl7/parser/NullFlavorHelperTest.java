package ca.infoway.messagebuilder.marshalling.hl7.parser;


import static org.junit.Assert.assertEquals;

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
		new NullFlavorHelper((ConformanceLevel)arguments[0], node, xmlToJavaResult).
			parseNullNode();
		assertEquals(arguments[1], xmlToJavaResult.getHl7Errors().isEmpty());
	}
	
	private Node createNode(String xml) throws SAXException {
		return new DocumentFactory().createFromString(xml).getDocumentElement();
	}

}
