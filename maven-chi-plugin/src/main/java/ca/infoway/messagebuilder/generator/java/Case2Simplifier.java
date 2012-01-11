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

package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class Case2Simplifier extends InlineableSimplifier {

	class SimplifiableReference {
		private final SimplifiableRelationship relationship;
		private final SimplifiableType type;
		
		public SimplifiableReference(SimplifiableType type, SimplifiableRelationship relationship) {
			this.type = type;
			this.relationship = relationship;
		}
		public SimplifiableRelationship getRelationship() {
			return this.relationship;
		}
		public SimplifiableType getType() {
			return this.type;
		}
	}
	
	private Set<String> nonInlineableTypes = Collections.synchronizedSet(new HashSet<String>());
	private final Case1Simplifier case1Simplifier;
	private final SimplifiableDefinitions definitions;
	
	public Case2Simplifier(LogUI log, SimplifiableDefinitions definitions) {
		super(log, definitions);
		this.definitions = definitions;
		this.case1Simplifier = new Case1Simplifier(log, definitions);
	}

	@Override
	public void execute() {
		analyze();
		super.execute();
	}
	
	private void analyze() {
		for (SimplifiableType type : this.definitions.getAllTypes()) {
			if (type.getRelationships().size() >= 7) {
				this.nonInlineableTypes.add(type.getName());
			}
		}
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (inlineableType.getMessagePart().isAbstract()) {
			result = false;
		} else if (isTemplateRelationshipPresent(inlineableType)) {
			result = false;
		} else if (!isUsedExactlyOnce(complexTypePackage, inlineableType)) {
			// if used more than once do not inline - we don't want to denormalize unnecessarily; 
			result = false;
		} else {
			List<SimplifiableReference> references = getAllSimplifiableReferencesToType(
					getPotentialReferrers(complexTypePackage, inlineableType), inlineableType);
			result = validateReferences(complexTypePackage, inlineableType, references);
		}
		
		return result;
	}
	
	private boolean isTemplateRelationshipPresent(SimplifiableType inlineableType) {
		boolean result = false;
		for (SimplifiableRelationship relationship : inlineableType.getRelationships()) {
			if (relationship.isTemplateParameterPresent()) {
				result = true;
				break;
			}
		}
		return result;
	}

	private Collection<SimplifiableType> getPotentialReferrers(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		return this.definitions.getAllTypes();
	}

	private boolean validateReferences(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType, List<SimplifiableReference> references) {
		boolean result = !references.isEmpty();
		for (SimplifiableReference reference : references) {
			result &= validateReference(complexTypePackage, inlineableType, reference);
		}
		return result;
	}
	
	private List<SimplifiableReference> getAllSimplifiableReferencesToType(Collection<SimplifiableType> values, SimplifiableType inlineableType) {
		List<SimplifiableReference> result = new ArrayList<SimplifiableReference>();
		for (SimplifiableType type : values) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					result.add(new SimplifiableReference(type, relationship));
				}
			}
		}
		return result;
	}
	
	private boolean validateReference(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType, SimplifiableReference reference) {
		boolean result = true;
		
		SimplifiableRelationship relationship = reference.getRelationship();
		if (relationship.getRelationship().getCardinality().isMultiple()) {
			result = false;
		} else if (this.nonInlineableTypes.contains(reference.getType().getMessagePart().getName())) {
			result = false;
		} else if (ObjectUtils.equals(inlineableType.getName(), reference.getType().getName())) {
			return false;
		} else if (this.case1Simplifier.isInlineable(complexTypePackage, reference.getType())) {
			return false;
		} else if (EXACTLY_ONE.equals(relationship.getRelationship().getCardinality())) {
			result = true;
		} else {
			// must have at least one mandatory property in order to avoid ambiguity with collapsed relationships (parent is nullflavor vs parent has child and all child relationships are nullflavor)
			result = hasAtLeastOneMandatoryProperty(inlineableType);
		}
		
		return result && !relationship.getRelationship().getConformance().equals(ConformanceLevel.POPULATED);
	}
	
	private boolean hasAtLeastOneMandatoryProperty(SimplifiableType inlineableType) {
		boolean result = false;
		for (SimplifiableRelationship relationship : inlineableType.getRelationships()) {
			if (relationship.getRelationship().getCardinality().getMin() == 1) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private boolean isUsedExactlyOnce(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		int count = 0;
		for (SimplifiableType type : complexTypePackage.getTypes()) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					count++;
				}
			}
		}
		return count == 1;
	}
}
