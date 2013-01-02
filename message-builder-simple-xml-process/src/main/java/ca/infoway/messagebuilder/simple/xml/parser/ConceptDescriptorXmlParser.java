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

import static java.lang.String.format;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class ConceptDescriptorXmlParser extends AbstractSimpleXmlParser<CD, Code> implements SimpleXmlParser<CD> {
	
	ConceptDescriptorXmlParser() {
	}

	@Override
	protected Map<String, String> toNameValuePairs(CD cd, SimpleXmlParseContext context) {
		Code code = cd.getValue();
		
		Map<String, String> attributes = new LinkedHashMap<String, String>();

		if (code.getCodeValue()!=null) {
			attributes.put("code", code.getCodeValue());	
		}
		
		if (code.getCodeSystem()!=null) {
			attributes.put("codeSystem", code.getCodeSystem());	
		}
		
		if (!StringUtils.isEmpty(cd.getOriginalText())) {
			attributes.put("originalText", cd.getOriginalText());	
		}
		
		if (!StringUtils.isEmpty(cd.getDisplayName())) {
			attributes.put("displayName", cd.getDisplayName());
		}
		
        return attributes;
	}

	@Override
	protected boolean closeStartElement(CD dataTypeInstance) {
		return dataTypeInstance.getTranslations().isEmpty();
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, CD dataTypeValue) throws ParserException {
		renderTranslationsIfPossible(builder, dataTypeValue.getTranslations());
	}
	
	private void renderTranslationsIfPossible(StringBuilder builder, List<CD> translations) {
		if (!translations.isEmpty()) {
			for (CD translation : translations) {
				if (translation.getValue()!=null) {
					Code code = translation.getValue();
					builder.append(format("<translation code=\"%s\" codeSystem=\"%s\">", code.getCodeValue(), code.getCodeSystem()));
					String originalText = translation.getOriginalText();
					if (!StringUtils.isEmpty(originalText)) {
						builder.append(format("<originalText>%s</originalText>", originalText));
					}
					builder.append("</translation>");
				}
			} 
		}
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Code value) throws ParserException {
	}

}
