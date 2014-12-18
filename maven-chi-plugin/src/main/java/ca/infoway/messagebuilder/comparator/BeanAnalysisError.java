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

package ca.infoway.messagebuilder.comparator;

import java.io.File;

public class BeanAnalysisError {

	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes
	public enum ErrorType {
		EXTENDS, 
		IMPLEMENTS, 
		NO_CORRESPONDING_CLASS, 
		METHOD_NOT_FOUND, 
		DIFFERENT_RETURN_TYPE, 
		CLASS_NOT_PUBLIC;
	}
	
	private final String errorMessage;
	private final File file;
	private final ErrorType errorType;

	public BeanAnalysisError(File file, ErrorType errorType, String errorMessage) {
		this.file = file;
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public File getFile() {
		return file;
	}
	
	public String getResult() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.file.getName() + ": ");
		stringBuilder.append(this.errorMessage);
		return stringBuilder.toString();
	}
}
