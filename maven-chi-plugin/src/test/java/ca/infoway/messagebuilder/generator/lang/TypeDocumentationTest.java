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

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.C_SHARP;
import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;
import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;


public class TypeDocumentationTest {
	
	private StringWriter writer;

	@Before
	public void setUp() throws Exception {
		this.writer = new StringWriter();
	}
	
	@Test
	public void shouldWriteDocumentationWithBusinessNameInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.setBusinessName("The Business Name");
		String output = write(documentation, C_SHARP);	
		assertTrue("business name", output.contains("<summary>Business Name: The Business Name</summary>"));
		
	}
	@Test
	public void shouldWriteVeryBasicDocumentationInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.getAnnotations().add(new Annotation("I am the very model of a modern markup paragraph."));
		String output = write(documentation, C_SHARP);	
		assertTrue("business name", output.contains("<summary>I am the very model of a modern markup paragraph.</summary>"));
		assertFalse("business name", output.contains("<remarks>"));
	}
	@Test
	public void shouldWriteMultipleParagraphDocumentationInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.getAnnotations().add(new Annotation("Antimony arsenic aluminum selenium."));
		documentation.getAnnotations().add(new Annotation("And hydrogen and oxygen and nitrogen and rhenium."));
		documentation.getAnnotations().add(new Annotation("And nickel, neodymium, neptunium, germanium."));
		String output = write(documentation, C_SHARP);	
		assertTrue("summary", output.contains("<summary>Antimony arsenic aluminum selenium.</summary>"));
		assertTrue("remarks", output.contains("<remarks>"));
	}
	
	@Test
	public void shouldCleanUpHtmlElements() throws Exception {
		Documentation documentation = new Documentation();
		// Believe it or not, this is an actual example from a jurisdiction
		documentation.getAnnotations().add(new Annotation("<p><font color=\"#000080\" size=\"2\" face=\"Helvetica\"><font color=\"#000080\" size=\"2\" face=\"Helvetica\"><font color=\"#000080\" size=\"2\" face=\"Helvetica\">\r\n" + 
				"<p align=\"left\">Provincial, and Territorial jurisdiction.</p>\r\n" + 
				"</font></font></font></p>"));
		String output = write(documentation, JAVA);
		assertEquals(lineSeparator()
				+ "/**" + lineSeparator() + 
				" * <p> </p><p align=\"left\">Provincial, and Territorial " + lineSeparator() + 
				" * jurisdiction.</p>" + lineSeparator() + 
				" */" + lineSeparator(), output);
	}
	
	@Test
	public void shouldCleanUpHtmlElements_StripLangAttribute() throws Exception {
		Documentation documentation = new Documentation();
		// Believe it or not, this is an actual example from a jurisdiction
		documentation.getAnnotations().add(new Annotation("<span lang=\"EN-CA\"><span style=\"line-height: normal; \"></span></span>"));
		String output = write(documentation, JAVA);
		assertEquals(lineSeparator()
				+ "/**" + lineSeparator()
				+ " * <p><span ><span style=\"line-height: normal; \"></span></span></p>" + lineSeparator()
				+ " */" + lineSeparator(), output);
	}

	private String write(Documentation documentation, ProgrammingLanguage programmingLanguage) throws IOException {
		new TypeDocumentation(documentation).write(programmingLanguage, writer, 0);
		
		String output = writer.toString();
		System.out.println(output);
		return output;
	}
}
