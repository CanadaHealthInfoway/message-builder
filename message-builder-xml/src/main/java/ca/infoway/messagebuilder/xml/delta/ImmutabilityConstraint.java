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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="immutability_change")
public class ImmutabilityConstraint extends Constraint {

	private static final long serialVersionUID = -4292104044657928385L;

	@Column(length=12)
	@Enumerated(EnumType.STRING)
	private ImmutabilityType newValue;

	@Column(length=12)
	@Enumerated(EnumType.STRING)
	private ImmutabilityType originalValue;

	public ImmutabilityConstraint() {
	}
	public ImmutabilityConstraint(ImmutabilityType originalValue, ImmutabilityType newValue) {
		this.originalValue = originalValue;
		this.newValue = newValue;
	}

	@Override
	public boolean hasChange() {
		return !new EqualsBuilder().append(this.newValue, this.originalValue).isEquals();
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		return false;
	}

	@Override
	public String getAsString() {
		return null;
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_IMMUTABILITY;
	}

	public ImmutabilityType getNewValue() {
		return this.newValue;
	}

	public void setNewValue(ImmutabilityType newValue) {
		this.newValue = newValue;
	}

	public ImmutabilityType getOriginalValue() {
		return this.originalValue;
	}

	public void setOriginalValue(ImmutabilityType originalValue) {
		this.originalValue = originalValue;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new ImmutabilityConstraint(originalValue, newValue);
	}
}
