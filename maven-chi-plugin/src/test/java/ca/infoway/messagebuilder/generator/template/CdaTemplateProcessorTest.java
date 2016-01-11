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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.cda.CdaXsdProcessor;
import ca.infoway.messagebuilder.generator.cda.Schema;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.AddConstraint;
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

@RunWith(MockitoJUnitRunner.class)
public class CdaTemplateProcessorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet messageSet = new MessageSet();
	private static TemplateSet templateSet = new TemplateSet();
	
	@BeforeClass
	public static void setUp() throws Exception {
		OutputUI outputUI = Mockito.mock(OutputUI.class);
		
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040_SDTC.xsd"));
		Schema supplementalSchema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/SDTC.xsd"));
		
		new CdaXsdProcessor(outputUI).processSchema(schema, supplementalSchema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/Consolidation.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc.xml"));
		
		new CdaTemplateProcessor(valueSetDefinition, outputUI).parseTemplate(templateExport, messageSet, templateSet);
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("templateId")) {
				foundCardinalityCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNull(dataTypeConstraint);
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
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.POPULATED, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(foundCardinalityCase);
		assertTrue(foundFixedValueCase);
		assertTrue(foundDataTypeCase);
	}

	@Test
	public void shouldPromoteFixedValueFieldsToMandatory() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.31");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundConformanceCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("AgeObservation.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("AgeObservation.Observation") && delta.getRelationshipName().equals("code")) {
				foundConformanceCase = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
				
			}
		}
		assertTrue(foundConformanceCase);
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("Snomed_CT", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			}
		}
		assertTrue(foundFixedCase);
		assertTrue(foundTypeCase);
	}

	@Test
	@Ignore	// The only case that exercised this pattern has been excluded. Leaving the code in place so that it can be rewritten if a new case comes up.
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
	public void shouldParseFixedValuesForBoolean() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundFixedCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.InstructionsEntryRelationship") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("MedicationActivity.InstructionsEntryRelationship") && delta.getRelationshipName().equals("inversionInd")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				foundFixedCase = true;
				assertEquals("true", ((FixedConstraint) fixedConstraint).getNewValue());
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
				assertEquals("HealthcareProviderTaxonomy", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				
				assertTrue(delta instanceof AssociationDelta);
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				foundCardinalityCase = true;
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint typeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(typeConstraint);
				foundTypeCase = true;
				assertEquals("BaseModel.EntryRelationship", ((AssociationTypeConstraint) typeConstraint).getOriginalValue());
				assertEquals("PregnancyObservation.EntryRelationshipChoice", ((AssociationTypeConstraint) typeConstraint).getNewValue());
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
				assertEquals("BaseModel.ManufacturedProduct", ((AssociationTypeConstraint) typeConstraint).getOriginalValue());
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("SOPInstanceObservation.Observation") && delta.getRelationshipName().equals("code.codeSystem")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				codeSystemConstraintFound = true;
				assertEquals("1.2.840.10008.2.6.1", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(foundCloneCase);
		assertTrue(codeSystemConstraintFound);
		
		template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.2");
		assertNotNull(template);
		deltas = template.getDeltas();
		
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.CustodianOrganization") && delta.getRelationshipName() != null && delta.getRelationshipName().equals("id.root")) {
				fail("Did not expect a constrained datatype here");
			}
		}
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
				assertEquals("BaseModel.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.EntryRelationship", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
	public void shouldRemoveChoiceForSingleOptionCase() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.15.3.8");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundClonedObservation = false;
		boolean foundClonedRelationship = false;
		boolean foundRemovedChoiceBlock = false;
		boolean foundCardinalityConstraint = false;
		boolean foundNewAssociationConstraint = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName() == null) {
				foundClonedObservation = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.Observation", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				foundCardinalityConstraint = true;
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName() == null) {
				foundClonedRelationship = true;
				
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("PregnancyObservation.EntryRelationship", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.EntryRelationship", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName().equals("entryRelationshipChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				foundRemovedChoiceBlock = true;
			} else if (delta.getClassName().equals("PregnancyObservation.EntryRelationship") && delta.getRelationshipName().equals("observation")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				foundNewAssociationConstraint = true;
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint)cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint)cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				assertEquals("EstimatedDateOfDelivery.Observation", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
		}
		assertTrue(foundClonedObservation);
		assertTrue(foundClonedRelationship);
		assertTrue(foundCardinalityConstraint);
		assertTrue(foundRemovedChoiceBlock);
		assertTrue(foundNewAssociationConstraint);
		
		assertEquals(1, template.getTemplateReferences().size());
		assertEquals("PregnancyObservation.EntryRelationship.observation", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.15.3.1", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
	}
	
	@Test
	public void shouldHandleComplexChoicesForOpenTemplate() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean sectionAssociationConstraintFound = false;
		boolean choiceBlockCreateConstraintFound = false;
		boolean procedureEntryCloneConstraintFound = false;
		boolean procedureEntryRemoveChoiceConstraintFound = false;
		boolean procedureEntryAssociationConstraintFound = false;
		boolean observationEntryCloneConstraintFound = false;
		boolean observationEntryRemoveChoiceConstraintFound = false;
		boolean observationEntryAssociationConstraintFound = false;
		boolean actEntryCloneConstraintFound = false;
		boolean actEntryRemoveChoiceConstraintFound = false;
		boolean actEntryAssociationConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProceduresSectionentriesRequired.Section") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				sectionAssociationConstraintFound = true;
				assertEquals("ProceduresSectionentriesRequired.EntryChoice", ((AssociationTypeConstraint) associationTypeConstraint).getNewValue());
			}

			if (delta.getClassName().equals("ProceduresSectionentriesRequired.EntryChoice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint addConstraint = delta.getConstraint(ConstraintChangeType.ADD);
				assertNotNull(addConstraint);
				choiceBlockCreateConstraintFound = true;
				assertTrue(((AddConstraint) addConstraint).getIsAbstract());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(4, addChoiceConstraints.size());
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertFalse(((AddChoiceConstraint)addChoiceConstraints.get(0)).isDefault());
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertFalse(((AddChoiceConstraint)addChoiceConstraints.get(1)).isDefault());
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityActEntry", ((AddChoiceConstraint)addChoiceConstraints.get(2)).getChoiceClassName());
				assertFalse(((AddChoiceConstraint)addChoiceConstraints.get(2)).isDefault());
				assertEquals("BaseModel.Entry", ((AddChoiceConstraint)addChoiceConstraints.get(3)).getChoiceClassName());
				assertTrue(((AddChoiceConstraint)addChoiceConstraints.get(3)).isDefault());
			}

			if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				procedureEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				procedureEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry") && delta.getRelationshipName().equals("procedure")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				procedureEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityProcedure.Procedure", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				observationEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				observationEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry") && delta.getRelationshipName().equals("observation")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				observationEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityObservation.Observation", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityActEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				actEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesRequired.ProcedureActivityActEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityActEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				actEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesRequired.ProcedureActivityActEntry") && delta.getRelationshipName().equals("act")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				actEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityAct.Act", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
		}

		assertTrue(sectionAssociationConstraintFound);
		assertTrue(choiceBlockCreateConstraintFound);
		assertTrue(procedureEntryCloneConstraintFound);
		assertTrue(procedureEntryRemoveChoiceConstraintFound);
		assertTrue(procedureEntryAssociationConstraintFound);
		assertTrue(observationEntryCloneConstraintFound);
		assertTrue(observationEntryRemoveChoiceConstraintFound);
		assertTrue(observationEntryAssociationConstraintFound);
		assertTrue(actEntryCloneConstraintFound);
		assertTrue(actEntryRemoveChoiceConstraintFound);
		assertTrue(actEntryAssociationConstraintFound);

		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("ProceduresSectionentriesRequired.ProcedureActivityProcedureEntry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
		assertEquals("ProceduresSectionentriesRequired.ProcedureActivityObservationEntry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(1).getCardinality().getMax().intValue());
		assertEquals("ProceduresSectionentriesRequired.ProcedureActivityActEntry.act", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.12", template.getTemplateReferences().get(2).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(2).getCardinality().getMax().intValue());
	}
	
	@Test
	public void shouldManageCardinalityForComplexChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.7");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean sectionAssociationConstraintFound = false;
		boolean choiceBlockCreateConstraintFound = false;
		boolean procedureEntryCloneConstraintFound = false;
		boolean procedureEntryRemoveChoiceConstraintFound = false;
		boolean procedureEntryAssociationConstraintFound = false;
		boolean observationEntryCloneConstraintFound = false;
		boolean observationEntryRemoveChoiceConstraintFound = false;
		boolean observationEntryAssociationConstraintFound = false;
		boolean actEntryCloneConstraintFound = false;
		boolean actEntryRemoveChoiceConstraintFound = false;
		boolean actEntryAssociationConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProceduresSectionentriesOptional.Section") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.Section") && delta.getRelationshipName().equals("entry")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(0, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				sectionAssociationConstraintFound = true;
				assertEquals("ProceduresSectionentriesOptional.EntryChoice", ((AssociationTypeConstraint) associationTypeConstraint).getNewValue());
			}

			if (delta.getClassName().equals("ProceduresSectionentriesOptional.EntryChoice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint addConstraint = delta.getConstraint(ConstraintChangeType.ADD);
				assertNotNull(addConstraint);
				choiceBlockCreateConstraintFound = true;
				assertTrue(((AddConstraint) addConstraint).getIsAbstract());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(4, addChoiceConstraints.size());
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityActEntry", ((AddChoiceConstraint)addChoiceConstraints.get(2)).getChoiceClassName());
				assertEquals("BaseModel.Entry", ((AddChoiceConstraint)addChoiceConstraints.get(3)).getChoiceClassName());
			}

			if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				procedureEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				procedureEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry") && delta.getRelationshipName().equals("procedure")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				procedureEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityProcedure.Procedure", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				observationEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				observationEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry") && delta.getRelationshipName().equals("observation")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				observationEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityObservation.Observation", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityActEntry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				actEntryCloneConstraintFound = true;
				assertEquals("ProceduresSectionentriesOptional.ProcedureActivityActEntry", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Entry", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityActEntry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				actEntryRemoveChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ProceduresSectionentriesOptional.ProcedureActivityActEntry") && delta.getRelationshipName().equals("act")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				actEntryAssociationConstraintFound = true;
				assertEquals("ProcedureActivityAct.Act", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
		}

		assertTrue(sectionAssociationConstraintFound);
		assertTrue(choiceBlockCreateConstraintFound);
		assertTrue(procedureEntryCloneConstraintFound);
		assertTrue(procedureEntryRemoveChoiceConstraintFound);
		assertTrue(procedureEntryAssociationConstraintFound);
		assertTrue(observationEntryCloneConstraintFound);
		assertTrue(observationEntryRemoveChoiceConstraintFound);
		assertTrue(observationEntryAssociationConstraintFound);
		assertTrue(actEntryCloneConstraintFound);
		assertTrue(actEntryRemoveChoiceConstraintFound);
		assertTrue(actEntryAssociationConstraintFound);
		
		assertEquals(3, template.getTemplateReferences().size());
		assertEquals("ProceduresSectionentriesOptional.ProcedureActivityProcedureEntry.procedure", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.14", template.getTemplateReferences().get(0).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
		assertEquals("ProceduresSectionentriesOptional.ProcedureActivityObservationEntry.observation", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.13", template.getTemplateReferences().get(1).getOid());
		assertEquals(1, template.getTemplateReferences().get(1).getCardinality().getMax().intValue());
		assertEquals("ProceduresSectionentriesOptional.ProcedureActivityActEntry.act", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.12", template.getTemplateReferences().get(2).getOid());
		assertEquals(1, template.getTemplateReferences().get(2).getCardinality().getMax().intValue());
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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("negationInd")) {
				foundStructuralAttributeCase = true;
				
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(constraint);
			} else if (delta.getClassName().equals("EstimatedDateOfDelivery.Observation") && delta.getRelationshipName().equals("id")) {
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
				assertEquals("BaseModel.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("effectiveTime")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				cardinalityconstraintFound = true;
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(cardinalityconstraintFound);
		
		// Add more hairy assertions as we determine how much of this edge case needs to be handled
	}
	
	
	@Test
	public void shouldHandleDatatypeConstraintWithEscapedCharacters() throws Exception {
		// vestigal test - there are no cases in the given templates where the constraint specifies a datatype with escaped characters and those characters make it into the delta set
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean setConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("MedicationActivity.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.SubstanceAdministration", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("approachSiteCode")) {
				Constraint setConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNotNull(setConstraint);
				setConstraintFound = true;
				// The escaped characters in the template should in fact be stripped out, because the cardinality is 0..1
				assertEquals("CD", ((DatatypeConstraint) setConstraint).getNewValue());
			}
		}
		assertTrue(setConstraintFound);
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
				assertEquals("BaseModel.ObservationRange", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.ClinicalDocument") && delta.getRelationshipName().equals("confidentialityCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				confidentialityConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("BasicConfidentialityKind", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

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
				assertEquals("BaseModel.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.Act", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PlanOfCareActivityAct.Act") && delta.getRelationshipName().equals("moodCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				moodConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("PlanOfCareEncounterMoodCode", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

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
				assertEquals("BaseModel.Observation", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertNotNull(bindingConstraint);
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint)bindingConstraint).getNewDomainSource());
				assertEquals("ActStatus", ((VocabularyBindingConstraint)bindingConstraint).getNewDomainType());
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
				assertEquals("BaseModel.Performer1", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("USRealmHeader.Performer1") && delta.getRelationshipName().equals("typeCode")) {
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNull(fixedConstraint);
				
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				codeSystemConstraintFound = true;
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("ParticipationType", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
			}
		}
		assertTrue(codeSystemConstraintFound);
		
		
	}

	@Test
	public void shouldHandlePrefixInVocabularyOids() throws Exception {
		OutputUI outputUI = Mockito.mock(OutputUI.class);
		
		TemplateSet localTemplateSet = new TemplateSet();
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/template_ab.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc_ab.xml"));
		
		new CdaTemplateProcessor(valueSetDefinition, outputUI).parseTemplate(templateExport, messageSet, localTemplateSet);
		
		Template template = localTemplateSet.getByOid("2.16.840.1.113883.3.163.10.2.2");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean codeConstraintFound = false;
		boolean confidentialityConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("CAABTranscribedReports.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("CAABTranscribedReports.ClinicalDocument", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("CAABTranscribedReports.ClinicalDocument") && delta.getRelationshipName().equals("code")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				codeConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("AlbertaTranscribedReportType", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());

			} else if (delta.getClassName().equals("CAABTranscribedReports.ClinicalDocument") && delta.getRelationshipName().equals("confidentialityCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				confidentialityConstraintFound = true;
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("ConfidentialityCode", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
				
			}
		}
		assertTrue(codeConstraintFound);
		assertTrue(confidentialityConstraintFound);
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
				assertEquals("BaseModel.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.Author", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.ClinicalDocument", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
				assertEquals("BaseModel.Patient", ((CloneConstraint) cloneConstraint).getOriginalClassName());
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
	
	@Test
	public void shouldHandleChildrenOfDeepConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.10");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean assignedAuthorConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("UnstructuredDocument.AssignedAuthor") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("UnstructuredDocument.AssignedAuthor") && delta.getRelationshipName().equals("addr")) {
				assignedAuthorConstraintFound = true;
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(assignedAuthorConstraintFound);
	}
	
	@Test
	public void shouldParseLocalChoices() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.70");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean rootDeltaFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PressureUlcerObservation.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("PressureUlcerObservation.Observation") && delta.getRelationshipName().equals("code")) {
				rootDeltaFound = true;
				
				Constraint fixedConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(fixedConstraint);
				assertEquals("ASSERTION", ((FixedConstraint) fixedConstraint).getNewValue());
			}
		}
		assertTrue(rootDeltaFound);
	}
	
	
	@Test
	public void shouldParseDivergentLists() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.61");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean cardinalityConstraintFound = false;
		boolean choiceBlockFound = false;
		boolean payerPerformerFound = false;
		boolean payerPerformerTimeRemoved = false;
		boolean guarantorPerformerFound = false;
		boolean payerEntityFound = false;
		boolean payerEntityPersonRemoved = false;
		boolean guarantorEntityFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PolicyActivity.Act") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("PolicyActivity.Act") && delta.getRelationshipName().equals("performer")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(constraint);
				
				cardinalityConstraintFound = true;
				
				assertEquals(1, ((CardinalityConstraint)constraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint)constraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("PolicyActivity.Performer2Choice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				List<Constraint> constraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(3, constraints.size());
				assertEquals("PolicyActivity.PayerPerformerPerformer2", ((AddChoiceConstraint)constraints.get(0)).getChoiceClassName());
				assertEquals("PolicyActivity.GuarantorPerformerPerformer2", ((AddChoiceConstraint)constraints.get(1)).getChoiceClassName());
				assertEquals("BaseModel.Performer2", ((AddChoiceConstraint)constraints.get(2)).getChoiceClassName());
				choiceBlockFound = true;
			}
			
			if (delta.getClassName().equals("PolicyActivity.PayerPerformerPerformer2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.Performer2", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PolicyActivity.PayerPerformerPerformer2") && delta.getRelationshipName().equals("time")) {
				assertNotNull(delta.getConstraint(ConstraintChangeType.REMOVE));
				payerPerformerTimeRemoved = true;
			} else if (delta.getClassName().equals("PolicyActivity.PayerPerformerPerformer2") && delta.getRelationshipName().equals("assignedEntity")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				assertEquals("PolicyActivity.PayerPerformerAssignedEntity", ((AssociationTypeConstraint)constraint).getNewValue());
				payerPerformerFound = true;
			}
			
			if (delta.getClassName().equals("PolicyActivity.GuarantorPerformerPerformer2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.Performer2", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PolicyActivity.GuarantorPerformerPerformer2") && delta.getRelationshipName().equals("assignedEntity")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				assertEquals("PolicyActivity.GuarantorPerformerAssignedEntity", ((AssociationTypeConstraint)constraint).getNewValue());
				guarantorPerformerFound = true;
			}
			
			if (delta.getClassName().equals("PolicyActivity.PayerPerformerAssignedEntity") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.AssignedEntity", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PolicyActivity.PayerPerformerAssignedEntity") && delta.getRelationshipName().equals("assignedPerson")) {
				assertNotNull(delta.getConstraint(ConstraintChangeType.REMOVE));
				payerEntityPersonRemoved = true;
			} else if (delta.getClassName().equals("PolicyActivity.PayerPerformerAssignedEntity") && delta.getRelationshipName().equals("code")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(constraint);
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint)constraint).getNewDomainSource());
				assertEquals("FinanciallyResponsiblePartyType", ((VocabularyBindingConstraint)constraint).getNewDomainType());
				
				assertNull(delta.getConstraint(ConstraintChangeType.CHANGE_FIXED));
				payerEntityFound = true;
			}
			
			if (delta.getClassName().equals("PolicyActivity.GuarantorPerformerAssignedEntity") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.AssignedEntity", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PolicyActivity.GuarantorPerformerAssignedEntity") && delta.getRelationshipName().equals("code")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_FIXED);
				assertNotNull(constraint);
				assertEquals("GUAR", ((FixedConstraint)constraint).getNewValue());
				
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				assertEquals(DomainSource.CODE_SYSTEM, ((VocabularyBindingConstraint)bindingConstraint).getNewDomainSource());
				assertEquals("RoleClass", ((VocabularyBindingConstraint)bindingConstraint).getNewDomainType());
				guarantorEntityFound = true;
			}
		}
		assertTrue(cardinalityConstraintFound);
		assertTrue(choiceBlockFound);
		assertTrue(payerPerformerFound);
		assertTrue(payerPerformerTimeRemoved);
		assertTrue(guarantorPerformerFound);
		assertTrue(payerEntityFound);
		assertTrue(payerEntityPersonRemoved);
		assertTrue(guarantorEntityFound);
	}

	
	@Test
	public void shouldParseDivergentListsWithoutTemplateIds() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.70");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean cardinalityConstraintFound = false;
		boolean choiceBlockFound = false;
		boolean lengthRelationshipFound = false;
		boolean widthRelationshipFound = false;
		boolean depthRelationshipFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PressureUlcerObservation.Observation") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("PressureUlcerObservation.Observation") && delta.getRelationshipName().equals("entryRelationship")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(constraint);
				
				cardinalityConstraintFound = true;
				
				assertEquals(0, ((CardinalityConstraint)constraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint)constraint).getNewMaxValue().intValue());
			}
			
			if (delta.getClassName().equals("PressureUlcerObservation.EntryRelationshipChoice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				List<Constraint> constraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(4, constraints.size());
				assertEquals("PressureUlcerObservation.LengthofWoundEntryRelationship", ((AddChoiceConstraint)constraints.get(0)).getChoiceClassName());
				assertEquals("PressureUlcerObservation.WidthofWoundEntryRelationship", ((AddChoiceConstraint)constraints.get(1)).getChoiceClassName());
				assertEquals("PressureUlcerObservation.DepthofWoundEntryRelationship", ((AddChoiceConstraint)constraints.get(2)).getChoiceClassName());
				assertEquals("BaseModel.EntryRelationship", ((AddChoiceConstraint)constraints.get(3)).getChoiceClassName());
				choiceBlockFound = true;
			}
			
			if (delta.getClassName().equals("PressureUlcerObservation.LengthofWoundEntryRelationship") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.EntryRelationship", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PressureUlcerObservation.LengthofWoundEntryRelationship") && delta.getRelationshipName().equals("observation")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				assertEquals("PressureUlcerObservation.LengthofWoundEntryRelationshipObservation", ((AssociationTypeConstraint)constraint).getNewValue());
				lengthRelationshipFound = true;
			}
			
			if (delta.getClassName().equals("PressureUlcerObservation.WidthofWoundEntryRelationship") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.EntryRelationship", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PressureUlcerObservation.WidthofWoundEntryRelationship") && delta.getRelationshipName().equals("observation")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				assertEquals("PressureUlcerObservation.WidthofWoundEntryRelationshipObservation", ((AssociationTypeConstraint)constraint).getNewValue());
				widthRelationshipFound = true;
			}
			
			if (delta.getClassName().equals("PressureUlcerObservation.DepthofWoundEntryRelationship") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				assertEquals("BaseModel.EntryRelationship", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("PressureUlcerObservation.DepthofWoundEntryRelationship") && delta.getRelationshipName().equals("observation")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				assertEquals("PressureUlcerObservation.DepthofWoundEntryRelationshipObservation", ((AssociationTypeConstraint)constraint).getNewValue());
				depthRelationshipFound = true;
			}
			
		}
		assertTrue (cardinalityConstraintFound);
		assertTrue (choiceBlockFound);
		assertTrue(lengthRelationshipFound);
		assertTrue(widthRelationshipFound);
		assertTrue(depthRelationshipFound);
	}
	
	@Test
	public void shouldParseDivergentListsTypeCodeDisambiguation() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.48");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean choiceBlockFound = false;
		boolean verifierCloneFound = false;
		boolean verifierRoleFound = false;
		boolean custodianCloneFound = false;
		boolean custodianRoleFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("AdvanceDirectiveObservation.Participant2Choice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				List<Constraint> constraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(3, constraints.size());
				assertEquals("AdvanceDirectiveObservation.VerifierParticipant2", ((AddChoiceConstraint)constraints.get(0)).getChoiceClassName());
				assertEquals("AdvanceDirectiveObservation.CustodianParticipant2", ((AddChoiceConstraint)constraints.get(1)).getChoiceClassName());
				assertEquals("BaseModel.Participant2", ((AddChoiceConstraint)constraints.get(2)).getChoiceClassName());
				choiceBlockFound = true;
			}
			
			if (delta.getClassName().equals("AdvanceDirectiveObservation.VerifierParticipant2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				verifierCloneFound = true;
				assertEquals("BaseModel.Participant2", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("AdvanceDirectiveObservation.VerifierParticipant2") && delta.getRelationshipName().equals("participantRole")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				verifierRoleFound = true;
				assertEquals("AdvanceDirectiveObservation.VerifierParticipantRole", ((AssociationTypeConstraint)constraint).getNewValue());
			}
			
			if (delta.getClassName().equals("AdvanceDirectiveObservation.CustodianParticipant2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(constraint);
				custodianCloneFound = true;
				assertEquals("BaseModel.Participant2", ((CloneConstraint)constraint).getOriginalClassName());
			} else if (delta.getClassName().equals("AdvanceDirectiveObservation.CustodianParticipant2") && delta.getRelationshipName().equals("participantRole")) {
				Constraint constraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(constraint);
				custodianRoleFound = true;
				assertEquals("AdvanceDirectiveObservation.CustodianParticipantRole", ((AssociationTypeConstraint)constraint).getNewValue());
			}
		}
		assertTrue(choiceBlockFound);
		assertTrue(verifierCloneFound);
		assertTrue(verifierRoleFound);
		assertTrue(custodianCloneFound);
		assertTrue(custodianRoleFound);
	}
	
	@Test
	public void shouldParseContextlessExternalReferenceConstraints() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.9");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean component2CloneFound = false;
		boolean component2ChoiceAssociationConstraintFound = false;
		boolean structuredBodyCloneFound = false;
		boolean componentAssociationConstraintFound = false;
		boolean choiceBlockCreateConstraintFound = false;
		boolean objectiveSectionCloneConstraintFound = false;
		boolean objectiveSectionAssociationConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ProgressNote.Component2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				component2CloneFound = true;
			} else if (delta.getClassName().equals("ProgressNote.Component2") && delta.getRelationshipName().equals("component2Choice")) {
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				component2ChoiceAssociationConstraintFound = true;
				assertEquals("BaseModel.Component2Choice", ((AssociationTypeConstraint) associationTypeConstraint).getOriginalValue());
				assertEquals("ProgressNote.Component2Choice", ((AssociationTypeConstraint) associationTypeConstraint).getNewValue());
			}

			if (delta.getClassName().equals("ProgressNote.StructuredBody") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				structuredBodyCloneFound = true;
			} else if (delta.getClassName().equals("ProgressNote.StructuredBody") && delta.getRelationshipName().equals("component")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				componentAssociationConstraintFound = true;
				assertEquals("ProgressNote.Component3Choice", ((AssociationTypeConstraint) associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ProgressNote.Component3Choice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint addConstraint = delta.getConstraint(ConstraintChangeType.ADD);
				assertNotNull(addConstraint);
				choiceBlockCreateConstraintFound = true;
				assertTrue(((AddConstraint) addConstraint).getIsAbstract());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(21, addChoiceConstraints.size());
				assertEquals("ProgressNote.ObjectiveSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("ProgressNote.MedicationsSectionentriesOptionalComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertEquals("ProgressNote.MedicationsSectionentriesRequiredComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(2)).getChoiceClassName());
				assertEquals("ProgressNote.ChiefComplaintSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(3)).getChoiceClassName());
				assertEquals("ProgressNote.AllergiesSectionentriesOptionalComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(4)).getChoiceClassName());
				assertEquals("ProgressNote.AllergiesSectionentriesRequiredComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(5)).getChoiceClassName());
				assertEquals("ProgressNote.AssessmentAndPlanSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(6)).getChoiceClassName());
				assertEquals("ProgressNote.PlanOfCareSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(7)).getChoiceClassName());
				assertEquals("ProgressNote.AssessmentSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(8)).getChoiceClassName());
				assertEquals("ProgressNote.InterventionsSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(9)).getChoiceClassName());
				assertEquals("ProgressNote.PhysicalExamSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(10)).getChoiceClassName());
				assertEquals("ProgressNote.ResultsSectionentriesOptionalComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(11)).getChoiceClassName());
				assertEquals("ProgressNote.ResultsSectionentriesRequiredComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(12)).getChoiceClassName());
				assertEquals("ProgressNote.VitalSignsSectionentriesOptionalComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(13)).getChoiceClassName());
				assertEquals("ProgressNote.VitalSignsSectionentriesRequiredComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(14)).getChoiceClassName());
				assertEquals("ProgressNote.ProblemSectionentriesOptionalComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(15)).getChoiceClassName());
				assertEquals("ProgressNote.ProblemSectionentriesRequiredComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(16)).getChoiceClassName());
				assertEquals("ProgressNote.ReviewOfSystemsSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(17)).getChoiceClassName());
				assertEquals("ProgressNote.SubjectiveSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(18)).getChoiceClassName());
				assertEquals("ProgressNote.InstructionsSectionComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(19)).getChoiceClassName());
				assertEquals("BaseModel.Component3", ((AddChoiceConstraint)addChoiceConstraints.get(20)).getChoiceClassName());
			}

			if (delta.getClassName().equals("ProgressNote.ObjectiveSectionComponent3") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				objectiveSectionCloneConstraintFound = true;
				assertEquals("ProgressNote.ObjectiveSectionComponent3", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Component3", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			} else if (delta.getClassName().equals("ProgressNote.ObjectiveSectionComponent3") && delta.getRelationshipName().equals("section")) {
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				objectiveSectionAssociationConstraintFound = true;
				assertEquals("ObjectiveSection.Section", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
		}
		assertTrue(component2CloneFound);
		assertTrue(component2ChoiceAssociationConstraintFound);
		assertTrue(structuredBodyCloneFound);
		assertTrue(componentAssociationConstraintFound);
		assertTrue(choiceBlockCreateConstraintFound);
		assertTrue(objectiveSectionCloneConstraintFound);
		assertTrue(objectiveSectionAssociationConstraintFound);

		assertEquals(20, template.getTemplateReferences().size());
		assertEquals("ProgressNote.ObjectiveSectionComponent3.section", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.21.2.1", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
		assertEquals("ProgressNote.MedicationsSectionentriesOptionalComponent3.section", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.1", template.getTemplateReferences().get(1).getOid());
		assertEquals(1, template.getTemplateReferences().get(1).getCardinality().getMax().intValue());
		assertEquals("ProgressNote.MedicationsSectionentriesRequiredComponent3.section", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.1.1", template.getTemplateReferences().get(2).getOid());
		assertEquals(1, template.getTemplateReferences().get(2).getCardinality().getMax().intValue());
		assertEquals("ProgressNote.ChiefComplaintSectionComponent3.section", template.getTemplateReferences().get(3).getContext());
		assertEquals("1.3.6.1.4.1.19376.1.5.3.1.1.13.2.1", template.getTemplateReferences().get(3).getOid());
		assertEquals(1, template.getTemplateReferences().get(3).getCardinality().getMax().intValue());
	}
	

	@Test
	public void shouldParseContextlessExternalReferenceConstraintsVariableCardinalities() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.3");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean structuredBodyCloneFound = false;
		boolean componentAssociationConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("HistoryAndPhysical.StructuredBody") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				structuredBodyCloneFound = true;
			} else if (delta.getClassName().equals("HistoryAndPhysical.StructuredBody") && delta.getRelationshipName().equals("component")) {
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				componentAssociationConstraintFound = true;
				assertEquals(1, ((CardinalityConstraint) cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(Integer.MAX_VALUE, ((CardinalityConstraint) cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(structuredBodyCloneFound);
		assertTrue(componentAssociationConstraintFound);
		
		assertEquals(28, template.getTemplateReferences().size());
		assertEquals("HistoryAndPhysical.AllergiesSectionentriesOptionalComponent3.section", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.6", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMin().intValue());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
		assertEquals("HistoryAndPhysical.AllergiesSectionentriesRequiredComponent3.section", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.6.1", template.getTemplateReferences().get(1).getOid());
		assertEquals(1, template.getTemplateReferences().get(1).getCardinality().getMin().intValue());
		assertEquals(1, template.getTemplateReferences().get(1).getCardinality().getMax().intValue());
		assertEquals("HistoryAndPhysical.AssessmentSectionComponent3.section", template.getTemplateReferences().get(2).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.8", template.getTemplateReferences().get(2).getOid());
		assertEquals(0, template.getTemplateReferences().get(2).getCardinality().getMin().intValue());
		assertEquals(1, template.getTemplateReferences().get(2).getCardinality().getMax().intValue());
		assertEquals("HistoryAndPhysical.FamilyHistorySectionComponent3.section", template.getTemplateReferences().get(6).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.2.15", template.getTemplateReferences().get(6).getOid());
		assertEquals(1, template.getTemplateReferences().get(6).getCardinality().getMin().intValue());
		assertEquals(1, template.getTemplateReferences().get(6).getCardinality().getMax().intValue());
	}
	
	@Test
	public void shouldParseContextlessExternalReferenceConstraintsComplicationsSpecialCase() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.2.32");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean entryCloneFound = false;
		boolean removeChoiceConstraintFound = false;
		boolean addObservationDeltaFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ComplicationsOpNote.Entry") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				entryCloneFound = true;
			} else if (delta.getClassName().equals("ComplicationsOpNote.Entry") && delta.getRelationshipName().equals("entryChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				Constraint removeConstraint = delta.getConstraint(ConstraintChangeType.REMOVE);
				assertNotNull(removeConstraint);
				removeChoiceConstraintFound = true;
			} else if (delta.getClassName().equals("ComplicationsOpNote.Entry") && delta.getRelationshipName().equals("observation")) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				addObservationDeltaFound = true;

				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				assertEquals("ProblemObservation.Observation", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
				
				Constraint cardinalityConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
				assertNotNull(cardinalityConstraint);
				assertEquals(1, ((CardinalityConstraint)cardinalityConstraint).getNewMinValue().intValue());
				assertEquals(1, ((CardinalityConstraint)cardinalityConstraint).getNewMaxValue().intValue());
			}
		}
		assertTrue(entryCloneFound);
		assertTrue(removeChoiceConstraintFound);
		assertTrue(addObservationDeltaFound);
		
		assertEquals(1, template.getTemplateReferences().size());
		assertEquals("ComplicationsOpNote.Entry.observation", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.22.4.4", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMin().intValue());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
	}
	
	
	@Test
	public void shouldParseContextlessExternalReferenceConstraintsDiagnosticImageCase() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.5");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean choiceBlockCreateConstraintFound = false;
		boolean encounterParticipantConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("DiagnosticImagingReport.Component3Choice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint addConstraint = delta.getConstraint(ConstraintChangeType.ADD);
				assertNotNull(addConstraint);
				choiceBlockCreateConstraintFound = true;
				assertTrue(((AddConstraint) addConstraint).getIsAbstract());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(6, addChoiceConstraints.size());
				assertEquals("DiagnosticImagingReport.ProcedureContextComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("DiagnosticImagingReport.FetusSubjectContextComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertEquals("DiagnosticImagingReport.ObserverContextComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(2)).getChoiceClassName());
				assertEquals("DiagnosticImagingReport.FindingsSectionDIRComponent3", ((AddChoiceConstraint)addChoiceConstraints.get(3)).getChoiceClassName());
				assertEquals("DiagnosticImagingReport.DICOMObjectCatalogSectionDCM121181Component3", ((AddChoiceConstraint)addChoiceConstraints.get(4)).getChoiceClassName());
				assertEquals("BaseModel.Component3", ((AddChoiceConstraint)addChoiceConstraints.get(5)).getChoiceClassName());
			}

			if (delta.getClassName().equals("DiagnosticImagingReport.EncompassingEncounter") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("DiagnosticImagingReport.EncompassingEncounter") && delta.getRelationshipName().equals("encounterParticipant")) {
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				encounterParticipantConstraintFound = true;
				assertEquals("PhysicianOfRecordParticipant.EncounterParticipant", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
		}
		assertTrue(choiceBlockCreateConstraintFound);
		assertTrue(encounterParticipantConstraintFound);

		assertEquals(6, template.getTemplateReferences().size());
		assertEquals("DiagnosticImagingReport.EncompassingEncounter.encounterParticipant", template.getTemplateReferences().get(0).getContext());
		assertEquals("2.16.840.1.113883.10.20.6.2.2", template.getTemplateReferences().get(0).getOid());
		assertEquals(1, template.getTemplateReferences().get(0).getCardinality().getMax().intValue());
		assertEquals("DiagnosticImagingReport.ProcedureContextComponent3.section", template.getTemplateReferences().get(1).getContext());
		assertEquals("2.16.840.1.113883.10.20.6.2.5", template.getTemplateReferences().get(1).getOid());
		assertEquals(Integer.MAX_VALUE, template.getTemplateReferences().get(1).getCardinality().getMax().intValue());
	}
	
	@Test
	public void shouldParseContextlessExternalReferenceConstraintsContinuityOfCareCase() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.2");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean componentAssociationFound = false;
		boolean componentCloneDeltaFound = false;
		boolean componentChoiceAssociationFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.ClinicalDocument") && delta.getRelationshipName().equals("component")) {
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				componentAssociationFound = true;
				assertEquals("ContinuityOfCareDocumentCCD.Component2", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.Component2") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				componentCloneDeltaFound = true;
			} else if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.Component2") && delta.getRelationshipName().equals("component2Choice")) {
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				componentChoiceAssociationFound = true;
				assertEquals("ContinuityOfCareDocumentCCD.Component2Choice", ((AssociationTypeConstraint)associationTypeConstraint).getNewValue());
			}
		}
		assertTrue(componentAssociationFound);
		assertTrue(componentCloneDeltaFound);
		assertTrue(componentChoiceAssociationFound);
	}
	
	@Ignore
	@Test
	public void shouldHandleNamespaces() throws Exception {
		// This attribute has been temporarily excluded from scope
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean raceCodeConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
			} else if (delta.getClassName().equals("USRealmHeader.Patient") && delta.getRelationshipName().equals("sdtc:raceCode")) {
				Constraint bindingConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_VOCABULARY_BINDING);
				assertNotNull(bindingConstraint);
				raceCodeConstraintFound = true;
				assertEquals(DomainSource.VALUE_SET, ((VocabularyBindingConstraint) bindingConstraint).getNewDomainSource());
				assertEquals("Race", ((VocabularyBindingConstraint) bindingConstraint).getNewDomainType());
				
			}
		}
		assertTrue(raceCodeConstraintFound);

	}
	
	@Test
	public void shouldNotCreateDuplicateRemoveDeltas() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.61");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();

		int removeConstraintCount = 0;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PolicyActivity.CoveredPartyParticipantParticipantRole") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
			} else if (delta.getClassName().equals("PolicyActivity.CoveredPartyParticipantParticipantRole") && delta.getRelationshipName().equals("participantRoleChoice")) {
				assertEquals(DeltaChangeType.REMOVE, delta.getDeltaChangeType());
				removeConstraintCount++;
			}
		}
		assertEquals(1, removeConstraintCount);
	}
	
	@Test
	public void shouldNormalizeDatatypeNames() throws Exception {
		// This constraint was resulting in a spurious constraint because non-standard spacing
		//  in the datatype name was defeating the attempt to match the base model datatype.
		//  Normalizing the datatype from the template causes the constraint not to be created
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.16");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundDataTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("MedicationActivity.SubstanceAdministration") && delta.getRelationshipName().equals("maxDoseQuantity")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				foundDataTypeCase = true;
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNull(dataTypeConstraint);
			}
		}
		assertTrue(foundDataTypeCase);
	}
	
	@Test
	public void shouldSuppressDatatypeConstraintsForBranchAttributes() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.17");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundDataTypeCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("MedicationSupplyOrder.Supply") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("MedicationSupplyOrder.Supply") && delta.getRelationshipName().equals("effectiveTime")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				foundDataTypeCase = true;
				
				Constraint dataTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
				assertNull(dataTypeConstraint);
			}
		}
		assertTrue(foundDataTypeCase);
	}
	
	@Test
	public void shouldHandleSingleOptionChoicesForBranch() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.2");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean sectionAssociationConstraintFound = false;
		boolean choiceBlockCreateConstraintFound = false;
		boolean participantCloneConstraintFound = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.ClinicalDocument") && delta.getRelationshipName().equals("participant")) {
				Constraint associationTypeConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationTypeConstraint);
				sectionAssociationConstraintFound = true;
				assertEquals("ContinuityOfCareDocumentCCD.Participant1Choice", ((AssociationTypeConstraint) associationTypeConstraint).getNewValue());
			}

			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.Participant1Choice") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.ADD, delta.getDeltaChangeType());
				
				Constraint addConstraint = delta.getConstraint(ConstraintChangeType.ADD);
				assertNotNull(addConstraint);
				choiceBlockCreateConstraintFound = true;
				assertTrue(((AddConstraint) addConstraint).getIsAbstract());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertEquals(2, addChoiceConstraints.size());
				assertEquals("ContinuityOfCareDocumentCCD.Participant1", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("BaseModel.Participant1", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
			}

			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.Participant1") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				participantCloneConstraintFound = true;
				assertEquals("ContinuityOfCareDocumentCCD.Participant1", ((CloneConstraint) cloneConstraint).getClassName());
				assertEquals("BaseModel.Participant1", ((CloneConstraint) cloneConstraint).getOriginalClassName());
			}
			
		}

		assertTrue(sectionAssociationConstraintFound);
		assertTrue(choiceBlockCreateConstraintFound);
		assertTrue(participantCloneConstraintFound);
	}
	
	@Test
	public void shouldSubstituteOptionsInChoiceBlocks() throws Exception {
		// The template parser was handling constraints on classes that are options within a choice block by breaking
		//  the choice block out into separate associations. This is wrong for a couple of reasons, but mostly because
		//  it was messing up the sort order.
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.1.2");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundChoiceBlockAssociationCase = false;
		boolean foundChoiceBlockCloneCase = false;
		boolean foundChoiceBlockDefinitionCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.AssignedAuthor") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.AssignedAuthor") && delta.getRelationshipName().equals("assignedAuthorChoice")) {
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				foundChoiceBlockAssociationCase = true;
				
				Constraint associationConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
				assertNotNull(associationConstraint);
				assertEquals("ContinuityOfCareDocumentCCD.AssignedAuthorChoice", ((AssociationTypeConstraint)associationConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.AssignedAuthorChoice") && delta.getRelationshipName() == null && delta.getDeltaChangeType().equals(DeltaChangeType.CLONE)) {
				foundChoiceBlockCloneCase = true;
				
				Constraint cloneConstraint = delta.getConstraint(ConstraintChangeType.CLONE);
				assertNotNull(cloneConstraint);
				assertEquals("ContinuityOfCareDocumentCCD.AssignedAuthorChoice", ((CloneConstraint)cloneConstraint).getClassName());
				assertEquals("BaseModel.AssignedAuthorChoice", ((CloneConstraint)cloneConstraint).getOriginalClassName());
			
			} else if (delta.getClassName().equals("ContinuityOfCareDocumentCCD.AssignedAuthorChoice") && delta.getRelationshipName() == null && delta.getDeltaChangeType().equals(DeltaChangeType.CHOICE)) {

				foundChoiceBlockDefinitionCase = true;
				
				List<Constraint> removeChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.REMOVE_CHOICE);
				assertNotNull(removeChoiceConstraints);
				assertEquals(2, removeChoiceConstraints.size());
				assertEquals("BaseModel.Person", ((RemoveChoiceConstraint)removeChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("BaseModel.AuthoringDevice", ((RemoveChoiceConstraint)removeChoiceConstraints.get(1)).getChoiceClassName());
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertNotNull(addChoiceConstraints);
				assertEquals(2, addChoiceConstraints.size());
				assertEquals("ContinuityOfCareDocumentCCD.AssignedAuthorPerson", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("assignedPerson", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getOptionName());
				assertEquals("ContinuityOfCareDocumentCCD.AuthoringDevice", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertEquals("assignedAuthoringDevice", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getOptionName());
			}
		}
		assertTrue(foundChoiceBlockAssociationCase);
		assertTrue(foundChoiceBlockCloneCase);
		assertTrue(foundChoiceBlockDefinitionCase);
	}
	
	@Test
	public void shouldInheritOptionsFromParentTemplates() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.10.20.22.4.68");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundChoiceBlockDefinitionCase = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("FunctionalStatusProblemObservation.EntryRelationshipChoice") && delta.getRelationshipName() == null) {

				foundChoiceBlockDefinitionCase = true;
				
				List<Constraint> addChoiceConstraints = delta.getAllConstraints(ConstraintChangeType.ADD_CHOICE);
				assertNotNull(addChoiceConstraints);
				assertEquals(7, addChoiceConstraints.size());
				assertEquals("FunctionalStatusProblemObservation.NonMedicinalSupplyActivityEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(0)).getChoiceClassName());
				assertEquals("FunctionalStatusProblemObservation.CaregiverCharacteristicsEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(1)).getChoiceClassName());
				assertEquals("FunctionalStatusProblemObservation.AssessmentScaleObservationEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(2)).getChoiceClassName());
				assertEquals("FunctionalStatusProblemObservation.AgeObservationEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(3)).getChoiceClassName());
				assertEquals("FunctionalStatusProblemObservation.ProblemStatusEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(4)).getChoiceClassName());
				assertEquals("FunctionalStatusProblemObservation.HealthStatusObservationEntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(5)).getChoiceClassName());
				assertEquals("BaseModel.EntryRelationship", ((AddChoiceConstraint)addChoiceConstraints.get(6)).getChoiceClassName());
			}
		}
		assertTrue(foundChoiceBlockDefinitionCase);
	}
}
