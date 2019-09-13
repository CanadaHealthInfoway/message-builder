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

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.delta.AddInteractionArgument;
import ca.infoway.messagebuilder.xml.delta.AddInteractionConstraint;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.InteractionDelta;
import ca.infoway.messagebuilder.xml.delta.TemplateParameterConstraint;

@RunWith(MockitoJUnitRunner.class)
public class InteractionDeltaVisitorTest {
	
	private InteractionDelta delta;
	private MessageSet messageSet;
	private InteractionDeltaVisitor visitor;
	
	
	@Before
	public void setup() throws Exception {
		this.messageSet = new MessageSetMarshaller().unmarshall(new File("src/test/resources/messageSet_r02_04_02.xml"));
		this.delta = new InteractionDelta();
	}
	
	@Test
	public void applyAddConstraint() throws Exception {
		AddInteractionConstraint addConstraint = new AddInteractionConstraint("MCCI_MT002100CA.Message");
		addConstraint.getArguments().add(new AddInteractionArgument("ControlActEvent", "controlActEvent", "QUQI_MT120006CA.ControlActEvent"));
		addConstraint.getArguments().add(new AddInteractionArgument("Act", "patientCareProvisionEvent", "COCT_MT011001CA.PatientCareProvisionEvent"));
		addConstraint.getArguments().add(new AddInteractionArgument("ParameterList", "parameterList", "PRPA_MT101101CA.ParameterList"));
		this.delta.setClassName("PRPA_IN999999CA");
		this.delta.setDeltaChangeType(DeltaChangeType.ADD);
		this.delta.addConstraint(addConstraint);
		this.visitor = new InteractionDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(addConstraint);

		Interaction interaction = this.messageSet.getInteractions().get("PRPA_IN999999CA");
		assertNotNull("null interaction", interaction);
		assertEquals("interaction name", "PRPA_IN999999CA", interaction.getName());
		assertEquals("super type name", "MCCI_MT002100CA.Message", interaction.getSuperTypeName());
		assertEquals("super type has one argument", 1, interaction.getArguments().size());
		
		Argument topLevelArgument = interaction.getArgumentByTemplateParameterName("ControlActEvent");
		assertNotNull("top level argument exists", topLevelArgument);
		assertEquals("top level argument name", "QUQI_MT120006CA.ControlActEvent", topLevelArgument.getName());
		assertEquals("top level argument traversal name", "controlActEvent", topLevelArgument.getTraversalName());
		assertEquals("top level argument has two children", 2, topLevelArgument.getArguments().size());
		
		// I'm not sure whether order really matters
		Argument firstChildArgument = topLevelArgument.getArguments().get(0);
		assertEquals("first child argument name", "PRPA_MT101101CA.ParameterList", firstChildArgument.getName());
		assertEquals("first child argument template parameter name", "ParameterList", firstChildArgument.getTemplateParameterName());
		assertEquals("first child argument traversal name", "parameterList", firstChildArgument.getTraversalName());
		assertEquals("first child argument has no children", 0, firstChildArgument.getArguments().size());

		Argument secondChildArgument = topLevelArgument.getArguments().get(1);
		assertEquals("second child argument name", "COCT_MT011001CA.PatientCareProvisionEvent", secondChildArgument.getName());
		assertEquals("second child argument template parameter name", "Act", secondChildArgument.getTemplateParameterName());
		assertEquals("second child argument traversal name", "patientCareProvisionEvent", secondChildArgument.getTraversalName());
		assertEquals("second child argument has no children", 0, secondChildArgument.getArguments().size());
	}
	
	@Test
	public void shouldApplyTemplateParameterConstraint() throws Exception {
		TemplateParameterConstraint constraint = new TemplateParameterConstraint();
		constraint.setTemplateParameterName("Act");
		constraint.setOriginalMessagePartName("COMT_MT001103CA.ActEvent");
		constraint.setNewMessagePartName("COMT_MT001104CA.ActEvent");
		constraint.setOriginalTraversalName("actEvent");
		constraint.setNewTraversalName("sceneEvent");
		this.delta.setClassName("PORX_IN020090CA");
		this.delta.setDeltaChangeType(DeltaChangeType.ADD);
		this.delta.addConstraint(constraint);
		this.visitor = new InteractionDeltaVisitor(delta, messageSet);
		
		this.visitor.visit(constraint);
		
		Interaction interaction = this.messageSet.getInteractions().get("PORX_IN020090CA");
		assertNotNull("null interaction", interaction);
		
		Argument targetArgument = interaction.getArgumentByTemplateParameterName("Act");
		assertNotNull("argument not found", targetArgument);
		assertEquals("argument name", "COMT_MT001104CA.ActEvent", targetArgument.getName());
		assertEquals("argument traversal name", "sceneEvent", targetArgument.getTraversalName());
	}
}
