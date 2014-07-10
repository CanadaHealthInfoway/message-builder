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

import static ca.infoway.messagebuilder.generator.lang.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.lang.TypeAndRelationshipBuilder.createSimplifiableAttribute;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class Case3FuzzyMatcherTest {

	private Mockery jmock = new Mockery();
	private SimplifiableTypeProvider definitions = this.jmock.mock(SimplifiableTypeProvider.class);
	private ClusterProvider provider;

	@Before
	public void initialize() {
		final SimplifiableType type = new SimplifiableType(null, false);
		this.provider = this.jmock.mock(ClusterProvider.class);
		this.jmock.checking(new Expectations() {{
			// logging
			allowing(definitions).getType(with(any(String.class))); will(returnValue(type));
		}});
	}
	
	@Test
	public void shouldNotMatchNonSimilarSimplifiableTypes() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.CompletelyUnrelatedType"), false);
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("no matches", createMatcher(result).performMatching(type1, Arrays.asList(type1, type2)));
	}

	@Test
	public void shouldMatchRenamedTypes() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("MCCI_MT102001CA.Agent"), false);
		final SimplifiableType organizationType = new SimplifiableType(new MessagePart("MCCI_MT102001CA.Organization"), false);
		organizationType.getRelationships().add(new SimplifiableRelationship(new Relationship("id", "II", Cardinality.create("0-1")), new TypeConverter().convertToType("II", null)));
		type1.getRelationships().add(new SimplifiableRelationship(new Relationship("agentOrganization", "MCCI_MT102001CA.Organization", Cardinality.create("0-1")), organizationType));
		
		final SimplifiableType organizationType2 = new SimplifiableType(new MessagePart("MCCI_MT102001CA.Organization2"), false);
		organizationType2.getRelationships().add(new SimplifiableRelationship(new Relationship("id", "II", Cardinality.create("0-1")), new TypeConverter().convertToType("II", null)));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("MCCI_MT102001CA.Agent2"), false);
		type2.getRelationships().add(new SimplifiableRelationship(new Relationship("representedOrganization", "MCCI_MT102001CA.Organization2", Cardinality.create("0-1")), organizationType2));
		
		TemporaryTypeName mergedTypeName = TemporaryTypeName.create("merged");
		organizationType.setMergedTypeName(mergedTypeName);
		organizationType.getMergedWithTypes().add(organizationType2);
		organizationType2.setMergedTypeName(mergedTypeName);
		organizationType2.getMergedWithTypes().add(organizationType);
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2,
					organizationType, organizationType2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.recordMatch(organizationType, organizationType2);
		
		assertTrue("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
	}

	private Case3FuzzyMatcher createMatcher(Case3MergeResult result) {
		return new Case3FuzzyMatcher(new SysoutLogUI(), this.definitions, this.provider, result, FuzzQuotient.LEVEL_0);
	}
	
	@Test
	public void shouldMatchSimilarTypes() throws Exception {
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
	}
	
	@Test
	public void shouldMatchSimplifiableTypesWithSameGroupingPrefixAndSimilarType() throws Exception {
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Device3"), false);
		type1.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.Device2"), false);
		type2.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
		
	}

	@Test
	public void shouldMatchSimplifiableTypesWithListAndSetType() throws Exception {
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Device3"), false);
		type1.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("0-4"), "LIST<II>"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.Device2"), false);
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("2-5"), "SET<II>"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
		
	}

	@Test
	public void shouldMatchTwoTemplateRelationships() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertTrue("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
	}
	
	@Test
	public void shouldNotMatchTemplateRelationshipsWithDifferentNumberOfTemplates() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		type1.getRelationships().add(createSimplifiableAssociation("registeredRole", Cardinality.create("1"), new TemplateVariable("R"), ConformanceLevel.MANDATORY));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("matches", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
	}
	
	@Test
	public void shouldNotMatchTemplateRelationshipsWithUnmatchingTemplateRelationships() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		type1.getRelationships().add(createSimplifiableAssociation("subject", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		final SimplifiableType subject = new SimplifiableType(new MessagePart("ABCD_MT987654CA.Subject"), false);
		subject.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		type2.getRelationships().add(createSimplifiableAssociation("subject", Cardinality.create("1"), subject));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2, subject)));
			allowing(provider).getClusters(); will(returnValue(Arrays.asList(new Cluster(type1, type2, subject))));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("matches", createMatcher(result).matchAllTypes());
	}
	
	@Test
	public void shouldNotMatchTransitiveTemplateRelationships() throws Exception {
		final SimplifiableType templateType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Subject"), false);
		templateType.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), templateType, ConformanceLevel.MANDATORY));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getRelationships().add(createSimplifiableAssociation("act", Cardinality.create("1"), new TemplateVariable("T"), ConformanceLevel.MANDATORY));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		assertFalse("matches", createMatcher(result).performMatching(type1, Arrays.asList(type1, type2)));
		
		assertFalse("matches reverse", createMatcher(result).performMatching(type2, Arrays.asList(type1, type2)));
	}
	
	@Test
	public void shouldNotMatchDifferentChoices() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeType"), false);
		type1.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type1.getInterfaceTypes().add("ABCD_MT777777CA.MyChoice");
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.SomeType"), false);
		type2.getInterfaceTypes().add("ABCD_MT777777CA.MyChoice");
		type2.getRelationships().add(createSimplifiableAttribute("name", Cardinality.create("1"), "ST"));
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "II"));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type2)));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(definitions);
		assertFalse("matches", createMatcher(result).performMatching(type1, Arrays.asList(type1, type2)));
	}

	@Test
	public void shouldNotMatchDifferentRelationships() throws Exception {
		
		final SimplifiableType type1 = new SimplifiableType(new MessagePart("PORX_MT010140CA.ActRequest"), false);
		type1.getMessagePart().setDocumentation(new Documentation());
		type1.getMessagePart().getDocumentation().setBusinessName("Prescription");
		type1.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		final SimplifiableType type2 = new SimplifiableType(new MessagePart("PORX_MT030040CA.CombinedMedicationRequest"), false);
		type2.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type2.getRelationships().add(createSimplifiableAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createSimplifiableType(null, "PORX_MT030040CA.Component1", false)));
		final SimplifiableType type3 = new SimplifiableType(new MessagePart("PORX_MT020070CA.SubstanceAdministrationRequest"), false);
		type3.getMessagePart().setDocumentation(new Documentation());
		type3.getMessagePart().getDocumentation().setBusinessName("Prescription");
		type3.getRelationships().add(createSimplifiableAttribute("id", Cardinality.create("1"), "SET<II.BUS_AND_VER>"));
		type3.getRelationships().add(createSimplifiableAssociation("component1", Cardinality.create("1"), 
				TypeAndRelationshipBuilder.createSimplifiableType(null, "PORX_MT020070CA.Component13", false)));
		
		this.jmock.checking(new Expectations() {{
			allowing(definitions).getAllTypes(); will(returnValue(Arrays.asList(type1, type3)));
			allowing(definitions).getType(type1.getTypeName().getName()); will(returnValue(type1));
			allowing(definitions).getType(type2.getTypeName().getName()); will(returnValue(type2));
		}});
		
		Case3MergeResult result = new Case3MergeResult();
		result.initialize(definitions);
		result.recordMatch(type1, type2);
		
		type1.setMergedTypeName(result.getDescriptorByName(type1.getTypeName()).getNewName());
		type2.setMergedTypeName(result.getDescriptorByName(type2.getTypeName()).getNewName());
		
		assertFalse("matches", createMatcher(result).performMatching(type1, Arrays.asList(type1, type2)));
	}

}
