package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAttribute;
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
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;

@RunWith(JMock.class)
public class Case3FuzzyMatcherTest {

	private Mockery jmock = new Mockery();
	private TypeProvider provider = this.jmock.mock(TypeProvider.class);
	private SimplifiableTypeProvider definitions = this.jmock.mock(SimplifiableTypeProvider.class);
	
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
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type1));
	}
	
	@Test
	public void shouldNotMatchDifferentChoices() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type1.getInterfaceTypes().add("ABCD_MT777777CA.MyChoice");
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getInterfaceTypes().add("ABCD_MT777777CA.MyChoice");
		type2.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(definitions);
		assertFalse("matches", createMatcher(result).performMatching(type1));
	}

	@Test
	public void shouldNotMatchDifferentRelationships() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("PORX_MT010140CA.ActRequest"), false);
		type1.getMessagePart().setDocumentation(new Documentation());
		type1.getMessagePart().getDocumentation().setBusinessName("Prescription");
		type1.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("PORX_MT030040CA.CombinedMedicationRequest"), false);
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type2.getRelationships().add(createSimplifiableAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createSimplifiableType(null, "PORX_MT030040CA.Component1", false)));
		final SimplifiableType type3 = new SimplifiableType(new MessagePart("PORX_MT020070CA.SubstanceAdministrationRequest"), false);
		type3.getMessagePart().setDocumentation(new Documentation());
		type3.getMessagePart().getDocumentation().setBusinessName("Prescription");
		type3.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type3.getRelationships().add(createSimplifiableAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createSimplifiableType(null, "PORX_MT020070CA.Component13", false)));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type3)));
			allowing(definitions).getType(type1.getTypeName().getName()); will(returnValue(type1));
			allowing(definitions).getType(type2.getTypeName().getName()); will(returnValue(type2));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(definitions);
		result.recordMatch(type1, type2);
		
		assertFalse("matches", createMatcher(result).performMatching(type1));
	}

}
