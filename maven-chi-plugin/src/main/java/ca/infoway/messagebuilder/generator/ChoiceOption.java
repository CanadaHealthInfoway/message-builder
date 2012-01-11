/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

class ChoiceOption {
	
	private String relationshipName;
	private String type;
	
	private List<ChoiceOption> options;
	
	@SuppressWarnings("unchecked")
	public ChoiceOption(String relationshipName, String type) {
		this(relationshipName, type, Collections.EMPTY_LIST);
	}
	public ChoiceOption(String relationshipName, String type, List<ChoiceOption> options) {
		this.relationshipName = relationshipName;
		this.type = type;
		this.options = Collections.unmodifiableList(new ArrayList<ChoiceOption>(options));
	}
	
	public String getRelationshipName() {
		return this.relationshipName;
	}
	public String getType() {
		return this.type;
	}
	public List<ChoiceOption> getOptions() {
		return this.options;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("relationshipName", this.relationshipName)
			.append("type", this.type)
			.toString();
	}
}
