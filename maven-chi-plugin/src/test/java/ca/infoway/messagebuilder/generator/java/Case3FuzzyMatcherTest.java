package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class Case3FuzzyMatcherTest {

	private Mockery jmock = new Mockery();
	private TypeProvider provider = this.jmock.mock(TypeProvider.class);
	private SimplifiableTypeProvider definitions = this.jmock.mock(SimplifiableTypeProvider.class);
	
	@Test
	public void shouldNotMatchNonSimilarTypes() throws Exception {
		
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.SomeType"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.CompletelyUnrelatedType"));

		this.jmock.checking(new Expectations() {{
			allowing(provider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("no matches", createMatcher(result).performMatching(type1));
	}
	
	@Test
	public void shouldNotMatchNonSimilarSimplifiableTypes() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.CompletelyUnrelatedType"), false);
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("no matches", createMatcher(result).performMatching(type1));
	}

	private Case3FuzzyMatcher createMatcher(Case3MergeResult result) {
		return new Case3FuzzyMatcher(new SysoutLogUI(), this.provider, this.definitions, result);
	}
	
	@Test
	public void shouldMatchSimilarTypes() throws Exception {
		
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.SomeType"));
		type1.getRelationships().add(createAttribute("name", Cardinality.create("1"), "ST"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.SomeType"));
		type2.getRelationships().add(createAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(provider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type1));
	}
	@Test
	public void shouldNotMatchDifferentChoices() throws Exception {
		
		final Type type1 = new Type(new TypeName("ABCD_MT123456CA.SomeType"));
		type1.getRelationships().add(createAttribute("name", Cardinality.create("1"), "ST"));
		type1.getInterfaceTypes().add(new TypeName("ABCD_MT777777CA.MyChoice"));
		final Type type2 = new Type(new TypeName("ABCD_MT987654CA.SomeType"));
		type2.getInterfaceTypes().add(new TypeName("ABCD_MT777777CA.MyChoice"));
		type2.getRelationships().add(createAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(provider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(provider);
		assertFalse("matches", createMatcher(result).performMatching(type1));
	}

	@Test
	public void shouldNotMatchDifferentRelationships() throws Exception {
		
		final Type type1 = new Type(new TypeName("PORX_MT010140CA.ActRequest"));
		type1.setBusinessName("Prescription");
		type1.getRelationships().add(createAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		final Type type2 = new Type(new TypeName("PORX_MT030040CA.CombinedMedicationRequest"));
		type2.getRelationships().add(createAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type2.getRelationships().add(createAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createType(null, "PORX_MT030040CA.Component1")));
		final Type type3 = new Type(new TypeName("PORX_MT020070CA.SubstanceAdministrationRequest"));
		type3.setBusinessName("Prescription");
		type3.getRelationships().add(createAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type3.getRelationships().add(createAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createType(null, "PORX_MT020070CA.Component13")));
		
		this.jmock.checking(new Expectations() {{
			allowing(provider).getAllMessageTypes(); will(returnValue(Arrays.asList(type1, type3)));
			allowing(provider).getTypeByName(type1.getTypeName()); will(returnValue(type1));
			allowing(provider).getTypeByName(type2.getTypeName()); will(returnValue(type2));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(provider);
		result.recordMatch(type1, type2);
		
		assertFalse("matches", createMatcher(result).performMatching(type1));
	}

}
