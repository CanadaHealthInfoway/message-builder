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
import javax.persistence.Embeddable;

@Embeddable
public class ChoiceRelationshipName {

	@Column(nullable=false)
	private String choicePartType;
	private String oldName;
	private String newName;
	
	public ChoiceRelationshipName(String choicePartType, String oldName,
			String newName) {
		this.choicePartType = choicePartType;
		this.oldName = oldName;
		this.newName = newName;
	}
	public ChoiceRelationshipName() {
	}
	public String getChoicePartType() {
		return this.choicePartType;
	}
	public void setChoicePartType(String choicePartType) {
		this.choicePartType = choicePartType;
	}
	public String getOldName() {
		return this.oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return this.newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String toString() {
		return "{" + this.choicePartType + "} " + this.oldName + " => " + this.newName;
	}
}
