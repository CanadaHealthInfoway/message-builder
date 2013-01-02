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

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Vocabulary {
	
	@ElementList(inline=true,required=false,entry="valueSet")
	private List<ValueSet> valueSets = new ArrayList<ValueSet>();

	@ElementList(inline=true,required=false,entry="conceptDomain")
	private List<ConceptDomain> conceptDomains = new ArrayList<ConceptDomain>();

	public List<ValueSet> getValueSets() {
		return this.valueSets;
	}

	public List<ConceptDomain> getConceptDomains() {
		return this.conceptDomains;
	}

	public void setValueSets(List<ValueSet> valueSets) {
		this.valueSets = valueSets;
	}

	public void setConceptDomains(List<ConceptDomain> conceptDomains) {
		this.conceptDomains = conceptDomains;
	}
	
}
