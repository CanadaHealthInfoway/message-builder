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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2013-04-08 11:07:24 -0400 (Mon, 08 Apr 2013) $
 * Revision:      $LastChangedRevision: 6766 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.dependencyanalyzer.DependencyManager;
import ca.infoway.messagebuilder.dependencyanalyzer.Layer;
import ca.infoway.messagebuilder.dependencyanalyzer.Node;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;


public class DependencyTrackerTest {

	@Test
	public void shouldMarkDependencyInAssociation() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		MessagePart body = new MessagePart("ABCD_MT123456CA.Body");
		body.getRelationships().add(new Relationship("arm", "ABCD_MT123456CA.Arm", Cardinality.create("1")));
		messageSet.addMessagePart(body);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getManager();
		
		printNodes(map);
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("arm layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Arm"));
		assertEquals("body layer", 2, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Body"));
	}
	
	@Test
	public void shouldMarkChoiceDependencyInAssociation() throws Exception {
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		MessagePart body = new MessagePart("ABCD_MT123456CA.Body");
		Relationship relationship = new Relationship("arm", "ABCD_MT123456CA.Arm", Cardinality.create("1"));
		relationship.getChoices().add(new Relationship("hand", "ABCD_MT123456CA.Hand", Cardinality.create("1")));
		body.getRelationships().add(relationship);
		messageSet.addMessagePart(body);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		MessagePart hand = new MessagePart("ABCD_MT123456CA.Hand");
		messageSet.addMessagePart(hand);
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getChoiceManager();
		
		printNodes(map);
		
		assertEquals("hand layer", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Hand"));
		assertEquals("body layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Body"));
	}
	
	@Test
	public void shouldMarkNestedChoiceDependencyInAssociation() throws Exception {
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		
		Relationship handRelationship = new Relationship("hand", "ABCD_MT123456CA.Hand", Cardinality.create("1"));
		handRelationship.getChoices().add(new Relationship("finger", "ABCD_MT123456CA.Finger", Cardinality.create("1")));
		
		Relationship relationship = new Relationship("arm", "ABCD_MT123456CA.Arm", Cardinality.create("1"));
		relationship.getChoices().add(handRelationship);
		
		MessagePart body = new MessagePart("ABCD_MT123456CA.Body");
		body.getRelationships().add(relationship);
		
		messageSet.addMessagePart(body);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		MessagePart hand = new MessagePart("ABCD_MT123456CA.Hand");
		messageSet.addMessagePart(hand);
		MessagePart finger = new MessagePart("ABCD_MT123456CA.Finger");
		messageSet.addMessagePart(finger);
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getChoiceManager();
		
		printNodes(map);
		
		assertEquals("Finger layer", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Finger"));
		assertEquals("Hand layer", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Hand"));
		assertEquals("body layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Body"));
	}
	
	@Test
	public void shouldMarkDependencyInSuperType() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.Message"));
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		messageSet.getInteractions().put(interaction.getName(), interaction);
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getManager();
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("message layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Message"));
		assertEquals("interaction layer", 2, map.getLayeredGraph().getLayer("ABCD_IN123456CA"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldMarkDependencyInArgument() throws Exception {
		
		MessageSet messageSet = createInteractionWithArguments();
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getManager();
		
		printNodes(map);
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("trigger event layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ControlAct"));
		assertEquals("payload layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ParameterList"));
		assertEquals("interaction layer", 2, map.getLayeredGraph().getLayer("ABCD_IN123456CA"));

		Set<Node<String>> set = map.getNodeLayers().get(2).getContents();
		Node<String> node = (Node<String>) CollectionUtils.get(set, 0);
		assertTrue("depends on control act", node.getEfferentCouplings().contains("ABCD_MT123456CA.ControlAct"));
		assertTrue("depends on payload", node.getEfferentCouplings().contains("ABCD_MT123456CA.ParameterList"));
	}

	@Test
	public void shouldMarkChoiceDependenciesInArgument() throws Exception {
		
		MessageSet messageSet = createInteractionWithArguments();
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getChoiceManager();
		
		printNodes(map);
		
		assertEquals("choice layer1", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ChoiceType1"));
		assertEquals("choice layer2", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ChoiceType2"));
		assertEquals("choice layer3", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ChoiceType3"));
		assertEquals("interaction layer", 1, map.getLayeredGraph().getLayer("ABCD_IN123456CA"));
	}

	@Test
	public void shouldMarkDependencyInInterfaceTypeButNotBetweenInterfaceAndImplementingTypes() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		MessagePart appendage = new MessagePart("ABCD_MT123456CA.Appendage");
		appendage.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.Arm"));
		messageSet.addMessagePart(appendage);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		
		DependencyManager<String> map = DependencyTracker.create(messageSet).getManager();
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("appendage layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Appendage"));
		assertEquals("arm layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Arm"));
	}
	
	
	private MessageSet createInteractionWithArguments() {
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.Message"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ControlAct"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ParameterList"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ChoiceType1"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ChoiceType2"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ChoiceType3"));
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		Argument argument1 = new Argument();
		argument1.setName("ABCD_MT123456CA.ControlAct");
		argument1.getChoices().add(new Relationship("choice1", "ABCD_MT123456CA.ChoiceType1", Cardinality.create("1")));
		interaction.getArguments().add(argument1);
		
		Argument argument2 = new Argument();
		argument2.setName("ABCD_MT123456CA.ParameterList");
		argument2.getChoices().add(new Relationship("choice1", "ABCD_MT123456CA.ChoiceType2", Cardinality.create("1")));
		argument2.getChoices().get(0).getChoices().add(new Relationship("choice2", "ABCD_MT123456CA.ChoiceType3", Cardinality.create("1")));
		argument1.getArguments().add(argument2);
		messageSet.getInteractions().put(interaction.getName(), interaction);
		return messageSet;
	}
	
	private void printNodes(DependencyManager<String> map) {
		for (Layer<Node<String>> layer : map.getNodeLayers()) {
			System.out.println(layer.getLevel() + " -> " + layer.getContents());
		}
	}
}
