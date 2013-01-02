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

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.MessageSetGenerator;

@RunWith(JMock.class)
public class MifToXmlGeneratorMojoTest {
	
	private Mockery jmock = new Mockery();
	private MessageSetGeneratorFactory factory;
	private MifToXmlGeneratorMojo mojo;
	private MessageSetGenerator generator;
	
	@Before
	public void setUp() {
		this.factory = this.jmock.mock(MessageSetGeneratorFactory.class);
		this.mojo = new MifToXmlGeneratorMojo(this.factory);
		this.generator = this.jmock.mock(MessageSetGenerator.class);
	}
	
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoSourceDirectoryConfigured() throws Exception {
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfFileSetsAreEmpty() throws Exception {
		this.mojo.setFileSets(new ArrayList<FileSet>());
		this.mojo.execute();
	}

	@Test
	public void shouldProcessSuccessfully() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).create((Mojo) with(anything()), (String) with(anything()), (File) with(anything()), (File) with(anything())); will(returnValue(generator));
			allowing(generator);
		}});
		this.mojo.setFileSets(Arrays.asList(new FileSet("category1", new File("./src"))));
		this.mojo.setVersion("R02.04.00");
		this.mojo.execute();
	}
}
