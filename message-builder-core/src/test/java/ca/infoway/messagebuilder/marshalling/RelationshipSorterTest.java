package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;

public class RelationshipSorterTest {

	@Test
	public void shouldHandleCollapsedProperties() throws Exception {
		RelationshipSorter sorter = RelationshipSorter.create("", new MockMessageBean());
		
		assertNotNull("type exists", sorter.get("theType"));
		assertTrue("type", sorter.get("theType") instanceof BeanProperty);
		
		sorter = RelationshipSorter.create("", new MockSubType());
		
		assertNotNull("component exists", sorter.get("component"));
		assertTrue("component", sorter.get("component") instanceof RelationshipSorter);
		
		RelationshipSorter deviceSorter = (RelationshipSorter) sorter.get("component");
		
		System.out.println(deviceSorter.keySet());
		assertNotNull("id exists", deviceSorter.get("subject3"));
	}
}
