package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Interaction;

public class InstantiatorTest {
	
	@Before
	public void setUp() {
		MockMessageBeanRegistry.initialize();
	}

	@Test
	public void shouldFindUniqueTealBeanForHl7PartType() throws Exception {
		assertTrue("instance of Sender", Instantiator.getInstance().instantiateMessagePartBean("MOCK_NEWFOUNDLAND", "MOCK_MT123456CA.SubType", new Interaction()) instanceof MockSubType);
	}

	@Test
	public void shouldFindTealBeanWhenPartTypeHasVersionSuffix() throws Exception {
		assertTrue("instance of Sender", Instantiator.getInstance().instantiateMessagePartBean("MOCK_NEWFOUNDLAND", "MOCK_MT123456CA.SubType_V02R02", new Interaction()) instanceof MockSubType);
	}

}
