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
package ca.infoway.demiftifier.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.Layout;
import ca.infoway.demiftifier.LayoutItem;
import ca.infoway.demiftifier.MessagePartBuilder;
import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.demiftifier.MessageSetBuilder;
import ca.infoway.demiftifier.PackageLocationBuilder;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.RimClass;

@RunWith(MockitoJUnitRunner.class)
public class LayerOuterTest {
	private static final String DUP_MARKER = "_Dup";
	private static final String PACKAGE_LOCATION_NAME = "ABCD_MT123456CA";
	private static final String PACKAGE_LOCATION_PREFIX = PACKAGE_LOCATION_NAME + ".";
	private static final String PACKAGE_LOCATION_NAME_OTHER = "WXYZ_MT123456CA";
	private static final String PACKAGE_LOCATION_OTHER_PREFIX = PACKAGE_LOCATION_NAME_OTHER + ".";

	private Map<String, MessagePartLayoutItem> buildMap(Collection<MessagePartLayoutItem> messagePartLayoutItems) {
		Map<String, MessagePartLayoutItem> result = new HashMap<String, MessagePartLayoutItem>();
		for (MessagePartLayoutItem item : messagePartLayoutItems) {
			if (item.isDuplicate()){
				result.put(item.getName() + DUP_MARKER, item);
			} else {
				result.put(item.getName(), item);
			}
		}
		return result;
	}
	

	private void assertLogicalX(String name, int expectedX, Map<String,MessagePartLayoutItem> items) {
		assertEquals(name, expectedX, getItemFailIfNotFound(name, items).getLogicalX());
	}


	private MessagePartLayoutItem getItemFailIfNotFound(String name, Map<String, MessagePartLayoutItem> items) {
		MessagePartLayoutItem result = items.get(name);
		if (result == null){
			fail(name + " not found in map!");
		}
		return result;
	}

	private void assertLogicalY(String name, int expectedY, Map<String,MessagePartLayoutItem> items) {
		assertEquals(name, expectedY, getItemFailIfNotFound(name, items).getLogicalY());
	}

	private void assertHeight(String name, int expectedHeight, Map<String, MessagePartLayoutItem> items) {
		assertEquals(name, expectedHeight, getItemFailIfNotFound(name, items).getHeight());
	}

	private void assertInboundAssociationNull(String name, Map<String, MessagePartLayoutItem> items) {
		assertNull(name, getItemFailIfNotFound(name, items).getInboundAssociation());
	}


	private void assertInboundArrowDepth(String name, int expectedDepth, Map<String, MessagePartLayoutItem> items) {
		assertEquals(name, expectedDepth, getItemFailIfNotFound(name, items).getInboundAssociation().getInboundArrowDepth());
	}
	
	private void assertIsCmet(String name, Map<String, MessagePartLayoutItem> items) {
		assertTrue(name, getItemFailIfNotFound(name, items).isCmet());
	}

	private void assertIsNotCmet(String name, Map<String, MessagePartLayoutItem> items) {
		assertFalse(name, getItemFailIfNotFound(name, items).isCmet());
	}

	private void assertEncroachmentLevel(String name, int encroachmentLevel, Map<String, MessagePartLayoutItem> items) {
		assertEquals(name, encroachmentLevel, getItemFailIfNotFound(name, items).getEncroachmentLevel());
	}

	private void assertIsCyclic(String name, Map<String, MessagePartLayoutItem> items) {
		assertTrue(name, getItemFailIfNotFound(name, items).isCyclic());
	}

	private void assertIsNotCyclic(String name, Map<String, MessagePartLayoutItem> items) {
		assertFalse(name, getItemFailIfNotFound(name, items).isCyclic());
	}

	private void assertEncroachmentLevelEnd(String name, int encroachmentLevelEnd, Map<String, MessagePartLayoutItem> items) {
		assertEquals(name, encroachmentLevelEnd, getItemFailIfNotFound(name, items).getEncroachmentLevelEnd());
	}
	
