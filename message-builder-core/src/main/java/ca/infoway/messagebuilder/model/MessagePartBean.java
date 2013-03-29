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
		} else {
			throw new IllegalStateException("Could not find property " + propertyName + " in order to set nullFlavor");
		}
	}

	public boolean hasNullFlavorInList(String propertyName, int indexInList) {
		return false;
	}

	public NullFlavor getNullFlavorInList(String propertyName, int indexInList) {
		return null;
	}

	public void setNullFlavorInList(String propertyName, int indexInList, NullFlavor nullFlavor) {
	}

	public boolean hasNullFlavorInSet(String propertyName, Object valueInSet) {
		return false;
	}

	public NullFlavor getNullFlavorInSet(String propertyName, Object valueInSet) {
		return null;
	}

	public void setNullFlavorInSet(String propertyName, Object valueInSet, NullFlavor nullFlavor) {
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
		ANY<?> field = (ANY<?>) getField(propertyName);
		@SuppressWarnings("unchecked")
		Collection<ANY<?>> value = (Collection<ANY<?>>) field.getValue();

		if (indexInList >= value.size()) {
			throw new IndexOutOfBoundsException("Property " + propertyName + " only has " + value.size() + " elements, but trying to access element " + indexInList);
		}
		
		StandardDataType result = null;
		int pos = 0;
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); pos++) {
			ANY<?> item = iterator.next();
			if (pos == indexInList) {
				result = item.getDataType();
				break;
			}
		}
        
        return result;
	}

	public void setSpecializationTypeInList(String propertyName, int indexInList, StandardDataType specializationType) {
		ANY<?> field = (ANY<?>) getField(propertyName);
		@SuppressWarnings("unchecked")
		Collection<ANY<?>> value = (Collection<ANY<?>>) field.getValue();

		if (indexInList >= value.size()) {
			throw new IndexOutOfBoundsException("Property " + propertyName + " only has " + value.size() + " elements, but trying to access index " + indexInList);
		}
		
		int pos = 0;
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); pos++) {
			ANY<?> item = iterator.next();
			if (pos == indexInList) {
				item.setDataType(specializationType);
				break;
			}
		}
        
	}

	public StandardDataType getSpecializationTypeInSet(String propertyName, Object valueInSet) {
		ANY<?> field = (ANY<?>) getField(propertyName);
		@SuppressWarnings("unchecked")
		Collection<ANY<?>> value = (Collection<ANY<?>>) field.getValue();

		StandardDataType result = null;
		
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); ) {
			ANY<?> item = iterator.next();
			Object actualValue = item.getValue();
			if (valueInSet.equals(actualValue)) {
				result = item.getDataType();
				break;
			}
		}
        
        return result;
	}

	public boolean setSpecializationTypeInSet(String propertyName,	Object valueInSet, StandardDataType specializationType) {
		ANY<?> field = (ANY<?>) getField(propertyName);
		@SuppressWarnings("unchecked")
		Collection<ANY<?>> value = (Collection<ANY<?>>) field.getValue();

		boolean result = false;
		
        for (Iterator<ANY<?>> iterator = value.iterator(); iterator.hasNext(); ) {
			ANY<?> item = iterator.next();
			Object actualValue = item.getValue();
			if (valueInSet.equals(actualValue)) {
				item.setDataType(specializationType);
				result = true;
				break;
			}
		}
        
        return result;
	}
	
}
