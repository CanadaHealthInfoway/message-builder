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

package ca.infoway.messagebuilder.generator.cda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

@RunWith(MockitoJUnitRunner.class)
public class CdaXsdProcessorTest {
	
	@Mock
	private OutputUI outputUI;
	
	private CdaXsdProcessor fixture;

	private Serializer serializer = new Persister(new AnnotationStrategy());
	private MessageSet messageSet;
	
	@Before
	public void setUp() throws Exception {
		fixture = new CdaXsdProcessor(outputUI);
		
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("/POCD_MT000040_SDTC.xsd"));
		Schema supplementarySchema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("/SDTC.xsd"));
		
		messageSet = new MessageSet();
		fixture.processSchema(schema, supplementarySchema, messageSet);
	}
	
	@Test
	public void shouldCreateMessagePart() throws Exception {
		MessagePart actMessagePart = messageSet.getMessagePart("BaseModel.Act");
		assertNotNull(actMessagePart);
		
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("BaseModel.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		MessagePart component2MessagePart = messageSet.getMessagePart("BaseModel.Component2");
		assertNotNull(component2MessagePart);
	}

	@Test
	public void shouldParseAttributes() throws Exception {
		MessagePart actMessagePart = messageSet.getMessagePart("BaseModel.Act");
		assertNotNull(actMessagePart);
		
		// exception - the nullFlavor attribute is special, and should not be parsed
		//  we already have a built-in null flavor mechanism in the legacy code to handle message models derived from MIFs
		//  parsing this attribute when it occurs in the XSD causes a conflict
		Relationship nullFlavorRelationship = actMessagePart.getRelationship("nullFlavor");
		assertNull(nullFlavorRelationship);
		
		Relationship classCodeRelationship = actMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship);
		assertTrue(classCodeRelationship.isAttribute());
		assertTrue(classCodeRelationship.isStructural());
		assertEquals(1, classCodeRelationship.getSortOrder());
		assertEquals("CS", classCodeRelationship.getType());
		assertEquals(DomainSource.VALUE_SET, classCodeRelationship.getDomainSource());
		assertEquals("x_ActClassDocumentEntryAct", classCodeRelationship.getDomainType());
		assertEquals(ConformanceLevel.MANDATORY, classCodeRelationship.getConformance());
		assertEquals(1, classCodeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, classCodeRelationship.getCardinality().getMax().intValue());
		
		Relationship moodCodeRelationship = actMessagePart.getRelationship("moodCode");
		assertNotNull(moodCodeRelationship);
		assertTrue(moodCodeRelationship.isAttribute());
		assertTrue(moodCodeRelationship.isStructural());
		assertEquals(2, moodCodeRelationship.getSortOrder());
		assertEquals("CS", moodCodeRelationship.getType());
		assertEquals(DomainSource.VALUE_SET, moodCodeRelationship.getDomainSource());
		assertEquals("x_DocumentActMood", moodCodeRelationship.getDomainType());
		assertEquals(ConformanceLevel.MANDATORY, moodCodeRelationship.getConformance());
		assertEquals(1, moodCodeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, moodCodeRelationship.getCardinality().getMax().intValue());
		
		Relationship negationIndRelationship = actMessagePart.getRelationship("negationInd");
		assertNotNull(negationIndRelationship);
		assertTrue(negationIndRelationship.isAttribute());
		assertTrue(negationIndRelationship.isStructural());
		assertEquals(3, negationIndRelationship.getSortOrder());
		assertEquals("BL", negationIndRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, negationIndRelationship.getConformance());
		assertEquals(0, negationIndRelationship.getCardinality().getMin().intValue());
		assertEquals(1, negationIndRelationship.getCardinality().getMax().intValue());
		
		Relationship templateIdRelationship = actMessagePart.getRelationship("templateId");
		assertNotNull(templateIdRelationship);
		assertTrue(templateIdRelationship.isAttribute());
		assertFalse(templateIdRelationship.isStructural());
		assertEquals(5, templateIdRelationship.getSortOrder());
		assertEquals("LIST<II>", templateIdRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, templateIdRelationship.getConformance());
		assertEquals(0, templateIdRelationship.getCardinality().getMin().intValue());
		assertEquals(Integer.MAX_VALUE, templateIdRelationship.getCardinality().getMax().intValue());
		
		Relationship codeRelationship = actMessagePart.getRelationship("code");
		assertNotNull(codeRelationship);
		assertTrue(codeRelationship.isAttribute());
		assertFalse(codeRelationship.isStructural());
		assertEquals(7, codeRelationship.getSortOrder());
		assertEquals("CD", codeRelationship.getType());
		assertEquals(ConformanceLevel.POPULATED, codeRelationship.getConformance());
		assertEquals(1, codeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, codeRelationship.getCardinality().getMax().intValue());
		
		Relationship effectiveTimeRelationship = actMessagePart.getRelationship("effectiveTime");
		assertNotNull(effectiveTimeRelationship);
		assertTrue(effectiveTimeRelationship.isAttribute());
		assertFalse(effectiveTimeRelationship.isStructural());
		assertEquals(10, effectiveTimeRelationship.getSortOrder());
		assertEquals("IVL<TS>", effectiveTimeRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, effectiveTimeRelationship.getConformance());
		assertEquals(0, effectiveTimeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, effectiveTimeRelationship.getCardinality().getMax().intValue());
		
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("BaseModel.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		Relationship classCodeRelationship2 = assignedAuthorMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship2);
		assertTrue(classCodeRelationship2.isAttribute());
		assertTrue(classCodeRelationship2.isStructural());
		assertEquals(1, classCodeRelationship2.getSortOrder());
		assertEquals("CS", classCodeRelationship2.getType());
		assertEquals(DomainSource.VALUE_SET, classCodeRelationship2.getDomainSource());
		assertEquals("RoleClassAssignedEntity", classCodeRelationship2.getDomainType());
		assertEquals("ASSIGNED", classCodeRelationship2.getFixedValue());
		assertEquals(ConformanceLevel.OPTIONAL, classCodeRelationship2.getConformance());
		assertEquals(0, classCodeRelationship2.getCardinality().getMin().intValue());
		assertEquals(1, classCodeRelationship2.getCardinality().getMax().intValue());
		
		MessagePart criterionMessagePart = messageSet.getMessagePart("BaseModel.Criterion");
		assertNotNull(criterionMessagePart);
		
		Relationship classCodeRelationship3 = criterionMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship3);
		assertEquals("OBS", classCodeRelationship3.getDefaultValue());
		
		MessagePart sectionMessagePart = messageSet.getMessagePart("BaseModel.Section");
		assertNotNull(sectionMessagePart);
		
		Relationship sectionIdRelationship = sectionMessagePart.getRelationship("ID");
		assertNotNull(sectionIdRelationship);
		assertEquals("ST", sectionIdRelationship.getType());
		assertEquals("xs:ID", sectionIdRelationship.getConstrainedType());
		
	}

	@Test
	public void shouldParseAssociations() throws Exception {
		MessagePart actMessagePart = messageSet.getMessagePart("BaseModel.Act");
		assertNotNull(actMessagePart);
		
		Relationship subjectRelationship = actMessagePart.getRelationship("subject");
		assertNotNull(subjectRelationship);
		assertTrue(subjectRelationship.isAssociation());
		assertEquals(13, subjectRelationship.getSortOrder());
		assertEquals("BaseModel.Subject", subjectRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, subjectRelationship.getConformance());
		assertEquals(0, subjectRelationship.getCardinality().getMin().intValue());
		assertEquals(1, subjectRelationship.getCardinality().getMax().intValue());
		
		Relationship specimenRelationship = actMessagePart.getRelationship("specimen");
		assertNotNull(specimenRelationship);
		assertTrue(specimenRelationship.isAssociation());
		assertEquals(14, specimenRelationship.getSortOrder());
		assertEquals("BaseModel.Specimen", specimenRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, specimenRelationship.getConformance());
		assertEquals(0, specimenRelationship.getCardinality().getMin().intValue());
		assertEquals(Integer.MAX_VALUE, specimenRelationship.getCardinality().getMax().intValue());
		
	}
	
	@Test
	public void shouldParseChoices() throws Exception {
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("BaseModel.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		Relationship assignedChoice = assignedAuthorMessagePart.getRelationship("assignedAuthorChoice");
		assertNotNull(assignedChoice);
		assertTrue(assignedChoice.isChoice());
		assertEquals("BaseModel.AssignedAuthorChoice", assignedChoice.getType());
		assertEquals(ConformanceLevel.OPTIONAL, assignedChoice.getConformance());
		assertEquals(0, assignedChoice.getCardinality().getMin().intValue());
		assertEquals(1, assignedChoice.getCardinality().getMax().intValue());
		assertEquals(8, assignedChoice.getSortOrder());
		assertEquals(2, assignedChoice.getChoices().size());
		
		Relationship assignedPersonRelationship = assignedChoice.getChoices().get(0);
		assertNotNull(assignedPersonRelationship);
		assertEquals("assignedPerson", assignedPersonRelationship.getName());
		assertEquals("BaseModel.Person", assignedPersonRelationship.getType());
		
		Relationship assignedAuthoringDeviceRelationship = assignedChoice.getChoices().get(1);
		assertNotNull(assignedAuthoringDeviceRelationship);
		assertEquals("assignedAuthoringDevice", assignedAuthoringDeviceRelationship.getName());
		assertEquals("BaseModel.AuthoringDevice", assignedAuthoringDeviceRelationship.getType());
		
		MessagePart assignedChoicePart = messageSet.getMessagePart("BaseModel.AssignedAuthorChoice");
		assertNotNull(assignedChoicePart);
		
		SpecializationChild assignedPersonSpecializationChild = assignedChoicePart.getSpecializationChilds().get(0);
		assertNotNull(assignedPersonSpecializationChild);
		assertEquals("BaseModel.Person", assignedPersonSpecializationChild.getName());
		
		SpecializationChild assignedAuthoringDeviceSpecializationChild = assignedChoicePart.getSpecializationChilds().get(1);
		assertNotNull(assignedAuthoringDeviceSpecializationChild);
		assertEquals("BaseModel.AuthoringDevice", assignedAuthoringDeviceSpecializationChild.getName());
		
		MessagePart component2MessagePart = messageSet.getMessagePart("BaseModel.Component2");
		assertNotNull(component2MessagePart);
		
		Relationship bodyChoice = component2MessagePart.getRelationship("component2Choice");
		assertNotNull(bodyChoice);
		assertEquals(ConformanceLevel.MANDATORY, bodyChoice.getConformance());
		assertEquals(1, bodyChoice.getCardinality().getMin().intValue());
		assertEquals(1, bodyChoice.getCardinality().getMax().intValue());
		
		Relationship structuredBodyRelationship = bodyChoice.getChoices().get(1);
		assertNotNull(structuredBodyRelationship);
		assertEquals("structuredBody", structuredBodyRelationship.getName());
		assertEquals("BaseModel.StructuredBody", structuredBodyRelationship.getType());
	}

	@Test
	public void shouldParseConstrainedDatatypes() throws Exception {
		// Do not create bogus message parts for these guys
		assertNull(messageSet.getMessagePart("BaseModel.InfrastructureRoot.typeId"));
		assertNull(messageSet.getMessagePart("BaseModel.RegionOfInterest.value"));
		
		MessagePart actMessagePart = messageSet.getMessagePart("BaseModel.Act");
		assertNotNull(actMessagePart);
		
		Relationship typeIdRelationship = actMessagePart.getRelationship("typeId");
		assertNotNull(typeIdRelationship);
		assertTrue(typeIdRelationship.isAttribute());
		assertFalse(typeIdRelationship.isStructural());
		assertEquals(4, typeIdRelationship.getSortOrder());
		assertEquals("II", typeIdRelationship.getType());
		assertEquals("BaseModel.InfrastructureRoot.typeId", typeIdRelationship.getConstrainedType());
		assertEquals(ConformanceLevel.OPTIONAL, typeIdRelationship.getConformance());
		assertEquals(0, typeIdRelationship.getCardinality().getMin().intValue());
		assertEquals(1, typeIdRelationship.getCardinality().getMax().intValue());
		
		ConstrainedDatatype typeIdConstrainedType = messageSet.getConstrainedDatatype("BaseModel.InfrastructureRoot.typeId");
		assertNotNull(typeIdConstrainedType);
		assertTrue(typeIdConstrainedType.isRestriction());
		assertFalse(typeIdConstrainedType.isExtension());
		assertEquals("II", typeIdConstrainedType.getBaseType());
		assertEquals(2, typeIdConstrainedType.getRelationships().size());
		Relationship rootRelationship = typeIdConstrainedType.getRelationships().get(0);
		assertNotNull(rootRelationship);
		assertEquals("root", rootRelationship.getName());
		assertEquals("uid", rootRelationship.getType());
		assertEquals(ConformanceLevel.MANDATORY, rootRelationship.getConformance());
		assertEquals("2.16.840.1.113883.1.3", rootRelationship.getFixedValue());
		Relationship extensionRelationship = typeIdConstrainedType.getRelationships().get(1);
		assertNotNull(extensionRelationship);
		assertEquals("extension", extensionRelationship.getName());
		assertEquals("ST", extensionRelationship.getType());
		assertEquals(ConformanceLevel.MANDATORY, extensionRelationship.getConformance());
		
		ConstrainedDatatype regionOfInterestValueConstrainedType = messageSet.getConstrainedDatatype("BaseModel.RegionOfInterest.value");
		assertNotNull(regionOfInterestValueConstrainedType);
		assertTrue(regionOfInterestValueConstrainedType.isExtension());
		assertFalse(regionOfInterestValueConstrainedType.isRestriction());
		assertEquals("INT", regionOfInterestValueConstrainedType.getBaseType());
		assertEquals(1, regionOfInterestValueConstrainedType.getRelationships().size());
		Relationship unsortedRelationship = regionOfInterestValueConstrainedType.getRelationships().get(0);
		assertNotNull(unsortedRelationship);
		assertEquals("unsorted", unsortedRelationship.getName());
		assertEquals("BL", unsortedRelationship.getType());
		assertEquals("xs:boolean", unsortedRelationship.getConstrainedType());
		assertEquals(ConformanceLevel.OPTIONAL, unsortedRelationship.getConformance());
		assertEquals("false", unsortedRelationship.getDefaultValue());
		
		MessagePart sectionMessagePart = messageSet.getMessagePart("BaseModel.Section");
		assertNotNull(sectionMessagePart);
		
		Relationship textRelationship = sectionMessagePart.getRelationship("text");
		assertNotNull(textRelationship);
		assertTrue(textRelationship.isAttribute());
		assertFalse(textRelationship.isStructural());
		assertEquals("ED", textRelationship.getType());
		assertEquals("StrucDoc.Text", textRelationship.getConstrainedType());
		
		// We don't create a ConstrainedDatatype entry for StrucDoc.Text
		assertNull(messageSet.getConstrainedDatatype("StrucDoc.Text"));
	}
	
	@Test
	public void shouldParseExtendedAttributes() throws Exception {
		MessagePart encounterMessagePart = messageSet.getMessagePart("BaseModel.Encounter");
		assertNotNull(encounterMessagePart);
		Relationship dischargeDispositionCode = encounterMessagePart.getRelationship("dischargeDispositionCode", "sdtc");
		assertNotNull(dischargeDispositionCode);
		assertTrue(dischargeDispositionCode.isAttribute());
		assertFalse(dischargeDispositionCode.isStructural());
		assertEquals("CE", dischargeDispositionCode.getType());
		assertEquals(ConformanceLevel.OPTIONAL, dischargeDispositionCode.getConformance());
		assertEquals(0, dischargeDispositionCode.getCardinality().getMin().intValue());
		assertEquals(1, dischargeDispositionCode.getCardinality().getMax().intValue());
		assertEquals("sdtc", dischargeDispositionCode.getNamespace());

		MessagePart patientMessagePart = messageSet.getMessagePart("BaseModel.Patient");
		assertNotNull(patientMessagePart);
		Relationship baseRaceCode = patientMessagePart.getRelationship("raceCode");
		assertNotNull(baseRaceCode);
		assertTrue(baseRaceCode.isAttribute());
		assertFalse(baseRaceCode.isStructural());
		assertEquals("CE", baseRaceCode.getType());
		assertEquals(ConformanceLevel.OPTIONAL, baseRaceCode.getConformance());
		assertEquals(0, baseRaceCode.getCardinality().getMin().intValue());
		assertEquals(1, baseRaceCode.getCardinality().getMax().intValue());
		assertNull(baseRaceCode.getNamespace());

		// TM - removed namespace check on MessagePart.getRelationship - this may be reinstated at some point
//		Relationship extendedRaceCode = patientMessagePart.getRelationship("raceCode", "sdtc");
//		// Suppress extended attributes whose names would collide with standard attributes
//		// They aren't in scope for this release, and they're causing problems downstream
//		assertNull(extendedRaceCode);
		
//		assertNotNull(extendedRaceCode);
//		assertTrue(extendedRaceCode.isAttribute());
//		assertFalse(extendedRaceCode.isStructural());
//		assertEquals("LIST<CE>", extendedRaceCode.getType());
//		assertEquals(ConformanceLevel.OPTIONAL, extendedRaceCode.getConformance());
//		assertEquals(0, extendedRaceCode.getCardinality().getMin().intValue());
//		assertEquals(Integer.MAX_VALUE, extendedRaceCode.getCardinality().getMax().intValue());
//		assertEquals("sdtc", extendedRaceCode.getNamespace());
	}
	
	@Test
	public void shouldCreateDefaultInteraction() throws Exception {
		Map<String, Interaction> allInteractions = messageSet.getInteractions();
		assertEquals(1, allInteractions.size());
		Interaction interaction = allInteractions.get("BaseModel");
		assertNotNull(interaction);
		assertEquals("BaseModel", interaction.getName());
		assertEquals("BaseModel.ClinicalDocument", interaction.getSuperTypeName());
		assertEquals("document", interaction.getCategory());
	}
}
