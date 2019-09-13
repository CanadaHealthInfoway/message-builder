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

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class StringArrayToAnnotationDecoratorTest {
	
	@Test
	public void shouldProcessEmptyArrays() throws Exception {
		
		assertEquals("", new StringArrayToAnnotationDecorator().render());
		assertEquals("", new StringArrayToAnnotationDecorator((String[]) null).render());
	}
	
	@Test
	public void shouldProcessStandardInput() throws Exception {
		assertEquals("\"a\",\"b\",\"c\"", new StringArrayToAnnotationDecorator("a", "b", "c").render());
		assertEquals("\"a\",\"\",\"c\"", new StringArrayToAnnotationDecorator("a", "", "c").render());
		assertEquals("\"a\",\"\",\"c\"", new StringArrayToAnnotationDecorator("a", null, "c").render());
	}
	
	@Test
	public void shouldProcessSingleValueInput() throws Exception {
		assertEquals("\"a\"", new StringArrayToAnnotationDecorator("a").render());
	}
}
