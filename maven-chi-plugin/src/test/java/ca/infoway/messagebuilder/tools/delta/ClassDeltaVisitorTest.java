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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools.delta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.AddConstraint;
import ca.infoway.messagebuilder.xml.delta.ClassDelta;
import ca.infoway.messagebuilder.xml.delta.CloneConstraint;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;

@RunWith(MockitoJUnitRunner.class)
public class ClassDeltaVisitorTest {
	
	private ClassDelta delta;
	private MessageSet messageSet;
	private ClassDeltaVisitor visitor;
	
	
	@Before
	public void setup() throws Exception {
		this.messageSet = new MessageSetMarshaller().unmarshall(new File("src/test/resources/messageSet_r02_04_02.xml"));
		this.delta = new ClassDelta();
	}
	
	@Test
	public void applyCloneConstraint() throws Exception {
		CloneConstraint constraint;
		constraint = new CloneConstraint("COCT_MT011001CA.ClonedLocation", null, "COCT_MT011001CA.ServiceDeliveryLocation");
		this.delta.setClassName(constraint.getClassName());
		this.delta.setDeltaChangeType(DeltaChangeType.CLONE);
		this.delta.addConstraint(constraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		this.visitor.visit(constraint);
		
		MessagePart originalMessagePart = this.messageSet.getMessagePart("COCT_MT011001CA.ServiceDeliveryLocation");
		MessagePart messagePart = this.messageSet.getMessagePart("COCT_MT011001CA.ClonedLocation");
		assertNotNull(messagePart);
		List<Relationship> relationships = messagePart.getRelationships();
		List<Relationship> originalRelationships = originalMessagePart.getRelationships();
		assertFalse(relationships.equals(originalRelationships));
		for (int i=0; i < relationships.size(); ++i) {
			assertEquals(relationships.get(i).getName(), originalRelationships.get(i).getName());
			assertEquals(relationships.get(i).getCardinality().getMax(), originalRelationships.get(i).getCardinality().getMax());
			assertEquals(relationships.get(i).getCardinality().getMin(), originalRelationships.get(i).getCardinality().getMin());
		}
	}

	@Test
	public void applyAddConstraint() throws Exception {
		AddConstraint addConstraint = new AddConstraint("COCT_MT011001CA.NewLocation", null, false);
		this.delta.setClassName(addConstraint.getClassName());
		this.delta.setDeltaChangeType(DeltaChangeType.ADD);
		this.delta.addConstraint(addConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("COCT_MT011001CA.NewLocation");
		assertNotNull(messagePart);
		assertEquals("COCT_MT011001CA.NewLocation", messagePart.getName());
	}
	
	@Test
	public void shouldApplySetAbstractFlag() {
		AddConstraint addConstraint = new AddConstraint("COCT_MT011001CA.NewLocation", null, true);		this.delta.setClassName(addConstraint.getClassName());
		this.delta.setDeltaChangeType(DeltaChangeType.ADD);
		this.delta.addConstraint(addConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("COCT_MT011001CA.NewLocation");
		assertNotNull(messagePart);
		assertEquals("COCT_MT011001CA.NewLocation", messagePart.getName());
		assertTrue(messagePart.isAbstract());
	}
	
	@Ignore
	@Test 
	public void shouldAddNonExistantPackage() throws Exception {
		AddConstraint addConstraint = new AddConstraint("NEW_PACKAGE.NewPart", null, false);
		this.delta.setClassName(addConstraint.getClassName());
		this.delta.setDeltaChangeType(DeltaChangeType.ADD);
		this.delta.addConstraint(addConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addConstraint);
		
		assertNotNull(this.messageSet.getPackageLocations().get("NEW_PACKAGE"));
		assertNotNull(this.messageSet.getPackageLocationRootType("NEW_PACKAGE"));
		MessagePart messagePart = this.messageSet.getMessagePart("NEW_PACKAGE.NewPart");
		assertNotNull(messagePart);
		assertEquals("NEW_PACKAGE.NewPart", messagePart.getName());
	}
	
	@Test
	public void shouldAddNewPartToChoiceBlock() throws Exception {
		AddChoiceConstraint addChoiceConstraint = new AddChoiceConstraint("COCT_MT050007CA.Patient");
		this.delta.setClassName("POLB_MT001000CA.RequestChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(addChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001000CA.RequestChoice");
		assertEquals("number of children", 4, messagePart.getSpecializationChilds().size());
		assertTrue("contains new part", messagePart.hasSpecializationChild("COCT_MT050007CA.Patient"));
	}

	@Test
	public void shouldRemovePartFromChoiceBlock() throws Exception {
		RemoveChoiceConstraint removeChoiceConstraint = new RemoveChoiceConstraint("POLB_MT001000CA.PlacerGroup");
		this.delta.setClassName("POLB_MT001000CA.RequestChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(removeChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(removeChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001000CA.RequestChoice");
		assertEquals("number of children", 2, messagePart.getSpecializationChilds().size());
		assertFalse("does not contain removed part", messagePart.getSpecializationChilds().contains("POLB_MT001000CA.PlacerGroup"));
	}
	
	@Test
	public void shouldRemoveDeletedPartFromChoiceBlock() throws Exception {
		RemoveConstraint removeConstraint = new RemoveConstraint("POLB_MT001000CA.PlacerGroup", null);
		this.delta.setClassName("POLB_MT001000CA.PlacerGroup");
		this.delta.setDeltaChangeType(DeltaChangeType.REMOVE);
		this.delta.addConstraint(removeConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(removeConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001000CA.RequestChoice");
		assertEquals("number of children", 2, messagePart.getSpecializationChilds().size());
		assertFalse("does not contain removed part", messagePart.getSpecializationChilds().contains("POLB_MT001000CA.PlacerGroup"));
	}

	@Test
	public void shouldRemovePartFromRelationshipsToChoiceBlock() throws Exception {
		RemoveChoiceConstraint removeChoiceConstraint = new RemoveChoiceConstraint("POLB_MT004000CA.BatteryEvent");
		this.delta.setClassName("POLB_MT004000CA.ResultChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(removeChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(removeChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001999CA.InFulfillmentOf");
		Relationship topLevelChoiceRelationship = messagePart.getRelationship("resultChoice1");
		assertChoicesDoNotContain(topLevelChoiceRelationship.getChoices(), "POLB_MT004000CA.BatteryEvent");
	}
	
	@Test
	public void shouldNotRemovePartFromRelationshipsToOtherChoiceBlocks() throws Exception {
		RemoveChoiceConstraint removeChoiceConstraint = new RemoveChoiceConstraint("COCT_MT090502CA.AssignedEntity");
		this.delta.setClassName("POLB_MT001999CA.RecipientChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(removeChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(removeChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001999CA.InformationRecipient");
		Relationship topLevelChoiceRelationship = messagePart.getRelationship("recipientChoice");
		assertChoicesDoNotContain(topLevelChoiceRelationship.getChoices(), "COCT_MT090502CA.AssignedEntity");
		
		messagePart = this.messageSet.getMessagePart("POLB_MT001010CA.InformationRecipient");
		topLevelChoiceRelationship = messagePart.getRelationship("recipientChoice");	// abstract class = POLB_MT001010CA.RecipientChoice
		assertTrue(choicesContain(topLevelChoiceRelationship.getChoices(), "COCT_MT090502CA.AssignedEntity", "assignedEntity1"));
	}

	@Test
	public void shouldAddPartToRelationshipsToChoiceBlock() throws Exception {
		AddChoiceConstraint addChoiceConstraint = new AddChoiceConstraint("COCT_MT050007CA.Patient");
		this.delta.setClassName("POLB_MT001000CA.RequestChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(addChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT001000CA.Component5");
		Relationship topLevelChoiceRelationship = messagePart.getRelationship("requestChoice");
		assertTrue(choicesContain(topLevelChoiceRelationship.getChoices(), "COCT_MT050007CA.Patient", "patient"));
	}
	
	@Test
	public void shouldAddNestedPartsToRelationshipsToChoiceBlock() throws Exception {
		AddChoiceConstraint addChoiceConstraint = new AddChoiceConstraint("POLB_MT004200CA.ObservationChoice");
		this.delta.setClassName("POLB_MT004000CA.ResultChoice");
		this.delta.setDeltaChangeType(DeltaChangeType.CHOICE);
		this.delta.addConstraint(addChoiceConstraint);
		this.visitor = new ClassDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addChoiceConstraint);
		
		MessagePart messagePart = this.messageSet.getMessagePart("POLB_MT004000CA.Component1");
		Relationship topLevelChoiceRelationship = messagePart.getRelationship("resultChoice");
		assertTrue("direct choice", choicesContain(topLevelChoiceRelationship.getChoices(), "POLB_MT004200CA.ObservationChoice", "observationChoice"));
		assertTrue("nested choice", choicesContain(topLevelChoiceRelationship.getChoices(), "POLB_MT004200CA.ObservationReport", "observationReport2"));
	}
	
	private void assertChoicesDoNotContain(List<Relationship> choices, String partName) {
		for (Relationship choice : choices) {
			assertFalse("does not contain removed part", choice.getType().equals(partName));
			assertChoicesDoNotContain(choice.getChoices(), partName);
		}
	}

	private boolean choicesContain(List<Relationship> choices, String partName, String relationshipName) {
		boolean found = false;
		for (Relationship choice : choices) {
			found |= (choice.getType().equals(partName) && choice.getName().equals(relationshipName)) || 
					choicesContain(choice.getChoices(), partName, relationshipName);
		}
		return found;
	}
}
