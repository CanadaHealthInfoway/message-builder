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
