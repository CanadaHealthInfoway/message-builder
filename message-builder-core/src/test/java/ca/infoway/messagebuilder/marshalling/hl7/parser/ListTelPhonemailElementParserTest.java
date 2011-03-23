package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;

public class ListTelPhonemailElementParserTest extends ParserTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something value=\"mailto://Fred\"/>" +
				"<something value=\"mailto://Wilma\"/>" +
				"</top>");
		
		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02.getVersionLiteral(), null), 
				asList(node.getChildNodes()), null);
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		
		Set<String> expectedStrings = new HashSet<String>();
		expectedStrings.add("Fred");
		expectedStrings.add("Wilma");
		
		for (TelecommunicationAddress address : list) {
			assertEquals("urlscheme", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
			assertTrue("expected set contains address", expectedStrings.contains(address.getAddress()));
			expectedStrings.remove(address.getAddress());
		}
	}
}
