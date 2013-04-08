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

package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>The CMET binding metadata associated with a MIF file. Derived from a coremif file with root=DEFN and artifact=IFC.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class CmetBinding implements Documentable {
	
	@Attribute(required=false)
	private String cmetName;
	@Attribute(required=false)
	private String attributionLevel;
	@Attribute(required=false)
	private String code;
	@Attribute(required=false)
	private String codeSystemOid;
	@Element(required=false)
	private Documentation documentation;
	
	/**
	 * <p>The default constructor.
	 */
	public CmetBinding() {
	}

	public String getCmetName() {
		return cmetName;
	}

	public void setCmetName(String cmetName) {
		this.cmetName = cmetName;
	}

	public String getAttributionLevel() {
		return attributionLevel;
	}

	public void setAttributionLevel(String attributionLevel) {
		this.attributionLevel = attributionLevel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeSystemOid() {
		return codeSystemOid;
	}

	public void setCodeSystemOid(String codeSystemOid) {
		this.codeSystemOid = codeSystemOid;
	}

	public Documentation getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!CmetBinding.class.isAssignableFrom(obj.getClass())) return false;
		
		CmetBinding that = (CmetBinding) obj;
		return new EqualsBuilder()
			.append(this.cmetName, that.cmetName)
			.append(this.attributionLevel, that.attributionLevel)
			.append(this.code, that.code)
			.append(this.codeSystemOid, that.codeSystemOid)
			.append(this.documentation, that.documentation)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.cmetName)
			.append(this.attributionLevel)
			.append(this.code)
			.append(this.codeSystemOid)
			.append(this.documentation)
			.toHashCode();
	}
}
