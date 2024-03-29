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

package ca.infoway.messagebuilder.generator.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ca.infoway.messagebuilder.generator.util.MatchType;
import ca.infoway.messagebuilder.generator.util.NameMatcher;
import ca.infoway.messagebuilder.xml.TypeName;

class ClusterAnalyzer implements ClusterProvider {

	class ComparatorImpl implements Comparator<TypeName> {
		public int compare(TypeName o1, TypeName o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	private static Set<MatchType> VALID_MATCHES = new HashSet<MatchType>(
			Arrays.asList(MatchType.EXACT, MatchType.MINOR_DIFFERENCE));
	private Map<TypeName,Cluster> clusters = Collections.synchronizedMap(new TreeMap<TypeName,Cluster>(new ComparatorImpl()));

	void cluster(SimplifiableType type, SimplifiableType otherType) {
		Cluster cluster = this.clusters.get(type.getTypeName());
		if (cluster == null) {
			cluster = this.clusters.get(otherType.getTypeName());
		} else {
			Cluster temp = this.clusters.get(otherType.getTypeName());
			if (temp != null && temp != cluster) {
				cluster.getTypes().addAll(temp.getTypes());
				for (SimplifiableType s : temp.getTypes()) {
					this.clusters.put(s.getTypeName(), cluster);
				}
			}
		}
		if (cluster == null) {
			cluster = new Cluster();
		}
		
		this.clusters.put(type.getTypeName(), cluster);
		this.clusters.put(otherType.getTypeName(), cluster);
		
		cluster.getTypes().add(type);
		cluster.getTypes().add(otherType);
	}
	
	public Collection<Cluster> getClusters() {
		return new LinkedHashSet<Cluster>(this.clusters.values());
	}
	
	void analyze(Collection<SimplifiableType> types) {
		List<SimplifiableType> temp = new ArrayList<SimplifiableType>(types);
		while (!temp.isEmpty()) {
			SimplifiableType type = temp.remove(0);
			for (SimplifiableType otherType : temp) {
				MatchType matchType = new NameMatcher().matchNames(type, otherType);
				if (VALID_MATCHES.contains(matchType)) {
					cluster(type, otherType);
				}
			}
		}
	}
}
