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

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.lang.Exciser;
import ca.infoway.messagebuilder.generator.multiplemessageset.PreMergeEvaluator;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class ExciserTest {
	
	@Test
	public void shouldRemoveNestedChoiceDependencyInAssociation() throws Exception {
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

		createDifference(finger);
		
		assertFalse("finger choice exists", handRelationship.getChoices().isEmpty());

		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertTrue("finger choice removed", handRelationship.getChoices().isEmpty());
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

	@Test
	public void shouldRemoveInteractionsWithDifferences() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getInteractions().get("ABCD_IN123456CA"));
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNotNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveInteractionsWithArgumentDifferences() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getInteractions().get("ABCD_IN123456CA").getArguments().get(0).getArguments().get(0));
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNotNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveAllDependenciesIfWeRemovePayload() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveNestedArgumentChoiceIfWeRemoveChoiceType() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getMessagePart("ABCD_MT123456CA.ChoiceType3"));
		
		assertFalse("choice", messageSet.getInteractions().get("ABCD_IN123456CA").getArguments().get(0).getArguments().get(0)
				.getChoices().get(0).getChoices().isEmpty());

		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("choice type", messageSet.getInteractions().get("ABCD_MT123456CA.ChoiceType3"));
		assertTrue("choice", messageSet.getInteractions().get("ABCD_IN123456CA").getArguments().get(0).getArguments().get(0)
				.getChoices().get(0).getChoices().isEmpty());
	}
	
	@Test
	public void shouldRemoveAllDependenciesIfWeRemovePackageLocation() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
	}

	@Test
	public void shouldRemoveAllDependenciesIfWeHaveCyclicDependency() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		MessagePart location = new MessagePart("ABCD_MT123456CA.Location");
		MessagePart place = new MessagePart("ABCD_MT123456CA.Place");
		location.getRelationships().add(new Relationship("place", "ABCD_MT123456CA.Place", Cardinality.create("0-1")));
		place.getRelationships().add(new Relationship("location", "ABCD_MT123456CA.Location", Cardinality.create("0-1")));
		
		messageSet.addMessagePart(location);
		messageSet.addMessagePart(place);
		MessagePart parameterList = messageSet.getMessagePart("ABCD_MT123456CA.ParameterList");
		parameterList.getRelationships().add(new Relationship("location", "ABCD_MT123456CA.Location", Cardinality.create("0-1")));
		
		createDifference(messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
	}
	
	private void createDifference(HasDifferences differences) {
		Difference difference = new Difference();
		difference.setOk(false);
		differences.addDifference(difference);
	}
	
	@Test
	public void shouldRemoveDependenciesWithChoiceDifference() throws Exception {
		Relationship choiceNotOk = new Relationship("otherPlace", "ABCD_MT123456CA.OtherPlace", Cardinality.create("0-1"));
		createDifference(choiceNotOk);
		
		Relationship choiceOk = new Relationship("anotherPlace", "ABCD_MT123456CA.AnotherPlace", Cardinality.create("0-1"));

		Relationship rel = new Relationship("place", "ABCD_MT123456CA.Place", Cardinality.create("0-1"));
		rel.getChoices().add(choiceNotOk);
		rel.getChoices().add(choiceOk);
		
		MessagePart part = new MessagePart("ABCD_MT123456CA.Message");
		part.getRelationships().add(rel);
		
		PackageLocation packageLocation = new PackageLocation("ABCD_MT123456CA");
		packageLocation.setRootType(part.getName());
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", packageLocation);
		messageSet.addMessagePart(part);
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		messageSet.getInteractions().put(interaction.getName(), interaction);
		
		new Exciser(messageSet, new PreMergeEvaluator()).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		// we have decided that leaving an empty package location (or one containing orphaned parts) is acceptable
		assertNotNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("message part", messageSet.getMessagePart("ABCD_MT123456CA.Message"));
	}
	
}
