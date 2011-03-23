package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.TypeName;


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
		TypeAnalysisResult result = new TypeAnalysisResult();
		Type type1 = TypeAndRelationshipBuilder.createType(result, "Person");
		type1.getInterfaceTypes().add(new TypeName("ABCD_MT123456CA.Choice1"));
		Type type2 = TypeAndRelationshipBuilder.createType(result, "APerson");
		type2.getInterfaceTypes().add(new TypeName("ABCD_MT123456CA.Choice1"));
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(result);
		
		assertTrue("unmergeable", mergeResult.isUnmergeable(type1, type2));
	}

	@Test
	public void shouldRecognizeTransitivelyUnmergeableResults() throws Exception {
		TypeAnalysisResult result = new TypeAnalysisResult();
		Type type1 = TypeAndRelationshipBuilder.createType(result, "Person");
		type1.getInterfaceTypes().add(new TypeName("ABCD_MT123456CA.Choice1"));
		Type type2 = TypeAndRelationshipBuilder.createType(result, "APerson");
		type2.getInterfaceTypes().add(new TypeName("ABCD_MT123456CA.Choice1"));
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(result);
		
		Type type3 = TypeAndRelationshipBuilder.createType(result, "Person1");
		
		mergeResult.recordMatch(type3, type1);
		
		assertTrue("unmergable normal", mergeResult.isUnmergeable(type1, type2));
		assertTrue("unmergable transitive", mergeResult.isUnmergeable(type2, type3));
	}
}
