package ca.infoway.messagebuilder.generator.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;

public class DomainRegistry {
	
	public static DomainRegistry instance;
	
	private final Map<String, Class<?>> domains;

	DomainRegistry(Map<String, Class<?>> map) {
		this.domains = map;
	}

	public static DomainRegistry getInstance() {
		if (instance == null) {
			initialize();
		}
		
		return instance;
	}

	private static synchronized void initialize() {
		if (instance == null) {
			Map<String, Class<?>> map = new HashMap<String,Class<?>>();
			List<Class<?>> classes = new ClassFinder().findClasses(Code.class, Predicates.isInstanceofPredicate(Code.class, true));
			for (Class<?> c : classes) {
				map.put(ClassUtils.getShortClassName(c).toLowerCase(), c);
			}
			instance = new DomainRegistry(map);
		}
	}
	
	/**
	 * <p>Return the class that 
	 * @param vocabularyDomainName
	 * @return
	 */
	public Class<?> getDomainType(String vocabularyDomainName) {
		return vocabularyDomainName == null ? null : this.domains.get(vocabularyDomainName.toLowerCase());
	}
}
