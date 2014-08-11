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
 * Provides the and old value for the change.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="cmet_substitution_change")
public class CmetSubstitutionConstraint extends NewStringValueConstraint {

	private static final long serialVersionUID = 4936460790772849453L;

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.SUBSTITUTE_CMET;
	}

	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		// TODO Auto-generated method stub
		CmetSubstitutionConstraint newConstraint = new CmetSubstitutionConstraint();
		newConstraint.setOriginalValue(getOriginalValue());
		newConstraint.setNewValue(getNewValue());
		return newConstraint;
	}

}
