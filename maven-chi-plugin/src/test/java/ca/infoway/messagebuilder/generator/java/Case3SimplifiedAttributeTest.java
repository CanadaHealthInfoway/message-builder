package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class Case3SimplifiedAttributeTest {

	private TypeConverter converter = new TypeConverter();
	
	@Test
	public void shouldReplaceDataType() throws Exception {
		Relationship relationship1 = new Relationship("profileId", "SET<II.OID>", Cardinality.create("0-20"));
		Attribute attribute1 = new Attribute(relationship1, this.converter.convertToType(relationship1));
		
		Relationship relationship2 = new Relationship("profileId", "LIST<II.BUS>", Cardinality.create("0-20"));
		Attribute attribute2 = new Attribute(relationship2, this.converter.convertToType(relationship2));
		
		HashMap<TypeName,BaseRelationship> map = new HashMap<TypeName,BaseRelationship>();
		map.put(new TypeName("MCCI_MT000100CA.Message"), attribute1);
		map.put(new TypeName("MCCI_MT002100CA.Message"), attribute2);
		Case3SimplifiedAttribute attribute = new Case3SimplifiedAttribute(attribute1, map);
		
		assertEquals("data type", 
				this.converter.convertToType("COLLECTION<II>", null).getTypeName(),
				attribute.getDataType().getTypeName());
	}
}
