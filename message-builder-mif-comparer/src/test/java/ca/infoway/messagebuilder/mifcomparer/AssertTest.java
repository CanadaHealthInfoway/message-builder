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

import static org.junit.Assert.*;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void that_assertListsEqualUnordered_succeeds_with_equivalent_lists() {
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new LinkedList<String>();
	
		l1.add("a");
		l1.add("b");
		l2.add("b");
		l2.add("a");
		assertEqualsUnordered(l1, l2);
	}

	@Test
	public void that_assertListsEqualUnordered_fails_with_different_lists() {
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new LinkedList<String>();
	
		l1.add("a");
		l1.add("b");
		l2.add("b");
		l2.add("c");
		exception.expect(AssertionError.class);
		exception.expectMessage("expected:<[a, b]> but was:<[b, c]>");
		assertEqualsUnordered(l1, l2);
	}

	@Test
	public void that_assertListsEqualUnordered_fails_with_different_lists_when_values_are_the_same() {
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new LinkedList<String>();
	
		l1.add("a");
		l1.add("b");
		l2.add("b");
		l2.add("a");
		l2.add("a");
		exception.expect(AssertionError.class);
		exception.expectMessage("expected:<[a, b]> but was:<[a, a, b]>");
		assertEqualsUnordered(l1, l2);
	}
}
