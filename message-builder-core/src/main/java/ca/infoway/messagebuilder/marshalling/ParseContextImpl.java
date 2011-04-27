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

package ca.infoway.messagebuilder.marshalling;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

class ParseContextImpl implements ParseContext {

	private final Relationship relationship;
	private final String version;

	private ParseContextImpl(Relationship relationship, String version) {
		this.relationship = relationship;
		this.version = version;
	}

	public static ParseContext create(Relationship relationship, String version) {
		return new ParseContextImpl(relationship, version);
	}

	public Type getExpectedReturnType() {
		return DomainTypeHelper.getReturnType(this.relationship);
	}

	public String getType() {
		return this.relationship.getType();
	}

	public String getVersion() {
		return this.version;
	}
	public Integer getLength() {
		return this.relationship.getLength();
	}
	public CodingStrength getCodingStrength() {
		return this.relationship.getCodingStrength();
	}
	public ConformanceLevel getConformance() {
		return this.relationship.getConformance();
	}
}
