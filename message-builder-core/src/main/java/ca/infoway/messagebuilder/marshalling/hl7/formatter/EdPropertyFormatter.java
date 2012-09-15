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

import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_CHARSET;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_COMPRESSION;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_LANGUAGE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_MEDIA_TYPE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_REPRESENTATION;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_VALUE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ELEMENT_REFERENCE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.REPRESENTATION_B64;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedString;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
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

	private EdValidationUtils edValidationUtils = new EdValidationUtils();
	
	@Override
	String formatNonNullValue(FormatContext context, EncapsulatedData data, int indentLevel) throws ModelToXmlTransformationException {
		throw new UnsupportedOperationException("ED uses formatNonNullDataType() method instead.");
	}
	
	@Override
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) throws ModelToXmlTransformationException {
		
		EncapsulatedData encapsulatedData = extractBareValue(dataType);
		
		validate(context, dataType, encapsulatedData);
		
		StringBuffer buffer = new StringBuffer();
		Map<String, String> attributes = new HashMap<String, String>();
		addCompressedDataAttributes(encapsulatedData, attributes);
		byte[] content = getContent(encapsulatedData);
		boolean base64 = this.edValidationUtils.isBase64(encapsulatedData, content);
		addEncapsulatedDataAttributes(encapsulatedData, attributes, base64, context.getType(), dataType.getDataType(), context.getVersion());
		buffer.append(createElement(context, attributes, indentLevel, false, false));
		writeReference(encapsulatedData, buffer, indentLevel + 1);
		writeContent(encapsulatedData, buffer, content, base64);
		buffer.append(createElementClosure(context, 0, true));
		return buffer.toString();
	}

	private void validate(FormatContext context, BareANY dataType, EncapsulatedData encapsulatedData) {
		String type = context.getType();
		String specializationType = dataType.getDataType() == null ? null : dataType.getDataType().getType();
		Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
		Hl7Errors errors = context.getModelToXmlResult();
		
		this.edValidationUtils.doValidate(encapsulatedData, specializationType, baseVersion, type, errors);
	}

	private void writeReference(EncapsulatedData data, StringBuffer buffer, int indentLevel) {
		if (StringUtils.isNotBlank(data.getReference())) {
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(ATTRIBUTE_VALUE, data.getReference());
			buffer.append("\n").append(createElement(ELEMENT_REFERENCE, attributes, indentLevel, true, true));
		}
	}

	private void writeContent(EncapsulatedData data, StringBuffer buffer, byte[] content, boolean base64) {
		if (content != null) {
			if (base64) {
				buffer.append(Base64.encodeBase64String(content));
			} else if (data instanceof EncapsulatedString) {
				buffer.append(XmlStringEscape.escape(((EncapsulatedString) data).getContentAsString()));
			} else {
				buffer.append(XmlStringEscape.escape(new String(content)));
			}
		}
	}

	private void addEncapsulatedDataAttributes(EncapsulatedData data, Map<String, String> attributes, boolean base64, String type, StandardDataType specializationType, VersionNumber version) {
		if (data.getMediaType() != null) {
			attributes.put(ATTRIBUTE_MEDIA_TYPE, data.getMediaType().getCodeValue());
		}
		
		if (StringUtils.isNotBlank(data.getLanguage())) {
			attributes.put(ATTRIBUTE_LANGUAGE, data.getLanguage());
		}

		if (StringUtils.isNotBlank(data.getCharset())) {
			attributes.put(ATTRIBUTE_CHARSET, data.getCharset());
		}

		if (base64 == true) {
			attributes.put(ATTRIBUTE_REPRESENTATION, REPRESENTATION_B64);
		}
		
		if (StandardDataType.ED_DOC_OR_REF.getType().equals(type) && !Hl7BaseVersion.CERX.equals(version.getBaseVersion())) {
			if (specializationType == StandardDataType.ED_DOC || specializationType == StandardDataType.ED_DOC_REF) {
				addSpecializationType(attributes, specializationType.getType());
			} else {
				// best guess: check content to decide on DOC or DOC_REF
				addSpecializationType(attributes, data.getContent() != null && data.getContent().length > 0 ? StandardDataType.ED_DOC.getType() : StandardDataType.ED_DOC_REF.getType());
			}
		}
		
	}

	private void addCompressedDataAttributes(EncapsulatedData data, Map<String, String> attributes) {
		if (data instanceof CompressedData) {
			CompressedData compressedData = (CompressedData) data;
			if (compressedData.getCompression() != null) {
				attributes.put(ATTRIBUTE_COMPRESSION, compressedData.getCompression().getCompressionType());
			}
		}
	}

	private byte[] getContent(EncapsulatedData data) {
		byte[] content = null;
		if (data instanceof CompressedData) {
			content = ((CompressedData) data).getCompressedContent();
		} else {
			content = data.getContent();
		}
		return content;
	}

}
