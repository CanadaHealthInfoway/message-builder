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

package ca.infoway.messagebuilder.acceptance;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestGroupMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunEndedRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunStartedRecord;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AllAcceptanceGroupTestMetrics;
import ca.intelliware.commons.dependency.devcreek.Record;

public class AcceptanceTestsMetricsRecordCreator {

	public List<Record> create(AllAcceptanceGroupTestMetrics metrics) {
		List<Record> records = new ArrayList<Record>();
		
		records.add(new RunStartedRecord());
		processGroups(records, metrics.getGroupMetrics());
		records.add(new RunEndedRecord());
		
		return records;
	}

	private void processGroups(List<Record> records, List<AcceptanceTestGroupMetrics> groupMetrics) {
		for (AcceptanceTestGroupMetrics aGroupMetrics : groupMetrics) {
			records.add(new AcceptanceTestGroupMetricsRecord(aGroupMetrics));
			processGroup(records, aGroupMetrics);
		}
	}

	private void processGroup(List<Record> records, AcceptanceTestGroupMetrics aGroupMetrics) {
		for (AcceptanceTestMetrics acceptanceTestMetrics : aGroupMetrics.getMetrics()) {
			records.add(new AcceptanceTestMetricsRecord(aGroupMetrics.getGroupName(), aGroupMetrics.getLanguage().getLanguageLiteral(), acceptanceTestMetrics));
		}
	}

}
