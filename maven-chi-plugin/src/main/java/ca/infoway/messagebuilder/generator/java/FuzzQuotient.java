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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.MatchType.ADDED;
import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MAJOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.REMOVED;
import static ca.infoway.messagebuilder.generator.java.MatchType.RENAMED;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.xml.TypeName;

enum FuzzQuotient implements Fuzziness {
	LEVEL_00, LEVEL_0, LEVEL_1;

	private static final Predicate DIFFERENCE_PREDICATE = PredicateUtils.equalPredicate(MAJOR_DIFFERENCE);
	private static final Predicate REMOVED_PREDICATE = PredicateUtils.equalPredicate(REMOVED);
	private static final Predicate ADDED_PREDICATE = PredicateUtils.equalPredicate(ADDED);
	private static final Predicate EXACT_OR_MINOR_OR_RENAMED_PREDICATE = PredicateUtils.orPredicate(
			PredicateUtils.orPredicate(
				PredicateUtils.equalPredicate(EXACT),
				PredicateUtils.equalPredicate(RENAMED)),
			PredicateUtils.equalPredicate(MatchType.MINOR_DIFFERENCE));
	
	
	public boolean isWorthChecking(SimplifiableType type, SimplifiableType otherType) {
		switch (this) {
		case LEVEL_00:
			return matchesTypePrefix(type, otherType) && matchesUnqualifiedName(type, otherType);
		case LEVEL_0:
			return matchesTypePrefix(type, otherType);
		default:
			return true;
		}
	}

	private boolean matchesUnqualifiedName(SimplifiableType type,
			SimplifiableType otherType) {
		TypeName name = new TypeName(type.getName());
		TypeName otherName = new TypeName(otherType.getName());
		return StringUtils.equals(name.getUnqualifiedName(), otherName.getUnqualifiedName());
	}

	private boolean matchesTypePrefix(SimplifiableType type, SimplifiableType otherType) {
		return StringUtils.equals(getTypePrefix(type), getTypePrefix(otherType));
	}

	private String getTypePrefix(SimplifiableType type) {
		return StringUtils.substringBefore(type.getName(), "_");
	}
	@Override
	public String toString() {
		return DescribableUtil.getDefaultDescription(name());
	}

	public boolean isSufficientOverlap(List<MatchType> matchTypes) {
		int numExact = CollectionUtils.countMatches(matchTypes, EXACT_OR_MINOR_OR_RENAMED_PREDICATE);
//		int numAdded = CollectionUtils.countMatches(matchTypes, ADDED_PREDICATE);
//		int numRemoved = CollectionUtils.countMatches(matchTypes, REMOVED_PREDICATE);
		int numMajorDifferences = CollectionUtils.countMatches(matchTypes, DIFFERENCE_PREDICATE);
		
		// must have at least 1 exact match, and no differences
		// current approach is then no more than 2 different properties, or no more than 25% of properties different 
		
//		int numTotal = numExact + numAdded + numRemoved;
//		int numDifferent = numAdded + numRemoved;
		return numExact > 0 
			&& numMajorDifferences == 0;
		
	}
	
}
