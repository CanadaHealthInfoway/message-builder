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

package ca.infoway.messagebuilder.platform;

import java.lang.reflect.Type;
import java.util.Map;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * @sharpen.ignore platform
 */
public class GenericClassUtil {

	public static Object instantiate(Class<?> partClass, Map<String, Class<?>> map) 
			throws InstantiationException, IllegalAccessException {
		return partClass.newInstance();
	}

	public static Class<?> getCollectionContentsType(BeanProperty property) {
		Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) (property.getDescriptor().getReadMethod().getGenericReturnType())).getActualTypeArguments();
		return actualTypeArguments != null && actualTypeArguments.length > 0 ? (Class<?>) actualTypeArguments[0] : null;
	}

}
