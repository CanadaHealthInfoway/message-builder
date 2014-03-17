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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7Choice;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;

public class MessagePartWrapper {

	private final MessagePartBean bean;
	private Map<String,Field> fields;

	public MessagePartWrapper(MessagePartBean bean) {
		this.bean = bean;
	}

	public Object getField(String fieldName) throws MarshallingException {
		try {
			Field field = getBeanField(fieldName);
			return field.get(getContextBean(field));
		} catch (IllegalArgumentException e) {
			throw new FormatterException(e);
		} catch (IllegalAccessException e) {
			throw new FormatterException(e);
		}
	}

	public void setField(String fieldName, List<Object> value) throws MarshallingException {
		try {
			Field field = getBeanField(fieldName);
			if (isHl7Collection(field)) {
				setHl7CollectionField((COLLECTION<?>) getField(fieldName), value);
			} else if (isStandardCollection(field)) {
				setMessagePartCollection((List<?>) getField(fieldName), value);
			} else if (value.size() == 1) {
				field.set(getContextBean(field), value.get(0));
			} else if (value.isEmpty()) {
				field.set(getContextBean(field), null);
			} else {
				throw new FormatterException("field " + fieldName
						+ " is not a collection, but there are " + value.size()
						+ " elements in the incoming XML");
			}
		} catch (SecurityException e) {
			throw new FormatterException(e);
		} catch (IllegalArgumentException e) {
			throw new FormatterException(e);
		} catch (IllegalAccessException e) {
			throw new FormatterException(e);
		}
	}

	private MessagePartBean getContextBean(Field field) {
		// TM - removed old code checking if there was a messageAttributes property
		//    - should this method do anything now except just return the bean?
		return this.bean;
	}

	@SuppressWarnings("unchecked")
	private void setMessagePartCollection(List field, List value) {
		field.clear();
		field.addAll(value);
	}

	private boolean isStandardCollection(Field field) {
		return List.class.isAssignableFrom(field.getType());
	}

	@SuppressWarnings("unchecked")
	private void setHl7CollectionField(COLLECTION collection, List<Object> value) {
		Collection fieldValue = (Collection) collection.getValue();
		fieldValue.clear();
		fieldValue.addAll(value);
	}

	Field getBeanField(String fieldName) throws MarshallingException {
		return getFields().get(fieldName);
	}

	private boolean isHl7Collection(Field field) {
		return LIST.class.isAssignableFrom(field.getType())
				|| SET.class.isAssignableFrom(field.getType());
	}

	public MessagePartBean unwrap() {
		return this.bean;
	}

	public List<String> getFieldNames() throws MarshallingException {
		return new ArrayList<String>(getFields().keySet());
	}
	
	Map<String,Field> getFields() throws MarshallingException {
		if (this.fields == null) {
			Map<String, Field> result = collectFields((Class<?>) this.bean.getClass());
			this.fields = result;
		}
		return this.fields;
	}

	private Map<String, Field> collectFields(Class<?> c) throws MarshallingException {
		Map<String,Field> result = new LinkedHashMap<String,Field>();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		do {
			classes.add(0, c);
			c = c.getSuperclass();
		} while (c != Object.class);

		for (Class<?> class1 : classes) {
			collectFields(result, class1);
		}
		return result;
	}

	private void collectFields(Map<String,Field> result, Class<?> c) throws MarshallingException {
		Field[] declaredFields = c.getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			if (Modifier.isStatic(field.getModifiers())) {
				// skip it
//			} else if (MessageAttributesBean.class.isAssignableFrom(field.getType())) {
//				result.putAll(collectFields(getValue(field).getClass()));
			} else if (isChoicePlaceholder(field)) {
				addField(result, field);
			} else if (field.getGenericType() instanceof TypeVariable) {
				// need to be able to detect, say, the record types in a query response
				addField(result, field);
			} else if (MessagePartBean.class.isAssignableFrom(field.getType())) {
				addField(result, field);
			} else if (Collection.class.isAssignableFrom(field.getType())) {
				addField(result, field);
			} else if (ANY.class.isAssignableFrom(field.getType())) {
				addField(result, field);
			}
		}
	}

	private boolean isChoicePlaceholder(Field field) {
		return field.getType().isInterface() && field.getType().isAnnotationPresent(Hl7PartTypeMapping.class);
	}

	Object getValue(Field field) throws MarshallingException {
		try {
			return field.get(getContextBean(field));
		} catch (IllegalArgumentException e) {
			throw new MarshallingException(e);
		} catch (IllegalAccessException e) {
			throw new MarshallingException(e);
		}
	}

	private void addField(Map<String, Field> result, Field field) {
		if (field.isAnnotationPresent(Hl7Choice.class)) {
			Hl7Choice choice = field.getAnnotation(Hl7Choice.class);
			for (String name : choice.value()) {
				result.put(name, field);
			}
		} else if (field.isAnnotationPresent(Hl7BusinessName.class)) {
			Hl7BusinessName name = field.getAnnotation(Hl7BusinessName.class);
			result.put(isNotBlank(name.value()) ? name.value() : field.getName(), field);
		} else {
			result.put(field.getName(), field);
		}
	}

	public String getTypeName() {
		return ClassUtils.getShortClassName(this.bean.getClass());
	}
}
