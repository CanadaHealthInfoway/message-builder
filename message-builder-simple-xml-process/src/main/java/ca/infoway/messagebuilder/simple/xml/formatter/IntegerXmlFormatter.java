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

import org.apache.commons.lang.math.NumberUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class IntegerXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected IntegerXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public INT format(FormatContext formatContext, Element value) throws FormatterException {
		INT result = null;
		
		String intString = value.getTextContent();
		try {
			
			// numerous validations done in IntElementParser are _not_ duplicated here - formatter will hopefully catch for now,
			// and we can refactor out common validation at a later date
			
			Integer integer = NumberUtils.createInteger(intString);
			result = new INTImpl(integer);
		} catch(NumberFormatException e) {
			processError(formatContext, "Value not an integer", value);
		}
		return result;
	}
}
