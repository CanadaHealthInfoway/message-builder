package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;

public class PropertyGeneratorBuildersCardinalityChangedTest {
	
	@Rule
	public final JMockMockeryRule jmock = new JMockMockeryRule();
	
	private ClassNameManager manager;
	private BaseRelationshipNameResolver nameResolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.nameResolver = this.jmock.mock(BaseRelationshipNameResolver.class);
	}

	@Test @Ignore
	public void shouldGenerateCardinalityChangeFromMultipleToSingleAssociation() throws Exception {
		final Association originalRelationship = new AssociationBuilder()
			.setName("beans")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 5))
			.buildStandard();

		final Association newRelationship = new AssociationBuilder()
			.setName("beans")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("beans"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("bean")); 
			atLeast(1).of(manager).getRepresentationOfType(newRelationship.getAssociationType()); will(returnValue("FooBean"));
		}});
		
		RegeneratedAssociationImpl association = new RegeneratedAssociationImpl(originalRelationship, newRelationship);
		
		StringWriter writer = new StringWriter();
		generate(writer, createMultipleToSingleGenerator(association));
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("list field", output.contains("private List<FooBean> beans = new ArrayList<FooBean>()"));
		assertTrue("list annotation", output.contains("@Hl7XmlMapping({\"beans\"})"));
		assertTrue("list getter", output.contains("public List<FooBean> getBeans()"));
		assertFalse("no list setter", output.contains("public void setBeans(FooBean"));
		
		assertTrue("getter", output.contains("public FooBean getBean()"));
		assertTrue("setter", output.contains("public void setBean(FooBean"));
		assertTrue("getter body", output.contains("getBeans().isEmpty() ? null : getBeans().iterator().next()"));
		assertTrue("setter body", output.contains("getBeans().clear(); getBeans().add(bean)"));
		assertFalse("no annotation", output.contains("@Hl7XmlMapping({\"beans\"})\npublic FooBean getBean() {"));
	}

	private void generate(StringWriter writer, PropertyGenerator generator) throws IOException {
		generator.createAttributeDefinition(0, writer);
		generator.createGettersAndSetters(0, writer);
	}

	private PropertyGenerator createMultipleToSingleGenerator(RegeneratedAssociationImpl association) {
		return null;
	}

	@Test @Ignore
	public void shouldGenerateCardinalityChangeFromSingleToMultipleAssociation() throws Exception {
		final Association originalRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 1))
			.buildStandard();

		final Association newRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 5))
			.buildStandard();

		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("bean"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("beans")); 
			atLeast(1).of(manager).getRepresentationOfTypeName(new TypeName("FooBean")); will(returnValue("FooBean"));
		}});

		RegeneratedAssociationImpl association = new RegeneratedAssociationImpl(originalRelationship, newRelationship);

		StringWriter writer = new StringWriter();
		generate(writer, createSingleToMultipleGenerator(association));

		String output = writer.toString();  
		System.out.println(output);

		assertTrue("list field", output.contains("private List<FooBean> beans = new ArrayList<FooBean>()"));
		assertTrue("list annotation", output.contains("@Hl7XmlMapping({\"bean\"})"));
		assertTrue("list getter", output.contains("public List<FooBean> getBeans()"));
		assertFalse("no list setter", output.contains("public void setBeans(FooBean"));

		assertTrue("getter", output.contains("public FooBean getBean()"));
		assertTrue("setter", output.contains("public void setBean(FooBean"));
		assertTrue("getter body", output.contains("getBeans().isEmpty() ? null : getBeans().iterator().next()"));
		assertTrue("setter body", output.contains("getBeans().clear(); getBeans().add(bean)"));
		assertFalse("no annotation", output.contains("@Hl7XmlMapping({\"beans\"})\npublic FooBean getBean() {"));
	}	

	private PropertyGenerator createSingleToMultipleGenerator(RegeneratedAssociationImpl association) {
		return PropertyGeneratorBuilders.newAssociationCardinalityChangedFromSingleToMultipleBuilder(association).build(manager, nameResolver);
	}
	
}
