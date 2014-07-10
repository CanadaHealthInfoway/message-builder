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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * Provides the new and old value for the change.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="conformance_change")
public class ConformanceConstraint extends Constraint {

	private static final long serialVersionUID = 2873896598848025184L;
	
	@Column(length=20)			
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.ConformanceLevel")})		
	private ConformanceLevel newValue;

	@Column(length=20)			
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.ConformanceLevel")})
	private ConformanceLevel originalValue;
	
	
	public ConformanceConstraint(ConformanceLevel originalValue, ConformanceLevel newValue) {
		this.originalValue = originalValue;
		this.newValue = newValue;
	}

	public ConformanceConstraint() {
	}

	public ConformanceLevel getNewValue() {
		return newValue;
	}
	public void setNewValue(ConformanceLevel newValue) {
		this.newValue = newValue;
	}
	public ConformanceLevel getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(ConformanceLevel originalValue) {
		this.originalValue = originalValue;
	}
	@Override
	public String getAsString() {
		return getNewValue() == null ? "" : getNewValue().name(); 
	}
	@Override
	public boolean hasChange() {
		return !new EqualsBuilder().append(newValue, originalValue).isEquals();
	}
	
	@Override
	public boolean hasChange(Constraint constraint) {
		boolean result = false;
		if (constraint instanceof ConformanceConstraint) {
			ConformanceConstraint compareConstraint = (ConformanceConstraint) constraint;
			
			result = !new EqualsBuilder()
						.append(this.newValue, compareConstraint.newValue)
						.append(this.originalValue, compareConstraint.originalValue)
						.isEquals();
		}
		return result;
	}
	
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_CONFORMANCE;
	}

}
