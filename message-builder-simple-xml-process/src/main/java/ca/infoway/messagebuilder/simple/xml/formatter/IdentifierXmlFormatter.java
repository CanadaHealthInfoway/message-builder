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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.apache.commons.lang.StringUtils.trimToNull;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class IdentifierXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected IdentifierXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public II format(FormatContext formatContext, Element value) throws FormatterException {
		String root = value.getAttribute("root");
		String extension = value.getAttribute("extension");
	
		// numerous validations done in IiElementParser are _not_ duplicated here - formatter will hopefully catch for now,
		// and we can refactor out common validation at a later date
		
		if (StringUtils.isBlank(root)) {
			processError(formatContext, "Mandatory attribute \"root\" not provided", value);
			return null;
		} else {
			return new IIImpl(new Identifier(root, trimToNull(extension)));
		}
	}
}
