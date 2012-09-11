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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_CHARSET;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_COMPRESSION;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_LANGUAGE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_MEDIA_TYPE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_REPRESENTATION;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_VALUE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ELEMENT_REFERENCE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.REPRESENTATION_B64;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * ED - Encapsulated Data (Document or Reference)
 * 
 * Parses a ED element into an Encapsulated Data:
 * 
 * <element-name mediaType="text/plain">This is some text.</element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 *
 * This appears to be correct, although all of the examples name the outer element as "text".
 *
 * Note that there are many more variations on this datatype. HTML, XML and PDF data are
 * all supported. However the current schemas that we work with all define the document
 * as a String so plain text is all we support at the moment.
 */
@DataTypeHandler("ED")
class EdElementParser extends AbstractSingleElementParser<EncapsulatedData> {

	private static final int ONE_MEGABYTE_SIZE = 1048576;

	@Override
	protected EncapsulatedData parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		validateMaxChildCount(context, node, 1);
		try {
			return parse((Element) node, context, xmlToModelResult);
		} catch (RuntimeException e) {
			throw new XmlToModelTransformationException(e);
		}
	}

	private EncapsulatedData parse(Element element, ParseContext context, XmlToModelResult xmlToModelResult) {
		
		String specializationType = parseSpecializationType(element);
		Compression compression = parseCompression(element);
		x_DocumentMediaType mediaType = parseMediaType(element);
		String charset = parseCharset(element);
		String language = parseLanguage(element);
		String representation = parseRepresentation(element);
		String reference = parseReference(element);
		byte[] content = parseContent(element, representation);

		validate(specializationType, compression, mediaType, charset, language, representation, reference, content, element, context, xmlToModelResult);
		
		if (compression != null) {
			return new CompressedData(mediaType, reference, content, compression, language, charset);
		} else if (mediaType != null || reference != null || content != null) {
			return new EncapsulatedData(mediaType, reference, language, content, charset);
		} else {
			return null;
		}
	}

	private void validate(String specializationType, Compression compression, x_DocumentMediaType mediaType, String charset, String language, String representation, String reference, byte[] content, 
			Element element, ParseContext context, XmlToModelResult xmlToModelResult) {

		Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
		String type = context.getType();
		Hl7Errors errors = xmlToModelResult;
		
		// specializationType - must be provided for ED.DOCORREF *except* for CeRx; must be ED.DOC or ED.DOCREF
		if (StandardDataType.ED_DOC_OR_REF.getType().equals(type) && !Hl7BaseVersion.CERX.equals(baseVersion)) {
			if (StringUtils.isBlank(specializationType)) {
				// must specify
				type = (content == null || content.length == 0 ? StandardDataType.ED_DOC_REF.getType() : StandardDataType.ED_DOC.getType());
				createError("Must specify specializationType for ED.DOC_OR_REF types. Value will be treated as " + type + ".", element, errors);
			} else if (!(StandardDataType.ED_DOC.getType().equals(specializationType) || StandardDataType.ED_DOC_REF.getType().equals(specializationType))) {
				// must be doc or docref; default to something suitable 
				type = (content == null || content.length == 0 ? StandardDataType.ED_DOC_REF.getType() : StandardDataType.ED_DOC.getType());
				createError("The specializationType must be ED.DOC or ED.DOCREF for ED.DOC_OR_REF types. Value will be treated as " + type + ".", element, errors);
			} else {
				type = specializationType;
			}
		}
		
		// compression - required, must be DF or GZ
		//             - only GZ for CeRx (ED.DOCORREF), and only allowed if content present
		//             - not permitted for ED.REF
		if (compression != null) {
			if (StandardDataType.ED_REF.getType().equals(type)) {
				// not allowed
				createError("Compression not allowed for ED.REF types.", element, errors);
			} else if (Hl7BaseVersion.CERX.equals(baseVersion) && !Compression.GZIP.getCompressionType().equals(compression.getCompressionType())) {
				// only GZ allowed in this case
				createError("Only GZ compression allowed for CeRx ED.REF type.", element, errors);
			} else if (!Compression.GZIP.getCompressionType().equals(compression.getCompressionType()) && !Compression.DEFLATE.getCompressionType().equals(compression.getCompressionType())) {
				// only DF or GZ
				createError("Compression must be DF or GZ.", element, errors);
			}
		}
		
		// mediatype - mandatory; value from x_DocumentMediaType
		//           - ED.DOC/ED.DOCREF/MR2007, ED.DOCORREF/ED.REF/CeRx: restricted to "text/plain", "text/html", "text/xml", "application/pdf"
		if (mediaType == null) {
			// must be provided, and must be acceptable value
			createError("MediaType must be provided and must be a value from x_DocumentMediaType.", element, errors);
		}
		
		// charset - mandatory (MR2009); not permitted for MR2007/CeRx
		if (StringUtils.isBlank(charset) && Hl7BaseVersion.MR2009.equals(baseVersion)) {
			// must provide for MR2009
			// FIXME - VALIDATION - TM - waiting to hear back from Sam on whether this is really mandatory for MR2009
		} else if (StringUtils.isNotBlank(charset) && !Hl7BaseVersion.MR2009.equals(baseVersion)) {
			// not permitted
			createError("The charset attribute is not permitted.", element, errors);
		}
		
		// language - required, 2-2
		//          - "eng" or "fre" (CeRx)
		if (StringUtils.isNotBlank(language)) {
			if (Hl7BaseVersion.CERX.equals(baseVersion)) {
				if (!"eng".equalsIgnoreCase(language) && !"fre".equalsIgnoreCase(language)) {
					// incorrect language for CeRx
					createError("The language attribute must be one of 'eng' or 'fre'.", element, errors);
				}
			} else {
				if (language.length() != 5 || (language.charAt(2) != '-')) {
					// needs to be a language code (yes, the above check isn't perfect, but it should be fine for most cases)
					createError("The language attribute must be a 2-letter language code, followed by a hyphen, followed by a 2-letter country code.", element, errors);
				}
			}
		}
		
		// representation - TXT or B64; vague on if this is mandatory or not; not permitted for CeRx
		if (StringUtils.isNotBlank(representation)) {
			if (!"TXT".equalsIgnoreCase(representation) && !"B64".equalsIgnoreCase(representation)) {
				// error
				createError("The representation attribute must be one of 'TXT' or 'B64'.", element, errors);
			}
		}
		
		// reference - required; must be TEL.URI (mandatory for ED.DOCREF)
		//           - CeRx: only allowed (and mandatory?) if content not present; must be FTP, HTTP, HTTPS  (ED.REF, ED.DOCORREF) 
		if (StringUtils.isBlank(reference)) {
			if (StandardDataType.ED_DOC_REF.getType().equals(type) || StandardDataType.ED_REF.getType().equals(type)) {
				// mandatory case
				createError("Reference is mandatory.", element, errors);
			}
		}
		if (element.hasAttribute(ELEMENT_REFERENCE)) {
			createError("Reference is not allowed as an attribute; it should be in a <reference> element having a value attribute containing the actual reference.", element, errors);
		}
		
		// content - max 1 MB after compression and base64 encoding; compressed or pdf must be b64-encoded; any checks done on this??
		//         - mandatory for ED.DOC, ED.DOCORREF/CeRx (if no ref provided)
		//         - not permitted for ED.DOCREF/ED.REF
		if (content != null && content.length > 0) {
			if (StandardDataType.ED_DOC_REF.getType().equals(type) || StandardDataType.ED_REF.getType().equals(type)) {
				// not permitted
				createError("Content is not permitted for " + type + ".", element, errors);
			}
			if (content.length > ONE_MEGABYTE_SIZE) {
				// too large
				createError("Content must be less than 1 MB.", element, errors);
			}
		} else {
			if (StandardDataType.ED_DOC.getType().equals(type)) {
				// must be provided
				createError("Content must be provided for " + type + ".", element, errors);
			}
		}
		
		if (Hl7BaseVersion.CERX.equals(baseVersion) && StandardDataType.ED_DOC_OR_REF.getType().equals(type)) {
			if (StringUtils.isNotBlank(reference) && (content != null && content.length > 0)) {
				// can't provide both
				createError("Cannot provide both content and reference.", element, errors);
			} else if (StringUtils.isBlank(reference) && (content == null || content.length == 0)) {
				// must provide one
				createError("Must provide one and only one of content or reference.", element, errors);
			}
		}
		
	}

	private byte[] parseContent(Element element, String representation) {
		byte[] content = null;
		String text = NodeUtil.getTextValue(element, false);
		if (!StringUtils.isBlank(text)) {
			if (REPRESENTATION_B64.equalsIgnoreCase(representation)) {
				content = Base64.decodeBase64String(text);
			} else {
				content = text.getBytes();
			}
		}
		return content;
	}

	private String parseRepresentation(Element element) {
		if (element.hasAttribute(ATTRIBUTE_REPRESENTATION)) {
			return element.getAttribute(ATTRIBUTE_REPRESENTATION);
		}
		return null;
	}

	private String parseReference(Element element) {
		if (element.hasAttribute(ELEMENT_REFERENCE)) {
			// this format of ED is no longer correct (for any HL7v3 version), contrary to what V01R04.3 and V02R02 data type specifications state
			return element.getAttribute(ELEMENT_REFERENCE);
		} else {
			// look for newer format for providing reference within a "value" attribute of a "reference" element
			NodeList elements = element.getElementsByTagName(ELEMENT_REFERENCE);
			if (elements.getLength() == 1) {
				Element reference = (Element) elements.item(0);
				if (reference.hasAttribute(ATTRIBUTE_VALUE)) {
					return reference.getAttribute(ATTRIBUTE_VALUE);
				}
			}
		}
		return null;
	}

	private String parseSpecializationType(Element element) {
		if (element.hasAttribute(SPECIALIZATION_TYPE)) {
			return element.getAttribute(SPECIALIZATION_TYPE);
		}
		return null;
	}

	private String parseCharset(Element element) {
		if (element.hasAttribute(ATTRIBUTE_CHARSET)) {
			return element.getAttribute(ATTRIBUTE_CHARSET);
		}
		return null;
	}

	private String parseLanguage(Element element) {
		if (element.hasAttribute(ATTRIBUTE_LANGUAGE)) {
			return element.getAttribute(ATTRIBUTE_LANGUAGE);
		}
		return null;
	}

	private Compression parseCompression(Element element) {
		if (element.hasAttribute(ATTRIBUTE_COMPRESSION)) {
			return Compression.get(element.getAttribute(ATTRIBUTE_COMPRESSION));
		}
		return null;
	}

	private x_DocumentMediaType parseMediaType(Element element) {
		if (element.hasAttribute(ATTRIBUTE_MEDIA_TYPE)) {
			return X_DocumentMediaType.get(element.getAttribute(ATTRIBUTE_MEDIA_TYPE));
		}
		return null;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EDImpl<EncapsulatedData>();
	}

	
	private void createError(String errorMessage, Element element, Hl7Errors errors) {
		errors.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						errorMessage + " ("	+ XmlDescriber.describeSingleElement(element) + ")", 
						element));
	}
	
}
