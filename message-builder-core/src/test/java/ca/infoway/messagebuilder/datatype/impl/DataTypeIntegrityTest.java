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

package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;

import org.junit.Assume;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.ClassPredicate;

/**
 * @sharpen.ignore - datatype - Test is more applicable to Java than .NET as long as .NET classes are manually translated correctly.
 */
public class DataTypeIntegrityTest {
	
	public static Class<?>[] DATA_TYPES = collectAllDataTypes(); 
	
	@Test
	public void shouldBeWellDefined() throws Exception {
		for (Class<?> dataType : DATA_TYPES) {
			assertDataTypeMustDefineCorrectGetDataType(dataType);
			assertDataTypeMustHaveDefaultConstructor(dataType);
		}
	}
	
	private void assertDataTypeMustHaveDefaultConstructor(Class<?> dataType) throws Exception {
		Assume.assumeTrue(!LIST.class.isAssignableFrom(dataType));
		Assume.assumeTrue(!SET.class.isAssignableFrom(dataType));
		assertNotNull(dataType + " is missing default constructor", hasPublicDefaultConstructor(dataType));
	}

	private void assertDataTypeMustDefineCorrectGetDataType(Class<?> dataType) throws Exception {
		Assume.assumeTrue(!LIST.class.isAssignableFrom(dataType));
		Assume.assumeTrue(!SET.class.isAssignableFrom(dataType));
		assertTrue(dataType + " does not have correct getDataType", hasCorrectGetDataType(dataType));
	}
	
	private boolean hasCorrectGetDataType(Class<?> dataType) throws InstantiationException, IllegalAccessException {
		ANY any = (ANY) dataType.newInstance();
		
		StandardDataType standardDataType = any.getDataType();
		
		return standardDataType != null && any.getClass().getSimpleName().startsWith(standardDataType.getRootType());
	}

	private Constructor<?> hasPublicDefaultConstructor(Class<?> dataType) throws NoSuchMethodException {
		try {
			return dataType.getConstructor(null);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
	
	private static Class<?>[] collectAllDataTypes() {
		return new ClassFinder().findClasses(ANY.class, new ClassPredicate() {
			public boolean isSelected(String packageName, String className) {
				return "ca.infoway.messagebuilder.datatype.impl".equals(packageName)
				    && className.endsWith("Impl");
			}
			public boolean isSelected(Class<?> c) {
				return ANY.class.isAssignableFrom(c);
			}
		}).toArray(new Class<?>[]{});
	}

}
