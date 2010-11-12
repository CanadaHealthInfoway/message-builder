package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class DefinitionToResultConverterTest {


	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	private DefinitionToResultConverter converter = new DefinitionToResultConverter();
	
	@Test
	public void shouldConvertSimpleCase() throws Exception {

		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1"))));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert(this.definitions);
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = (Type) CollectionUtils.get(result.getAllMessageTypes(), 0);
		assertEquals("name", new TypeName("ABCD_MT123456CA.Tom"), type.getName());
		
		assertEquals("number of relationships", 1, type.getRelationships().size());
		
	}
	
	@Test
	public void shouldConvertSimpleCaseWithAssociation() throws Exception {
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Tom", Cardinality.create("1"))));
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1"))));
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert(this.definitions);
		
		assertNotNull("result", result);
		assertEquals("number of types", 2, result.getAllMessageTypes().size());

		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
	}
	@Test
	public void shouldConvertSimpleCaseWithTemplateAssociation() throws Exception {
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		Relationship relationship = new Relationship("role", null, Cardinality.create("1"));
		relationship.setTemplateParameterName("RegisteredRole");
		simplifiableType.getRelationships().add(new SimplifiableRelationship(relationship));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert(this.definitions);
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("association", type.getRelationships().get(0) instanceof Association);
		assertTrue("template association", ((Association) type.getRelationships().get(0)).isTemplateType());
		assertEquals("variable name", "RR", ((Association) type.getRelationships().get(0)).getType());
	}
}
