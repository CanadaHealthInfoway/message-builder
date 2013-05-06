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
package ca.infoway.demiftifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.RimClass;

@RunWith(MockitoJUnitRunner.class)
public class MessagePartLayoutItemTest {
	
	private static final String DEFAULT_RELATIONSHIP_NAME = "relationshipName";
	private static final String CMET_BINDING_NAME = "cmetBindingName";

	@Mock
	Layout layout;
	@Mock 
	PackageLocation packageLocation;
	@Mock
	MessageSet messageSet;

	@Before
	public void setUp() {
		Mockito.when(this.layout.getMessageSet()).thenReturn(this.messageSet);
		Mockito.when(this.layout.getPackageLocation()).thenReturn(this.packageLocation);		
	}

	private void assertGetLabel(String messagePartName, RimClass rimClass, String expectedLabel){
		MessagePart messagePart = MessagePartBuilder.basicBuilder(messagePartName).withRimClass(rimClass).build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout)
				.withRelationshipName(DEFAULT_RELATIONSHIP_NAME).build();
		assertEquals(expectedLabel, layoutItem.getLabel());
	}

	private void assertIsNotCmet(String messagePartName) {
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePartName, this.layout).build();
		assertFalse(layoutItem.isCmet());
	}

	private void assertIsCmet(String messagePartName){
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePartName, this.layout).build();
		assertTrue(layoutItem.isCmet());
	}

	@Test
	public void testIsCmet() {
		Mockito.when(this.packageLocation.getName()).thenReturn("REPC_MT230001CA");		
		assertIsCmet("COCT_MT050202CA.FOO");
		assertIsNotCmet("REPC_MT230001CA.FOO");
	}
	
	@Test
	public void testGetLabel() throws Exception {
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.ACT, "FOO");
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.ACT_RELATIONSHIP, DEFAULT_RELATIONSHIP_NAME);
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.ENTITY, "FOO");
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.OTHER_CLASS, "FOO");
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.PARTICIPATION, DEFAULT_RELATIONSHIP_NAME);
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.ROLE, "FOO");
		assertGetLabel("COCT_MT050202CA.FOO", RimClass.ROLE_LINK, "FOO");
		assertGetLabel("COCT_MT123456CA.FOO", RimClass.ACT, "COCT_MT123456CA"); //CMET
	}
	
	@Test
	public void createDuplicate() throws Exception {
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO")
				.withRimClass(RimClass.ACT)
				.withAssociation("bar", "COCT_MT050202CA.someType").build();
		MessagePartLayoutItem original = LayoutItemBuilder.basicBuilder(messagePart, this.layout).build();
		
		MessagePartLayoutItem duplicate = original.createDuplicate();
		
		Mockito.verify(this.layout).addItem(duplicate);
		assertEquals(original, duplicate.getOriginal());
		assertEquals(1, original.getAssociations().size());
		assertEquals(0, duplicate.getAssociations().size());

	}


	@Test
	public void testGetAssociations() throws Exception {
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO")
				.withRimClass(RimClass.ACT)
				.withAssociation("bar0", "COCT_MT050202CA.someType0")
				.withAssociation("bar1", "COCT_MT050202CA.someType1")
				.withAssociation("bar2", "COCT_MT050202CA.someType2").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout).build();
		
		assertEquals(3, layoutItem.getAssociations().size());
	}
	

	@Test
	public void getAssociationsShouldReturnEmptyListForCmets() throws Exception {
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT123456CA.FOO")
				.withRimClass(RimClass.ACT)
				.withAssociation("bar", "COCT_MT050202CA.someType").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout).build();
		
		assertEquals(0, layoutItem.getAssociations().size());
	}
	
	@Test
	public void getAssociationsShouldReturnEmptyListForDuplicates() throws Exception {
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO")
				.withRimClass(RimClass.ACT)
				.withAssociation("bar", "COCT_MT050202CA.someType").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout).build().createDuplicate();
		
		assertEquals(0, layoutItem.getAssociations().size());
	}
	
	@Test
	public void shouldNotReturnCmetBindingForVanillaParts() throws Exception {
		Mockito.when(this.messageSet.getPackageLocation("COCT_MT050202CA")).thenReturn(this.packageLocation);
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout).build();
		
		assertNull(layoutItem.getCmetBinding());
	}

	@Test
	public void shouldReturnCmetBindingFromAssociation() throws Exception {
		CmetBinding cmetBinding = new CmetBinding();
		Mockito.when(this.messageSet.getPackageLocation("COCT_MT050202CA")).thenReturn(this.packageLocation);
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");
		Mockito.when(this.packageLocation.getCmetBinding(CMET_BINDING_NAME)).thenReturn(cmetBinding);
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(messagePart, this.layout)
				.withRelationshipName(DEFAULT_RELATIONSHIP_NAME, CMET_BINDING_NAME).build();
		
		assertSame(cmetBinding, layoutItem.getCmetBinding());
	}
	
	@Test
	public void shouldReturnCmetBindingFromSpecialization() throws Exception {
		CmetBinding cmetBinding = new CmetBinding();
		Mockito.when(this.messageSet.getPackageLocation("COCT_MT050202CA")).thenReturn(this.packageLocation);
		Mockito.when(this.packageLocation.getName()).thenReturn("COCT_MT050202CA");
		Mockito.when(this.packageLocation.getCmetBinding(CMET_BINDING_NAME)).thenReturn(cmetBinding);
		
		MessagePart parentMessagePart = MessagePartBuilder.basicBuilder("PORX_MT010101CA.Choice")
				.withSpecChild("PORX_MT010101.Child")
				.withSpecChild("COCT_MT050202CA.FOO", CMET_BINDING_NAME, "Act").build();
		MessagePartLayoutItem parentLayoutItem = LayoutItemBuilder.basicBuilder(parentMessagePart, this.layout).build();
		
		MessagePart messagePart = MessagePartBuilder.basicBuilder("COCT_MT050202CA.FOO").build();
		MessagePartLayoutItem layoutItem = LayoutItemBuilder.basicBuilder(parentLayoutItem, messagePart, this.layout).build();
		
		assertSame(cmetBinding, layoutItem.getCmetBinding());
	}
	
}
