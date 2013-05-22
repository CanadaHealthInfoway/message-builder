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
package ca.infoway.demiftifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;

public class VocabularyLayout implements Layout {

	private Map<String,VocabularyLayoutItem> items = new HashMap<String,VocabularyLayoutItem>();

	private MessageSet messageSet;
	private String conceptDomainName;
	
	public VocabularyLayout(MessageSet messageSet, String conceptDomainName) {
		this.messageSet = messageSet;
		this.conceptDomainName = conceptDomainName;
	}
	
	@Override
	public Collection<LayoutItem> getItems() {
		Collection<LayoutItem> result = new ArrayList<LayoutItem>();
//		ConceptDomainLayoutItem conceptDomainLayoutItem = new ConceptDomainLayoutItem(getConceptDomain());
//		result.add(conceptDomainLayoutItem);
		result.addAll(getLayoutItems());
		return result;
	}

	private Collection<VocabularyLayoutItem> getLayoutItems() {
		Collection<VocabularyLayoutItem> result = new ArrayList<VocabularyLayoutItem>();
		for (VocabularyLayoutItem layoutItem : items.values()) {
			if (layoutItem.isAlreadyLayedOut()) {
				result.add(layoutItem);
			}
		}
		return result;
	}

	public ConceptDomain getConceptDomain() {
		for (ConceptDomain conceptDomain : this.messageSet.getVocabulary().getConceptDomains()) {
			if (conceptDomainName.equals(conceptDomain.getName())) {
				return conceptDomain;
			}
		}
		return null;
	}

	@Override
	public MessageSet getMessageSet() {
		return messageSet;
	}
	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public String getConceptDomainName() {
		return conceptDomainName;
	}
	public void setConceptDomainName(String conceptDomainName) {
		this.conceptDomainName = conceptDomainName;
	}
	
	public VocabularyLayoutItem createItem(ValueSet valueSet) {
		if(!items.containsKey(DomainSource.VALUE_SET.name() + "_" + valueSet.getName())) {
			items.put(DomainSource.VALUE_SET.name() + "_" + valueSet.getName(), new VocabularyLayoutItem(valueSet, this));
		}
		
		return items.get(DomainSource.VALUE_SET.name() + "_" + valueSet.getName());
	}
	
	public VocabularyLayoutItem createItem(ConceptDomain conceptDomain) {
		if(!items.containsKey(DomainSource.CONCEPT_DOMAIN.name() + "_" + conceptDomain.getName())) {
			items.put(DomainSource.CONCEPT_DOMAIN.name() + "_" + conceptDomain.getName(), new VocabularyLayoutItem(conceptDomain, this));
		}
		
		return items.get(DomainSource.CONCEPT_DOMAIN.name() + "_" + conceptDomain.getName());
	}
	
	public VocabularyLayoutItem createItem(CodeSystem codeSystem) {
		if(!items.containsKey(DomainSource.CODE_SYSTEM.name() + "_" + codeSystem.getName())) {
			items.put(DomainSource.CODE_SYSTEM.name() + "_" + codeSystem.getName(), new VocabularyLayoutItem(codeSystem, this));
		}
		
		return items.get(DomainSource.CODE_SYSTEM.name() + "_" + codeSystem.getName());
	}
}
