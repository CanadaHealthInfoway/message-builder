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
