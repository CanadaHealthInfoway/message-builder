/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.TypeName;


public class NameMatcherTest {
	
	class NamedTypeImpl implements NamedType {

		private final String businessName;
		private final TypeName name;

		public NamedTypeImpl(String name, String businessName) {
			this.businessName = businessName;
			this.name = new TypeName(name);
		}
		public String getBusinessName() {
			return this.businessName;
		}
		public TypeName getTypeName() {
			return this.name;
		}
	}
	
	@Test
	public void shouldMatchBusinessNames() throws Exception {
		assertEquals("matches", MatchType.EXACT, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
				new NamedTypeImpl("ABCD_MT987654CA.Fred", "Fred Flintstone")));
		
		assertEquals("matches with type names are different", MatchType.EXACT, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.StoneAgeCharacter", "Fred Flintstone")));
	}
	
	@Test
	public void shouldNotMatchIfTypeNamesDontMatch() throws Exception {
		assertEquals("matches", MatchType.MAJOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", null), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", null)));
	}
	
	@Test
	public void shouldAlmostMatchIfNamesDifferOnlyBySuffix() throws Exception {
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", null), 
						new NamedTypeImpl("ABCD_MT987654CA.Fred2", null)));
		
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Fred2", null)));
	}
	
	@Test
	public void shouldNotMatchIfBusinessNamesAndTypeNamesDontMatch() throws Exception {
		assertEquals("matches", MatchType.MAJOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Fred", "Fred Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", "Wilma Flintstone")));
	}
	
	@Test
	public void shouldMatchIfBusinessNamesDontMatchButTypeNamesDoMatch() throws Exception {
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("ABCD_MT123456CA.Wilma", "Flintstone"), 
						new NamedTypeImpl("ABCD_MT987654CA.Wilma", "Wilma Flintstone")));
	}
	
	@Test
	public void shouldMatchIfBusinessNamesDontMatchButTypeNamesAreSimilar() throws Exception {
		assertEquals("matches", MatchType.MINOR_DIFFERENCE, 
				new NameMatcher().matchNames(new NamedTypeImpl("MCCI_MT102001CA.Organization3", null), 
						new NamedTypeImpl("MCCI_MT102001CA.Organization2", null)));
	}
}
