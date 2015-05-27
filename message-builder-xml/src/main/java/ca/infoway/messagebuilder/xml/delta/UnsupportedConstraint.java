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

import org.apache.commons.lang.StringUtils;

/**
 * Provides descriptions for the unsupported constraints. This type of constraint
 * captures changes that are currently not represented in the DeltaSet data
 * model. The {@link DeltaSetApplier} will not be able to apply the changes recoded 
 * with this constraint. This constraint type is created for use in the 
 * {@link DeltaSetGenerator}.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="unsupported_change")
public class UnsupportedConstraint extends Constraint {

	private static final long serialVersionUID = 884785613294286004L;
	private String description;
	private String originalValue;
	private String newValue;

	public UnsupportedConstraint() {
	}
	public UnsupportedConstraint(String description, String originalValue, String newValue) {
		this.description = description;
		this.originalValue = originalValue;
		this.newValue = newValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.UNSUPPORTED;
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
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new UnsupportedConstraint(description, originalValue, StringUtils.replace(newValue, originalPackageName, newPackageName));
	}

}
