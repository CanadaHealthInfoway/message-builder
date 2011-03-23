package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetStringElementParserTest extends ParserTestCase {

	@Test
	@SuppressWarnings("unchecked")
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something>Fred</something>" +
				"<something>Wilma</something>" +
				"<something>Betty</something>" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<ST>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				null);
		Set<String> set = ((SET<ST,String>) result).rawSet();
		
		assertNotNull("null", set);
		assertEquals("size", 3, set.size());
		assertTrue("Fred", set.contains("Fred"));
		assertTrue("Wilma", set.contains("Wilma"));
		assertTrue("Betty", set.contains("Betty"));
	}
}
