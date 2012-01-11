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

package ca.infoway.messagebuilder.platform;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

/**
 * @sharpen.ignore platform
 */
public class ClassUtil {

	public static boolean isAbstract(Class<?> javaClass) {
		return Modifier.isAbstract(javaClass.getModifiers());
	}

	@SuppressWarnings("unchecked")
	public static Object newInstance(Class type) {
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException("Unable to instantiate " + type);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to instantiate " + type);
		}
	}
	
	public static boolean isGeneric(Class<?> partClass) {
		TypeVariable<?>[] parameters = partClass.getTypeParameters();
		return parameters != null && parameters.length > 0;
	}
}
