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

import java.beans.PropertyDescriptor;

import org.apache.commons.lang.ClassUtils;

/**
 * <p>An exception that indicates that a problem was encountered while
 * performing reflection on a bean.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class BeanReflectionException extends RuntimeException {

	private static final long serialVersionUID = -7767648387814671605L;

	/**
	 * <p>Standard constructor.
	 * @param beanProperty - the bean property that caused the exception.
	 * @param cause - the problem that was encountered.
	 */
	public BeanReflectionException(BeanProperty beanProperty, Throwable cause) {
		this(beanProperty.getBeanType(), beanProperty.getDescriptor(), cause);
	}
	/**
	 * <p>Standard constructor.
	 * @param beanClass - the bean type that caused the exception.
	 * @param descriptor - the descriptor of the property that caused the exception.
	 * @param cause - the problem that was encountered.
	 */
	public BeanReflectionException(Class<?> beanClass, PropertyDescriptor descriptor, Throwable cause) {
		super("Exception thrown while trying to work with property " 
				+ descriptor.getName() 
				+ " on " + ClassUtils.getShortClassName(beanClass), cause);
	}
	/**
	 * <p>Standard constructor.
	 * @param e - the problem that was encountered.
	 */
	public BeanReflectionException(Throwable e) {
		super(e.toString(), e);
	}
}
