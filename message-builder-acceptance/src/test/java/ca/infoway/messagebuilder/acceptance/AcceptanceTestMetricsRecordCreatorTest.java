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

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestGroupMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.AcceptanceTestMetricsRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunEndedRecord;
import ca.infoway.messagebuilder.acceptance.devcreek.RunStartedRecord;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestLanguage;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AllAcceptanceGroupTestMetrics;

public class AcceptanceTestMetricsRecordCreatorTest {
	
	private AcceptanceTestsMetricsRecordCreator creator;

	@Before
	public void setUp() {
		creator = new AcceptanceTestsMetricsRecordCreator();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeRunStartedRecord() throws Exception {
		List<?> records = creator.create(new AllAcceptanceGroupTestMetrics(new Date()));
		assertThat((List<Object>) records, hasItem(instanceOf(RunStartedRecord.class)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeRunEndedRecord() throws Exception {
		List<?> records = creator.create(new AllAcceptanceGroupTestMetrics(new Date()));
		assertThat((List<Object>) records, hasItem(instanceOf(RunEndedRecord.class)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeOneAcceptanceTestGroupMetricsRecord() throws Exception {
		AllAcceptanceGroupTestMetrics amalgamatedMetrics = new AllAcceptanceGroupTestMetrics(new Date());
		amalgamatedMetrics.getGroupMetrics().add(new AcceptanceTestGroupMetrics("XML Parser Fidelity", "description", AcceptanceTestLanguage.JAVA));
		List<?> records = creator.create(amalgamatedMetrics);
		assertThat((List<Object>) records, hasItem(instanceOf(AcceptanceTestGroupMetricsRecord.class)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldIncludeOneAcceptanceTestMetricsRecord() throws Exception {
		AllAcceptanceGroupTestMetrics amalgamatedMetrics = new AllAcceptanceGroupTestMetrics(new Date());

		AcceptanceTestGroupMetrics groupMetrics = new AcceptanceTestGroupMetrics("XML Parser Fidelity", "description", AcceptanceTestLanguage.JAVA);
		groupMetrics.getMetrics().add(new AcceptanceTestMetrics("NullFlavorTests", 1));
		
		amalgamatedMetrics.getGroupMetrics().add(groupMetrics);
		
		List<?> records = creator.create(amalgamatedMetrics);
		assertThat((List<Object>) records, hasItem(instanceOf(AcceptanceTestMetricsRecord.class)));
	}

}
