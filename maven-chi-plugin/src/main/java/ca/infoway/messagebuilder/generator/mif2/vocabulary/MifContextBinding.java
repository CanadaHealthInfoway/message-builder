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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifContextBinding {

	@Attribute
	private String bindingRealmName;
	
	@Attribute
	private String effectiveDate;
	
	@Attribute
	private String valueSet;
	
	@Attribute
	private String conceptDomain;
	
	@Attribute
	private String codingStrength;

	public String getBindingRealmName() {
		return bindingRealmName;
	}

	public void setBindingRealmName(String bindingRealmName) {
		this.bindingRealmName = bindingRealmName;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getValueSet() {
		return valueSet;
	}

	public void setValueSet(String valueSet) {
		this.valueSet = valueSet;
	}

	public String getConceptDomain() {
		return conceptDomain;
	}

	public void setConceptDomain(String conceptDomain) {
		this.conceptDomain = conceptDomain;
	}

	public String getCodingStrength() {
		return codingStrength;
	}

	public void setCodingStrength(String codingStrength) {
		this.codingStrength = codingStrength;
	}
}
