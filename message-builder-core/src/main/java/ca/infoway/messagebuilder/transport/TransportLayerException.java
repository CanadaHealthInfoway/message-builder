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
 * 
 * <p>An exception for general problems encountered within the transport layers. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * sharpen.ignore - transport - TBD!
 */
public class TransportLayerException extends RuntimeException {

	private static final long serialVersionUID = -5941185034989629293L;

	/**
	 * <p>Constructs a basic transport exception.
	 */
	public TransportLayerException() {
	}

	/**
	 * <p>Constructs a transport exception with a message and a cause.
	 * 
	 * @param message the exception error message
	 * @param cause the root exception
	 */
	public TransportLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>Constructs a transport exception with a message.
	 * 
	 * @param message the exception error message
	 */
	public TransportLayerException(String message) {
		super(message);
	}

	/**
	 * <p>Constructs a transport exception with a cause.
	 * 
	 * @param cause the root exception
	 */
	public TransportLayerException(Throwable cause) {
		super(cause.toString(), cause);
	}
}
