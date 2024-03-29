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

package ca.infoway.messagebuilder.generator.template;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(strict=false)
@Namespace(reference="http://www.lantanagroup.com")
public class CdaConstraint {
	
	private static final String SHALL = "SHALL";
	private static final String SHALL_NOT = "SHALL NOT";
	private static final String SHOULD = "SHOULD";
	private static final String MAY = "MAY";
	
	@Attribute(required=false,name="isPrimitive")
	private boolean primitive;
	
	@Attribute(required=false)
	private String conformance;
	
	@Attribute(required=false,name="isSchRooted")
	private boolean schRooted;
	
	@Attribute(required=false)
	private String cardinality;
	
	@Attribute(required=false)
	private String context;
	
	@Attribute(required=false)
	private String number;

	@Attribute(required=false,name="isBranch")
	private boolean branch;
	
	@Attribute(required=false)
	private String dataType;
	
	@Attribute(required=false)
	private String containedTemplateOid;
	
	@Element(required=false,name="SingleValueCode")
	private SingleValueCode singleValueCode;
	
	@Element(required=false,name="ValueSet")
	private ValueSet valueSet;
	
	@Element(required=false,name="CodeSystem")
	private CodeSystem codeSystem;
	
	@Element(required=false,name="SchematronTest")
	private SchematronTest schematronTest;
	
	@Element(required=false,name="NarrativeText")
	private NarrativeText narrativeText;
	
	@ElementList(required=false,inline=true,entry="Constraint")
	private List<CdaConstraint> constraints = new ArrayList<CdaConstraint>();
	
	public boolean isPrimitive() {
		return primitive;
	}

	public void setPrimitive(boolean primitive) {
		this.primitive = primitive;
	}

	public String getConformance() {
		return conformance;
	}

	public void setConformance(String conformance) {
		this.conformance = conformance;
	}

	public boolean isSchRooted() {
		return schRooted;
	}

	public void setSchRooted(boolean schRooted) {
		this.schRooted = schRooted;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isBranch() {
		return branch;
	}

	public void setBranch(boolean branch) {
		this.branch = branch;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getContainedTemplateOid() {
		return containedTemplateOid;
	}

	public void setContainedTemplateOid(String containedTemplateOid) {
		this.containedTemplateOid = containedTemplateOid;
	}

	public SingleValueCode getSingleValueCode() {
		return singleValueCode;
	}

	public void setSingleValueCode(SingleValueCode singleValueCode) {
		this.singleValueCode = singleValueCode;
	}

	public ValueSet getValueSet() {
		return valueSet;
	}

	public void setValueSet(ValueSet valueSet) {
		this.valueSet = valueSet;
	}

	public CodeSystem getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(CodeSystem codeSystem) {
		this.codeSystem = codeSystem;
	}

	public SchematronTest getSchematronTest() {
		return schematronTest;
	}

	public void setSchematronTest(SchematronTest schematronTest) {
		this.schematronTest = schematronTest;
	}

	public NarrativeText getNarrativeText() {
		return narrativeText;
	}

	public void setNarrativeText(NarrativeText narrativeText) {
		this.narrativeText = narrativeText;
	}

	public List<CdaConstraint> getConstraints() {
		return constraints;
	}
	
	public boolean isConformanceShall() {
		return SHALL.equals(this.conformance);
	}
	
	public boolean isConformanceShallNot() {
		return SHALL_NOT.equals(this.conformance);
	}
	
	public boolean isConformanceShould() {
		return SHOULD.equals(this.conformance);
	}

	public boolean isConformanceMay() {
		return MAY.equals(this.conformance);
	}
	
}
