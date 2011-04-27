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

import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class ParserContextImpl implements ParseContext {

	private final Type expectedReturnType;
	private final String type;
	private final String version;
	private final ConformanceLevel conformance;
	private final CodingStrength strength;
	private final Integer length;

	private ParserContextImpl(String type, Type returnType, String version, 
			ConformanceLevel conformance, CodingStrength strength, Integer length) {
		this.type = type;
		this.expectedReturnType = returnType;
		this.version = version;
		this.conformance = conformance;
		this.strength = strength;
		this.length = length;
	}

	public String getType() {
		return this.type;
	}
	
	public Type getExpectedReturnType() {
		return this.expectedReturnType;
	}

	public String getVersion() {
		return this.version;
	}

	public ConformanceLevel getConformance() {
		return this.conformance;
	}

	static ParseContext create(String type, Type returnType, String version, ConformanceLevel conformance) {
		return new ParserContextImpl(type, returnType, version, conformance, null, null);
	}

	public CodingStrength getCodingStrength() {
		return this.strength;
	}

	public Integer getLength() {
		return this.length;
	}

	public static ParseContext create(String type, Type returnType, String version,
			ConformanceLevel conformance, CodingStrength strength, Integer length) {
		return new ParserContextImpl(type, returnType, version, conformance, strength, length);
	}
}
