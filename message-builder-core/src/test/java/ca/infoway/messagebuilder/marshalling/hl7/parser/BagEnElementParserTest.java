package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class BagEnElementParserTest extends ParserTestCase {
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseSimpleBag() throws Exception {
		Node node = createNode("<top><name><family>Flinstone</family><given>Fred</given></name>" + 
				                    "<name><family>Flinstone</family><given>Wilma</given></name></top>");
		BareANY result = new BagElementParser().parse(
				ParserContextImpl.create("BAG<PN>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				this.xmlJavaResult);
		List<PersonName> list = ((LIST<PN,PersonName>) result).rawList();
		
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		EntityName fred = list.get(0);
		EntityName wilma = list.get(1);
		assertEquals("Flinstone", fred.getParts().get(0).getValue());
		assertEquals("Fred", fred.getParts().get(1).getValue());
		assertEquals("Flinstone", wilma.getParts().get(0).getValue());
		assertEquals("Wilma", wilma.getParts().get(1).getValue());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseEmptyBag() throws Exception {
		Node node = createNode("<top></top>");
		BareANY result = new BagElementParser().parse(
				ParserContextImpl.create("BAG<PN>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				this.xmlJavaResult);
		List<PersonName> list = ((LIST<PN,PersonName>) result).rawList();
		
		assertNotNull("null", list);
		assertEquals("size", 0, list.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseNullFlavor() throws Exception {
		Node node = createNode("<top><name nullFlavor=\"NI\"/></top>");
		BareANY result = new BagElementParser().parse(
				ParserContextImpl.create("BAG<PN>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				this.xmlJavaResult);
		
		LIST<PN,PersonName> hl7List = (LIST<PN,PersonName>) result;
		List<PersonName> list = hl7List.rawList();
		assertNotNull("null", list);
		assertEquals("size", 1, list.size());
		
		PN firstName = hl7List.getValue().iterator().next();
		assertTrue("null", firstName.isNull());
	}
}
