package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

@RunWith(JMock.class)
public class PropertyDefinitionGeneratorTest {

	private Mockery jmock = new Mockery();
	private FieldDefinition fieldDefinition;
	private PropertyDefinitionGenerator csharpPropertyDefinition;
	private PropertyDefinitionGenerator javaPropertyDefinition;
	private StringWriter writer;
	
	@Before
	public void setUp() throws Exception {
		this.fieldDefinition = this.jmock.mock(FieldDefinition.class);
		this.csharpPropertyDefinition = new PropertyDefinitionGenerator(this.fieldDefinition, ProgrammingLanguage.C_SHARP);
		this.javaPropertyDefinition = new PropertyDefinitionGenerator(this.fieldDefinition, ProgrammingLanguage.JAVA);
		this.writer = new StringWriter();
	}
	
	@Test
	public void shouldCreateWritableJavaProperty() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).isWritable(); will(returnValue(true));
			allowing(fieldDefinition).getXmlPathName(); will(returnValue(new String[] {"name/value", "myName/value"}));
			allowing(fieldDefinition).getFieldName(); will(returnValue("myName"));
			allowing(fieldDefinition).getFieldImplementationType(); will(returnValue("STImpl"));
			allowing(fieldDefinition).getFieldType(); will(returnValue("ST"));
			allowing(fieldDefinition).getGetterBodyStyle(); will(returnValue(GetterBodyStyle.ATTRIBUTE));
			allowing(fieldDefinition).getSetterBodyStyle(); will(returnValue(SetterBodyStyle.ATTRIBUTE));
			allowing(fieldDefinition).getCapitalizedPropertyName(); will(returnValue("MyName"));
			allowing(fieldDefinition).getInitializationArguments(); will(returnValue(""));
			allowing(fieldDefinition).getPropertyType(); will(returnValue("String"));
			allowing(fieldDefinition).getFieldElementImplementationType(); will(returnValue("STImpl.class"));
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue("String"));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(null));
		}});
		
		this.javaPropertyDefinition.createPropertyDefinition(1, writer, false);
		
		String output = this.writer.toString();
		assertTrue("getter", output.contains("public String getMyName() {"));
		assertTrue("getter body", output.contains("return this.myName.getValue();"));
	}

	@Test
	public void shouldCreateReadOnlyJavaDerivedChoiceProperty() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).isWritable(); will(returnValue(false));
			allowing(fieldDefinition).isDerivedChoice(); will(returnValue(true));
			allowing(fieldDefinition).getXmlPathName(); will(returnValue(null));
			allowing(fieldDefinition).getFieldName(); will(returnValue("choiceField"));
			allowing(fieldDefinition).getFieldImplementationType(); will(returnValue("UnsureWhatThisIsFor"));
			allowing(fieldDefinition).getFieldType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getGetterBodyStyle(); will(returnValue(GetterBodyStyle.DERIVED_CHOICE));
			allowing(fieldDefinition).getSetterBodyStyle(); will(returnValue(null));
			allowing(fieldDefinition).getCapitalizedPropertyName(); will(returnValue("ChoiceFieldAsSubChoiceField"));
			allowing(fieldDefinition).getInitializationArguments(); will(returnValue(""));
			allowing(fieldDefinition).getPropertyType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getFieldElementImplementationType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue(""));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(GetterBodyStyle.DERIVED_CHOICE_HAS));
		}});
		
		this.javaPropertyDefinition.createPropertyDefinition(1, writer, false);
		
		String output = this.writer.toString();
		assertTrue("getter", output.contains("public SubChoiceType getChoiceFieldAsSubChoiceField() {"));
		assertTrue("getter body", output.contains("return this.choiceField instanceof SubChoiceType ? (SubChoiceType) this.choiceField : null;"));
		assertTrue("has", output.contains("public boolean hasChoiceFieldAsSubChoiceField() {"));
		assertTrue("has body", output.contains("return (this.choiceField instanceof SubChoiceType);"));
	}

}
