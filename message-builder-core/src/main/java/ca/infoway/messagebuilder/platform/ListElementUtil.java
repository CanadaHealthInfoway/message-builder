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

package ca.infoway.messagebuilder.platform;

import java.util.Collection;
import java.util.List;

/**
 * <p>Access an element of a list.
 * 
 * <p>Because of the oddities of C# generics, it's very hard
 * to downcast a list to a generic list type.  This utility will vary on the 
 * two platforms.
 * 
 * @sharpen.ignore platform
 */
public class ListElementUtil {

	public static boolean isCollection(Object list) {
		return list instanceof Collection<?>;
	}

	public static boolean isCollection(Class<?> propertyType) {
		return List.class.isAssignableFrom(propertyType);
	}
	
	public static Object getElement(Object list, int index) {
		if (list == null) {
			return null;
		} else if (list instanceof List<?>) {
			return ((List<?>) list).get(index);
		} else {
			throw new IllegalArgumentException("Expected argument to be a list, but was " + list.getClass());
		}
	}

	public static int count(Object list) {
		if (list == null) {
			return 0;
		} else if (list instanceof Collection<?>) {
			return ((Collection<?>) list).size();
		} else {
			throw new IllegalArgumentException("Expected argument to be a list, but was " + list.getClass());
		}
	}

	public static boolean isEmpty(Object list) {
		if (list == null) {
			return true;
		} else if (list instanceof Collection<?>) {
			return ((Collection<?>) list).isEmpty();
		} else {
			throw new IllegalArgumentException("Expected argument to be a list, but was " + list.getClass());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void addElement(Object list, Object element) {
		((Collection) list).add(element);
	}
	@SuppressWarnings("unchecked")
	public static void addAllElements(Object list, Object elementList) {
		((Collection) list).addAll((Collection) elementList);
	}

}
