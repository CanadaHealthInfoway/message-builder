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

import javax.xml.transform.TransformerException;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.EdConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.util.text.Indenter;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;


/**
 * ED (R2) - Encapsulated Data
 */
@DataTypeHandler("ED")
public class EdR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<EncapsulatedDataR2> {
	
	private TelR2PropertyFormatter telFormatter = new TelR2PropertyFormatter();
	private final EdConstraintsHandler constraintsHandler = new EdConstraintsHandler();
	
	@Override
	protected
	String formatNonNullValue(FormatContext context, EncapsulatedDataR2 data, int indentLevel) {
		throw new UnsupportedOperationException("ED uses formatNonNullDataType() method instead.");
	}
	
	@Override
	protected
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
		
		EncapsulatedDataR2 encapsulatedData = extractBareValue(dataType);
		
		handleConstraints(encapsulatedData, context.getConstraints(), context.getPropertyPath(), context.getModelToXmlResult());

		Map<String, String> attributes = createAttributes(encapsulatedData, context);

		boolean hasContent = hasContent(encapsulatedData);
		boolean hasReferenceOrThumbnailOrDocument = hasReferenceOrThumbnailOrDocument(encapsulatedData);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, attributes, indentLevel, !hasContent, hasReferenceOrThumbnailOrDocument));
		if (hasContent) {
			writeReference(encapsulatedData, buffer, indentLevel + 1, context);
			writeThumbnail(encapsulatedData, buffer, indentLevel + 1, context);
			writeContent(encapsulatedData, buffer, indentLevel + 1, context, hasReferenceOrThumbnailOrDocument);
			buffer.append(createElementClosure(context, hasReferenceOrThumbnailOrDocument ? indentLevel : 0, true));
		}
		
		return buffer.toString();
	}

	private void handleConstraints(EncapsulatedDataR2 ed, ConstrainedDatatype constraints, final String propertyPath, final Hl7Errors errors) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};

		this.constraintsHandler.handleConstraints(constraints, ed, logger);
	}

	private boolean hasContent(EncapsulatedDataR2 encapsulatedData) {
		return hasReferenceOrThumbnailOrDocument(encapsulatedData) || 
			   encapsulatedData.getTextContent() != null ||
			   encapsulatedData.getCdataContent() != null ||
			   encapsulatedData.getDocumentContent() != null;
	}

	private boolean hasReferenceOrThumbnailOrDocument(EncapsulatedDataR2 encapsulatedData) {
		return encapsulatedData.getReference() != null || 
			   encapsulatedData.getThumbnail() != null ||
			   encapsulatedData.getDocumentContent() != null;
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
	
	private void writeContent(EncapsulatedDataR2 encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context, boolean hasReferenceOrThumbnailOrDocument) {
		boolean hasDoc = encapsulatedData.getDocumentContent() != null;
		boolean hasCdata = encapsulatedData.getCdataContent() != null;
		boolean hasText = encapsulatedData.getTextContent() != null;
		boolean hasContent = (hasDoc || hasCdata || hasText);
		validateContent(context, hasDoc, hasCdata, hasText);
		
		if (hasReferenceOrThumbnailOrDocument && hasContent) {
			Indenter.indentBuffer(buffer, indentLevel);
		}
		if (hasDoc) {
			try {
				String documentContentAsString = encapsulatedData.getDocumentContentAsString(indentLevel);
				buffer.append(documentContentAsString);
			} catch (TransformerException e) {
				context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR, "ED xml document content could not be rendered: " + e.getMessage(), context.getPropertyPath()));
			}
		} else if (hasCdata) {
			buffer.append("<![CDATA[" + encapsulatedData.getCdataContent() + "]]>");
		} else if (hasText) {
			String textContent = encapsulatedData.getTextContent();
			if (EdRepresentation.B64.equals(encapsulatedData.getRepresentation())) {
				validateBase64Encoded("content", textContent, context);
			}
			buffer.append(XmlStringEscape.escape(textContent));
		}
		if (hasReferenceOrThumbnailOrDocument && hasContent) {
			buffer.append(LINE_SEPARATOR);
		}
	}

	private void validateContent(FormatContext context, boolean hasDoc, boolean hasCdata, boolean hasText) {
		// only one content type should be provided
		int numProvided = (hasDoc ? 1 : 0) + (hasCdata ? 1 : 0) + (hasText ? 1 : 0);
		if (numProvided > 1) {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(Hl7ErrorCode.ONLY_ONE_TYPE_OF_CONTENT_ALLOWED, 
							Hl7ErrorLevel.WARNING, 
							"ED only allows for one type of content (Document, CDATA or text). Precendence given to content in order shown; other content not rendered.", 
							context.getPropertyPath()));
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
