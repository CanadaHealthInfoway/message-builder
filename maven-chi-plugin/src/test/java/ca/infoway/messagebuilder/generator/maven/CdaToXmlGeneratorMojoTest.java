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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator.maven;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.generator.cda.CdaToXmlGenerator;

@RunWith(MockitoJUnitRunner.class)
public class CdaToXmlGeneratorMojoTest {

	@Mock
	private MessageSetGeneratorFactory factory;
	@Mock
	private CdaToXmlGenerator generator;
	
	@Mock
	private File schemaFile;
	@Mock
	private File suppSchemaFile;
	@Mock
	private File templateFile;
	@Mock
	private File vocFile;
	@Mock
	private File generatedReportsDir;
	
	private CdaToXmlGeneratorMojo mojo;
	
	@Before
	public void setUp() {
		when(this.schemaFile.exists()).thenReturn(true);
		when(this.schemaFile.isFile()).thenReturn(true);
		when(this.suppSchemaFile.exists()).thenReturn(true);
		when(this.suppSchemaFile.isFile()).thenReturn(true);
		when(this.templateFile.exists()).thenReturn(true);
		when(this.templateFile.isFile()).thenReturn(true);
		when(this.vocFile.exists()).thenReturn(true);
		when(this.vocFile.isFile()).thenReturn(true);
		
		this.mojo = new CdaToXmlGeneratorMojo(this.factory);
		
		when(this.factory.createForCda(eq(mojo), anyBoolean())).thenReturn(generator);
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoSchemaConfigured() throws Exception {
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfSchemaDoesNotExist() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.schemaFile.exists()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfSchemaIsNotAFile() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.schemaFile.isFile()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoTemplateConfigured() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);

		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfTemplateDoesNotExist() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.templateFile.exists()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfTemplateIsNotAFile() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.templateFile.isFile()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoVocabularyConfigured() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setR2Datatypes(true);

		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfVocabularyDoesNotExist() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.vocFile.exists()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfVocabularyIsNotAFile() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		
		when(this.vocFile.isFile()).thenReturn(false);
		
		this.mojo.execute();
	}
	
	@Test
	public void shouldProcessSuccessfully() throws Exception {
		this.mojo.setSchema(schemaFile);
		this.mojo.setSupplementarySchema(suppSchemaFile);
		this.mojo.setTemplate(templateFile);
		this.mojo.setVocabulary(vocFile);
		this.mojo.setR2Datatypes(true);
		this.mojo.setOutputFile(generatedReportsDir);
		
		this.mojo.execute();
		
		verify(this.generator).processAllCdaFiles(schemaFile, suppSchemaFile, templateFile, vocFile);
	}
}
