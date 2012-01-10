/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.simple.xml.ErrorMessage;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public abstract class AbstractSimpleXmlFormatter implements SimpleXmlFormatter {

	protected final FormatterConfiguration configuration;
	
	public static final String NAMESPACE = "urn:ca.infoway.messagebuilder.simplexml.v1";

	protected AbstractSimpleXmlFormatter(FormatterConfiguration configuration) {
		this.configuration = configuration;
	}
	
	void processError(FormatContext formatContext, String string, Element value) throws FormatterException {
		if (this.configuration.isPermissive()) {
			addErrorMessage(formatContext, string, value);
		} else {
			throw new FormatterException(string);
		}
	}

	private void addErrorMessage(FormatContext formatContext, String string, Element value) {
		formatContext.getErrors().add(new ErrorMessage(string, value));
	}

	protected Element getSingleElement(Element value, String tagName) throws FormatterException {
		NodeList list = value.getElementsByTagNameNS(NAMESPACE, tagName);
		if (list.getLength() > 1) {
			throw new FormatterException("Too many instances of child element " + tagName + " in " + XmlDescriber.describePath(value));
		} else if (list.getLength() == 1) {
			return (Element) list.item(0);
		} else {
			return null;
		}
	}
}
