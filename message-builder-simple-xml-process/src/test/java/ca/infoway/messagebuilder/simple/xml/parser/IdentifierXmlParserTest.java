package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class IdentifierXmlParserTest extends AbstractXmlParserTest<II> {
	
	public IdentifierXmlParserTest() {
		super(new IdentifierXmlParser(), "id", new IIImpl());
	}	
	@Test
	public void shouldParseValue() throws Exception {
		assertEquals(
				"<id extension=\"2\" root=\"1\"/>",
				this.parser.parse(createContext(), new IIImpl(new Identifier("1", "2"))));
	}

	@Override
	protected II createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new IIImpl(nullFlavor);
	}

}
