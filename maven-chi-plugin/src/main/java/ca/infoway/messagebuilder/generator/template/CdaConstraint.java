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
	
	@Attribute(required=false,name="isPrimitive")
	private boolean primitive;
	
	@Attribute(required=false)
	private String cardinality;
	
	@Attribute(required=false)
	private String context;
	
	@Attribute
	private String number;
	
	@Attribute(required=false)
	private String dataType;
	
	@Attribute(required=false)
	private String containedTemplateOid;
	
	@Element(required=false,name="SingleValueCode")
	private SingleValueCode singleValueCode;
	
	@ElementList(required=false,inline=true,entry="Constraint")
	private List<CdaConstraint> constraints = new ArrayList<CdaConstraint>();
	
	public boolean isPrimitive() {
		return primitive;
	}

	public void setPrimitive(boolean primitive) {
		this.primitive = primitive;
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

	public List<CdaConstraint> getConstraints() {
		return constraints;
	}

}
