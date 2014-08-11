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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.xml.UpdateModeType;

/**
 * Contains a list of updateModeValues.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="update_mode_value_change")
public class UpdateModeValuesConstraint extends Constraint {

	private static final long serialVersionUID = -164359582075181292L;
	
	@ElementCollection
	@Column(name="update_mode_type", length=20, nullable=false)
	@JoinTable(name="new_update_modes", joinColumns=@JoinColumn(name="change_id"))
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.UpdateModeType")})	
	private List<UpdateModeType> newUpdateModes = Collections.synchronizedList(new ArrayList<UpdateModeType>());

	@ElementCollection
	@Column(name="update_mode_type", length=20, nullable=false)
	@JoinTable(name="original_update_modes", joinColumns=@JoinColumn(name="change_id"))
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.UpdateModeType")})		
	private List<UpdateModeType> originalUpdateModes = Collections.synchronizedList(new ArrayList<UpdateModeType>());

	public UpdateModeValuesConstraint() {
	}
	public UpdateModeValuesConstraint(List<UpdateModeType> originalValue, List<UpdateModeType> newValue) {
		setOriginalUpdateModes(originalValue);
		setNewUpdateModes(newValue);
	}
	public List<UpdateModeType> getNewUpdateModes() {
		return newUpdateModes;
	}
	public void setNewUpdateModes(List<UpdateModeType> newUpdateModes) {
		this.newUpdateModes = newUpdateModes;
	}

	public void setOriginalUpdateModes(List<UpdateModeType> originalUpdateModes) {
		this.originalUpdateModes = originalUpdateModes;
	}
	public List<UpdateModeType> getOriginalUpdateModes() {
		return originalUpdateModes;
	}

	@Override
	public String getAsString() {
		return ConstraintChangeType.CHANGE_UPDATEMODE_VALUES.name();
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_UPDATEMODE_VALUES;
	}

	@Override
	public boolean hasChange() {
		return !(this.originalUpdateModes.size() == this.newUpdateModes.size() && 
			     this.originalUpdateModes.containsAll(this.newUpdateModes));
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		boolean result = false;
		if (constraint instanceof UpdateModeValuesConstraint) {
			UpdateModeValuesConstraint compareConstraint = (UpdateModeValuesConstraint) constraint;
			
			result = !(this.originalUpdateModes.size() == compareConstraint.originalUpdateModes.size() && 
				       this.originalUpdateModes.containsAll(compareConstraint.originalUpdateModes) &&
				       this.newUpdateModes.size() == compareConstraint.newUpdateModes.size() && 
				       this.newUpdateModes.containsAll(compareConstraint.newUpdateModes));
		}
		return result;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		UpdateModeValuesConstraint newConstraint = new UpdateModeValuesConstraint();
		newConstraint.getOriginalUpdateModes().addAll(originalUpdateModes);
		newConstraint.getNewUpdateModes().addAll(newUpdateModes);
		return null;
	}
	
}
