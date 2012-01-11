/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * 
 * <p>An exception for http problems encountered within the transport layers. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class HttpTransportLayerException extends TransportLayerException {

	private static final long serialVersionUID = 4806719016466005503L;
	
	/**
	 * <p>Constructs an http transport layer exception based on the http status code.
	 * 
	 * @param statusCode the statusCode of the http error
	 */
	public HttpTransportLayerException(int statusCode) {
		super("Invalid HTTP status code received from server " + statusCode);
	}

}
