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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;


import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.HXIT;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.CodedTypesConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.CodeLookupUtils;
import ca.infoway.messagebuilder.marshalling.hl7.parser.EdElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

/**
 * CodedType parser for R2
 * 
 */
public abstract class AbstractCodedTypeR2ElementParser extends AbstractSingleElementParser<CodedTypeR2<Code>> {

	private static final String CODE_SYSTEM_NAME = "codeSystemName";
	protected static final String STANDARD_CODE_ATTRIBUTE_NAME = "code";
	protected static final String CODE_SYSTEM_ATTRIBUTE_NAME = "codeSystem";

	private static final String CODE_SYSTEM_VERSION = "codeSystemVersion";
	private static final String DISPLAY_NAME = "displayName";
	private static final String VALUE = "value";
	private static final String QTY = "qty";
	
	private CodeLookupUtils codeLookupUtils = new CodeLookupUtils();
	private SxcmR2ElementParserHelper operatorHelper = new SxcmR2ElementParserHelper();
	private IvlTsR2ElementParser validTimeParser = new IvlTsR2ElementParser();
	private EdElementParser edParser = new EdElementParser(new TelR2ElementParser(), true);
	private CodedTypesConstraintsHandler constraintsHandler = new CodedTypesConstraintsHandler();
	
