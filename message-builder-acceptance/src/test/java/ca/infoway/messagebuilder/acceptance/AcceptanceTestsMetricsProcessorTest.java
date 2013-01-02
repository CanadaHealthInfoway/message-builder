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

package ca.infoway.messagebuilder.acceptance;

import static java.lang.String.format;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.matchers.TypeSafeMatcher;

import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestGroupMetrics;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestLanguage;
import ca.infoway.messagebuilder.acceptance.metrics.AcceptanceTestMetrics;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;

public class AcceptanceTestsMetricsProcessorTest {
	
	@Test
	public void shouldReturnEmptyMetricsWhenItHasNoTestRunners() {
		AcceptanceTestGroupMetrics metrics = 
			new AcceptanceTestsMetricsProcessor("groupName", "description", AcceptanceTestLanguage.JAVA, Collections.<AcceptanceTestRunner>emptyList()).process();
		
		assertFalse(metrics.hasData());
	}

	@Test
	public void shouldReturnMetricsWithCorrectName() {
		AcceptanceTestGroupMetrics metrics = 
			new AcceptanceTestsMetricsProcessor("groupName", "description", null, Collections.<AcceptanceTestRunner>emptyList()).process();
		
		assertEquals("groupName", metrics.getGroupName());
	}

	@Test
	public void shouldReturnMetricsWithCorrectLanguage() {
		AcceptanceTestGroupMetrics metrics = 
			new AcceptanceTestsMetricsProcessor(null, "description", AcceptanceTestLanguage.JAVA, Collections.<AcceptanceTestRunner>emptyList()).process();
		
		assertEquals(AcceptanceTestLanguage.JAVA, metrics.getLanguage());
	}
	
	
	@Test
	public void shouldReturnMetrics() {
		AcceptanceTestGroupMetrics metrics = 
			new AcceptanceTestsMetricsProcessor("", "description", AcceptanceTestLanguage.JAVA, Arrays.<AcceptanceTestRunner>asList(new AcceptanceTestRunner() {
				public void run(AcceptanceTestResultCallback resultCallback) {
					resultCallback.done("testName", 3, 4, Collections.<String>emptyList());
				};
			})).process();
		
		assertTrue(metrics.hasData());
		assertEquals(1, metrics.getMetrics().size());
		assertThat(metrics.getMetrics(), hasItem(acceptanceTestMetricsMatcher("testName", 3, 4)));
	}

	private Matcher<AcceptanceTestMetrics> acceptanceTestMetricsMatcher(final String name, final int success, final int total) {
		return new TypeSafeMatcher<AcceptanceTestMetrics>() {
			@Override
			public boolean matchesSafely(AcceptanceTestMetrics metrics) {
				return metrics.getName().equals(name) && metrics.getNumSuccessful() == success
						&& metrics.getName().equals(name) && metrics.getNumTotal() == total;
			}
			public void describeTo(Description description) {
				description.appendText(format("name=%s, successes=%s, total=%s", name, success, total));
			}
		};
	}
	
}
