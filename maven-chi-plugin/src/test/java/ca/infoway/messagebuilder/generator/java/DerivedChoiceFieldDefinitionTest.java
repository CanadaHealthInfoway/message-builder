package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
public class DerivedChoiceFieldDefinitionTest {
	
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
		Relationship choiceRelationship = new Relationship("mainChoice", "ABCD_MT123456CA.Component6", Cardinality.create("1"));
		final Relationship subChoiceRelationship = new Relationship("subChoice", "ABCD_MT123456CA.Component2", Cardinality.create("1"));
		final Association association = Association.createStandardAssociation(choiceRelationship, new Type(new TypeName(choiceRelationship.getType())));
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfTypeName(association.getPropertyTypeName()); will(returnValue("MedicalOrder"));
			allowing(manager).getRepresentationOfTypeName(new TypeName(subChoiceRelationship.getType())); will(returnValue("MedicalOrderSpecialization"));
			allowing(resolver).getName(association); will(returnValue("relatedTo"));
		}});
		DerivedChoiceFieldDefinition field = new DerivedChoiceFieldDefinition(association, 
				new Choice("subChoice", new Type(new TypeName("ABCD_MT123456CA.Component2"))), JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertFalse("not writable", field.isWritable());
		assertEquals("field name", "relatedTo", field.getFieldName());
		assertEquals("property name", "RelatedToAsSubChoice", field.getCapitalizedPropertyName());
		assertEquals("type", "MedicalOrderSpecialization", field.getFieldType());
	}
	
}
