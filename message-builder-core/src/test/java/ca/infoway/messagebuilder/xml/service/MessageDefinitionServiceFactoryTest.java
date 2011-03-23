package ca.infoway.messagebuilder.xml.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MessageDefinitionServiceFactoryTest {

	@Test
	public void shouldProduceNonNullResult() throws Exception {
		MessageDefinitionService service = new MockTestCaseMessageDefinitionService();
		assertNotNull("service", service);
	}
}
