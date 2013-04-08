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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.demiftifier.InboundAssociation;
import ca.infoway.demiftifier.Layout;
import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.intelliware.commons.dependency.DependencyManager;
import ca.intelliware.commons.dependency.LayeredGraph;
import ca.intelliware.commons.dependency.Node;

public class LayerOuter {
	
	public Layout layout(MessageSet messageSet, String packageLocationName) {
		Layout result = new Layout(messageSet, packageLocationName);
		DependencyManager<MessagePartLayoutItem> dependencyManager = createDependencyGraph(
				result);

		LayeredGraph<MessagePartLayoutItem> layeredGraph = dependencyManager.getLayeredGraph();
		Node<MessagePartLayoutItem> root = layeredGraph.getNode(result.createItem(
				result.getMessageSet().getMessagePart(result.getPackageLocation().getRootType())));
		
		processRoot(result, layeredGraph, root);
		mergeAdjacentDuplicates(result);
		return result;
	}


	private void mergeAdjacentDuplicates(Layout layout) {
		for (MessagePartLayoutItem layoutItem : layout.getMessagePartLayoutItems()) {
			if (layoutItem.isSpecialization()) {
				// skip it
			} else if (layoutItem.isDuplicate()) {
				
				MessagePartLayoutItem original = layoutItem.getOriginal();
				if (layoutItem.getLogicalX() == original.getLogicalX()
						&& (layoutItem.getLogicalY() == (original.getLogicalY() + original.getHeight()))) {
					
					original.setHeight(original.getHeight() + layoutItem.getHeight());
					layout.removeDuplicate(layoutItem);
				}
			}
		}
	}


	private void processRoot(Layout result,
			LayeredGraph<MessagePartLayoutItem> layeredGraph,
			Node<MessagePartLayoutItem> root) {
		Branch branch = Branch.createWithRoot(root.getItem());
		//Set y=1 for the root item to allow for the EntryPoint shape which is always above it
		root.getItem().setLogicalY(1);
		root.getItem().setLogicalX(0);
		int height = processAllAfferents(result, layeredGraph, branch, 1);
		root.getItem().setHeight(height);
		if (root.getItem().isAbstract()) {
			processChoices(result, layeredGraph, branch, root.getItem().getHeight() + 1);
		}
	}


	private int processAllAfferents(Layout layout, LayeredGraph<MessagePartLayoutItem> graph, Branch branch, int logicalY) {
		MessagePartLayoutItem parentItem = branch.getCurrentEndpoint();
		// We are essentially creating a grid layout where y represents the row and x the column.
		// Also the column in which an item belongs is the item's "layer" in the layeredGraph    
		List<MessagePartLayoutItem> afferents = getCouplingsInOrder(layout, graph, branch);
		// The height of an element is equal to the sum of the height of its children or 1 if it has no children
		int height = 0;
		
		if (afferents.size() == 0) {
			height = 1;
		} else {
			for (MessagePartLayoutItem afferent : afferents) {
				afferent.setLogicalX(parentItem.getLogicalX() + 1);
				afferent.setLogicalY(height + logicalY);
				
				if (!afferent.isDuplicate()) {
					Branch afferentBranch = branch.withNewEndpoint(afferent);
					processAllAfferents(layout, graph, afferentBranch, height + logicalY);
					if (afferent.isAbstract() && !afferent.isCmet()) {
						processChoices(layout, graph, afferentBranch, height + logicalY + afferent.getHeight());
					}
				}
				height += afferent.getHeight();
			}
		}
		parentItem.setHeight(height);
		return height;
	}


	private void processChoices(Layout layout,
			LayeredGraph<MessagePartLayoutItem> graph,
			Branch parentBranch, int logicalY) {
		
		MessagePartLayoutItem layoutItem = parentBranch.getCurrentEndpoint();
		int height = 0;
		for (SpecializationChild specializationChild : layoutItem.getMessagePart().getSpecializationChilds()) {
			MessagePart childPart = layout.getMessageSet().getMessagePart(specializationChild.getName());
			MessagePartLayoutItem childItem = layout.createChoiceItem(layoutItem, childPart);
			
			Branch branch = parentBranch.createChoiceBranch(childItem);
			
			if (!childItem.isTrivial()) {
				childItem.setLogicalX(layoutItem.getTopAncestor().getLogicalX());
				childItem.setLogicalY(logicalY);
				processAllAfferents(layout, graph, branch, logicalY);
				logicalY += childItem.getHeight();

//				if (childPart.isAbstract()) {
//					processChoices(layout, graph, branch, logicalY);
//				}
				height += childItem.getHeight();
			} else {
				childItem.setLogicalX(layoutItem.getTopAncestor().getLogicalX());
				childItem.setLogicalY(layoutItem.getLogicalY());
				childItem.setHeight(0);
				childItem.setWidth(1);
				height += childItem.getHeight();
			}
		}
		layoutItem.setHeight(layoutItem.getHeight() + height);
	}


