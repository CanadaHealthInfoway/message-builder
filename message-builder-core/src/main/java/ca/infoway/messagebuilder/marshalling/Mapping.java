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

package ca.infoway.messagebuilder.marshalling;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

public class Mapping {

	static class PartTypeMapping {
		private final String type;
		private final String name;

		PartTypeMapping(String name, String type) {
			this.name = name;
			this.type = type;
		}
		public String getType() {
			return this.type;
		}
		public String getName() {
			return this.name;
		}
		public PartTypeMapping skip(String first) {
			if (this.name.startsWith(first + "/")) {
				return new PartTypeMapping(StringUtils.substringAfter(name, first + "/"), type);
			} else {
				throw new IllegalStateException("mapping does not start with " + first);
			}
		}
	}
	
	private static Map<PropertyDescriptor, List<Mapping>> mappingCache = new HashMap<PropertyDescriptor, List<Mapping>>();

	private final String mapping;
	private final List<PartTypeMapping> mappings;
	
	Mapping(String mapping, List<PartTypeMapping> mappings) {
		this.mapping = mapping;
		this.mappings = mappings;
	}

	public boolean isCompound() {
		return this.mapping.contains("/");
	}

	static List<Mapping> from(List<String> mappings, Hl7MapByPartType[] exceptions) {
		List<Mapping> result = new ArrayList<Mapping>();
		for (String mapping : EmptyIterable.<String>nullSafeIterable(mappings)) {
			result.add(new Mapping(mapping, extractPartTypeMappings(exceptions)));
		}
		return result;
	}
	private static List<PartTypeMapping> extractPartTypeMappings(Hl7MapByPartType[] exceptions) {
		
		List<PartTypeMapping> mappings = new ArrayList<PartTypeMapping>();
		if (exceptions != null) {
			for (Hl7MapByPartType nameValuePair : exceptions) {
				mappings.add(new PartTypeMapping(nameValuePair.name(), nameValuePair.type()));
			}
		}
		
		return mappings;
	}

	public static List<Mapping> from(BeanProperty property) {
		if (mappingCache.containsKey(property.getDescriptor())) {
			return mappingCache.get(property.getDescriptor());
		}
		// This is an expensive operation. If possible, let's try to do it only once.
		Hl7XmlMapping mapping = property.getAnnotation(Hl7XmlMapping.class);
		Hl7MapByPartType[] exceptions = MappingHelper.getAllHl7MapByPartType(property);
		List<Mapping> mappingList = from(mapping, exceptions);
		mappingCache.put(property.getDescriptor(), mappingList);
		return mappingList;
	}

	private static List<Mapping> from(Hl7XmlMapping mapping, Hl7MapByPartType[] exceptions) {
		return mapping == null ? Collections.<Mapping>emptyList() : from(Arrays.asList(mapping.value()), exceptions);
	}

	@Override
	public String toString() {
		return this.mapping;
	}

	public String first() {
		return isCompound() ? StringUtils.substringBefore(this.mapping, "/") : this.mapping;
	}
	public Mapping rest() {
		return isCompound() ? new Mapping(StringUtils.substringAfter(this.mapping, "/"), extractMatchingMappings(this.mappings, first())) : null;
	}

	public Mapping firstPart() {
		return new Mapping(first(), this.mappings);
	}

	private static List<PartTypeMapping> extractMatchingMappings(List<PartTypeMapping> mappings, String first) {
		List<PartTypeMapping> result = new ArrayList<PartTypeMapping>();
		for (PartTypeMapping partTypeMapping : mappings) {
			if (partTypeMapping.getName().startsWith(first + "/")) {
				result.add(partTypeMapping.skip(first));
			}
		}
		return result;
	}

	public String getName() {
		return this.mapping;
	}

	public List<NamedAndTyped> getAllTypes() {
		return getAllTypes(this.mapping);
	}

	private List<NamedAndTyped> getAllTypes(String suppliedMapping) {
		List<NamedAndTyped> types = new ArrayList<NamedAndTyped>();
		if (hasPartTypeMappings()) {
			for (PartTypeMapping map : this.mappings) {
				if (StringUtils.equals(suppliedMapping, map.getName())) {
					types.add(new RelationshipMap.Key(suppliedMapping, map.getType()));
				}
			}
		} else {
			types.add(new RelationshipMap.Key(suppliedMapping));
		}
		return types;
	}
	
	public List<NamedAndTyped> getAllTypesIncludingAttribute() {
		List<NamedAndTyped> results = getAllTypes();
		if (results.isEmpty() && isCompound()) {
			// this mapping is likely for an attribute; back the mapping up one step to find type matches
			int lastSlash = this.mapping.lastIndexOf('/');
			String newMapping = this.mapping.substring(0, lastSlash);
			results = getAllTypes(newMapping);
		}
		return results;
	}

	public boolean hasPartTypeMappings() {
		return CollectionUtils.isNotEmpty(this.mappings);
	}
}
