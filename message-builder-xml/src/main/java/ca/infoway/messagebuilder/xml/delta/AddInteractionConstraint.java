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

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

/**
 * Contains the entry to be added.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="add_interaction_change")
public class AddInteractionConstraint extends Constraint{
	
	private static final long serialVersionUID = 7839474523548026273L;
	
	private String baseTypeName;
	
	@OneToMany(cascade = ALL,orphanRemoval=true)
	@OrderBy("id")
	@JoinColumn(name="change_id", referencedColumnName="id")
	private List<AddInteractionArgument> arguments = Collections.synchronizedList(new ArrayList<AddInteractionArgument>());
	
	public AddInteractionConstraint() {
	}
	public AddInteractionConstraint(String baseTypeName) {
		this.baseTypeName = baseTypeName;
	}
	
	public String getBaseTypeName() {
		return baseTypeName;
	}
	public void setBaseTypeName(String baseTypeName) {
		this.baseTypeName = baseTypeName;
	}
	public List<AddInteractionArgument> getArguments() {
		return arguments;
	}
	//GN: DeltaSetReplicator requires when copying the deltaset for snapshots and imports
	public void setArguments(List<AddInteractionArgument> arguments) {
		this.arguments = arguments;
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
		return ConstraintChangeType.ADD_INTERACTION;
	}
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.baseTypeName = realmCode.substituteRealmCode(this.baseTypeName);
		for (AddInteractionArgument argument : this.getArguments()) {
			argument.setMessagePartName(realmCode.substituteRealmCode(argument.getMessagePartName()));
		}
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		AddInteractionConstraint newConstraint = new AddInteractionConstraint(StringUtils.replace(baseTypeName, originalPackageName, newPackageName));
		for (AddInteractionArgument argument : this.arguments) {
			newConstraint.getArguments().add(new AddInteractionArgument(
					argument.getTemplateParameterName(), 
					argument.getTraversalName(), 
					StringUtils.replace(argument.getMessagePartName(), originalPackageName, newPackageName)));
		}
		
		return newConstraint;
	}
}
