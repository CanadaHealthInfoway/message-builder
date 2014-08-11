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
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.IndexColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ChoiceRelationshipNameConstraint extends Constraint {

	private static final long serialVersionUID = -3477704294256983779L;
	@ElementCollection
	@IndexColumn(name="ordinal")
	@JoinTable(name="choice_relationship_name")
	private List<ChoiceRelationshipName> choiceRelationshipNames = new ArrayList<ChoiceRelationshipName>();

	public ChoiceRelationshipNameConstraint() {
	}
	public ChoiceRelationshipNameConstraint(List<ChoiceRelationshipName> name) {
		this.getChoiceRelationshipNames().addAll(name);
	}

	@Override
	public boolean hasChange() {
		boolean result = false;
		for (ChoiceRelationshipName name : this.getChoiceRelationshipNames()) {
			result |= !name.getOldName().equals(name.getNewName());
		}
		return result;
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		if (constraint instanceof ChoiceRelationshipNameConstraint) {
			ChoiceRelationshipNameConstraint that = (ChoiceRelationshipNameConstraint) constraint;
			boolean change = that.getChoiceRelationshipNames().size() != this.getChoiceRelationshipNames().size();
			for (int i = 0; !change && i < this.getChoiceRelationshipNames().size(); i++) {
				change |= StringUtils.equals(this.getChoiceRelationshipNames().get(i).getOldName(), that.getChoiceRelationshipNames().get(i).getOldName());
				change |= StringUtils.equals(this.getChoiceRelationshipNames().get(i).getNewName(), that.getChoiceRelationshipNames().get(i).getNewName());
				change |= StringUtils.equals(this.getChoiceRelationshipNames().get(i).getChoicePartType(), that.getChoiceRelationshipNames().get(i).getChoicePartType());
			}
			return change;
		} else {
			return false;
		}
	}

	@Override
	public String getAsString() {
		return null;
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_CHOICE_RELATIONSHIP_NAME;
	}

	public List<ChoiceRelationshipName> getNames() {
		return this.getChoiceRelationshipNames();
	}

	@SuppressWarnings("unused")
	private void setNames(List<ChoiceRelationshipName> names) {
		this.setChoiceRelationshipNames(names);
	}
	
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		for (ChoiceRelationshipName name : this.getChoiceRelationshipNames()) {
			name.setChoicePartType(realmCode.substituteRealmCode(name.getChoicePartType()));
		}
	}
	public List<ChoiceRelationshipName> getChoiceRelationshipNames() {
		return choiceRelationshipNames;
	}
	//GN: Required by deltasetReplicator when copying deltaset for snapshot and imports
	public void setChoiceRelationshipNames(List<ChoiceRelationshipName> choiceRelationshipNames) {
		this.choiceRelationshipNames = choiceRelationshipNames;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		ChoiceRelationshipNameConstraint newConstraint = new ChoiceRelationshipNameConstraint();
		for (ChoiceRelationshipName name : this.choiceRelationshipNames) {
			newConstraint.getChoiceRelationshipNames().add(new ChoiceRelationshipName(
					StringUtils.replace(name.getChoicePartType(), originalPackageName, newPackageName), 
					name.getOldName(), 
					name.getNewName()));
		}
		return newConstraint;
	}
}
