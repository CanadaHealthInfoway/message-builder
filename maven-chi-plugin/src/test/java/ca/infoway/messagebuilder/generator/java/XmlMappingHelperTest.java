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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.xml.DifferenceType.RELATIONSHIP_RENAMED;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

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
	public void shouldGetSimpleXmlNameForMergedRelationship() throws Exception {
		String[] mappings = new XmlMappingHelper(this.relationship,
				new Relationship(
						"otherName", "ABCD_MT123456CA.PatientName", 
						Cardinality.create("1"))).getAllXmlMappings();
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name", "otherName")).containsAll(asList(mappings)));
	}
	
	@Test
	public void shouldNotHaveAnyNameAndTypesForSimpleCase() throws Exception {
		Set<NameAndType> nameAndTypes = new XmlMappingHelper(this.relationship).getMapByPartTypeMappings();
		assertEquals("count", 0, nameAndTypes.size());
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
	public void shouldGetXmlNameOnRelationshipWithDifferencesAndMergedRelationship() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		String[] mappings = new XmlMappingHelper(this.relationship,
				new Relationship("otherName", "ABCD_MT123456CA.PatientName", 
						Cardinality.create("1"))).getAllXmlMappings();
		assertEquals("count", 3, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name", "oldName", "otherName")).containsAll(asList(mappings)));
	}
	
	@Test
	public void shouldGetNameAndTypesForRelationshipWithDifferences() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		Set<NameAndType> nameAndTypes = new XmlMappingHelper(this.relationship).getMapByPartTypeMappings();
		assertEquals("count", 2, nameAndTypes.size());
		assertTrue("first nameAndType", nameAndTypes.contains(new NameAndType("oldName", "ABCD_MT123456CA.PatientName")));
		assertTrue("second nameAndType", nameAndTypes.contains(new NameAndType("name", "ABCD_MT123456CA.PatientName")));
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
	public void shouldConcatSimpleXmlNameAndMergedType() throws Exception {
		XmlMappingHelper newHelper = new XmlMappingHelper(this.relationship,
				new Relationship(
						"otherName", "ABCD_MT123456CA.PatientName", 
						Cardinality.create("1"))).concat(
				new XmlMappingHelper(new Relationship("value", "PN", Cardinality.create("1"))));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name/value", "otherName/value")).containsAll(asList(mappings)));
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
		
		assertEquals("mappings count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name/value", "oldName/oldValue")).containsAll(asList(mappings)));
		
		Set<NameAndType> mapByPartTypeMappings = newHelper.getMapByPartTypeMappings();
		assertEquals("name and type count", 2, mapByPartTypeMappings.size());
		assertTrue("name and type", mapByPartTypeMappings.contains(new NameAndType("name", "ABCD_MT123456CA.PatientName")));
		assertTrue("name and type", mapByPartTypeMappings.contains(new NameAndType("oldName", "ABCD_MT123456CA.PatientName")));
//		assertTrue("name and type", mapByPartTypeMappings.contains(new NameAndType("name/value", "ABCD_MT123456CA.PatientName")));
//		assertTrue("name and type", mapByPartTypeMappings.contains(new NameAndType("oldName/oldValue", "ABCD_MT123456CA.PatientName")));
	}
	
	@Test
	public void shouldConcatXmlNameWithDifferencesBasedOnAssociations() throws Exception {
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		Relationship valueRelationship = new Relationship("value", "ABCD_MT123456CA.Value", Cardinality.create("1"));
		valueRelationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldValue"),
				new DifferenceValue("MR2009", "value")));
		XmlMappingHelper newHelper = new XmlMappingHelper(this.relationship).concat(
				new XmlMappingHelper(valueRelationship));
		String[] mappings = newHelper.getAllXmlMappings();
		
		assertEquals("mappings count", 2, mappings.length);
		assertTrue("mapping", new HashSet<String>(asList("name/value", "oldName/oldValue")).containsAll(asList(mappings)));
		
		Set<NameAndType> mapByPartTypeMappings = newHelper.getMapByPartTypeMappings();
		assertEquals("name and type count", 4, mapByPartTypeMappings.size());
		assertTrue("name and type 1", mapByPartTypeMappings.contains(new NameAndType("name", "ABCD_MT123456CA.PatientName")));
		assertTrue("name and type 2", mapByPartTypeMappings.contains(new NameAndType("oldName", "ABCD_MT123456CA.PatientName")));
		assertTrue("name and type 3", mapByPartTypeMappings.contains(new NameAndType("name/value", "ABCD_MT123456CA.Value")));
		assertTrue("name and type 4", mapByPartTypeMappings.contains(new NameAndType("oldName/oldValue", "ABCD_MT123456CA.Value")));
	}
	
	@Test
	public void shouldConcatXmlNameWithNestedDifferences() throws Exception {
		Relationship topRelationship = new Relationship("patient", "ABCD_MT123456CA.Patient", Cardinality.create("1"));
		
		this.relationship.addDifference(new Difference(RELATIONSHIP_RENAMED, true, 
				new DifferenceValue("MR2007", "oldName"),
				new DifferenceValue("MR2009", "name")));
		
		Relationship valueRelationship = new Relationship("value", "ABCD_MT123456CA.Value", Cardinality.create("1"));
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

		Set<NameAndType> mapByPartTypeMappings = newHelper.getMapByPartTypeMappings();
		assertEquals("name and type count", 5, mapByPartTypeMappings.size());
//		for (NameAndType nameAndType : mapByPartTypeMappings) {
//			System.out.println(nameAndType.getName() + " " + nameAndType.getType());
//		}
		
		assertTrue("name and type 1", mapByPartTypeMappings.contains(new NameAndType("patient", "ABCD_MT123456CA.Patient")));
		assertTrue("name and type 2", mapByPartTypeMappings.contains(new NameAndType("patient/name", "ABCD_MT123456CA.PatientName")));
		assertTrue("name and type 3", mapByPartTypeMappings.contains(new NameAndType("patient/oldName", "ABCD_MT123456CA.PatientName")));
		assertTrue("name and type 4", mapByPartTypeMappings.contains(new NameAndType("patient/name/value", "ABCD_MT123456CA.Value")));
		assertTrue("name and type 5", mapByPartTypeMappings.contains(new NameAndType("patient/oldName/oldValue", "ABCD_MT123456CA.Value")));
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
