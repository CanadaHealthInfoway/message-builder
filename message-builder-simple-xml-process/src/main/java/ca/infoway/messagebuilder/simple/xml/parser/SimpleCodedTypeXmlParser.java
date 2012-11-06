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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class SimpleCodedTypeXmlParser extends AbstractSimpleXmlParser<CS, Code> implements SimpleXmlParser<CS> {
	
	SimpleCodedTypeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Code value) throws ParserException {
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Code code, SimpleXmlParseContext context) {
		Map<String, String> attributes = new LinkedHashMap<String, String>();

		if (code.getCodeValue()!=null) {
			attributes.put("code", code.getCodeValue());	
		}
		
        return attributes;
	}

	@Override
	protected boolean closeStartElement(CS dataTypeInstance) {
		return true;
	}

}
