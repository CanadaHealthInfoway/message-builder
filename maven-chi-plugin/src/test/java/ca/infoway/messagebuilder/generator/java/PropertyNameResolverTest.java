package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyNameResolverTest {
	
	@Test
	public void shouldRegisterOriginalAndNewIfCardinalityChanged() throws Exception {
		Association originalAssociation = new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 1)).buildStandard();
		Association newAssociation = new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 5)).buildStandard();
		
		RegeneratedAssociationImpl merged = new RegeneratedAssociationImpl(originalAssociation, newAssociation);
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", Arrays.<BaseRelationship>asList(merged));
		
		assertEquals("Name", resolver.getName(originalAssociation));
		assertEquals("Names", resolver.getName(newAssociation));
	}

	@Test
	public void shouldRegisterOriginalOnlyIfCardinalityNotChanged() throws Exception {
		Association originalAssociation = new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 1)).buildStandard();
		Association newAssociation = new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 1)).buildStandard();
		
		RegeneratedAssociationImpl merged = new RegeneratedAssociationImpl(originalAssociation, newAssociation);
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", Arrays.<BaseRelationship>asList(merged));
		
		assertEquals("Name", resolver.getName(originalAssociation));
	}

	@Test
	public void shouldRegisterOriginalAndNewIfCardinalityChangedAndSameBusinessName() throws Exception {
		Association originalAssociation = new AssociationBuilder()
			.setName("name").setBusinessName("businessName").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		Association newAssociation = new AssociationBuilder()
			.setName("name").setBusinessName("businessName").setCardinality(new Cardinality(0, 5))
			.buildStandard();
		
		RegeneratedAssociationImpl merged = new RegeneratedAssociationImpl(originalAssociation, newAssociation);
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", Arrays.<BaseRelationship>asList(merged));
		
		assertEquals("BusinessName", resolver.getName(originalAssociation));
		assertEquals("BusinessNames", resolver.getName(newAssociation));
	}

	@Test
	public void shouldRegisterOriginalAndNewIfDifferentBusinessName() throws Exception {
		Association originalAssociation = new AssociationBuilder()
			.setName("name").setBusinessName("originalBusinessName").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		Association newAssociation = new AssociationBuilder()
			.setName("name").setBusinessName("newBusinessName").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		RegeneratedAssociationImpl merged = new RegeneratedAssociationImpl(originalAssociation, newAssociation);
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", Arrays.<BaseRelationship>asList(merged));
		
		assertEquals("OriginalBusinessName", resolver.getName(originalAssociation));
		assertEquals("NewBusinessName", resolver.getName(newAssociation));
	}
	
	
	@Test
	public void shouldNotRegisterBusinessNameIfCollidesWithTypeName() throws Exception {
		Association association = new AssociationBuilder()
			.setName("name").setBusinessName("healthcareWorker").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", Arrays.<BaseRelationship>asList(association));
		
		assertEquals("Name", resolver.getName(association));
	}
	
}
