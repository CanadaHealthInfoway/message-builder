/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipsMerger implements Merger<List<Relationship>> {

	private final MergeContext context;
	private final MessageSetMergeHelper mergeHelper;
	private final boolean forChoice;
	private List<Relationship> result;
	
	RelationshipsMerger(MergeContext context, boolean forChoice) {
		this.context = context;
		this.forChoice = forChoice;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public List<Relationship> merge(List<Relationship> relationships1, List<Relationship> relationships2) {
		this.result = new ArrayList<Relationship>();
		// hmmm - will order matter? Likely not, as we will only be using this merged messageset for api generation, not to produce a message or for validation 
		Map<String, Relationship> relationships2Map = new LinkedHashMap<String, Relationship>();
		for (Relationship relationship : relationships2) {
			relationships2Map.put(relationship.getName(), relationship);
		}
		
		for (Relationship relationship1 : relationships1) {
			Relationship relationship2 = pullOutMatchingRelationship(relationship1,	relationships2Map);
			Relationship mergedRelationship = createRelationshipMerger().merge(relationship1, relationship2);
			this.result.add(mergedRelationship);
		}
		
		for (Relationship relationship : relationships2Map.values()) {
			Relationship mergedRelationship = createRelationshipMerger().merge(null, relationship);
			this.result.add(mergedRelationship);
		}

		checkForDuplicateTypesOrNames(this.result);
		
		return this.result;
	}

	private void checkForDuplicateTypesOrNames(List<Relationship> relationships) {
		Set<String> types = new HashSet<String>();
		Set<String> names = new HashSet<String>();
		for (Relationship relationship : relationships) {
			if (!names.add(relationship.getName())) {
				this.mergeHelper.addDifference(this.context, relationship, DifferenceType.DUPLICATE_RELATIONSHIP_NAME, relationship.getName(), relationship.getName());
			}
			if (relationship.isAssociation() && !relationship.isTemplateRelationship()) {
				if (!types.add(relationship.getType())) {
					this.mergeHelper.addDifference(this.context, relationship, DifferenceType.DUPLICATE_ASSOCIATION_TYPE, relationship.getType(), relationship.getType());
				}
			}
		}
	}

	private Relationship pullOutMatchingRelationship(Relationship relationship1, Map<String, Relationship> relationships2Map) {
		Relationship matchResult = null;
		
		// look for a type match first - only for associations, and only if there is a unique match
		String type1 = relationship1.getType();
		if (relationship1.isAssociation() && StringUtils.isNotBlank(type1)) {
			for (Relationship relationship2 : relationships2Map.values()) {
				String type2 = relationship2.getType();
				if (StringUtils.equals(type1, type2)) {
					matchResult = relationship2;
					break;
				}
			}
		}
		
		if (matchResult == null) {
			matchResult = relationships2Map.remove(relationship1.getName());
		} else {
			relationships2Map.remove(matchResult.getName());
		}
		return matchResult;
	}

	Merger<Relationship> createRelationshipMerger() {
		return this.forChoice ? new ChoiceMerger(this.context) : new RelationshipMerger(this.context);
	}

}
