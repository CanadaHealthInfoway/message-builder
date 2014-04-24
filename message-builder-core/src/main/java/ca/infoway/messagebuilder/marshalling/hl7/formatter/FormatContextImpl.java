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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class FormatContextImpl implements FormatContext {

	private final ModelToXmlResult result;
	private final ConformanceLevel conformanceLevel;
	private final String elementName;
	private final String type;
	private final boolean isSpecializationType;
	private final VersionNumber version;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;
	private final String propertyPath;
	private final CodingStrength codingStrength;
	private final Cardinality cardinality; 
	private final String domainType;

	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, ConformanceLevel conformanceLevel, Cardinality cardinality) {
		this(result, propertyPath, elementName, type, null, conformanceLevel, cardinality, false, null, null, null, null);
	}
	
	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, ConformanceLevel conformanceLevel, Cardinality cardinality, boolean isSpecializationType, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, CodingStrength codingStrength) {
		this(result, propertyPath, elementName, type, null, conformanceLevel, cardinality, isSpecializationType, version, dateTimeZone, dateTimeTimeZone, codingStrength);
	}
	
	FormatContextImpl(ModelToXmlResult result, String propertyPath, String elementName, String type, String domainType, ConformanceLevel conformanceLevel, Cardinality cardinality, boolean isSpecializationType, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, CodingStrength codingStrength) {
		this.result = result;
		this.propertyPath = propertyPath;
		this.elementName = elementName;
		this.type = type;
		this.domainType = domainType;
		this.conformanceLevel = conformanceLevel;
		this.cardinality = cardinality;
		this.isSpecializationType = isSpecializationType;
		this.version = version;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.codingStrength = codingStrength;
	}
	
	FormatContextImpl(String newType, FormatContext context) {
		this(newType, context.isSpecializationType(), context.getConformanceLevel(), context.getCardinality(), context.getElementName(), context);
	}
	
	FormatContextImpl(String newType, ConformanceLevel newConformanceLevel, Cardinality newCardinality, String elementName, FormatContext context) {
		this(newType, context.isSpecializationType(), newConformanceLevel, newCardinality, elementName, context);
	}
	
	FormatContextImpl(String newType, boolean isSpecializationType, FormatContext context) {
		this(newType, isSpecializationType, context.getConformanceLevel(), context.getCardinality(), context.getElementName(), context);
	}

	FormatContextImpl(String newType, boolean isSpecializationType, ConformanceLevel newConformanceLevel, Cardinality newCardinality, String elementName, FormatContext context) {
		this(context.getModelToXmlResult(), 
			 context.getPropertyPath(), 
			 elementName, 
			 newType,
			 context.getDomainType(),
			 newConformanceLevel, 
			 newCardinality, 
			 isSpecializationType, 
			 context.getVersion(), 
			 context.getDateTimeZone(), 
			 context.getDateTimeTimeZone(),
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

	public Cardinality getCardinality() {
		return this.cardinality;
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
	
	public CodingStrength getCodingStrength() {
		return this.codingStrength;
	}

	public String getDomainType() {
		return this.domainType;
	}

	public boolean isFixed() {
		// assumes that this version of FormatContext is only ever used for non-fixed relationships (might change later)
		return false;
	}

}
