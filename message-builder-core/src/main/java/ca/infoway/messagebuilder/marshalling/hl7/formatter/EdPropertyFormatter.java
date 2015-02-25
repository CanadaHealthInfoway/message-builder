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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.EdConstraintsHandler;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

/**
 * ED - Encapsulated Data
 * ED.DOCORREF - Encapsulated Data (Document or Reference)
 * (etc.)
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

	private AbstractNullFlavorPropertyFormatter<TelecommunicationAddress> telFormatter;
	private final EdConstraintsHandler constraintsHandler = new EdConstraintsHandler();
	private EdContentRenderer edContentRenderer = new EdContentRenderer();
	private EdValidationUtils edValidationUtils = new EdValidationUtils();
	
	private final boolean isR2;
	
	public EdPropertyFormatter() {
		this(new TelUriPropertyFormatter(), false); // R1
	}

	public EdPropertyFormatter(AbstractNullFlavorPropertyFormatter<TelecommunicationAddress> telFormatter, boolean isR2) {
		this.isR2 = isR2;
		this.telFormatter = telFormatter;
	}

	@Override
	protected
	String formatNonNullValue(FormatContext context, EncapsulatedData data, int indentLevel) {
		throw new UnsupportedOperationException("ED uses formatNonNullDataType() method instead.");
	}
	
	@Override
	protected
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
		
		EncapsulatedData encapsulatedData = extractBareValue(dataType);
		
		handleConstraints(encapsulatedData, context.getConstraints(), context.getPropertyPath(), context.getModelToXmlResult());

		Map<String, String> attributes = createAttributes(encapsulatedData, context);

		boolean hasContent = hasContent(encapsulatedData);
		boolean hasReferenceOrThumbnailOrDocument = hasReferenceOrThumbnailOrDocument(encapsulatedData);
		
		if (!this.isR2) {
			addSpecializationType(encapsulatedData, attributes, context.getType(), dataType.getDataType(), context.getVersion());
			validate(context, dataType, encapsulatedData);
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, attributes, indentLevel, !hasContent, hasReferenceOrThumbnailOrDocument));
		if (hasContent) {
			writeReference(encapsulatedData, buffer, indentLevel + 1, context);
			writeThumbnail(encapsulatedData, buffer, indentLevel + 1, context);
			this.edContentRenderer.renderContent(encapsulatedData, buffer, indentLevel + 1, context, hasReferenceOrThumbnailOrDocument);
			buffer.append(createElementClosure(context, hasReferenceOrThumbnailOrDocument ? indentLevel : 0, true));
		}
		
		return buffer.toString();
	}

	private void handleConstraints(EncapsulatedData ed, ConstrainedDatatype constraints, final String propertyPath, final Hl7Errors errors) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};

		this.constraintsHandler.handleConstraints(constraints, ed, logger);
	}

	private boolean hasContent(EncapsulatedData encapsulatedData) {
		return hasReferenceOrThumbnailOrDocument(encapsulatedData) || 
			   encapsulatedData.hasContent()
			   ;
	}

	private boolean hasReferenceOrThumbnailOrDocument(EncapsulatedData encapsulatedData) {
		return encapsulatedData.getReferenceObj() != null || 
			   encapsulatedData.getThumbnail() != null ||
			   encapsulatedData.hasContent()
			   ;
	}

	private void writeReference(EncapsulatedData encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context) {
		if (encapsulatedData.getReferenceObj() != null) {
			TEL tel = new TELImpl(encapsulatedData.getReferenceObj());
			FormatContext newContext = new FormatContextImpl(isR2 ? "TEL" : "TEL.URI", "reference", context); 
			String formattedReference = this.telFormatter.format(newContext, tel, indentLevel);
			if (StringUtils.isNotBlank(formattedReference)) {
				buffer.append(formattedReference);
			}
		}
	}

	private void writeThumbnail(EncapsulatedData encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context) {
		EncapsulatedData thumbnail = encapsulatedData.getThumbnail();
		if (thumbnail != null) {
			
			if (thumbnail.getThumbnail() != null) {
				recordError("For ED types, the thumbnail property itself cannot also have a thumbnail", context);
			}
			
			ED<EncapsulatedData> thumbnailWrapper = new EDImpl<EncapsulatedData>(thumbnail);
			FormatContext newContext = new FormatContextImpl("ED", "thumbnail", context); 
			String formattedThumbnail = this.format(newContext, thumbnailWrapper, indentLevel);
			if (StringUtils.isNotBlank(formattedThumbnail)) {
				buffer.append(formattedThumbnail);
			}
		}
	}
	
	private Map<String, String> createAttributes(EncapsulatedData encapsulatedData, FormatContext context) {
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
			attributes.put("compression", encapsulatedData.getCompression().getCompressionType());
		}

		if (encapsulatedData.getIntegrityCheck() != null) {
			this.edContentRenderer.validateBase64Encoded("integrityCheck", encapsulatedData.getIntegrityCheck(), context);
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

	private void validate(FormatContext context, BareANY dataType, EncapsulatedData encapsulatedData) {
		String type = context.getType();
		String specializationType = dataType.getDataType() == null ? null : dataType.getDataType().getType();
		Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
		Hl7Errors errors = context.getModelToXmlResult();
		
		this.edValidationUtils.doValidate(encapsulatedData, specializationType, baseVersion, type, context.getPropertyPath(), errors);
	}

	private void addSpecializationType(EncapsulatedData ed, Map<String, String> attributes, String type, StandardDataType specializationType, VersionNumber version) {
		if (StandardDataType.ED_DOC_OR_REF.getType().equals(type) && !Hl7BaseVersion.CERX.equals(version.getBaseVersion())) {
			if (specializationType == StandardDataType.ED_DOC || specializationType == StandardDataType.ED_DOC_REF) {
				addSpecializationType(attributes, specializationType.getType());
			} else {
				// best guess: check content to decide on DOC or DOC_REF (CDA/R1 will get ST, though clients may not want it)
				addSpecializationType(attributes, ed.hasContent() ? StandardDataType.ED_DOC.getType() : StandardDataType.ED_DOC_REF.getType());
			}
		}
	}

}
