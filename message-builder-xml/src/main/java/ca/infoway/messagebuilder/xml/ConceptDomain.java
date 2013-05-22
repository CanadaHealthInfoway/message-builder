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

public class ConceptDomain {

	@Attribute
	private String name;
	@Attribute(required=false)
	private String owningSCWG;
	@Attribute(required=false)
	private String riskOfChange;
	@Element(required=false)
	private Documentation documentation = new Documentation();
	@ElementList(required=false,inline=true,entry="specializes")
	private List<String> parentConceptDomains = new ArrayList<String>();
	
	public ConceptDomain() {
	}
	public ConceptDomain(String name) {
		this.name = name;
	}
	public ConceptDomain(String name, List<String> parentConceptDomains) {
		this(name);
		if (parentConceptDomains != null) {
			this.getParentConceptDomains().addAll(parentConceptDomains);
		}
	}

	public String getName() {
		return this.name;
	}

	public List<String> getParentConceptDomains() {
		return this.parentConceptDomains;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setParentConceptDomains(List<String> parentConceptDomains) {
		this.parentConceptDomains = parentConceptDomains;
	}
	public void addParent(String parentConceptDomain) {
		this.parentConceptDomains.add(parentConceptDomain);
	}
	public String getOwningSCWG() {
		return owningSCWG;
	}
	public void setOwningSCWG(String owningSCWG) {
		this.owningSCWG = owningSCWG;
	}
	public String getRiskOfChange() {
		return riskOfChange;
	}
	public void setRiskOfChange(String riskOfChange) {
		this.riskOfChange = riskOfChange;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
}
