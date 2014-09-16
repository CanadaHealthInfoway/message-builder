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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

public class TemplateNode {

	private String packageName;
	private String disambiguationName;
	private String unqualifiedName;
	
	private List<String> breadcrumbs = new ArrayList<String>();
	
	private Map<String,List<TemplateNode>> children = new HashMap<String,List<TemplateNode>>();
	
	private CdaConstraint constraint;
	private MessagePart baseModelPart;
	
	public TemplateNode(String packageName, String unqualifiedName, MessagePart baseModelPart) {
		this.packageName = packageName;
		this.disambiguationName = "";
		this.unqualifiedName = unqualifiedName;
		this.breadcrumbs.add(unqualifiedName);
		this.baseModelPart = baseModelPart;
	}
	
	private TemplateNode(TemplateNode parentNode, String childName, CdaConstraint constraint, MessagePart baseModelPart) {
		this.packageName = parentNode.getPackageName();
		this.disambiguationName = "";
		this.unqualifiedName = childName;
		this.breadcrumbs.addAll(parentNode.getBreadcrumbs());
		this.breadcrumbs.add(childName);
		this.constraint = constraint;
		this.baseModelPart = baseModelPart;
	}
	
	public Map<String, List<TemplateNode>> getChildren() {
		return children;
	}
	
	public TemplateNode addChild(String relationshipName, String className, CdaConstraint constraint, MessagePart baseModelPart) {
		TemplateNode childNode = new TemplateNode(this, className, constraint, baseModelPart);
		List<TemplateNode> branchChildren = this.children.get(relationshipName);
		if (branchChildren == null) {
			branchChildren = new ArrayList<TemplateNode>();
			this.children.put(relationshipName, branchChildren);
		}
		branchChildren.add(childNode);
		return childNode;
	}
	
	/**
	 * @deprecated
	 * @param relationshipName
	 * @return
	 */
	public TemplateNode getChild(String relationshipName) {
		List<TemplateNode> list = this.children.get(relationshipName);
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
	public String getQualifiedName() {
		return this.packageName + "." + this.disambiguationName + this.unqualifiedName;
	}
	
	public void disambiguateTree(TemplateSet templateSet) {
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
		
		for (List<TemplateNode> nodeList : this.children.values()) {
			if (nodeList.size() > 1) {
				for (TemplateNode node : nodeList) {
					String nameOrnament = findNameOrnament(node, templateSet);
					node.disambiguationName = nameOrnament + node.disambiguationName;
					for (List<TemplateNode> childNodeList : node.children.values()) {
						for (TemplateNode childNode : childNodeList) {
							childNode.disambiguationName = nameOrnament + childNode.disambiguationName;
						}
					}
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
					rival.getUnqualifiedName().equals(this.getUnqualifiedName()) &&
					!rival.getBreadcrumbs().equals(this.getBreadcrumbs())) {
				rivalSet.add(rival);
			}
		}
		
		if (!rivalSet.isEmpty()) {
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
		
	}
	
	private String findNameOrnament(TemplateNode node, TemplateSet templateSet) {
		String result = "";
		for (CdaConstraint constraint : node.getConstraint().getConstraints()) {
			if (constraint.getContainedTemplateOid() != null) {
				result = templateSet.getByOid(constraint.getContainedTemplateOid()).getPackageName();
			}
		}
		
		if (StringUtils.isBlank(result)) {
			for (CdaConstraint constraint : node.getConstraint().getConstraints()) {
				if (StringUtils.equals(constraint.getContext(), "templateId")) {
					for (CdaConstraint subconstraint : constraint.getConstraints()) {
						if (StringUtils.equals(subconstraint.getContext(), "@root") && subconstraint.getSingleValueCode() != null && StringUtils.isNotBlank(subconstraint.getSingleValueCode().getDisplayName())) {
							result = StringUtils.deleteWhitespace(subconstraint.getSingleValueCode().getDisplayName());
						}
					}
				}
			}
		}

		if (StringUtils.isBlank(result)) {
			for (CdaConstraint constraint : node.getConstraint().getConstraints()) {
				for (CdaConstraint subconstraint : constraint.getConstraints()) {
					if (subconstraint.getConstraints() != null) {
						for (CdaConstraint subsubconstraint : subconstraint.getConstraints()) {
							if (StringUtils.equals(subsubconstraint.getContext(), "@code") && subsubconstraint.getSingleValueCode() != null && StringUtils.isNotBlank(subsubconstraint.getSingleValueCode().getDisplayName())) {
								result = StringUtils.deleteWhitespace(subsubconstraint.getSingleValueCode().getDisplayName());
							}
						}
					}
				}
			}
		}
			
		if (StringUtils.isBlank(result)) {
			for (CdaConstraint constraint : node.getConstraint().getConstraints()) {
				if (StringUtils.isBlank(result) && StringUtils.equals(constraint.getContext(), "@typeCode") && constraint.getSingleValueCode() != null && StringUtils.isNotBlank(constraint.getSingleValueCode().getDisplayName())) {
					result = StringUtils.deleteWhitespace(constraint.getSingleValueCode().getDisplayName());
				}
			}
		}

		if (StringUtils.isBlank(result)) {
			for (CdaConstraint constraint : node.getConstraint().getConstraints()) {
				Relationship relationship = node.getBaseModelPart().getRelationship(constraint.getContext());
				if (relationship != null && relationship.isChoice()) {
					Relationship choiceOption = relationship.findChoiceOption(Relationship.choiceOptionNamePredicate(constraint.getContext()));
					TypeName optionName = new TypeName(choiceOption.getType());
					result = optionName.getUnqualifiedName();
				}
			}
		}
			
		return result;
	}

	private void collectDescendants(Map<String,List<TemplateNode>> nodes) {
		List<TemplateNode> conflictingNodes = nodes.get(getUnqualifiedName());
		if (conflictingNodes == null) {
			conflictingNodes = new ArrayList<TemplateNode>();
			nodes.put(getUnqualifiedName(), conflictingNodes);
		}
		
		conflictingNodes.add(this);
		
		for (List<TemplateNode> nodeList : this.children.values()) {
			for (TemplateNode node : nodeList) {
				node.collectDescendants(nodes);
			}
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

	public CdaConstraint getConstraint() {
		return constraint;
	}

	public MessagePart getBaseModelPart() {
		return baseModelPart;
	}
}
