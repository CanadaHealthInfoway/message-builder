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

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class EncapsulatedDataSignatureXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected EncapsulatedDataSignatureXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public ED<String> format(FormatContext formatContext, Element value) throws FormatterException {
		ED<String> result = null;
		
		String signature = (value == null ? null : value.getTextContent());
		
		if (StringUtils.isBlank(signature)) {
			processError(formatContext, "No signature value provided", value);
		} else {
			result = new EDImpl<String>(signature);
		}
		
		return result;
	}
}
