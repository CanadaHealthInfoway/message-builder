/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.transport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * @sharpen.ignore - test - translated manually
 */
public class SimpleRequestMessageTest {
	
	@Test
	public void shouldRenderDocumentToCreateStringVersionOfMessage() throws Exception {
		Document document = new DocumentFactory().createFromString("<myMessage></myMessage>");
		RequestMessage message = SimpleRequestMessage.create(document);
		
		assertTrue("message", message.getMessageAsString().contains("<myMessage"));
	}

	@Test
	public void shouldParseDocumentToCreateDomVersionOfMessage() throws Exception {
		RequestMessage message = SimpleRequestMessage.create("<myMessage></myMessage>");
		
		assertNotNull("document", message.getMessageAsDocument());
		assertEquals("document element", "myMessage", message.getMessageAsDocument().getDocumentElement().getTagName());
	}
	
	@Test(expected=TransportLayerException.class)
	public void shouldThrowExceptionIfMessageIsInvalid() throws Exception {
		SimpleRequestMessage.create("<myMessage>Fred");
	}
	
}
