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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.datatype.mif;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MifProperty {
	
	@Attribute
	private String name;

	@Attribute(required=false)
	private String fixedValue;
	
	@Attribute(required=false)
	private String sortKey;
	
	@Attribute(required=false)
	private String propertyKind;
	
	@Attribute(required=false)
	private String visibility;
	
	@Attribute(required=false)
	private Boolean isMandatory;
	
	@Attribute(required=false)
	private String minimumMultiplicity;
	
	@Attribute(required=false)
	private String maximumMultiplicity;
	
	@Attribute(required=false)
	private String conformance;
	
	@Element(required=false)
	private MifAnnotations annotations;
	
	@Element(required=false)
	private MifName type;

	@Element(required=false)
	private MifName businessName;
	
	@Element(required=false)
	private MifDerivedFrom derivedFrom;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getPropertyKind() {
		return propertyKind;
	}

	public void setPropertyKind(String propertyKind) {
		this.propertyKind = propertyKind;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Boolean getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getMinimumMultiplicity() {
		return minimumMultiplicity;
	}

	public void setMinimumMultiplicity(String minimumMultiplicity) {
		this.minimumMultiplicity = minimumMultiplicity;
	}

	public String getMaximumMultiplicity() {
		return maximumMultiplicity;
	}

	public void setMaximumMultiplicity(String maximumMultiplicity) {
		this.maximumMultiplicity = maximumMultiplicity;
	}

	public String getConformance() {
		return conformance;
	}

	public void setConformance(String conformance) {
		this.conformance = conformance;
	}

	public MifAnnotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(MifAnnotations annotations) {
		this.annotations = annotations;
	}

	public MifName getType() {
		return type;
	}

	public void setType(MifName type) {
		this.type = type;
	}

	public MifName getBusinessName() {
		return businessName;
	}

	public void setBusinessName(MifName businessName) {
		this.businessName = businessName;
	}

	public MifDerivedFrom getDerivedFrom() {
		return derivedFrom;
	}

	public void setDerivedFrom(MifDerivedFrom derivedFrom) {
		this.derivedFrom = derivedFrom;
	}

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}
}
