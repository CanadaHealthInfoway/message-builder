package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_RENAMED;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Relationship;



public class XmlMappingHelperTest {

	private Relationship relationship;

	@Before
	public void setUp() {
		this.relationship = new Relationship("name", "ABCD_MT123456CA.PatientName", Cardinality.create("1"));
		
	}
	
	@Test
	public void shouldGetSimpleXmlName() throws Exception {
		String[] mappings = new XmlMappingHelper(this.relationship).getAllXmlMappings();
		assertEquals("count", 1, mappings.length);
		assertEquals("mapping", "name", mappings[0]);
	}
	
	@Test
	public void shouldGetXmlNameOnRelationshipWithDifferences() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		String[] mappings = new XmlMappingHelper(this.relationship).getAllXmlMappings();
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name", "oldName")).containsAll(asList(mappings)));
	}
	
	@Test
	public void shouldConcatSimpleXmlName() throws Exception {
		XmlMappingHelper newHelper = new XmlMappingHelper(this.relationship).concat(
				new XmlMappingHelper(new Relationship("value", "PN", Cardinality.create("1"))));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("count", 1, mappings.length);
		assertEquals("mapping", "name/value", mappings[0]);
	}
	
	@Test
	public void shouldConcatXmlNameWithDifferences() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		Relationship valueRelationship = new Relationship("value", "PN", Cardinality.create("1"));
		valueRelationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldValue"),
				new DifferenceValue("MR2009", "value")));
		XmlMappingHelper newHelper = new XmlMappingHelper(this.relationship).concat(
				new XmlMappingHelper(valueRelationship));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name/value", "oldName/oldValue")).containsAll(asList(mappings)));
	}
	
	@Test
	public void shouldConcatXmlNameWithNestedDifferences() throws Exception {
		Relationship topRelationship = new Relationship("patient", "ABCD_MT123456CA.Patient", Cardinality.create("1"));
		
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		Relationship valueRelationship = new Relationship("value", "PN", Cardinality.create("1"));
		valueRelationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldValue"),
				new DifferenceValue("MR2009", "value")));
		XmlMappingHelper newHelper = 
				new XmlMappingHelper(topRelationship).concat(
						new XmlMappingHelper(this.relationship).concat(
								new XmlMappingHelper(valueRelationship)));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("patient/name/value", "patient/oldName/oldValue")).containsAll(asList(mappings)));
	}
	
	@Test
	public void shouldConcatXmlNameWhereOnlyOneRelationshipHasDifferences() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		XmlMappingHelper newHelper = new XmlMappingHelper(this.relationship).concat(
				new XmlMappingHelper(new Relationship("value", "PN", Cardinality.create("1"))));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name/value", "oldName/value")).containsAll(asList(mappings)));
	}
}
