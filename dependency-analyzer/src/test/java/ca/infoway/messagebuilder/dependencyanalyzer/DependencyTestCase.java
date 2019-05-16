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

package ca.infoway.messagebuilder.dependencyanalyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.dependencyanalyzer.DirectedGraph;

public abstract class DependencyTestCase {

	protected DirectedGraph<String> createSimpleGraphWithCycles() {
		Set<String> all = asSet("steve", "ken", "diana", "dion", "bc", "play-doh");
		Map<String,Set<String>> efferents = new HashMap<String, Set<String>>();
		efferents.put("steve", asSet("diana", "dion"));
		efferents.put("diana", asSet("dion"));
		efferents.put("ken", asSet("diana", "steve", "bc"));
		efferents.put("dion", asSet("ken"));
		efferents.put("bc", asSet("play-doh"));

		return new DirectedGraph<String>(all, efferents);
	}

	protected DirectedGraph<String> createSimpleGraphWithSelfCycle() {
		Set<String> all = asSet("steve", "ken", "diana", "dion", "bc", "play-doh");
		Map<String,Set<String>> efferents = new HashMap<String, Set<String>>();
		efferents.put("steve", asSet("diana", "dion"));
		efferents.put("diana", asSet("dion"));
		efferents.put("ken", asSet("diana", "steve", "bc"));
		efferents.put("dion", asSet("dion"));
		efferents.put("bc", asSet("play-doh"));

		return new DirectedGraph<String>(all, efferents);
	}
	protected DirectedGraph<String> createSimpleGraphWithNoCycles() {
		Set<String> all = asSet("steve", "ken", "diana", "dion", "bc", "play-doh");
		Map<String,Set<String>> efferents = new HashMap<String, Set<String>>();
		efferents.put("steve", asSet("diana", "dion"));
		efferents.put("diana", asSet("dion"));
		efferents.put("ken", asSet("diana", "steve", "bc"));
		efferents.put("bc", asSet("play-doh"));

		return new DirectedGraph<String>(all, efferents);
	}

	private Set<String> asSet(String... strings) {
		return new HashSet<String>(Arrays.asList(strings));
	}

}
