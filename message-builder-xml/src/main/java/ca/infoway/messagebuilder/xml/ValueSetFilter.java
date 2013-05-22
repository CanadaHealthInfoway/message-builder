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
 * Last modified: $LastChangedDate: 2012-01-10 18:22:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3229 $
 */
package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class ValueSetFilter {
	
	@Attribute(required=false)
	private String codeSystemName;
	@Attribute(required=false)
	private String propertyName;
	@Attribute(required=false)
	private String propertyValue;
	@Attribute(required=false)
	private String nonComputableContent;
	@ElementList(required=false,inline=true,entry="includedCode")
	private List<ValueSetFilterCode> includedCodes;
	@ElementList(required=false,inline=true,entry="excludedCode")
	private List<ValueSetFilterCode> excludedCodes;
	@ElementList(required=false,inline=true,entry="otherValueSet")
	private List<ValueSetFilterReference> otherValueSets = new ArrayList<ValueSetFilterReference>();
	public String getCodeSystemName() {
		return codeSystemName;
	}
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getNonComputableContent() {
		return nonComputableContent;
	}
	public void setNonComputableContent(String nonComputableContent) {
		this.nonComputableContent = nonComputableContent;
	}
	public List<ValueSetFilterCode> getIncludedCodes() {
		return includedCodes;
	}
	public void setIncludedCodes(List<ValueSetFilterCode> includedCodes) {
		this.includedCodes = includedCodes;
	}
	public void addIncludedCode(ValueSetFilterCode code) {
		if (this.includedCodes == null) {
			this.includedCodes = new ArrayList<ValueSetFilterCode>();
		}
		this.includedCodes.add(code);
	}
	public List<ValueSetFilterCode> getExcludedCodes() {
		return excludedCodes;
	}
	public void setExcludedCodes(List<ValueSetFilterCode> excludedCodes) {
		this.excludedCodes = excludedCodes;
	}
	public void addExcludedCode(ValueSetFilterCode code) {
		if (this.excludedCodes == null) {
			this.excludedCodes = new ArrayList<ValueSetFilterCode>();
		}
		this.excludedCodes.add(code);
	}
	public List<ValueSetFilterReference> getOtherValueSets() {
		return otherValueSets;
	}
	public void setOtherValueSets(List<ValueSetFilterReference> otherValueSets) {
		this.otherValueSets = otherValueSets;
	}
	public void addOtherValueSet(ValueSetFilterReference reference) {
		if (this.otherValueSets == null) {
			this.otherValueSets = new ArrayList<ValueSetFilterReference>();
		}
		this.otherValueSets.add(reference);
	}

}
