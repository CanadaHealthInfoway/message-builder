package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class IiTokenElementParserTest extends CeRxDomainValueTestCase {

	private static final String ROOT_UUID = "1ee83ff1-08ab-4fe7-b573-ea777e9bad51";
	
	private AbstractSingleElementParser<Identifier> parser;
	private XmlToModelResult xmlToJavaResult;

	private ParseContext context;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.parser = new IiElementParser();
		this.xmlToJavaResult = new XmlToModelResult();
		this.context = ParserContextImpl.create("II.TOKEN", Identifier.class, V02R02.getVersionLiteral(), null);
	}
	
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		BareANY ii = this.parser.parse(this.context, node, this.xmlToJavaResult);
		assertNull("null result", ii.getBareValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ii.getNullFlavor());
	}
	
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		this.parser.parse(this.context, node, this.xmlToJavaResult);
		assertFalse("result", this.xmlToJavaResult.isValid());
	}

	@Test
	public void testParseValid() throws Exception {
		Node node = createNode("<something root=\"" + ROOT_UUID + "\" />");
		Identifier result = (Identifier) this.parser.parse(this.context, node, this.xmlToJavaResult).getBareValue();
		assertEquals("result", new Identifier(ROOT_UUID), result);
		assertTrue("error", this.xmlToJavaResult.isValid());;
	}

	@Test
	public void testParseDetectExtraAttribute() throws Exception {
		Node node = createNode(
				"<something root=\"" + ROOT_UUID + "\" extension=\"lsdfjlsdjkf\" />");
		Identifier result = (Identifier) this.parser.parse(this.context, node, this.xmlToJavaResult).getBareValue();
		assertEquals("result", new Identifier(ROOT_UUID, "lsdfjlsdjkf"), result);
		assertFalse("error", this.xmlToJavaResult.isValid());;
	}
	
}
