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

package ca.infoway.messagebuilder.simple.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.datatype.StandardDataType;

public class FormatterContextImpl implements FormatContext {

	private StandardDataType type;
	private Class<?> expectedReturnType;

	private List<ErrorMessage> errors = Collections.synchronizedList(new ArrayList<ErrorMessage>());
	
	public FormatterContextImpl() {
	}
	
	public FormatterContextImpl(StandardDataType type, Class<?> expectedReturnType) {
		this.type = type;
		this.expectedReturnType = expectedReturnType;
	}
	
	public List<ErrorMessage> getErrors() {
		return this.errors;
	}

	public StandardDataType getType() {
		return this.type;
	}

	public Class<?> getExpectedReturnType() {
		return this.expectedReturnType;
	}

	public boolean matchesType(StandardDataType type) {
		boolean matches = false;
		if (this.type != null) {
			matches = this.type.equals(type);
		}
		return matches;
	}

}
