package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;

import org.junit.Assume;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.ClassPredicate;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class DataTypeIntegrityTest {
	
	public static Class<?>[] DATA_TYPES = collectAllDataTypes(); 
	
	@Test
	public void shouldBeWellDefined() throws Exception {
		for (Class<?> dataType : DATA_TYPES) {
			assertDataTypeMustDefineCorrectGetDataType(dataType);
			assertDataTypeMustHaveDefaultConstructor(dataType);
		}
	}
	
	private void assertDataTypeMustHaveDefaultConstructor(Class<?> dataType) throws Exception {
		Assume.assumeTrue(!LIST.class.isAssignableFrom(dataType));
		Assume.assumeTrue(!SET.class.isAssignableFrom(dataType));
		assertNotNull(dataType + " is missing default constructor", hasPublicDefaultConstructor(dataType));
	}

	private void assertDataTypeMustDefineCorrectGetDataType(Class<?> dataType) throws Exception {
		Assume.assumeTrue(!LIST.class.isAssignableFrom(dataType));
		Assume.assumeTrue(!SET.class.isAssignableFrom(dataType));
		assertTrue(dataType + " does not have correct getDataType", hasCorrectGetDataType(dataType));
	}
	
	private boolean hasCorrectGetDataType(Class<?> dataType) throws InstantiationException, IllegalAccessException {
		ANY any = (ANY) dataType.newInstance();
		
		StandardDataType standardDataType = any.getDataType();
		
		return standardDataType != null && any.getClass().getSimpleName().startsWith(standardDataType.getRootType());
	}

	private Constructor<?> hasPublicDefaultConstructor(Class<?> dataType) throws NoSuchMethodException {
		try {
			return dataType.getConstructor(null);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
	
	private static Class<?>[] collectAllDataTypes() {
		return new ClassFinder().findClasses(ANY.class, new ClassPredicate() {
			public boolean isSelected(String packageName, String className) {
				return "ca.infoway.messagebuilder.datatype.impl".equals(packageName)
				    && className.endsWith("Impl");
			}
			public boolean isSelected(Class<?> c) {
				return ANY.class.isAssignableFrom(c);
			}
		}).toArray(new Class<?>[]{});
	}

}
