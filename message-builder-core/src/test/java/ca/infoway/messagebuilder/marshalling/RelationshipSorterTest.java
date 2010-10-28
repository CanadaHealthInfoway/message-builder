package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
		assertEquals("property name", "type2", ((BeanProperty) object).getName());

		Relationship otherRelationship = new Relationship(
				"theType", "MOCK_MT123456CA.SubType", Cardinality.create("1"));
		Object otherObject = sorter.get(otherRelationship);
		assertNotNull("other type exists", otherObject);
		assertTrue("other type", otherObject instanceof BeanProperty);
		assertEquals("other property name", "type", ((BeanProperty) otherObject).getName());
	}
}
