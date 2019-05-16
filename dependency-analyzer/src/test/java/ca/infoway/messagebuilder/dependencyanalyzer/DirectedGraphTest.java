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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.dependencyanalyzer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.dependencyanalyzer.DirectedGraph;

public class DirectedGraphTest extends DependencyTestCase {

	@Test
	public void testIsNotAcyclic() throws Exception {
		DirectedGraph<String> graph = createSimpleGraphWithCycles();
		assertFalse("acyclic", graph.isAcyclic());
	}
	@Test
	public void testIsNotAcyclicTrivialCase() throws Exception {
		DirectedGraph<String> graph = createSimpleGraphWithSelfCycle();
		assertFalse("acyclic", graph.isAcyclic());
	}
	@Test
	public void testIsAcyclic() throws Exception {
		DirectedGraph<String> graph = createSimpleGraphWithNoCycles();
		assertTrue("acyclic", graph.isAcyclic());
	}
	@Test
	public void testIsSink() throws Exception {
		DirectedGraph<String> graph = createSimpleGraphWithCycles();
		assertTrue("sink", graph.isSink("play-doh"));
		assertFalse("not sink", graph.isSink("bc"));
	}
	@Test
	public void testIsSouce() throws Exception {
		DirectedGraph<String> graph = createSimpleGraphWithCycles();
		assertFalse("not source", graph.isSource("play-doh"));
		assertFalse("source", graph.isSource("bc"));
	}
}
