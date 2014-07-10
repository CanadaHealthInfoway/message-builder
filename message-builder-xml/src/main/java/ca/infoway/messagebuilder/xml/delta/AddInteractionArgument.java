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

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Contains the entry to be added.
 */
@Entity
public class AddInteractionArgument implements Serializable {
	
	private static final long serialVersionUID = 7839474523548026273L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String templateParameterName;
	private String traversalName;
	private String messagePartName;
	
	public AddInteractionArgument() {
	}

	public AddInteractionArgument(String templateParameterName,
			String traversalName, String messagePartName) {
		super();
		this.templateParameterName = templateParameterName;
		this.traversalName = traversalName;
		this.messagePartName = messagePartName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateParameterName() {
		return templateParameterName;
	}

	public void setTemplateParameterName(String templateParameterName) {
		this.templateParameterName = templateParameterName;
	}

	public String getTraversalName() {
		return traversalName;
	}

	public void setTraversalName(String traversalName) {
		this.traversalName = traversalName;
	}

	public String getMessagePartName() {
		return messagePartName;
	}

	public void setMessagePartName(String messagePartName) {
		this.messagePartName = messagePartName;
	}
}
