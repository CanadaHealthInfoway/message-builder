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
import javax.persistence.Table;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * <p>Provides the and old value for the change.
 */
@Entity
@Table(name="cardinality_change")
public class CardinalityConstraint extends Constraint {

	private static final long serialVersionUID = -9057899029072091524L;

	private Integer newMinValue;
	private Integer originalMinValue;
	private Integer newMaxValue;
	private Integer originalMaxValue;
	
	public CardinalityConstraint() {
	}
	public CardinalityConstraint(Cardinality originalCardinality, Cardinality newCardinality) {
		setNewCardinality(newCardinality);
		setOriginalCardinality(originalCardinality);
	}
	public void setNewCardinality(Cardinality newCardinality) {
		this.newMinValue = newCardinality == null ? null : newCardinality.getMin();
		this.newMaxValue = newCardinality == null ? null : newCardinality.getMax();
	}
	public void setOriginalCardinality(Cardinality originalCardinality) {
		this.originalMinValue = originalCardinality == null ? null : originalCardinality.getMin();
		this.originalMaxValue = originalCardinality == null ? null : originalCardinality.getMax();
	}

	@Override
	public String getAsString() {
		return "" + getNewCardinality();
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_CARDINALITY;
	}

	@Override
	public boolean hasChange() {
		return !(ObjectUtils.equals(this.originalMaxValue, this.newMaxValue)
			&& ObjectUtils.equals(this.originalMinValue, this.newMinValue));
	}
	
	@Override
	public boolean hasChange(Constraint constraint) {
		boolean result = false;
		if (constraint instanceof CardinalityConstraint) {
			CardinalityConstraint compareConstraint = (CardinalityConstraint) constraint;
			
			result = !(ObjectUtils.equals(this.originalMinValue, compareConstraint.originalMinValue) &&
					   ObjectUtils.equals(this.originalMaxValue, compareConstraint.originalMaxValue) &&
					   ObjectUtils.equals(this.newMinValue, compareConstraint.newMinValue) &&
					   ObjectUtils.equals(this.newMaxValue, compareConstraint.newMaxValue));
		}
		return result;
	}

	public Cardinality getNewCardinality() {
		return new Cardinality(this.newMinValue, this.newMaxValue);
	}
	public Cardinality getOriginalCardinality() {
		return new Cardinality(this.originalMinValue, this.originalMaxValue);
	}

	public Integer getNewMinValue() {
		return this.newMinValue;
	}

	public void setNewMinValue(Integer newMinValue) {
		this.newMinValue = newMinValue;
	}

	public Integer getOriginalMinValue() {
		return this.originalMinValue;
	}

	public void setOriginalMinValue(Integer originalMinValue) {
		this.originalMinValue = originalMinValue;
	}

	public Integer getNewMaxValue() {
		return this.newMaxValue;
	}

	public void setNewMaxValue(Integer newMaxValue) {
		this.newMaxValue = newMaxValue;
	}

	public Integer getOriginalMaxValue() {
		return this.originalMaxValue;
	}

	public void setOriginalMaxValue(Integer originalMaxValue) {
		this.originalMaxValue = originalMaxValue;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new CardinalityConstraint(getOriginalCardinality(), getNewCardinality());
	}
}
