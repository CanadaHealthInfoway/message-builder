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
									new MessageTypeKey(MockVersionNumber.MOCK_NEWFOUNDLAND, 
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
