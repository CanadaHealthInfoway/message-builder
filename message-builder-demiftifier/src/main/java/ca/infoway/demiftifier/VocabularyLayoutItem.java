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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.ValueSet;

public class VocabularyLayoutItem implements LayoutItem {
	private int logicalX = -1;
	private int logicalY = -1;
	private int height = 1;
	private int width = 1;
	
	private InboundVocabularyElement inboundVocabularyElement;
	
	private ValueSet valueSet;
	private CodeSystem codeSystem;
	private ConceptDomain conceptDomain;
	private Set<ValueSet> boundValueSets = new HashSet<ValueSet>();
	private Set<CodeSystem> drawsFromCodeSystems = new HashSet<CodeSystem>();
	private DomainSource vocabType;
	
	private VocabularyLayoutItem parentItem;
	private VocabularyLayout layout;
	private int encroachmentLevel;
	
	public VocabularyLayoutItem(ValueSet valueSet, VocabularyLayout layout) {
		this.valueSet = valueSet;
		this.layout = layout;
		this.vocabType = DomainSource.VALUE_SET;
	}
	
	public VocabularyLayoutItem(ConceptDomain conceptDomain,  VocabularyLayout layout) {
		this.conceptDomain = conceptDomain;
		this.layout = layout;
		this.vocabType = DomainSource.CONCEPT_DOMAIN;
	}
	
	public VocabularyLayoutItem(CodeSystem codeSystem, VocabularyLayout layout) {
		this.codeSystem = codeSystem;
		this.layout = layout;
		this.vocabType = DomainSource.CODE_SYSTEM;
	}

	public VocabularyLayoutItem(VocabularyLayoutItem parentItem, ValueSet valueSet, VocabularyLayout layout) {
		this.valueSet = valueSet;
		this.layout = layout;
		this.parentItem = parentItem;
		this.vocabType = DomainSource.VALUE_SET;
	}
	
	public VocabularyLayoutItem(VocabularyLayoutItem parentItem, ConceptDomain conceptDomain, VocabularyLayout layout) {
		this.conceptDomain = conceptDomain;
		this.layout = layout;
		this.parentItem = parentItem;
		this.vocabType = DomainSource.CONCEPT_DOMAIN;
	}
	
	public VocabularyLayoutItem(VocabularyLayoutItem parentItem, CodeSystem codeSystem, VocabularyLayout layout) {
		this.codeSystem = codeSystem;
		this.layout = layout;
		this.parentItem = parentItem;
		this.vocabType = DomainSource.CODE_SYSTEM;
	}
	
	@Override
	public int getLogicalX() {
		return logicalX;
	}
	public void setLogicalX(int logicalX) {
		this.logicalX = logicalX;
	}
	
	@Override
	public int getLogicalY() {
		return logicalY;
	}
	public void setLogicalY(int logicalY) {
		this.logicalY = logicalY;
	}

	@Override
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	@Override
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String getName() {
		if(DomainSource.CODE_SYSTEM.equals(getVocabType())) {
			return getCodeSystem().getName();
		} else if (DomainSource.VALUE_SET.equals(getVocabType())) {
			return getValueSet().getName();			
		} else if (DomainSource.CONCEPT_DOMAIN.equals(getVocabType())) {
			return getConceptDomain().getName();
		}
		return null;
	}

	@Override
	public String getLabel() {
		if(DomainSource.CODE_SYSTEM.equals(getVocabType())) {
			return getCodeSystem().getName();
		} else if (DomainSource.VALUE_SET.equals(getVocabType())) {
			return getValueSet().getName();			
		} else if (DomainSource.CONCEPT_DOMAIN.equals(getVocabType())) {
			return getConceptDomain().getName();
		}
		return null;
	}
	
	public String getSubLabel() {
		if(DomainSource.CODE_SYSTEM.equals(getVocabType())) {
			return "(Code System)";
		} else if (DomainSource.VALUE_SET.equals(getVocabType())) {
			return "(Value Set)";			
		} else if (DomainSource.CONCEPT_DOMAIN.equals(getVocabType())) {
			return "(Concept Domain)";
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

	public CodeSystem getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(CodeSystem codeSystem) {
		this.codeSystem = codeSystem;
	}

	public DomainSource getVocabType() {
		return vocabType;
	}

	public void setVocabType(DomainSource vocabType) {
		this.vocabType = vocabType;
	}

	public VocabularyLayout getLayout() {
		return layout;
	}

	public void setLayout(VocabularyLayout layout) {
		this.layout = layout;
	}

	public VocabularyLayoutItem getParentItem() {
		return parentItem;
	}

	public void setParentItem(VocabularyLayoutItem parentItem) {
		this.parentItem = parentItem;
	}

	public boolean isAlreadyLayedOut() {
		return this.logicalX >= 0 && this.logicalY >= 0;
	}

	public VocabularyLayoutItem getTopAncestor() {
		if (this.parentItem == null) {
			return this;
		} else {
			return this.parentItem.getTopAncestor();
		}
	}

	public Set<ValueSet> getBoundValueSets() {
		return boundValueSets;
	}

	public void setBoundValueSets(Set<ValueSet> boundValueSets) {
		this.boundValueSets = boundValueSets;
	}

	public Set<CodeSystem> getDrawsFromCodeSystems() {
		return drawsFromCodeSystems;
	}

	public void setDrawsFromCodeSystems(Set<CodeSystem> drawsFromCodeSystems) {
		this.drawsFromCodeSystems = drawsFromCodeSystems;
	}
	
	public int getVocabDepth() {
		if (this.parentItem == null) {
			return 0;
		} else {
			return 1 + this.parentItem.getVocabDepth();
		}
	}
	
	@Override
	public InboundVocabularyElement getInboundElement() {
		return this.inboundVocabularyElement;
	}

	public void setInboundElement(InboundVocabularyElement inboundElement) {
		this.inboundVocabularyElement = inboundElement;
	}
	

	public int getEncroachmentLevel() {
		return encroachmentLevel;
	}

	public void setEncroachmentLevel(int encroachmentLevel) {
		this.encroachmentLevel = encroachmentLevel;
	}


	//TODO: NOT NEEDED In this class, need to clean up the interface a bit later as it was originally built for only message parts/packages
	@Override
	public RimClass getRimClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> getAttributes() {
		return new ArrayList<Relationship>();
	}

	@Override
	public PackageLocation getPackageLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship getFirstOutgoingAssociation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDuplicate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCmet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSpecialization() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRootType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CmetBinding getCmetBinding() {
		// TODO Auto-generated method stub
		return null;
	}
}
