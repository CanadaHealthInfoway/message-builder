package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class Case3SimplifierTest {
	
	private Mockery jmock = new JUnit4Mockery();
	private TypeAnalysisResult result;
	private LogUI log;
	private Case3Simplifier simplifier;

	@Before
	public void setUp() throws Exception {
		this.result = new TypeAnalysisResult();
		this.log = this.jmock.mock(LogUI.class);
		this.simplifier = new Case3Simplifier(this.log, this.result);
	}
	
	@Test
	public void shouldRetainOriginalRelationships() throws Exception {
		Type type1 = createType1();
		Type type2 = createType2();

		MergedTypeDescriptor descriptor = new MergedTypeDescriptor();
		descriptor.getMergedTypes().add(type1.getName());
		descriptor.getMergedTypes().add(type2.getName());
		
		Type mergedType = this.simplifier.createMergedType(descriptor);
		
		assertEquals("number of relationships", 4, mergedType.getRelationships().size());
		assertNotNull("id", mergedType.getRelationship("id"));
		assertEquals("collapsed relationships", 2, mergedType.getRelationship("id").getAllRelationships().size());
		
	}

	private Type createType2() {
		Type type = new Type(new TypeName("ABCD_MT898989CA.Patient"));
		type.getRelationships().add(new Attribute(
				new Relationship("id", "II.BUS", Cardinality.create("1")), 
				createDataType("II.BUS")));
		type.getRelationships().add(new Attribute(
				new Relationship("name", "PN", Cardinality.create("1")), 
				createDataType("PN")));
		type.getRelationships().add(new Association(
				new Relationship("person", "ABCD_MT898989CA.Person", Cardinality.create("1")), 
				new Type(new TypeName("ABCD_MT898989CA.Person"))));
		
		this.result.addType(type);
		return type;
	}

	private DataType createDataType(String type) {
		return new TypeConverter().convertToType(type, null);
	}

	private Type createType1() {
		Type type = new Type(new TypeName("ABCD_MT123456CA.Patient"));
		type.getRelationships().add(new Attribute(
				new Relationship("id", "II.BUS", Cardinality.create("1")), 
				createDataType("II.BUS")));
		type.getRelationships().add(new Attribute(
				new Relationship("name", "PN", Cardinality.create("1")), 
				createDataType("PN")));
		Relationship genderRelationship = new Relationship("gender", "CD", Cardinality.create("1"));
		genderRelationship.setDomainType("AdministrativeGender");
		type.getRelationships().add(new Attribute(
				genderRelationship, 
				createDataType("CD")));

		this.result.addType(type);
		return type;
	}
}
