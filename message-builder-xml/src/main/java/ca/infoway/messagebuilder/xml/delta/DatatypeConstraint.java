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
@Table(name="data_type_change")
public class DatatypeConstraint extends NewStringValueConstraint {

	private static final long serialVersionUID = -9171161483466322794L;

	public DatatypeConstraint() {
	}
	public DatatypeConstraint(String originalValue, String newValue) {
		setOriginalValue(originalValue);
		setNewValue(newValue);
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_DATATYPE;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new DatatypeConstraint(getOriginalValue(), getNewValue());
	}

}
