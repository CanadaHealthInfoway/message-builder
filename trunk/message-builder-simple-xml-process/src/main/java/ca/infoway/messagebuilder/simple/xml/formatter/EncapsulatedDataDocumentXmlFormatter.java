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

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class EncapsulatedDataDocumentXmlFormatter extends AbstractSimpleXmlFormatter {
	
	public static final String REPRESENTATION_B64 = "B64";
	public static final String ATTRIBUTE_COMPRESSION = "compression";
	public static final String ATTRIBUTE_LANGUAGE = "language";
	public static final String ATTRIBUTE_REFERENCE = "uri";
	public static final String ATTRIBUTE_MEDIA_TYPE = "mediaType";

	protected EncapsulatedDataDocumentXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public ED<EncapsulatedData> format(FormatContext formatContext, Element value) throws FormatterException {
		ED<EncapsulatedData> result = null;
		
		EncapsulatedData encapsulatedData = null;
		
		try {
			encapsulatedData = parse(value, formatContext);
			if (encapsulatedData == null) {
				processError(formatContext, "Document could not be created", value);
			}
		} catch (DecoderException e) {
			processError(formatContext, "Document caused exception while being parsed - " + e.getMessage(), value);
		}
			
		if (encapsulatedData != null) {
			result = new EDImpl<EncapsulatedData>(encapsulatedData);
		}
		
		return result;
	}
	
	private EncapsulatedData parse(Element element, FormatContext context) throws DecoderException, FormatterException {
		x_DocumentMediaType mediaType = parseMediaType(element);
		Compression compression = parseCompression(element);
		String language = parseLanguage(element);
		String reference = parseReference(element, context);
		byte[] content = parseContent(getSingleElement(element, "document"), context, REPRESENTATION_B64);
		if (compression != null) {
			return new CompressedData(mediaType, reference, content, compression, language);
		} else if (mediaType != null || reference != null || content != null) {
			return new EncapsulatedData(mediaType, reference, language, content);
		} else {
			return null;
		}
	}

	private byte[] parseContent(Element element, FormatContext context, String representation) throws DecoderException, FormatterException {
		byte[] content = null;
		String text = (element == null ? null : element.getTextContent());
		if (StringUtils.isNotBlank(text) && context.matchesType(StandardDataType.ED_DOC)) {
			if (REPRESENTATION_B64.equalsIgnoreCase(representation)) {
				content = Base64.decodeBase64(text.getBytes());
			} else {
				content = text.getBytes();
			}
		} else if (StringUtils.isBlank(text) == context.matchesType(StandardDataType.ED_DOC)) {
			processError(context, "Document type must have content; Reference type may not have content", element);
		}
		return content;
	}

	private String parseReference(Element element, FormatContext context) throws FormatterException {
		if (element.hasAttribute(ATTRIBUTE_REFERENCE)) {
			return element.getAttribute(ATTRIBUTE_REFERENCE);
		} else if (context.matchesType(StandardDataType.ED_DOC_REF) || context.matchesType(StandardDataType.ED_REF)) {
			processError(context, "Reference type requires reference attribute", element);
		}
		return null;
	}

	private String parseLanguage(Element element) {
		if (element.hasAttribute(ATTRIBUTE_LANGUAGE)) {
			String lang = element.getAttribute(ATTRIBUTE_LANGUAGE);
			return convertLanguage(lang);
		}
		return null;
	}

	private String convertLanguage(String lang) {
		if ("en".equalsIgnoreCase(lang)) {
			return "en-CA";
		} else if ("fr".equalsIgnoreCase(lang)) {
			return "fr-CA";
		} else {
			return lang;
		}
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

}
