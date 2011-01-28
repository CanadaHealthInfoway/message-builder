package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 *	@sharpen.ignore 
 */
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
		assertEquals("property name", "type2", ((BeanProperty) object).getName());

		Relationship otherRelationship = new Relationship(
				"theType", "MOCK_MT123456CA.SubType", Cardinality.create("1"));
		Object otherObject = sorter.get(otherRelationship);
		assertNotNull("other type exists", otherObject);
		assertTrue("other type", otherObject instanceof BeanProperty);
		assertEquals("other property name", "type", ((BeanProperty) otherObject).getName());
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
		assertEquals("property name", "type2", ((BeanProperty) object).getName());

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
		assertEquals("other property name", "type", ((BeanProperty) object).getName());
		
	}
}
