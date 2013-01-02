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

import static ca.infoway.messagebuilder.datatype.StandardDataType.ST;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ST_LANG;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class StringXmlFormatter extends AbstractSimpleXmlFormatter {

	protected StringXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public ST format(FormatContext formatContext, Element value) throws FormatterException {
		ST result = null;
		
		String language = value.getAttribute("language");
		String string = value.getTextContent();
		
		if (StringUtils.isBlank(string)) {
			processError(formatContext, "No string value provided", value);
		} else if (formatContext.matchesType(ST_LANG) && StringUtils.isBlank(language)) {
			processError(formatContext, "Language attribute is mandatory", value);
		} else if (formatContext.matchesType(ST_LANG) && !STImpl.ALLOWED_LANGUAGES.contains(language)) {
			processError(formatContext, "Language attribute is not a supported value", value);
		} else if (formatContext.matchesType(ST) && StringUtils.isNotBlank(language)) {
			processError(formatContext, "Language attribute not allowed for ST type", value);
		} else {
			result = new STImpl(string, language);
		}
		
		return result;
	}
}
