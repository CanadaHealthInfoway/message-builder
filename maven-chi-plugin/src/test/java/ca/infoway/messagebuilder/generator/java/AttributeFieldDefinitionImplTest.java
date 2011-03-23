package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class AttributeFieldDefinitionImplTest {
	
	private Mockery jmock = new Mockery();
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.resolver = this.jmock.mock(BaseRelationshipNameResolver.class);
		
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(String.class.getName()); 
				will(returnValue(String.class));
		}});
	}
	
	@Test
	public void shouldDefineBasicAttribute() throws Exception {
		Relationship relationship = new Relationship("text", "ST", Cardinality.create("1"));
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.C_SHARP);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "ST", field.getFieldType());
		assertEquals("implementation type", "STImpl", field.getFieldImplementationType());
		assertEquals("property type", "String", field.getPropertyType());
		assertEquals("getter body", GetterBodyStyle.ATTRIBUTE, field.getGetterBodyStyle());
	}
	
	@Test
	public void shouldDefineInlinedAttribute() throws Exception {
		Relationship relationship = new Relationship("text", "ST", Cardinality.create("1"));
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		InlinedAttribute outer = new InlinedAttribute(attribute, 
				new Association(
					new Relationship("component", "ABCD_MT123456CA.Component", Cardinality.create("0-10")), 
					new Type(new TypeName("ABCD_MT123456CA.Component"))));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(outer, ProgrammingLanguage.C_SHARP);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("itype", "IList<ST>", field.getFieldType());
		assertEquals("implementation type", "List<ST>", field.getFieldImplementationType());
		assertEquals("property type", "IList<String>", field.getPropertyType());
		assertEquals("property type", "String", field.getPropertyElementImplementationType());
		assertEquals("getter body", GetterBodyStyle.ASSOCIATION_COLLAPSED_TO_ATTRIBUTE, field.getGetterBodyStyle());
	}
	
	@Test
	public void shouldDefineCollectionAttribute() throws Exception {
		Relationship relationship = new Relationship("text", "SET<ST>", Cardinality.create("5"));
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.C_SHARP);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "SET<ST, String>", field.getFieldType());
		assertEquals("implementation type", "SETImpl<ST, String>", field.getFieldImplementationType());
		assertEquals("constructor args", "typeof(STImpl)", field.getInitializationArguments());
		assertEquals("getter body", GetterBodyStyle.ATTRIBUTE_SET, field.getGetterBodyStyle());
	}
	
	@Test
	public void shouldDefineCollectionAttributeForJava() throws Exception {
		Relationship relationship = new Relationship("text", "SET<ST>", Cardinality.create("5"));
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "SET<ST, String>", field.getFieldType());
		assertEquals("implementation type", "SETImpl<ST, String>", field.getFieldImplementationType());
		assertEquals("constructor args", "STImpl.class", field.getInitializationArguments());
		assertEquals("getter body", GetterBodyStyle.ATTRIBUTE_SET, field.getGetterBodyStyle());
	}
	
	@Test
	public void shouldDefineCollectionOfCodesAttribute() throws Exception {
		Relationship relationship = new Relationship("text", "SET<CV>", Cardinality.create("5"));
		relationship.setDomainType("ActCode");
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.C_SHARP);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "SET<CV, Code>", field.getFieldType());
		assertEquals("implementation type", "SETImpl<CV, Code>", field.getFieldImplementationType());
		assertEquals("constructor args", "typeof(CVImpl)", field.getInitializationArguments());
		assertEquals("getter body", GetterBodyStyle.CODED_ATTRIBUTE_SET, field.getGetterBodyStyle());
	}
	
	@Test
	public void shouldDefineCollectionOfCodesAttributeForJava() throws Exception {
		Relationship relationship = new Relationship("text", "SET<CV>", Cardinality.create("5"));
		relationship.setDomainType("ActCode");
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "SET<CV, Code>", field.getFieldType());
		assertEquals("implementation type", "SETImpl<CV, Code>", field.getFieldImplementationType());
		assertEquals("constructor args", "CVImpl.class", field.getInitializationArguments());
	}
	
	@Test
	public void shouldDefineCodeAttribute() throws Exception {
		Relationship relationship = new Relationship("text", "CV", Cardinality.create("1"));
		relationship.setDomainType("ActCode");
		Attribute attribute = new Attribute(relationship, new TypeConverter().convertToType(relationship));
		
		AttributeFieldDefinitionImpl field = new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.C_SHARP);
		field.initializeContext(this.manager, this.resolver);
		
		assertEquals("type", "CV", field.getFieldType());
		assertEquals("type", "ActCode", field.getPropertyType());
		assertEquals("implementation type", "CVImpl", field.getFieldImplementationType());
		assertEquals("constructor args", "", field.getInitializationArguments());
		assertEquals("getter body", GetterBodyStyle.CODED_ATTRIBUTE, field.getGetterBodyStyle());
	}
}
