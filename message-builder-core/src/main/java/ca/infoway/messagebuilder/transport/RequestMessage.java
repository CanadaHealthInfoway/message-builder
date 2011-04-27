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

package ca.infoway.messagebuilder.transport;

import org.w3c.dom.Document;

/**
 * <p>A message that can be sent across a transport layer.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public interface RequestMessage {
	
	/**
	 * <p>Obtains the message as a string, converting the underlying structure if necessary (i.e. DOM -> string). 
	 * 
	 * @return the underlying message rendered as a string
	 * @throws TransportLayerException if a string representation of the message could not be constructed
	 */
	public String getMessageAsString() throws TransportLayerException;
	
	/**
	 * <p>Obtains the message's interaction id. 
	 * 
	 * @return the message's interaction id
	 * @throws TransportLayerException if the message's interaction id could not be determined
	 */
	public String getInteractionId() throws TransportLayerException;
	
	/**
	 * <p>Obtains the message as a DOM, converting the underlying structure if necessary (i.e. string -> DOM). 
	 * 
	 * @return the underlying message in a DOM structure
	 * @throws TransportLayerException if there were problems creating the DOM
	 */
	public Document getMessageAsDocument() throws TransportLayerException;

}
