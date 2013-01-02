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

import static ca.infoway.messagebuilder.util.iterator.NodeListIterator.collatedElements;
import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;
import static ca.infoway.messagebuilder.util.xml.XmlDescriber.describePath;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;

public class SimpleXmlFormatProcessor {

	private final FormatterFactory factory;
	private final MessagePartResolver resolver;
	private Log log = LogFactory.getLog(getClass());
	private final VersionNumber versionNumber;

	public SimpleXmlFormatProcessor(VersionNumber versionNumber) {
		this(new FormatterFactoryImpl(), new MessagePartResolverImpl(), versionNumber);
	}

	SimpleXmlFormatProcessor(FormatterFactory factory, MessagePartResolver resolver, VersionNumber versionNumber) {
		this.factory = factory;
		this.resolver = resolver;
		this.versionNumber = versionNumber;
	}

	public MessagePartBean process(Schema schema, Document document)
			throws MarshallingException {

		DOMSource source = new DOMSource(document);
		DOMResult result = new DOMResult();

		try {
			schema.newValidator().validate(source, result);
			Document augmented = (Document) result.getNode();
			return processMessagePart(augmented.getDocumentElement(), null);
		} catch (SAXException e) {
			throw new FormatterException(e);
		} catch (IOException e) {
			throw new FormatterException(e);
		}
	}

	private Object process(Element element, MessagePartWrapper part, Field field)
			throws MarshallingException {
		String typeName = element.getSchemaTypeInfo().getTypeName();
		if (this.factory.isSimpleDataType(typeName)) {
			SimpleXmlFormatter formatter = this.factory.createFormatter(typeName);
			return formatter.format(new FormatterContextImpl(StandardDataType
					.convertSimpleXmlToDataType(typeName), getTypeIfApplicable(field)),
					element);
		} else {
			Object fieldValue = part.getValue(field);
			return processMessagePart(element, fieldValue);
		}
	}

	Class<?> getTypeIfApplicable(Field field) {
		Class<?> result = null;
		if (isCodedType(field)) {
			Method method = getGetter(field);
			if (method!=null) {
				result = method.getReturnType();
			}
		} else if (isList(field)) {
			Type listType = Generics.getParameterType(field.getGenericType());
			if (isCodedType(listType)) {
				result = (Class<?>) Generics.getParameterType(listType);
			}
		}
		return result;
	}

	private Method getGetter(Field field) {
		Method getter = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(field.getDeclaringClass());
			for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
				System.err.println(descriptor.getName());
				if (descriptor.getName().equals(field.getName())) {
					getter = descriptor.getReadMethod();
					break;
				}
			}
		} catch (IntrospectionException e) {
		}
		return getter;
	}

	private boolean isList(Field field) {
		return false;
	}

	private boolean isCodedType(Field field) {
		return isCodedType(field.getType());
	}

	@SuppressWarnings("unchecked")
	private boolean isCodedType(Type type) {
		if (type instanceof ParameterizedType) {
			return isCodedType(((ParameterizedType) type).getRawType());
		} else if (type instanceof Class) {
			return isCodedType((Class) type);
		} else {
			return false;
		}
	}

	private boolean isCodedType(Class<?> type) {
		return CS.class.isAssignableFrom(type) || CV.class.isAssignableFrom(type)
				|| CD.class.isAssignableFrom(type) || CE.class.isAssignableFrom(type);
	}

	private MessagePartBean processMessagePart(Element element, Object fieldValue)
			throws MarshallingException {
		String typeName = element.getSchemaTypeInfo().getTypeName();
		MessagePartWrapper part = this.resolver.resolve(this.versionNumber, typeName, fieldValue);
		this.log.debug("Now applying child nodes of " + describePath(element)
				+ " against type " + typeName + "(" + part.getTypeName() + ")");
		for (List<Element> children : collatedElements(element.getChildNodes())) {
			String fieldName = getLocalOrTagName(children.get(0));
			Field field = part.getBeanField(fieldName);
			if (field == null) {
				this.log.error("Field " + fieldName + " on part " + typeName
						+ " does not exist.");
				// throw new MarshallingException("Field " + fieldName +
				// " on part " + typeName + " does not exist.");
			} else {
				List<Object> value = process(children, part, field);
				part.setField(fieldName, value);
			}
		}
		return part.unwrap();
	}

	private List<Object> process(List<Element> children, MessagePartWrapper part,
			Field field) throws MarshallingException {
		List<Object> result = new ArrayList<Object>();
		for (Element child : children) {
			result.add(process(child, part, field));
		}
		return result;
	}
}
