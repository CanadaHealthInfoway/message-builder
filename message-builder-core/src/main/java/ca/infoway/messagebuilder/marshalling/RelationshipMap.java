package ca.infoway.messagebuilder.marshalling;

import java.util.LinkedHashMap;
import java.util.Map;

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
	
	class Key {
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
		public int hashCode() {
			return new HashCodeBuilder().append(this.name).append(this.type).toHashCode();
		}
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
		this.relationships.put(new Key(mapping), beanProperty);
	}

	void put(Mapping mapping, RelationshipSorter sorter) {
		this.relationships.put(new Key(mapping), sorter);
	}

	@Deprecated
	Object get(String relationshipName) {
		return this.relationships.get(new Key(relationshipName));
	}

	boolean containsMapping(Mapping mapping) {
		return this.relationships.containsKey(new Key(mapping));
	}

	Object get(NamedAndTyped relationship) {
		Object result = this.relationships.get(new Key(relationship));
		if (result == null) {
			result = this.relationships.get(new Key(relationship.getName()));
		}
		return result;
	}
}