	private List<MessagePartLayoutItem> getCouplingsInOrder(Layout layout, LayeredGraph<MessagePartLayoutItem> graph, Branch branch) {
		MessagePartLayoutItem dependent = branch.getCurrentEndpoint();
		Node<MessagePartLayoutItem> topAncestor = graph.getNode(dependent.getTopAncestor());
		Map<String,MessagePartLayoutItem> map = new HashMap<String,MessagePartLayoutItem>(); 
		for (MessagePartLayoutItem layoutItem : topAncestor.getAfferentCouplings()) {
			map.put(layoutItem.getName(), layoutItem);
		}
		
		List<MessagePartLayoutItem> result = new ArrayList<MessagePartLayoutItem>();
		if (!dependent.isCmet()) {
			for (Relationship relationship : dependent.getAssociations()) {
				if (relationship.isAssociation()) {
					MessagePartLayoutItem layoutItem = map.get(relationship.isTemplateRelationship() 
							? createTemplateParameterTypeName(dependent, relationship) 
							: relationship.getType());
					
					Branch temp = branch.withNewEndpoint(layoutItem);
					
					if (layoutItem != null) {
						Node<MessagePartLayoutItem> afferentNode = graph.getNode(layoutItem.getTopAncestor());
						if (afferentNode == null) {
							throw new RuntimeException("No node found for : " + layoutItem.getName() + " -> top " + layoutItem.getTopAncestor().getName());
						} else if (temp.isEndingInCycle()) {
							dependent.setEncroachmentLevelEnd(temp.getCycleConnectionPoint().getSpecializationDepth());
							// System.out.println("Cycle found: " + layoutItem.getName() + " -> " + dependent.getName() + " (" + relationship.getName() + ")");
							dependent.setCyclic(true);
						} else {
							if (layoutItem.isAlreadyLayedOut() ) {
								layoutItem = layoutItem.createDuplicate();
							}
							InboundAssociation parentInboundAssociation = dependent.getInboundAssociation();
							int inboundArrowDepth = parentInboundAssociation == null ? 0 : parentInboundAssociation.getInboundArrowDepth();
							if ((layoutItem.isEntityOrOtherClassType() || dependent.isEntityOrOtherClassType()) && !layoutItem.isRootType() &&!layoutItem.isSpecialization()) {
								inboundArrowDepth += 1;
							} else {
								inboundArrowDepth = 0;
							}
							layoutItem.setInboundAssociation(new InboundAssociation(relationship, inboundArrowDepth));
							layoutItem.setEncroachmentLevel(dependent.getSpecializationDepth());
							result.add(layoutItem);
						}
					}
				}
			}
		}
		return result;
	}
		
	private DependencyManager<MessagePartLayoutItem> createDependencyGraph(Layout layout) {
		PackageLocation packageLocation = layout.getPackageLocation();
		
		DependencyManager<MessagePartLayoutItem> dependencyManager = new DependencyManager<MessagePartLayoutItem>();
		String rootType = packageLocation.getRootType();

		//Let's make sure we are on the right footing ...
		if (!TypeName.determineRootName(rootType).equals(packageLocation.getName())){
			throw new IllegalStateException("Abort! Abort! RootName of rootType: " + rootType +
					" does not match package packageLocationName: " + packageLocation.getName());
		} else {
			MessagePart rootMessagePart = layout.getMessageSet().getMessagePart(rootType);
			addAllDependencies(dependencyManager, rootMessagePart, layout);
			dependencyManager.add(layout.createItem(rootMessagePart));
			return dependencyManager;
		}
	}


	private void addAllDependencies(DependencyManager<MessagePartLayoutItem> dependencyManager, MessagePart messagePart, Layout layout) {
		addAllDependencies(dependencyManager, messagePart, messagePart, layout);
		
	}
	private void addAllDependencies(DependencyManager<MessagePartLayoutItem> dependencyManager, MessagePart messagePartWithRelationships, MessagePart dependant, Layout layout) {
		if (!isAlreadyProcessed(messagePartWithRelationships, dependencyManager, layout)) {
			processAllRelationshipsAsDependencies(dependencyManager, messagePartWithRelationships, dependant, layout);
			for (SpecializationChild specializationChild : messagePartWithRelationships.getSpecializationChilds()) {
				if (isSamePackage(specializationChild.getName(), dependant.getName())) {
					MessagePart choice = layout.getMessageSet().getMessagePart(specializationChild.getName());
					addAllDependencies(dependencyManager, choice, dependant, layout);
				}
			}
		}
	}


	private boolean isAlreadyProcessed(
			MessagePart messagePart, DependencyManager<MessagePartLayoutItem> dependencyManager, Layout layout) {
		return layout.containsItemFor(messagePart) && 
				!dependencyManager.getLayeredGraph().getNode(
						layout.createItem(messagePart)).getAfferentCouplings().isEmpty();
	}


	private void processAllRelationshipsAsDependencies(
			DependencyManager<MessagePartLayoutItem> dependencyManager, MessagePart messagePart, MessagePart dependant, Layout layout) {
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAssociation()) {
				if (relationship.isTemplateRelationship()) {
					String typeName = createTemplateParameterTypeName(messagePart, relationship);
					MessagePart relationshipPart = layout.getMessageSet().getMessagePart(typeName);
					if (relationshipPart == null) {
						// old message set -- created before Jason's MIF Fidelity work
						relationshipPart = new MessagePart(typeName);
						relationshipPart.setTemplateParameter(true);
						relationshipPart.setRimClass(RimClass.ACT); // because they usually are
					}
					dependencyManager.add(layout.createItem(relationshipPart), layout.createItem(dependant));
				} else {
					MessagePart relationshipPart = layout.getMessageSet().getMessagePart(relationship.getType());
					dependencyManager.add(layout.createItem(relationshipPart), layout.createItem(dependant));
					if (isSamePackage(relationship.getType(), messagePart.getName())) {
						addAllDependencies(dependencyManager, relationshipPart, layout);
					}
				}
			}
		}
	}


	private String createTemplateParameterTypeName(Named messagePart,
			Relationship relationship) {
		return TypeName.determineRootName(messagePart.getName()) + "." + new TypeName(relationship.getTemplateParameterName()).getUnqualifiedName();
	}
	

	private boolean isSamePackage(String type, String name) {
		TypeName type1 = new TypeName(type);
		TypeName type2 = new TypeName(name);
		return type1.getRootName().equals(type2.getRootName());
	}
}
