package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class SimpleCodedTypeXmlParserTest extends AbstractXmlParserTest<CS> {
	
	public SimpleCodedTypeXmlParserTest() {
		super(new SimpleCodedTypeXmlParser(), "code", new CSImpl());
	}
	
	@Test
	public void shouldParseCode() throws Exception {
		assertEquals(
				"<code code=\"A\"/>",
				this.parser.parse(createContext(), new CSImpl(createCode("A", "1.2.3.4.5"))));
	}

	private Code createCode(final String code, final String codeSystem) {
		return new Code() {
			public String getCodeValue() {
				return code;
			}
			public String getCodeSystem() {
				return codeSystem;
			}
		};
	}
	
	@Override
	protected CS createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new CSImpl(nullFlavor);
	}

}
