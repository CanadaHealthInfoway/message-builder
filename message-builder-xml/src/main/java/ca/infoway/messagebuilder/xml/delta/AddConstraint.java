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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.xml.RimClass;

/**
 * Contains the entry to be added.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="add_change")
public class AddConstraint extends Constraint{
	
	private static final long serialVersionUID = 7839474523548026273L;
	
	private String className;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20,nullable=false)
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType", parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.RimClass")})		
	private RimClass rimClass;
	
	@Column(nullable=false)
	private Boolean isAbstract = false;
	
	public AddConstraint() {
	}
	public AddConstraint(String className, RimClass rimClass, Boolean isAbstract) {
		this.className = className;
		this.rimClass = rimClass;
		this.isAbstract = isAbstract;
	}
	@Deprecated
	public String getClassName() {
		return className;
	}
	@Deprecated
	public void setClassName(String className) {
		this.className = className;
	}
	public RimClass getRimClass() {
		return rimClass;
	}
	public void setRimClass(RimClass rimClass) {
		this.rimClass = rimClass;
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
		return ConstraintChangeType.ADD;
	}
	public Boolean getIsAbstract() {
		return isAbstract;
	}
	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.className = realmCode.substituteRealmCode(this.className);
	}
}
