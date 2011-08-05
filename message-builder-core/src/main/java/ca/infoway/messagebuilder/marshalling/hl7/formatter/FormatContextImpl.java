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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class FormatContextImpl implements FormatContext {

	private final ConformanceLevel conformanceLevel;
	private final String elementName;
	private final String type;
	private final boolean isSpecializationType;
	private final boolean isPassOnSpecializationType;
	private final VersionNumber version;
	private final TimeZone timeZone;

	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel) {
		this(elementName, type, conformanceLevel, false, null, null, true);
	}
	
	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version, TimeZone timeZone) {
		this(elementName, type, conformanceLevel, isSpecializationType, version, timeZone, true);
	}
	
	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version, TimeZone timeZone, boolean isPassOnSpecializationType) {
		this.elementName = elementName;
		this.type = type;
		this.conformanceLevel = conformanceLevel;
		this.isSpecializationType = isSpecializationType;
		this.version = version;
		this.timeZone = timeZone;
		this.isPassOnSpecializationType = isPassOnSpecializationType;
	}
	
	public ConformanceLevel getConformanceLevel() {
		return this.conformanceLevel;
	}

	public String getElementName() {
		return this.elementName;
	}

	public String getType() {
		return this.type;
	}

	public boolean isSpecializationType() {
		return this.isSpecializationType;
	}

	public VersionNumber getVersion() {
		return this.version;
	}
	
	public TimeZone getTimeZone() {
		return this.timeZone;
	}
	
	public boolean isPassOnSpecializationType() {
		return this.isPassOnSpecializationType;
	}
}
