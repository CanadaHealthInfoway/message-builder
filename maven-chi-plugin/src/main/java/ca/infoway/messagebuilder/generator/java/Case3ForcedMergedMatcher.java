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

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;

public class Case3ForcedMergedMatcher extends Case3FuzzyMatcher {

	private final ForcedMatchManager forcedMatchManager;
	private boolean greatBigSwitch = false;

	public Case3ForcedMergedMatcher(LogUI log, SimplifiableTypeProvider definitions, 
			ClusterProvider clusterProvider,
			Case3MergeResult result, ForcedMatchManager forcedMatchManager) {
		super(log, definitions, clusterProvider, result, forcedMatchManager);
		this.forcedMatchManager = forcedMatchManager;
	}

	@Override
	public boolean matchAllTypes() {
		boolean result = super.matchAllTypes();
		
		if (!result && !this.greatBigSwitch) {
			this.greatBigSwitch = true;
			this.log.log(LogLevel.INFO, "Now processing items that must be forced to match.");
			forceTheCriticalTypesToMerge();
		}
		return result;
	}

	private void forceTheCriticalTypesToMerge() {
		for (Tuple<String> tuple : this.forcedMatchManager.getSpecificMatches()) {
			List<SimplifiableType> matches = new ArrayList<SimplifiableType>();

			SimplifiableType type1 = this.definitions.getType(tuple.getName1());
			SimplifiableType type2 = this.definitions.getType(tuple.getName2());
			
			if (this.mergeResult.isKnownMatch(type1, type2)) {
				this.log.log(LogLevel.INFO, "Necessary merge types " 
						+ type1.getName() + " and " + type2.getName() + " are already merged.");
			} else if (!type1.isAbstract() && !type2.isAbstract()) {
				this.log.log(LogLevel.INFO, "In order to support multiple versions we need to get " 
						+ type1.getName() + " and " + type2.getName() + " to merge");
				
				matches.add(type1);
				matches.add(type2);
				if (!performFinalMatchChecks(type1, matches)) {
					this.log.log(LogLevel.INFO, "The types " 
							+ type1.getName() + " and " + type2.getName() + " did not merge.");
				}
			} else if ((!type1.isAbstract()) || !type2.isAbstract()) {
				this.log.log(LogLevel.INFO, "Inconsistent level of abstractness between: " 
						+ type1.getName() + " and " + type2.getName() + ".  Not merged.");
			} else {
				this.log.log(LogLevel.INFO, "Both of these types, " 
						+ type1.getName() + " and " + type2.getName() + ", are abstract.  Not merged.");
			}
		}
	}
	
	@Override
	boolean hasNameCollision(SimplifiableType otherType, SimplifiableRelationship relationship) {
		boolean result = super.hasNameCollision(otherType, relationship);
		if (result && this.greatBigSwitch && relationship.isAssociation() 
				&& otherType.getRelationship(relationship.getName()).isAssociation()) {
			result = false;
		}
		return result;
	}
}
