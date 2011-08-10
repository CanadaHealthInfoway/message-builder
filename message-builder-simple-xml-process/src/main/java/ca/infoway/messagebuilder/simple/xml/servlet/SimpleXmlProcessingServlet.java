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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;
import ca.infoway.messagebuilder.simple.xml.process.RequestProcessor;
import ca.infoway.messagebuilder.simple.xml.process.ResponseProcessor;
import ca.infoway.messagebuilder.simple.xml.process.SimpleXmlProcessor;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayer;
import ca.infoway.messagebuilder.transport.TrivialCredentialsProvider;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;

public class SimpleXmlProcessingServlet extends HttpServlet {

	public static final String MESSAGEBUILDER_SIMPLEXML_RESTURL = "messagebuilder.simplexml.resturl";
	private static final String MESSAGEBUILDER_SIMPLEXML_RESTURL_DEFAULT = "https://tl7.intelliware.ca/rest/nl";
	
	public static final String MESSAGEBUILDER_SIMPLEXML_VERSION = "messagebuilder.simplexml.version";
	private static final String MESSAGEBUILDER_SIMPLEXML_VERSION_DEFAULT = "R02_04_02";
	
	private static final long serialVersionUID = -7961751642861919438L;
	
	private final SimpleXmlProcessor requestProcessor;
	private final SimpleXmlProcessor responseProcessor;
	private final TransportLayer transportLayer;

	public SimpleXmlProcessingServlet() {
		this(
			SpecificationVersion.valueOf(SpecificationVersion.class, 
					System.getProperty(MESSAGEBUILDER_SIMPLEXML_VERSION, MESSAGEBUILDER_SIMPLEXML_VERSION_DEFAULT)), 
			new RestTransportLayer(
					System.getProperty(MESSAGEBUILDER_SIMPLEXML_RESTURL, MESSAGEBUILDER_SIMPLEXML_RESTURL_DEFAULT)));
	}

	public SimpleXmlProcessingServlet(VersionNumber versionNumber, TransportLayer transportLayer) {
		this(new RequestProcessor(versionNumber), new ResponseProcessor(versionNumber), transportLayer);
	}
	
	public SimpleXmlProcessingServlet(SimpleXmlProcessor requestProcessor,
			SimpleXmlProcessor responseProcessor, TransportLayer transportLayer) {
		this.requestProcessor = requestProcessor;
		this.responseProcessor = responseProcessor;
		this.transportLayer = transportLayer;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String requestAsHl7 = convertRequest(request);
			String responseAsHl7 = sendAndReceive(requestAsHl7);
			convertResponse(response, responseAsHl7);
		} catch (SAXException e) {
			throw new ServletException(e);
		} catch (MarshallingException e) {
			throw new ServletException(e);
		}
	}

	private String sendAndReceive(String requestAsHl7) {
		return this.transportLayer.sendRequestAndGetResponse(
				new TrivialCredentialsProvider(null), 
				SimpleRequestMessage.create(requestAsHl7));
	}

	private void convertResponse(HttpServletResponse response, String responseAsHl7) throws IOException, MarshallingException, SAXException {
		String responseAsSimpleXml = this.responseProcessor.process(responseAsHl7);
		if (StringUtils.isNotBlank(responseAsSimpleXml)) {
			response.setContentType("text/xml");
			response.setCharacterEncoding("UTF-8");
			byte[] bytes = responseAsSimpleXml.getBytes("UTF-8");
			response.setContentLength(bytes.length);
			IOUtils.write(bytes, response.getOutputStream());
		}
	}

	private String convertRequest(HttpServletRequest request) throws IOException,
			MarshallingException, SAXException {
		String requestAsString = IOUtils.toString(request.getReader());
		return this.requestProcessor.process(requestAsString);
	}
}
