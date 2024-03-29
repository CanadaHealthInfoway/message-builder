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

package ca.infoway.messagebuilder.acceptance.runner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AcceptanceTestGroupRunnerTest {

	private AcceptanceTestGroupRunner fixture;
	
	@Before
	public void initialize() {
		
		List<AcceptanceTestRunner> runners = new ArrayList<AcceptanceTestRunner>();
		runners.add(createRunner(1));
		runners.add(createRunner(2));
		runners.add(createRunner(3));
		
		this.fixture = new AcceptanceTestGroupRunner("testRunner", runners);
	}

	private AcceptanceTestRunner createRunner(final int runnerIndex) {
		return new AcceptanceTestRunner() {
			public void run(AcceptanceTestResultCallback resultCallback) {
				resultCallback.done("name"+runnerIndex, 1, runnerIndex, Arrays.<String>asList("message" + runnerIndex));
			}
		};
	}
	
	@Test
	public void testAcceptanceTestRunner() throws Exception {
		final Set<String> names = new HashSet<String>();
		final List<Integer> successes = new ArrayList<Integer>();
		final List<Integer> total = new ArrayList<Integer>();
		final List<String> allMessages = new ArrayList<String>();
		
		this.fixture.run(new AcceptanceTestResultCallback() {
			public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
				names.add(name);
				successes.add(numSuccessful);
				total.add(numTotal);
				allMessages.addAll(messages);
			}
		});
		
		assertEquals(1, names.size());
		assertEquals("testRunner", names.iterator().next());
		
		assertEquals(1, successes.size());
		assertEquals(3, (int) successes.get(0));
		
		assertEquals(1, total.size());
		assertEquals(6, (int) total.get(0));

		assertEquals(3, allMessages.size());
		assertEquals("message1", allMessages.get(0));
		assertEquals("message2", allMessages.get(1));
		assertEquals("message3", allMessages.get(2));
	}
}
