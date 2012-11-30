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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;


public class ParserFactoryImplTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldRegisterAllParsers() throws Exception {
		List<Class<?>> classes = new ClassFinder().findClasses(ParserFactoryImpl.class, Predicates.isInstanceofPredicate(SimpleXmlParser.class));
		
		Map<StandardDataType, Class<? extends SimpleXmlParser>> map = new ParserFactoryImpl().map;
		for (Class<?> c : classes) {
			if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers())) {
				assertTrue(ClassUtils.getShortClassName(c), map.containsValue(c));
			}
		}
	}
}
