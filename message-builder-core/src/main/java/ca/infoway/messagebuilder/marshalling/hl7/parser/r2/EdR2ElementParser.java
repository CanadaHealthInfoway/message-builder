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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-03-11 18:38:50 -0400 (Mon, 11 Mar 2013) $
 * Revision:      $LastChangedRevision: 6702 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

/**
 * ED (R2)- Encapsulated Data
 * 
 * Parses a ED element into an Encapsulated Data:
 * 
 * <element-name mediaType="text/plain">This is some text.</element-name>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 *
 */
@DataTypeHandler("ED")
class EdR2ElementParser extends AbstractSingleElementParser<EncapsulatedDataR2> {

	private TelR2ElementParser telParser = new TelR2ElementParser();

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EDImpl<EncapsulatedDataR2>();
	}

	@Override
	protected EncapsulatedDataR2 parseNonNullNode(ParseContext context, Node node, BareANY bareAny, Type expectedReturnType, XmlToModelResult result) {

		Element element = (Element) node;
		
		EncapsulatedDataR2 ed = new EncapsulatedDataR2();

		handleRepresentation(ed, element, context, result);
		handleMediaType(ed, element, result);
		handleLanguage(ed, element, result);
		handleCompression(ed, element, result);
		handleIntegrityCheck(ed, element, context, result);
		handleIntegrityCheckAlgorithm(ed, element, context, result);
		
		handleContent(ed, element, result, context);
		handleReference(ed, element, result, context);
		handleThumbnail(ed, element, result, context);
		
		if (ed.isEmpty()) {
			ed = null;
		}
		
		return ed;
	}

	private void handleContent(EncapsulatedDataR2 ed, Element element, XmlToModelResult result, ParseContext context) {
		
//		DOMImplementationLS lsImpl = (DOMImplementationLS)element.getOwnerDocument().getImplementation().getFeature("LS", "3.0");
//		LSSerializer serializer = lsImpl.createLSSerializer();
//		serializer.getDomConfig().setParameter("xml-declaration", false); //by default its true, so set it to false to get String without xml-declaration
//		String str = serializer.writeToString(element);
//		System.out.println(str);
		
		// FIXME - TM - CDA - need to expand on this 
		//                  - validate that there is only one "extra" element (ignoring blank text nodes) after reference and thumbnail; could be a non-blank text node, or document content
		
		String content = NodeUtil.getTextValue(element, false);
		if (!StringUtils.isBlank(content)) {
			ed.setContent(content);
		}
	}

	private void handleIntegrityCheckAlgorithm(EncapsulatedDataR2 ed, Element element, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute("integrityCheckAlgorithm")) {
			String icaString = element.getAttribute("integrityCheckAlgorithm");
			try {
				IntegrityCheckAlgorithm ica = IntegrityCheckAlgorithm.valueOf(icaString);
				ed.setIntegrityCheckAlgorithm(ica);
			} catch (Exception e) {
				recordError("Unknown value for integrityCheckAlgorithm: " + icaString, element, context, result);
			}
		}
	}

	private void handleIntegrityCheck(EncapsulatedDataR2 ed, Element element, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute("integrityCheck")) {
			String icString = element.getAttribute("integrityCheck");
			ed.setIntegrityCheck(icString);
		}
	}

	private void handleReference(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult, ParseContext context) {
		List<Element> references = getNamedElements("reference", element);
		if (!references.isEmpty()) {
			if (references.size() > 1) {
				recordError("ED types only allow a single reference. Found: " + references.size(), element, context, xmlToModelResult);
			}
			Element referenceElement = references.get(0);
			ParseContext newContext = ParserContextImpl.create("TEL", context);
			BareANY parsedRef = this.telParser.parse(newContext, referenceElement, xmlToModelResult);
			if (parsedRef != null && parsedRef.getBareValue() != null) {
				ed.setReference((TelecommunicationAddress) parsedRef.getBareValue());
			}
		}
	}

	private void handleRepresentation(EncapsulatedDataR2 ed, Element element, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute("representation")) {
			String representationString = element.getAttribute("representation");
			try {
				EdRepresentation representation = EdRepresentation.valueOf(representationString);
				ed.setRepresentation(representation);
			} catch (Exception e) {
				recordError("Unknown value for representation: " + representationString, element, context, result);
			}
		}
	}

	private void handleThumbnail(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult, ParseContext context) {
		List<Element> thumbnails = getNamedElements("thumbnail", element);
		
		if (!thumbnails.isEmpty()) {
			if (thumbnails.size() > 1) {
				recordError("ED types only allow a single thumbnail. Found: " + thumbnails.size(), element, context, xmlToModelResult);
			}
			Element thumbnailElement = thumbnails.get(0);
			ParseContext newContext = ParserContextImpl.create("ED", context);
			BareANY parsedThumbnail = this.parse(newContext, thumbnailElement, xmlToModelResult);
			EncapsulatedDataR2 edThumbnail = (EncapsulatedDataR2) parsedThumbnail.getBareValue();
			ed.setThumbnail(edThumbnail);
			if (edThumbnail.getThumbnail() != null) {
				recordError("ED thumbnail properties should not themselves also have a thumbnail." + thumbnails.size(), element, context, xmlToModelResult);
			}
		}
	}

	private void handleLanguage(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult) {
		if (element.hasAttribute("language")) {
			ed.setLanguage(element.getAttribute("language"));
		}
	}

	private void handleCompression(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult) {
		if (element.hasAttribute("compression")) {
			ed.setCompression(Compression.get(element.getAttribute("compression")));
		}
	}

	private void handleMediaType(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult) {
		if (element.hasAttribute("mediaType")) {
			ed.setMediaType(X_DocumentMediaType.get(element.getAttribute("mediaType")));
		}
	}

	private void recordError(String message, Element element, ParseContext context, XmlToModelResult result) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, element));
	}
	
}