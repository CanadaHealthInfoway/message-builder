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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2015-01-13 13:10:01 -0500 (Tue, 13 Jan 2015) $
 * Revision:      $LastChangedRevision: 9127 $
 */

package ca.infoway.messagebuilder.terminology.codeset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.terminology.domainvalue.Displayable;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;

public class CdaCodeResolverTest {

	private CdaCodeResolver fixture;

	@Before
	public void setUp() {
		
		fixture = new CdaCodeResolver(new TypedCodeFactory(), 
				CdaCodeResolverTest.class.getResourceAsStream("/voc.xml"),
				CdaCodeResolverTest.class.getResourceAsStream("/vocabNameMap.xml"));
	}
	
	@Test
	public void shouldFindAllCodesByType() {
		Collection<BasicConfidentialityKind> collection = fixture.lookup(BasicConfidentialityKind.class);
		assertEquals(3, collection.size());
		
		Set<String> expectedCodes = new HashSet<String>(Arrays.asList("N", "R", "V"));
		for (BasicConfidentialityKind code : collection) {
			assertTrue("one copy of " + code.getCodeValue(), expectedCodes.contains(code.getCodeValue()));
			expectedCodes.remove(code.getCodeValue());
		}
	}

	@Test
	public void shouldFindCodeByCodeAndType() {
		BasicConfidentialityKind code = fixture.lookup(BasicConfidentialityKind.class, "N");
		
		assertNotNull(code);
		assertEquals("N", code.getCodeValue());
		assertEquals("2.16.840.1.113883.5.25", code.getCodeSystem());
		assertEquals("ConfidentialityCode", code.getCodeSystemName());
		
		assertTrue(Displayable.class.isAssignableFrom(code.getClass()));
		Displayable displayable = (Displayable) code;
		assertEquals("normal", displayable.getDisplayText("en"));
	}
	
	@Test
	public void shouldFindCodeByCodeAndOid() {
		BasicConfidentialityKind code = fixture.lookup(BasicConfidentialityKind.class, "N", "2.16.840.1.113883.5.25");
		assertNotNull(code);
		
		code = fixture.lookup(BasicConfidentialityKind.class, "N", "some.bogus.oid");
		assertNull(code);
	}
}