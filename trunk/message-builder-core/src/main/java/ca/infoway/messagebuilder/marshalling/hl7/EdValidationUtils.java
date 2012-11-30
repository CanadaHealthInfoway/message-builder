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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.PLAIN_TEXT;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class EdValidationUtils {

	private static final int ONE_MEGABYTE_SIZE = 1048576;

	public static final String REPRESENTATION_TXT = "TXT";
	public static final String REPRESENTATION_B64 = "B64";
	public static final String ATTRIBUTE_COMPRESSION = "compression";
	public static final String ATTRIBUTE_LANGUAGE = "language";
	public static final String ATTRIBUTE_REPRESENTATION = "representation";
	public static final String ATTRIBUTE_MEDIA_TYPE = "mediaType";
	public static final String ELEMENT_REFERENCE = "reference";
	public static final String ATTRIBUTE_VALUE = "value"; // for newer format of "reference" usage
	public static final String CERX_ENGLISH = "eng";
	public static final String CERX_FRENCH = "fre";

	public void doValidate(EncapsulatedData encapsulatedData, String specializationType, Hl7BaseVersion baseVersion, String type, String propertyPath, Hl7Errors errors) {
		Compression compression = (encapsulatedData instanceof CompressedData ? ((CompressedData) encapsulatedData).getCompression() : null);
		boolean hasCompression = (compression != null);
		String representation = this.isBase64(encapsulatedData, encapsulatedData.getContent()) ? REPRESENTATION_B64 : REPRESENTATION_TXT;
		doValidate(specializationType, compression, hasCompression, encapsulatedData.getMediaType(), encapsulatedData.getLanguage(), representation, encapsulatedData.getReference(), encapsulatedData.getContent(), baseVersion, type, null, propertyPath, errors);
	}

	public void doValidate(String specializationType, 
							Compression compression,
							boolean hasCompression,
							x_DocumentMediaType mediaType, 
							String language, 
							String representation, 
							String reference, 
							byte[] content, 
							Hl7BaseVersion baseVersion, 
							String type, 
							Element element, 
							String propertyPath, 
							Hl7Errors errors) {
		
		// specializationType - must be provided for ED.DOCORREF *except* for CeRx; must be ED.DOC or ED.DOCREF
		if (StandardDataType.ED_DOC_OR_REF.getType().equals(type) && !Hl7BaseVersion.CERX.equals(baseVersion)) {
			if (StringUtils.isBlank(specializationType) || StandardDataType.ED.getType().equals(specializationType)) {
				// must specify
				type = (content == null || content.length == 0 ? StandardDataType.ED_DOC_REF.getType() : StandardDataType.ED_DOC.getType());
				createError("Must specify specializationType for ED.DOC_OR_REF types. Value will be treated as " + type + ".", element, propertyPath, errors);
			} else if (!(StandardDataType.ED_DOC.getType().equals(specializationType) || StandardDataType.ED_DOC_REF.getType().equals(specializationType))) {
				// must be doc or docref; default to something suitable 
				type = (content == null || content.length == 0 ? StandardDataType.ED_DOC_REF.getType() : StandardDataType.ED_DOC.getType());
				createError("Invalid specializationType: " + specializationType + ". The specializationType must be ED.DOC or ED.DOCREF for ED.DOC_OR_REF types. Value will be treated as " + type + ".", element, propertyPath, errors);
			} else {
				type = specializationType;
			}
		}
		
		// compression - required, must be DF or GZ
		//             - only GZ for CeRx (ED.DOCORREF), and only allowed if content present
		//             - not permitted for ED.REF
		if (hasCompression) {
			if (StandardDataType.ED_REF.getType().equals(type)) {
				// not allowed
				createError("Compression not allowed for ED.REF types.", element, propertyPath, errors);
			} else if (Hl7BaseVersion.CERX.equals(baseVersion) && (compression == null || !Compression.GZIP.getCompressionType().equals(compression.getCompressionType()))) {
				// only GZ allowed in this case
				createError("Only GZ compression allowed for CeRx ED.DOCORREF type.", element, propertyPath, errors);
			} else if (compression == null || (!Compression.GZIP.getCompressionType().equals(compression.getCompressionType()) && !Compression.DEFLATE.getCompressionType().equals(compression.getCompressionType()))) {
				// only DF or GZ
				createError("Compression must be DF or GZ.", element, propertyPath, errors);
			}
		}
		
		// mediatype - mandatory; value from x_DocumentMediaType
		//           - ED.DOC/ED.DOCREF/MR2007, ED.DOCORREF/ED.REF/CeRx: restricted to "text/plain", "text/html", "text/xml", "application/pdf"
		if (mediaType == null) {
			// must be provided, and must be acceptable value
			createError("MediaType must be provided and must be a value from x_DocumentMediaType.", element, propertyPath, errors);
		}
		
		// language - required, 2-2
		//          - "eng" or "fre" (CeRx)
		if (StringUtils.isNotBlank(language)) {
			if (Hl7BaseVersion.CERX.equals(baseVersion)) {
				if (!CERX_ENGLISH.equalsIgnoreCase(language) && !CERX_FRENCH.equalsIgnoreCase(language)) {
					// incorrect language for CeRx
					createError("The language attribute must be one of 'eng' or 'fre'.", element, propertyPath, errors);
				}
			} else {
				if (language.length() != 5 || (language.charAt(2) != '-')) {
					// needs to be a language code (yes, the above check isn't perfect, but it should be fine for most cases)
					createError("The language attribute must be a 2-letter language code, followed by a hyphen, followed by a 2-letter country code.", element, propertyPath, errors);
				}
			}
		}
		
		// representation - TXT or B64; vague on if this is mandatory or not; not permitted for CeRx
		if (StringUtils.isNotBlank(representation)) {
			if (!REPRESENTATION_TXT.equalsIgnoreCase(representation) && !REPRESENTATION_B64.equalsIgnoreCase(representation)) {
				// error
				createError("The representation attribute must be one of 'TXT' or 'B64'.", element, propertyPath, errors);
			}
		}
		
		// reference - required; must be TEL.URI (mandatory for ED.DOCREF)
		//           - CeRx: only allowed (and mandatory?) if content not present; must be FTP, HTTP, HTTPS  (ED.REF, ED.DOCORREF) 
		if (StringUtils.isBlank(reference)) {
			if (StandardDataType.ED_DOC_REF.getType().equals(type) || StandardDataType.ED_REF.getType().equals(type)) {
				// mandatory case
				createError("Reference is mandatory.", element, propertyPath, errors);
			}
		}
		if (element != null && element.hasAttribute(ELEMENT_REFERENCE)) {
			createError("Reference is not allowed as an attribute; it should be in a <reference> element having a value attribute containing the actual reference.", element, propertyPath, errors);
		}
		
		// content - max 1 MB after compression and base64 encoding; compressed or pdf must be b64-encoded; any checks done on this??
		//         - mandatory for ED.DOC, ED.DOCORREF/CeRx (if no ref provided)
		//         - not permitted for ED.DOCREF/ED.REF
		if (content != null && content.length > 0) {
			if (StandardDataType.ED_DOC_REF.getType().equals(type) || StandardDataType.ED_REF.getType().equals(type)) {
				// not permitted
				createError("Content is not permitted for " + type + ".", element, propertyPath, errors);
			}
			if (content.length > ONE_MEGABYTE_SIZE) {
				// too large
				createError("Content must be less than 1 MB.", element, propertyPath, errors);
			}
		} else {
			if (StandardDataType.ED_DOC.getType().equals(type)) {
				// must be provided
				createError("Content must be provided for " + type + ".", element, propertyPath, errors);
			}
		}
		
		if (Hl7BaseVersion.CERX.equals(baseVersion) && StandardDataType.ED_DOC_OR_REF.getType().equals(type)) {
			if (StringUtils.isNotBlank(reference) && (content != null && content.length > 0)) {
				// can't provide both
				createError("Cannot provide both content and reference.", element, propertyPath, errors);
			} else if (StringUtils.isBlank(reference) && (content == null || content.length == 0)) {
				// must provide one
				createError("Must provide one and only one of content or reference.", element, propertyPath, errors);
			}
		}
	}

	private void createError(String errorMessage, Element element, String propertyPath, Hl7Errors errors) {
		Hl7Error error = null;
		if (element != null) {
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage + 	" (" + XmlDescriber.describeSingleElement(element) + ")", 
					element);		
		} else { // assuming this has a property path
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage, 
					propertyPath);		
		}
		
		errors.addHl7Error(error);
	}

	public boolean isBase64(EncapsulatedData data, byte[] content) {
		if (data != null) {
			if (data instanceof CompressedData) {
				return true;
			} else if (content != null && data.getMediaType() != PLAIN_TEXT) {
				return true;
			}
		}
		return false;
	}


}
