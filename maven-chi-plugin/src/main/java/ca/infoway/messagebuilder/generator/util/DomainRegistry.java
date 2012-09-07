/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.Predicates;

public class DomainRegistry {
	
	public static DomainRegistry instance;
	
	private final Map<String, DomainType> domains;

	DomainRegistry(Map<String, DomainType> map) {
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
			Map<String, DomainType> map = new HashMap<String,DomainType>();
			List<Class<?>> classes = new ClassFinder().findClasses(Code.class, Predicates.isInstanceofPredicate(Code.class, true));
			for (Class<?> c : classes) {
				map.put(ClassUtils.getShortClassName(c).toLowerCase(), new ClassBasedDomainType(c));
			}
			instance = new DomainRegistry(map);
		}
	}
	
	/**
	 * <p>Return the class that 
	 * @param vocabularyDomainName
	 * @return
	 */
	public DomainType getDomainType(String vocabularyDomainName) {
		return vocabularyDomainName == null ? null : this.domains.get(vocabularyDomainName.toLowerCase());
	}

	public void register(String domainType, PackageName packageName, Collection<String> parentDomainTypes) {
		if (!this.domains.containsKey(domainType.toLowerCase())) {
			List<DomainType> parents = getDomainTypes(parentDomainTypes);
			this.domains.put(domainType.toLowerCase(), new SpecificationDomainType(domainType, packageName, parents));
		}
	}

	private List<DomainType> getDomainTypes(Collection<String> parentDomainTypes) {
		List<DomainType> result = new ArrayList<DomainType>();
		
		for (String parent : parentDomainTypes) {
			DomainType domainType = getDomainType(parent);
			if (domainType != null) {
				result.add(domainType);
			}
		}
		
		return result;
	}

	public List<DomainType> getAllSpecificationDomainTypes() {
		List<DomainType> result = new ArrayList<DomainType>();
		for (DomainType domainType : this.domains.values()) {
			if (domainType instanceof SpecificationDomainType) {
				result.add(domainType);
			}
		}
		return result;
	}
}
