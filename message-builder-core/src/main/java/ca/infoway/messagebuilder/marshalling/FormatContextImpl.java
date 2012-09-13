/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

class FormatContextImpl implements FormatContext {

	private final Relationship relationship;
	private final VersionNumber version;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;

	private FormatContextImpl(Relationship relationship, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.relationship = relationship;
		this.version = version;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
	}

	public static FormatContext create(Relationship relationship, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		return new FormatContextImpl(relationship, version, dateTimeZone, dateTimeTimeZone);
	}

	public ConformanceLevel getConformanceLevel() {
		return this.relationship.getConformance();
	}

	public String getElementName() {
		return this.relationship.getName();
	}

	public String getType() {
		return this.relationship.getType();
	}

	public boolean isSpecializationType() {
		return false;
	}

	public boolean isPassOnSpecializationType() {
		return true;
	}

	public VersionNumber getVersion() {
		return this.version;
	}

	public TimeZone getDateTimeZone() {
		return dateTimeZone;
	}

	public TimeZone getDateTimeTimeZone() {
		return dateTimeTimeZone;
	}
}
