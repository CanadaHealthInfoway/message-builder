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

package ca.infoway.messagebuilder.generator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CmetDefinitionKey {

	private final String definitionPackage;
	private final String cmetName;
	
	public CmetDefinitionKey(String definitionPackage, String cmetName) {
		this.definitionPackage = definitionPackage;
		this.cmetName = cmetName;
	}

	public String getDefinitionPackage() {
		return definitionPackage;
	}

	public String getCmetName() {
		return cmetName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!CmetDefinitionKey.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		CmetDefinitionKey that = (CmetDefinitionKey) obj;
		
		return new EqualsBuilder().
				append(this.definitionPackage, that.definitionPackage).
				append(this.cmetName, that.cmetName).
				isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().
				append(this.definitionPackage).
				append(this.cmetName).
				toHashCode();
	}
}
