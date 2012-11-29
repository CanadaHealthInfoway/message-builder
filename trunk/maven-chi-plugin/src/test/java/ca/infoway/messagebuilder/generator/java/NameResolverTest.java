/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
	public void shouldUseRelationshipNameIfNoBusinessNamesForBusinessName() throws Exception {
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.BUSINESS_NAMES);
		assertEquals("Id", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseBusinessNamesForBusinessName() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);

		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: person identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.BUSINESS_NAMES);
		assertEquals("DrugProductIdentifier", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonIdentifier", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseRelationshipNameIfBusinessNameUsedForBusinessName() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);
		
		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: drug product identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.BUSINESS_NAMES);
		assertEquals("DrugProductIdentifier", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseRelationshipNameIfNoBusinessNamesForDefault() throws Exception {
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("Id", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseModelNamesForDefault() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);

		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: person identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("Id", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}

	@Test
	public void shouldUseModelNameIfBusinessNameUsedForDefault() throws Exception {
		Documentation documentation0 = new Documentation();
		documentation0.setBusinessName("*o: drug product identifier");
		this.relationships.get(0).getRelationship().setDocumentation(documentation0);
		
		Documentation documentation1 = new Documentation();
		documentation1.setBusinessName("*o: drug product identifier");
		this.relationships.get(1).getRelationship().setDocumentation(documentation1);
		
		PropertyNameResolver resolver = new PropertyNameResolver("Fred", this.relationships, NamingPolicy.getDefaultPolicy());
		assertEquals("Id", resolver.getName(this.relationships.get(0)));
		assertEquals("PersonId", resolver.getName(this.relationships.get(1)));
	}
}
