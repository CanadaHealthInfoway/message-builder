package ca.infoway.messagebuilder.generator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActStatus;


public class DomainRegistryTest {

	@Test
	public void shouldNotThrowExceptionOnNullParameter() throws Exception {
		assertNull("null parameter", DomainRegistry.getInstance().getDomainType(null));
	}
	
	@Test
	public void shouldResolveValue() throws Exception {
		assertEquals("value", ActClass.class, DomainRegistry.getInstance().getDomainType("ActClass"));
	}
	@Test
	public void shouldResolveValueWithWrongCase() throws Exception {
		assertEquals("value", ActClass.class, DomainRegistry.getInstance().getDomainType("actclass"));
	}
	
	@Test
	public void shouldResolveInterfaceTypesOnly() throws Exception {
		assertEquals("value", ActStatus.class, DomainRegistry.getInstance().getDomainType("ActStatus"));
	}
	
}
