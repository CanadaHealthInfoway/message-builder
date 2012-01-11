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

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;


public class Case1SimplifierTest {

	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneMultipleCardinality() throws Exception {
		
		createSimplifiableType(this.definitions, "ParameterList", true, 
			createSimplifiableAssociation("birthTime", new Cardinality(0,100), 
					createSimplifiableType(this.definitions, "PersonBirthtime", false, createSimplifiableAttribute("value", null, "LIST<TS.FULLDATE>"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertNotNull("not elided", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime"));
		assertFalse("not elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldNotSimplifyIfChainHasMoreThanOneOptional() throws Exception {
		
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", new Cardinality(0, 1), "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertFalse("not elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldSimplifyMultipleCardinalityCase() throws Exception {
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,100), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	
	@Test
	public void shouldSimplifyCollectionAttributeCase() throws Exception {
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(1,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "LIST<TS.FULLDATE>"))));
		
		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldExcludeType() throws Exception {

		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(1,1), 
						createSimplifiableType(this.definitions, "PersonBirthtime", false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));

		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertTrue("elided from definitions", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test
	public void shouldExcludeTemporaryType() throws Exception {
		
		SimplifiableType mergedType = null;
		createSimplifiableType(this.definitions,
				"ParameterList", true, createSimplifiableAssociation("birthTime", new Cardinality(0,1), 
						mergedType = createSimplifiableType(
								this.definitions, 
								"PersonBirthtime", 
								false, 
								createSimplifiableAttribute("value", null, "TS.FULLDATE"))));
		mergedType.getMergedWithTypes().add(createSimplifiableType(definitions, "ABCD_MT999999CA.PersonBirthtime", false));
		
		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertTrue("marked as inlined", this.definitions.getType("ABCD_MT123456CA.PersonBirthtime").isInlined());
	}
	
	@Test @Ignore
	public void shouldNotRemoveTypeWhenReferredToByAChoice() throws Exception {

//		Type crossReferenceType = createType(this.result, "CrossReference", createAttribute("id", new Cardinality(1, 1), "SET<II.BUS>"));
//		Type otherType = createType(this.result, "OtherReference", createAssociation("crossRef", new Cardinality(1, 1), crossReferenceType));
//		
//		Type rootType = createRootType(this.result, "BillableActChoice");
//		
//		rootType.setAbstract(true);
//		crossReferenceType.getInterfaceTypes().add(rootType);
//		rootType.getChildTypes().add(crossReferenceType);
//		
//		new Case1Simplifier(new SysoutLogUI(), this.definitions).execute();
//		
//		assertNotNull("type not removed", this.definitions.getType("ABCD_MT123456CA.CrossReference"));
//		assertFalse("type not removed", this.definitions.getType("ABCD_MT123456CA.CrossReference").isInlined());
//		assertTrue("relationship removed", otherType.getRelationship("crossRefId") instanceof InlinedAttribute);
	}	
}
