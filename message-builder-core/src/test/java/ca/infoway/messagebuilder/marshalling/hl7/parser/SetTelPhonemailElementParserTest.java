package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetTelPhonemailElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something value=\"mailto://Fred\"/>" +
				"<something value=\"mailto://Wilma\"/>" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				null);
		Set<TelecommunicationAddress> set = ((SET<TEL,TelecommunicationAddress>) result).rawSet();
		assertNotNull("null", set);
		assertEquals("size", 2, set.size());
		
		Set<String> expectedStrings = new HashSet<String>();
		expectedStrings.add("Fred");
		expectedStrings.add("Wilma");
		
		for (TelecommunicationAddress address : set) {
			assertEquals("urlscheme", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
			assertTrue("expected set contains address", expectedStrings.contains(address.getAddress()));
			expectedStrings.remove(address.getAddress());
		}
	}
}