	// MyType -> MyType2 -> MyType3
	@Test
	public void shouldLayoutTrivialCase() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myType2 = PACKAGE_LOCATION_PREFIX + "MyType2";
		String myType3 = PACKAGE_LOCATION_PREFIX + "MyType3";

		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(myType3)
				.withRimClass(RimClass.ACT).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myType2)
				.withRimClass(RimClass.ACT_RELATIONSHIP)
				.withAssociation("name", myType3).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withRimClass(RimClass.ACT)
				.withAssociation("name", myType2).build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);

		//Check Entry Point
		LayoutItem entryPoint = layout.getItems().iterator().next();
		assertEquals(PACKAGE_LOCATION_NAME, entryPoint.getName());
		
		//Check Message Part Layout Items
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());
		assertEquals("item count", 3, items.size());
		assertLogicalX(myType, 0, items);
		assertLogicalY(myType, 1, items);
		assertInboundAssociationNull(myType, items);
		assertLogicalX(myType2, 1, items);
		assertInboundArrowDepth(myType2, 0, items);
		assertLogicalX(myType3, 2, items);
		assertInboundArrowDepth(myType3, 0, items);
	}
	
	//          +-> MyType3
	//  MyType -+
	//          +-> MyType2
	@Test
	public void shouldLayoutMultipleDependencies() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myType2 = PACKAGE_LOCATION_PREFIX + "MyType2";
		String myType3 = PACKAGE_LOCATION_PREFIX + "MyType3";

		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(myType3).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myType2).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withAssociation("thirdThing", myType3)
				.withAssociation("name", myType2).build();

		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 3, items.size());
		assertLogicalX(myType, 0, items);
		assertHeight(myType, 2, items);
		
		assertLogicalX(myType2, 1, items);
		assertLogicalY(myType2, 2, items);
		
		assertLogicalX(myType3, 1, items);
		assertLogicalY(myType3, 1, items);
	}

	//          +-> MyType3
	//  MyType -+
	//          +-> MyType2 -> MyType3
	@Test
	public void shouldLayoutMultipleDependenciesWithDuplicates() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myType2 = PACKAGE_LOCATION_PREFIX + "MyType2";
		String myType3 = PACKAGE_LOCATION_PREFIX + "MyType3";

		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(myType3).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myType2)
				.withAssociation("thirdThing", myType3).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withAssociation("thirdThing", myType3)
				.withAssociation("name", myType2).build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 4, items.size());
		assertLogicalX(myType, 0, items);
		assertHeight(myType, 2, items);
		
		assertLogicalX(myType2, 1, items);
		assertLogicalY(myType2, 2, items);
		
		assertLogicalX(myType3 + DUP_MARKER, 2, items);
		assertLogicalY(myType3 + DUP_MARKER, 2, items);

		assertLogicalX(myType3, 1, items);
		assertLogicalY(myType3, 1, items);
	}

	//          +-> MyType2 -> MyType4
	//  MyType -+
	//          +-> MyType3 -> MyType4
	@Test
	public void shouldMergeAdjacentDuplicates() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myType2 = PACKAGE_LOCATION_PREFIX + "MyType2";
		String myType3 = PACKAGE_LOCATION_PREFIX + "MyType3";
		String myType4 = PACKAGE_LOCATION_PREFIX + "MyType4";

		MessagePart messagePart4 = MessagePartBuilder.basicBuilder(myType4).build();
		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(myType3)
				.withAssociation("type4", myType4).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myType2)
				.withAssociation("type4", myType4).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withAssociation("type2", myType2)
				.withAssociation("type3", myType3).build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).withMessagePart(messagePart4).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 4, items.size());
		assertLogicalX(myType, 0, items);
		assertHeight(myType, 2, items);
		
		assertLogicalX(myType2, 1, items);
		assertLogicalY(myType2, 1, items);
		
		assertLogicalX(myType3, 1, items);
		assertLogicalY(myType3, 2, items);

		assertLogicalX(myType4, 2, items);
		assertLogicalY(myType4, 1, items);
		assertHeight(myType4, 2, items);
	}

	// RootTypeEntity (no arrow) -> Type2Entity (hasArrow - depth 1) -> Type3Act (hasArrow - depth 2) -> Type4Participation (noArrow - depth 0)
	@Test
	public void shouldLayoutWithTwoConsecutiveInboundArrows() {
		
		String rootTypeEntity = PACKAGE_LOCATION_PREFIX + "RootTypeEntity";
		String type2Entity = PACKAGE_LOCATION_PREFIX + "Type2Entity";
		String type3Act = PACKAGE_LOCATION_PREFIX + "Type3Act";
		String type4Participation = PACKAGE_LOCATION_PREFIX + "Type4Participation";

		MessagePart messagePart4 = MessagePartBuilder.basicBuilder(type4Participation)
				.withRimClass(RimClass.PARTICIPATION).build();
		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(type3Act)
				.withRimClass(RimClass.ACT)
				.withAssociation("inboundTo4", type4Participation).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(type2Entity)
				.withRimClass(RimClass.ENTITY)
				.withAssociation("name", type3Act).build();
		MessagePart rootMessagePart = MessagePartBuilder.basicBuilder(rootTypeEntity)
				.withRimClass(RimClass.ENTITY)
				.withAssociation("name", type2Entity).build();

		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, rootMessagePart)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).withMessagePart(messagePart4).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 4, items.size());
		assertLogicalX(rootTypeEntity, 0, items);
		assertInboundAssociationNull(rootTypeEntity, items);
		assertLogicalX(type2Entity, 1, items);
		assertInboundArrowDepth(type2Entity, 1, items);
		assertLogicalX(type3Act, 2, items);
		assertInboundArrowDepth(type3Act, 2, items);
		assertLogicalX(type4Participation, 3, items);
		assertInboundArrowDepth(type4Participation, 0, items);
	}

	//
	//  RootTypeActChoice  -> Type2Entity (with arrow)
	//
	//		ChoiceC1 --------> Type3Participation
	//
	//		ChoiceC2 --------> Type4OtherClass (with arrow)
	//          		
	@Test
	public void shouldLayoutChoices() {
		String rootTypeActChoice = PACKAGE_LOCATION_PREFIX + "RootTypeActChoice";
		String choiceC1 = PACKAGE_LOCATION_PREFIX + "ChoiceC1";
		String choiceC2 = PACKAGE_LOCATION_PREFIX + "ChoiceC2";
		String type2Entity = PACKAGE_LOCATION_PREFIX + "Type2Entity";
		String type3Participation = PACKAGE_LOCATION_PREFIX + "Type3Participation";
		String type4OtherClass = PACKAGE_LOCATION_PREFIX + "Type4OtherClass";

		MessagePart messagePart4 = MessagePartBuilder.basicBuilder(type4OtherClass)
				.withRimClass(RimClass.OTHER_CLASS).build();
		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(type3Participation)
				.withRimClass(RimClass.PARTICIPATION).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(type2Entity)
				.withRimClass(RimClass.ENTITY).build();
		MessagePart messagePartChoice2 = MessagePartBuilder.basicBuilder(choiceC2)
				.withRimClass(RimClass.ACT)
				.withAssociation("name", type4OtherClass).build();
		MessagePart messagePartChoice1 = MessagePartBuilder.basicBuilder(choiceC1)
				.withRimClass(RimClass.ACT)
				.withAssociation("name", type3Participation).build();
		MessagePart rootMessagePartChoice = MessagePartBuilder.basicBuilder(rootTypeActChoice)
				.asAbstract(true).withRimClass(RimClass.ACT)
				.withSpecChild(choiceC1)
				.withSpecChild(choiceC2)
				.withAssociation("name", type2Entity).build();

		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, rootMessagePartChoice)
				.withMessagePart(messagePartChoice1).withMessagePart(messagePartChoice2)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).withMessagePart(messagePart4).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 6, items.size());
		assertLogicalX(rootTypeActChoice, 0, items);
		assertLogicalY(rootTypeActChoice, 1, items);
		assertHeight(rootTypeActChoice, 3, items);
		assertInboundAssociationNull(rootTypeActChoice, items);
		assertEncroachmentLevel(rootTypeActChoice, 0, items);

		assertLogicalX(choiceC1, 0, items);
		assertLogicalY(choiceC1, 2, items);
		assertHeight(choiceC1, 1, items);
		assertInboundAssociationNull(choiceC1, items);
		assertEncroachmentLevel(choiceC1, 0, items);

		assertLogicalX(choiceC2, 0, items);
		assertLogicalY(choiceC2, 3, items);
		assertHeight(choiceC2, 1, items);
		assertInboundAssociationNull(choiceC2, items);
		assertEncroachmentLevel(choiceC2, 0, items);
		
		assertLogicalX(type2Entity, 1, items);
		assertLogicalY(type2Entity, 1, items);
		assertHeight(type2Entity, 1, items);
		assertInboundArrowDepth(type2Entity, 1, items);
		assertEncroachmentLevel(type2Entity, 0, items);
		
		assertLogicalX(type3Participation, 1, items);
		assertLogicalY(type3Participation, 2, items);
		assertHeight(type3Participation, 1, items);
		assertInboundArrowDepth(type3Participation, 0, items);
		assertEncroachmentLevel(type3Participation, 1, items);

		assertLogicalX(type4OtherClass, 1, items);
		assertLogicalY(type4OtherClass, 3, items);
		assertHeight(type4OtherClass, 1, items);
		assertInboundArrowDepth(type4OtherClass, 1, items);
		assertEncroachmentLevel(type4OtherClass, 1, items);

	}
	
	//            +-> B.MyType3 (CMET) +-> B.MyType4 (Don't render because parent is CMET)
	//  A.MyType -+
	//            +-> A.MyType2
	@Test
	public void shouldNotLayoutChildrenOfCmets() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myType2 = PACKAGE_LOCATION_PREFIX + "MyType2";
		String myType3 = PACKAGE_LOCATION_OTHER_PREFIX + "MyType3";
		String myType4 = PACKAGE_LOCATION_OTHER_PREFIX + "MyType4";

		MessagePart messagePart4 = MessagePartBuilder.basicBuilder(myType4).build();
		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(myType3)
				.withAssociation("childOfCmet", myType4).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myType2).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withAssociation("thirdThing", myType3)
				.withAssociation("name", myType2).build();

		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).build();
		PackageLocation otherPackageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME_OTHER, messagePart3)
				.withMessagePart(messagePart4).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).withPackageLocation(otherPackageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 3, items.size());
		assertLogicalX(myType, 0, items);
		assertHeight(myType, 2, items);
		assertIsNotCmet(myType, items);
		
		assertLogicalX(myType2, 1, items);
		assertLogicalY(myType2, 2, items);
		assertIsNotCmet(myType2, items);
		
		assertLogicalX(myType3, 1, items);
		assertLogicalY(myType3, 1, items);
		assertIsCmet(myType3, items);
	}

	// MyType -> MyTemplateParameter 
	@Test
	public void shouldLayoutTemplateRelationshipPreMifFidelity() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withTemplateRelationship("myTemplateRelationship", "MyTemplateParameter").build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		
		//Check Message Part Layout Items
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());
		assertEquals("item count", 2, items.size());
		assertLogicalX(myType, 0, items);
		assertLogicalY(myType, 1, items);
		assertInboundAssociationNull(myType, items);
		assertLogicalX(PACKAGE_LOCATION_PREFIX + "MyTemplateParameter", 1, items);
		assertInboundArrowDepth(PACKAGE_LOCATION_PREFIX + "MyTemplateParameter", 0, items);
	}

	// MyType -> MyTemplateParameterType 
	@Test
	public void shouldLayoutTemplateRelationshipPostMifFidelity() {
		
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		String myTemplateParameterType = PACKAGE_LOCATION_PREFIX + "MyTemplateParameterType";
		
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myTemplateParameterType).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withTemplateRelationship("myTemplateRelationship", "MyTemplateParameterType").build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		
		//Check Message Part Layout Items
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());
		assertEquals("item count", 2, items.size());
		assertLogicalX(myType, 0, items);
		assertLogicalY(myType, 1, items);
		assertInboundAssociationNull(myType, items);
		assertLogicalX(myTemplateParameterType, 1, items);
		assertInboundArrowDepth(myTemplateParameterType, 0, items);
	}

	// MyType -> MyCycleBackType 
	@Test
	public void shouldLayoutBasicCylicRelationship() {
		
		String myCycleBackType = PACKAGE_LOCATION_PREFIX + "MyCycleBackType";
		String myType = PACKAGE_LOCATION_PREFIX + "MyType";
		
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(myCycleBackType)
				.withAssociation("backToMyType", myType).build();
		MessagePart messagePart1 = MessagePartBuilder.basicBuilder(myType)
				.withAssociation("toMyCycleBackType", myCycleBackType).build();
		
		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, messagePart1)
				.withMessagePart(messagePart2).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		
		//Check Message Part Layout Items
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());
		assertEquals("item count", 2, items.size());
		assertLogicalX(myType, 0, items);
		assertLogicalY(myType, 1, items);
		assertInboundAssociationNull(myType, items);
		assertIsNotCyclic(myType, items);
		
		assertLogicalX(myCycleBackType, 1, items);
		assertInboundArrowDepth(myCycleBackType, 0, items);
		assertIsCyclic(myCycleBackType, items);
	}

	//											<---------|
	//  RootTypeActChoice  -> Type2CycleBackToChoice -----
	//
	//		ChoiceC1 --------> Type3Participation
	//
	//		ChoiceC2 --------> Type4CycleBackToChoiceC2 --|
	//     										<----------     		
	@Test
	public void shouldLayoutCycleBackToChoice() {
		String rootTypeActChoice = PACKAGE_LOCATION_PREFIX + "RootTypeActChoice";
		String choiceC1 = PACKAGE_LOCATION_PREFIX + "ChoiceC1";
		String choiceC2 = PACKAGE_LOCATION_PREFIX + "ChoiceC2";
		String type2CycleBackToChoice = PACKAGE_LOCATION_PREFIX + "Type2CycleBackToChoice";
		String type3Participation = PACKAGE_LOCATION_PREFIX + "Type3Participation";
		String type4CycleBackToChoiceC2 = PACKAGE_LOCATION_PREFIX + "Type4CycleBackToChoiceC2";

		MessagePart messagePart4 = MessagePartBuilder.basicBuilder(type4CycleBackToChoiceC2)
				.withRimClass(RimClass.PARTICIPATION)
				.withAssociation("cycleBackToChoiceC2", choiceC2).build();
		MessagePart messagePart3 = MessagePartBuilder.basicBuilder(type3Participation)
				.withRimClass(RimClass.PARTICIPATION).build();
		MessagePart messagePart2 = MessagePartBuilder.basicBuilder(type2CycleBackToChoice)
				.withRimClass(RimClass.PARTICIPATION)
				.withAssociation("cycleBackToChoice", rootTypeActChoice).build();
		MessagePart messagePartChoice2 = MessagePartBuilder.basicBuilder(choiceC2)
				.withRimClass(RimClass.ACT)
				.withAssociation("name", type4CycleBackToChoiceC2).build();
		MessagePart messagePartChoice1 = MessagePartBuilder.basicBuilder(choiceC1)
				.withRimClass(RimClass.ACT)
				.withAssociation("name", type3Participation).build();
		MessagePart rootMessagePartChoice = MessagePartBuilder.basicBuilder(rootTypeActChoice)
				.asAbstract(true).withRimClass(RimClass.ACT)
				.withSpecChild(choiceC1)
				.withSpecChild(choiceC2)
				.withAssociation("name", type2CycleBackToChoice).build();

		PackageLocation packageLocation = PackageLocationBuilder.basicBuilder(PACKAGE_LOCATION_NAME, rootMessagePartChoice)
				.withMessagePart(messagePartChoice1).withMessagePart(messagePartChoice2)
				.withMessagePart(messagePart2).withMessagePart(messagePart3).withMessagePart(messagePart4).build();
		MessageSet messageSet = MessageSetBuilder.basicBuilder(packageLocation).build();

		Layout layout = new LayerOuter().layout(messageSet, PACKAGE_LOCATION_NAME);
		Map<String, MessagePartLayoutItem> items = buildMap(layout.getMessagePartLayoutItems());

		assertEquals("item count", 6, items.size());
		

		assertLogicalX(rootTypeActChoice, 0, items);
		assertLogicalY(rootTypeActChoice, 1, items);
		assertHeight(rootTypeActChoice, 3, items);
		assertInboundAssociationNull(rootTypeActChoice, items);
		assertEncroachmentLevel(rootTypeActChoice, 0, items);
		assertIsNotCyclic(rootTypeActChoice, items);
		assertEncroachmentLevelEnd(rootTypeActChoice, 0, items);

		assertLogicalX(choiceC1, 0, items);
		assertLogicalY(choiceC1, 2, items);
		assertHeight(choiceC1, 1, items);
		assertInboundAssociationNull(choiceC1, items);
		assertEncroachmentLevel(choiceC1, 0, items);
		assertIsNotCyclic(choiceC1, items);
		assertEncroachmentLevelEnd(choiceC1, 0, items);

		assertLogicalX(choiceC2, 0, items);
		assertLogicalY(choiceC2, 3, items);
		assertHeight(choiceC2, 1, items);
		assertInboundAssociationNull(choiceC2, items);
		assertEncroachmentLevel(choiceC2, 0, items);
		assertIsNotCyclic(choiceC2, items);
		assertEncroachmentLevelEnd(choiceC2, 0, items);
	
		assertLogicalX(type2CycleBackToChoice, 1, items);
		assertLogicalY(type2CycleBackToChoice, 1, items);
		assertHeight(type2CycleBackToChoice, 1, items);
		assertInboundArrowDepth(type2CycleBackToChoice, 0, items);
		assertEncroachmentLevel(type2CycleBackToChoice, 0, items);
		assertIsCyclic(type2CycleBackToChoice, items);
		assertEncroachmentLevelEnd(type2CycleBackToChoice, 0, items);
		
		assertLogicalX(type3Participation, 1, items);
		assertLogicalY(type3Participation, 2, items);
		assertHeight(type3Participation, 1, items);
		assertInboundArrowDepth(type3Participation, 0, items);
		assertEncroachmentLevel(type3Participation, 1, items);
		assertIsNotCyclic(type3Participation, items);
		assertEncroachmentLevelEnd(type3Participation, 0, items);

		assertLogicalX(type4CycleBackToChoiceC2, 1, items);
		assertLogicalY(type4CycleBackToChoiceC2, 3, items);
		assertHeight(type4CycleBackToChoiceC2, 1, items);
		assertInboundArrowDepth(type4CycleBackToChoiceC2, 0, items);
		assertEncroachmentLevel(type4CycleBackToChoiceC2, 1, items);
		assertIsCyclic(type4CycleBackToChoiceC2, items);
		assertEncroachmentLevelEnd(type4CycleBackToChoiceC2, 1, items);

	}

}
