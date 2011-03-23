package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;

public class FormatterFactoryImplTest {

	@Test
	public void shouldLookupFormatter() throws Exception {
		SimpleXmlFormatter formatter = new FormatterFactoryImpl().createFormatter("integer");
		assertNotNull("formatter", formatter);
	}
	
	@Test
	public void shouldDetermineSimpleDataType() throws Exception {
		assertTrue("simple type: integer", new FormatterFactoryImpl().isSimpleDataType("integer"));
		assertTrue("simple type: money", new FormatterFactoryImpl().isSimpleDataType("Money"));
	}
	
	@Test
	public void shouldRegisterAllFormatters() throws Exception {
		List<Class<?>> classes = new ClassFinder().findClasses(FormatterFactoryImpl.class, Predicates.isInstanceofPredicate(SimpleXmlFormatter.class));
		
		for (Class<?> c : classes) {
			if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers())) {
				Map<String, Class<? extends SimpleXmlFormatter>> map = new FormatterFactoryImpl().map;
				assertTrue(ClassUtils.getShortClassName(c), map.containsValue(c));
			}
		}
		
	}
}
