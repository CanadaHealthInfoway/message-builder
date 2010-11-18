package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Case3MergeResultTest {
	
	@Test
	public void shouldIndicateWhetherOrNotMatchIsNewlyRecorded() throws Exception {
		
		Type type1 = TypeAndRelationshipBuilder.createType(null, "Person");
		Type type2 = TypeAndRelationshipBuilder.createType(null, "APerson");
		Type type3 = TypeAndRelationshipBuilder.createType(null, "SomePerson");
		Type type4 = TypeAndRelationshipBuilder.createType(null, "ThatPerson");
		
		Case3MergeResult result = new Case3MergeResult();
		
		assertTrue("first match", result.recordMatch(type1, type2));
		assertFalse("repeat first match", result.recordMatch(type1, type2));
		
		assertTrue("second match", result.recordMatch(type3, type4));
		assertTrue("third match", result.recordMatch(type2, type4));
		
		assertFalse("fourth match", result.recordMatch(type1, type4));
	}

	@Test
	public void shouldInitialize() throws Exception {
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		SimplifiableType type1 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person", false);
		type1.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		SimplifiableType type2 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "APerson", false);
		type2.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(definitions);
		
		assertTrue("unmergeable", mergeResult.isUnmergeable(type1, type2));
	}

	@Test
	public void shouldRecognizeTransitivelyUnmergeableResults() throws Exception {
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		SimplifiableType type1 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person", false);
		type1.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		SimplifiableType type2 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "APerson", false);
		type2.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(definitions);
		
		SimplifiableType type3 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person1", false);
		
		mergeResult.recordMatch(type3, type1);
		
		assertTrue("unmergable normal", mergeResult.isUnmergeable(type1, type2));
		assertTrue("unmergable transitive", mergeResult.isUnmergeable(type2, type3));
	}
}
