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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name="vocabularyModel",strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifVocabularyModel {

	@Element(required=false)
	private MifIdentifier packageLocation;

	@ElementList(entry="conceptDomain",required=false,inline=true)
	private List<MifConceptDomain> conceptDomains = new ArrayList<MifConceptDomain>();

	@ElementList(entry="valueSet",required=false,inline=true)
	private List<MifValueSet> valueSets = new ArrayList<MifValueSet>();
		
	@ElementList(entry="contextBinding",required=false,inline=true)
	private List<MifContextBinding> contextBindings = new ArrayList<MifContextBinding>();

	public MifIdentifier getPackageLocation() {
		return this.packageLocation;
	}

	public List<MifConceptDomain> getConceptDomains() {
		return this.conceptDomains;
	}

	public List<MifValueSet> getValueSets() {
		return this.valueSets;
	}

	public List<MifContextBinding> getContextBindings() {
		return this.contextBindings;
	}
}
