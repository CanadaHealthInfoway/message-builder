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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_COMPRESSION;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_LANGUAGE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_MEDIA_TYPE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_REPRESENTATION;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ATTRIBUTE_VALUE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.ELEMENT_REFERENCE;
import static ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils.REPRESENTATION_B64;

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
import ca.infoway.messagebuilder.marshalling.hl7.EdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

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

	private EdValidationUtils edValidationUtils = new EdValidationUtils();

	@Override
	protected EncapsulatedData parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		validateMaxChildCount(context, node, StandardDataType.ED_DOC.getType().equals(context.getType()) ? 2 : 1);
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
		String language = parseLanguage(element);
		String representation = parseRepresentation(element);
		String reference = parseReference(element);
		byte[] content = parseContent(element, representation);

		validate(specializationType, compression, mediaType, language, representation, reference, content, element, context, xmlToModelResult);
		
		if (compression != null) {
			return new CompressedData(mediaType, reference, content, compression, language);
		} else if (mediaType != null || reference != null || content != null) {
			return new EncapsulatedData(mediaType, reference, language, content);
		} else {
			return null;
		}
	}

	private void validate(String specializationType, Compression compression, x_DocumentMediaType mediaType, String language, String representation, String reference, byte[] content, 
			Element element, ParseContext context, XmlToModelResult xmlToModelResult) {

		Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
		String type = context.getType();
		Hl7Errors errors = xmlToModelResult;
		
		boolean hasCompression = element.hasAttribute(ATTRIBUTE_COMPRESSION);
		
		this.edValidationUtils.doValidate(specializationType, compression, hasCompression, mediaType, language, representation, reference, content, baseVersion, type, element, null, errors);
		
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
		return getSpecializationType(element);
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

	
}
