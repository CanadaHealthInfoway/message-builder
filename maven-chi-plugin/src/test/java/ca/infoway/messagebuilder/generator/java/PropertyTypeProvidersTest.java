package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class PropertyTypeProvidersTest {
	
	private Mockery jmock = new Mockery();
	private ClassNameManager manager;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
	}
	
	@Test
	public void shouldUseCsharpConstructs() throws Exception {
		
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName("System.String"); will(returnValue("String"));
		}});
		
		Relationship relationship = new Relationship("text", "ST", Cardinality.create("1"));
		DataType dataType = new TypeConverter().convertToType(relationship);
		
		Attribute attribute = new Attribute(relationship, dataType);
		PropertyTypeProviders.Attribute provider = new PropertyTypeProviders.Attribute(attribute, C_SHARP);
		
		assertEquals("type", "String", provider.getType(this.manager));
	}
}
