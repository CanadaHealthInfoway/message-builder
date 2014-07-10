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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.cda.CdaXsdProcessor;
import ca.infoway.messagebuilder.generator.cda.Schema;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.ConstraintChangeType;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

public class CdaTemplateProcessorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static TemplateSet templateSet = new TemplateSet();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		new CdaXsdProcessor().processSchema(schema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("Consolidation.xml"));
		
		new CdaTemplateProcessor().parseTemplate(templateExport, messageSet, templateSet);
	}
	
	@Test
	public void shouldCreateTemplates() throws Exception {
		assertNotNull(templateSet);
		
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		assertFalse(template.isOpen());
		assertEquals("Observation", template.getContextType());
		assertEquals("entry", template.getTemplateType());
		assertEquals("observation", template.getContext());
		assertEquals("This clinical statement represents the anticipated date when a woman will give birth.", template.getDescription());
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		assertTrue(template.isOpen());
		assertEquals("ClinicalDocument", template.getContextType());
		assertEquals("document", template.getTemplateType());
		assertEquals("ClinicalDocument", template.getContext());
		assertEquals("This section describes constraints that apply to the header for all documents within the scope of this implementation guide. Header constraints specific to each document type are described in the appropriate document-specific section below.", template.getDescription());
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.5.1");
		assertNotNull(template);
		assertTrue(template.isOpen());
		assertEquals("PN", template.getContextType());
		assertEquals("unspecified", template.getTemplateType());
		assertEquals("name", template.getContext());
		assertEquals("The US Realm Patient Name datatype flavor is a set of reusable constraints that can be used for the patient or any other person. It requires a first (given) and last (family) name. If a patient or person has only one name part (e.g., patient with first name only) place the name part in the field required by the organization. Use the appropriate nullFlavor, \"\"Not Applicable\"\" (NA), in the other field.\n" +
				"For information on mixed content see the Extensible Markup Language reference (http://www.w3c.org/TR/2008/REC-xml-20081126/).", template.getDescription());
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.7");
		assertNotNull(template);
		assertTrue(template.isOpen());
		assertEquals("Observation", template.getContextType());
		assertEquals("entry", template.getTemplateType());
		assertEquals("observation", template.getContext());
		assertEquals("2.16.840.1.113883.10.20.24.3.90", template.getImpliedTemplateOid());
		assertEquals("This clinical statement represents that an allergy or adverse reaction exists or does not exist. The agent that is the cause of the allergy or adverse reaction is represented as a manufactured material participant playing entity in the allergy observation. While the agent is often implicit in the alert observation (e.g. \"\"allergy to penicillin\"\"), it should also be asserted explicitly as an entity. The manufactured material participant is used to represent natural and non-natural occurring substances.\n\n" +
				"NOTE: The agent responsible for an allergy or adverse reaction is not always a manufactured material (for example, food allergies), nor is it necessarily consumed. The following constraints reflect limitations in the base CDA R2 specification, and should be used to represent any type of responsible agent.", template.getDescription());
	}
	
	@Test
	public void shouldParseBasicConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCardinalityCase = false;
		boolean foundFixedValueCase = false;
		boolean foundDataTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("templateId")) {
				foundCardinalityCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("classCode")) {
				foundFixedValueCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("OBS", ((FixedConstraint) fixedConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("value")) {
				foundDataTypeCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(dataTypeConstraint);
				assertEquals("TS", ((DatatypeConstraint) dataTypeConstraint).getNewValue());
			}
		}
		assertTrue(foundCardinalityCase);
		assertTrue(foundFixedValueCase);
		assertTrue(foundDataTypeCase);
	}

	@Test
	public void shouldParseBasicAssociationConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCardinalityCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				foundCardinalityCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(foundCardinalityCase);
	}
	
	@Test
	public void shouldParseInnerFieldConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundInnerFieldCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("templateId.root")) {
				foundInnerFieldCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());

				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("2.16.840.1.113883.10.20.15.3.1", ((FixedConstraint) fixedConstraint).getNewValue());
			}
			
		}
		assertTrue(foundInnerFieldCase);
	}
	
	
	@Test
	public void shouldParseNestedInnerFieldConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundFirstInnerConstraint = false;
		boolean foundSecondInnerConstraint = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.SubstanceAdministration") && delta.getRelationshipName().equals("text")) {
				
				fail("Should not find empty constraint");
			}
			
			if (delta.getClassName().equals("POCD_MT000040.SubstanceAdministration") && delta.getRelationshipName().equals("text.reference")) {
				foundFirstInnerConstraint = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNull(conformanceConstraint);

				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNull(fixedConstraint);
			}
			
			if (delta.getClassName().equals("POCD_MT000040.SubstanceAdministration") && delta.getRelationshipName().equals("text.reference.value")) {
				foundSecondInnerConstraint = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNull(conformanceConstraint);
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNull(fixedConstraint);
			}
			
		}
		assertTrue(foundFirstInnerConstraint);
		assertTrue(foundSecondInnerConstraint);
	}
	
	@Test
	public void shouldParseNestedAssociationConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundFixedCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.EntryRelationship") && delta.getRelationshipName().equals("typeCode")) {
				foundFixedCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("REFR", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundFixedCase);
	}
	
	@Test
	public void shouldNarrowChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCardinalityConstraint = false;
		int constraints = 0;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				foundCardinalityConstraint = true;
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("POCD_MT000040.EntryRelationship") && delta.getRelationshipName().equals("EntryRelationship_11")) {
				assertEquals(DeltaChangeType.CHOICE, delta.getDeltaChangeType());
				
				for (Constraint constraint : delta.getAllConstraints(ConstraintChangeType.REMOVE_CHOICE)) {
					assertFalse("POCD_MT000040.Observation".equals(((RemoveChoiceConstraint) constraint).getChoiceClassName()));
					constraints++;
				}
				
			}
		}
		assertTrue(foundCardinalityConstraint);
		assertEquals(8, constraints);
		
		assertEquals(1, template.getTemplateReferences().size());
		assertEquals("POCD_MT000040.EntryRelationship.observation", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.15.3.1", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getMaxInstances());
	}
	
	@Test
	public void shouldNotNarrowChoicesForOpenTemplateWithUnlimitedCardinality() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}

			if (delta.getClassName().equals("POCD_MT000040.Entry") && delta.getRelationshipName().equals("Entry_7")) {
				fail("The choice should be unconstrained");
			}
		}
		
		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("POCD_MT000040.Entry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getMaxInstances());
		assertEquals("POCD_MT000040.Entry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(1).getMaxInstances());
		assertEquals("POCD_MT000040.Entry.act", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.12", template.getTemplateReferences().get(2).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(2).getMaxInstances());
	}
	
	@Test
	public void shouldManageCardinalityForComplexChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("POCD_MT000040.Entry") && delta.getRelationshipName().equals("Entry_7")) {
				fail("The choice should be unconstrained");
			}
		}
		
		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("POCD_MT000040.Entry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getMaxInstances());
		assertEquals("POCD_MT000040.Entry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(1, template.getTemplateReferences().get(1).getMaxInstances());
		assertEquals("POCD_MT000040.Entry.act", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.12", template.getTemplateReferences().get(2).getOid());
		assertEquals(1, template.getTemplateReferences().get(2).getMaxInstances());
	}
	
	@Test
	public void shouldRemoveUnreferencedRelationshipsFromClosedTemplates() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundStructuralAttributeCase = false;
		boolean foundNonstructuralAttributeCase = false;
		boolean foundAssociationCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("negationInd")) {
				foundStructuralAttributeCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			}
			
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("realmCode")) {
				foundNonstructuralAttributeCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			}
			
			if (delta.getClassName().equals("POCD_MT000040.Observation") && delta.getRelationshipName().equals("subject")) {
				foundAssociationCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			}
		}
		assertTrue(foundStructuralAttributeCase);
		assertTrue(foundNonstructuralAttributeCase);
		assertTrue(foundAssociationCase);
		
		Template openTemplate = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		for (Delta delta : openTemplate.getDeltas()) {
			if (DeltaChangeType.REMOVE.equals(delta.getDeltaChangeType())) {
				fail("Unexpected remove delta for " + delta.getClassName() + " " + delta.getRelationshipName());
			}
		}
	}
	
}
