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

import static ca.infoway.messagebuilder.mifcomparer.MessageStatistics.StatisticsGroup.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ca.infoway.messagebuilder.mifcomparer.MessageStatistics.StatisticsGroup;


public class MessageStatisticsTest {
	private static final String NEWLINE = System.getProperty("line.separator");
	
    @Rule
    public ExpectedException exception = ExpectedException.none();

	@Test
	public void that_getStatisticsFor_on_new_object_returns_empty_map() {
		MessageStatistics obj = new MessageStatistics();
		
		Map<String, Integer> actStats = obj.getStatisticsFor(OTHER);
	
		assertEquals(0, actStats.keySet().size());
	}
	   
	@Test
	public void that_first_tally_sets_value_to_1() {
		MessageStatistics obj = new MessageStatistics();
		
		obj.tally(OTHER, "my key");
		Map<String, Integer> actStats = obj.getStatisticsFor(OTHER);
	
		assertEquals(1, actStats.keySet().size());
		assertEquals(1, (int)actStats.get("my key"));
	}
	
	@Test
	public void that_second_tally_sets_value_to_2() {
		MessageStatistics obj = new MessageStatistics();
		
		obj.tally(OTHER, "my key");
		obj.tally(OTHER, "my key");
		Map<String, Integer> actStats = obj.getStatisticsFor(OTHER);
	
		assertEquals(1, actStats.keySet().size());
		assertEquals(2, (int)actStats.get("my key"));
	}	
	
	@Test
	public void that_tally_on_two_keys_doesnt_collide() {
		MessageStatistics obj = new MessageStatistics();
		
		obj.tally(OTHER, "key A");
		obj.tally(OTHER, "key B");
		Map<String, Integer> actStats = obj.getStatisticsFor(OTHER);
	
		assertEquals(2, actStats.keySet().size());
		assertEquals(1, (int)actStats.get("key A"));
		assertEquals(1, (int)actStats.get("key B"));
	}	
	
	@Test
	public void that_tally_on_two_groups_doesnt_collide() {
		MessageStatistics obj = new MessageStatistics();
		
		obj.tally(OTHER, "my key");
		obj.tally(PER_FILE, "my key");
		obj.tally(PER_FILE, "my key");
		Map<String, Integer> actStats = obj.getStatisticsFor(OTHER);
		
		assertEquals(1, actStats.keySet().size());
		assertEquals(1, (int)actStats.get("my key"));
		
		actStats = obj.getStatisticsFor(PER_FILE);
	
		assertEquals(1, actStats.keySet().size());
		assertEquals(2, (int)actStats.get("my key"));
	}

	@Test
	public void that_ensureDefined_defines_new_key() {
		// Setup
		MessageStatistics obj = new MessageStatistics();
		assertNull(obj.getStatisticsFor(OTHER).get("foo"));
		
		// Perform
		obj.ensureDefined(OTHER, "foo");
		
		// Test
		assertEquals(0, (int)obj.getStatisticsFor(OTHER).get("foo"));
	}
	
	@Test
	public void that_ensureDefined_doesnt_stomp_existing_key() {
		// Setup
		MessageStatistics obj = new MessageStatistics();
		obj.tally(OTHER, "foo");
		obj.tally(OTHER, "foo");
		obj.tally(OTHER, "foo");
		
		// Perform
		obj.ensureDefined(OTHER, "foo");
		
		// Test
		assertEquals(3, (int)obj.getStatisticsFor(OTHER).get("foo"));
	}
	
	@Test
	public void that_toString_produces_good_results() {
		MessageStatistics obj = new MessageStatistics();
		String exp =
			"Per-file statistics:" + NEWLINE +
			"    2\tmy key" + NEWLINE +
			
			NEWLINE + "XML differences:" + NEWLINE +
			"\t(none)" + NEWLINE +
			
			NEWLINE + "Other messages:" + NEWLINE +
			"    1\tmy key" + NEWLINE +
			
			NEWLINE + "By XPath:" + NEWLINE +
			"\t(none)" + NEWLINE +
			"";
		
		obj.tally(OTHER, "my key");
		obj.tally(PER_FILE, "my key");
		obj.tally(PER_FILE, "my key");

		String act = obj.toString();
		
		System.out.print(String.format("Expected: <<<%s>>>%n%n", exp)); 
		System.out.print(String.format("Expected: <<<%s>>>%n%n", act)); 
		assertEquals(exp, act);

	}
	
