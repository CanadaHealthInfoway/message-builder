package ca.infoway.messagebuilder.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Test;

/**
 * @sharpen.ignore - test - translated manually
 */
public class EnumBasedCodeResolverTest {

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
    public void testEnumResolverUsingInterfaceWithCodeSystem() throws Exception {
    	EnumBasedCodeResolver resolver = new EnumBasedCodeResolver(MockStarTrek.class);
    	MockCharacters spock = resolver.lookup(MockCharacters.class, "SPOCK", "to.boldly.go.wrong.code.system", null);
    	assertNull("spock", spock);
    }
}
