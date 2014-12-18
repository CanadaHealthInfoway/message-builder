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
 * Last modified: $LastChangedDate: 2014-11-06 15:40:43 -0500 (Thu, 06 Nov 2014) $
 * Revision:      $LastChangedRevision: 9058 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public class ParseContextImpl implements ParseContext {

	private final Type expectedReturnType;
	private final String type;
	private final VersionNumber version;
	private final ConformanceLevel conformance;
	private final CodingStrength strength;
	private final Integer length;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;
	private final Cardinality cardinality;
	private final ConstrainedDatatype constraints;
	private final boolean isCda;

	private ParseContextImpl(String type, Type returnType, VersionNumber version,
			TimeZone dateTimeZone, TimeZone dateTimeTimeZone, ConformanceLevel conformance, Cardinality cardinality, 
			CodingStrength strength, Integer length, ConstrainedDatatype constraints, boolean isCda) {
		this.type = type;
		this.expectedReturnType = returnType;
		this.version = version;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.conformance = conformance;
		this.cardinality = cardinality;
		this.strength = strength;
		this.length = length;
		this.constraints = constraints;
		this.isCda = isCda;
	}

	public String getType() {
		return this.type;
	}

	public Type getExpectedReturnType() {
		return this.expectedReturnType;
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

	public ConformanceLevel getConformance() {
		return this.conformance;
	}

	public Cardinality getCardinality() {
		return this.cardinality;
	}

	public CodingStrength getCodingStrength() {
		return this.strength;
	}

	public Integer getLength() {
		return this.length;
	}

	public ConstrainedDatatype getConstraints() {
		return this.constraints;
	}

	public boolean isCda() {
		return isCda;
	}

	// tests only
	public static ParseContext create(String type, Type returnType, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, ConformanceLevel conformance, Cardinality cardinality, ConstrainedDatatype constraints, boolean isCda) {
		return new ParseContextImpl(type, returnType, version, dateTimeZone, dateTimeTimeZone, conformance, cardinality, null, null, constraints, isCda);
	}

	// tests only
	public static ParseContext create(String type, Type returnType, VersionNumber version,
			TimeZone dateTimeZone, TimeZone dateTimeTimeZone, ConformanceLevel conformance, Cardinality cardinality, CodingStrength strength, Integer length, ConstrainedDatatype constraints, boolean isCda) {
		return new ParseContextImpl(type, returnType, version, dateTimeZone, dateTimeTimeZone, conformance, cardinality, strength, length, constraints, isCda);
	}
	
	public static ParseContext create(String newType, ParseContext oldContext) {
		return ParseContextImpl.create(newType, oldContext.getConformance(), oldContext.getCardinality(), oldContext);
	}
	
	public static ParseContext createWithConstraints(String newType, ParseContext oldContext) {
		return new ParseContextImpl(newType, oldContext.getExpectedReturnType(), oldContext.getVersion(), oldContext.getDateTimeZone(), oldContext.getDateTimeTimeZone(), oldContext.getConformance(), oldContext.getCardinality(), oldContext.getCodingStrength(), oldContext.getLength(), oldContext.getConstraints(), oldContext.isCda());
	}
	
	public static ParseContext createWithConstraints(String newType, Type newReturnType, ParseContext oldContext) {
		return new ParseContextImpl(newType, newReturnType, oldContext.getVersion(), oldContext.getDateTimeZone(), oldContext.getDateTimeTimeZone(), oldContext.getConformance(), oldContext.getCardinality(), oldContext.getCodingStrength(), oldContext.getLength(), oldContext.getConstraints(), oldContext.isCda());
	}
	
	public static ParseContext create(String newType, Type newReturnType, ParseContext oldContext) {
		// not passing constraints down unless constraints are explicitly provided
		return new ParseContextImpl(newType, newReturnType, oldContext.getVersion(), oldContext.getDateTimeZone(), oldContext.getDateTimeTimeZone(), oldContext.getConformance(), oldContext.getCardinality(), oldContext.getCodingStrength(), oldContext.getLength(), null, oldContext.isCda());
	}

	public static ParseContext create(String newType, ConformanceLevel newConformance, Cardinality newCardinality, ParseContext oldContext) {
		// not passing constraints down unless constraints are explicitly provided
		return new ParseContextImpl(newType, oldContext.getExpectedReturnType(), oldContext.getVersion(), oldContext.getDateTimeZone(), oldContext.getDateTimeTimeZone(), newConformance, newCardinality, oldContext.getCodingStrength(), oldContext.getLength(), null, oldContext.isCda());
	}

	public static ParseContext create(String newType, Type newReturnType, ConformanceLevel newConformance, Cardinality newCardinality, ParseContext oldContext) {
		// not passing constraints down unless constraints are explicitly provided
		return new ParseContextImpl(newType, newReturnType, oldContext.getVersion(), oldContext.getDateTimeZone(), oldContext.getDateTimeTimeZone(), newConformance, newCardinality, oldContext.getCodingStrength(), oldContext.getLength(), null, oldContext.isCda());
	}
	
}
