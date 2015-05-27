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
 * Contains the entry to be added.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="remove_choice_change")
public class RemoveChoiceConstraint extends Constraint{
	
	private static final long serialVersionUID = 7839474523548026273L;
	
	private String choiceClassName;
	
	public RemoveChoiceConstraint() {
	}
	public RemoveChoiceConstraint(String choiceClassName) {
		super();
		this.choiceClassName = choiceClassName;
	}
	public String getChoiceClassName() {
		return choiceClassName;
	}
	public void setChoiceClassName(String choiceClassName) {
		this.choiceClassName = choiceClassName;
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
		return ConstraintChangeType.REMOVE_CHOICE;
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new RemoveChoiceConstraint(choiceClassName);
	}
}
