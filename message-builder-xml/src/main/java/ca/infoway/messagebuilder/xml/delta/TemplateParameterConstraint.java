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
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="template_parameter_change")
public class TemplateParameterConstraint extends Constraint{
	
	private static final long serialVersionUID = -2157145914870565347L;

	private String templateParameterName;
	private String originalTraversalName;
	private String newTraversalName;
	private String originalMessagePartName;
	private String newMessagePartName;
	
	public TemplateParameterConstraint() {
	}
	public TemplateParameterConstraint(String templateParameterName,
			String originalTraversalName, String newTraversalName,
			String originalMessagePartName, String newMessagePartName) {
		super();
		this.templateParameterName = templateParameterName;
		this.originalTraversalName = originalTraversalName;
		this.newTraversalName = newTraversalName;
		this.originalMessagePartName = originalMessagePartName;
		this.newMessagePartName = newMessagePartName;
	}
	public String getTemplateParameterName() {
		return templateParameterName;
	}
	public void setTemplateParameterName(String templateParameterName) {
		this.templateParameterName = templateParameterName;
	}
	public String getOriginalTraversalName() {
		return originalTraversalName;
	}
	public void setOriginalTraversalName(String originalTraversalName) {
		this.originalTraversalName = originalTraversalName;
	}
	public String getNewTraversalName() {
		return newTraversalName;
	}
	public void setNewTraversalName(String newTraversalName) {
		this.newTraversalName = newTraversalName;
	}
	public String getOriginalMessagePartName() {
		return originalMessagePartName;
	}
	public void setOriginalMessagePartName(String originalMessagePartName) {
		this.originalMessagePartName = originalMessagePartName;
	}
	public String getNewMessagePartName() {
		return newMessagePartName;
	}
	public void setNewMessagePartName(String newMessagePartName) {
		this.newMessagePartName = newMessagePartName;
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
		return ConstraintChangeType.CHANGE_TEMPLATE_PARAMETER;
	}
	
	@Override
	void assignRealmCode(RealmCode realmCode) {
		super.assignRealmCode(realmCode);
		this.originalMessagePartName = realmCode.substituteRealmCode(this.originalMessagePartName);
		this.newMessagePartName = realmCode.substituteRealmCode(this.newMessagePartName);
	}
}
