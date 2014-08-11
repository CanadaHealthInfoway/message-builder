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
 * Contains the class to be cloned.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="clone_change")
public class CloneConstraint extends Constraint {

	private static final long serialVersionUID = -1110902372841865980L;
	
	private String className;
	private String relationshipName;
	private String originalClassName;

	public CloneConstraint() {
	}
	public CloneConstraint(String className, String relationshipName, String originalClassName) {
		this.className = className;
		this.relationshipName = relationshipName;
		this.originalClassName = originalClassName;
	}
	@Override
	public String getAsString() {
		String returnString = "as string clone class=" +	getClassName();
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
		return ConstraintChangeType.CLONE;
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
	public String getOriginalClassName() {
		return originalClassName;
	}
	public void setOriginalClassName(String originalClassName) {
		this.originalClassName = originalClassName;
	}
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.className = realmCode.substituteRealmCode(this.className);
	}
	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new CloneConstraint(StringUtils.replace(className, originalPackageName, newPackageName), relationshipName, originalClassName);
	}
}
