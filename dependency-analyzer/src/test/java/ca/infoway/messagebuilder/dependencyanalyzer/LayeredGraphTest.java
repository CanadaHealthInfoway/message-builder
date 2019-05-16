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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.dependencyanalyzer.DirectedGraph;
import ca.infoway.messagebuilder.dependencyanalyzer.Layer;
import ca.infoway.messagebuilder.dependencyanalyzer.LayeredGraph;
import ca.infoway.messagebuilder.dependencyanalyzer.Node;


public class LayeredGraphTest extends DependencyTestCase {

	@Test
	public void testGetLayers() throws Exception {
		LayeredGraph<String> graph = createSimpleLayeredGraphWithCycles();
		List<Layer<Node<String>>> layers = graph.getLayers();
		printLayers(layers);
		assertEquals("play-doh's layer", 0, graph.getLayer("play-doh"));
		assertEquals("ken's layer", 3, graph.getLayer("ken"));
		assertEquals("superman's layer", -1, graph.getLayer("superman"));
	}

	@Test
	public void testGetNode() throws Exception {
		LayeredGraph<String> graph = createSimpleLayeredGraphWithCycles();
		List<Layer<Node<String>>> layers = graph.getLayers();
		printLayers(layers);
		Node<String> node = graph.getNode("ken");
		assertEquals("ken's layer", 3, node.getLayer());
		assertFalse("ken has efferants", node.getEfferentCouplings().isEmpty());
	}
	
	@Test
	public void testGetLayersWithSelfCycle() throws Exception {
		LayeredGraph<String> graph = toLayeredGraph(createSimpleGraphWithSelfCycle());
		List<Layer<Node<String>>> layers = graph.getLayers();
		printLayers(layers);
		assertEquals("play-doh's layer", 0, graph.getLayer("play-doh"));
		assertEquals("ken's layer", 3, graph.getLayer("ken"));
		assertEquals("superman's layer", -1, graph.getLayer("superman"));
	}

	private void printLayers(List<Layer<Node<String>>> layers) {
		for (Layer<Node<String>> layer : layers) {
			System.out.println(layer.getLevel() + ": " + layer.getContents());
		}
		System.out.println();
	}

	protected LayeredGraph<String> createSimpleLayeredGraphWithCycles() {
		return toLayeredGraph(createSimpleGraphWithCycles());
	}

	private LayeredGraph<String> toLayeredGraph(DirectedGraph<String> graph) {
		return new LayeredGraph<String>(graph.getAll(), graph.getEfferentCouplings(), graph.getAfferentCouplings());
	}

}
