/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_COMPRESSION;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_LANGUAGE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_MEDIA_TYPE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_REFERENCE;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.ATTRIBUTE_REPRESENTATION;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter.REPRESENTATION_B64;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.Compression;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.MediaType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
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

	@Override
	protected EncapsulatedData parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToJavaResult)
			throws XmlToModelTransformationException {
		validateMaxChildCount(context, node, 1);
		try {
			return parse(node);
		} catch (RuntimeException e) {
			throw new XmlToModelTransformationException(e);
		}
	}

	private EncapsulatedData parse(Node node) {
		Element element = (Element) node;
		MediaType mediaType = parseMediaType(element);
		Compression compression = parseCompression(element);
		String language = parseLanguage(element);
		String representation = parseRepresentation(element);
		String reference = parseReference(element);
		byte[] content = parseContent(element, representation);
		if (compression != null || language != null) {
			return new CompressedData(mediaType, reference, content, compression, language);
		} else if (mediaType != null || reference != null || content != null) {
			return new EncapsulatedData(mediaType, reference, content);
		} else {
			return null;
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
		if (element.hasAttribute(ATTRIBUTE_REFERENCE)) {
			return element.getAttribute(ATTRIBUTE_REFERENCE);
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

	private MediaType parseMediaType(Element element) {
		if (element.hasAttribute(ATTRIBUTE_MEDIA_TYPE)) {
			return MediaType.get(element.getAttribute(ATTRIBUTE_MEDIA_TYPE));
		}
		return null;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EDImpl<EncapsulatedData>();
	}
}
