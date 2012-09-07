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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-01-10 21:45:18 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3334 $
 */
package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.generator.util.DomainType;

@RunWith(MockitoJUnitRunner.class)
public class JavaDomainTypeWriterTest {

	@Mock
	DomainType domainType;
	
	@Test
	public void shouldWriteDomainType() throws Exception {
		Mockito.when(this.domainType.getName()).thenReturn("MyCode");
		Mockito.when(this.domainType.getFullyQualifiedClassName()).thenReturn("ca.infoway.messagebuilder.myrelease.domainvalue.MyCode");
		StringWriter writer = new StringWriter();
		new JavaDomainTypeWriter(this.domainType).write(writer);
		
		String result = writer.toString();
		System.out.println(result);
		assertTrue("package", result.contains("package ca.infoway.messagebuilder.myrelease.domainvalue;"));
		assertTrue("import", result.contains("import ca.infoway.messagebuilder.Code;"));
		assertTrue("declaration", result.contains("public interface MyCode extends Code {"));

	}

}
