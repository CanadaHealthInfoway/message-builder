/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.model.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class BridgeFactoryImplTest {
	
	private static final VersionNumber VERSION = MockVersionNumber.MOCK_NEWFOUNDLAND;
	
	private MessageDefinitionService service;
	private MockMessageDefinitionService mockService;

	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		this.service = new MockTestCaseMessageDefinitionService();
		this.mockService = new MockMessageDefinitionService();
	}
	
	@Test
	public void shouldHandleSimpleCollapsedTypes() throws Exception {

		FindCandidatesCriteria bean = new FindCandidatesCriteria();
		bean.setBirthDate(new Date());
		MessagePart part = this.service.getMessagePart(VERSION, "PRPA_MT101103CA.ParameterList");
		PartBridge bridge = new BridgeFactoryImpl(this.service, VERSION).createPartBridgeFromBean("", bean, 
				this.service.getInteraction(VERSION, "PRPA_IN101103CA"), 
				new MessagePartHolder(this.service, VERSION, "PRPA_MT101103CA.ParameterList"));
	
		assertEquals("bridge", 6, bridge.getRelationshipBridges().size());
		BaseRelationshipBridge relationshipBridge = bridge.getRelationshipBridges().get(0);
		assertEquals("type", "administrativeGender", relationshipBridge.getRelationship().getName());
		
		relationshipBridge = bridge.getRelationshipBridges().get(1);
		assertEquals("type", "clientId", relationshipBridge.getRelationship().getName());
		
		relationshipBridge = bridge.getRelationshipBridges().get(2);
		assertEquals("type", "personAddress", relationshipBridge.getRelationship().getName());
		
		relationshipBridge = bridge.getRelationshipBridges().get(3);
		assertEquals("type", "personBirthtime", relationshipBridge.getRelationship().getName());
		
		relationshipBridge = bridge.getRelationshipBridges().get(4);
		assertEquals("type", "personName", relationshipBridge.getRelationship().getName());
		
		relationshipBridge = bridge.getRelationshipBridges().get(5);
		assertEquals("type", "personTelecom", relationshipBridge.getRelationship().getName());
	}

	@Test
	public void shouldProcessInteraction() throws Exception {
		final Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA.SimpleInteraction");
		interaction.setSuperTypeName("ABCD_MT123456CA.MessageBean");
		final MessagePart partB = new MessagePart("ABCD_MT123456CA.BeanB");
		partB.getRelationships().add(new Relationship("text", "ST", Cardinality.create("1")));
		final MessagePart message = new MessagePart("ABCD_MT123456CA.MessageBean");
		message.getRelationships().add(new Relationship("bean", "ABCD_MT123456CA.BeanB", Cardinality.create("1")));

		mockService.addPart("ABCD_MT123456CA.MessageBean", message);
		mockService.addPart("ABCD_MT123456CA.BeanB", partB);
		mockService.addInteraction("ABCD_IN123456CA.SimpleInteraction", interaction);
		
		SimpleInteraction interactionBean = new SimpleInteraction();
		interactionBean.setBean(new BeanB());
		
		PartBridge bridge = new BridgeFactoryImpl(this.mockService,VERSION).createInteractionBridge(interactionBean);
		assertNotNull("bridge", bridge);
	
	}
	
	@Test
	public void shouldHandleCollapsedTypesWithOuterMultipleCardinalityAndSeveralLevelsOfCollapsing() throws Exception {
		
		final MessagePart partB = new MessagePart("ABCE_MT123456CA.BeanB");
		partB.getRelationships().add(new Relationship("text", "ST", Cardinality.create("1")));
		
		final MessagePart elidedPart1 = new MessagePart("ABCE_MT123456CA.ElidedPart1");
		elidedPart1.getRelationships().add(new Relationship("component", "ABCE_MT123456CA.ElidedPart2", Cardinality.create("1")));
		
		final MessagePart elidedPart2 = new MessagePart("ABCE_MT123456CA.ElidedPart2");
		elidedPart2.getRelationships().add(new Relationship("issue", "ABCE_MT123456CA.BeanB", Cardinality.create("1")));
		
		mockService.addPart(elidedPart1.getName(), elidedPart1);
		mockService.addPart(elidedPart2.getName(), elidedPart2);
		mockService.addPart(partB.getName(), partB);
		
		BeanAPrime bean = new BeanAPrime();
		bean.getIssues().add(new BeanB());
		bean.getIssues().add(new BeanB());
		
		MessagePart part = new MessagePart();
		Relationship subjectOfRelationship = new Relationship("subjectOf", "ABCE_MT123456CA.ElidedPart1", Cardinality.create("0-50"));
		assertTrue("association", subjectOfRelationship.isAssociation());
		part.getRelationships().add(subjectOfRelationship);
		
		PartBridge bridge = new BridgeFactoryImpl(this.mockService, VERSION).createPartBridgeFromBean("controlAct", bean, 
				new Interaction(), new MessagePartHolder(part));
		
		assertEquals("size", 1, bridge.getRelationshipBridges().size());
		assertEquals("name of relationship", "subjectOf", bridge.getRelationshipBridges().get(0).getRelationship().getName());
		
		BaseRelationshipBridge relationship = bridge.getRelationshipBridges().get(0);
		assertTrue("association relationship", relationship.isAssociation());
		
		Collection<PartBridge> values = ((AssociationBridge) relationship).getAssociationValues();
		assertEquals("number of values", 2, values.size());
	}
	
	@Test
	public void shouldHandleCollapsedTypesWithOuterMultipleCardinality() throws Exception {
		
		final MessagePart partB = new MessagePart("ABCE_MT123456CA.BeanB");
		partB.getRelationships().add(new Relationship("text", "ST", Cardinality.create("1")));
		
		final MessagePart elidedPart = new MessagePart("ABCE_MT123456CA.ElidedPart");
		elidedPart.getRelationships().add(new Relationship("issue", "ABCE_MT123456CA.BeanB", Cardinality.create("1")));
		
		mockService.addPart(elidedPart.getName(), elidedPart);
		mockService.addPart(partB.getName(), partB);
		
		BeanA bean = new BeanA();
		bean.getIssues().add(new BeanB());
		bean.getIssues().add(new BeanB());
		
		MessagePart part = new MessagePart();
		Relationship subjectOfRelationship = new Relationship("subjectOf", "ABCE_MT123456CA.ElidedPart", Cardinality.create("0-50"));
		assertTrue("association", subjectOfRelationship.isAssociation());
		part.getRelationships().add(subjectOfRelationship);
		
		PartBridge bridge = new BridgeFactoryImpl(this.mockService, VERSION).createPartBridgeFromBean("controlAct", bean, 
				new Interaction(), new MessagePartHolder(part));
		
		assertEquals("size", 1, bridge.getRelationshipBridges().size());
		assertEquals("name of relationship", "subjectOf", bridge.getRelationshipBridges().get(0).getRelationship().getName());
		
		BaseRelationshipBridge relationship = bridge.getRelationshipBridges().get(0);
		assertTrue("association relationship", relationship.isAssociation());
		
		Collection<PartBridge> values = ((AssociationBridge) relationship).getAssociationValues();
		assertEquals("number of values", 2, values.size());
		
		for (PartBridge partBridge : values) {
			List<BaseRelationshipBridge> relationshipBridges = partBridge.getRelationshipBridges();
			assertEquals("inner relationships", 1, relationshipBridges.size());
			BaseRelationshipBridge temp = relationshipBridges.get(0);
			AssociationBridge association = (AssociationBridge) temp;
			Collection<PartBridge> innerValues = association.getAssociationValues();
			assertFalse("has value", innerValues.isEmpty());
		}
	}
}
