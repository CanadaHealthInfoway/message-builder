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
package ca.infoway.demiftifier.layout;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.LayoutItem;

class Branch {

	class Node {
		
		private LayoutItem item;
		private LayoutItem ancestor;
		
		private Node(LayoutItem item, LayoutItem ancestor) {
			this.item = item;
			this.ancestor = ancestor;
		}
		private Node(LayoutItem item) {
			this.item = item;
		}
		
		boolean isChoice() {
			return this.ancestor != null;
		}
		LayoutItem getItem() {
			return this.item;
		}
		LayoutItem getAncestor() {
			return this.ancestor;
		}
	}
	
	List<Node> nodes = new ArrayList<Node>();
	
	private Branch() {
	}
	private Branch(LayoutItem root) {
		this.nodes.add(new Node(root));
	}

	static Branch createWithRoot(LayoutItem root) {
		return new Branch(root);
	}
	
	LayoutItem getCurrentEndpoint() {
		return this.nodes.isEmpty() ? null : this.nodes.get(this.nodes.size()-1).item;
	}

	Node getCurrentEndpointNode() {
		return this.nodes.isEmpty() ? null : this.nodes.get(this.nodes.size()-1);
	}
	
	Branch withNewEndpoint(LayoutItem endpoint) {
		Branch result = new Branch();
		result.nodes.addAll(this.nodes);
		result.nodes.add(new Node(endpoint));
		return result;
	}
	Branch createChoiceBranch(LayoutItem childItem) {
		Branch result = new Branch();
		if (!this.nodes.isEmpty()) {
			if (this.nodes.size() > 1) {
				result.nodes.addAll(this.nodes.subList(0, this.nodes.size()-2));
			}
			Node node = getCurrentEndpointNode();
			result.nodes.add(new Node(childItem, node.isChoice() ? node.ancestor : node.item));
		}
		return result;
	}
	boolean isEndingInCycle() {
		return getCycleConnectionPoint() != null;
	}
	private LayoutItem touches(Node endpoint, Node node) {
		if (StringUtils.equals(endpoint.item.getName(), node.item.getName())) {
			return node.item;
		} else if (node.isChoice() && StringUtils.equals(endpoint.item.getName(), node.ancestor.getName())) {
			return node.ancestor;
		} else if (endpoint.isChoice() && StringUtils.equals(endpoint.ancestor.getName(), node.item.getName())) {
			return node.item;
		} else if (endpoint.isChoice() && node.isChoice() && StringUtils.equals(endpoint.ancestor.getName(), node.ancestor.getName())) {
			return node.ancestor;
		} else {
			return null;
		}
	}
	LayoutItem getCycleConnectionPoint() {
		LayoutItem result = null;
		Node endpoint = getCurrentEndpointNode();
		for (int i = this.nodes.size()-2; i >= 0; i--) {
			Node node = this.nodes.get(i);
			result = touches(endpoint, node);
			if (result != null) {
				break;
			}
		}
		return result;
	}
}
