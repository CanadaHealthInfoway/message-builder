package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class ListErrorElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
		Node node = createNode("<top><name>Fred</name>" + 
				                    "<name>Flinstone</name></top>");
		new ListElementParser().parse(
				ParserContextImpl.create("LIST<ABCDEFGHIJKLMNOPQRSTUVWXYZ>", null, SpecificationVersion.V02R02.getVersionLiteral(), null), 
				asList(node.getChildNodes()), result);
		
		assertFalse("valid", result.isValid());
		for (Hl7Error error : result.getHl7Errors()) {
			System.out.println(error);
		}
	}
}
