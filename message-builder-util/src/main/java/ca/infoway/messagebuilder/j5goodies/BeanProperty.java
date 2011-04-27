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

package ca.infoway.messagebuilder.j5goodies;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>A class to make bean reflection easier.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class BeanProperty {
	
	private final PropertyDescriptor descriptor;
	private final Object bean;

	private BeanProperty(Object bean, PropertyDescriptor descriptor) {
		this.bean = bean;
		this.descriptor = descriptor;
	}

	/**
	 * <p>Get the type of the property's bean.
	 * @return - the bean type
	 */
	public Class<?> getBeanType() {
		return this.bean.getClass();
	}
	/**
	 * <p>Get the property name.
	 * @return - the name
	 */
	public String getName() {
		return this.descriptor.getName();
	}
	
	/**
	 * <p>Get the declared type of the property.
	 * @return - the property type
	 */
	public Class<?> getPropertyType() {
		return this.descriptor.getPropertyType();
	}
	
	/**
	 * <p>Indicate whether or not the bean is readable.
	 * @return - true is the bean is readable; false otherwise.
	 */
	public boolean isReadable() {
		return this.descriptor.getReadMethod() != null;
	}
	
	/**
	 * <p>Indicate whether or not the bean is writable.
	 * @return - true is the bean is writable; false otherwise.
	 */
	public boolean isWritable() {
		return getWriteMethod() != null;
	}
	
	/**
	 * <p>Get the read method of the bean property.
	 * @return - the read method.
	 */
	public Method getReadMethod() {
		Method readMethod = this.descriptor.getReadMethod();
		if (readMethod != null && readMethod.isBridge()) {
			readMethod = findNonBridgeMethod(readMethod);
		}
		return readMethod;
	}
	
	private Method findNonBridgeMethod(Method bridgeMethod) {
		Method method = bridgeMethod;
		try {
			method = bridgeMethod.getDeclaringClass().getMethod(bridgeMethod.getName(), bridgeMethod.getParameterTypes());
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		}
		return method;
	}
	
	/**
	 * <p>Get the write method of the bean property.
	 * @return - the write method.
	 */
	public Method getWriteMethod() {
		return this.descriptor.getWriteMethod();
	}

	/**
	 * <p>Set the property value.
	 * @param value - the new value
	 */
	public void set(Object value) {
		try {
			this.descriptor.getWriteMethod().invoke(this.bean, new Object[] { value });
		} catch (IllegalAccessException e) {
			throw new BeanReflectionException(this, e);
		} catch (InvocationTargetException e) {
			throw new BeanReflectionException(this, e);
		}
	}

	/**
	 * <p>Get the property value.
	 * @return - the value
	 */
	public Object get() {
		try {
			return this.descriptor.getReadMethod().invoke(this.bean, new Object[0]);
		} catch (IllegalAccessException e) {
			throw new BeanReflectionException(this, e);
		} catch (InvocationTargetException e) {
			throw new BeanReflectionException(this, e);
		}
	}

	/**
	 * <p>Get all properties of the bean.
	 * @param bean - the bean to introspect.
	 * @return - a map of all properties, keyed by property name.
	 */
	public static Map<String,BeanProperty> getProperties(Object bean) {
		Map<String,BeanProperty> properties = new HashMap<String,BeanProperty>();
		try {
			if (bean != null) {
				PropertyDescriptor[] descriptors = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
				for (PropertyDescriptor descriptor : descriptors) {
					properties.put(descriptor.getName(), new BeanProperty(bean, descriptor));
				}
			}
		} catch (IntrospectionException e) {
		}
		return properties;
	}

	/**
	 * <p>Get a specific property.
	 * @param bean - the bean to be introspected.
	 * @param propertyName - the name of the property
	 * @return - the property, or null if the property name does not exist.
	 */
	public static BeanProperty getProperty(Object bean, String propertyName) {
		return getProperties(bean).get(propertyName);
	}

	/**
	 * <p>Get the property descriptor.
	 * @return - the descriptor.
	 */
	public PropertyDescriptor getDescriptor() {
		return this.descriptor;
	}
	/**
	 * <p>Get the bean.
	 * @return - the bean.
	 */
	public Object getBean() {
		return this.bean;
	}

	/**
	 * <p>Indicates whether or not the property type is a collection.
	 * @return - true if the property type is a collection; false otherwise.
	 */
	public boolean isCollection() {
		return Collection.class.isAssignableFrom(getPropertyType());
	}
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		if (getReadMethod() == null) {
			return null;
		} else {
			return getReadMethod().getAnnotation(annotationType);
		}
	}
}
