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
 * Contains the class and relationship to be removed.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="remove_change")
public class RemoveConstraint extends Constraint {

	private static final long serialVersionUID = 2873896598848025184L;
	
	private String className;
	private String relationshipName;

	public RemoveConstraint() {
	}
	public RemoveConstraint(String className, String relationshipName) {
		this.className = className;
		this.relationshipName = relationshipName;
	}
	@Override
	public String getAsString() {
		String returnString = "as string remove class=" +	getClassName();
		if (StringUtils.isNotBlank(getRelationshipName())) {
			returnString += " relationship name=" + getRelationshipName();
		}
		return returnString;
	}
	@Override
	public boolean hasChange() {
		return true;
	}
	@Override
	public boolean hasChange(Constraint constraint) {
		return true;
	}
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.REMOVE;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getRelationshipName() {
		return relationshipName;
	}
	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.className = realmCode.substituteRealmCode(this.className);
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new RemoveConstraint(StringUtils.replace(className, originalPackageName, newPackageName), relationshipName);
	}
}
