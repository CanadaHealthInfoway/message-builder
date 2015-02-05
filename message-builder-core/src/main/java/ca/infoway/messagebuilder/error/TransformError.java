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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-12-18 14:55:30 -0400 (Thu, 18 Dec 2014) $
 * Revision:      $LastChangedRevision: 9099 $
 */
package ca.infoway.messagebuilder.error;

public class TransformError {

	private final Hl7Error error;
	private final ErrorCode errorCode;

	public TransformError(Hl7Error error) {
		this.error = error;
		this.errorCode = ErrorCode.transformCode(error.getHl7ErrorCode());
	}
	
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}
	
	public ErrorLevel getErrorLevel() {
		return this.error.getHl7ErrorLevel();
	}
	
	public String getMessage() {
		return this.error.getMessage();
	}
	
	public String getPath() {
		return this.error.getPath();
	}

	public String getBeanPath() {
		return this.error.getBeanPath();
	}
	
}