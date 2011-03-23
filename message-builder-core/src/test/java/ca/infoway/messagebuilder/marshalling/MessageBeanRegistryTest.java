package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang.ClassUtils;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;

/**
 * @sharpen.ignore - marshalling - translated manually
 */
public class MessageBeanRegistryTest {
	
	public static MessageDescription CR = new MessageDescription("FindCandidatesQueryMessageBean", "PRPA_IN101103CA"); 
	public static MessageDescription CERX = new MessageDescription("RecordDispenseProcessingRequestMessageBean", "PORX_IN020190CA");
	public static MessageDescription COMMON = new MessageDescription("GenericResponseMessageBean", "MCCI_IN000002CA");

	@Before
	public void setUp() {
		MockMessageBeanRegistry.initialize();
	}
	
	@Test
	public void shouldFindMessageBeanType() throws Exception {
		for (MessageDescription description : Arrays.asList(CR, CERX, COMMON)) {
			assertEquals("type",
					description.getMessageType(),
					ClassUtils.getShortClassName(
							MessageBeanRegistry.getInstance().getInteractionBeanType(
									new MessageTypeKey(MockVersionNumber.MOCK.getVersionLiteral(), 
											description.getInteractionId()))));
		}
	}

	static class MessageDescription {
		private final String messageType;
		private final String interactionId;
		public MessageDescription(String messageType, String interactionId) {
			this.messageType = messageType;
			this.interactionId = interactionId;
		}
		public String getMessageType() {
			return this.messageType;
		}
		public String getInteractionId() {
			return this.interactionId;
		}
	}
}
