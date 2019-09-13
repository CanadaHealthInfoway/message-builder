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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AssociationTypeConstraint;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;


public class AssociationDeltaVisitorTest {

	private MessageSet messageSet;
	private MessagePart part;
	private Relationship relationship;

	@Test
	public void shouldUpdateConformanceLevel() throws Exception {
		AssociationDelta delta = new AssociationDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("person");
		ConformanceConstraint constraint = new ConformanceConstraint();
		constraint.setOriginalValue(ConformanceLevel.MANDATORY);
		constraint.setNewValue(ConformanceLevel.POPULATED);
		
		new AssociationDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("conformance", ConformanceLevel.POPULATED, relationship.getConformance());
	}

	@Test
	public void shouldRemoveNotAllowedConformanceLevel() throws Exception {
		AssociationDelta delta = new AssociationDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("person");
		ConformanceConstraint constraint = new ConformanceConstraint();
		constraint.setOriginalValue(ConformanceLevel.MANDATORY);
		constraint.setNewValue(ConformanceLevel.NOT_ALLOWED);
		
		assertNotNull(this.messageSet.getMessagePart("ABCD_MT123456CA.Patient").getRelationship("person"));
		
		new AssociationDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertNull(this.messageSet.getMessagePart("ABCD_MT123456CA.Patient").getRelationship("person"));
	}

	@Test
	public void shouldUpdateCardinalityLevel() throws Exception {
		AssociationDelta delta = new AssociationDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("person");
		CardinalityConstraint constraint = new CardinalityConstraint();
		constraint.setOriginalCardinality(Cardinality.create("1"));
		constraint.setNewCardinality(Cardinality.create("1-3"));
		
		new AssociationDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("conformance", Cardinality.create("1-3"), relationship.getCardinality());
	}
	
	@Test
	public void shouldAddChoicesToRelationshipToAbstractClass() throws Exception {
		createTestDataForChoiceTest();
		
		AssociationDelta delta = new AssociationDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("choice");
		delta.setDeltaChangeType(DeltaChangeType.ADD);
		AssociationTypeConstraint constraint = new AssociationTypeConstraint(null, "ABCD_MT123456CA.Abstract");
		delta.addConstraint(constraint);
		// for the purposes of this test case, we don't care about conformance, cardinality
		
		new AssociationDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		Relationship newRelationship = this.messageSet.getMessagePart("ABCD_MT123456CA.Patient").getRelationship("choice");
		assertNotNull(newRelationship);
		assertEquals("ABCD_MT123456CA.Abstract", newRelationship.getType());
		assertEquals("choice", newRelationship.getName());
		assertEquals(2, newRelationship.getChoices().size());
		
		Relationship firstChild = newRelationship.getChoices().get(0);
		assertEquals("ABCD_MT123456CA.AbstractChild", firstChild.getType());
		assertEquals("abstractChild", firstChild.getName());
		assertEquals(2, firstChild.getChoices().size());
		
		Relationship secondChild = newRelationship.getChoices().get(1);
		assertEquals("ABCD_MT123456CA.Child1", secondChild.getType());
		assertEquals("child1", secondChild.getName());
		assertEquals(0, secondChild.getChoices().size());
		
		Relationship firstGrandchild = firstChild.getChoices().get(0);
		assertEquals("ABCD_MT123456CA.Child2", firstGrandchild.getType());
		assertEquals("child2", firstGrandchild.getName());
		assertEquals(0, firstGrandchild.getChoices().size());
		
		Relationship secondGrandchild = firstChild.getChoices().get(1);
		assertEquals("ABCD_MT123456CA.Child3", secondGrandchild.getType());
		assertEquals("child3", secondGrandchild.getName());
		assertEquals(0, secondGrandchild.getChoices().size());
		
		
	}
	
	@Before
	public void setUp() {
		this.messageSet = new MessageSet();
		this.messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		this.part = new MessagePart("ABCD_MT123456CA.Patient");
		this.messageSet.addMessagePart(this.part);

		this.relationship = new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1"));
		this.relationship.setConformance(ConformanceLevel.MANDATORY);
		this.part.getRelationships().add(this.relationship);
	}
	
	public void createTestDataForChoiceTest() {
		MessagePart abstractPart = createPart("ABCD_MT123456CA.Abstract", true);
		MessagePart abstractChildPart = createPart("ABCD_MT123456CA.AbstractChild", true);
		MessagePart childPart1 = createPart("ABCD_MT123456CA.Child1", false);
		MessagePart childPart2 = createPart("ABCD_MT123456CA.Child2", false);
		MessagePart childPart3 = createPart("ABCD_MT123456CA.Child3", false);
		
		abstractPart.getSpecializationChilds().add(new SpecializationChild(abstractChildPart.getName()));
		abstractPart.getSpecializationChilds().add(new SpecializationChild(childPart1.getName()));
		abstractChildPart.getSpecializationChilds().add(new SpecializationChild(childPart2.getName()));
		abstractChildPart.getSpecializationChilds().add(new SpecializationChild(childPart3.getName()));
	}

	private MessagePart createPart(String name, boolean isAbstract) {
		MessagePart part = new MessagePart(name);
		part.setAbstract(isAbstract);
		this.messageSet.addMessagePart(part);
		
		return part;
	}
}
