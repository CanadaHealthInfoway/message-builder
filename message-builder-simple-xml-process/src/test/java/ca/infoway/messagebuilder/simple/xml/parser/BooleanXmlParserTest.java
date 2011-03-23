package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class BooleanXmlParserTest  extends AbstractXmlParserTest<BL> {
	
	public BooleanXmlParserTest() {
		super(new BooleanXmlParser(), "groovy", new BLImpl());
	}
	
	@Test
	public void shouldParseTrueValue() throws Exception {
		assertEquals(
				"<groovy>true</groovy>",
				this.parser.parse(createContext(), new BLImpl(true)));
	}

	@Test
	public void shouldParseFalseValue() throws Exception {
		assertEquals(
				"<groovy>false</groovy>",
				this.parser.parse(createContext(), new BLImpl(false)));
	}
	
	@Override
	protected BL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new BLImpl(nullFlavor);
	}

}
