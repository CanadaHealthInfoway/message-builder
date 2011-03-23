package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createRootType;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;


public class Case1SimplifierTest {

	private TypeAnalysisResult result = new TypeAnalysisResult();
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneMultipleCardinality() throws Exception {
		
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,100), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "LIST<TS.FULLDATE>"))));

		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertTrue("not elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
	}
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneOptional() throws Exception {
		
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", new Cardinality(0, 1), "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertTrue("not elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
	}
	
	@Test
	public void shouldSimplifyMultipleCardinalityCase() throws Exception {
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,100), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
	}
	
	
	@Test
	public void shouldSimplifyCollectionAttributeCase() throws Exception {
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(1,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "LIST<TS.FULLDATE>"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
	}
	
	@Test
	public void shouldExcludeType() throws Exception {

		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(this.result, "PersonBirthtime", createAttribute("value", null, "TS.FULLDATE"))));

		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.PersonBirthtime")));
	}
	
	@Test
	public void shouldExcludeTemporaryType() throws Exception {
		
		TemporaryTypeName name = TemporaryTypeName.create("merged");
		createRootType(this.result,
				"ParameterList", createAssociation("birthTime", new Cardinality(0,1), 
						createType(
								this.result, 
								name, 
								false, 
								createAttribute("value", null, "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(name));
	}
	
	@Test
	public void shouldNotRemoveTypeWhenReferredToByAChoice() throws Exception {

		Type crossReferenceType = createType(this.result, "CrossReference", createAttribute("id", new Cardinality(1, 1), "SET<II.BUS>"));
		Type otherType = createType(this.result, "OtherReference", createAssociation("crossRef", new Cardinality(1, 1), crossReferenceType));
		
		Type rootType = createRootType(this.result, "BillableActChoice");
		
		rootType.setAbstract(true);
		crossReferenceType.getInterfaceTypes().add(rootType.getName());
		rootType.getChildTypes().add(crossReferenceType.getName());
		
		new Case1Simplifier(new SysoutLogUI(), this.result).execute();
		
		assertTrue("type not removed", this.result.getTypes().containsKey(new TypeName("ABCD_MT123456CA.CrossReference")));
		assertTrue("relationship removed", otherType.getRelationship("crossRefId") instanceof InlinedAttribute);
	}	
}
