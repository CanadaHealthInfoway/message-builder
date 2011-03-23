package ca.infoway.messagebuilder.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	public void testShouldResolveCodeAndCodeSystem() throws Exception {
		CompositeCodeResolver resolver = new CompositeCodeResolver(
				new EnumBasedCodeResolver(MockEnum.class),
				new EnumBasedCodeResolver(MockStarTrek.class));
		
		MockCharacters result = resolver.lookup(MockCharacters.class, "SPOCK", "to.boldly.go");
		assertNotNull("result", result);
		assertEquals("spock", MockStarTrek.SPOCK, result);
	}
}
