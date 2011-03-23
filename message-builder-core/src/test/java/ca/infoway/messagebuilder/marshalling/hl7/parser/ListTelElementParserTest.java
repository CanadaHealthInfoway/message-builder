package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ListTelElementParserTest extends ParserTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top><telecom value=\"tel:+1-519-555-2345;ext=12345\"/>" + 
				                    "<telecom value=\"tel:+1-416-555-2345;ext=12345\"/></top>");

		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL>", null, SpecificationVersion.V02R02.getVersionLiteral(), null), 
				asList(node.getChildNodes()), null);
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		TelecommunicationAddress phone1 = list.get(0);
		TelecommunicationAddress phone2 = list.get(1);
		assertEquals("+1-519-555-2345;ext=12345", phone1.getAddress());
		assertEquals("+1-416-555-2345;ext=12345", phone2.getAddress());
	}
}
