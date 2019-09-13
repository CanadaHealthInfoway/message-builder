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

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.lang.LanguageSpecificName;
import ca.infoway.messagebuilder.generator.lang.SimpleNameTranslator;


public class ImportDeclarationGeneratorTest {
	
	@Test
	public void shouldHandleSimpleImports() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.MyClass2");
		classes.add("ca.infoway.temp.SomethingElse"); 
		classes.add("ca.infoway.messagebuilder.datatype.Interval"); 
		
		generate(classes, 4);
	}
	
	@Test
	public void shouldNotTryToImportSameClassMoreThanOnce() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp2.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}

	@Test
	public void shouldIdentifyWhichItemShouldBeFullyQualified() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp2.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 

		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new LanguageSpecificName("ca.infoway.temp", "Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl(), NamingPolicy.getDefaultPolicy(), false));

		assertEquals("second", "ca.infoway.temp2.MyClass", generator.getRepresentationOfClassName("ca.infoway.temp2.MyClass"));
		assertEquals("first", "MyClass", generator.getRepresentationOfClassName("ca.infoway.temp.MyClass"));
	}

	@Test
	public void shouldOmitPackageNameWhenTypeIsInCurrentPackage() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.Fred");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new LanguageSpecificName("ca.infoway.temp.abcd_mt123456ca", "Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.temp", new TypeNameHelperImpl(), NamingPolicy.getDefaultPolicy(), false));
		
		assertEquals("class", "MyClass", generator.getRepresentationOfClassName("ca.infoway.temp.abcd_mt123456ca.MyClass"));
	}
	
	@Test
	public void shouldKeepPackageNameWhenTypeIsInCurrentPackageButImportCollisionExists() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.Fred");
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new LanguageSpecificName("ca.infoway.temp", "Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl(), NamingPolicy.getDefaultPolicy(), false));
		
		assertEquals("class", "ca.infoway.example.abcd_mt123456ca.MyClass", generator.getRepresentationOfClassName("ca.infoway.example.abcd_mt123456ca.MyClass"));
	}
	
	@Test
	public void shouldNotTryToImportExactSameClassMoreThanOnce() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}
	
	@Test
	public void shouldNotTryToImportJavaLangClasses() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("java.lang.String");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}
	
	private void generate(Collection<Object> classes, int count) throws IOException {
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new LanguageSpecificName("ca.infoway.temp.abcd_mt123456ca", "Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl(), NamingPolicy.getDefaultPolicy(), false));
		
		StringWriter writer = new StringWriter();
		generator.generate(writer, 0);
		
		String output = writer.toString().trim();
		String[] imports = StringUtils.split(output, ";");
		assertEquals("imports", count, imports.length);
	}
}
