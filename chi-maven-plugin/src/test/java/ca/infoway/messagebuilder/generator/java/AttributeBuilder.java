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

/**
 * 
 */
package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.Attribute;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class AttributeBuilder {
	private String name;
	private String documentation;
	private String fixedValue;
	private ConformanceLevel conformanceLevel;
	private DataType dataType;
	private String businessName;

	public AttributeBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public AttributeBuilder setDocumentation(String documentation) {
		this.documentation = documentation;
		return this;
	}

	public Attribute build() {
		Relationship relationship = new Relationship();
		relationship.setName(this.name);
		if (this.documentation!=null) {
			relationship.setDocumentation(new Documentation(new Annotation(this.documentation)));
		}
		if (this.fixedValue!=null) {
			relationship.setFixedValue(this.fixedValue);
		}
		if (this.conformanceLevel!=null) {
			relationship.setConformance(this.conformanceLevel);
		}
		if (this.businessName!=null) {
			if (relationship.getDocumentation()==null) {
				relationship.setDocumentation(new Documentation());
			}
			relationship.getDocumentation().setBusinessName(businessName);
		}
		Attribute attribute = new Attribute(relationship, dataType);
		return attribute;
	}

	public AttributeBuilder setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
		return this;
	}

	public AttributeBuilder setConformance(ConformanceLevel conformanceLevel) {
		this.conformanceLevel = conformanceLevel;
		return this;
	}

	public AttributeBuilder setDataType(String type) {
		this.dataType = new TypeConverter(false).convertToType(type, null);
		return this;
	}

	public AttributeBuilder setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	
}