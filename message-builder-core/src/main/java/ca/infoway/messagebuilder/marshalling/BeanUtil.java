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

package ca.infoway.messagebuilder.marshalling;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

class BeanUtil {

	private static final String XPATH_SEPARATOR = "/";
		
	public static <T> T instantiate(Class<? extends T> value) {
		try {
			return (T) value.newInstance();
		} catch (Exception e) {
			throw new MarshallingException(e);
		}
	}
	
	public static String describeBeanPath(Object bean, String xpath) {
		StringBuilder result = new StringBuilder();
		if (bean != null && StringUtils.isNotBlank(xpath)) {
			describeBeanPath(bean, xpath.trim(), result);
		}
		return result.toString();
	}

	private static void describeBeanPath(Object bean, String xpath, StringBuilder result) {
		List<String> pathParts = obtainParts(xpath);
		removePartType(bean, pathParts);
		
		result.append(bean.getClass().getSimpleName()).append('.');
		
		RelationshipSorter sorter = RelationshipSorter.create("", bean);
		for (String part : pathParts) {
			Object sorterObj = sorter.get(part);
			if (sorterObj instanceof RelationshipSorter) {
				sorter = (RelationshipSorter) sorterObj;
			} else if (sorterObj instanceof BeanProperty) {
				BeanProperty beanProperty = (BeanProperty) sorterObj;
//				result.append(beanProperty.getPropertyType().getSimpleName()).append('.');  // BEAN PATH
				result.append(beanProperty.getName()).append('.');                          // ACCESSOR PATH
				sorter = RelationshipSorter.create("", beanProperty.get()); 
			} else {
				// if can't find a mapping match then stop here
				// just append letfover parts? i.e. a.b.c (.leftover1.leftover2)
				break;
			}
		}
		if (result.charAt(result.length() - 1) == '.') {
			result.deleteCharAt(result.length() - 1);
		}
	}

	private static void removePartType(Object bean, List<String> pathParts) {
		if (isNotEmpty(pathParts)) {
			if (hasPartType(bean, pathParts.get(0))) {
				pathParts.remove(0);
			}
		}
	}

	private static boolean hasPartType(Object bean, String part) {
		boolean result = false;
		if (bean.getClass().isAnnotationPresent(Hl7PartTypeMapping.class)) {
			Hl7PartTypeMapping partType = bean.getClass().getAnnotation(Hl7PartTypeMapping.class);
			String[] values = partType.value();
			result = values.length > 0 && values[0].equals(part);
		}
		return result;
	}

	private static List<String> obtainParts(String xpath) {
		// need to handle attribute ('@') in xpath - currently attributes are not included in any of our error xpaths,
		//                                          so not handling this situation for now
		if (xpath.startsWith(XPATH_SEPARATOR)) {
			xpath = xpath.substring(1);
		}
		List<String> fixedList = Arrays.asList(xpath.split(XPATH_SEPARATOR));
		// need to return a modifiable list
		return new ArrayList<String>(fixedList);
	}

}
