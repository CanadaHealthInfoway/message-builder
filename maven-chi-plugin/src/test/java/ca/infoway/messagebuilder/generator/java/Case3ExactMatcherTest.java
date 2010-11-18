package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.xml.Cardinality.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class Case3ExactMatcherTest {
	
	private Mockery jmock = new Mockery();
	private TypeProvider typeProvider;
	private SimplifiableTypeProvider definitions;
	
	@Before
	public void setUp() throws Exception {
		this.typeProvider = this.jmock.mock(TypeProvider.class);
		this.definitions = this.jmock.mock(SimplifiableTypeProvider.class);
	}
	
	@Test
	public void shouldCheckEqualityFirstPass() throws Exception {
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		type1.getRelationships().add(createAttribute("id", "II.BUS"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.FifthSacredThing"));
		type2.getRelationships().add(createAttribute("id", "II.BUS"));
		this.jmock.checking(new Expectations() {{
			allowing(typeProvider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();

		assertTrue("matched", createMatcher(result).performMatching(type1));
	}

	@Test
	public void shouldCheckSimplifiableEqualityFirstPass() throws Exception {
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.FifthSacredThing"), false);
		type1.getRelationships().add(createSimplifiableAttribute("id", "II.BUS"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.FifthSacredThing"), false);
		type2.getRelationships().add(createSimplifiableAttribute("id", "II.BUS"));
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		
		assertTrue("matched", createMatcher(result).performMatching(type1));
	}
	
	private Case3ExactMatcher createMatcher(Case3MergeResult result) {
		return new Case3ExactMatcher(new SysoutLogUI(), this.typeProvider, this.definitions, result);
	}

	@Test
	public void shouldCheckEqualityOfAbstractTypes() throws Exception {
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		type1.setAbstract(true);
		type1.getChildTypes().add(new TypeName("ABCD_MT222222CA.Quintessence"));
		type1.getChildTypes().add(new TypeName("ABCD_MT222222CA.Spirit"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.FifthSacredThing"));
		type2.setAbstract(true);
		type2.getChildTypes().add(new TypeName("ABCD_MT222222CA.Quintessence"));
		type2.getChildTypes().add(new TypeName("ABCD_MT222222CA.Spirit"));
		this.jmock.checking(new Expectations() {{
			allowing(typeProvider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		
		assertTrue("matched", createMatcher(result).performMatching(type1));
		MergedTypeDescriptor descriptor = result.getDescriptorByName(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		assertEquals("merged descriptor", 2, descriptor.getMergedTypes().size());
	}
	
	@Test
	public void shouldCheckEqualityOfAbstractSimplifiableTypes() throws Exception {
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.FifthSacredThing"), false);
		type1.getMessagePart().setAbstract(true);
		type1.getMessagePart().getSpecializationChilds().add("ABCD_MT222222CA.Quintessence");
		type1.getMessagePart().getSpecializationChilds().add("ABCD_MT222222CA.Spirit");
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.FifthSacredThing"), false);
		type2.getMessagePart().setAbstract(true);
		type2.getMessagePart().getSpecializationChilds().add("ABCD_MT222222CA.Quintessence");
		type2.getMessagePart().getSpecializationChilds().add("ABCD_MT222222CA.Spirit");
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		
		assertTrue("matched", createMatcher(result).performMatching(type1));
		MergedTypeDescriptor descriptor = result.getDescriptorByName(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		assertEquals("merged descriptor", 2, descriptor.getMergedTypes().size());
	}
	
	@Test
	public void shouldCheckEqualityOfAbstractTypesAfterMerging() throws Exception {
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		type1.setAbstract(true);
		type1.getChildTypes().add(new TypeName("ABCD_MT222222CA.Quintessence"));
		type1.getChildTypes().add(new TypeName("ABCD_MT222222CA.Spirit"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.FifthSacredThing"));
		type2.setAbstract(true);
		type2.getChildTypes().add(new TypeName("ABCD_MT222222CA.Quintessence"));
		type2.getChildTypes().add(new TypeName("ABCD_MT333333CA.Spirit"));
		this.jmock.checking(new Expectations() {{
			allowing(typeProvider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.recordMatch(new Type(new TypeName("ABCD_MT333333CA.Spirit")), new Type(new TypeName("ABCD_MT222222CA.Spirit")));
		
		assertTrue("matched", createMatcher(result).performMatching(type1));
		MergedTypeDescriptor descriptor = result.getDescriptorByName(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		assertEquals("merged descriptor", 2, descriptor.getMergedTypes().size());
	}
	
	@Test
	public void shouldCheckEqualityAfterAssociationTypesHaveBeenMatched() throws Exception {
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.FifthSacredThing"));
		type1.getRelationships().add(createAttribute("id", "II.BUS"));
		type1.getRelationships().add(createAssociation("person", "ABCD_MT123456CA.Person"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.FifthSacredThing"));
		type2.getRelationships().add(createAttribute("id", "II.BUS"));
		type2.getRelationships().add(createAssociation("person", "ABCD_MT987654CA.Person"));
		this.jmock.checking(new Expectations() {{
			allowing(typeProvider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();

		assertFalse("not matched", createMatcher(result).performMatching(type1));
		
		result.recordMatch(((Association) type1.getRelationship("person")).getAssociationType(), 
				((Association) type2.getRelationship("person")).getAssociationType());
		
		assertNotNull("match emulated", result.getDescriptorByName(new TypeName("ABCD_MT987654CA.Person")));
		assertTrue("matched", createMatcher(result).performMatching(type1));
	}

	private BaseRelationship createAssociation(String name, String type) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setType(type);
		
		return Association.createStandardAssociation(relationship, new Type(new TypeName(type)), 0);
	}

	private BaseRelationship createAttribute(String name, String type) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setType(type);
		
		return new Attribute(relationship, null);
	}

	private SimplifiableRelationship createSimplifiableAttribute(String name, String type) {
		Relationship relationship = new Relationship(name, type, create("1"));
		return new SimplifiableRelationship(relationship, new TypeConverter().convertToType(relationship));
	}
	
}
