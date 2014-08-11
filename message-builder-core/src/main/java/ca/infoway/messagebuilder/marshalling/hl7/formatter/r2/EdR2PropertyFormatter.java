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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.util.text.Indenter;


/**
 * ED (R2) - Encapsulated Data
 */
@DataTypeHandler("ED")
public class EdR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<EncapsulatedDataR2> {

	private TelR2PropertyFormatter telFormatter = new TelR2PropertyFormatter();
	
	@Override
	protected
	String formatNonNullValue(FormatContext context, EncapsulatedDataR2 data, int indentLevel) {
		throw new UnsupportedOperationException("ED uses formatNonNullDataType() method instead.");
	}
	
	@Override
	protected
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
		
		EncapsulatedDataR2 encapsulatedData = extractBareValue(dataType);

		Map<String, String> attributes = createAttributes(encapsulatedData, context);

		boolean hasContent = hasContent(encapsulatedData);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, attributes, indentLevel, !hasContent, true));
		if (hasContent) {
			writeReference(encapsulatedData, buffer, indentLevel + 1, context);
			writeThumbnail(encapsulatedData, buffer, indentLevel + 1, context);
			writeContent(encapsulatedData, buffer, indentLevel + 1, context);
			buffer.append(createElementClosure(context, indentLevel, true));
		}
		
		return buffer.toString();
	}

	private boolean hasContent(EncapsulatedDataR2 encapsulatedData) {
		return encapsulatedData.getReference() != null || 
			   encapsulatedData.getThumbnail() != null || 
			   encapsulatedData.getContent() != null;
	}

	private void writeReference(EncapsulatedDataR2 encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context) {
		if (encapsulatedData.getReference() != null) {
			TEL tel = new TELImpl(encapsulatedData.getReference());
			FormatContext newContext = new FormatContextImpl("TEL", "reference", context); 
			String formattedReference = this.telFormatter.format(newContext, tel, indentLevel);
			if (StringUtils.isNotBlank(formattedReference)) {
				buffer.append(formattedReference);
			}
		}
	}

	private void writeThumbnail(EncapsulatedDataR2 encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context) {
		EncapsulatedDataR2 thumbnail = encapsulatedData.getThumbnail();
		if (thumbnail != null) {
			
			if (thumbnail.getThumbnail() != null) {
				recordError("For ED types, the thumbnail property itself cannot also have a thumbnail", context);
			}
			
			ED<EncapsulatedDataR2> thumbnailWrapper = new EDImpl<EncapsulatedDataR2>(thumbnail);
			FormatContext newContext = new FormatContextImpl("ED", "thumbnail", context); 
			String formattedThumbnail = this.format(newContext, thumbnailWrapper, indentLevel);
			if (StringUtils.isNotBlank(formattedThumbnail)) {
				buffer.append(formattedThumbnail);
			}
		}
	}
	
	private void writeContent(EncapsulatedDataR2 encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context) {
		if (StringUtils.isNotBlank(encapsulatedData.getContent())) {
			
			if (EdRepresentation.B64.equals(encapsulatedData.getRepresentation())) {
				validateBase64Encoded("content", encapsulatedData.getContent(), context);
			}
			
			// may need to make sure *not* to add any whitespace to content
			Indenter.indentBuffer(buffer, indentLevel);
			buffer.append(encapsulatedData.getContent());
	        buffer.append(LINE_SEPARATOR);
		}
	}

	private Map<String, String> createAttributes(EncapsulatedDataR2 encapsulatedData, FormatContext context) {
		Map<String, String> attributes = new HashMap<String, String>();
		if (encapsulatedData.getRepresentation() != null) {
			attributes.put("representation", encapsulatedData.getRepresentation().toString());
		}
		
		if (encapsulatedData.getMediaType() != null) {
			attributes.put("mediaType", encapsulatedData.getMediaType().getCodeValue());
		}
		
		if (encapsulatedData.getLanguage() != null) {
			attributes.put("language", encapsulatedData.getLanguage());
		}

		if (encapsulatedData.getCompression() != null) {
			attributes.put("language", encapsulatedData.getCompression().getCompressionType());
		}

		if (encapsulatedData.getIntegrityCheck() != null) {
			validateBase64Encoded("integrityCheck", encapsulatedData.getIntegrityCheck(), context);
			attributes.put("integrityCheck", encapsulatedData.getIntegrityCheck());
		}

		if (encapsulatedData.getIntegrityCheckAlgorithm() != null) {
			attributes.put("integrityCheckAlgorithm", encapsulatedData.getIntegrityCheckAlgorithm().toString().replaceAll("_", "-"));
		}
		return attributes;
	}

	private void recordError(String message, FormatContext context) {
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, context.getPropertyPath()));
	}

	private void validateBase64Encoded(String property, String stringToCheck, FormatContext context) {
		try {
			Base64.decodeBase64String(stringToCheck);
		} catch (Exception e) {
			recordError("The ED property '" + property + "' does not appear to be Base64 encoded.", context);
		}
	}
	
//	private void writeContent(EncapsulatedData data, StringBuffer buffer, byte[] content, boolean base64) {
//		if (content != null) {
//			if (base64) {
//				buffer.append(Base64.encodeBase64String(content));
//			} else if (data instanceof EncapsulatedString) {
//				buffer.append(XmlStringEscape.escape(((EncapsulatedString) data).getContentAsString()));
//			} else {
//				buffer.append(XmlStringEscape.escape(new String(content)));
//			}
//		}
//	}

}
