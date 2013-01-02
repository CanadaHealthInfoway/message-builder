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

package ca.infoway.messagebuilder.transport;

/**
 * <p>A transport mechanism for sending requests (as requestMessages) and receiving responses (as strings).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public interface TransportLayer {
	
	/**
	 * <p>Sends a RequestMessage using the provided credentials and returns a response message as a string. 
	 * 
	 * @param credentialsProvider a way to obtain credentials
	 * @param requestMessage the message to be sent across the transport layer
	 * @return the response message as a string
	 * @throws TransportLayerException if any problems occurred during send or receive of the message
	 */
	public String sendRequestAndGetResponse(CredentialsProvider credentialsProvider, RequestMessage requestMessage) throws TransportLayerException;
	
}
