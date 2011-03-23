package ca.infoway.messagebuilder.transport.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.HttpTransportLayerException;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayerException;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;

/**
 * @sharpen.ignore - test - translated manually.
 */
@RunWith(JMock.class)
public class RestTransportLayerTest {

	private Mockery jmock = new Mockery();
	private RestTransportLayer rest;
	private Client client;
	private CredentialsProvider provider;

	@Before
	public void setUp() throws Exception {
		this.client = this.jmock.mock(Client.class);
		this.provider = this.jmock.mock(CredentialsProvider.class);
		this.rest = new RestTransportLayer(this.client, 
				"http://localhost:8080/rest");
		this.jmock.checking(new Expectations() {{
			allowing(client).getState(); will(returnValue(new HttpState()));
			allowing(client).getParams(); will(returnValue(new HttpClientParams()));
		}});
	}

	@Test
	public void shouldSendBasicMessageToServer() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(provider).getCredentials(); will(returnValue(null));
			one(client).executeMethod((PostMethod) with(anything())); will(returnValue(HttpStatus.SC_OK));
		}});
		this.rest.sendRequestAndGetResponse(this.provider, createMessage());
	}

	private RequestMessage createMessage() {
		return SimpleRequestMessage.create("<myXml></myXml>");
	}

	@Test
	public void testShouldThrowExceptionOnServerError() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(provider).getCredentials(); will(returnValue(null));
			allowing(client).executeMethod((PostMethod) with(anything())); will(returnValue(HttpStatus.SC_INTERNAL_SERVER_ERROR));
		}});
		try {
			this.rest.sendRequestAndGetResponse(this.provider, createMessage());
			fail("expected exception");
		} catch (HttpTransportLayerException e) {
			assertTrue(e.getMessage(), e.getMessage().contains("500"));
		}
	}

	@Test
	public void testShouldRequestUseridAndPassword() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(provider).getCredentials(); will(returnValue(null)); 
			one(provider).getCredentials(); will(returnValue(new UsernamePasswordCredentials("wilma", "pebbles")));
			one(client).executeMethod((PostMethod) with(anything())); will(returnValue(HttpStatus.SC_UNAUTHORIZED));
			one(client).executeMethod((PostMethod) with(anything())); will(returnValue(HttpStatus.SC_OK));
		}});
		
		this.rest.sendRequestAndGetResponse(this.provider, createMessage());
	}
	@Test
	public void testShouldRethrowHttpExceptions() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(provider).getCredentials(); will(returnValue(null));
			one(client).executeMethod((PostMethod) with(anything())); will(throwException(new HttpException("I hate rabbits!")));
		}});
		try {
			this.rest.sendRequestAndGetResponse(this.provider, createMessage());
			fail("expected exception");
		} catch (TransportLayerException e) {
		}
	}
}
