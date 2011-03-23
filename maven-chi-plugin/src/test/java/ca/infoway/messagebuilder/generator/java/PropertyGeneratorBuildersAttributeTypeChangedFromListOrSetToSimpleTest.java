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

public class PropertyGeneratorBuildersAttributeTypeChangedFromListOrSetToSimpleTest {

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
	public void shouldGenerateChangeFromSetToSimpleCorrectly() throws Exception {
		final Attribute originalRelationship = new AttributeBuilder().setName("ids").setDataType("SET<II>").build();
		final Attribute newRelationship = new AttributeBuilder().setName("ids").setDataType("II").build();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("ids"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("id")); 
			atLeast(1).of(manager).getRepresentationOfClassName("ca.infoway.messagebuilder.datatype.lang.Identifier"); will(returnValue("Identifier"));
			atLeast(1).of(manager).getRepresentationOfClassName("java.util.Set"); will(returnValue("Set"));
		}});
		
		RegeneratedAttributeImpl attribute = new RegeneratedAttributeImpl(originalRelationship, newRelationship);
		
		StringWriter writer = new StringWriter();
		generate(writer, PropertyGeneratorBuilders.newAttributeTypeChangedFromListOrSetToSimpleBuilder(attribute).build(manager, nameResolver));
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("list field", output.contains("private SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class)"));
		assertTrue("list annotation", output.contains("@Hl7XmlMapping({\"ids\"})"));
		assertTrue("list getter", output.contains("public Set<Identifier> getIds()"));
		assertFalse("no list setter", output.contains("public void setIds(Set<Identifier>"));

		assertTrue("getter", output.contains("public Identifier getId()"));
		assertTrue("getter body", output.contains("return getIds().isEmpty() ? null : getIds().iterator().next()"));
		assertTrue("setter", output.contains("public void setId(Identifier"));
		assertTrue("setter body", output.contains("getIds().clear(); getIds().add(id)"));
		assertFalse("no annotation", output.contains("@Hl7XmlMapping({\"id\"})\npublic Identifier getId() {"));
	}

	
	@Test @Ignore
	public void shouldGenerateChangeFromListToSimpleCorrectly() throws Exception {
		final Attribute originalRelationship = new AttributeBuilder().setName("ids").setDataType("LIST<II>").build();
		final Attribute newRelationship = new AttributeBuilder().setName("ids").setDataType("II").build();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("ids"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("id")); 
			
			atLeast(1).of(manager).getRepresentationOfClassName("ca.infoway.messagebuilder.datatype.lang.Identifier"); will(returnValue("Identifier"));
			atLeast(1).of(manager).getRepresentationOfClassName("java.util.List"); will(returnValue("List"));
			
		}});
		
		RegeneratedAttributeImpl attribute = new RegeneratedAttributeImpl(originalRelationship, newRelationship);
		
		StringWriter writer = new StringWriter();
		generate(writer, PropertyGeneratorBuilders.newAttributeTypeChangedFromListOrSetToSimpleBuilder(attribute).build(manager, nameResolver));
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("list field", output.contains("private LIST<II, Identifier> ids = new LISTImpl<II, Identifier>(IIImpl.class)"));
		assertTrue("list annotation", output.contains("@Hl7XmlMapping({\"ids\"})"));
		assertTrue("list getter", output.contains("public List<Identifier> getIds()"));
		assertFalse("no list setter", output.contains("public void setIds(List<Identifier>"));

		assertTrue("getter", output.contains("public Identifier getId()"));
		assertTrue("getter body", output.contains("return getIds().isEmpty() ? null : getIds().iterator().next()"));
		assertTrue("setter", output.contains("public void setId(Identifier"));
		assertTrue("setter body", output.contains("getIds().clear(); getIds().add(id)"));
		assertFalse("no annotation", output.contains("@Hl7XmlMapping({\"id\"})\npublic Identifier getId() {"));
	}

	@Test @Ignore
	public void shouldGenerateChangeFromSimpleToSetCorrectly() throws Exception {
		final Attribute originalRelationship = new AttributeBuilder().setName("id").setDataType("II").build();
		final Attribute newRelationship = new AttributeBuilder().setName("id").setDataType("SET<II>").build();
		
		this.jmock.checking(new Expectations() {{
			atLeast(1).of(nameResolver).getName(originalRelationship); will(returnValue("id"));
			atLeast(1).of(nameResolver).getName(newRelationship); will(returnValue("ids")); 
			atLeast(1).of(manager).getRepresentationOfClassName("ca.infoway.messagebuilder.datatype.lang.Identifier"); will(returnValue("Identifier"));
			atLeast(1).of(manager).getRepresentationOfClassName("java.util.Set"); will(returnValue("Set"));
		}});
		
		RegeneratedAttributeImpl attribute = new RegeneratedAttributeImpl(originalRelationship, newRelationship);
		
		StringWriter writer = new StringWriter();
		generate(writer, PropertyGeneratorBuilders.newAttributeTypeChangedFromSimpleToListOrSetBuilder(attribute).build(manager, nameResolver));
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("list field", output.contains("private SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class)"));
		assertTrue("list annotation", output.contains("@Hl7XmlMapping({\"id\"})"));
		assertTrue("list getter", output.contains("public Set<Identifier> getIds()"));
		assertFalse("no list setter", output.contains("public void setIds(Set<Identifier>"));

		assertTrue("getter", output.contains("public Identifier getId()"));
		assertTrue("getter body", output.contains("return getIds().isEmpty() ? null : getIds().iterator().next()"));
		assertTrue("setter", output.contains("public void setId(Identifier"));
		assertTrue("setter body", output.contains("getIds().clear(); getIds().add(id)"));
		assertFalse("no annotation", output.contains("@Hl7XmlMapping({\"id\"})\npublic Identifier getId() {"));
	}

	private void generate(StringWriter writer, PropertyGenerator generator) throws IOException {
		generator.createAttributeDefinition(0, writer);
		generator.createGettersAndSetters(0, writer);
	}
	
}
