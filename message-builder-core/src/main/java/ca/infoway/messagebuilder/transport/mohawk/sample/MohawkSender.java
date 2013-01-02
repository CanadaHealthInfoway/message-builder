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

package ca.infoway.messagebuilder.transport.mohawk.sample;

import java.io.IOException;

import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayerException;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.mohawk.MohawkTransportLayer;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * <p>Sends a sample message to the Mohawk HIAL using the MohawkTransportLayer.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - transport - TBD!
 */
public class MohawkSender {
	
	/**
	 * <p>Sends a sample message to the Mohawk HIAL using the MohawkTransportLayer.
	 * 
	 * @param args standard "main" args (not used in this case)
	 * @throws TransportLayerException if the message or its response encountered problems
	 * @throws SAXException if the sample xml could not be converted into a Document (parsing problem)
	 * @throws IOException if the sample xml could not be converted into a Document (resource problem)
	 */
	public static void main(String[] args) throws TransportLayerException, SAXException, IOException {
		MohawkTransportLayer transportLayer = new MohawkTransportLayer();
		CredentialsProvider credentialsProvider = new CredentialsProvider() {
			public Credentials getCredentials() {
				return new UsernamePasswordCredentials("username", "password");
			}
		};
		RequestMessage requestMessage = SimpleRequestMessage.create(
				new DocumentFactory().createFromStream(MohawkSender.class.getResourceAsStream("findCandidatesQuery.xml")));
		String response = transportLayer.sendRequestAndGetResponse(credentialsProvider, requestMessage);
		System.out.println(response);		
	}

}
