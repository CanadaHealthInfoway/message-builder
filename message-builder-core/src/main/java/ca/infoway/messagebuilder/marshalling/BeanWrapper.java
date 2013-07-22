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

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.marshalling.datatypeadapter.DataTypeValueAdapterProvider;
import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.Relationship;

class BeanWrapper {

	@Deprecated
	private final Map<String, BeanProperty> map;
	@Deprecated
	private final String contextName;
	private final Log log = LogFactory.getLog(BeanWrapper.class);
	
	private final DataTypeValueAdapterProvider adapterProvider = new DataTypeValueAdapterProvider();
	private RelationshipSorter sorter;
	private final BeanWrapper parentWrapper;

	BeanWrapper(Object bean) {
		this.map = BeanProperty.getProperties(bean);
		this.sorter = RelationshipSorter.create("", bean);
		this.contextName = null;
		this.parentWrapper = null;
	}

	private BeanWrapper(BeanWrapper parentWrapper, String contextName, RelationshipSorter sorter) {
		this.parentWrapper = parentWrapper;
		this.map = parentWrapper.map;
		this.sorter = sorter;
		this.contextName = concatenate(parentWrapper.contextName, contextName);
	}

	private String concatenate(String part1, String part2) {
		if (isBlank(part1)) {
			return part2;
		} else if (isBlank(part2)) {
			return part1;
		} else {
			return part1 + "/" + part2;
		}
	}

	void write(Relationship relationship, Object o) {
		if (!relationship.isFixed()) {
			BeanProperty property = findBeanProperty(relationship);
			if (property != null) {
				if (o!=null) {
					if (o instanceof BareANY) {
						writeDataType(property, (BareANY) o, relationship.getType());
					} else {
						writeNonDataType(relationship.getName(), property, o);
					} 
				}
			} else {
				this.log.info("PROPERTY NOT WRITTEN: could not find property with relationship named " + relationship + " on " + getWrappedType());
			}
		}
	}

	private BeanProperty findBeanProperty(NamedAndTyped relationshipName) {
		return (BeanProperty) this.sorter.get(relationshipName);
	}

	private void writeDataType(BeanProperty property, BareANY value, String dataTypeName) {
		BareANY field = new DataTypeFieldHelper(property.getBean(), property.getName()).get(BareANY.class);
		
		if (field==null) {
			//this is required for the case sure when we collapse an association with cardinality > 1
			//into a List of data types. See DevicePrescriptionSummaryQueryCriteriaBean#getRxDispenseIndicator
			if (property.isCollection()) {
				ListElementUtil.addElement(property.get(), value.getBareValue());
			}
		} else {
			value = this.adapterProvider.getAdapter(dataTypeName, field.getClass()).adapt(value);
			if (value.hasNullFlavor()) {
				new DataTypeFieldHelper(property.getBean(), property.getName()).setNullFlavor(value.getNullFlavor());
			}
			if (value instanceof CD) {
				((CD)field).setOriginalText(((CD)value).getOriginalText());
			}
			((BareANYImpl) field).setBareValue(value.getBareValue());
			field.setDataType(value.getDataType());
		}
	}

	private void writeNonDataType(String relationshipName, BeanProperty property, Object object) {
		if (property.isCollection()) {
			if (ListElementUtil.isCollection(object)) {
				ListElementUtil.addAllElements(property.get(), object);
			} else {
				this.log.info("Warning mapping HL7 single property to Teal collection. Property=" + relationshipName );
				ListElementUtil.addElement(property.get(), object);
			}
		} else if (property.isWritable()) {
			if (object!=null) {
				property.set(object);
			} 
		} else {
			throw new MarshallingException("Cannot write to " + property.getName() + " of " + this.sorter.getBean().getClass());
		}
	}

	public void writeNodeAttribute(Relationship relationship, String attributeValue, VersionNumber version) {
		BeanProperty property = findBeanProperty(relationship);
		if (property != null) {
            if (StringUtils.isNotBlank(attributeValue)) {
            	if (property.isWritable()) {
            		if ("BL".equals(relationship.getType())) {
            			property.set(Boolean.valueOf(attributeValue));
            		} else if ("CS".equals(relationship.getType())) {
            			property.set(resolveCodeValue(relationship, attributeValue, version));
            		} else {
            			this.log.info("UNSUPPORTED RimType: IGNORING relationshipName=" + relationship.getName() + ", property=" + property.getName());
            		}
				} else {
        			this.log.info("PROPERTY NOT WRITABLE: IGNORING relationshipName=" + relationship.getName() + ", property=" + property.getName());
				}
            }
		} else if (relationship.isFixed()){
			// We don't need to map fixed value codes.
		} else {
			this.log.info("PROPERTY NOT FOUND - IGNORED: no relationship named " + relationship.getName() + " found on " + getWrappedType());
		}
	}