	// Utility methods

	public static void assertGroupEmpty(MessageStatistics stats, StatisticsGroup sg) {
		Map<String, Integer> emptyGroup = new HashMap<String, Integer>();
		assertEquals("For statistics group " + sg + ",", emptyGroup, stats.getStatisticsFor(sg));
	}
	
	public static void assertStatsEmpty(MessageStatistics stats) {
		for (StatisticsGroup sg : StatisticsGroup.values()) {
			assertGroupEmpty(stats, sg);
		}
	}
	
	@Test
	public void test_that_assert_empty_passes_with_empty_MessageStatistics() {
		// Prepare
		MessageStatistics obj = new MessageStatistics();
		
		// Perform
		assertStatsEmpty(obj);
		
		// no tests
	}
	
	
	@Test
	public void test_that_assert_empty_fails_with_nonEmpty_MessageStatistics() {
		// Prepare
		MessageStatistics obj = new MessageStatistics();
		obj.tally(OTHER, "foo");
				
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group OTHER, expected:<{}> but was:<{foo=1}>");
		assertStatsEmpty(obj);
		
		// no tests
	}
	
	static void assertGroupContainsOnly(MessageStatistics stats, StatisticsGroup sg, String key, int value) {
		Map<String, Integer> exp = new HashMap<String, Integer>();
		exp.put(key, value);
		
		Map<String, Integer> act = stats.getStatisticsFor(sg);

		assertEquals("For statistics group " + sg + ",", exp, act);
	}
	
	@Test
	public void that_assertGroupContainsOnly_passes_when_group_is_correct() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		
		// Perform
		assertGroupContainsOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertGroupContainsOnly_fails_on_empty_group() {
		MessageStatistics stats = new MessageStatistics();
		
		// Perform
		exception.expect(AssertionError.class);
		assertGroupContainsOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}	
	
	
	@Test
	public void that_assertGroupContainsOnly_fails_on_wrong_value() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		stats.tally(XML_DIFFS, "foo");		// Do this twice, for an actual count of 2
		
		// Perform
		exception.expect(AssertionError.class);
		assertGroupContainsOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	public static void assertXpathStatsContainOnly(MessageStatistics stats, String key, int value) {
		assertGroupContainsOnly(stats, BY_XPATH, key, value);
	}
	
	public static void assertMainStatsContainOnly(MessageStatistics stats, StatisticsGroup expSG, String expKey, int expVal) {
		for (StatisticsGroup sg : StatisticsGroup.values()) {
			if (sg == BY_XPATH) {
				continue;
			} else if (sg == expSG) {
				assertGroupContainsOnly(stats, sg, expKey, expVal);
			} else {
				assertGroupEmpty(stats, sg);
			}
		}
	}
	
	@Test
	public void that_assertMainStatsContainOnly_passes_when_stats_are_correct() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		
		// Perform
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_fails_on_empty() {
		MessageStatistics stats = new MessageStatistics();
		
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group XML_DIFFS, expected:<{foo=1}> but was:<{}>");
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_fails_on_wrong_group() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(OTHER, "foo");
		
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group XML_DIFFS, expected:<{foo=1}> but was:<{}>");
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_fails_on_extra_group() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		stats.tally(OTHER, "bar");
		
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group OTHER, expected:<{}> but was:<{bar=1}>");
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_fails_on_wrong_key() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "bar");
		
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group XML_DIFFS, expected:<{foo=1}> but was:<{bar=1}>");
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_fails_on_wrong_value() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		stats.tally(XML_DIFFS, "foo");		// Do this twice, for an actual count of 2
		
		// Perform
		exception.expect(AssertionError.class);
		exception.expectMessage("For statistics group XML_DIFFS, expected:<{foo=1}> but was:<{foo=2}>");
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
	
	@Test
	public void that_assertMainStatsContainOnly_does_not_fail_because_of_xpath_stats() {
		MessageStatistics stats = new MessageStatistics();
		stats.tally(XML_DIFFS, "foo");
		stats.tally(BY_XPATH, "bar");
		
		// Perform
		assertMainStatsContainOnly(stats, XML_DIFFS, "foo", 1);
		
		// no tests
	}
}
