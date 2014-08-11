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
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AssociationTypeConstraint;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.CloneConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.ConstraintChangeType;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.SchematronConstraint;
import ca.infoway.messagebuilder.xml.delta.VocabularyBindingConstraint;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

public class CdaTemplateProcessorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static TemplateSet templateSet = new TemplateSet();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		new CdaXsdProcessor().processSchema(schema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/Consolidation.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc.xml"));
		
		new CdaTemplateProcessor(valueSetDefinition).parseTemplate(templateExport, messageSet, templateSet);
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
		assertEquals("EstimatedDateOfDelivery", template.getPackageName());
		assertEquals("EstimatedDateOfDelivery.Observation", template.getEntryClassName());
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		assertTrue(template.isOpen());
		assertEquals("ClinicalDocument", template.getContextType());
		assertEquals("document", template.getTemplateType());
		assertEquals("ClinicalDocument", template.getContext());
		assertEquals("This section describes constraints that apply to the header for all documents within the scope of this implementation guide. Header constraints specific to each document type are described in the appropriate document-specific section below.", template.getDescription());
		assertEquals("USRealmHeader", template.getPackageName());
		assertEquals("USRealmHeader.ClinicalDocument", template.getEntryClassName());
		
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
		assertEquals("AllergyIntoleranceObservation", template.getPackageName());
		assertEquals("AllergyIntoleranceObservation.Observation", template.getEntryClassName());
	}
	
	@Test
	public void shouldParseBasicConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCloneCase = false;
		boolean foundCardinalityCase = false;
		boolean foundFixedValueCase = false;
		boolean foundDataTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName() == null) {
				foundCloneCase = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("templateId")) {
				foundCardinalityCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(dataTypeConstraint);
				assertEquals("LIST<II>", ((DatatypeConstraint) dataTypeConstraint).getOriginalValue());
				assertEquals("II", ((DatatypeConstraint) dataTypeConstraint).getNewValue());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("classCode")) {
				foundFixedValueCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("OBS", ((FixedConstraint) fixedConstraint).getNewValue());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("value")) {
				foundDataTypeCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(dataTypeConstraint);
				assertEquals("TS", ((DatatypeConstraint) dataTypeConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(foundCardinalityCase);
		assertTrue(foundFixedValueCase);
		assertTrue(foundDataTypeCase);
	}

	@Test
	public void shouldParseFixedValuesForCodedAttributesWithDatatypeInTemplate() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundFixedCase = false;
		boolean foundTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName().equals("value")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint typeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(typeConstraint);
				foundTypeCase = true;
				assertEquals("LIST<ANY>", ((DatatypeConstraint) typeConstraint).getOriginalValue());
				assertEquals("CD", ((DatatypeConstraint) typeConstraint).getNewValue());

				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				foundFixedCase = true;
				assertEquals("77386006", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundFixedCase);
		assertTrue(foundTypeCase);
	}

	@Test
	public void shouldParseFixedValuesListDataType() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundFixedCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("realmCode")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				foundFixedCase = true;
				assertEquals("US", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundFixedCase);
	}
	
	@Test
	public void shouldParseVocabularyBindingFromCodeOnly() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundAuthorCase = false;
		boolean foundPerformerCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("USRealmHeader.AssignedAuthor") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("USRealmHeader.AssignedAuthor") && delta.getRelationshipName().equals("code")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				foundAuthorCase = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("HealthcareProviderTaxonomyHIPAA", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			}

			if (delta.getClassName().equals("USRealmHeader.Performer1AssignedEntity") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("USRealmHeader.Performer1AssignedEntity") && delta.getRelationshipName().equals("code")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				foundPerformerCase = true;
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("NUCCProviderTaxonomy", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			}
		}
		assertTrue(foundAuthorCase);
		assertTrue(foundPerformerCase);
	}
	
	@Test
	public void shouldParseBasicAssociationConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCloneCase = false;
		boolean foundCardinalityCase = false;
		boolean foundTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName() == null) {
				foundCloneCase = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				
				assertTrue(delta instanceof AssociationDelta);
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				foundCardinalityCase = true;
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint typeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(typeConstraint);
				foundTypeCase = true;
				assertEquals("POCD_MT000040.EntryRelationship", ((AssociationTypeConstraint) typeConstraint).getOriginalValue());
				assertEquals("PregnancyObservation.EntryRelationship", ((AssociationTypeConstraint) typeConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(foundCardinalityCase);
		assertTrue(foundTypeCase);
	}
	
	@Test
	public void shouldParseExternalAssociations() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.Consumable") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("MedicationActivity.Consumable") && delta.getRelationshipName().equals("manufacturedProduct")) {
				
				assertTrue(delta instanceof AssociationDelta);
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint typeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(typeConstraint);
				foundTypeCase = true;
				assertEquals("POCD_MT000040.ManufacturedProduct", ((AssociationTypeConstraint) typeConstraint).getOriginalValue());
				assertEquals("MedicationInformation.ManufacturedProduct", ((AssociationTypeConstraint) typeConstraint).getNewValue());
			}
		}
		assertTrue(foundTypeCase);
	}
	
	@Test
	public void shouldParseInnerFieldConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundInnerFieldCase = false;
		boolean foundCloneCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName() == null) {
				foundCloneCase = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("templateId.root")) {
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
		assertTrue(foundCloneCase);
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.6.2.8");
		assertNotNull(template);
		deltas = template.getDeltas();
		
		foundCloneCase = false;
		boolean codeSystemConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("SOPInstanceObservation.Observation") && delta.getRelationshipName() == null) {
				foundCloneCase = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("SOPInstanceObservation.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("SOPInstanceObservation.Observation") && delta.getRelationshipName().equals("code.codeSystem")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				codeSystemConstraintFound = true;
				assertEquals("1.2.840.10008.2.6.1", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(codeSystemConstraintFound);
	}
	
	
	@Test
	public void shouldParseNestedInnerFieldConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCloneConstraint = false;
		boolean foundFirstInnerConstraint = false;
		boolean foundSecondInnerConstraint = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				foundCloneConstraint = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("MedicationActivity.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("text.reference")) {
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
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("text.reference.value")) {
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
		assertTrue(foundCloneConstraint);
		assertTrue(foundFirstInnerConstraint);
		assertTrue(foundSecondInnerConstraint);
	}
	
	@Test
	public void shouldParseNestedAssociationConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundCloneCase = false;
		boolean foundFixedCase = false;
		for (Delta delta : deltas) {
			
			if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName() == null) {
				foundCloneCase = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.EntryRelationship", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.EntryRelationship", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName().equals("typeCode")) {
				foundFixedCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("REFR", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(foundFixedCase);
	}
	
	@Test
	public void shouldNarrowChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundClonedObservation = false;
		boolean foundClonedRelationship = false;
		boolean foundClonedChoiceBlock = false;
		boolean foundCardinalityConstraint = false;
		int constraints = 0;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName() == null) {
				foundClonedObservation = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				foundCardinalityConstraint = true;
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName() == null) {
				foundClonedRelationship = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.EntryRelationship", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.EntryRelationship", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName().equals("EntryRelationship_11")) {
				Constraint associationConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationConstraint);
				assertEquals("PregnancyObservation.EntryRelationship_11", ((AssociationTypeConstraint) associationConstraint).getNewValue());
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship_11") && delta.getRelationshipName() == null && delta.getDeltaChangeType() == DeltaChangeType.CLONE) {
				foundClonedChoiceBlock = true;
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship_11") && delta.getRelationshipName() == null && delta.getDeltaChangeType() == DeltaChangeType.CHOICE) {
				
				Constraint addChoiceConstraint = delta.getConstraint(ConstraintChangeType.ADD_CHOICE);
				assertNotNull(addChoiceConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((AddChoiceConstraint)addChoiceConstraint).getChoiceClassName());
				
				for (Constraint constraint : delta.getAllConstraints(ConstraintChangeType.REMOVE_CHOICE)) {
					assertTrue(((RemoveChoiceConstraint) constraint).getChoiceClassName().startsWith("POCD_MT000040."));
					constraints++;
				}
				
			}
		}
		assertTrue(foundClonedObservation);
		assertTrue(foundClonedRelationship);
		assertTrue(foundClonedChoiceBlock);
		assertTrue(foundCardinalityConstraint);
		assertEquals(9, constraints);
		
		assertEquals(1, template.getTemplateReferences().size());
		assertEquals("PregnancyObservation.EntryRelationship.observation", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.15.3.1", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getMaxInstances());
	}
	
	@Test
	public void shouldNotNarrowChoicesForOpenTemplateWithUnlimitedCardinality() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProceduresSectionentriesRequired.Section") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProceduresSectionentriesRequired.Section", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Section", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}

			if (delta.getClassName().equals("ProceduresSectionentriesRequired.SectionEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProceduresSectionentriesRequired.SectionEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("POCD_MT000040.Entry") && delta.getRelationshipName().equals("Entry_7")) {
				assertEquals(0, delta.getConstraints().size());
			}
		}
		
		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("ProceduresSectionentriesRequired.Entry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getMaxInstances());
		assertEquals("ProceduresSectionentriesRequired.Entry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(1).getMaxInstances());
		assertEquals("ProceduresSectionentriesRequired.Entry.act", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.12", template.getTemplateReferences().get(2).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(2).getMaxInstances());
	}
	
	@Test
	public void shouldManageCardinalityForComplexChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProceduresSectionentriesOptional.Section") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProceduresSectionentriesOptional.Section", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Section", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("ProceduresSectionentriesOptional.SectionEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProceduresSectionentriesOptional.SectionEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.SectionEntry") && delta.getRelationshipName().equals("Entry_7")) {
				assertEquals(0, delta.getConstraints().size());
			}
		}
		
		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("ProceduresSectionentriesOptional.Entry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getMaxInstances());
		assertEquals("ProceduresSectionentriesOptional.Entry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(1, template.getTemplateReferences().get(1).getMaxInstances());
		assertEquals("ProceduresSectionentriesOptional.Entry.act", template.getTemplateReferences().get(2).getContext());
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
			if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("negationInd")) {
				foundStructuralAttributeCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("realmCode")) {
				foundNonstructuralAttributeCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("subject")) {
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
	
	@Test
	public void shouldHandleNightmareCases() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean cardinalityconstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("MedicationActivity.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("effectiveTime")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				cardinalityconstraintFound = true;
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(2, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(cardinalityconstraintFound);
		
		// Add more hairy assertions as we determine how much of this edge case needs to be handled
	}
	
	
	@Test
	public void shouldHandleDatatypeConstraintWithEscapedCharacters() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean setConstraintFound = false;
		boolean rtoConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("MedicationActivity.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("approachSiteCode")) {
				Constraint setConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(setConstraint);
				setConstraintFound = true;
				// The escaped characters in the template should in fact be stripped out, because the cardinality is 0..1
				assertEquals("CD", ((DatatypeConstraint) setConstraint).getNewValue());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("maxDoseQuantity")) {
				Constraint rtoConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(rtoConstraint);
				rtoConstraintFound = true;
				assertEquals("RTO<PQ, PQ>", ((DatatypeConstraint) rtoConstraint).getNewValue());
			}
		}
		assertTrue(setConstraintFound);
		assertTrue(rtoConstraintFound);
	}
	
	@Test
	public void shouldHandleRemovingRelationshipByZeroingCardinality() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.2");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean cardinalityConstraintFound = false;
		boolean conformanceConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ResultObservation.ObservationRange") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ResultObservation.ObservationRange", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.ObservationRange", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ResultObservation.ObservationRange") && delta.getRelationshipName().equals("code")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				cardinalityConstraintFound = true;
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());

				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				conformanceConstraintFound = true;
				assertEquals(ConformanceLevel.NOT_ALLOWED, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			}

		}
		assertTrue(cardinalityConstraintFound);
		assertTrue(conformanceConstraintFound);
	}
	
	@Test
	public void shouldBindValueSets() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean confidentialityConstraintFound = false;
		boolean languageConstraintFound = false;
		boolean maritalStatusConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.ClinicalDocument", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("confidentialityCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				confidentialityConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("HL7BasicConfidentialityKind", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("languageCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				languageConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("Language", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
				
			}
			
			if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.Patient", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName().equals("maritalStatusCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				maritalStatusConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("MaritalStatus", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
				
			}
		}
		assertTrue(confidentialityConstraintFound);
		assertTrue(languageConstraintFound);
		assertTrue(maritalStatusConstraintFound);

		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.39");
		assertNotNull(template);
		deltas = template.getDeltas();
		
		boolean moodConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PlanOfCareActivityAct.Act") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PlanOfCareActivityAct.Act", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Act", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PlanOfCareActivityAct.Act") && delta.getRelationshipName().equals("moodCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				moodConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("PlanOfCareMoodCodeActEncounterProcedure", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

			}
		}
		assertTrue(moodConstraintFound);

		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		deltas = template.getDeltas();
		
		boolean approachSiteConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("approachSiteCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				approachSiteConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("BodySite", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

			}
		}
		assertTrue(approachSiteConstraintFound);

	}
	
	@Test
	public void shouldBindCodeSystems() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean codeConstraintFound = false;
		boolean codeSystemConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("code")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				codeConstraintFound = true;
				assertEquals("11778-8", ((FixedConstraint) fixedConstraint).getNewValue());

				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				codeSystemConstraintFound = true;
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("LOINC", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("code.code")) {
				fail("should not have inner constraint - is fixed value binding");
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("code.codeSystem")) {
				fail("should not have inner constraint - is vocabulary domain binding");
			}
		}
		assertTrue(codeConstraintFound);
		assertTrue(codeSystemConstraintFound);
		
		codeConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName() == null) {
				// already asserted this stuff above
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("statusCode")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				codeConstraintFound = true;
				assertEquals("completed", ((FixedConstraint) fixedConstraint).getNewValue());
				
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNull(bindingConstraint);
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("statusCode.code")) {
				fail("should not have inner constraint - is fixed value binding");
			}
		}
		assertTrue(codeConstraintFound);

		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		deltas = template.getDeltas();
		
		codeSystemConstraintFound = false;
		for (Delta delta : deltas) {
			
			if (delta.getClassName().equals("USRealmHeader.Performer1") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.Performer1", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Performer1", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.Performer1") && delta.getRelationshipName().equals("typeCode")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNull(fixedConstraint);
				
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				codeSystemConstraintFound = true;
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("HL7ParticipationType", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			}
		}
		assertTrue(codeSystemConstraintFound);
		
		
	}

	@Test
	public void shouldCaptureSchematronTests() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean effectiveTimeConstraintFound = false;
		boolean setIdConstraintFound = false;
		boolean birthTimeConstraintsFound = false;
		boolean authorConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.ClinicalDocument", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("effectiveTime")) {
				Constraint schematronConstraint = delta.getConstraint(ConstraintChangeType.SCHEMATRON);
				assertNotNull(schematronConstraint);
				effectiveTimeConstraintFound = true;
				assertEquals("string-length(cda:effectiveTime//@value)>=8", ((SchematronConstraint) schematronConstraint).getTest());
			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("setId")) {
				Constraint schematronConstraint = delta.getConstraint(ConstraintChangeType.SCHEMATRON);
				assertNotNull(schematronConstraint);
				setIdConstraintFound = true;
				assertEquals("count(../cda:versionNumber |../cda:setId)=2 or count(../cda:versionNumber | ../cda:setId)=0", ((SchematronConstraint) schematronConstraint).getTest());
			}
			
			if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.Patient", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName().equals("birthTime")) {
				List<Constraint> schematronConstraints = delta.getAllConstraints(ConstraintChangeType.SCHEMATRON);
				assertNotNull(schematronConstraints);
				assertEquals(2, schematronConstraints.size());
				birthTimeConstraintsFound = true;
				assertEquals("string-length(cda:recordTarget/cda:patientRole/cda:patient/cda:birthTime/@value) >= 4", ((SchematronConstraint) schematronConstraints.get(0)).getTest());
				assertFalse(((SchematronConstraint) schematronConstraints.get(0)).isWarning());
				assertEquals("string-length(cda:recordTarget/cda:patientRole/cda:patient/cda:birthTime/@value) >= 8", ((SchematronConstraint) schematronConstraints.get(1)).getTest());
				assertTrue(((SchematronConstraint) schematronConstraints.get(1)).isWarning());
			}
			
			if (delta.getClassName().equals("USRealmHeader.Author") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("USRealmHeader.Author", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Author", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.Author") && delta.getRelationshipName().equals("assignedAuthor")) {
				Constraint schematronConstraint = delta.getConstraint(ConstraintChangeType.SCHEMATRON);
				assertNotNull(schematronConstraint);
				authorConstraintFound = true;
				assertEquals("count(cda:author/cda:assignedAuthor/cda:assignedPerson)=1 or count(cda:author/cda:assignedAuthor/cda:assignedAuthoringDevice)=1", ((SchematronConstraint) schematronConstraint).getTest());
			}
		}
		assertTrue(effectiveTimeConstraintFound);
		assertTrue(setIdConstraintFound);
		assertTrue(birthTimeConstraintsFound);
		assertTrue(authorConstraintFound);
	}
	
	@Test
	public void shouldDuplicateConstraintsFromAncestorTemplate() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.9");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean realmConstraintFound = false;
		boolean codeConstraintFound = false;
		boolean recordTargetConstraintFound = false;
		boolean documentationConstraintFound = false;
		boolean patientConstraintsFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProgressNote.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProgressNote.ClinicalDocument", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProgressNote.ClinicalDocument") && delta.getRelationshipName().equals("realmCode")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(constraint);
				realmConstraintFound = true;
				assertEquals("US", ((FixedConstraint) constraint).getNewValue());
			} else if (delta.getClassName().equals("ProgressNote.ClinicalDocument") && delta.getRelationshipName().equals("code")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(constraint);
				codeConstraintFound = true;
				assertEquals("ProgressNoteDocumentTypeCode", ((VocabularyBindingConstraint) constraint).getNewDomainType());
			} else if (delta.getClassName().equals("ProgressNote.ClinicalDocument") && delta.getRelationshipName().equals("recordTarget")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				recordTargetConstraintFound = true;
				assertEquals("ProgressNote.RecordTarget", ((AssociationTypeConstraint) constraint).getNewValue());
			} else if (delta.getClassName().equals("ProgressNote.ClinicalDocument") && delta.getRelationshipName().equals("documentationOf")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				documentationConstraintFound = true;
				assertEquals("ProgressNote.DocumentationOf", ((AssociationTypeConstraint) constraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProgressNote.Patient") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ProgressNote.Patient", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("POCD_MT000040.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProgressNote.Patient") && delta.getRelationshipName().equals("birthTime")) {
				List<Constraint> schematronConstraints = delta.getAllConstraints(ConstraintChangeType.SCHEMATRON);
				assertNotNull(schematronConstraints);
				assertEquals(2, schematronConstraints.size());
				patientConstraintsFound = true;
				assertEquals("string-length(cda:recordTarget/cda:patientRole/cda:patient/cda:birthTime/@value) >= 4", ((SchematronConstraint) schematronConstraints.get(0)).getTest());
				assertFalse(((SchematronConstraint) schematronConstraints.get(0)).isWarning());
				assertEquals("string-length(cda:recordTarget/cda:patientRole/cda:patient/cda:birthTime/@value) >= 8", ((SchematronConstraint) schematronConstraints.get(1)).getTest());
				assertTrue(((SchematronConstraint) schematronConstraints.get(1)).isWarning());
			}
		}
		assertTrue(realmConstraintFound);
		assertTrue(codeConstraintFound);
		assertTrue(recordTargetConstraintFound);
		assertTrue(documentationConstraintFound);
		assertTrue(patientConstraintsFound);
	}
	
	@Test
	public void shouldHandleDeepConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.9");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean locationDeltaFound = false;
		boolean healthCareFacilityDeltaFound = false;
		boolean idConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProgressNote.EncompassingEncounter") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ProgressNote.EncompassingEncounter") && delta.getRelationshipName().equals("location")) {
				locationDeltaFound = true;
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				assertEquals("ProgressNote.Location", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			if (delta.getClassName().equals("ProgressNote.Location") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ProgressNote.Location") && delta.getRelationshipName().equals("healthCareFacility")) {
				healthCareFacilityDeltaFound = true;
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				assertEquals("ProgressNote.HealthCareFacility", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			if (delta.getClassName().equals("ProgressNote.HealthCareFacility") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ProgressNote.HealthCareFacility") && delta.getRelationshipName().equals("id")) {
				idConstraintFound = true;
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
		}
		assertTrue(locationDeltaFound);
		assertTrue(healthCareFacilityDeltaFound);
		assertTrue(idConstraintFound);
	}
}
