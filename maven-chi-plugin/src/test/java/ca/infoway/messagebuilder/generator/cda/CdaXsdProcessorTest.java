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
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

public class CdaXsdProcessorTest {
	
	private CdaXsdProcessor fixture;

	private Serializer serializer = new Persister(new AnnotationStrategy());
	
	@Before
	public void setUp() throws Exception {
		fixture = new CdaXsdProcessor();
	}
	
	@Test
	public void shouldCreateMessagePart() throws Exception {
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		fixture.processSchema(schema, messageSet);
		
		MessagePart actMessagePart = messageSet.getMessagePart("POCD_MT000040.Act");
		assertNotNull(actMessagePart);
		
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("POCD_MT000040.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		MessagePart component2MessagePart = messageSet.getMessagePart("POCD_MT000040.Component2");
		assertNotNull(component2MessagePart);
	}

	@Test
	public void shouldParseAttributes() throws Exception {
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		fixture.processSchema(schema, messageSet);
		
		MessagePart actMessagePart = messageSet.getMessagePart("POCD_MT000040.Act");
		assertNotNull(actMessagePart);
		
		Relationship nullFlavorRelationship = actMessagePart.getRelationship("nullFlavor");
		assertNotNull(nullFlavorRelationship);
		assertTrue(nullFlavorRelationship.isAttribute());
		assertTrue(nullFlavorRelationship.isStructural());
		assertEquals(1, nullFlavorRelationship.getSortOrder());
		assertEquals("CS", nullFlavorRelationship.getType());
		assertEquals(DomainSource.VALUE_SET, nullFlavorRelationship.getDomainSource());
		assertEquals("NullFlavor", nullFlavorRelationship.getDomainType());
		assertEquals(ConformanceLevel.OPTIONAL, nullFlavorRelationship.getConformance());
		assertEquals(0, nullFlavorRelationship.getCardinality().getMin().intValue());
		assertEquals(1, nullFlavorRelationship.getCardinality().getMax().intValue());
		
		Relationship classCodeRelationship = actMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship);
		assertTrue(classCodeRelationship.isAttribute());
		assertTrue(classCodeRelationship.isStructural());
		assertEquals(2, classCodeRelationship.getSortOrder());
		assertEquals("CS", classCodeRelationship.getType());
		assertEquals(DomainSource.VALUE_SET, classCodeRelationship.getDomainSource());
		assertEquals("x_ActClassDocumentEntryAct", classCodeRelationship.getDomainType());
		assertEquals(ConformanceLevel.REQUIRED, classCodeRelationship.getConformance());
		assertEquals(1, classCodeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, classCodeRelationship.getCardinality().getMax().intValue());
		
		Relationship moodCodeRelationship = actMessagePart.getRelationship("moodCode");
		assertNotNull(moodCodeRelationship);
		assertTrue(moodCodeRelationship.isAttribute());
		assertTrue(moodCodeRelationship.isStructural());
		assertEquals(3, moodCodeRelationship.getSortOrder());
		assertEquals("CS", moodCodeRelationship.getType());
		assertEquals(DomainSource.VALUE_SET, moodCodeRelationship.getDomainSource());
		assertEquals("x_DocumentActMood", moodCodeRelationship.getDomainType());
		assertEquals(ConformanceLevel.REQUIRED, moodCodeRelationship.getConformance());
		assertEquals(1, moodCodeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, moodCodeRelationship.getCardinality().getMax().intValue());
		
		Relationship negationIndRelationship = actMessagePart.getRelationship("negationInd");
		assertNotNull(negationIndRelationship);
		assertTrue(negationIndRelationship.isAttribute());
		assertTrue(negationIndRelationship.isStructural());
		assertEquals(4, negationIndRelationship.getSortOrder());
		assertEquals("BL", negationIndRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, negationIndRelationship.getConformance());
		assertEquals(0, negationIndRelationship.getCardinality().getMin().intValue());
		assertEquals(1, negationIndRelationship.getCardinality().getMax().intValue());
		
		Relationship realmCodeRelationship = actMessagePart.getRelationship("realmCode");
		assertNotNull(realmCodeRelationship);
		assertTrue(realmCodeRelationship.isAttribute());
		assertFalse(realmCodeRelationship.isStructural());
		assertEquals(5, realmCodeRelationship.getSortOrder());
		assertEquals("LIST<CS>", realmCodeRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, realmCodeRelationship.getConformance());
		assertEquals(0, realmCodeRelationship.getCardinality().getMin().intValue());
		assertEquals(Integer.MAX_VALUE, realmCodeRelationship.getCardinality().getMax().intValue());
		
		Relationship templateIdRelationship = actMessagePart.getRelationship("templateId");
		assertNotNull(templateIdRelationship);
		assertTrue(templateIdRelationship.isAttribute());
		assertFalse(templateIdRelationship.isStructural());
		assertEquals(7, templateIdRelationship.getSortOrder());
		assertEquals("LIST<II>", templateIdRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, templateIdRelationship.getConformance());
		assertEquals(0, templateIdRelationship.getCardinality().getMin().intValue());
		assertEquals(Integer.MAX_VALUE, templateIdRelationship.getCardinality().getMax().intValue());
		
		Relationship codeRelationship = actMessagePart.getRelationship("code");
		assertNotNull(codeRelationship);
		assertTrue(codeRelationship.isAttribute());
		assertFalse(codeRelationship.isStructural());
		assertEquals(9, codeRelationship.getSortOrder());
		assertEquals("CD", codeRelationship.getType());
		assertEquals(ConformanceLevel.MANDATORY, codeRelationship.getConformance());
		assertEquals(1, codeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, codeRelationship.getCardinality().getMax().intValue());
		
		Relationship effectiveTimeRelationship = actMessagePart.getRelationship("effectiveTime");
		assertNotNull(effectiveTimeRelationship);
		assertTrue(effectiveTimeRelationship.isAttribute());
		assertFalse(effectiveTimeRelationship.isStructural());
		assertEquals(12, effectiveTimeRelationship.getSortOrder());
		assertEquals("IVL_TS", effectiveTimeRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, effectiveTimeRelationship.getConformance());
		assertEquals(0, effectiveTimeRelationship.getCardinality().getMin().intValue());
		assertEquals(1, effectiveTimeRelationship.getCardinality().getMax().intValue());
		
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("POCD_MT000040.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		Relationship classCodeRelationship2 = assignedAuthorMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship2);
		assertTrue(classCodeRelationship2.isAttribute());
		assertTrue(classCodeRelationship2.isStructural());
		assertEquals(2, classCodeRelationship2.getSortOrder());
		assertEquals("CS", classCodeRelationship2.getType());
		assertEquals(DomainSource.VALUE_SET, classCodeRelationship2.getDomainSource());
		assertEquals("RoleClassAssignedEntity", classCodeRelationship2.getDomainType());
		assertEquals("ASSIGNED", classCodeRelationship2.getFixedValue());
		assertEquals(ConformanceLevel.OPTIONAL, classCodeRelationship2.getConformance());
		assertEquals(0, classCodeRelationship2.getCardinality().getMin().intValue());
		assertEquals(1, classCodeRelationship2.getCardinality().getMax().intValue());
		
		MessagePart criterionMessagePart = messageSet.getMessagePart("POCD_MT000040.Criterion");
		assertNotNull(criterionMessagePart);
		
		Relationship classCodeRelationship3 = criterionMessagePart.getRelationship("classCode");
		assertNotNull(classCodeRelationship3);
		assertEquals("OBS", classCodeRelationship3.getDefaultValue());
		
	}

	@Test
	public void shouldParseAssociations() throws Exception {
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		fixture.processSchema(schema, messageSet);
		
		MessagePart actMessagePart = messageSet.getMessagePart("POCD_MT000040.Act");
		assertNotNull(actMessagePart);
		
		Relationship subjectRelationship = actMessagePart.getRelationship("subject");
		assertNotNull(subjectRelationship);
		assertTrue(subjectRelationship.isAssociation());
		assertEquals(15, subjectRelationship.getSortOrder());
		assertEquals("POCD_MT000040.Subject", subjectRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, subjectRelationship.getConformance());
		assertEquals(0, subjectRelationship.getCardinality().getMin().intValue());
		assertEquals(1, subjectRelationship.getCardinality().getMax().intValue());
		
		Relationship specimenRelationship = actMessagePart.getRelationship("specimen");
		assertNotNull(specimenRelationship);
		assertTrue(specimenRelationship.isAssociation());
		assertEquals(16, specimenRelationship.getSortOrder());
		assertEquals("POCD_MT000040.Specimen", specimenRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, specimenRelationship.getConformance());
		assertEquals(0, specimenRelationship.getCardinality().getMin().intValue());
		assertEquals(Integer.MAX_VALUE, specimenRelationship.getCardinality().getMax().intValue());
		
	}
	
	@Test
	public void shouldPArseChoices() throws Exception {
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		fixture.processSchema(schema, messageSet);
		
		MessagePart assignedAuthorMessagePart = messageSet.getMessagePart("POCD_MT000040.AssignedAuthor");
		assertNotNull(assignedAuthorMessagePart);
		
		Relationship assignedChoice = assignedAuthorMessagePart.getRelationship("AssignedAuthor_10");
		assertNotNull(assignedChoice);
		assertTrue(assignedChoice.isChoice());
		assertEquals(10, assignedChoice.getSortOrder());
		assertEquals(2, assignedChoice.getChoices().size());
		
		Relationship assignedPersonRelationship = assignedChoice.getChoices().get(0);
		assertNotNull(assignedPersonRelationship);
		assertEquals("assignedPerson", assignedPersonRelationship.getName());
		assertEquals("POCD_MT000040.Person", assignedPersonRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, assignedPersonRelationship.getConformance());
		assertEquals(0, assignedPersonRelationship.getCardinality().getMin().intValue());
		assertEquals(1, assignedPersonRelationship.getCardinality().getMax().intValue());
		
		Relationship assignedAuthoringDeviceRelationship = assignedChoice.getChoices().get(1);
		assertNotNull(assignedAuthoringDeviceRelationship);
		assertEquals("assignedAuthoringDevice", assignedAuthoringDeviceRelationship.getName());
		assertEquals("POCD_MT000040.AuthoringDevice", assignedAuthoringDeviceRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, assignedAuthoringDeviceRelationship.getConformance());
		assertEquals(0, assignedAuthoringDeviceRelationship.getCardinality().getMin().intValue());
		assertEquals(1, assignedAuthoringDeviceRelationship.getCardinality().getMax().intValue());
		
		MessagePart component2MessagePart = messageSet.getMessagePart("POCD_MT000040.Component2");
		assertNotNull(component2MessagePart);
		Relationship bodyChoice = component2MessagePart.getRelationship("Component2_7");
		assertNotNull(bodyChoice);
		Relationship structuredBodyRelationship = bodyChoice.getChoices().get(1);
		assertNotNull(structuredBodyRelationship);
		assertEquals("structuredBody", structuredBodyRelationship.getName());
		assertEquals("POCD_MT000040.StructuredBody", structuredBodyRelationship.getType());
		assertEquals(ConformanceLevel.MANDATORY, structuredBodyRelationship.getConformance());
		assertEquals(1, structuredBodyRelationship.getCardinality().getMin().intValue());
		assertEquals(1, structuredBodyRelationship.getCardinality().getMax().intValue());
	}

	@Test
	public void shouldParseConstrainedDatatypes() throws Exception {
		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdProcessorTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		fixture.processSchema(schema, messageSet);
		
		MessagePart actMessagePart = messageSet.getMessagePart("POCD_MT000040.Act");
		assertNotNull(actMessagePart);
		
		Relationship typeIdRelationship = actMessagePart.getRelationship("typeId");
		assertNotNull(typeIdRelationship);
		assertTrue(typeIdRelationship.isAttribute());
		assertFalse(typeIdRelationship.isStructural());
		assertEquals(6, typeIdRelationship.getSortOrder());
		assertEquals("II", typeIdRelationship.getType());
		assertEquals("POCD_MT000040.InfrastructureRoot.typeId", typeIdRelationship.getConstrainedType());
		assertEquals(ConformanceLevel.OPTIONAL, typeIdRelationship.getConformance());
		assertEquals(0, typeIdRelationship.getCardinality().getMin().intValue());
		assertEquals(1, typeIdRelationship.getCardinality().getMax().intValue());
		
		ConstrainedDatatype typeIdConstrainedType = messageSet.getConstrainedDatatype("POCD_MT000040.InfrastructureRoot.typeId");
		assertNotNull(typeIdConstrainedType);
		assertTrue(typeIdConstrainedType.isRestriction());
		assertEquals("II", typeIdConstrainedType.getBaseType());
		assertEquals(2, typeIdConstrainedType.getRelationships().size());
		Relationship rootRelationship = typeIdConstrainedType.getRelationships().get(0);
		assertNotNull(rootRelationship);
		assertEquals("root", rootRelationship.getName());
		assertEquals("uid", rootRelationship.getType());
		assertEquals(ConformanceLevel.REQUIRED, rootRelationship.getConformance());
		assertEquals("2.16.840.1.113883.1.3", rootRelationship.getFixedValue());
		Relationship extensionRelationship = typeIdConstrainedType.getRelationships().get(1);
		assertNotNull(extensionRelationship);
		assertEquals("extension", extensionRelationship.getName());
		assertEquals("ST", extensionRelationship.getType());
		assertEquals(ConformanceLevel.REQUIRED, extensionRelationship.getConformance());
		
		ConstrainedDatatype regionOfInterestValueConstrainedType = messageSet.getConstrainedDatatype("POCD_MT000040.RegionOfInterest.value");
		assertNotNull(regionOfInterestValueConstrainedType);
		assertTrue(regionOfInterestValueConstrainedType.isExtension());
		assertEquals("INT", regionOfInterestValueConstrainedType.getBaseType());
		assertEquals(1, regionOfInterestValueConstrainedType.getRelationships().size());
		Relationship unsortedRelationship = regionOfInterestValueConstrainedType.getRelationships().get(0);
		assertNotNull(unsortedRelationship);
		assertEquals("unsorted", unsortedRelationship.getName());
		assertEquals("xs:boolean", unsortedRelationship.getType());
		assertEquals(ConformanceLevel.OPTIONAL, unsortedRelationship.getConformance());
		assertEquals("false", unsortedRelationship.getDefaultValue());
	}
}
