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

import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.ValueSet;

public class InboundVocabularyElement extends InboundElement {

	private ValueSet valueSet;
	private CodeSystem codeSystem;
	private ConceptDomain conceptDomain;
	private DomainSource vocabType;
	
	public InboundVocabularyElement(CodeSystem codeSystem, int inboundArrowDepth) {
		super(inboundArrowDepth);
		this.codeSystem = codeSystem;
		this.vocabType = DomainSource.CODE_SYSTEM;
	}
	
	public InboundVocabularyElement(ValueSet valueSet, int inboundArrowDepth) {
		super(inboundArrowDepth);
		this.valueSet = valueSet;
		this.vocabType = DomainSource.VALUE_SET;
	}

	public InboundVocabularyElement(ConceptDomain conceptDomain, int inboundArrowDepth) {
		super(inboundArrowDepth);
		this.conceptDomain = conceptDomain;
		this.vocabType = DomainSource.CONCEPT_DOMAIN;
	}
	
	@Override
	public String getName() {
		if (DomainSource.VALUE_SET.equals(getVocabType())) {
			return valueSet.getName();
		} else if (DomainSource.CONCEPT_DOMAIN.equals(getVocabType())) {
			return conceptDomain.getName();
		}
		return null;
	}
	
	public ValueSet getValueSet() {
		return valueSet;
	}

	public void setValueSet(ValueSet valueSet) {
		this.valueSet = valueSet;
	}

	public ConceptDomain getConceptDomain() {
		return conceptDomain;
	}

	public void setConceptDomain(ConceptDomain conceptDomain) {
		this.conceptDomain = conceptDomain;
	}

	public DomainSource getVocabType() {
		return vocabType;
	}

	public CodeSystem getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(CodeSystem codeSystem) {
		this.codeSystem = codeSystem;
	}
}
