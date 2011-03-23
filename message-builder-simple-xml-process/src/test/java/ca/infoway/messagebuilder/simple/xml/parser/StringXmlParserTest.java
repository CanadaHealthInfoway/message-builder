package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class StringXmlParserTest  extends AbstractXmlParserTest<ST> {
	
	public StringXmlParserTest() {
		super(new StringXmlParser(), "comment", new STImpl());
	}
	
	@Test
	public void shouldParseSt() throws Exception {
		assertEquals(
				"<comment>hola</comment>",
				this.parser.parse(createContext(), createSt(StandardDataType.ST, "hola")));
	}

	@Test
	public void shouldParseStlang() throws Exception {
		assertEquals(
				"<comment language=\"en-CA\">hola</comment>",
				this.parser.parse(createContext(), createSt(StandardDataType.ST_LANG, "hola")));
	}

	private STImpl createSt(StandardDataType dataType, String value) {
		STImpl st = new STImpl(value);
		st.setDataType(dataType);
		if (StandardDataType.ST_LANG.equals(dataType)) {
			st.setLanguage("en-CA");
		}
		return st;
	}
	
	@Override
	protected ST createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new STImpl(nullFlavor);
	}

}
