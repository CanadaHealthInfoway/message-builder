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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class FormatContextImpl implements FormatContext {

	private final ModelToXmlResult result;
	private final ConformanceLevel conformanceLevel;
	private final String elementName;
	private final String type;
	private final boolean isSpecializationType;
	private final boolean isPassOnSpecializationType;
	private final VersionNumber version;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;
	private final String propertyPath;
	private CodingStrength codingStrength;
	private final String domainType; 


	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, ConformanceLevel conformanceLevel) {
		this(result, propertyPath, elementName, type, null, conformanceLevel, false, null, null, null, true, null);
	}
	
	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, CodingStrength codingStrength) {
		this(result, propertyPath, elementName, type, null, conformanceLevel, isSpecializationType, version, dateTimeZone, dateTimeTimeZone, true, codingStrength);
	}
	
	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, String domainType, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, boolean isPassOnSpecializationType, CodingStrength codingStrength) {
		this.result = result;
		this.propertyPath = propertyPath;
		this.elementName = elementName;
		this.type = type;
		this.domainType = domainType;
		this.conformanceLevel = conformanceLevel;
		this.isSpecializationType = isSpecializationType;
		this.version = version;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.isPassOnSpecializationType = isPassOnSpecializationType;
		this.codingStrength = codingStrength;
	}
	
	FormatContextImpl(String newType, FormatContext context) {
		this(newType, context.isSpecializationType(), context.getConformanceLevel(), context.getElementName(), context);
	}
	
	FormatContextImpl(String newType, ConformanceLevel newConformanceLevel, String elementName, FormatContext context) {
		this(newType, context.isSpecializationType(), newConformanceLevel, elementName, context);
	}
	
	FormatContextImpl(String newType, boolean isSpecializationType, FormatContext context) {
		this(newType, isSpecializationType, context.getConformanceLevel(), context.getElementName(), context);
	}

	FormatContextImpl(String newType, boolean isSpecializationType, ConformanceLevel newConformanceLevel, String elementName, FormatContext context) {
		this(context.getModelToXmlResult(), 
			 context.getPropertyPath(), 
			 elementName, 
			 newType,
			 context.getDomainType(),
			 newConformanceLevel, 
			 isSpecializationType, 
			 context.getVersion(), 
			 context.getDateTimeZone(), 
			 context.getDateTimeTimeZone(), 
			 context.isPassOnSpecializationType(),
			 context.getCodingStrength());
	}

	public ModelToXmlResult getModelToXmlResult() {
		return this.result;
	}

	public String getPropertyPath() {
		return this.propertyPath;
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
	
	public TimeZone getDateTimeZone() {
		return this.dateTimeZone;
	}

	public TimeZone getDateTimeTimeZone() {
		return this.dateTimeTimeZone;
	}
	
	public boolean isPassOnSpecializationType() {
		return this.isPassOnSpecializationType;
	}

	public CodingStrength getCodingStrength() {
		return this.codingStrength;
	}

	public String getDomainType() {
		return this.domainType;
	}

}
