package ca.infoway.messagebuilder.resolver;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;

/**
 * @sharpen.ignore - test - translated manually
 */
public class TrivialCodeResolverTest {

	private static final String CODESYSTEM = "CODESYSTEM";
	private static final String CODE = "CODE";

	@Test
	public void testResolveCodeWithCodeAndCodeSystem() throws Exception {
		MockCharacters result = new TrivialCodeResolver().lookup(MockCharacters.class, CODE, CODESYSTEM);
		assertEquals("result", CODE, ((Code) result).getCodeValue());
		assertEquals("result", CODESYSTEM, ((Code) result).getCodeSystem());
	}

	@Test
	public void testNullCode() throws Exception {
		TrivialCodeResolver trivialCodeResolver = new TrivialCodeResolver();
		
		trivialCodeResolver.addDomainValue(null, MockCharacters.class);
		assertNull("null", trivialCodeResolver.lookup(MockCharacters.class, "foo"));
		trivialCodeResolver.addDomainValue(createMockCharactersCode("foo"), MockCharacters.class);
		assertNotNull("not null", trivialCodeResolver.lookup(MockCharacters.class, "foo"));
	}

	private Code createMockCharactersCode(final String code) {
		return new MockCharacters() {
			public String getCodeValue() {
				return code;
			}
			public String getCodeSystem() {
				return null;
			}
		};
	}
	
}
