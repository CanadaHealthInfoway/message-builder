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

import org.junit.After;
import org.junit.Test;

/**
 * @sharpen.ignore - test - translated manually
 */
public class EnumBasedCodeResolverTest {

	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
    public void testEnumResolver() throws Exception {
        CodeResolverRegistry.registerResolver(MockEnum.class, new EnumBasedCodeResolver(MockEnum.class));

        MockEnum fred = CodeResolverRegistry.lookup(MockEnum.class, "FRED");
        assertNotNull("fred", fred);
        assertEquals("fred", MockEnum.FRED, fred);
    }

	@Test
    public void testAllValues() throws Exception {
    	Collection<MockEnum> results = new EnumBasedCodeResolver(MockEnum.class).lookup(MockEnum.class);
    	assertNotNull("results", results);
    	assertEquals("size", 5, results.size());
    }
    
	@Test
    public void testEnumResolverUsingInterface() throws Exception {
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));

        MockCharacters fred = CodeResolverRegistry.lookup(MockCharacters.class, "FRED");
        assertNotNull("fred", fred);
        assertEquals("fred", MockEnum.FRED, fred);
    }

	@Test
    public void testEnumResolverUsingInterfaceWithIncorrectCodeSystem() throws Exception {
    	EnumBasedCodeResolver resolver = new EnumBasedCodeResolver(MockStarTrek.class);
    	MockCharacters spock = resolver.lookup(MockCharacters.class, "SPOCK", "to.boldly.go.wrong.code.system");
    	assertNull("spock", spock);
    }
	
	@Test
    public void testEnumResolverUsingInterfaceWithCorrectCodeSystem() throws Exception {
    	EnumBasedCodeResolver resolver = new EnumBasedCodeResolver(MockStarTrek.class);
    	MockCharacters spock = resolver.lookup(MockCharacters.class, "SPOCK", "to.boldly.go");
    	assertNotNull("spock", spock);
        assertEquals("spock", MockStarTrek.SPOCK, spock);
    }
	
	@Test
    public void testEnumResolverUsingInterfaceWithCorrectCodeSystemIgnoringCase() throws Exception {
    	EnumBasedCodeResolver resolver = new EnumBasedCodeResolver(MockStarTrek.class);
    	MockCharacters spock = resolver.lookup(MockCharacters.class, "Spock", "to.boldly.go", true);
    	assertNotNull("spock", spock);
        assertEquals("spock", MockStarTrek.SPOCK, spock);
    }
	
	@Test
    public void testEnumResolverUsingInterfaceWithCorrectCodeSystemNotIgnoringCase() throws Exception {
    	EnumBasedCodeResolver resolver = new EnumBasedCodeResolver(MockStarTrek.class);
    	MockCharacters spock = resolver.lookup(MockCharacters.class, "Spock", "to.boldly.go");
    	assertNull("spock", spock);
    }
}
