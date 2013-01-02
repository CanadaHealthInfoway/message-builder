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

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.xml.TypeName;


public class CsharpSourceFileWriterProviderTest {
	
	@Test
	public void shouldCreateWriter() throws Exception {
		JavaSourceFileWriterProvider provider = new JavaSourceFileWriterProvider(
				SystemUtils.getJavaIoTmpDir(), new SimpleNameTranslator(C_SHARP, "ca.infoway.test", new TypeNameHelperImpl(), NamingPolicy.getDefaultPolicy()));
		File file = provider.createFile(new TypeName("ABCD_MT123456CA.Subject23"));
		
        String expectedPathEnd = "ca/infoway/test/abcd_mt123456ca/Subject23.java".replace('/', System.getProperty("file.separator").charAt(0));
        assertTrue("file name: " + file.getAbsolutePath(),
                file.getAbsolutePath().endsWith(expectedPathEnd));
	}
}
