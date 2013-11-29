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
 * Last modified: $LastChangedDate: 2012-01-10 18:22:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3229 $
 */
package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Concept {

	@Attribute(required=false)
	private String code;
	@Attribute(required=false)
	private String displayName;
	@Attribute(required=false)
	private boolean selectable;
	@Attribute(required=false)
	private String status;

	@Element(required=false)
	private Documentation documentation = new Documentation();
	@ElementList(required=false,inline=true,entry="parentConcept")
	private List<String> parentConcepts;
	
	public Concept() {
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Documentation getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}

	public List<String> getParentConcepts() {
		return parentConcepts;
	}

	public void addParentConcept(String parentConcept) {
		if (this.parentConcepts == null) {
			this.parentConcepts = new ArrayList<String>();
		}
		this.parentConcepts.add(parentConcept);
	}
}
