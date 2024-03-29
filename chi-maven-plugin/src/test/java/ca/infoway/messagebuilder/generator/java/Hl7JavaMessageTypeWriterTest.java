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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.lang.InteractionType;
import ca.infoway.messagebuilder.generator.lang.LanguageSpecificName;
import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.generator.lang.Type;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class Hl7JavaMessageTypeWriterTest {
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private NameTranslator translator;

	private StringWriter writer;

	private TypeName typeName;

	private TypeName interactionType;
	
	@Before
	public void setUp() throws Exception {
		this.translator = this.jmock.mock(NameTranslator.class);
		this.writer = new StringWriter();
		this.typeName = new TypeName("ABCD_MT123456CA.MyType");
		this.interactionType = new TypeName("ABCD_IN123456CA");
		this.jmock.checking(new Expectations() {{
			allowing(Hl7JavaMessageTypeWriterTest.this.translator).getPackageName(with(any(TypeName.class)));
			allowing(Hl7JavaMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(Hl7JavaMessageTypeWriterTest.this.interactionType); will(returnValue("Fred"));
			allowing(Hl7JavaMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(Hl7JavaMessageTypeWriterTest.this.typeName); will(returnValue("MyTranslatedType"));
			allowing(Hl7JavaMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(with(any(TypeName.class)));
			allowing(Hl7JavaMessageTypeWriterTest.this.translator).getFullyQualifiedClassName(with(any(TypeName.class)));
		}});
	}
	
	@Test
	public void shouldWriteAutoGenerationComment() throws Exception {
		final Type type = new Type(this.typeName);
		type.setLanguageSpecificName(new LanguageSpecificName("ca.infoway.test", "MyType"));
		type.setAbstract(true);

		Hl7JavaMessageTypeWriter typeWriter = new Hl7JavaMessageTypeWriter(type, this.translator, NamingPolicy.getDefaultPolicy());
		typeWriter.write(this.writer);
		assertTrue("comment", this.writer.toString().contains(
				"/* This class was auto-generated by the message builder generator tools. */"));
	}

	@Test
	public void shouldWriteSuperclassInClassDefinition() throws Exception {
		final InteractionType type = new InteractionType(this.interactionType);
		type.setLanguageSpecificName(new LanguageSpecificName("ca.infoway.test", "Fred"));
		type.setParentType(new Type(this.typeName));
		type.getParentType().setLanguageSpecificName(new LanguageSpecificName("ca.infoway.test", "MyTranslatedType"));
		
		Hl7JavaMessageTypeWriter typeWriter = new Hl7JavaMessageTypeWriter(type, this.translator, NamingPolicy.getDefaultPolicy());
		typeWriter.writeClassDefinition(this.writer, 0);
		assertTrue("declaration", this.writer.toString().contains(
			"public class Fred extends MyTranslatedType implements InteractionBean {"));
	}
	
	@Test
	public void shouldWriteHl7RootTypeAnnotationForHl7RootType() throws Exception {
		final Type type = new Type(this.typeName, true);
		type.setLanguageSpecificName(new LanguageSpecificName("ca.infoway.test", "MyType"));
		
		Hl7JavaMessageTypeWriter typeWriter = new Hl7JavaMessageTypeWriter(type, this.translator, NamingPolicy.getDefaultPolicy());
		typeWriter.write(this.writer);
		
		assertTrue("annotation", this.writer.toString().contains(
				"@Hl7RootType"));
	}
	
}
