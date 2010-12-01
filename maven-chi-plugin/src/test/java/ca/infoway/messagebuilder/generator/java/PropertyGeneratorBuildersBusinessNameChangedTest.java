package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyGeneratorBuildersBusinessNameChangedTest {

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
	public void shouldGenerateSingleCardinalityAssociation() throws Exception {
		final Association originalRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 1))
			.setBusinessName("oldBusinessName")
			.buildStandard();

		final Association newRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 1))
			.setBusinessName("newBusinessName")
			.buildStandard();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("oldBusinessName"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("newBusinessName")); 
			atLeast(1).of(manager).getRepresentationOfType(newRelationship.getAssociationType()); will(returnValue("FooBean"));
		}});
		
		StringWriter writer = new StringWriter();
		generate(new RegeneratedAssociationImpl(originalRelationship, newRelationship), writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("original field", output.contains("private FooBean oldBusinessName;"));
		assertTrue("original annotation", output.contains("@Hl7XmlMapping({\"bean\"})"));
		assertTrue("original getter", output.contains("public FooBean getOldBusinessName()"));
		assertTrue("original getter body", output.contains("return this.oldBusinessName"));
		assertTrue("original setter", output.contains("public void setOldBusinessName(FooBean oldBusinessName"));
		assertTrue("original setter body", output.contains("this.oldBusinessName = oldBusinessName"));
		
		assertFalse("no new field", output.contains("private FooBean newBusinessName;"));
		assertTrue("new getter", output.contains("public FooBean getNewBusinessName()"));
		assertTrue("new getter body", output.contains("return this.oldBusinessName"));
		assertTrue("new setter", output.contains("public void setNewBusinessName(FooBean newBusinessName"));
		assertTrue("new setter body", output.contains("this.oldBusinessName = newBusinessName"));
	}

	@Test  @Ignore
	public void shouldGenerateMultipleCardinalityAssociation() throws Exception {
		final Association originalRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 5))
			.setBusinessName("oldBusinessName")
			.buildStandard();

		final Association newRelationship = new AssociationBuilder()
			.setName("bean")
			.setType(new TypeBuilder().setName("FooBean").build())
			.setCardinality(new Cardinality(0, 5))
			.setBusinessName("newBusinessName")
			.buildStandard();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("oldBusinessName"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("newBusinessName")); 
			atLeast(1).of(manager).getRepresentationOfType(originalRelationship.getAssociationType()); will(returnValue("FooBean"));
		}});
		
		StringWriter writer = new StringWriter();
		generate(new RegeneratedAssociationImpl(originalRelationship, newRelationship), writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("original field", output.contains("private List<FooBean> oldBusinessName = new ArrayList<FooBean>();"));
		assertTrue("original annotation", output.contains("@Hl7XmlMapping({\"bean\"})"));
		assertTrue("original getter", output.contains("public List<FooBean> getOldBusinessName()"));
		assertTrue("original getter body", output.contains("return this.oldBusinessName"));
		assertFalse("original setter", output.contains("public void setOldBusinessName(List<FooBean> oldBusinessName"));
		
		assertFalse("no new field", output.contains("private List<FooBean> newBusinessName;"));
		assertTrue("new getter", output.contains("public List<FooBean> getNewBusinessName()"));
		assertTrue("new getter body", output.contains("return this.oldBusinessName"));
		assertFalse("new setter", output.contains("public void setNewBusinessName(List<FooBean> newBusinessName"));
	}
	
	private void generate(RegeneratedAssociation regenerated, StringWriter writer) throws IOException {
	}
	
	@Test @Ignore
	public void shouldSingleCardinalityAttribute() throws Exception {
		final Attribute originalRelationship = new AttributeBuilder()
			.setName("attribute")
			.setBusinessName("oldBusinessName")
			.setDataType("II")
			.build();

		final Attribute newRelationship = new AttributeBuilder()
			.setName("attribute")
			.setBusinessName("newBusinessName")
			.setDataType("II")
			.build();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("oldBusinessName"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("newBusinessName"));
			atLeast(1).of(manager).getRepresentationOfClassName(
					with(equal(Identifier.class.getName()))); will(returnValue("Identifier"));
			
		}});
		
		StringWriter writer = new StringWriter();
		generate(new RegeneratedAttributeImpl(originalRelationship, newRelationship), writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("original field", output.contains("private II oldBusinessName = new IIImpl()"));
		assertTrue("original annotation", output.contains("@Hl7XmlMapping({\"attribute\"})"));
		assertTrue("original getter", output.contains("public Identifier getOldBusinessName()"));
		assertTrue("original setter", output.contains("public void setOldBusinessName(Identifier oldBusinessName"));
		assertTrue("original setter body", output.contains("this.oldBusinessName.setValue(oldBusinessName)"));
		
		assertFalse("no new field", output.contains("private II newBusinessName;"));
		assertTrue("new getter", output.contains("public Identifier getNewBusinessName()"));
		assertTrue("new getter body", output.contains("return this.oldBusinessName.getValue();"));
		assertTrue("new setter", output.contains("public void setNewBusinessName(Identifier newBusinessName"));
		assertTrue("new setter body", output.contains("this.oldBusinessName.setValue(newBusinessName)"));
	}

	@Test @Ignore
	public void shouldMultipleCardinalityAttribute() throws Exception {
		final Attribute originalRelationship = new AttributeBuilder()
			.setName("attribute")
			.setBusinessName("oldBusinessName")
			.setDataType("SET<II>")
			.build();

		final Attribute newRelationship = new AttributeBuilder()
			.setName("attribute")
			.setBusinessName("newBusinessName")
			.setDataType("SET<II>")
			.build();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("oldBusinessName"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("newBusinessName"));
			atLeast(1).of(manager).getRepresentationOfClassName(
					with(equal(Set.class.getName()))); will(returnValue("Identifier"));
			
		}});
		
		StringWriter writer = new StringWriter();
		generate(new RegeneratedAttributeImpl(originalRelationship, newRelationship), writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("original field", output.contains("private SET<II, Identifier> oldBusinessName = new SETImpl<II, Identifier>(IIImpl.class)"));
		assertTrue("original annotation", output.contains("@Hl7XmlMapping({\"attribute\"})"));
		assertTrue("original getter", output.contains("public Identifier<Identifier> getOldBusinessName() {"));
		assertFalse("original setter", output.contains("public void setOldBusinessName(Identifier<Identifier> oldBusinessName"));
		
		assertFalse("no new field", output.contains("private II newBusinessName;"));
		assertTrue("new getter", output.contains("public Identifier<Identifier> getNewBusinessName() {"));
		assertTrue("new getter body", output.contains("return this.oldBusinessName.rawSet();"));
		assertFalse("new setter", output.contains("public void setNewBusinessName(Identifier<Identifier> newBusinessName"));
		assertFalse("new setter body", output.contains("this.oldBusinessName.setValue(newBusinessName)"));
	}
	
	private void generate(RegeneratedAttribute regenerated, StringWriter writer) throws IOException {
	}
	
}
