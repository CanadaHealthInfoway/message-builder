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

import org.apache.commons.lang.StringUtils;

/**
 * Provides the new and old value for the change.
 */
@MappedSuperclass
public abstract class NewStringValueConstraint extends Constraint {

	private static final long serialVersionUID = 809343572185528860L;
	
	private String newValue;
	private String originalValue;
	
	public NewStringValueConstraint() {
	}
	public NewStringValueConstraint(String originalValue, String newValue) {
		this.originalValue = originalValue;
		this.newValue = newValue;
	}

	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}
	public String getAsString() {
		return "" + getNewValue();
	}
	
	@Override
	public boolean hasChange() {
		return !StringUtils.equals(newValue, originalValue) && !(StringUtils.isBlank(newValue) && StringUtils.isBlank(originalValue));
	}

	@Override
	public boolean hasChange(Constraint compareConstraint) {
		boolean result = false;
		if (compareConstraint instanceof NewStringValueConstraint) {
			NewStringValueConstraint compareStringValue = (NewStringValueConstraint) compareConstraint;
			
			result = (!StringUtils.equals(this.newValue, compareStringValue.newValue) && !(StringUtils.isBlank(this.newValue) && StringUtils.isBlank(compareStringValue.newValue)))
					||
					 (!StringUtils.equals(this.originalValue, compareStringValue.originalValue) && !(StringUtils.isBlank(this.originalValue) && StringUtils.isBlank(compareStringValue.originalValue)));
		}
		return result;
	}

}
