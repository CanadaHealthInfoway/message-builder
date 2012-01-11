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

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class XmlToJavaGeneratorMojoTest {

	@DataPoint public static final File EMPTY = null;
	@DataPoint public static final File DIRECTORY = new File("./src/");
	@DataPoint public static final File NOT_EXISTS = new File("unicorns");
	
	private XmlToJavaGeneratorMojo mojo;

	@Before
	public void setUp() {
		this.mojo = new XmlToJavaGeneratorMojo();
	}
	
	@Test(expected=MojoFailureException.class) @Theory(nullsAccepted=true)
	public void shouldThrowExceptionIfInputFileIsInvalid(File file) throws Exception {
		this.mojo.setMessageSet(file);
		this.mojo.execute();
	}
}
