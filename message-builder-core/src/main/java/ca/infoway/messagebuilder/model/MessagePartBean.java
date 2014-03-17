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

package ca.infoway.messagebuilder.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;

/**
 * @sharpen.ignore model - translated manually.
 */
public class MessagePartBean implements ExtendedNullFlavorSupport, SpecializationTypeSupport, Serializable {

    private static final long serialVersionUID = -850542695451569891L;

    private final Log log = LogFactory.getLog(MessagePartBean.class);

	private NullFlavor nullFlavor;

	private Object getHl7ValueFromMessageAttributes(String propertyName) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		BeanProperty property = BeanProperty.getProperty(this, "messageAttributes");
		MessagePartBean messageAttributesBean = (MessagePartBean) property.get();
		return messageAttributesBean.getField(propertyName);
	}

	private int extractIndex(String indexPart) {
		return Integer.parseInt(indexPart.replaceAll("\\[|\\]", ""));
	}

	private Field getAccessibleField(String basePropertyName) {
		Class<? extends MessagePartBean> type = getClass();
		return getAccessibleField(type, basePropertyName);
	}

	private Field getAccessibleField(Class<?> type, String basePropertyName) {
		Field field = null;
		try {
			field = type.getDeclaredField(basePropertyName);
		} catch (NoSuchFieldException e) {
		}
		
		if (field==null) {
			if (type.getSuperclass()!=null) {
				field = getAccessibleField(type.getSuperclass(), basePropertyName);
			}
		} else {
			field.setAccessible(true);
		}
		
		return field;
	}

    private String pickIndexPart(String propertyName) {
    	String indexPart = "";

    	Pattern p = Pattern.compile("\\[\\d+\\]");
        Matcher m = p.matcher(propertyName);
        boolean result = m.find();
        if (result) {
        	indexPart = m.group();
        }
    	
		return indexPart;
	}

	public Object getField(String propertyName) {
		Object hl7Value = null;
        try {
        	String indexPart = pickIndexPart(propertyName);
        	
        	if (indexPart.length() == 0) { // a strict translation of the 1.6-only "indexPart.isEmpty()"
        		Field field = getAccessibleField(propertyName);
        		
        		if (field==null) {
        			if (isInteraction()) {
            			hl7Value = getHl7ValueFromMessageAttributes(propertyName);
            		} 
//        			else {
//            			log.error(String.format("The field %s.%s was not found", this.getClass().getSimpleName(), propertyName));
//            		}
        		} else {
        			hl7Value = field.get(this);
        		}
        	} else {
        		Field field = getAccessibleField(propertyName.replace(indexPart, ""));
        		if (LIST.class.isAssignableFrom(field.getType())) {
        			LIST<?, ?> list = LIST.class.cast(field.get(this));
        			List<?> hl7ListValue = (List<?>) list.getValue();
        			hl7Value = hl7ListValue.get(extractIndex(indexPart));
        		} else {
        			log.error(String.format("The indexed field {0} of bean {1} is not a LIST.", propertyName, this));	
        		}
        	}
        } catch (SecurityException e) {
            log.error(MessageFormat.format("Unable to get field {0} of bean {1}", propertyName, this), e);
        } catch (NoSuchFieldException e) {
            log.error(MessageFormat.format("Unable to get field {0} of bean {1}", propertyName, this), e);
        } catch (IllegalArgumentException e) {
            log.error(MessageFormat.format("Unable to get field {0} of bean {1}", propertyName, this), e);
        } catch (IllegalAccessException e) {
            log.error(MessageFormat.format("Unable to get field {0} of bean {1}", propertyName, this), e);
        }
        return hl7Value;
    }

	private boolean isInteraction() {
		BeanProperty property = BeanProperty.getProperty(this, "messageAttributes");
		return property != null;
	}

	public NullFlavor getNullFlavor() {
		return nullFlavor;
	}

	public boolean hasNullFlavor() {
		return getNullFlavor() != null;
	}

	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	public NullFlavor getNullFlavor(String propertyName) {
		Object field = getField(propertyName);
		if (field instanceof BareANY) {
			return ((BareANY) field).getNullFlavor();
		} else if (field instanceof MessagePartBean) {
			return ((MessagePartBean) field).getNullFlavor();
		} else {
			throw new IllegalStateException("Could not find property " + propertyName + " in order to get nullFlavor");
		}
	}
	
	public boolean hasNullFlavor(String propertyName) {
		return getNullFlavor(propertyName) != null;
	}

	public void setNullFlavor(String propertyName, NullFlavor nullFlavor) {
		Object field = getField(propertyName);
		if (field instanceof BareANY) {
			((BareANY) field).setNullFlavor(nullFlavor);
		} else if (field instanceof MessagePartBean) {
			((MessagePartBean) field).setNullFlavor(nullFlavor);
		} else {
			throw new IllegalStateException("Could not find property " + propertyName + " in order to set nullFlavor");
		}
	}

	public boolean hasNullFlavorInList(String propertyName, int indexInList) {
		return getNullFlavorInList(propertyName, indexInList) != null;
	}

	public NullFlavor getNullFlavorInList(String propertyName, int indexInList) {
		return (NullFlavor) getMetadataInCollection(propertyName, indexInList, null, false);
	}

	public boolean setNullFlavorInList(String propertyName, int indexInList, NullFlavor nullFlavor) {
		return setMetadataInCollection(propertyName, indexInList, null, nullFlavor, false);
	}

	public boolean hasNullFlavorInSet(String propertyName, Object valueInSet) {
		return getNullFlavorInSet(propertyName, valueInSet) != null;
	}

	public NullFlavor getNullFlavorInSet(String propertyName, Object valueInSet) {
		return (NullFlavor) getMetadataInCollection(propertyName, -1, valueInSet, false);
	}

	public boolean setNullFlavorInSet(String propertyName, Object valueInSet, NullFlavor nullFlavor) {
		return setMetadataInCollection(propertyName, -1, valueInSet, nullFlavor, false);
	}

	public StandardDataType getSpecializationType(String propertyName) {
		Object field = getField(propertyName);
		if (field instanceof BareANY) {
			return ((BareANY) field).getDataType();
		} else {
			throw new IllegalStateException("Could not find property " + propertyName + " in order to get specialization type");
		}
	}
	
	public void setSpecializationType(String propertyName, StandardDataType specializationType) {
		Object field = getField(propertyName);
		if (field instanceof BareANY) {
			((BareANY) field).setDataType(specializationType);
		} else {
			throw new IllegalStateException("Could not find property " + propertyName + " in order to set specialization type");
		}
	}

	public StandardDataType getSpecializationTypeInList(String propertyName, int indexInList) {
		return (StandardDataType) getMetadataInCollection(propertyName, indexInList, null, true);
	}

	public boolean setSpecializationTypeInList(String propertyName, int indexInList, StandardDataType specializationType) {
		return setMetadataInCollection(propertyName, indexInList, null, specializationType, true);
	}

	public StandardDataType getSpecializationTypeInSet(String propertyName, Object valueInSet) {
		return (StandardDataType) getMetadataInCollection(propertyName, -1, valueInSet, true);
	}

	public boolean setSpecializationTypeInSet(String propertyName, Object valueInSet, StandardDataType specializationType) {
		return setMetadataInCollection(propertyName, -1, valueInSet, specializationType, true);
	}

	// TM - could modify get/set to accommodate NFs on collections of associations? 
	//      (users can set NF directly on MessagePart beans, not really necessary to do this here)
	private Object getMetadataInCollection(String propertyName, int indexInList, Object valueInSet, boolean isSpecializationType) {
		
		Collection<ANY<?>> value = obtainFieldInCollection(propertyName, indexInList);
		if (value == null) {
			return null;
		}
		
		Object result = null;

		int pos = 0;
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); pos++) {
			ANY<?> item = iterator.next();
			Object actualValue = item.getValue();
			if ((indexInList == -1 && valueInSet.equals(actualValue)) || pos == indexInList) {
				result = isSpecializationType ? item.getDataType() : item.getNullFlavor();
				break;
			}
		}
        
        return result;
	}
	
	private boolean setMetadataInCollection(String propertyName, int indexInList, Object valueInSet, Object valueToApply, boolean isSpecializationType) {
		// the field specified by propertyName MUST be a LIST/SET/COLLECTION datatype or a Collection, otherwise this method will fail
		
		Collection<ANY<?>> value = obtainFieldInCollection(propertyName, indexInList);
		if (value == null) {
			return false;
		}
		
		boolean result = false;

		int pos = 0;
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); pos++) {
			ANY<?> item = iterator.next();
			Object actualValue = item.getValue();
			if ((indexInList == -1 && valueInSet.equals(actualValue)) || pos == indexInList) {
				if (isSpecializationType) {
					item.setDataType((StandardDataType) valueToApply);
				} else {
					item.setNullFlavor((NullFlavor) valueToApply);
				}
				result = true;
				break;
			}
		}
        
        if (!result) {
			this.log.error(String.format("Could not find the specified entry in the field/collection %s.%s. Value not set.", this.getClass().getSimpleName(), propertyName));
        }
        
        return result;
	}

	@SuppressWarnings("unchecked")
	private Collection<ANY<?>> obtainFieldInCollection(String propertyName,	int indexInList) {
		Collection<ANY<?>> value = null;
		
		Object rawField = getField(propertyName);
		if (rawField == null) {
			this.log.error(String.format("The field %s.%s was not found", this.getClass().getSimpleName(), propertyName));
			return null;
		}
		
		// the rawField will either be an ANY type or a List
		if (rawField instanceof ANY<?>) {
			ANY<?> field = (ANY<?>) rawField;
			if (field.getValue() instanceof Collection<?>) {
				value = (Collection<ANY<?>>) field.getValue();
			} else {
				this.log.error(String.format("The field %s.%s was expected to be of type LIST/SET/COLLECTION. Cannot process.", this.getClass().getSimpleName(), propertyName));
				return null;
			}
		} else if (rawField instanceof Collection<?>) {
			value = (Collection<ANY<?>>) rawField;
		} else {
			this.log.error(String.format("The field %s.%s was expected to be a Collection type (typically List). Cannot process.", this.getClass().getSimpleName(), propertyName));
			return null;
		}

		if (indexInList >= value.size()) {
			this.log.error("Property " + propertyName + " has " + value.size() + " elements, but trying to access element " + indexInList + ". Cannot process.");
			return null;
		}
		
		return value;
	}
	
}
