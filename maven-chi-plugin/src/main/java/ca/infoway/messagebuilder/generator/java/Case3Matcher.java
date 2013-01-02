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

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogUI;


abstract class Case3Matcher {
	
	private final LogUI log;
	protected final SimplifiableTypeProvider definitions;
	private final ClusterProvider clusterProvider;
	
	Case3Matcher(LogUI log, SimplifiableTypeProvider definitions, ClusterProvider clusterProvider) {
		this.log = log;
		this.definitions = definitions;
		this.clusterProvider = clusterProvider;
	}
	
	abstract String getDescription();
	abstract boolean performMatching(SimplifiableType type, List<SimplifiableType> types);

	boolean matchAllTypes() {
		boolean changes = false;
		
		for (Cluster cluster : this.clusterProvider.getClusters()) {
			List<SimplifiableType> types = new ArrayList<SimplifiableType>(cluster.getTypes());
			
			while (!types.isEmpty()) {
				SimplifiableType type = types.remove(0);
				
				boolean match = performMatching(type, types);
				this.log.log(DEBUG, "Simplification case 3: Now analyzing " + type.getTypeName() + ". " +
						(match ? "Candidate for simplification" : ""));
				changes |= match;
			}
		}

		return changes;
	}
}
