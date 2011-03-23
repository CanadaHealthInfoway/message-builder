package ca.infoway.messagebuilder.marshalling;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.marshalling.datatypeadapter.DataTypeValueAdapterProvider;
import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.Relationship;

class BeanWrapper implements Formattable {

	private final Object bean;
	private final Map<String, BeanProperty> map;
	private final String contextName;
	private final Log log = LogFactory.getLog(BeanWrapper.class);
	
	private final DataTypeValueAdapterProvider adapterProvider = new DataTypeValueAdapterProvider();

	public BeanWrapper(Object bean) {
		this.bean = bean;
		this.map = BeanProperty.getProperties(this.bean);
		this.contextName = null;
	}

	private BeanWrapper(BeanWrapper beanWrapper, String contextName) {
		this.bean = beanWrapper.bean;
		this.map = beanWrapper.map;
		this.contextName = concatenate(beanWrapper.contextName, contextName);
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

	public Object read(Relationship relationship) {
		return read(relationship.getName());
	}
	
	public BareANY readDataType(Relationship relationship) {
		return readHl7(relationship.getName());
	}

	@SuppressWarnings("unchecked")
	private BareANY readHl7(String name) {
		BareANY hl7Value = new ANYImpl();
		BeanProperty property = getPropertyForPath(name);
		if (property!=null) {
			hl7Value = new DataTypeFieldHelper(property.getBean(), property.getName()).get(BareANY.class);
		}
		return hl7Value;
	}

	public Object read(String relationshipName) {
		BeanProperty property = getPropertyForPath(relationshipName);
		if (property != null) {
			return property.get();
		} else {
			return null;
		}
	}
	
	public void write(String dataTypeName, String relationshipName, Object o, boolean isFixedValue) {
		BeanProperty property = getPropertyForPath(relationshipName);
		
		if (!isFixedValue) {
			if (property != null) {
				if (o!=null) {
					if (o instanceof BareANY) {
						writeDataType(property, (BareANY) o, dataTypeName);
					} else {
						writeNonDataType(relationshipName, property, o);
					} 
				}
			} else {
				this.log.info("PROPERTY NOT WRITTEN: could not find property with relationship named " + relationshipName + " on " + getWrappedType());
			}
		}
		
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
				((BareANYImpl) field).setBareValue(value.getBareValue());
				field.setDataType(value.getDataType());
			} else {
				((BareANYImpl) field).setBareValue(value.getBareValue());
				field.setDataType(value.getDataType());
			}
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
			throw new MarshallingException("Cannot write to " + property.getName() + " of " + this.bean.getClass());
		}
	}

	public void writeNodeAttribute(Relationship relationship, String attributeValue) {
		BeanProperty property = getPropertyForPath(relationship.getName());
		if (property != null) {
            if (StringUtils.isNotBlank(attributeValue)) {
            	if (property.isWritable()) {
            		if ("BL".equals(relationship.getType())) {
            			property.set(Boolean.valueOf(attributeValue));
            		} else if ("CS".equals(relationship.getType())) {
            			property.set(CodeResolverRegistry.lookup((Class<Code>) DomainTypeHelper.getReturnType(relationship), attributeValue));
            		} else {
            			this.log.info("UNSUPPORTED RimType: IGNORING relationhsipName=" + relationship.getName() + ", property=" + property.getName());
            		}
				} else {
        			this.log.info("PROPERTY NOT WRITABLE: IGNORING relationhsipName=" + relationship.getName() + ", property=" + property.getName());
				}
            }
		} else if (relationship.isFixed()){
			// We don't need to map fixed value codes.
		} else {
			this.log.info("PROPERTY NOT FOUND - IGNORED: no relationship named " + relationship.getName() + " found on " + getWrappedType());
		}
	}

	public void writeNullFlavor(Hl7Source source, Relationship relationship, NullFlavor nullFlavor) {
		Object targetBean = null;
		if (this.contextName!=null) {
			targetBean = getOrCreateCollapsedBean(source, relationship);
		} else {
			targetBean = this.bean; 
		}
		
		if (targetBean instanceof NullFlavorSupport) {
			((NullFlavorSupport) targetBean).setNullFlavor(nullFlavor);
		} else {
			this.log.info(MessageFormat.format(
					"CAN NOT SET NULL FLAVOR! Bean {0} does not implement {1}.", 
					this.bean.getClass().getSimpleName(), NullFlavorSupport.class.getSimpleName()));
		}
	}

	private Object getOrCreateCollapsedBean(Hl7Source source, Relationship relationship) {
		BeanProperty property = this.map.get(this.contextName);
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
						this.bean.getClass().getSimpleName(), 
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
	
	private BeanProperty getPropertyForPath(String relationshipName) {
		BeanProperty result = null;
		for (BeanProperty property : this.map.values()) {
			if (propertyMappingMatchesRelationship(relationshipName, property)) {
				result = property;
				break;
			}
		}
		if (result == null){
			this.log.debug("PROPERTY NOT FOUND: could not find property with relationship named " + relationshipName + " on " + getWrappedType());
		}
		return result;
	}

	private boolean propertyMappingMatchesRelationship(String relationshipName,	BeanProperty property) {
		List<String> mappings = getMapping(property);
		for(String mapping : mappings){
			if (concatenate(this.contextName, relationshipName).equals(mapping)){
				return true;
			}
		}
		return false;
	}

	private List<String> getMapping(BeanProperty property) {
		Hl7XmlMapping annotation = property.getAnnotation(Hl7XmlMapping.class);
		if (annotation != null) {
			return Arrays.asList(annotation.value());
		} else {
			return Collections.<String>emptyList();
		}
	}

	public boolean isAssociationMappedToSameBean(String relationshipName) {
		boolean result = false;
		for (BeanProperty property : this.map.values()) {
			if (isAssociationMappedToProperty(relationshipName, property)) {
				result = true;
				break;
			}
		}
		return result;

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

	public Formattable createSubWrapper(String relationshipName) {
		return new BeanWrapper(this, relationshipName);
	}

	public String getWrappedType() {
		return ClassUtils.getShortClassName(this.bean.getClass());
	}

	public boolean isPreInitializedDelegate(String relationshipName) {
		return getInitializedReadOnlyAssociation(relationshipName) != null;
	}
	
	public Object getInitializedReadOnlyAssociation(String relationshipName) {
		Object object;
		BeanProperty beanProperty = getPropertyForPath(relationshipName);
		if (beanProperty == null){
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

	public List<String> findMatchingRelationshipNames(String pathPrefix) {
		List<String> relationshipNames = new ArrayList<String>();
		
		for (BeanProperty property : this.map.values()) {
			List<String> mappings = getMapping(property);
			for (String mapping : mappings) {
				if (startsWith(mapping, pathPrefix)) {
					relationshipNames.add(StringUtils.removeStart(mapping, this.contextName + "/"));
				}
			}
		}
		return relationshipNames;
	}

	public String getContextName() {
		return this.contextName;
	}

	public NullFlavor getNullFlavor() {
		//AG: make sure we always traverse down collapsed associations.
		NullFlavor nullFlavor = null;
		
		if (this.contextName==null) {
			if (this.bean instanceof NullFlavorSupport) {
				return ((NullFlavorSupport) this.bean).getNullFlavor();	
			}
		}
		
		return nullFlavor;
	}

}
