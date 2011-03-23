package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;

public class MergeTypeUtilTest {

	
	@Test
	public void shouldMergeIdenticalTypes() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertEquals(matchingType1, matchingType2);
		assertEquals(mergedType, matchingType1);
		assertEquals(mergedType, matchingType2);
	}
	
	@Test(expected=MergeTypeException.class)
	public void shouldNotMergeTypesWithDifferentTypeNames() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType2", 
				createAttribute("id", new Cardinality(0,1), "II"));
		
		new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
	}
	
	@Test(expected=MergeTypeException.class)
	public void shouldNotMergeTypesWithDifferentAbstractness() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType1.setAbstract(true);
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		
		new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
	}
	
	@Test(expected=MergeTypeException.class)
	public void shouldNotMergeTypesWithDifferentRootTypeness() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createRootType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		
		new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
	}
	
//	@Test(expected=MergeTypeException.class)
//	public void shouldNotMergeTypesWithDifferentParentTypes() throws Exception {
//		
//		Type matchingType1 = TypeBuilder.createType(null, "TestType", 
//				createAttribute("id", new Cardinality(0,1), "II"));
//		matchingType1.setParent(new TypeName("ABCD_MT123456CA.TestType")); 
//		Type matchingType2 = TypeBuilder.createType(null, "TestType", 
//				createAttribute("id", new Cardinality(0,1), "II"));
//		matchingType2.setParent(new TypeName("DCBA_MT654321CA.TestType")); 
//		
//		new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
//	}
	
	@Test
	public void shouldMergeTypesWithDifferentJavadocs() throws Exception {

		// assuming matchingType1 is more recent...
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType1.setTypeDocumentation(createJavaDoc("busName1", "line1", "line2"));
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.setTypeDocumentation(createJavaDoc("busName2", "line3", "line4"));
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertEquals(mergedType, matchingType1);
		assertEquals("more recent javadoc should win if merged", matchingType1.getTypeDocumentation(), mergedType.getTypeDocumentation());
	}

	@Test
	public void shouldMergeTypesWithNewerJavadocRemoved() throws Exception {

		// assuming matchingType1 is more recent...
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.setTypeDocumentation(createJavaDoc("busName2", "line3", "line4"));
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertEquals(mergedType, matchingType1);
		assertEquals("more recent javadoc should win if merged, even if blanked out", matchingType1.getTypeDocumentation(), mergedType.getTypeDocumentation());

		matchingType1.setTypeDocumentation(null);
		mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		assertEquals(mergedType, matchingType1);
		assertEquals("more recent javadoc should win if merged, even if blanked out", matchingType1.getTypeDocumentation(), mergedType.getTypeDocumentation());
	}

	private TypeDocumentation createJavaDoc(String businessName, String... javaDocString) {
		Documentation doc = new Documentation(javaDocString);
		doc.setBusinessName(businessName);
		return new TypeDocumentation(doc);
	}
	
	@Test
	public void shouldMergeTypesWithDifferentBusinessNames() throws Exception {
		
		// assuming matchingType1 is more recent...

		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType1.setBusinessName("business name 1");
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.setBusinessName("business name 2");
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType2));
		assertTrue(mergedType.equals(matchingType1));
		assertTrue("different business names should have more recent name win", mergedType.getBusinessName().equals("business name 1"));
	}
	
	@Test(expected=MergeTypeException.class)
	public void shouldMergeTypesWithDifferentCategories() throws Exception {
		
		// assuming matchingType1 is more recent...

		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType1.setCategory("cat 1");
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.setCategory("cat 2");
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType2));
		assertTrue(mergedType.equals(matchingType1));
		assertTrue("different categories should have more recent name win", mergedType.getCategory().equals("cat 1"));
	}
	
	@Test
	public void shouldMergeTypesWithDifferentInterfaces() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType1.getInterfaceTypes().add(new TypeName("interface 1"));
		matchingType1.getInterfaceTypes().add(new TypeName("interface 2"));
		matchingType1.getInterfaceTypes().add(new TypeName("interface 3"));
		
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.getInterfaceTypes().add(new TypeName("interface 3"));
		matchingType2.getInterfaceTypes().add(new TypeName("interface 4"));
		matchingType2.getInterfaceTypes().add(new TypeName("interface 5"));
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType1));
		assertEquals("all interfaces should be merged", 5, mergedType.getInterfaceTypes().size());
		assertTrue("all interfaces should be merged", mergedType.getInterfaceTypes().containsAll(matchingType1.getInterfaceTypes()));
		assertTrue("all interfaces should be merged", mergedType.getInterfaceTypes().containsAll(matchingType2.getInterfaceTypes()));
	}
	
	@Test
	public void shouldMergeTypesWithDifferentChildTypes() throws Exception {
		
		Type matchingType1 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		
		matchingType1.getChildTypes().add(new TypeName("ChildType1"));
		matchingType1.getChildTypes().add(new TypeName("ChildType2"));
		matchingType1.getChildTypes().add(new TypeName("ChildType3"));
		
		Type matchingType2 = TypeAndRelationshipBuilder.createType(null, "TestType", 
				createAttribute("id", new Cardinality(0,1), "II"));
		matchingType2.getChildTypes().add(new TypeName("ChildType3"));
		matchingType2.getChildTypes().add(new TypeName("ChildType4"));
		matchingType2.getChildTypes().add(new TypeName("ChildType5"));
		
		Type mergedType = new MergeTypeUtil().mergeTypes(matchingType2, matchingType1);
		
		assertNotNull(mergedType);
		assertFalse(matchingType1.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType2));
		assertFalse(mergedType.equals(matchingType1));
		assertEquals("all child types should be merged", 5, mergedType.getChildTypes().size());
		assertTrue("all child should be merged", mergedType.getChildTypes().containsAll(matchingType1.getChildTypes()));
		assertTrue("all child should be merged", mergedType.getChildTypes().containsAll(matchingType2.getChildTypes()));
	}
}
