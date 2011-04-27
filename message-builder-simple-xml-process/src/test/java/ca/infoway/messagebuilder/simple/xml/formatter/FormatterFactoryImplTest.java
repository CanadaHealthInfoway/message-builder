/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;

public class FormatterFactoryImplTest {

	@Test
	public void shouldLookupFormatter() throws Exception {
		SimpleXmlFormatter formatter = new FormatterFactoryImpl().createFormatter("integer");
		assertNotNull("formatter", formatter);
	}
	
	@Test
	public void shouldDetermineSimpleDataType() throws Exception {
		assertTrue("simple type: integer", new FormatterFactoryImpl().isSimpleDataType("integer"));
		assertTrue("simple type: money", new FormatterFactoryImpl().isSimpleDataType("Money"));
	}
	
	@Test
	public void shouldRegisterAllFormatters() throws Exception {
		List<Class<?>> classes = new ClassFinder().findClasses(FormatterFactoryImpl.class, Predicates.isInstanceofPredicate(SimpleXmlFormatter.class));
		
		for (Class<?> c : classes) {
			if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers())) {
				Map<String, Class<? extends SimpleXmlFormatter>> map = new FormatterFactoryImpl().map;
				assertTrue(ClassUtils.getShortClassName(c), map.containsValue(c));
			}
		}
		
	}
}
