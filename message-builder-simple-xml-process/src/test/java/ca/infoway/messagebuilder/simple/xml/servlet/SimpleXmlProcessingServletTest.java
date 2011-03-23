package ca.infoway.messagebuilder.simple.xml.servlet;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import ca.infoway.messagebuilder.simple.xml.process.SimpleXmlProcessor;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayer;

@RunWith(JMock.class)
public class SimpleXmlProcessingServletTest {
	
	private Mockery jmock = new Mockery();
	private SimpleXmlProcessor requestProcessor = this.jmock.mock(
			SimpleXmlProcessor.class, "requestProcessor");
	private SimpleXmlProcessor responseProcessor = this.jmock.mock(
			SimpleXmlProcessor.class, "responseProcessor");
	private TransportLayer transportLayer = this.jmock.mock(TransportLayer.class);
	private SimpleXmlProcessingServlet servlet = new SimpleXmlProcessingServlet(
			this.requestProcessor, this.responseProcessor, this.transportLayer);
	
	@Test
	public void shouldProcessIncomingXml() throws Exception {
		
		this.jmock.checking(new Expectations() {{
			one(requestProcessor).process("<myXmlInput />"); will(returnValue("<myHl7Message />"));
			one(transportLayer).sendRequestAndGetResponse(
					(CredentialsProvider) with(anything()), with(any(RequestMessage.class))); 
			will(returnValue("<myHl7Response />"));
			one(responseProcessor).process("<myHl7Response />"); will(returnValue("<mySimpleResponse />"));
		}});

		this.servlet.service(createRequest(), new MockHttpServletResponse());
	}
	private MockHttpServletRequest createRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("POST");
		request.setContent("<myXmlInput />".getBytes());
		return request;
	}
	@Test
	public void shouldWriteResponseToServletResponse() throws Exception {
		
		this.jmock.checking(new Expectations() {{
			allowing(requestProcessor); will(returnValue("<myHl7Message />"));
			allowing(transportLayer);
			allowing(responseProcessor); will(returnValue("<mySimpleResponse />"));
		}});
		
		MockHttpServletResponse response = new MockHttpServletResponse();
		this.servlet.service(createRequest(), response);
		
		assertEquals("response status", 200, response.getStatus());
		assertEquals("response content type", "text/xml", response.getContentType());
		assertEquals("response content length", 20, response.getContentLength());
		assertEquals("response content", "<mySimpleResponse />", response.getContentAsString());
	}
}
