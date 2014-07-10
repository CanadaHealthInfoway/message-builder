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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder;

/**
 * <p>An exception that indicates that something went wrong while trying to 
 * generate message sets from MIF files.</p>
 * 
 * @author administrator
 */
public class GeneratorException extends RuntimeException {

	private static final long serialVersionUID = 5359081721882569L;
	
	/**
	 * <p>Standard constructor.
	 */
	public GeneratorException() {
		super();
	}

	/**
	 * <p>Standard constructor.
	 * @param message - a description of the cause of the exception
	 * @param cause - the underlying exception that caused the error
	 */
	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>Standard constructor.
	 * @param message - a description of the cause of the exception
	 */
	public GeneratorException(String message) {
		super(message);
	}

	/**
	 * <p>Standard constructor.
	 * @param cause - the underlying exception that caused the error
	 */
	public GeneratorException(Throwable cause) {
		super(cause);
	}
}
