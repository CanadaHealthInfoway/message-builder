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

package ca.infoway.messagebuilder.mifcomparer;

/**
 * Exception class for error messages that should be reported to the end user <i>without</i> stacktrace, and abort execution.
 */
public class FatalConditionException extends RuntimeException {

	public FatalConditionException() {
		super();
	}

	public FatalConditionException(String message) {
		super(message);
	}

	public FatalConditionException(Throwable cause) {
		super(cause);
	}

	public FatalConditionException(String message, Throwable cause) {
		super(message, cause);
	}

}
