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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

import ca.infoway.messagebuilder.lang.MockBean;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class GenericsTest {
	
	@Test
		public void testGetParameterType() throws Exception {
			assertEquals("type", String.class, Generics.getParameterType(getProperty("names")));
		}
	
	public PropertyDescriptor getProperty(String name) throws Exception {
		PropertyDescriptor result = null;
		PropertyDescriptor[] descriptors = Introspector.getBeanInfo(MockBean.class).getPropertyDescriptors();
		for (PropertyDescriptor descriptor : descriptors) {
			if (name.equals(descriptor.getName())) {
				result = descriptor;
				break;
			}
		}
		return result;
	}
	
	@Test
	public void testIsCollection() throws Exception {
		assertTrue("collection", Generics.isCollectionParameterizedType(getProperty("names").getReadMethod().getGenericReturnType()));
	}
}
