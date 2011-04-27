/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

public class RelationshipSorterTest {

	@Test
	public void shouldHandleCollapsedProperties() throws Exception {
		RelationshipSorter sorter = RelationshipSorter.create("", new MockMessageBean());

		Relationship relationship = new Relationship(
				"theType", "MOCK_MT898989CA.SubType", Cardinality.create("1"));
		
		assertNotNull("type exists", sorter.get(relationship));
		assertTrue("type", sorter.get(relationship) instanceof BeanProperty);
		
		sorter = RelationshipSorter.create("", new MockSubType());
		
		relationship = new Relationship(
				"component", "MOCK_MT123456CA.Component", Cardinality.create("1"));

		assertNotNull("component exists", sorter.get(relationship));
		assertTrue("component", sorter.get(relationship) instanceof RelationshipSorter);
		
		RelationshipSorter deviceSorter = (RelationshipSorter) sorter.get(relationship);
		
		assertNotNull("id exists", deviceSorter.get(new Relationship(
				"subject3", "MOCK_MT123456CA.Subject6", Cardinality.create("1"))));
	}
	
	@Test
	public void shouldHandlePropertiesWithMapByPartType() throws Exception {
		RelationshipSorter sorter = RelationshipSorter.create("", new MockMultiplyMappedMessagePartBean());
		
		Relationship relationship = new Relationship(
				"theType", "MOCK_MT898989CA.SubType", Cardinality.create("1"));
		Object object = sorter.get(relationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property name", "type2", object);
		
		Relationship otherRelationship = new Relationship(
				"theType", "MOCK_MT123456CA.SubType", Cardinality.create("1"));
		Object otherObject = sorter.get(otherRelationship);
		assertNotNull("other type exists", otherObject);
		assertTrue("other type", otherObject instanceof BeanProperty);
		assertPropertyNamesEqual("other property name", "type", otherObject);
	}
	
	@Test
	public void shouldHandleCompoundPropertiesWithMapByPartType() throws Exception {
		RelationshipSorter sorter = RelationshipSorter.create("", new MockMultiplyCompoundMappedMessagePartBean());
		
		Relationship relationship1 = new Relationship(
				"theType", "MOCK_MT123458CA.SubTypeA", Cardinality.create("1"));
		
		Relationship relationship2 = new Relationship(
				"theSubType", "MOCK_MT123457CA.SubTypeB", Cardinality.create("1"));
		
		Relationship relationship3 = new Relationship(
				"theSubSubType", "MOCK_MT898989CA.SubType", Cardinality.create("1"));
		
		// first level
		Object object = sorter.get(relationship1);
		assertNotNull("exists", object);
		assertTrue("type", object instanceof RelationshipSorter);
		
		RelationshipSorter tempSorter = (RelationshipSorter) object; 
		
		// second level
		object = tempSorter.get(relationship2);
		assertNotNull("exists", object);
		assertTrue("type", object instanceof RelationshipSorter);

		tempSorter = (RelationshipSorter) object; 

		// third level
		object = tempSorter.get(relationship3);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property name", "type2", object);

		Relationship otherRelationship1 = new Relationship(
				"theType", "MOCK_MT123458CA.SubTypeA", Cardinality.create("1"));
		
		Relationship otherRelationship2 = new Relationship(
				"theSubType", "MOCK_MT123457CA.SubTypeB", Cardinality.create("1"));
		
		Relationship otherRelationship3 = new Relationship(
				"theSubSubType", "MOCK_MT123456CA.SubType", Cardinality.create("1"));
		
		// first level
		object = sorter.get(otherRelationship1);
		assertNotNull("other exists", object);
		assertTrue("other type", object instanceof RelationshipSorter);
		
		tempSorter = (RelationshipSorter) object; 
		
		// second level
		object = tempSorter.get(otherRelationship2);
		assertNotNull("other exists", object);
		assertTrue("other type", object instanceof RelationshipSorter);

		tempSorter = (RelationshipSorter) object; 

		// third level
		object = tempSorter.get(otherRelationship3);
		assertNotNull("other type exists", object);
		assertTrue("other type", object instanceof BeanProperty);
		assertPropertyNamesEqual("other property name", "type", object);
		
	}
	
	@Test
	public void shouldHandleInlinedPropertiesWithMapByPartTypeAndWithout() throws Exception {
		RelationshipSorter sorter = RelationshipSorter.create("", new MockMultiplyCompoundNestedMappedMessagePartBean());
		
		Relationship organizationInMapByPartTypeRelationship = new Relationship(
				"representedOrganization", "COCT_MT090102CA.Organization", Cardinality.create("1"));

		Relationship organizationNotInMapByPartTypeRelationship = new Relationship(
				"representedOrganization", "MOCK_MT090102CA.Organization", Cardinality.create("1"));

		Relationship assignedOrganizationInMapByPartTypeRelationship = new Relationship(
				"assignedOrganization", "COCT_MT260030CA.Organization", Cardinality.create("1"));
		
		Relationship nameRelationship = new Relationship(
				"name", "ST", Cardinality.create("1"));
		
		Relationship idRelationship = new Relationship(
				"id", "II", Cardinality.create("1"));
		
		Relationship otherIdRelationship = new Relationship(
				"otherId", "II", Cardinality.create("1"));
		
		// >>>>>>>>>>>>>>>>>>

		Object object = sorter.get(organizationInMapByPartTypeRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof RelationshipSorter);
		
		RelationshipSorter innerSorter = (RelationshipSorter) object;
		
		object = innerSorter.get(nameRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property name", "assignedOrganizationName", object);

		object = innerSorter.get(idRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property id", "organizationIdentifier", object);

		object = innerSorter.get(otherIdRelationship);
		assertNull("type does not exists", object);
		
		// >>>>>>>>>>>>>>>>>>
		
		object = sorter.get(organizationNotInMapByPartTypeRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof RelationshipSorter);
		
		innerSorter = (RelationshipSorter) object;
		
		object = innerSorter.get(nameRelationship);
		assertNull("type does not exist", object);

		object = innerSorter.get(idRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property id", "organizationIdentifier", object);

		object = innerSorter.get(otherIdRelationship);
		assertNull("type does not exist", object);

		// >>>>>>>>>>>>>>>>>>
		
		object = sorter.get(assignedOrganizationInMapByPartTypeRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof RelationshipSorter);
		
		innerSorter = (RelationshipSorter) object;
		
		object = innerSorter.get(nameRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("property name", "assignedOrganizationName", object);

		object = innerSorter.get(idRelationship);
		assertNull("type should not exist", object);

		object = innerSorter.get(otherIdRelationship);
		assertNotNull("type exists", object);
		assertTrue("type", object instanceof BeanProperty);
		assertPropertyNamesEqual("other property id", "otherOrganizationIdentifier", object);

	}

	private void assertPropertyNamesEqual(String message, String expected, Object beanProperty) {
		assertEquals(message, expected.toLowerCase(), getNameFromProperty(beanProperty).toLowerCase());
	}
	
	private String getNameFromProperty(Object beanProperty) {
		return ((BeanProperty) beanProperty).getName();
	}
}
