package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * @sharpen.ignore - test - translated manually 
 */
public class SetIiElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"rootValue\" extension=\"fred\" />" +
				"<something root=\"rootValue2\" extension=\"extensionValue\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), null);
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertNotNull("null", rawSet);
		assertEquals("size", 2, rawSet.size());
		assertThat(rawSet, hasItem(new Identifier("rootValue", "fred")));
		assertThat(rawSet, hasItem(new Identifier("rootValue2", "extensionValue")));
	}

	@Test
	public void rawValueCanBeAddedToParsedValue() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.1\" extension=\"fred\" use=\"BUS\"/>" +
				"<something root=\"2.2\" extension=\"extensionValue\" use=\"BUS\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<II.BUS>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), null);
		Set<Identifier> rawSet = ((SET) result).rawSet();
		

		rawSet.add(new Identifier("3.3", "newExtension"));
		
		assertEquals("size", 3, rawSet.size());
		assertThat(rawSet, hasItem(new Identifier("3.3", "newExtension")));
	}
	
}
