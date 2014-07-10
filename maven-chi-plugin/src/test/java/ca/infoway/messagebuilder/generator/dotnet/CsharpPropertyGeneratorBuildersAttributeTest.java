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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.dotnet;

import static ca.infoway.messagebuilder.generator.lang.TypeAndRelationshipBuilder.createAttribute;
import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.generator.lang.Attribute;
import ca.infoway.messagebuilder.generator.lang.BaseRelationship;
import ca.infoway.messagebuilder.generator.lang.BaseRelationshipNameResolver;
import ca.infoway.messagebuilder.generator.lang.ClassNameManager;
import ca.infoway.messagebuilder.generator.lang.PropertyGenerator;
import ca.infoway.messagebuilder.generator.lang.PropertyGeneratorBuilders;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;

public class CsharpPropertyGeneratorBuildersAttributeTest {
	
	@Rule
	public final JMockMockeryRule jmock = new JMockMockeryRule();
	
	private ClassNameManager manager;
	private BaseRelationshipNameResolver nameResolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.nameResolver = this.jmock.mock(BaseRelationshipNameResolver.class);
		this.jmock.checking(new Expectations() {{
			allowing(nameResolver).getName(with(any(BaseRelationship.class))); will(returnValue("relationshipName"));
		}});
	}

	@Test
	public void shouldGenerateSimpleTypeCd() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(with(equal(ActStatus.class.getName())));
				will(returnValue("ActStatus"));
		}});
		
		Attribute idRelationship = createAttribute("code", new Cardinality(1, 1), "CD", "ActStatus");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private CD relationshipName;"));
		assertTrue("annotation", output.contains("[Hl7XmlMappingAttribute(new string[] {\"code\"})]"));
		assertTrue("property", output.contains("public ActStatus RelationshipName {"));
		assertTrue("getter body", output.contains("get { return (ActStatus) this.relationshipName.Value; }"));
		assertTrue("setter", output.contains("set { this.relationshipName.Value = value; }"));
	}

	@Test
	public void shouldGenerateTs() throws Exception {
		Attribute idRelationship = createAttribute("updatedOn", new Cardinality(1, 1), "TS");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private TS relationshipName;"));
		assertTrue("annotation", output.contains("[Hl7XmlMappingAttribute(new string[] {\"updatedOn\"})]"));
		assertTrue("property", output.contains("public PlatformDate RelationshipName {"));
		assertTrue("getter body", output.contains("get { return this.relationshipName.Value; }"));
		assertTrue("setter", output.contains("set { this.relationshipName.Value = value; }"));
	}
	
	@Test
	public void shouldGenerateCodedTypeList() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.List"))); will(returnValue("List"));
		}});
		
		Attribute statusesRelationship = createAttribute("statuses", new Cardinality(1, 1), "LIST<CD>", "ActStatus");
		
		StringWriter writer = new StringWriter();
		generate(statusesRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private LIST<CD, Code> relationshipName"));
		assertTrue("annotation", output.contains("[Hl7XmlMappingAttribute(new string[] {\"statuses\"})]"));
		assertTrue("getter", output.contains("public IList<ActStatus> RelationshipName {"));
		assertTrue("getter body", output.contains("get { return this.relationshipName.RawList<ActStatus>(); }"));
		assertFalse("no setter", output.contains("set {"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeIvl() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.Interval"))); 
				will(returnValue("Interval"));
		}});
		
		Attribute idRelationship = createAttribute("ivl", new Cardinality(1, 1), "IVL<TS.FULLDATE>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private IVL<TS, Interval<PlatformDate>> relationshipName;"));
		assertTrue("annotation", output.contains("[Hl7XmlMappingAttribute(new string[] {\"ivl\"})]"));
		assertTrue("getter", output.contains("public Interval<PlatformDate> RelationshipName {"));
		assertTrue("getter", output.contains("get { return this.relationshipName.Value; }"));
		assertTrue("setter", output.contains("set { this.relationshipName.Value = value; }"));
	}

	private void generate(Attribute attribute, StringWriter writer) throws IOException {
		PropertyGenerator generator = PropertyGeneratorBuilders.newAttributeBuilder(C_SHARP, attribute).build(this.manager, this.nameResolver);
		generator.createAttributeDefinition(0, writer);
		generator.createGettersAndSetters(0, writer);
	}

}
