package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class DefinitionToResultConverterTest {


	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	private DefinitionToResultConverter converter = new DefinitionToResultConverter(this.definitions, "ca.infoway.test", JAVA);
	private TypeConverter typeConverter = new TypeConverter();
	
	@Test
	public void shouldConvertSimpleCase() throws Exception {

		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		simplifiableType.getRelationships().add(
				new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = (Type) CollectionUtils.get(result.getAllMessageTypes(), 0);
		assertEquals("name", new TypeName("ABCD_MT123456CA.Tom"), type.getTypeName());
		
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("atribute", type.getRelationships().get(0) instanceof Attribute);
		
		assertEquals("class name", "ca.infoway.test.abcd_mt123456ca.TomBean", type.getLanguageSpecificName().getFullyQualifiedName());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 2, result.getAllMessageTypes().size());

		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithInlinedAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		innerSimplifiableType.setInlined(true);
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
		
		BaseRelationship relationship = type.getRelationships().get(0);
		assertTrue("inlined", relationship instanceof InlinedAttribute);
		assertEquals("name", "personName", relationship.getName());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMultiplyInlinedAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("age", "INT", Cardinality.create("1")), this.typeConverter.convertToType("INT", null)));
		innerSimplifiableType.setInlined(true);
		SimplifiableType middleSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Person"), true);
		middleSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("tom", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		middleSimplifiableType.setInlined(true);
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1")), middleSimplifiableType));
		this.definitions.addType(middleSimplifiableType);
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 2, type.getRelationships().size());

		for (BaseRelationship relationship : type.getRelationships()) {
			assertTrue("inlined", relationship instanceof InlinedAttribute);
			assertTrue("name", new HashSet<String>(Arrays.asList("personTomName", "personTomAge")).contains(relationship.getName()));
		}
	}
	
	@Test
	public void shouldConvertSimpleCaseWithTemplateAssociation() throws Exception {
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		Relationship relationship = new Relationship("role", null, Cardinality.create("1"));
		relationship.setTemplateParameterName("RegisteredRole");
		simplifiableType.getRelationships().add(new SimplifiableRelationship(relationship, new TemplateVariable("RR")));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("association", type.getRelationships().get(0) instanceof Association);
		assertTrue("template association", ((Association) type.getRelationships().get(0)).isTemplateType());
		assertEquals("variable name", "RR", ((Association) type.getRelationships().get(0)).getType());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMergedTypes() throws Exception {
		Relationship relationship1 = new Relationship("role", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false, "common");
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(relationship1, this.typeConverter.convertToType("ST", null)));
		
		Relationship relationship2 = new Relationship("name", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false, "common");
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(relationship2, this.typeConverter.convertToType("ST", null)));
		
		TypeName mergedTypeName = TemporaryTypeName.create("merged");
		
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType1.setMergedTypeName(mergedTypeName);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.setMergedTypeName(mergedTypeName);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(mergedTypeName);
		assertNotNull("type", type);
		assertEquals("number of relationships", 2, type.getRelationships().size());
		assertEquals("category", "common", type.getCategory());
		assertTrue("attribute", type.getRelationships().get(0) instanceof Attribute);
		assertTrue("attribute", type.getRelationships().get(1) instanceof Attribute);
		
		assertEquals("class name", "ca.infoway.test.common.merged.Patient2Bean", type.getLanguageSpecificName().getFullyQualifiedName());
	}

	@Test
	public void shouldConvertSimpleCaseWithMergedAndInlinedTypes() throws Exception {
		
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.setInlined(true);
		
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false);
		simplifiableType2.setInlined(true);
		
		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 0, result.getAllMessageTypes().size());
	}	
	
	@Test
	public void shouldConvertSimpleCaseWithMergedWithTrivialInlinedCase() throws Exception {
		
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.setInlined(true);
		
		MessagePart messagePart = new MessagePart("ABCD_MT123456CA.Patient2");
		messagePart.getSpecializationChilds().add("ABCD_MT123456CA.Patient3");
		messagePart.getSpecializationChilds().add("ABCD_MT123456CA.Patient4");
		SimplifiableType simplifiableType2 = new SimplifiableType(messagePart, false);
		
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient3"), false);
		simplifiableType3.getInterfaceTypes().add("ABCD_MT123456CA.Patient2");

		SimplifiableType simplifiableType4 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient4"), false);
		simplifiableType4.getInterfaceTypes().add("ABCD_MT123456CA.Patient2");

		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		this.definitions.addType(simplifiableType4);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 3, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient3"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient4"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient2"));
		assertNotNull("type", type);
		assertEquals("interfaces", 2, type.getChildTypes().size());
	}	
	
	@Test
	public void shouldConvertInlinedAndMergedCaseWithMultipleCardinality() throws Exception {

		MessagePart messagePart1 = new MessagePart("ABCD_MT123456CA.MergedInterfaceType1");
		messagePart1.getSpecializationChilds().add("ABCD_MT123456CA.ChildType1");
		messagePart1.getSpecializationChilds().add("ABCD_MT123456CA.ChildType2");
		SimplifiableType simplifiableType1 = new SimplifiableType(messagePart1, false);
		
		MessagePart messagePart2 = new MessagePart("ABCD_MT123456CA.MergedInterfaceType2");
		messagePart2.getSpecializationChilds().add("ABCD_MT123456CA.ChildType1");
		messagePart2.getSpecializationChilds().add("ABCD_MT123456CA.ChildType2");
		SimplifiableType simplifiableType2 = new SimplifiableType(messagePart2, false);
		
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.ChildType1"), false);
		simplifiableType3.getInterfaceTypes().add("ABCD_MT123456CA.MergedInterfaceType1");

		SimplifiableType simplifiableType4 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.ChildType2"), false);
		simplifiableType4.getInterfaceTypes().add("ABCD_MT123456CA.MergedInterfaceType1");

		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		
		Relationship relationship = new Relationship("relatedPerson", "ABCD_MT123456CA.MergedInterfaceType1", Cardinality.create("1"));
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.InlinedType"), false);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(relationship, simplifiableType1));
		simplifiableType.setInlined(true);

		Relationship relationship0 = new Relationship("relatedPersons", "ABCD_MT123456CA.InlinedType", Cardinality.create("0-20"));
		SimplifiableType simplifiableType0 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.TopMostType"), false);
		simplifiableType0.getRelationships().add(new SimplifiableRelationship(relationship0, simplifiableType));

		this.definitions.addType(simplifiableType0);
		this.definitions.addType(simplifiableType);
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		this.definitions.addType(simplifiableType4);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 4, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.ChildType1"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.ChildType2"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(name);
		assertNotNull("type", type);
		assertEquals("interfaces", 2, type.getChildTypes().size());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.InlinedType"));
		assertNull("type", type);

		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.TopMostType"));
		assertNotNull("type", type);
		assertEquals("relationships", 1, type.getRelationships().size());
		assertTrue("cardinality", type.getRelationships().get(0).getCardinality().isMultiple());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMergedAssociations() throws Exception {
		Relationship relationship1 = new Relationship("role", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(relationship1, this.typeConverter.convertToType("ST", null)));
		
		Relationship relationship2 = new Relationship("name", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false);
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(relationship2, this.typeConverter.convertToType("ST", null)));
		
		TypeName mergedTypeName = TemporaryTypeName.create("merged");
		
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType1.setMergedTypeName(mergedTypeName);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.setMergedTypeName(mergedTypeName);

		Relationship relationship3 = new Relationship("patient1", "ABCD_MT123456CA.Patient1", Cardinality.create("1"));
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeOtherType"), false);
		simplifiableType3.getRelationships().add(new SimplifiableRelationship(relationship3, simplifiableType1));
		
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(mergedTypeName);
		assertNotNull("type", type);
		assertEquals("number of relationships", 2, type.getRelationships().size());
		assertTrue("attribute", type.getRelationships().get(0) instanceof Attribute);
		assertTrue("attribute", type.getRelationships().get(1) instanceof Attribute);
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.SomeOtherType"));
		assertNotNull("type", type);
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("association", type.getRelationships().get(0) instanceof MergedAssociation);
		assertEquals("association type", mergedTypeName.getName(), type.getRelationships().get(0).getType());
	}
	
	// an inlined attribute should collate according to the outer/elided association
	@Test
	public void shouldHandleMergedRenamedAssociations() throws Exception {
		Type mergedType = new Type(TemporaryTypeName.create("merged"));
		
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.Person"));
		
		type1.getRelationships().add(new InlinedAttribute(
				new Attribute(new Relationship("name", "PN", Cardinality.create("1")),
						this.typeConverter.convertToType("PN", null)),
				new Association(
						new Relationship("identifiedParty", "ABCD_MT123456CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.IndentifiedParty")),
						Collections.<Choice>emptyList())));
		
		Type type2 = new Type(new TypeName("ABCD_MT987654CA.Person"));
		
		mergedType.getMergedTypes().add(type1);
		mergedType.getMergedTypes().add(type2);
		
		this.converter.types.put(type1.getTypeName().getName(), type1);
		this.converter.types.put(type2.getTypeName().getName(), type2);

		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT123456CA.IndentifiedParty"), false));
		
		MergedTypeCollator collator = this.converter.createCollator(mergedType);
		
		Collection<Fingerprint> names = collator.relationshipNames();
		assertEquals("size", 1, names.size());
		assertEquals("type", "ABCD_MT123456CA.IndentifiedParty/name", 
				((Fingerprint) CollectionUtils.get(names, 0)).toString());
	}
	@Test
	public void shouldHandleForciblyMergedTypes() throws Exception {
		Type mergedType = new Type(TemporaryTypeName.create("merged"));
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.Person"));
		type1.getRelationships().add(
				new Association(
						new Relationship("identifiedParty", "ABCD_MT123456CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.IndentifiedParty")),
						Collections.<Choice>emptyList()));
		
		Type type2 = new Type(new TypeName("ABCD_MT987654CA.Person"));
		type2.getRelationships().add(
				new Association(
						new Relationship("identifiedParty", "ABCD_MT987654CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT987654CA.IndentifiedParty")),
						Collections.<Choice>emptyList()));
		
		mergedType.getMergedTypes().add(type1);
		mergedType.getMergedTypes().add(type2);
		
		this.converter.types.put(type1.getTypeName().getName(), type1);
		this.converter.types.put(type2.getTypeName().getName(), type2);
		this.converter.types.put(mergedType.getTypeName().getName(), mergedType);

		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Person"), false);
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.Person"), false);
		this.definitions.addType(simplifiableType1);
		simplifiableType1.setMergedTypeName(mergedType.getTypeName());
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		this.definitions.addType(simplifiableType2);
		simplifiableType2.setMergedTypeName(mergedType.getTypeName());
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT123456CA.IndentifiedParty"), false));
		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT987654CA.IndentifiedParty"), false));
		
		this.converter.createRelationshipsForAllMergedTypes();
		
		assertFalse("relationships", mergedType.getRelationships().isEmpty());
		assertEquals("relationship count", 2, mergedType.getRelationships().size());
		assertTrue("1 requires thingie", mergedType.getRelationships().get(0).requiresMapByPartTypeAnnotation());
		assertTrue("2 requires thingie", mergedType.getRelationships().get(1).requiresMapByPartTypeAnnotation());
	}
}
