package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.platform.ListElementUtil;

/**
 * <p>This class exists to make it a bit easier to collate information about 
 * collapsed beans.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class RelationshipSorter {
	
	private final RelationshipMap map = new RelationshipMap();
	private final Map<String, BeanProperty> properties = new LinkedHashMap<String,BeanProperty>();
	
	private final Class<?> beanType;
	private final Object bean;
	private final String propertyName;
	private final boolean collapsed;
	
	RelationshipSorter(String propertyName, Class<?> beanType, Object bean) {
		this(propertyName, beanType, bean, false);
	}

	private RelationshipSorter(String propertyName, Class<?> beanType, Object bean, boolean collapsed) {
		this.propertyName = propertyName;
		this.beanType = beanType;
		this.bean = bean;
		this.collapsed = collapsed;
	}
	
	Class<?> getBeanType() {
		return this.beanType;
	}

	void add(Mapping mapping, BeanProperty beanProperty) {
		this.properties.put(beanProperty.getName(), beanProperty);
		if (!mapping.isCompound()) {
			this.map.put(mapping, beanProperty);
		} else {
			if (!this.map.containsMapping(mapping.firstPart())) {
				RelationshipSorter sorter = new RelationshipSorter(beanProperty.getName(), getBeanType(), getBean(), true);
				this.map.put(mapping.firstPart(), sorter);
			}
			getAsRelationshipSorter(mapping.firstPart()).add(mapping.rest(), beanProperty);
		}
	}
	
	RelationshipSorter getAsRelationshipSorter(NamedAndTyped relationship) {
		return (RelationshipSorter) this.map.get(relationship);
	}
	
	static RelationshipSorter create(String propertyName, Object tealBean) {
		RelationshipSorter holder = new RelationshipSorter(propertyName, tealBean == null ? null : tealBean.getClass(), tealBean);
		Map<String,BeanProperty> properties = BeanProperty.getProperties(tealBean);
		for (BeanProperty property : properties.values()) {
			List<Mapping> mappings = Mapping.from(property);
			for (Mapping mapping : mappings) {
				holder.add(mapping, property);
			}
		}
		return holder;
	}

	boolean isCollapsedRelationship(NamedAndTyped relationshipName) {
		Object o = get(relationshipName);
		return o != null && o instanceof RelationshipSorter;
	}
	
	Object get(NamedAndTyped namedAndTyped) {
		return this.map.get(namedAndTyped);
	}
	@Deprecated
	Object get(String relationshipName) {
		return this.map.get(relationshipName);
	}
	
	Object getField(NamedAndTyped relationship) {
		Object o = this.map.get(relationship);
		if (o instanceof BeanProperty) {
			return getMessageBeanPart().getField(WordUtils.uncapitalize(((BeanProperty) o).getName()));
		} else {
			throw new MarshallingException("Relationship " + relationship.getName() + " of " + toString() + " does not resolve to a bean property");
		}
	}

	private MessagePartBean getMessageBeanPart() {
		return (MessagePartBean) this.bean;
	}

	// These methods only exist to support one case: the case of the collapsed relationship
	// with cardinality changes
	
	int propertyCount() {
		return this.properties.size();
	}

	int getSingleCollapsedPropertySize() {
		if (propertyCount() != 1) {
			throw new MarshallingException(toString() + 
					" with cardinality changes cannot handle " + propertyCount() + " collapsed properties");
		} else {
			BeanProperty property = (BeanProperty) new ArrayList<BeanProperty>(this.properties.values()).get(0);
			Object value = property.get();
			if (value == null) {
				return 0;
			} else if (ListElementUtil.isCollection(value)) {
				return ListElementUtil.count(value);
			} else {
				return 1;
			}
		}
	}
	
	public Object getBean() {
		return this.bean;
	}

	public String getPropertyName() {
		return this.propertyName;
	}
	
	@Override
	public String toString() {
		if (this.collapsed) {
			return "Sorter (Components of " + ClassUtils.getShortClassName(this.beanType) + "): " + this.propertyName;
		} else {
			return "Sorter (" + ClassUtils.getShortClassName(this.beanType) + "): " + this.propertyName;
		}
	}
}
