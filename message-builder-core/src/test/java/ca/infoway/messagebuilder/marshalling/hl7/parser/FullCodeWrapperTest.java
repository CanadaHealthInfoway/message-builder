package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;

public class FullCodeWrapperTest {
		
	@Test
	public void shouldWrapCodeWithCodeSystem() throws Exception {
		Code code = AdministrativeGender.MALE;
		String codeSystem = CodeSystem.CANADA.toString();
		
		Code fullCode = FullCodeWrapper.wrap(Code.class, code, codeSystem);
		assertEquals(codeSystem, fullCode.getCodeSystem());
		assertEquals(code.getCodeValue(), fullCode.getCodeValue());
	}

}