	@Override
	protected CodedTypeR2<Code> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		throw new UnsupportedOperationException("Nothing should be calling this method.");
	}
	
    @Override
	public BareANY parse(ParseContext context, Node node, XmlToModelResult result) {
    	BareANY codedTypeAny = doCreateDataTypeInstance(context.getType());
        
    	Element element = (Element) node;

    	CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();

    	// attributes
    	handleNullFlavor(element, codedTypeAny, context, result);
    	handleCodeAndCodeSystem(element, codedType, context, result);    	
    	handleCodeSystemName(element, codedType, context, result);
    	handleCodeSystemVersion(element, codedType, context, result);
    	handleDisplayName(element, codedType, context, result);
    	handleValue(element, codedType, context, result);
    	handleQty(element, codedType, context, result);
    	handleOperator(element, codedTypeAny, codedType, context, result);

    	// elements
		handleSimpleValue(element, codedType, context, result);
    	handleOriginalText(element, codedType, context, result);
    	handleQualifier(element, codedType, context, result);
    	handleTranslation(element, codedType, context, result);
    	handleValidTime(element, codedType, context, result);

    	handleConstraints(codedType, context.getConstraints(), element, result);
    	
    	// want to return null if no attributes or elements are present
    	if (codedType.isEmpty()) {
    		codedType = null;
    	}
    	
    	((BareANYImpl) codedTypeAny).setBareValue(codedType);
        return codedTypeAny;
    }

	private void handleConstraints(CodedTypeR2<Code> codedType, ConstrainedDatatype constraints, final Element element, final Hl7Errors errors) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, element));
			}
		};

		this.constraintsHandler.handleConstraints(constraints, codedType, logger);
	}

	private void handleQualifier(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (qualifierAllowed()) {
			ParseContext newContext = ParseContextImpl.create("CR", Code.class, context);
			
			NodeList qualifiers = element.getElementsByTagName("qualifier");
			for (int i = 0, length = qualifiers.getLength(); i < length; i++) {
				Element qualifierElement = (Element) qualifiers.item(i);
				// only want direct child node qualifiers
				if (qualifierElement.getParentNode().isSameNode(element)) {
					BareANY anyCr = new CrR2ElementParser().parse(newContext, qualifierElement, result);
					if (anyCr != null && anyCr.getBareValue() != null) {
						codedType.getQualifier().add((CodeRole) anyCr.getBareValue());
					}
				}
			}
    	} else {
    		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
    	}
	}

	private void handleNullFlavor(Element element, BareANY dataType, ParseContext context, XmlToModelResult result) {
		if (hasValidNullFlavorAttribute(context, element, result)) {
            NullFlavor nullFlavor = parseNullNode(context, element, result);
            dataType.setNullFlavor(nullFlavor);
        }
	}

	private void handleCodeAndCodeSystem(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
    	String code = getAttributeValue(element, STANDARD_CODE_ATTRIBUTE_NAME);
		String codeSystem = null;
		if (element.hasAttribute(CODE_SYSTEM_ATTRIBUTE_NAME)) {
    		if (codeSystemAllowed()) {
    			codeSystem = StringUtils.trimToNull(getAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME));
    		} else {
        		logValueNotAllowed(CODE_SYSTEM_ATTRIBUTE_NAME, element, context, result);
    		}
    	}
		
		Code actualCode = this.codeLookupUtils.getCorrespondingCode(code, codeSystem, context.getExpectedReturnType(), element, context.getType(), result, true);
		codedType.setCode(actualCode);
	}

	private void handleCodeSystemName(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute(CODE_SYSTEM_NAME)) {
    		if (codeSystemNameAllowed()) {
    			String codeSystemName = getAttributeValue(element, CODE_SYSTEM_NAME);
    			codedType.setCodeSystemName(StringUtils.trimToNull(codeSystemName));
    		} else {
        		logValueNotAllowed(CODE_SYSTEM_NAME, element, context, result);
    		}
    	}
	}
	
	private void handleCodeSystemVersion(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute(CODE_SYSTEM_VERSION)) {
    		if (codeSystemVersionAllowed()) {
    			String codeSystemVersion = getAttributeValue(element, CODE_SYSTEM_VERSION);
    			codedType.setCodeSystemVersion(StringUtils.trimToNull(codeSystemVersion));
    		} else {
        		logValueNotAllowed(CODE_SYSTEM_VERSION, element, context, result);
    		}
    	}
	}
	
	private void handleDisplayName(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute(DISPLAY_NAME)) {
    		if (displayNameAllowed()) {
    			String displayName = getAttributeValue(element, DISPLAY_NAME);
    			codedType.setDisplayName(StringUtils.trimToNull(displayName));
    		} else {
        		logValueNotAllowed(DISPLAY_NAME, element, context, result);
    		}
    	}
	}
	
	private void handleValue(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute(VALUE)) {
    		if (valueAllowed()) {
    			String valueString = StringUtils.trimToNull(getAttributeValue(element, VALUE));
    			BigDecimal valueBigDecimal = null;
    			try {
    				valueBigDecimal = new BigDecimal(valueString);
    			} catch (Exception e) {
    				recordError("Value attribute is not a valid decimal number: " + valueString, element, context, result);
    			}
    			codedType.setValue(valueBigDecimal);
    		} else {
        		logValueNotAllowed(VALUE, element, context, result);
    		}
    	}
	}
	
	private void handleQty(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (element.hasAttribute(QTY)) {
    		if (qtyAllowed()) {
    			String qtyString = StringUtils.trimToNull(getAttributeValue(element, QTY));
    			Integer qtyInt = null;
    			try {
    				qtyInt = Integer.parseInt(qtyString);
    			} catch (Exception e) {
    				recordError("Qty attribute is not a valid integer: " + qtyString, element, context, result);
    			}
    			codedType.setQty(qtyInt);
    		} else {
        		logValueNotAllowed(QTY, element, context, result);
    		}
    	}
	}

	private void handleOperator(Element element, BareANY codedTypeAny, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		// the operator is specified as defaulting to "I", but let's only allow process the attribute when not a nullFlavor (or if operator has been explicitly provided)
		if (element.hasAttribute("operator") || codedTypeAny.getNullFlavor() == null) {
			SetOperator operator = this.operatorHelper.handleOperator(element, context, result, new ANYImpl<Object>());
			codedType.setOperator(operator);
		}
	}
	
	private void handleSimpleValue(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		String value = null;
		NodeList childNodes = element.getChildNodes();
		int childNodeCount = childNodes.getLength();
		
		Node textNode = null; 
		int numTextNodes = 0;
		for (int i = 0; i < childNodeCount; i++) {
			if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) {
				if (StringUtils.isNotBlank(childNodes.item(i).getNodeValue())) {
					if (textNode == null) {
						textNode = childNodes.item(i);
					}
					numTextNodes++;
				}
			}
		}
		
		if (simpleValueAllowed()) {
			if (textNode != null) {
	            value = textNode.getNodeValue().trim();
			} 
			if (numTextNodes > 1) {
				// too many text nodes
				recordError("Expected " + context.getType() + " to have at most one text node", element, context, result);
			}
		} else {
			if (numTextNodes > 0) {
				logValueNotAllowed("text", element, context, result);
			}
		}
		
		codedType.setSimpleValue(value);
	}

	private void handleOriginalText(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (originalTextAllowed()) {
			List<Element> originalTextElements = getNamedElements("originalText", element);
			if (originalTextElements.size() > 0) {
				if (originalTextElements.size() > 1) {
					recordError("Only one original text element is allowed.", element, context, result);
				}
				ParseContext newContext = ParseContextImpl.create("ED", context);
				BareANY parsedOriginalText = this.edParser.parse(newContext, originalTextElements.get(0), result);
				if (parsedOriginalText != null) {
					codedType.setOriginalText((EncapsulatedData) parsedOriginalText.getBareValue());
				}
			}
    	} else {
    		validateUnallowedChildNode(context.getType(), element, result, "originalText");
    	}
	}

	private void logValueNotAllowed(String propertyName, Element element, ParseContext context, XmlToModelResult result) {
		String message = MessageFormat.format("Relationships of type \"{0}\" are not allowed to have the \"{1}\" property.", context.getType(), propertyName);
		recordError(message, element, context, result);
	}

	private void recordError(String message, Element element, ParseContext context, XmlToModelResult result) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, element));
	}

	private void handleTranslation(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (translationAllowed()) {
			// we have no knowledge of what domain the translation may belong to (I imagine code system could allow for a reverse lookup at some point)
			ParseContext newContext = ParseContextImpl.create("CD", Code.class, context); 
			NodeList translations = element.getElementsByTagName("translation");
			for (int i = 0, length = translations.getLength(); i < length; i++) {
				Element translationElement = (Element) translations.item(i);
				// only want direct child node translations
				if (translationElement.getParentNode().isSameNode(element)) {
					CodedTypeR2<Code> parsedTranslation = parseTranslation(translationElement, newContext, result);
					if (parsedTranslation != null) {
						codedType.getTranslation().add(parsedTranslation);
					}
				}
			}
		} else {
			validateUnallowedChildNode(context.getType(), element, result, "translation");
		}
	}

	protected CodedTypeR2<Code> parseTranslation(Element translationElement, ParseContext newContext, XmlToModelResult result) {
		// leave this up to subclasses to define, if applicable
		return null;
	}

	private void handleValidTime(Element element, CodedTypeR2<Code> codedType, ParseContext context, XmlToModelResult result) {
		if (validTimeAllowed()) {
			List<Element> validTimes = getNamedElements("validTime", element);			
			if (validTimes.size() > 0) {
				if (validTimes.size() > 1) {
					recordError("Only one validTime is allowed", element, context, result);
				}
				Node validTimeNode = validTimes.get(0);
				ParseContext newContext = ParseContextImpl.create("IVL<TS>", HXIT.class, context); 
				BareANY parsedValidTime = this.validTimeParser.parse(newContext, Arrays.asList(validTimeNode), result);
				if (parsedValidTime != null) {
					DateInterval dateInterval = (DateInterval) parsedValidTime.getBareValue();
					codedType.setValidTime(dateInterval == null ? null : dateInterval.getInterval());
				}
			}
		}
	}

	protected boolean codeSystemAllowed() {
		return false;
	}

	protected boolean valueAllowed() {
		return false;
	}

	protected boolean qtyAllowed() {
		return false;
	}

	protected boolean displayNameAllowed() {
		return false;
	}

	protected boolean codeSystemVersionAllowed() {
		return false;
	}

	protected boolean codeSystemNameAllowed() {
		return false;
	}

	protected boolean simpleValueAllowed() {
		return false;
	}

	protected boolean originalTextAllowed() {
		return false;
	}

	protected boolean translationAllowed() {
		return false;
	}

	protected boolean qualifierAllowed() {
		return false;
	}

	protected boolean validTimeAllowed() {
		return false;
	}

}
