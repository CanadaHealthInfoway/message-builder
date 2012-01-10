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

package ca.infoway.messagebuilder.acceptance.metrics;

import java.util.ArrayList;
import java.util.List;

public class AcceptanceTestGroupMetrics {
	
	private final String groupName;
	private final AcceptanceTestLanguage language;
	private final List<AcceptanceTestMetrics> metrics = new ArrayList<AcceptanceTestMetrics>();
	private final String groupDescription;
	
	public AcceptanceTestGroupMetrics(String groupName, String groupDescription, AcceptanceTestLanguage language) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.language = language;
	}

	public String getGroupDescription() {
		return this.groupDescription;
	}

	public AcceptanceTestLanguage getLanguage() {
		return this.language;
	}

	public String getGroupName() {
		return this.groupName;
	}
	
	public List<AcceptanceTestMetrics> getMetrics() {
		return this.metrics;
	}

	public int getOverallSuccessful() {
		int sumSuccessful = 0;
		for (AcceptanceTestMetrics testMetrics : this.metrics) {
			sumSuccessful += testMetrics.getNumSuccessful();
		}
		return sumSuccessful;
	}
	
	public int getOverallTotal() {
		int sumTotal = 0;
		for (AcceptanceTestMetrics testMetrics : this.metrics) {
			sumTotal += testMetrics.getNumTotal();
		}
		return sumTotal;
	}
	
	public boolean hasData() {
		return !metrics.isEmpty();
	}
}
