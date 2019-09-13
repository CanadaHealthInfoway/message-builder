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

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class CsharpSourceFileWriterProviderTest {
	
	private Mockery jmock = new Mockery();
	private NameTranslator translator;
	private CsharpSourceFileWriterProvider provider;
	private TypeName typeName;
	
	@Before
	public void setUp() throws Exception {
		this.typeName = new TypeName("ABCD_MT123456CA.MedicationAlert");
		this.translator = this.jmock.mock(NameTranslator.class);
		this.provider = new CsharpSourceFileWriterProvider(SystemUtils.getJavaIoTmpDir(), 
				this.translator);
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(typeName); will(returnValue("Ca.Infoway.Messagebuilder.Part"));
			allowing(translator).getClassNameWithoutPackage(typeName); will(returnValue("MedicationAlert"));
		}});
	}
	
	@Test
	public void shouldCreateCsharpFile() throws Exception {
		File file = this.provider.createFile(this.typeName);
		assertEquals("name", "MedicationAlert.cs", file.getName());
	}
}
