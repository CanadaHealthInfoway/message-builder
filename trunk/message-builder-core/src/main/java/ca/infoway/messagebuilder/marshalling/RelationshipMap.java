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

package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * <p>This class maps the individual HL7 relationships to either a 
 * bean property or to an instance of a relationship sorter.  If the 
 * bean's representation of the relationship is nested, then we get a 
 * relationship sorter; otherwise it's a bean property.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class RelationshipMap {
	
	static class Key implements NamedAndTyped {
		private final String name;
		private final String type;
		Key(NamedAndTyped namedAndTyped) {
			this.name = namedAndTyped.getName();
			this.type = namedAndTyped.getType();
		}
		Key(String name, String type) {
			this.name = name;
			this.type = type;
		}
		Key(String name) {
			this.name = name;
			this.type = null;
		}
		public String getName() {
			return this.name;
		}
		public String getType() {
			return this.type;
		}
		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(this.name).append(this.type).toHashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else if (obj == this) {
				return true;
			} else if (obj.getClass() != getClass()) {
				return false;
			} else {
				Key that = (Key) obj;
				return new EqualsBuilder()
						.append(this.name, that.name)
						.append(this.type, that.type)
						.isEquals();
			}
		}
		@Override
		public String toString() {
			return "Key: " + this.name + " (" + this.type + ")";
		}
	}

	private final Map<Key, Object> relationships = new LinkedHashMap<Key,Object>();

	void put(Mapping mapping, BeanProperty beanProperty) {
		for (NamedAndTyped namedAndTyped : mapping.getAllTypes()) {
			this.relationships.put(new Key(namedAndTyped), beanProperty);
		}
	}

	void put(Mapping mapping, RelationshipSorter sorter) {
		for (NamedAndTyped namedAndTyped : mapping.getAllTypes()) {
			this.relationships.put(new Key(namedAndTyped), sorter);
		}
	}

	@Deprecated
	Object get(String relationshipName) {
		return this.relationships.get(new Key(relationshipName));
	}

	List<Key> getAllTypeBased(String relationshipName) {
		List<Key> result = new ArrayList<Key>();
		Set<Key> keySet = this.relationships.keySet();
		for (Key key : keySet) {
			if (relationshipName.equals(key.getName()) && key.getType() != null) {
				result.add(key);
			}
		}
		return result;
	}

	boolean containsMapping(Mapping mapping) {
		return this.relationships.containsKey(new Key(mapping.getAllTypes().get(0)));
	}

	Object get(NamedAndTyped relationship) {
		Object result = this.relationships.get(new Key(relationship));
		if (result == null) {
			result = this.relationships.get(new Key(relationship.getName()));
		}
		return result;
	}
}
