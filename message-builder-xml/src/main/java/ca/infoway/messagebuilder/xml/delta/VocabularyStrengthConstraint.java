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

import ca.infoway.messagebuilder.xml.CodingStrength;

/**
 * Provides the and old value for the change.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="vocabulary_strength_change")
public class VocabularyStrengthConstraint extends Constraint {

	private static final long serialVersionUID = 2873896598848025184L;
	
	@Column(length=10)
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.CodingStrength")})			
	private CodingStrength newValue;

	@Column(length=10)
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.CodingStrength")})		
	private CodingStrength originalValue;

	public VocabularyStrengthConstraint() {
	}
	public VocabularyStrengthConstraint(CodingStrength originalValue, CodingStrength newValue) {
		this.originalValue = originalValue;
		this.newValue = newValue;
	}
	public CodingStrength getNewValue() {
		return newValue;
	}
	public void setNewValue(CodingStrength newValue) {
		this.newValue = newValue;
	}
	public CodingStrength getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(CodingStrength originalValue) {
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
		if (constraint instanceof VocabularyStrengthConstraint) {
			VocabularyStrengthConstraint compareConstraint = (VocabularyStrengthConstraint) constraint;
			
			result = !new EqualsBuilder()
						.append(this.newValue, compareConstraint.newValue)
						.append(this.originalValue, compareConstraint.originalValue)
						.isEquals();
		}
		return result;
	}
	
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_VOCABULARY_STRENGTH;
	}

}
