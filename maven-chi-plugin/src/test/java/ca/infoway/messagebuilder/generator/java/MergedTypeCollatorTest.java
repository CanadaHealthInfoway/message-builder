package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class MergedTypeCollatorTest {

	private MergedTypeCollator collator = new MergedTypeCollator();
	private TypeConverter converter = new TypeConverter();
	
	@Test
	public void shouldMergeAttributes() throws Exception {
		Relationship relationship1 = new Relationship("name", "PN", Cardinality.create("1"));
		this.collator.addRelationship(new TypeName("ABCD_MT123456CA.Person"), 
				new Attribute(relationship1, this.converter.convertToType(relationship1)));
		
		Relationship relationship2 = new Relationship("name", "PN", Cardinality.create("1"));
		this.collator.addRelationship(new TypeName("ABCD_MT999999CA.Person"), 
				new Attribute(relationship2, this.converter.convertToType(relationship2)));
		
		Relationship relationship3 = new Relationship("name", "PN", Cardinality.create("1"));
		this.collator.addRelationship(new TypeName("ABCD_MT987654CA.Person"), 
				new Attribute(relationship3, this.converter.convertToType(relationship3)));
		
		for (Fingerprint namedAndTyped : this.collator.relationshipNames()) {
			assertEquals("number of relationships: " + namedAndTyped, 
					3, this.collator.getRelationships(namedAndTyped).size());
		}
	}
	@Test
	public void shouldMergeAssociations() throws Exception {
		TypeName name = TemporaryTypeName.create("merged");
		Relationship relationship1 = new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1"));
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.Person"));
		type1.setMergedName(name);
		this.collator.addRelationship(new TypeName("ABCD_MT123456CA.Patient"), 
				new Association(relationship1, 
						type1, 
						Collections.<Choice>emptyList()));
		
		Relationship relationship2 = new Relationship("person", "ABCD_MT999999CA.Person", Cardinality.create("1"));
		Type type2 = new Type(new TypeName("ABCD_MT999999CA.Person"));
		type2.setMergedName(name);
		this.collator.addRelationship(new TypeName("ABCD_MT999999CA.Patient"), 
				new Association(relationship2, 
						type2, 
						Collections.<Choice>emptyList()));
		
		Relationship relationship3 = new Relationship("dude", "ABCD_MT987654CA.Person", Cardinality.create("1"));
		Type type3 = new Type(new TypeName("ABCD_MT987654CA.Person"));
		type3.setMergedName(name);
		this.collator.addRelationship(new TypeName("ABCD_MT987654CA.Patient"), 
				new Association(relationship3, 
						type3, 
						Collections.<Choice>emptyList()));
		
		for (Fingerprint fingerprint : this.collator.relationshipNames()) {
			assertEquals("number of relationships: " + fingerprint, 
					3, this.collator.getRelationships(fingerprint).size());
		}
	}
}
