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

package ca.infoway.messagebuilder.acceptance;

import java.util.List;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestLanguage;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;

public class AcceptanceTestsMetricsProcessor {

	private final List<AcceptanceTestRunner> acceptanceTestRunners;

	private final String groupName;
	private final AcceptanceTestLanguage language;
	private final String groupDescription;

	public AcceptanceTestsMetricsProcessor(String groupName, String groupDescription, AcceptanceTestLanguage language, List<AcceptanceTestRunner> acceptanceTestRunners) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.language = language;
		this.acceptanceTestRunners = acceptanceTestRunners;
	}

	String getGroupDescription() {
		return this.groupDescription;
	}

	String getGroupName() {
		return this.groupName;
	}

	AcceptanceTestLanguage getLanguage() {
		return this.language;
	}

	public AcceptanceTestGroupMetrics process() {
		final AcceptanceTestGroupMetrics groupMetrics = new AcceptanceTestGroupMetrics(this.getGroupName(), this.getGroupDescription(), getLanguage());
		
		for (AcceptanceTestRunner acceptanceTestRunner : acceptanceTestRunners) {
			acceptanceTestRunner.run(new AcceptanceTestResultCallback() {
				public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
					groupMetrics.getMetrics().add(new AcceptanceTestMetrics(name, numSuccessful, numTotal, messages));
				}
			});
		}
		
		return groupMetrics;
	}
	
	List<AcceptanceTestRunner> getAcceptanceTestRunners() {
		return this.acceptanceTestRunners;
	}
}
