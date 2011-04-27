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

package ca.infoway.messagebuilder.transport.mohawk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.server.UID;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.HttpTransportLayerException;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayer;
import ca.infoway.messagebuilder.transport.TransportLayerException;
import ca.infoway.messagebuilder.version.Configuration;

/**
 * <p>Implementation of a transport layer for sending messages to Mohawk HIAL via SOAP. 
 * SOAP is one of two common interfaces for HL7 messages.
 * 
 * <p>Makes use of Apache Commons HttpClient for communication.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - transport - TBD!
 */
public class MohawkTransportLayer implements TransportLayer {
	
	private static final String WSA_PREFIX = "wsa";
	private static final String WS_ADDRESSING_NAMESPACE = "http://www.w3.org/2005/08/addressing";
	
	static class StandardHttpClient implements Client {
		private HttpClient client = new HttpClient();

		public HttpClientParams getParams() {
			return this.client.getParams();
		}
		public HttpState getState() {
			return this.client.getState();
		}
		public int executeMethod(PostMethod method) throws IOException {
			method.setRequestHeader("User-Agent", Configuration.getInstance().asUserAgent());
			return this.client.executeMethod(method);
		}
	}

	private Client client;
	private String url;
	private Log log = LogFactory.getLog(MohawkTransportLayer.class);

	/**
	 * <p>Constructs a Mohawk transport layer using a well-known url. Makes use of the default tranport mechanism (HttpClient)
	 * 
	 */
	public MohawkTransportLayer() {
		this("http://142.222.45.132:8080/soap/hl7/v3/ca/v2.04.2/Service.svc");
	}
	
	/**
	 * <p>Constructs a Mohawk transport layer for the given url. Makes use of the default tranport mechanism (HttpClient)
	 * 
	 * @param url the target url to send messages to
	 */
	public MohawkTransportLayer(String url) {
		this(new StandardHttpClient(), url);
	}
	
	/**
	 * <p>Constructs a Mohawk transport layer for the given url. Makes use of provided client instead of the default HttpClient.  
	 * 
	 * @param client the transport client to use
	 * @param url the target url to send messages to
	 */
	public MohawkTransportLayer(Client client, String url) {
		this.client = client;
		this.url = url;
	}
	
	/**
	 * Sends a request message synchronously and returns a response message as a string.
	 * 
	 * @param credentialsProvider object to obtain Credentials from
	 * @param requestMessage the message to be sent
	 * 
	 * @return the response message as a string
	 * 
	 * @throws TransportLayerException if any problems occurred
	 * 
	 */
	public String sendRequestAndGetResponse(CredentialsProvider credentialsProvider, RequestMessage requestMessage) 
			throws TransportLayerException {
		try {
			return postMessage(requestMessage);
		} catch (IOException e) {
			throw new TransportLayerException(e);
		}
	}
	
	private String postMessage(RequestMessage requestMessage) throws IOException {
		try {
			return postMethod(createPostMethod(requestMessage));
		} catch (SOAPException e) {
			throw new TransportLayerException("Error creating SOAP wrapper for message", e);
		}
	}
	private String postMethod(PostMethod method) throws IOException, SOAPException {
		try {
			int statusCode = this.client.executeMethod(method);
			if (isOk(statusCode)) {
				return unwrapFromSoap(method);
			} else {
				this.log.warn("Status code " + statusCode + " received from server: " 
						+ method.getStatusLine() != null ? method.getStatusLine() : "");
				this.log.warn(method.getResponseBodyAsString());
				throw new HttpTransportLayerException(statusCode);
			}
		} finally {
			method.releaseConnection();
		}
	}
	private String unwrapFromSoap(PostMethod method) throws IOException, SOAPException {
		ByteArrayInputStream input = new ByteArrayInputStream(method.getResponseBody());
		return new Hl7MessageExtractor().getHl7Message(input);
	}
	PostMethod createPostMethod(RequestMessage requestMessage) throws IOException, SOAPException {
		String name = requestMessage.getInteractionId();
		ServiceDefinition service = ServiceDefinition.getService(name);
		if (service == null) {
			throw new TransportLayerException("Cannot find a Mohawk service for type " + name);
		} else {
			PostMethod method = new PostMethod(concatenate(this.url, service.getPath()));
			byte[] soapEnvelope = wrapInSoapEnvelope(requestMessage.getMessageAsDocument(), service);
			method.setRequestEntity(new ByteArrayRequestEntity(soapEnvelope, "application/soap+xml"));
			return method;
		}
	}
	byte[] wrapInSoapEnvelope(Document document, ServiceDefinition service) throws IOException, SOAPException {
		SOAPMessage message = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
		createSoapAction(service, message);
		SOAPBody body = message.getSOAPBody();
		body.appendChild(body.addDocument(document));
	
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		message.writeTo(output);
		return output.toByteArray();
	}
	
	private void createSoapAction(ServiceDefinition service, SOAPMessage message)
			throws SOAPException {
		SOAPHeader header = message.getSOAPHeader();
		SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
		header.addNamespaceDeclaration(WSA_PREFIX, WS_ADDRESSING_NAMESPACE);
		SOAPHeaderElement wsaActionElement = header.addHeaderElement(envelope.createName("Action", WSA_PREFIX, WS_ADDRESSING_NAMESPACE));
		wsaActionElement.addTextNode(service.getAction());
		SOAPHeaderElement wsaFromElement = header.addHeaderElement(envelope.createName("From", WSA_PREFIX, WS_ADDRESSING_NAMESPACE));
		SOAPElement wsaAddressElement = wsaFromElement.addChildElement(envelope.createName("Address", WSA_PREFIX, WS_ADDRESSING_NAMESPACE));
		wsaAddressElement.addTextNode("http://anonymous");
		SOAPHeaderElement wsaMessageIdElement = header.addHeaderElement(envelope.createName("MessageID", WSA_PREFIX, WS_ADDRESSING_NAMESPACE));
		wsaMessageIdElement.addTextNode(new UID().toString());
		SOAPHeaderElement wsaToElement = header.addHeaderElement(envelope.createName("To", WSA_PREFIX, WS_ADDRESSING_NAMESPACE));
		wsaToElement.addTextNode("http://bt-app.biztalk.marc-hi.ca:8080/soap/hl7/v3/ca/v2.04.2/service.svc");
	}
	private String concatenate(String url, String path) {
		if (url.endsWith("/") && path.startsWith("/")) {
			return url + path.substring(1);
		} else if (url.endsWith("/") || path.startsWith("/")) {
			return url + path;
		} else {
			return url + "/" + path;
		}
	}
	private boolean isOk(int statusCode) {
		return statusCode == HttpStatus.SC_OK;
	}	
}
