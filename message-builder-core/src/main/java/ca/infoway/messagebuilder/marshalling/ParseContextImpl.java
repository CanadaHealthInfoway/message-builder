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

package ca.infoway.messagebuilder.marshalling;

import java.lang.reflect.Type;
import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.domainvalue.util.CodeTypeHandler;
import ca.infoway.messagebuilder.domainvalue.util.DomainTypeHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

class ParseContextImpl implements ParseContext {

	private final Relationship relationship;
	private final VersionNumber version;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;
	private final ConstrainedDatatype constraints;
	private final CodeTypeHandler codeTypeHandler;
	private final boolean isCda;

	public ParseContextImpl(Relationship relationship, ConstrainedDatatype constraints, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, CodeTypeHandler codeTypeHandler, boolean isCda) {
		this.relationship = relationship;
		this.constraints = constraints;
		this.version = version;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.codeTypeHandler = codeTypeHandler;
		this.isCda = isCda;
	}

	public Type getExpectedReturnType() {
		return DomainTypeHelper.getReturnType(this.relationship, this.version, this.codeTypeHandler);
	}

	public String getType() {
		return this.relationship.getType();
	}

	public VersionNumber getVersion() {
		return this.version;
	}
	
	public TimeZone getDateTimeZone() {
		return this.dateTimeZone;
	}
	
	public TimeZone getDateTimeTimeZone() {
		return this.dateTimeTimeZone;
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

	public Cardinality getCardinality() {
		return this.relationship.getCardinality();
	}
	
	public ConstrainedDatatype getConstraints() {
		return this.constraints;
	}

	public boolean isCda() {
		return isCda;
	}

	public boolean isFixedValue() {
		return relationship.hasFixedValue();
	}
}
