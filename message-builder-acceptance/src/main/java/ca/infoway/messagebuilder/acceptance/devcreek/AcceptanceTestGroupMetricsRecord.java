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

package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.Map;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;

public class AcceptanceTestGroupMetricsRecord extends MetricsRecord {

	private final AcceptanceTestGroupMetrics metrics;

	public AcceptanceTestGroupMetricsRecord(AcceptanceTestGroupMetrics metrics) {
		this.metrics = metrics;
	}

	@Override
	public Map<String, String> getRecord() {
		Map<String, String> record = super.getRecord();	
		record.put("acceptanceTestsMetrics.groupName", this.metrics.getGroupName());
		record.put("acceptanceTestsMetrics.groupDescription", this.metrics.getGroupDescription());
		record.put("acceptanceTestsMetrics.language", this.metrics.getLanguage().getLanguageLiteral());
		record.put("acceptanceTestsMetrics.overallNumSuccessful", String.valueOf(this.metrics.getOverallSuccessful()));
		record.put("acceptanceTestsMetrics.overallNumTotal", String.valueOf(this.metrics.getOverallTotal()));
		return record;
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.acceptanceTestGroupMetrics";
		
	}

	public static AcceptanceTestGroupMetricsRecord create(AcceptanceTestGroupMetrics metrics) {
		return new AcceptanceTestGroupMetricsRecord(metrics);
	}
}
