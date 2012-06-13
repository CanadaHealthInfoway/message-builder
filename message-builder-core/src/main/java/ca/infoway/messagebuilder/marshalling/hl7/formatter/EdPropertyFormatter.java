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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.lang.MediaType.PLAIN_TEXT;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedString;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.platform.Base64;

/**
 * ED.DOCORREF - Encapsulated Data (Document or Reference)
 * 
 * Represents a String as an element:
 * 
 * &lt;element-name mediaType="text/plain"&gt;This is some
 * text.&lt;/element-name&gt;
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 * 
 */
@DataTypeHandler("ED")
public class EdPropertyFormatter extends AbstractNullFlavorPropertyFormatter<EncapsulatedData> {

	public static final String REPRESENTATION_B64 = "B64";
	public static final String ATTRIBUTE_COMPRESSION = "compression";
	public static final String ATTRIBUTE_LANGUAGE = "language";
	public static final String ATTRIBUTE_REPRESENTATION = "representation";
	public static final String ATTRIBUTE_MEDIA_TYPE = "mediaType";
	public static final String ATTRIBUTE_REFERENCE = "reference";
	public static final String ATTRIBUTE_VALUE = "value"; // for newer format of "reference" usage

	@Override
	String formatNonNullValue(FormatContext context, EncapsulatedData data, int indentLevel) throws ModelToXmlTransformationException {
		validateContext(context);
		StringBuffer buffer = new StringBuffer();
		Map<String, String> attributes = new HashMap<String, String>();
		addCompressedDataAttributes(data, attributes);
		byte[] content = getContent(data);
		boolean base64 = isBase64(data, content);
		addEncapsulatedDataAttributes(data, attributes, base64);
		buffer.append(createElement(context, attributes, indentLevel, false, false));
		if (data != null && content != null && base64) {
			buffer.append(Base64.encodeBase64String(content));
		} else if (data != null && content != null && data instanceof EncapsulatedString) {
			buffer.append(XmlStringEscape.escape(((EncapsulatedString) data).getContentAsString()));
		} else if (data != null && content != null) {
			buffer.append(XmlStringEscape.escape(new String(content)));
		}
		buffer.append(createElementClosure(context, 0, true));
		return buffer.toString();
	}

	private void addEncapsulatedDataAttributes(EncapsulatedData data, Map<String, String> attributes, boolean base64) {
		if (data != null && data.getMediaType() != null) {
			if (data instanceof CompressedData) {
				attributes.put(ATTRIBUTE_MEDIA_TYPE, data.getMediaType().getCodeValue());
			} else if (data.getMediaType() != PLAIN_TEXT) {
				attributes.put(ATTRIBUTE_MEDIA_TYPE, data.getMediaType().getCodeValue());
			}
		}

		if (data != null && data.getReference() != null) {
			attributes.put(ATTRIBUTE_REFERENCE, data.getReference());
		}

		if (base64 == true) {
			attributes.put(ATTRIBUTE_REPRESENTATION, REPRESENTATION_B64);
		}
	}

	private void addCompressedDataAttributes(EncapsulatedData data, Map<String, String> attributes) {
		if (data != null) {
			if (data instanceof CompressedData) {
				CompressedData compressedData = (CompressedData) data;
				if (compressedData.getLanguage() != null) {
					attributes.put(ATTRIBUTE_LANGUAGE, compressedData.getLanguage());
				}
				if (compressedData.getCompression() != null) {
					attributes.put(ATTRIBUTE_COMPRESSION, compressedData.getCompression().getCompressionType());
				}
			}
		}
	}

	private boolean isBase64(EncapsulatedData data, byte[] content) {
		if (data != null) {
			if (data instanceof CompressedData) {
				return true;
			} else if (content != null && data.getMediaType() != PLAIN_TEXT) {
				return true;
			}
		}
		return false;
	}

	private byte[] getContent(EncapsulatedData data) {
		byte[] content = null;
		if (data != null) {
			if (data instanceof CompressedData) {
				CompressedData compressedData = (CompressedData) data;
				content = compressedData.getCompressedContent();
			} else {
				content = data.getContent();
			}
		}
		return content;
	}

}
