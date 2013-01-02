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

package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class NameHelperTest {

	@Test
	public void shouldConcatenate() throws Exception {
		assertEquals("name", "ABCD_MT123456CA.Patient", NameHelper.createName("ABCD_MT123456CA", "Patient"));
	}
	
	@Test
	public void shouldDetermineRootName() throws Exception {
		Document document = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), "COCT_MT011001CA - Care Event identified.mif"));
		assertEquals("name", "COCT_MT011001CA", NameHelper.getOwnedEntryPoint(document.getDocumentElement()));
	}
}
