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

import static ca.infoway.messagebuilder.domainvalue.basic.MediaType.PLAIN_TEXT;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedString;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.domainvalue.basic.MediaType;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
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
	public static final String ATTRIBUTE_CHARSET = "charset";
	public static final String ATTRIBUTE_REPRESENTATION = "representation";
	public static final String ATTRIBUTE_MEDIA_TYPE = "mediaType";
	public static final String ELEMENT_REFERENCE = "reference";
	public static final String ATTRIBUTE_VALUE = "value"; // for newer format of "reference" usage

	@Override
	String formatNonNullValue(FormatContext context, EncapsulatedData data, int indentLevel) throws ModelToXmlTransformationException {
		StringBuffer buffer = new StringBuffer();
		Map<String, String> attributes = new HashMap<String, String>();
		addCompressedDataAttributes(data, attributes);
		byte[] content = getContent(data);
		boolean base64 = isBase64(data, content);
		addEncapsulatedDataAttributes(data, attributes, base64);
		buffer.append(createElement(context, attributes, indentLevel, false, false));
		writeReference(data, buffer, indentLevel + 1);
		writeContent(data, buffer, content, base64);
		buffer.append(createElementClosure(context, 0, true));
		return buffer.toString();
	}

	// FIXME - TM - Need to restrict this formatter based on actual data type - references only allowed in ED.REF/ED.DOCREF (similar restrictions on content, but only for ED.DOC)
	private void writeReference(EncapsulatedData data, StringBuffer buffer, int indentLevel) {
		if (data != null && data.getReference() != null) {
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(ATTRIBUTE_VALUE, data.getReference());
			// attributes.put("specializationType", "TEL.URI");  // is this necessary? 
			buffer.append("\n").append(createElement(ELEMENT_REFERENCE, attributes, indentLevel, true, true));
		}
	}

	private void writeContent(EncapsulatedData data, StringBuffer buffer, byte[] content, boolean base64) {
		if (data != null && content != null && base64) {
			buffer.append(Base64.encodeBase64String(content));
		} else if (data != null && content != null && data instanceof EncapsulatedString) {
			buffer.append(XmlStringEscape.escape(((EncapsulatedString) data).getContentAsString()));
		} else if (data != null && content != null) {
			buffer.append(XmlStringEscape.escape(new String(content)));
		}
	}

	private void addEncapsulatedDataAttributes(EncapsulatedData data, Map<String, String> attributes, boolean base64) {
		if (data != null && data.getMediaType() != null) {
			if (data instanceof CompressedData) {
				attributes.put(ATTRIBUTE_MEDIA_TYPE, data.getMediaType().getCodeValue());
			} else if (data.getMediaType() != PLAIN_TEXT) {
				attributes.put(ATTRIBUTE_MEDIA_TYPE, data.getMediaType().getCodeValue());
			}
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

	@SuppressWarnings("unused")
	private void validate(String specializationType, Compression compression, MediaType mediaType, String charset, String language, String representation, String reference, byte[] content, ParseContext context, XmlToModelResult xmlToModelResult) {
		
		// specializationType - must be provided for ED.DOCORREF *except* for CeRx; must be ED.DOC or ED.DOCREF

		// compression - required, must be DF or GZ
		//             - only GZ for CeRx (ED.DOCORREF), and only allowed if content present
		//             - not permitted for ED.REF
		
		// mediatype - mandatory; value from x_DocumentMediaType
		//           - ED.DOC/ED.DOCREF/MR2007, ED.DOCORREF/ED.REF/CeRx: restricted to "text/plain", "text/html", "text/xml", "application/pdf"
		
		// charset - mandatory (MR2009); not permitted for MR2007/CeRx
		
		// language - required, 2-2
		//          - "eng" or "fre" (CeRx)
		
		// representation - TXT or B64; vague on if this is mandatory or not; not permitted for CeRx
		
		// reference - required; must be TEL.URI (mandatory for ED.DOCREF)
		//           - CeRx: only allowed (and mandatory?) if content not present; must be FTP, HTTP, HTTPS  (ED.REF, ED.DOCORREF) 
		
		// content - max 1 MB after compression and base64 encoding; compressed or pdf must be b64-encoded; any checks done on this??
		//         - mandatory for ED.DOC, ED.DOCORREF/CeRx
		//         - not permitted for ED.DOCREF/ED.REF
		
	}

}
