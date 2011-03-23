package ca.infoway.messagebuilder.transport.mohawk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.transport.HttpTransportLayerException;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * @sharpen.ignore - test - translated manually.
 */
@RunWith(JMock.class)
public class MohawkTransportLayerTest {

	private static final String TRIVIAL_MESSAGE = "<REPC_IN000012CA xmlns=\"urn:hl7-org:v3\" ></REPC_IN000012CA>";
	private Mockery jmock = new Mockery();
	private Client client;
	private MohawkTransportLayer transport;
	
	@Before
	public void setUp() throws Exception {
		this.client = this.jmock.mock(Client.class);
		this.transport = new MohawkTransportLayer(this.client, "http://142.222.45.132:8080/soap/hl7/v3/ca/v2.04.2/Service.svc");
		
		this.jmock.checking(new Expectations() {{
			allowing(client).getState(); will(returnValue(new HttpState()));
			allowing(client).getParams(); will(returnValue(new HttpClientParams()));
		}});
	}

	@Test
	public void shouldMapToCorrectService() throws Exception {
		PostMethod method = this.transport.createPostMethod(SimpleRequestMessage.create("<REPC_IN000012CA></REPC_IN000012CA>"));
		assertEquals("url", new URI("http://142.222.45.132:8080/soap/hl7/v3/ca/v2.04.2/Service.svc/", true), method.getURI());
	}
	
	@Test
	public void shouldWrapInSoapEnvelope() throws Exception {
		byte[] soapEnvelope = this.transport.wrapInSoapEnvelope(
				new DocumentFactory().createFromString(
						TRIVIAL_MESSAGE), 
						new ServiceDefinition("/blah/", "myAction"));
		String xml = new String(soapEnvelope);
		assertTrue(xml, xml.contains("Body"));
		assertIsValidXml(soapEnvelope);
	}
	
	private void assertIsValidXml(byte[] soapEnvelope) {
		try {
			new DocumentFactory().createFromByteArray(soapEnvelope);
		} catch (SAXException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected=HttpTransportLayerException.class)
	public void shouldThrowExceptionOnBadState() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(client).executeMethod((PostMethod) with(anything())); will(returnValue(HttpStatus.SC_GONE));
		}});
		this.transport.sendRequestAndGetResponse(null, SimpleRequestMessage.create("<REPC_IN000012CA></REPC_IN000012CA>"));
	}
}
