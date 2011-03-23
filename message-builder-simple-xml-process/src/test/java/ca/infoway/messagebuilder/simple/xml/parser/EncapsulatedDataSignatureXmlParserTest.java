package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class EncapsulatedDataSignatureXmlParserTest extends AbstractXmlParserTest<ED<String>> {
	
	public EncapsulatedDataSignatureXmlParserTest() {
		super(new EncapsulatedDataSignatureXmlParser(), "sig", new EDImpl<String>());
	}
	
	@Test
	public void shouldParseSt() throws Exception {
		assertEquals(
				"<sig>hola</sig>",
				this.parser.parse(createContext(), createEdSignature(StandardDataType.ED_SIGNATURE, "hola")));
	}

	private EDImpl<String> createEdSignature(StandardDataType dataType, String value) {
		EDImpl<String> ed = new EDImpl<String>(value);
		ed.setDataType(dataType);
		return ed;
	}
	
	@Override
	protected ED<String> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new EDImpl<String>(nullFlavor);
	}

}
