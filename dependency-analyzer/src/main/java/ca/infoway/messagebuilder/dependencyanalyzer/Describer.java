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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.dependencyanalyzer;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class Describer {

	public String getDescription(Object o) {
		if (o == null) {
			return null;
		} else if (o instanceof String) {
			return (String) o;
		} else if (hasNameProperty(o)) {
			return getName(o);
		} else {
			return o.toString();
		}
	}

	private String getName(Object o) {
		try {
			return (String) PropertyUtils.getSimpleProperty(o, "name");
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean hasNameProperty(Object o) {
		try {
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(o, "name");
			return descriptor != null && String.class.equals(descriptor.getPropertyType());
		} catch (IllegalAccessException e) {
			return false;
		} catch (InvocationTargetException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}

}
