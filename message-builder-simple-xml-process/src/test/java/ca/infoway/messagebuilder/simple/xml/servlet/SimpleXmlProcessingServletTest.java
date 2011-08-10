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
	
	@Test
	public void shouldCreateServletWithDefaultSettings() {
		new SimpleXmlProcessingServlet();
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void shouldFailCreatingServletWithIncorrectTransportClass() {
		System.setProperty(SimpleXmlProcessingServlet.MESSAGEBUILDER_SIMPLEXML_TRANSPORTCLASS, "java.lang.String");
		new SimpleXmlProcessingServlet();
	}
	
	@Test
	public void shouldCreateServletWithTransportClass() {
		System.setProperty(SimpleXmlProcessingServlet.MESSAGEBUILDER_SIMPLEXML_TRANSPORTCLASS, "ca.infoway.messagebuilder.transport.mohawk.MohawkTransportLayer");
		new SimpleXmlProcessingServlet();
	}
	
}
