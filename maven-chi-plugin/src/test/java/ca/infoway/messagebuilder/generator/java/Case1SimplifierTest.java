package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createRootType;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableType;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;


public class Case1SimplifierTest {

	private TypeAnalysisResult result = new TypeAnalysisResult();
	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneMultipleCardinality() throws Exception {
		
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,100), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "LIST<TS.FULLDATE>"))));
		createSimplifiableType(this.definitions, "ParameterList", true, 
			createSimplifiableAssociation("birthTime", new Cardinality(0,100), 
					createSimplifiableType(this.definitions, "PersonBirthtime", false, createSimplifiableAttribute("value", null, "LIST<TS.FULLDATE>"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertTrue("not elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
		assertFalse("not elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneOptional() throws Exception {
		
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", new Cardinality(0, 1), "TS.FULLDATE"))));
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", new Cardinality(0, 1), "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertTrue("not elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
		assertFalse("not elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldSimplifyMultipleCardinalityCase() throws Exception {
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,100), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "TS.FULLDATE"))));
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,100), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	
	@Test
	public void shouldSimplifyCollectionAttributeCase() throws Exception {
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(1,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "LIST<TS.FULLDATE>"))));
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(1,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "LIST<TS.FULLDATE>"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldExcludeType() throws Exception {

		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "TS.FULLDATE"))));
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(1,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));

		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldExcludeTemporaryType() throws Exception {
		
		TemporaryTypeName name = TemporaryTypeName.create("merged");
		SimplifiableType mergedType = null;
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(
								this.result, 
								name, 
								false, 
								createAttribute("value", null, "TS.FULLDATE"))));
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,1), 
						mergedType = createSimplifiableType(
								this.definitions, 
								"PersonBirthtime", 
								false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));
		mergedType.getMergedWithTypes().add(createSimplifiableType(definitions, "ABCD_MT999999CA.PersonBirthtime", false));
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(name));
		assertTrue("marked as inlined", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldNotRemoveTypeWhenReferredToByAChoice() throws Exception {

		Type crossReferenceType = createType(this.result, "CrossReference", createAttribute("id", new Cardinality(1, 1), "SET<II.BUS>"));
		Type otherType = createType(this.result, "OtherReference", createAssociation("crossRef", new Cardinality(1, 1), crossReferenceType));
		
		Type rootType = createRootType(this.result, "BillableActChoice");
		
		rootType.setAbstract(true);
		crossReferenceType.getInterfaceTypes().add(rootType.getName());
		rootType.getChildTypes().add(crossReferenceType.getName());
		
		new Case1Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertTrue("type not removed", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.CrossReference")));
		assertTrue("relationship removed", otherType.getRelationship("crossRefId") instanceof InlinedAttribute);
	}	
}
