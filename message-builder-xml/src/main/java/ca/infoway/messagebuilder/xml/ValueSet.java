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
import org.simpleframework.xml.ElementList;

public class ValueSet {
	
	@Attribute
	private String name;
	@Attribute
	private String codeSystem;
	@ElementList(required=false,inline=true,entry="contextBinding")
	private List<ContextBinding> contextBindings = new ArrayList<ContextBinding>();

	public ValueSet() {
	}
	public ValueSet(String name, String codeSystem) {
		this.setName(name);
		this.setCodeSystem(codeSystem);
	}
	public String getName() {
		return this.name;
	}
	public String getCodeSystem() {
		return this.codeSystem;
	}
	public List<ContextBinding> getContextBindings() {
		return this.contextBindings;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}
	public void setContextBindings(List<ContextBinding> contextBindings) {
		this.contextBindings = contextBindings;
	}
}
