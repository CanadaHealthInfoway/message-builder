package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyNameResolverTest {
	
	@Test
	public void shouldNotRegisterBusinessNameIfCollidesWithTypeName() throws Exception {
		Association association = new AssociationBuilder()
			.setName("name").setBusinessName("healthcareWorker").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", 
				Arrays.<BaseRelationship>asList(association));
		
		assertEquals("Name", resolver.getName(association));
	}
	
}
