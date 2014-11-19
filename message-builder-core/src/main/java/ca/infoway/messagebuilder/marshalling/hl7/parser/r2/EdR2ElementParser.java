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

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.EdConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.util.xml.XmlRenderer;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

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

	private final TelR2ElementParser telParser = new TelR2ElementParser();
	private final EdConstraintsHandler constraintsHandler = new EdConstraintsHandler();

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
		
		validateInnerNodes(element, result);
		handleContent(ed, element, result, context);
		handleReference(ed, element, result, context);
		handleThumbnail(ed, element, result, context);
		
		handleConstraints(ed, context.getConstraints(), element, result);
		
		if (ed.isEmpty()) {
			ed = null;
		}
		
		return ed;
	}

	private void handleConstraints(EncapsulatedDataR2 ed, ConstrainedDatatype constraints, final Element element, final Hl7Errors errors) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, element));
			}
		};
		this.constraintsHandler.handleConstraints(constraints, ed, logger);
	}

	private void handleContent(EncapsulatedDataR2 ed, Element element, XmlToModelResult result, ParseContext context) {
		Node contentNode = determineContentNode(element, result);
		if (contentNode != null) {
	        if (contentNode.getNodeName().equals("#text")) {
	        	// debatable whether the text content should be trimmed or not; trimming for now
	        	ed.setTextContent(StringUtils.trim(contentNode.getTextContent()));
	        } else if (contentNode.getNodeType() == Node.CDATA_SECTION_NODE) {
	        	ed.setCdataContent(contentNode.getNodeValue());
	        } else {
	        	try {
					Document doc = XmlRenderer.obtainDocumentFromNode(contentNode, true);
					ed.setDocumentContent(doc);
				} catch (ParserConfigurationException e) {
					result.getHl7Errors().add(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR, "An error occurred trying to parse ED content: " + e.getMessage(), element));
				}
	        }
		}
	}

	private void validateInnerNodes(Element element, Hl7Errors errors) {
		// should come in the following order (ignoring empty text nodes)
		// at most one reference
		// at most one thumbnail
		// at most one content node (text, CDATA, element)
		int referenceCount = 0;
		int thumbnailCount = 0;
		int contentCount = 0;
		boolean nodesOutOfOrder = false;
		
		NodeList childNodes = element.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if ("reference".equals(node.getNodeName())) {
				if (thumbnailCount > 0 || contentCount > 0) {
					nodesOutOfOrder = true;
				}
				referenceCount++;
			} else if ("thumbnail".equals(node.getNodeName())) {
				if (contentCount > 0) {
					nodesOutOfOrder = true;
				}
				thumbnailCount++;
			} else if (!isEmptyTextNode(node)) {
				contentCount++;
			}
		}
		
		if (referenceCount > 1) {
			recordError("ED types only allow a single reference. Found: " + referenceCount, element, errors);
		}
		if (thumbnailCount > 1) {
			recordError("ED types only allow a single thumbnail. Found: " + thumbnailCount, element, errors);
		}
		if (contentCount > 1) {
			recordError("ED only supports a single content node. Found: " + contentCount, element, errors);
		}
		if (nodesOutOfOrder) {
			recordError("ED properties appear to be out of order. If provided, order must be (reference element, thumbnail element, content).", element, errors);
		}
	}

	private Node determineContentNode(Element element, Hl7Errors errors) {
		// skip reference element, thumbnail element, blank text nodes
		Node firstContentNode = null;
		NodeList childNodes = element.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (!"reference".equals(node.getNodeName()) && !"thumbnail".equals(node.getNodeName()) && !isEmptyTextNode(node)) {
				firstContentNode = node;
				break;
			}
		}
		return firstContentNode;
	}
	
    private boolean isEmptyTextNode(Node node) {
        return node.getNodeName().equals("#text") && StringUtils.isBlank(node.getTextContent());
	}

	private void handleIntegrityCheckAlgorithm(EncapsulatedDataR2 ed, Element element, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute("integrityCheckAlgorithm")) {
			String icaString = element.getAttribute("integrityCheckAlgorithm");
			try {
				IntegrityCheckAlgorithm ica = IntegrityCheckAlgorithm.valueOf(icaString);
				ed.setIntegrityCheckAlgorithm(ica);
			} catch (Exception e) {
				recordError("Unknown value for integrityCheckAlgorithm: " + icaString, element, result);
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
			Element referenceElement = references.get(0);
			ParseContext newContext = ParseContextImpl.create("TEL", context);
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
				recordError("Unknown value for representation: " + representationString, element, result);
			}
		}
	}

	private void handleThumbnail(EncapsulatedDataR2 ed, Element element, XmlToModelResult xmlToModelResult, ParseContext context) {
		List<Element> thumbnails = getNamedElements("thumbnail", element);
		
		if (!thumbnails.isEmpty()) {
			Element thumbnailElement = thumbnails.get(0);
			ParseContext newContext = ParseContextImpl.create("ED", context);
			BareANY parsedThumbnail = this.parse(newContext, thumbnailElement, xmlToModelResult);
			EncapsulatedDataR2 edThumbnail = (EncapsulatedDataR2) parsedThumbnail.getBareValue();
			ed.setThumbnail(edThumbnail);
			if (edThumbnail.getThumbnail() != null) {
				recordError("ED thumbnail properties should not themselves also have a thumbnail." + thumbnails.size(), element, xmlToModelResult);
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

	private void recordError(String message, Element element, Hl7Errors errors) {
		errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, element));
	}
	
}
