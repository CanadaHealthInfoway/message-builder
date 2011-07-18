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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class TrivialContext implements ParseContext {

	private final String type;

	public TrivialContext(String type) {
		this.type = type;
	}
	
	public CodingStrength getCodingStrength() {
		return null;
	}

	public ConformanceLevel getConformance() {
		return null;
	}

	public Type getExpectedReturnType() {
		return null;
	}

	public Integer getLength() {
		return null;
	}

	public VersionNumber getVersion() {
		return null;
	}

	public String getType() {
		return this.type;
	}

}
