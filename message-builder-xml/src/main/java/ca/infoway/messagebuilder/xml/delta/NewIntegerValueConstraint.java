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

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.ObjectUtils;

/**
 * Provides the and old value for the change.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@MappedSuperclass
public abstract class NewIntegerValueConstraint extends Constraint {

	private static final long serialVersionUID = 7116015054631078423L;
	
	private Integer newValue;
	private Integer originalValue;

	public Integer getNewValue() {
		return newValue;
	}
	public void setNewValue(Integer newValue) {
		this.newValue = newValue;
	}
	public Integer getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(Integer originalValue) {
		this.originalValue = originalValue;
	}
	public String getAsString() {
		return "" + getNewValue(); 
	}

	@Override
	public boolean hasChange() {
		return !ObjectUtils.equals(this.newValue, this.originalValue);
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		boolean result = false;
		if (constraint instanceof NewIntegerValueConstraint) {
			NewIntegerValueConstraint compareConstraint = (NewIntegerValueConstraint) constraint;
			
			result = !(ObjectUtils.equals(this.originalValue, compareConstraint.originalValue) &&
					   ObjectUtils.equals(this.newValue, compareConstraint.newValue));
		}
		return result;
	}

}
