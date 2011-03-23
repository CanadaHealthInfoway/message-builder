package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;


public class ParserFactoryImplTest {

	@SuppressWarnings("unchecked")
	@Test
	public void shouldRegisterAllParsers() throws Exception {
		List<Class<?>> classes = new ClassFinder().findClasses(ParserFactoryImpl.class, Predicates.isInstanceofPredicate(SimpleXmlParser.class));
		
		Map<StandardDataType, Class<? extends SimpleXmlParser>> map = new ParserFactoryImpl().map;
		for (Class<?> c : classes) {
			if (!c.isInterface() && !Modifier.isAbstract(c.getModifiers())) {
				assertTrue(ClassUtils.getShortClassName(c), map.containsValue(c));
			}
		}
	}
}
