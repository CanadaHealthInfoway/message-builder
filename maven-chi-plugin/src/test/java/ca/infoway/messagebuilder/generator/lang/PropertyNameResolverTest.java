/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.java.AssociationBuilder;
import ca.infoway.messagebuilder.generator.java.AttributeBuilder;
import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyNameResolverTest {
	
	@Test
	public void shouldNotRegisterBusinessNameIfCollidesWithTypeName() throws Exception {
		Association association = new AssociationBuilder()
			.setName("name").setBusinessName("healthcareWorker").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", 
				Arrays.<BaseRelationship>asList(association), NamingPolicy.getDefaultPolicy());
		
		assertEquals("Name", resolver.getName(association));
	}
	
	@Test
	public void shouldRemoveDotsFromName() throws Exception {
		Attribute attribute = new AttributeBuilder()
				.setName("person.name").build();
		
		PropertyNameResolver resolver = new PropertyNameResolver("Person", 
				Arrays.<BaseRelationship>asList(attribute), NamingPolicy.getDefaultPolicy());
		
		assertEquals("PersonName", resolver.getName(attribute));
	}
	
	@Test
	public void shouldInventUniqueNamesIfThereAreDuplicates() throws Exception {
		Association association1 = new AssociationBuilder()
				.setName("assignedEntity").setCardinality(new Cardinality(0, 1))
				.buildStandard();
		Association association2 = new AssociationBuilder()
			.setName("assignedEntity").setCardinality(new Cardinality(0, 1))
			.buildStandard();
		
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", 
				Arrays.<BaseRelationship>asList(association1, association2), NamingPolicy.getDefaultPolicy());
		
		assertEquals("AssignedEntity1", resolver.getName(association1));
		assertEquals("AssignedEntity2", resolver.getName(association2));
	}
	
	@Test
	public void shouldWorkHardToDetermineUniqueNamesIfThereAreDuplicates() throws Exception {
		Association association1 = new AssociationBuilder()
				.setName("assignedEntity").setCardinality(new Cardinality(0, 1))
				.buildStandard();
		Association association2 = new AssociationBuilder()
				.setName("assignedEntity").setCardinality(new Cardinality(0, 1))
				.buildStandard();
		Association association3 = new AssociationBuilder()
				.setName("assignedEntity1").setCardinality(new Cardinality(0, 1))
				.buildStandard();
		
		PropertyNameResolver resolver = new PropertyNameResolver("HealthcareWorker", 
				Arrays.<BaseRelationship>asList(association1, association2, association3), NamingPolicy.getDefaultPolicy());
		
		assertEquals("AssignedEntityAssociation1", resolver.getName(association1));
		assertEquals("AssignedEntityAssociation2", resolver.getName(association2));
	}
}
