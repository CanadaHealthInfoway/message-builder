package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyGeneratorBuildersAssociationTest {

	@Rule
	public final JMockMockeryRule jmock = new JMockMockeryRule();
	
	private ClassNameManager manager;
	private BaseRelationshipNameResolver nameResolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.nameResolver = this.jmock.mock(BaseRelationshipNameResolver.class);
		this.jmock.checking(new Expectations() {{
			allowing(nameResolver).getName(with(any(BaseRelationship.class))); will(returnValue("relationshipName"));
		}});
	}
	
	@Test
	public void shouldSingleCardinalityAssociation() throws Exception {
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(manager).getRepresentationOfClassName("ca.infoway.test.Foo");
				will(returnValue("FooBean"));
		}});
		
		Association beanRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(1, 1))
			.setLanguageSpecificName("ca.infoway.test", "Foo")
			.buildStandard();
		
		StringWriter writer = new StringWriter();
		
		generate(beanRelationship, writer);
		
		String output = writer.toString();  
		
		assertTrue("field", output.contains("private FooBean relationshipName"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"bean\"})"));
		assertTrue("getter", output.contains("public FooBean getRelationshipName()"));
		assertTrue("setter", output.contains("public void setRelationshipName(FooBean"));
	}

	@Test
	public void shouldMultipleCardinalityAssociation() throws Exception {
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(manager).getRepresentationOfClassName("ca.infoway.test.Foo");
				will(returnValue("FooBean"));
		}});
		
		Association beanRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 5))
			.setLanguageSpecificName("ca.infoway.test", "Foo")
			.buildStandard();
		
		StringWriter writer = new StringWriter();
		
		generate(beanRelationship, writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("field", output.contains("private List<FooBean> relationshipName = new ArrayList<FooBean>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"bean\"})"));
		assertTrue("getter", output.contains("public List<FooBean> getRelationshipName()"));
		assertFalse("no setter", output.contains("public void setRelationshipName(FooBean"));
	}

	private void generate(Association association, StringWriter writer) throws IOException {
		PropertyGenerator propertyGenerator = PropertyGeneratorBuilders.newAssociationBuilder(JAVA, association).build(this.manager, this.nameResolver);
		propertyGenerator.createAttributeDefinition(0, writer);
		propertyGenerator.createGettersAndSetters(0, writer);
	}
	
}
