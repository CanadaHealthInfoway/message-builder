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

import org.simpleframework.xml.Attribute;

public class ContextBinding {

	@Attribute
	private String conceptDomain;
	@Attribute
	private String realm;
	@Attribute
	private String codingStrength;
	
	public ContextBinding() {
	}
	public ContextBinding(String conceptDomain, String realm, CodingStrength codingStrength) {
		this.conceptDomain = conceptDomain;
		this.realm = realm;
		setCodingStrength(codingStrength);
	}

	public ContextBinding(String conceptDomain, String realm, String codingStrength) {
		this.conceptDomain = conceptDomain;
		this.realm = realm;
		this.codingStrength = codingStrength;
	}
	public String getConceptDomain() {
		return this.conceptDomain;
	}
	public String getRealm() {
		return this.realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public CodingStrength getCodingStrength() {
		return CodingStrength.valueOf(CodingStrength.class, this.codingStrength);
	}
	private void setCodingStrength(CodingStrength codingStrength) {
		this.codingStrength = codingStrength == null ? null : codingStrength.getName();
	}
}
