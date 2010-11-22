package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class AssociationFieldDefinitionTest {
	
	private Mockery jmock = new Mockery();
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.resolver = this.jmock.mock(BaseRelationshipNameResolver.class);
	}
	
	@Test
	public void shouldProvideData() throws Exception {
		Relationship relationship = new Relationship("component", "ABCD_MT123456CA.Component6", Cardinality.create("1"));
		final Association association = Association.createStandardAssociation(relationship, new Type(new TypeName(relationship.getType())));
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfTypeName(association.getPropertyTypeName()); will(returnValue("MedicalOrder"));
			allowing(resolver).getName(association); will(returnValue("relatedTo"));
		}});
		AssociationFieldDefinition field = new AssociationFieldDefinition(association, JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("name", "relatedTo", field.getFieldName());
		assertEquals("type", "MedicalOrder", field.getFieldType());
		assertArrayEquals("xmlMappings", new String[] { "component" }, field.getXmlPathName());
		assertTrue("writable", field.isWritable());
	}
	
	@Test
	public void shouldProvideDataForTemplateType() throws Exception {
		Relationship relationship = new Relationship("parameterList", null, Cardinality.create("1"));
		relationship.setTemplateParameterName("ParameterList");
		final Association association = new Association(relationship, new TemplateVariable("PL"));
		this.jmock.checking(new Expectations() {{
			allowing(resolver).getName(association); will(returnValue("parameterList"));
		}});
		AssociationFieldDefinition field = new AssociationFieldDefinition(association, JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("name", "parameterList", field.getFieldName());
		assertEquals("type", "PL", field.getFieldType());
		assertArrayEquals("xmlMappings", new String[] { "parameterList" }, field.getXmlPathName());
		assertTrue("writable", field.isWritable());
	}
	
	@Test
	public void shouldProvideDataForGenericType() throws Exception {
		Relationship relationship = new Relationship("component", "ABCD_MT123456CA.Component6", Cardinality.create("1"));
		Type associationType = new Type(new TypeName(relationship.getType()));
		associationType.getRelationships().add(new Association(new Relationship(), new TemplateVariable("ACT")));
		final Association association = Association.createStandardAssociation(relationship, associationType);
		
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfTypeName(association.getPropertyTypeName()); will(returnValue("Subject"));
			allowing(resolver).getName(association); will(returnValue("subject"));
		}});
		AssociationFieldDefinition field = new AssociationFieldDefinition(association, JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("name", "subject", field.getFieldName());
		assertEquals("type", "Subject<ACT>", field.getFieldType());
		assertArrayEquals("xmlMappings", new String[] { "component" }, field.getXmlPathName());
		assertTrue("writable", field.isWritable());
	}
}
