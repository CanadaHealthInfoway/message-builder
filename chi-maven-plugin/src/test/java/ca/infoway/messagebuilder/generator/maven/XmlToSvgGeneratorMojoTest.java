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
package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(MockitoJUnitRunner.class)
public class XmlToSvgGeneratorMojoTest {

	@Mock
	SvgGeneratorFactory factory;
	@Mock
	SvgGenerator generator;
	
	
	@Test(expected=MojoFailureException.class)
	public void shouldRecognizeMissingParameters() throws Exception {
		XmlToSvgGeneratorMojo mojo = new XmlToSvgGeneratorMojo(this.factory);
		mojo.execute();
	}

	@Test(expected=MojoFailureException.class)
	public void shouldRecognizeMissingMessageSetParameter() throws Exception {
		XmlToSvgGeneratorMojo mojo = new XmlToSvgGeneratorMojo(this.factory);
		mojo.svgFolder = new File(SystemUtils.JAVA_IO_TMPDIR);
		mojo.execute();
	}
	
	@Test(expected=MojoFailureException.class)
	public void shouldRecognizeInvalidMessageSetParameter() throws Exception {
		XmlToSvgGeneratorMojo mojo = new XmlToSvgGeneratorMojo(this.factory);
		mojo.svgFolder = new File(SystemUtils.JAVA_IO_TMPDIR);
		mojo.messageSet = new File(SystemUtils.JAVA_IO_TMPDIR);
		mojo.execute();
	}
	
	@Test(expected=MojoFailureException.class)
	public void shouldRecognizeMissingSvgFolderParameter() throws Exception {
		XmlToSvgGeneratorMojo mojo = new XmlToSvgGeneratorMojo(this.factory);
		mojo.messageSet = new File("./pom.xml");
		mojo.execute();
	}
	
	@Test
	public void shouldCallFactory() throws Exception {
		Mockito.when(this.factory.create(Mockito.any(LogUI.class))).thenReturn(this.generator);
		File file = File.createTempFile("messageSet-tmp-", ".xml");
		file.deleteOnExit();
		MessageSet messageSet = new MessageSet();
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		marshaller.marshall(messageSet, file);
		XmlToSvgGeneratorMojo mojo = new XmlToSvgGeneratorMojo(this.factory);
		mojo.svgFolder = new File(SystemUtils.JAVA_IO_TMPDIR);
		mojo.messageSet = file;
		mojo.execute();
		
		Mockito.verify(this.generator).execute(Mockito.any(MessageSet.class), Mockito.eq(mojo.svgFolder));
	}
}
