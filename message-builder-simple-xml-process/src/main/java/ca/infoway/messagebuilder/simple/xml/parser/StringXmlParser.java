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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class StringXmlParser extends AbstractSimpleXmlParser<ST, String> implements SimpleXmlParser<ST> {
	
	StringXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, String value) {
		builder.append(value);
	}

	@Override
	protected boolean closeStartElement(ST dataTypeInstance) {
		return false;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(ST dataTypeValue) {
		Map<String, String> attributes = Collections.emptyMap();
		if (StandardDataType.ST_LANG.equals(dataTypeValue.getDataType())) {
			attributes = new LinkedHashMap<String,String>();
			String language = dataTypeValue.getLanguage();
			// currently not throwing exception when language not provided - plug in a default value instead
			attributes.put("language", StringUtils.isBlank(language) ? "en-CA" : language);
		}
		return attributes;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, String value) {
		throw new UnsupportedOperationException("Different toNameValuePairs handler used for ST");
	}

}

