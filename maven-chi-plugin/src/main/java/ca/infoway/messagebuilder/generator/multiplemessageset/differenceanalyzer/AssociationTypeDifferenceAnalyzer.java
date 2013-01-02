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

package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import java.util.List;

import ca.infoway.messagebuilder.generator.java.MatchType;
import ca.infoway.messagebuilder.generator.java.NameMatcher;
import ca.infoway.messagebuilder.generator.multiplemessageset.NamedTypeImpl;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceMatch;
import ca.infoway.messagebuilder.xml.DifferenceValue;

public class AssociationTypeDifferenceAnalyzer implements DifferenceAnalyzer {

	private static final NameMatcher NAME_MATCHER = new NameMatcher(); 
	
	public AssociationTypeDifferenceAnalyzer() {
	}

//	public List<String> exceptions = Arrays.asList("ControlActEvent", "ActEvent", "ActRequest");
	
	public void analyze(Difference difference) {
//		boolean result = false;
//		List<DifferenceValue> differenceValues = difference.getDifferences();
//		if (differenceValues.size() == 2) {
//			if (differenceValues.size() == 2) {
//				String type1 = StringUtils.substringAfter(differenceValues.get(0).getValue(), ".");
//				String type2 = StringUtils.substringAfter(differenceValues.get(1).getValue(), ".");
//				if (exceptions.contains(type1) && exceptions.contains(type2)) {
//					result = true;
//				}
//			}
//		}
//		difference.setOk(result);
		boolean result = false;
		List<DifferenceValue> differenceValues = difference.getDifferences();
		if (differenceValues.size() == 2) {
			String type1 = differenceValues.get(0).getValue();
			String type2 = differenceValues.get(1).getValue();
			DifferenceMatch differenceMatch = determineTypeDifference(type1, type2);
			difference.setMatchConfidence(differenceMatch);
			
			// let later process decide on actual merits of match
			result = true;
		}
		difference.setOk(result);
	}

	private DifferenceMatch determineTypeDifference(String type1AsString, String type2AsString) {
		MatchType matchType = NAME_MATCHER.matchNames(new NamedTypeImpl(type1AsString), new NamedTypeImpl(type2AsString));
		return matchType == MatchType.MAJOR_DIFFERENCE ? DifferenceMatch.UNLIKELY_MATCH : DifferenceMatch.POSSIBLE_MATCH;
	}

}
