/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.model.MessagePartBean;

class DataTypeFieldHelper {
	
	private static NullFlavorSupport NULL_VALUABLE = new NullFlavorSupport() {
		public void setNullFlavor(NullFlavor nullFlavor) {
		}
		public boolean hasNullFlavor() {
			return false;
		}
		public NullFlavor getNullFlavor() {
			return null;
		}
	};
	
	private final Log log = LogFactory.getLog(DataTypeFieldHelper.class);
	
	private final ErrorLogger errorLogger;

	private final Object bean;
	private final String fieldName;

	public static class ErrorLogger {
		public void logNotMessagePartBean(Log log, Object bean) {
			log.error(MessageFormat.format("Unable to extract HL7 value. The bean {0} does not extend {1}", 
					bean.getClass().getSimpleName(), 
					MessagePartBean.class.getSimpleName()));
		}

		public void logFieldNotFound(Log log, MessagePartBean messagePartBean, String fieldName) {
			log.error(MessageFormat.format("Unable to extract HL7 value. The bean {0} does not have the field {1}", 
					messagePartBean.getClass().getSimpleName(),
					fieldName));
		}

		public void logInvalidFieldType(Log log, MessagePartBean bean, String fieldName, Class<?> fieldType, boolean isCollection) {
			String message = MessageFormat.format("Unable to extract HL7 value. The field {0}.{1} is not a {2}{3}", 
					bean.getClass().getSimpleName(), 
					fieldName,
					fieldType.getSimpleName(),
					isCollection ? " (this is possibly an expected situation)" : "");
			if (isCollection) {
				log.info(message);
			} else {
				log.warn(message);
			}
		}
	}

	public DataTypeFieldHelper(Object bean, String propertyName) {
		this(bean, propertyName, new ErrorLogger());
	}
	
	/**
	 * 
	 * @param bean
	 * @param propertyName - Note that in C#, the property name usually starts with a capital letter,
	 *   whereas the field name starts with a lower-case letter.
	 * @param errorLogger
	 */
	DataTypeFieldHelper(Object bean, String propertyName, ErrorLogger errorLogger) {
		this.bean = bean;
		this.fieldName = WordUtils.uncapitalize(propertyName);
		this.errorLogger = errorLogger;
	}

	private Object get() {
		MessagePartBean messagePartBean = asMessagePartBean();
		return messagePartBean != null ? getField(messagePartBean) : null;
	}
	
	public void setNullFlavor(NullFlavor nullFlavor) {
		asNullable(this.fieldName).setNullFlavor(nullFlavor);
	}

	public NullFlavor getNullFlavor() {
		return asNullable(this.fieldName).getNullFlavor();
	}
    
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> fieldType) {
		T typedField = null;
		
		Object field = get();
		if (fieldType.isInstance(field)) {
			typedField = (T) field;
		} else if (field!=null) {
			boolean isCollection = Collection.class.isInstance(field);
			this.errorLogger.logInvalidFieldType(this.log, (MessagePartBean) this.bean, this.fieldName, fieldType, isCollection);
		}
		
		return typedField;
	}
	
	private Object getField(MessagePartBean messagePartBean) {
		Object field = messagePartBean.getField(this.fieldName);
		if (field == null) {
			this.errorLogger.logFieldNotFound(this.log, messagePartBean, this.fieldName);
		}
		return field;
	}

	private MessagePartBean asMessagePartBean() {
		MessagePartBean messagePartBean = null; 
		if (this.bean instanceof MessagePartBean) {
			messagePartBean = (MessagePartBean) this.bean;
		} else {
			this.errorLogger.logNotMessagePartBean(this.log, this.bean);
		}
		return messagePartBean;
	}

    private NullFlavorSupport asNullable(String fieldName) {
		NullFlavorSupport nullable = NULL_VALUABLE; 
		MessagePartBean messagePartBean = asMessagePartBean();
		if (messagePartBean!=null) {
			Object field = getField(messagePartBean);
			if (field instanceof NullFlavorSupport) {
				nullable = (NullFlavorSupport) field;
			}
		}
		return nullable;
	}

}
