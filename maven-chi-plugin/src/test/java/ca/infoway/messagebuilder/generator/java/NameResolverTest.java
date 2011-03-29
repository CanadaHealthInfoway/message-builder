package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;


public class NameResolverTest {

	private List<BaseRelationship> relationships = new ArrayList<BaseRelationship>();

	@Before
	public void setUp() throws Exception {
		this.relationships.add(createAttribute("id", new Cardinality(1,1), "II"));
		this.relationships.add(createAttribute("personId", new Cardinality(1,1), "II"));
	}
	
	@Test
	public void shouldUseRelationshipNameIfNoBusinessNames() throws Exception {
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("Id", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseBusinessNames() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);

		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: person identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("DrugProductIdentifier", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonIdentifier", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseRelationshipNameIfBusinessNameUsed() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);
		
		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: drug product identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("DrugProductIdentifier", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}
}
