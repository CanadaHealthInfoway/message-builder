/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	public void testResolveCodeWithCodeAndCodeSystemCaseIgnore() throws Exception {
		MockCharacters result = new TrivialCodeResolver().lookup(MockCharacters.class, CODE, CODESYSTEM, true);
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
		    public String getCodeSystemName() {
		    	return null;
		    }
		};
	}
	
}
