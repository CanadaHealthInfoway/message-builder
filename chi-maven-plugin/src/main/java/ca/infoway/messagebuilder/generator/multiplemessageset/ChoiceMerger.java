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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Relationship;

class ChoiceMerger implements Merger<Relationship> {

	private final MergeContext context;
	private final RelationshipsMerger choicesMerger;
	private final MessageSetMergeHelper mergeHelper;
	private Relationship result;

	ChoiceMerger(MergeContext context) {
		this(context, new RelationshipsMerger(context, true));
	}

	ChoiceMerger(MergeContext context, RelationshipsMerger relationshipsMerger) {
		this.context = context;
		this.choicesMerger = relationshipsMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public Relationship merge(Relationship primary, Relationship secondary) {
		
		if (primary == null || secondary == null) {
			this.result = (primary == null ? secondary : primary);
			this.mergeHelper.addMissingDifference(this.context, this.result, secondary == null);
		} else {
			this.result = new Relationship();
			mergeName(primary.getName(), secondary.getName());
			mergeType(primary, secondary);
			mergeChoices(primary.getChoices(), secondary.getChoices());
		}
		
		return result;
	}

	// perhaps log some differences here when appropriate? 
	private void mergeChoices(List<Relationship> choices, List<Relationship> choices2) {
		List<Relationship> mergedChoices = this.choicesMerger.merge(choices, choices2);
		this.result.getChoices().addAll(mergedChoices);
	}

	private void mergeName(String name, String name2) {
		// should never be different at this point UNLESS we matched relationships based on identical association types
		if (!StringUtils.equals(name, name2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_RENAMED, name, name2);
		}
		this.result.setName(name);
	}

	private void mergeType(Relationship primary, Relationship secondary) {
		String type = primary.getType();
		String type2 = secondary.getType();
		String mergedType = this.mergeHelper.standardMerge(type, type2);
		if (!StringUtils.equals(type, type2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.CHOICE_RELATIONSHIP_TYPE, type, type2);
			
			if (primary.isChoice() != secondary.isChoice()) {
				this.mergeHelper.addDifference(this.context, this.result, DifferenceType.MESSAGE_PART_ABSTRACT, type, type2);
			}
			
		}
		this.result.setType(mergedType);
	}

}
