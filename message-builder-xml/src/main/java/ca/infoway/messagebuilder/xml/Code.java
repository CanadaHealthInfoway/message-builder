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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Attribute;

public class Code {

	@Attribute
	private String codeSystem;
	@Attribute
	private String code;
	@Attribute(required=false)
	private String status;
	@Attribute(required=false)
	private String printName;
	
	public Code() {
	}
	
	public Code(String codeSystem, String code) {
		this(codeSystem, code, null, null);
	}
	
	public Code(String codeSystem, String code, String printName, String status) {
		this.codeSystem = codeSystem;
		this.code = code;
		this.printName = printName;
		this.status = status;
	}

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Code.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		
		Code that = (Code) obj;
		
		return new EqualsBuilder().
				append(this.codeSystem, that.codeSystem).
				append(this.code, that.code).
				isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().
				append(this.codeSystem).
				append(this.code).
				toHashCode();
	}
}
