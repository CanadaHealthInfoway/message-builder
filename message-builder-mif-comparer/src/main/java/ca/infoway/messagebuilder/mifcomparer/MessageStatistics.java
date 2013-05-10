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

package ca.infoway.messagebuilder.mifcomparer;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MessageStatistics {
	private static final String NEWLINE = System.getProperty("line.separator");

	/**
	 * Several groups of statistics are accumulated separately, each in its own Map;
	 * this lists the various groups. 
	 */
	enum StatisticsGroup {
		PER_FILE {
			public String toFriendlyString() {
				return "Per-file statistics";
			}
		},
			
		XML_DIFFS {
			public String toFriendlyString() {
				return "XML differences";
			}
		},
		
		OTHER {
			public String toFriendlyString() {
				return "Other messages";
			}
		},

		BY_XPATH {
			public String toFriendlyString() {
				return "By XPath";
			}
		};
		
		public String toFriendlyString() {
			return this.toString();
		}
	};

	/**
	 * Where the statistics are stored.
	 * Each entry's value maps a statistic to the count seen.
	 * E.g.<pre>
	 * 		stats.get(OTHER).get("foo")
	 * gives the number of times statistic "foo" has been tallied in the "OTHER" group. 
	 */
	private Map<StatisticsGroup, Map<String, Integer>> stats;
	
	public MessageStatistics() {
		stats = new HashMap<StatisticsGroup, Map<String, Integer>>();
		
		for (StatisticsGroup sg : StatisticsGroup.values()) {
			stats.put(sg, new HashMap<String, Integer>());
		}
	}
	
	public Map<String, Integer> getStatisticsFor(StatisticsGroup sg) {
		return this.stats.get(sg);
	}

	public void ensureDefined(StatisticsGroup sg, String key) {
		Map<String, Integer> groupStats = getStatisticsFor(sg);
		if (groupStats.get(key) == null)
			groupStats.put(key, 0);
	}
	
	public void tally(StatisticsGroup sg, String key) {
		Map<String, Integer> groupStats = getStatisticsFor(sg);
		Integer value = groupStats.get(key);
		groupStats.put(key, value==null ? 1 : value + 1);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String separator = "";
		
		for (StatisticsGroup sg : StatisticsGroup.values()) {
			sb.append(separator);
			separator = NEWLINE;
			
			sb.append(sg.toFriendlyString());
			sb.append(":");
			sb.append(NEWLINE);
			
			Map<String, Integer> s = stats.get(sg);
			if (s.isEmpty()) {
				sb.append("\t(none)");
				sb.append(NEWLINE);
			} else {
				for (String k : new TreeSet<String>(s.keySet())) {		// Use a TreeSet to sort each group on "key"
					sb.append(String.format("%5d\t%s%n", s.get(k), k));
				}
			}	
		}
		
		return sb.toString();
		
	}

}
