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

import java.util.Collection;

import org.junit.Test;

/**
 * @sharpen.ignore - test - translated manually
 */
public class CompositeCodeResolverTest {
	
	@Test
	public void testShouldCompositeCollections() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		Collection<MockCharacters> c = resolver.lookup(MockCharacters.class);
		assertEquals("size", 11, c.size());
	}
	
	@Test
	public void testShouldResolveCode() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		MockCharacters result = resolver.lookup(MockCharacters.class, "SPOCK", null);
		assertNotNull("result", result);
		assertEquals("spock", MockStarTrek.SPOCK, result);
	}
	
	@Test
	public void testShouldResolveCodeIgnoringCase() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		MockCharacters result = resolver.lookup(MockCharacters.class, "Spock", null, true);
		assertNotNull("result", result);
		assertEquals("spock", MockStarTrek.SPOCK, result);

		result = resolver.lookup(MockCharacters.class, "Spock", true);
		assertNotNull("result", result);
		assertEquals("spock", MockStarTrek.SPOCK, result);
	}
	
	@Test
	public void testShouldNotResolveCodeWhenIncorrectCase() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		MockCharacters result = resolver.lookup(MockCharacters.class, "Spock", null);
		assertNull("result", result);
		
		result = resolver.lookup(MockCharacters.class, "Spock", null, false);
		assertNull("result", result);
	}
	
	@Test
	public void testShouldResolveCodeAndCodeSystem() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		MockCharacters result = resolver.lookup(MockCharacters.class, "SPOCK", "to.boldly.go");
		assertNotNull("result", result);
		assertEquals("spock", MockStarTrek.SPOCK, result);
	}
}
