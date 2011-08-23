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

package ca.infoway.messagebuilder.devtools;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.GenericClassUtil;


public class MessageBeanFactory {

	private final ValueHolder valueHolder;
	
	public MessageBeanFactory(ValueHolder valueHolder) {
		this.valueHolder = valueHolder;
	}

	public <T extends InteractionBean> T populate(T hl7MessageBean) {
		assignAllDefaults(hl7MessageBean, this.valueHolder);
		return hl7MessageBean;
	}

	private void assignAllDefaults(Object hl7MessageBean, Object defaultValues) {
		Map<String, BeanProperty> properties = BeanProperty.getProperties(hl7MessageBean);
		for (String propertyName : properties.keySet()) {
			BeanProperty property = properties.get(propertyName);
			if (isDefaultPresent(propertyName, defaultValues)) {
				assignValue(property, hl7MessageBean, defaultValues);
			}
		}
	}
	
	private void assignValue(BeanProperty property, Object hl7MessageBean, Object defaultValues) {
		BeanProperty defaultProperty = BeanProperty.getProperty(defaultValues, property.getName());
		defaultProperty.getReadMethod().setAccessible(true);
		Object value = defaultProperty.get();

		setValue(property, value);
	}
	
	@SuppressWarnings("unchecked")
	private void setValue(BeanProperty property, Object value) {
		if (value == null) {
			// do nothing
		} else if (Collection.class.isAssignableFrom(value.getClass()) && property.isCollection()) {
			for (Object o : ((Collection) value)) {
				Class clazz = GenericClassUtil.getCollectionContentsType(property);
				if (clazz == null || clazz.isAssignableFrom(o.getClass())) {
					((Collection) property.get()).add(o);
				} else {
					Object newInstance = ClassUtil.newInstance(clazz);
					assignAllDefaults(newInstance, o);
					((Collection) property.get()).add(newInstance);
				}
			}
		} else if (property.isCollection()) {
			((Collection) property.get()).add(value);
		} else if (Collection.class.isAssignableFrom(value.getClass())) {
			for (Object o : ((Collection) value)) {
				property.set(o);
			}
		} else if (!isStandardDataType(property)) {
			createBeanInstanceForProperty(property);
			assignAllDefaults(property.get(), value);
		} else if (property.isWritable()) {
			property.set(value);
		}
	}

	private void createBeanInstanceForProperty(BeanProperty property) {
		if (property.get() == null) {
			try {
				property.set(property.getPropertyType().newInstance());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isStandardDataType(BeanProperty property) {
		String packageName = ClassUtils.getPackageName(property.getPropertyType());
		if (packageName.startsWith("java.")) {
			return true;
		} else if (StringUtils.equals(packageName, ClassUtils.getPackageName(Identifier.class))) {
			return true;
		} else if (Code.class.isAssignableFrom(property.getPropertyType())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isDefaultPresent(String propertyName, Object defaultValues) {
		return BeanProperty.getProperty(defaultValues, propertyName) != null;
	}
}

