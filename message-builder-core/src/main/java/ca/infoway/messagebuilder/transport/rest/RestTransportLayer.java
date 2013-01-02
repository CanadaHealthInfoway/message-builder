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

package ca.infoway.messagebuilder.transport.rest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.j5goodies.MimeTypes;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.HttpTransportLayerException;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayer;
import ca.infoway.messagebuilder.transport.TransportLayerException;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.version.Configuration;

/**
 * <p>Implementation of a transport layer for REST (Representational State Transfer). 
 * REST is one of two common interfaces for HL7 messages. HL7 messages are POSTed to an HTTP server.
 * 
 * <p>Makes use of Apache Commons HttpClient for communication.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - transport - TBD!
 */
public class RestTransportLayer implements TransportLayer {

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
	private Log log = LogFactory.getLog(RestTransportLayer.class);

	/**
	 * <p>Constructs a REST transport layer for the given url. Makes use of the default tranport mechanism (HttpClient)
	 * 
	 * @param url the target url to send messages to
	 */
	public RestTransportLayer(String url) {
		this(new StandardHttpClient(), url);
	}
	
	/**
	 * <p>Constructs a REST transport layer for the given url. Makes use of provided client instead of the default HttpClient.  
	 * 
	 * @param client the transport client to use
	 * @param url the target url to send messages to
	 */
	public RestTransportLayer(Client client, String url) {
		this.client = client;
		this.url = url;
	}
	
	private void storeCredentials(UsernamePasswordCredentials credentials) {
		HttpState state = this.client.getState();
		state.setCredentials(new AuthScope(AuthScope.ANY_REALM, AuthScope.ANY_PORT), 
				new org.apache.commons.httpclient.UsernamePasswordCredentials(
						credentials.getUsername(), credentials.getPassword()));
		this.client.getParams().setAuthenticationPreemptive(true);
	}

	/**
	 * <p>Sends a request message synchronously and returns a response message as a string.
	 * 
	 * @param credentialsProvider object to obtain Credentials from
	 * @param requestMessage the message to be sent
	 * 
	 * @return the response message as a string
	 * 
	 */
	public String sendRequestAndGetResponse(CredentialsProvider credentialsProvider, RequestMessage requestMessage) {
		try {
			return postMessage(credentialsProvider, requestMessage);
		} catch (IOException e) {
			throw new TransportLayerException(e);
		}
	}

	private String postMessage(CredentialsProvider credentialsProvider, RequestMessage requestMessage) throws IOException {
		boolean repeat = false;
		int repeatCount = 0;
		String result = null;
		int statusCode = -1;
		handleCredentials(credentialsProvider);
		do {
			repeat = false;
			PostMethod method = createPostMethod();
			try {
				method.setRequestEntity(new StringRequestEntity(requestMessage.getMessageAsString(), MimeTypes.XML, "UTF-8"));
				statusCode = this.client.executeMethod(method);
				if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
					this.log.info("Authorization required.  Now prompting for userid/password");
					repeat = handleCredentials(credentialsProvider);
				} else if (isOk(statusCode)) {
					result = method.getResponseBodyAsString();
				} else {
					this.log.warn("Status code " + statusCode + " received from server: " 
							+ method.getStatusLine() != null ? method.getStatusLine() : "");
				}
			} finally {
				method.releaseConnection();
			}
		} while (repeat && ++repeatCount < 3);
		
		if (!isOk(statusCode)) {
			throw new HttpTransportLayerException(statusCode);
		} else {
			return result;
		}
	}
	protected PostMethod createPostMethod() {
		return new PostMethod(this.url);
	}

	private boolean handleCredentials(CredentialsProvider credentialProvider) {
		UsernamePasswordCredentials credentials = (UsernamePasswordCredentials) credentialProvider.getCredentials();
		if (credentials != null) {
			storeCredentials(credentials);
		}
		return credentials != null;
	}

	private boolean isOk(int statusCode) {
		return statusCode == HttpStatus.SC_OK;
	}
}
