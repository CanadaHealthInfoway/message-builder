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
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class ValueSet {
	
	@Attribute
	private String name;
	@Attribute(required=false)
	private String id;
	@Attribute(required=false)
	private Date date;
	@Attribute(required=false)
	private String owningSCWG;
	@Attribute(required=false)
	private String codeSystem;
	@Attribute(required=false)
	private boolean complete = false;
	@Element(required=false)
	private Documentation documentation = new Documentation();
	@ElementList(required=false,inline=true,entry="contextBinding")
	private List<ContextBinding> contextBindings = new ArrayList<ContextBinding>();
	@ElementList(required=false,inline=true,entry="drawsFrom")
	private List<String> sourceCodeSystems = new ArrayList<String>();
	@ElementList(required=false,inline=false,name="content",entry="code")
	private List<Code> codes;
	@ElementList(required=false,inline=true,entry="filter")
	private List<ValueSetFilter> filters;

	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public ValueSet() {
	}
	public ValueSet(String name, String id) {
		this.setName(name);
		this.setId(id);
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public String getOwningSCWG() {
		return owningSCWG;
	}
	public void setOwningSCWG(String owningSCWG) {
		this.owningSCWG = owningSCWG;
	}
	public List<Code> getCodes() {
		return codes;
	}
	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}
	public void addCode(Code code) {
		if (this.codes == null) {
			this.codes = new ArrayList<Code>();
		}
		this.codes.add(code);
	}
	public List<String> getSourceCodeSystems() {
		return sourceCodeSystems;
	}
	public void setSourceCodeSystems(List<String> sourceCodeSystems) {
		this.sourceCodeSystems = sourceCodeSystems;
	}
	public List<ValueSetFilter> getFilters() {
		return filters;
	}
	public void setFilters(List<ValueSetFilter> filters) {
		this.filters = filters;
	}
	public void addFilter(ValueSetFilter filter) {
		if (this.filters == null) {
			this.filters = new ArrayList<ValueSetFilter>();
		}
		this.filters.add(filter);
	}
}
