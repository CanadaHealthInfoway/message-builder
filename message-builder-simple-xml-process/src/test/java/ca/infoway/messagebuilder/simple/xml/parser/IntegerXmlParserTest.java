package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class IntegerXmlParserTest extends AbstractXmlParserTest<INT> {
	
	public IntegerXmlParserTest() {
		super(new IntegerXmlParser(), "maxAge", new INTImpl());
	}
	
	@Test
	public void shouldParseNonNullValue() throws Exception {
		assertEquals(
				"<maxAge>1</maxAge>",
				this.parser.parse(createContext(), new INTImpl(1)));
	}

	@Override
	protected INT createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new INTImpl(nullFlavor);
	}

}
