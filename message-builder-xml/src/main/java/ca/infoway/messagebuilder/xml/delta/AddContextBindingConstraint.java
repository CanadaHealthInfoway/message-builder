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

package ca.infoway.messagebuilder.xml.delta;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="add_context_binding_vocabulary_change")
public class AddContextBindingConstraint extends Constraint {
	private static final long serialVersionUID = 3778279440829529164L;
	private String conceptDomainName;
	private String codingStrength;
	
	public AddContextBindingConstraint(){}
	
	public AddContextBindingConstraint(String conceptDomainName, String codingStrength) {
		this.conceptDomainName = conceptDomainName;
		this.codingStrength = codingStrength;
	}
	
	@Override
	public boolean hasChange() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAsString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstraintChangeType getChange() {
		// TODO Auto-generated method stub
		return ConstraintChangeType.ADD_CONTEXT_BINDING;
	}

	public String getConceptDomainName() {
		return conceptDomainName;
	}

	public void setConceptDomainName(String conceptDomainName) {
		this.conceptDomainName = conceptDomainName;
	}

	public String getCodingStrength() {
		return codingStrength;
	}

	public void setCodingStrength(String codingStrength) {
		this.codingStrength = codingStrength;
	}

	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new AddContextBindingConstraint(conceptDomainName, codingStrength);
	}

}
