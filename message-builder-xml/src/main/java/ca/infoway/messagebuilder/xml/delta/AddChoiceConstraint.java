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

import org.apache.commons.lang.StringUtils;

/**
 * Contains the entry to be added.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="add_choice_change")
public class AddChoiceConstraint extends Constraint{
	
	private static final long serialVersionUID = 7839474523548026273L;
	
	private String choiceClassName;
	private String optionName;
	private boolean isDefault;
	
	public AddChoiceConstraint() {
	}
	public AddChoiceConstraint(String choiceClassName) {
		super();
		this.choiceClassName = choiceClassName;
	}
	public String getChoiceClassName() {
		return choiceClassName;
	}
	public void setChoiceClassName(String choiceClassName) {
		this.choiceClassName = choiceClassName;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public boolean hasChange() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasChange(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getAsString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.ADD_CHOICE;
	}
	
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.choiceClassName = realmCode.substituteRealmCode(this.choiceClassName);
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		AddChoiceConstraint addChoiceConstraint = new AddChoiceConstraint(StringUtils.replace(this.choiceClassName, originalPackageName, newPackageName));
		addChoiceConstraint.setOptionName(this.optionName);
		addChoiceConstraint.setDefault(this.isDefault);
		return addChoiceConstraint;
	}
}
