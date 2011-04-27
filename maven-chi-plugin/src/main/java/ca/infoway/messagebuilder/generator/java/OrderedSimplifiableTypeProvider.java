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

package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import ca.infoway.messagebuilder.generator.dependency.DependencyTracker;
import ca.intelliware.commons.dependency.LayeredGraph;

class OrderedSimplifiableTypeProvider implements SimplifiableTypeProvider {
	
	static class Node implements Comparable<Node> {
		
		private final SimplifiableType type;
		private final int layer;

		Node(SimplifiableType type, int layer) {
			this.type = type;
			this.layer = layer;
		}

		public int compareTo(Node that) {
			return new CompareToBuilder()
					.append(this.layer, that.layer)
					.append(this.type.getName(), that.type.getName())
					.toComparison();
		}
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else if (obj == this) {
				return true;
			} else if (obj.getClass() != getClass()) {
				return false;
			} else {
				Node that = (Node) obj;
				return new EqualsBuilder()
						.append(this.layer, that.layer)
						.append(this.type.getName(), that.type.getName())
						.isEquals();
			}
		}
	}

	private final SimplifiableDefinitions definitions;
	private final List<SimplifiableType> types;


	public OrderedSimplifiableTypeProvider(SimplifiableDefinitions definitions, List<SimplifiableType> types) {
		this.definitions = definitions;
		this.types = types;
	}

	public Collection<SimplifiableType> getAllTypes() {
		return this.types;
	}

	public SimplifiableType getType(String name) {
		return this.definitions.getType(name);
	}
	
	public static SimplifiableTypeProvider create(SimplifiableDefinitions definitions) {
		LayeredGraph<String> graph = DependencyTracker.create(definitions).getPrimaryLayeredGraph();
		
		List<Node> nodes = new ArrayList<Node>();
		for (SimplifiableType type : definitions.getAllTypes()) {
			nodes.add(new Node(type, graph.getLayer(type.getName())));
		}
		Collections.sort(nodes);
		
		List<SimplifiableType> types = new ArrayList<SimplifiableType>();
		for (Node node : nodes) {
			types.add(node.type);
		}
		return new OrderedSimplifiableTypeProvider(definitions, types);
	}
}
