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

package ca.infoway.messagebuilder.j5goodies;

import java.lang.annotation.Annotation;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Provides some standard class finder predicates.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class Predicates {

	/**
	 * <p>Construct a predicate that finds all classes in a particular package.
	 * 
	 * @param expectedPackageName - the package
	 * @return - the predicate
	 */
	public static ClassPredicate packageNamePredicate(final String expectedPackageName) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(String packageName, String className) {
				return StringUtils.equals(expectedPackageName, packageName);
			}
		};
	}
	/**
	 * <p>Construct a predicate that finds all classes with a particular annotation.
	 * 
	 * @param annotation - the annotation
	 * @return - the predicate
	 */
	public static ClassPredicate hasAnnotationPredicate(final Class<? extends Annotation> annotation) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				return c != null && c.isAnnotationPresent(annotation);
			}
		};
	}
	
	/**
	 * <p>Construct a predicate that finds all classes of a particular type.
	 * 
	 * @param type - the type
	 * @return - the predicate
	 */
	public static ClassPredicate isInstanceofPredicate(final Class<?> type) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				return c != null && type != null && type.isAssignableFrom(c);
			}
		};
	}

	/**
	 * <p>Construct a predicate that finds all classes of a particular type.
	 * 
	 * @param type - the type
	 * @param isInterface - true if the predicate should only return interfaces; 
	 *      false if the predicate should never return interfaces
	 * @return - the predicate
	 */
	public static ClassPredicate isInstanceofPredicate(final Class<?> type, final boolean isInterface) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				// TM - bugfix: "isInterface = true" would only return interfaces (as expected), but "isInterface = false" would return everything 
				return c != null && type != null && type.isAssignableFrom(c) && (isInterface == c.isInterface());
			}
		};
	}
	
}

