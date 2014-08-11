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

package ca.infoway.messagebuilder.generator.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class TemplateNode {

	private String packageName;
	private String disambiguationName;
	private String unqualifiedName;
	
	private List<String> breadcrumbs = new ArrayList<String>();
	
	private Map<String,TemplateNode> children = new HashMap<String,TemplateNode>();
	
	public TemplateNode(String packageName, String unqualifiedName) {
		this.packageName = packageName;
		this.disambiguationName = "";
		this.unqualifiedName = unqualifiedName;
		this.breadcrumbs.add(unqualifiedName);
	}
	
	private TemplateNode(TemplateNode parentNode, String childName) {
		this.packageName = parentNode.getPackageName();
		this.disambiguationName = "";
		this.unqualifiedName = childName;
		this.breadcrumbs.addAll(parentNode.getBreadcrumbs());
		this.breadcrumbs.add(childName);
	}
	
	public Collection<TemplateNode> getChildren() {
		return children.values();
	}
	
	public TemplateNode addChild(String relationshipName, String className) {
		TemplateNode childNode = new TemplateNode(this, className);
		this.children.put(relationshipName, childNode);
		return childNode;
	}
	
	public TemplateNode getChild(String relationshipName) {
		return this.children.get(relationshipName);
	}
	
	public String getQualifiedName() {
		return this.packageName + "." + this.disambiguationName + this.unqualifiedName;
	}
	
	public void disambiguateTree() {
		Map<String,List<TemplateNode>> nodes = new HashMap<String,List<TemplateNode>>();
		collectDescendants(nodes);
		
		for (List<TemplateNode> nodeList : nodes.values()) {
			if (nodeList.size() > 1) {
				// conflict to resolve
				for (TemplateNode node : nodeList) {
					node.disambiguate(nodeList);
				}
			}
		}
	}
	
	private void disambiguate(List<TemplateNode> rivals) {
		this.disambiguationName = "";
		
		if (this.breadcrumbs.size() == 1) {
			return;
		}
		
		HashSet<TemplateNode> rivalSet = new HashSet<TemplateNode>();
		for (TemplateNode rival : rivals) {
			if (rival != this &&
					rival.getUnqualifiedName().equals(this.getUnqualifiedName())) {
				rivalSet.add(rival);
			}
		}
		
		int depth = 1;
		while(StringUtils.isBlank(this.disambiguationName)) {
			Iterator<TemplateNode> iterator = rivalSet.iterator();
			while (iterator.hasNext()) {
				TemplateNode rival = iterator.next();
				if (rival.getBreadcrumbs().size() < depth ||
						!this.getBreadcrumb(depth).equals(rival.getBreadcrumb(depth))) {
					iterator.remove();
				}
			}
			if (rivalSet.isEmpty()) {
				this.disambiguationName = this.getBreadcrumb(depth);
			} else {
				depth++;
			}
		}
	}
	
	private void collectDescendants(Map<String,List<TemplateNode>> nodes) {
		List<TemplateNode> conflictingNodes = nodes.get(getUnqualifiedName());
		if (conflictingNodes == null) {
			conflictingNodes = new ArrayList<TemplateNode>();
			nodes.put(getUnqualifiedName(), conflictingNodes);
		}
		
		conflictingNodes.add(this);
		
		for (TemplateNode node : this.children.values()) {
			node.collectDescendants(nodes);
		}
	}
	
	private String getPackageName() {
		return packageName;
	}

	private String getUnqualifiedName() {
		return unqualifiedName;
	}

	private List<String> getBreadcrumbs() {
		return breadcrumbs;
	}
	
	private String getBreadcrumb(int depth) {
		int index = this.breadcrumbs.size() - depth;
		return this.breadcrumbs.get(index);
	}
}
