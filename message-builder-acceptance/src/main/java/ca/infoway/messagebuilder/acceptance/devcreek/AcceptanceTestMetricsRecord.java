/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

public class AcceptanceTestMetricsRecord extends MetricsRecord {

	private final String groupName;
	private final AcceptanceTestMetrics metrics;
	private final String language;

	public AcceptanceTestMetricsRecord(String groupName, String language, AcceptanceTestMetrics metrics) {
		this.groupName = groupName;
		this.language = language;
		this.metrics = metrics;
	}

	@Override
	public Map<String, String> getRecord() {
		Map<String, String> record = super.getRecord();
		record.put("acceptanceTestsMetrics.groupName", this.groupName);
		record.put("acceptanceTestsMetrics.name", this.metrics.getName());
		record.put("acceptanceTestsMetrics.language", this.language);
		record.put("acceptanceTestsMetrics.numSuccessful", String.valueOf(this.metrics.getNumSuccessful()));
		record.put("acceptanceTestsMetrics.numTotal", String.valueOf(this.metrics.getNumTotal()));
		record.put("acceptanceTestsMetrics.messages", XmlStringEscape.escape(convertList(this.metrics.getMessages())));
		return record;
	}

	private String convertList(List<String> messages) {
		return StringUtils.join(messages, "^^^");
	}

	@Override
	public String getCoreType() {
		return "acceptanceTestsMetrics.acceptanceTestMetrics";
		
	}

}
