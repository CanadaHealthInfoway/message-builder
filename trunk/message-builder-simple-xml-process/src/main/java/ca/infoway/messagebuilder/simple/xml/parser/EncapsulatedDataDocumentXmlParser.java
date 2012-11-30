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

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class EncapsulatedDataDocumentXmlParser extends AbstractSimpleXmlParser<ED<EncapsulatedData>, EncapsulatedData> implements SimpleXmlParser<ED<EncapsulatedData>> {
	
	EncapsulatedDataDocumentXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, EncapsulatedData value) {
		if (StandardDataType.ED_DOC.equals(dataType)) {
			builder.append("<document>");
			byte[] content = value.getContent();
			if (content != null) {
				builder.append(new String(Base64.encodeBase64(content)));
			}
			builder.append("</document>");
		}
	}

	@Override
	protected boolean closeStartElement(ED<EncapsulatedData> dataTypeInstance) {
		return false;
	}
	
	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, EncapsulatedData value, SimpleXmlParseContext context) {
		Map<String,String> attributes = new LinkedHashMap<String, String>();
		if (value.getMediaType() != null) {
			attributes.put("mediaType", value.getMediaType().getCodeValue());
		}
		if (StringUtils.isNotBlank(value.getReference())) {
			attributes.put("uri", value.getReference());
		}
		if (value instanceof CompressedData) {
			CompressedData compressedData = (CompressedData) value;
			String compressionType = compressedData.getCompression() == null ? null : compressedData.getCompression().getCompressionType();
			if (StringUtils.isNotBlank(compressionType)) {
				attributes.put("compression", compressionType);
			}
			String language = compressedData.getLanguage();
			if (StringUtils.isNotBlank(language)) {
				if ("en-CA".equals(language)) {
					attributes.put("language", "en");
				} else if ("fr-CA".equals(language)) {
					attributes.put("language", "fr");
				}
			}
		}
		return attributes;
	}

}