	@SuppressWarnings("unchecked")
	private Code resolveCodeValue(Relationship relationship, String attributeValue, VersionNumber version) {
		return CodeResolverRegistry.lookup((Class<Code>) DomainTypeHelper.getReturnType(relationship, version), attributeValue);
	}

	public void writeNullFlavor(Hl7Source source, Relationship relationship, NullFlavor nullFlavor) {
		Object targetBean = null;
		if (this.parentWrapper != null) {
			targetBean = getOrCreateCollapsedBean(source, relationship);
		} else {
			targetBean = this.sorter.getBean(); 
		}
		
		if (targetBean instanceof NullFlavorSupport) {
			((NullFlavorSupport) targetBean).setNullFlavor(nullFlavor);
		} else {
			this.log.info(MessageFormat.format(
					"CAN NOT SET NULL FLAVOR! Bean {0} does not implement {1}.", 
					this.sorter.getBeanType().getSimpleName(), NullFlavorSupport.class.getSimpleName()));
		}
	}

	private Object getOrCreateCollapsedBean(Hl7Source source, Relationship relationship) {
		BeanProperty property = findBeanProperty(relationship);
		// TM - fix for bug 13100 - will property always be null?
		if (property == null) {
			property = getPropertyForAssociation();
		}
		
		Object collapsedBean = property.get();
		if (collapsedBean==null) {
			Relationship collapsedRelationship = getCollapsedRelationship(
					source, 
					property.getAnnotation(Hl7XmlMapping.class));
			
			if (collapsedRelationship!=null) {
				Hl7PartSource collapsedPartSource = source.createPartSource(collapsedRelationship, source.getCurrentElement());
				collapsedBean = Instantiator.getInstance().instantiateMessagePartBean(
						collapsedPartSource.getVersion(), collapsedPartSource.getType(),
						collapsedPartSource.getInteraction());
				property.set(collapsedBean);
			} else {
				this.log.info(MessageFormat.format(
						"UNABLE TO SET NULL FLAVOR - Can not find bean for collapsed property {0}.{1}", 
						this.sorter.getBeanType().getSimpleName(), 
						this.contextName));
			} 
		}
		return collapsedBean;
	}

	private Relationship getCollapsedRelationship(Hl7Source source, Hl7XmlMapping mapping) {
		Relationship relationship = null;
		if (mapping != null) {
			for (String path : mapping.value()) {
				relationship = source.getRelationship(path.replaceAll(this.contextName+".", ""));
				if (relationship!=null) {
					break;
				}
			}
		}
		return relationship;
	}
	
	private List<String> getMapping(BeanProperty property) {
		Hl7XmlMapping annotation = property.getAnnotation(Hl7XmlMapping.class);
		if (annotation != null) {
			return Arrays.asList(annotation.value());
		} else {
			return Collections.<String>emptyList();
		}
	}

	public boolean isAssociationMappedToSameBean(NamedAndTyped relationshipName) {
		Object object = this.sorter.get(relationshipName);
		return object != null && object instanceof RelationshipSorter;
	}

	private BeanProperty getPropertyForAssociation() {
		BeanProperty result = null;
		for (BeanProperty property : this.map.values()) {
			if (isAssociationMappedToProperty(null, property)) {
				result = property;
				break;
			}
		}
		return result;

	}

	private boolean isAssociationMappedToProperty(String relationshipName,	BeanProperty property) {
		List<String> mappings = getMapping(property);
		for(String mapping : mappings){
			if (startsWith(mapping, relationshipName)){
				return true;
			}
		}
		return false;
	}

	private boolean startsWith(String mapping, String name) {
		return mapping.startsWith(concatenate(this.contextName, name) +"/");
	}

	public BeanWrapper createSubWrapper(NamedAndTyped relationshipName) {
		return new BeanWrapper(this, relationshipName.getName(), (RelationshipSorter) this.sorter.get(relationshipName));
	}

	public String getWrappedType() {
		return ClassUtils.getShortClassName(this.sorter.getBeanType());
	}

	public boolean isPreInitializedDelegate(NamedAndTyped relationshipName) {
		return getInitializedReadOnlyAssociation(relationshipName) != null;
	}
	
	public Object getInitializedReadOnlyAssociation(NamedAndTyped relationshipName) {
		Object object;
		BeanProperty beanProperty = findBeanProperty(relationshipName);
		if (beanProperty == null) {
			object = null;
		} else if (!beanProperty.isReadable()) {
			object = null;
		} else {
			if (ListElementUtil.isCollection((Class<?>) beanProperty.getPropertyType())){
				//Initialized collections don't count
				object = null;
			} else {
				object = beanProperty.get();
			}
		}
		return object;
	}

	public NullFlavor getNullFlavor() {
		//AG: make sure we always traverse down collapsed associations.
		NullFlavor nullFlavor = null;
		
		if (this.parentWrapper == null) {
			if (this.sorter.getBean() instanceof NullFlavorSupport) {
				return ((NullFlavorSupport) this.sorter.getBean()).getNullFlavor();	
			}
		}
		
		return nullFlavor;
	}

}
