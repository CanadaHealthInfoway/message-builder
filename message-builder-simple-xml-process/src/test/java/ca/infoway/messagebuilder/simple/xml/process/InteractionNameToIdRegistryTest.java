package ca.infoway.messagebuilder.simple.xml.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class InteractionNameToIdRegistryTest {

	@Test
	public void shouldResolveName() throws Exception {
		assertEquals("id", "PRPA_IN101103CA", InteractionNameToIdRegistry.getInstance().getMessageId("findCandidatesQuery"));
	}
}
