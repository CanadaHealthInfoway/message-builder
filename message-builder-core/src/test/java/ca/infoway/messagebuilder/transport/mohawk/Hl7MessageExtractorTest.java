package ca.infoway.messagebuilder.transport.mohawk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * @sharpen.ignore - test - translated manually
 */
public class Hl7MessageExtractorTest {
	
	@Test
	public void shouldExtractResponseMessage() throws Exception {
		byte[] b = loadResponse();
		String document = new Hl7MessageExtractor().getHl7Message(new ByteArrayInputStream(b));
		assertTrue("string", document.contains("<hl7:PRPA_IN101104CA"));
		
		assertEquals("root", "PRPA_IN101104CA", 
				new DocumentFactory().createFromString(
						document).getDocumentElement().getLocalName());
	}

	private byte[] loadResponse() throws Exception {
		InputStream input = getClass().getResourceAsStream("soapResponse.xml");
		try {
			return IOUtils.toByteArray(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
