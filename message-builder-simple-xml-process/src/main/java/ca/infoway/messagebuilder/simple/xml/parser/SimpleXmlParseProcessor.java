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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.simple.xml.MarshallingException;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;
import ca.infoway.messagebuilder.simple.xml.formatter.AbstractSimpleXmlFormatter;
import ca.infoway.messagebuilder.simple.xml.formatter.MessagePartWrapper;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

public class SimpleXmlParseProcessor {
	
	private final ParserFactory factory;
	private Log log = LogFactory.getLog(getClass());

	public SimpleXmlParseProcessor() {
		this(new ParserFactoryImpl());
	}
	public SimpleXmlParseProcessor(ParserFactory factory ) {
		this.factory = factory;
	}

	public String process(InteractionBean messageBean) throws MarshallingException { 
		StringBuilder builder = new StringBuilder();
		process(getInteractionName(messageBean), (MessagePartBean) messageBean, builder, 0);
		return builder.toString();
	}

	String getInteractionName(InteractionBean messageBean) {
		return getInteractionName(messageBean.getClass());
	}

	String getInteractionName(Class<? extends InteractionBean> messageClass) {
		String name = ClassUtils.getShortClassName(messageClass);
		if (name.endsWith("MessageBean")) {
			// likely no longer applicable with our automated bean generation
			name = StringUtils.chomp(name, "MessageBean");
		} else if (name.endsWith("Bean")) {
			name = StringUtils.chomp(name, "Bean");
		}
		return WordUtils.uncapitalize(name);
	}

	void process(String name, MessagePartBean messageBean, StringBuilder builder, int indent) throws MarshallingException {
		process(name, new MessagePartWrapper(messageBean), builder, indent);
	}

	private void process(String name, MessagePartWrapper wrapper,
			StringBuilder builder, int indent) throws MarshallingException {
		
		if (indent == 0) {
			builder.append(XmlRenderingUtils.createStartElement(name, AbstractSimpleXmlFormatter.NAMESPACE, indent, false, true));
		} else {
			builder.append(XmlRenderingUtils.createStartElement(name, indent, false, true));
		}
		
		for (String fieldName : wrapper.getFieldNames()) {
			renderField(fieldName, wrapper.getField(fieldName), builder, indent);
		}
		
		builder.append(XmlRenderingUtils.createEndElement(name, indent, true));
		
	}
	private void renderField(String fieldName, Object field, StringBuilder builder,
			int indent) throws MarshallingException {
		if (field == null) {
			// ignore it... not interesting
		} else if (isCollection(field)) {
			renderEachElement(fieldName, field, builder, indent);
		} else if (isHl7DataType(field)) {
			renderHl7Type(builder, fieldName, (ANY<?>) field);
		} else if (isMessagePart(field)) {
			process(fieldName, new MessagePartWrapper((MessagePartBean) field), builder, indent+1);
		}
	}
	private void renderEachElement(String fieldName, Object field, StringBuilder builder, int indent) throws MarshallingException {
		for (Object element : getElements(field)) {
			renderField(fieldName, element, builder, indent);
		}
	}
	@SuppressWarnings("unchecked")
	private Iterable<Object> getElements(Object field) {
		if (Collection.class.isAssignableFrom(field.getClass())) {
			return ((Collection) field);
		} else if (COLLECTION.class.isAssignableFrom(field.getClass())) {
			return (Collection) ((ANY) field).getValue();
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	private boolean isCollection(Object field) {
		return Collection.class.isAssignableFrom(field.getClass()) ||
				COLLECTION.class.isAssignableFrom(field.getClass());
	}
	@SuppressWarnings("unchecked")
	private void renderHl7Type(StringBuilder builder, String fieldName, ANY<?> any)
			throws ParserException {
		SimpleXmlParser parser = this.factory.create(any.getDataType());
		if (parser != null) {
			builder.append(parser.parse(new SimpleXmlParseContextImpl(fieldName), any));
		} else {
			this.log.warn("No simple xml parser type defined for type: " 
					+ any.getDataType() + " (" + fieldName + ")");
		}
	}

	private boolean isMessagePart(Object field) {
		return field instanceof MessagePartBean;
	}

	private boolean isHl7DataType(Object field) {
		return field instanceof ANY<?>;
	}
}
