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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CRImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.CodedTypeR2Helper;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.CodedTypesConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractAttributePropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.EdPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

abstract class AbstractCodedTypeR2PropertyFormatter extends AbstractAttributePropertyFormatter<CodedTypeR2<Code>> {

	private final IvlTsR2PropertyFormatter ivlFormatter = new IvlTsR2PropertyFormatter();
	private final EdPropertyFormatter edFormatter = new EdPropertyFormatter(new TelR2PropertyFormatter(), true);
	private CodedTypesConstraintsHandler constraintsHandler = new CodedTypesConstraintsHandler();
	
    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
    	String result = super.format(context, hl7Value, indentLevel); // also calls formatNonNullDataType, but only if no NullFlavor present
    	
    	// if the supplied value had a null flavor we still need to handle other properties (if present)
    	if (hl7Value != null && hl7Value.hasNullFlavor()) {
    		result = formatNonNullDataType(context, hl7Value, indentLevel);
    	}
    	
    	return result;
    }
    
	@Override
    protected CodedTypeR2<Code> extractBareValue(BareANY hl7Value) {
    	return hl7Value == null ? null : CodedTypeR2Helper.convertCodedTypeR2(hl7Value.getBareValue());
    }

    @Override
    protected String formatNonNullDataType(FormatContext context, BareANY hl7Value, int indentLevel) {
    	CodedTypeR2<Code> codedType = extractBareValue(hl7Value);
    	
    	handleConstraints(codedType, context.getConstraints(), context.getPropertyPath(), context.getModelToXmlResult());
    	
    	StringBuilder result = new StringBuilder();
    	
		Map<String, String> attributes = getAttributeNameValuePairs(context, codedType, hl7Value);
		
		validateChildContent(codedType, context);
		boolean hasChildContent = hasChildContent(codedType, context);
		boolean hasSimpleValue = (simpleValueAllowed() && hasSimpleValue(codedType));
		if (hasChildContent || hasSimpleValue || !attributes.isEmpty()) {
			result.append(createElement(context, attributes, indentLevel, !(hasChildContent || hasSimpleValue), !hasSimpleValue || hasChildContent));
			if (hasChildContent || hasSimpleValue) {
				createChildContent(codedType, context, indentLevel + 1, result);
    			result.append(createElementClosure(context, indentLevel, true));
			}
		}
		
		return result.toString();
    }
    
	private void handleConstraints(CodedTypeR2<Code> codedType, ConstrainedDatatype constraints, final String propertyPath, final Hl7Errors errors) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};

		this.constraintsHandler.handleConstraints(constraints, codedType, logger);
	}
	
	private void validateChildContent(CodedTypeR2<? extends Code> codedType, FormatContext context) {
		if (hasTranslation(codedType) && !translationAllowed()) {
       		logValueNotAllowed("translation", context);
		}
		if (hasQualifier(codedType) && !qualifierAllowed()) {
       		logValueNotAllowed("qualifier", context);
		}
		if (hasOriginalText(codedType) && !originalTextAllowed()) {
       		logValueNotAllowed("originalText", context);
		}
		if (hasSimpleValue(codedType) && !simpleValueAllowed()) {
       		logValueNotAllowed("text", context);
		}
	}

	private boolean hasChildContent(CodedTypeR2<? extends Code> codedType, FormatContext context) {
    	boolean hasChildContent = (originalTextAllowed() && hasOriginalText(codedType));
    	hasChildContent |= (qualifierAllowed() && hasQualifier(codedType));
    	hasChildContent |= (translationAllowed() && hasTranslation(codedType));
    	hasChildContent |= (validTimeAllowed() && hasValidTime(codedType));
		return hasChildContent;
	}

	private void createChildContent(CodedTypeR2<? extends Code> codedType, FormatContext context, int indentLevel, StringBuilder result) {
		handleOriginalText(codedType, indentLevel, result, context);
		handleQualifier(codedType, indentLevel, result, context);
		handleTranslation(codedType, indentLevel, result, context);
		handleValidTime(codedType, indentLevel, result, context);
		handleSimpleValue(codedType, result, context);
	}

	private void handleQualifier(CodedTypeR2<? extends Code> codedType,	int indentLevel, StringBuilder result, FormatContext context) {
		if (hasQualifier(codedType)) {
			if (qualifierAllowed()) {
				FormatContext newContext = new FormatContextImpl("CR", "qualifier", context);
				List<CodeRole> qualifier = codedType.getQualifier();
				for (CodeRole codeRole : qualifier) {
					String formattedQualifier = new CrR2PropertyFormatter().format(newContext, new CRImpl(codeRole), indentLevel);
					result.append(formattedQualifier);
				}
			}
		}
	}

	private void handleTranslation(CodedTypeR2<? extends Code> codedType, int indentLevel, StringBuilder result, FormatContext context) {
		// translation (LIST<CD>)
		if (hasTranslation(codedType)) {
			if (translationAllowed()) {
				FormatContext newContext = new FormatContextImpl("CD", "translation", context);
				for (CodedTypeR2<Code> translation : codedType.getTranslation()) {
					CD_R2<Code> cdAny = new CD_R2Impl<Code>(translation);
					cdAny.setNullFlavor(translation.getNullFlavorForTranslationOnly());
					String transationString = createTranslation(translation, cdAny, indentLevel, newContext);
					result.append(transationString);
				}
			}
		}
	}

	protected String createTranslation(CodedTypeR2<Code> translation, CD_R2<Code> cdAny, int indentLevel, FormatContext newContext) {
		// subclasses must implement as required 
		return "";
	}

	private void handleValidTime(CodedTypeR2<? extends Code> codedType, int indentLevel, StringBuilder result, FormatContext context) {
		if (hasValidTime(codedType)) {
			if (validTimeAllowed()) {
				FormatContext newContext = new FormatContextImpl("IVL<TS>", "validTime", context);
				Interval<Date> validTime = codedType.getValidTime();
				IVL_TS ivlTs = new IVL_TSImpl(validTime == null ? null : new DateInterval(validTime)); 
				String formattedValidTime = this.ivlFormatter.format(newContext, ivlTs, indentLevel);
				result.append(formattedValidTime);
			}
		}
	}

	private void handleSimpleValue(CodedTypeR2<? extends Code> codedType, StringBuilder result, FormatContext context) {
		// simpleValue (String)
		if (hasSimpleValue(codedType)) {
			if (simpleValueAllowed()) {
				result.append(XmlStringEscape.escape(codedType.getSimpleValue()));
			}
		}
	}

	private void handleOriginalText(CodedTypeR2<? extends Code> codedType, int indentLevel, StringBuilder result, FormatContext context) {
		if (hasOriginalText(codedType)) {
			if (originalTextAllowed()) {
				EncapsulatedData originalText = codedType.getOriginalText();
				EDImpl<EncapsulatedData> edAny = new EDImpl<EncapsulatedData>(originalText);
				FormatContext newContext = new FormatContextImpl("ED", "originalText", context);
				String formattedOriginalText = this.edFormatter.format(newContext, edAny, indentLevel);
				if (StringUtils.isNotBlank(formattedOriginalText)) {
					result.append(formattedOriginalText);
				}
			}
		}
	}

	@Override
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, CodedTypeR2<Code> codedType, BareANY bareAny) {
        Map<String, String> result = new HashMap<String, String>();
        
        handleNullFlavor(codedType, result, bareAny, context);
        handleCodeValue(codedType, result, context);
        handleCodeSystem(codedType, result, context);
        handleCodeSystemName(codedType, result, context);
        handleCodeSystemVersion(codedType, result, context);
        handleDisplayName(codedType, result, context);
        handleOperator(codedType, result, context);
        handleValue(codedType, result, context);
        handleQty(codedType, result, context);

        return result;
    }

	private void handleQty(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasQty(codedType)) {
        	if (qtyAllowed()) {
                result.put("qty", codedType.getQty().toString());
        	} else {
        		logValueNotAllowed("qty", context);
        	}
        }
	}

	private void handleValue(CodedTypeR2<? extends Code> codedType,	Map<String, String> result, FormatContext context) {
		if (hasValue(codedType)) {
        	if (valueAllowed()) {
                result.put("value", codedType.getValue().toString());
        	} else {
        		logValueNotAllowed("value", context);
        	}
        }
	}

	private void handleOperator(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasOperator(codedType)) {
        	if (operatorAllowed()) {
                result.put("operator", codedType.getOperator().getCodeValue());
        	} else {
        		logValueNotAllowed("operator", context);
        	}
        }
	}

	protected void handleDisplayName(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasDisplayName(codedType)) {
        	if (displayNameAllowed()) {
                result.put("displayName", codedType.getDisplayName());
        	} else {
        		logValueNotAllowed("displayName", context);
        	}
        }
	}

	private void handleCodeSystemVersion(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasCodeSystemVersion(codedType)) {
        	if (codeSystemVersionAllowed()) {
                result.put("codeSystemVersion", codedType.getCodeSystemVersion());
        	} else {
        		logValueNotAllowed("codeSystemVersion", context);
        	}
        }
	}

	protected void handleCodeSystemName(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasCodeSystemName(codedType)) {
        	if (codeSystemNameAllowed()) {
                result.put("codeSystemName", codedType.getCodeSystemName());
        	} else {
        		logValueNotAllowed("codeSystemName", context);
        	}
        }
	}

	protected void handleCodeSystem(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		// FIXME - TM - CDA - validate as uid (?)
		if (hasCodeSystem(codedType)) {
        	if (codeSystemAllowed()) {
                result.put("codeSystem", codedType.getCodeSystem());
        	} else {
        		logValueNotAllowed("codeSystem", context);
        	}
        }
	}

	private void handleCodeValue(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		if (hasCodeValue(codedType)) {
        	if (codeValueAllowed()) {
                result.put("code", codedType.getCodeValue());
        	} else {
        		logValueNotAllowed("code", context);
        	}
        }
	}

	private void handleNullFlavor(CodedTypeR2<? extends Code> codedType, Map<String, String> result, BareANY bareAny, FormatContext context) {
		if (bareAny != null && bareAny.hasNullFlavor()) {
			result.putAll(createNullFlavorAttributes(bareAny.getNullFlavor()));
        } else if (codedType == null) {
    		ConformanceLevel conformanceLevel = context.getConformanceLevel();
    		Cardinality cardinality = context.getCardinality();
			if (conformanceLevel == null || ConformanceLevelUtil.isPopulated(conformanceLevel, cardinality)) {
   				result.putAll(NULL_FLAVOR_ATTRIBUTES);
			}
        }
	}
    
	private void logValueNotAllowed(String propertyName, FormatContext context) {
		String message = MessageFormat.format("Relationships of type \"{0}\" are not allowed to have the \"{1}\" property.", context.getType(), propertyName);
		recordError(message, context);
	}

	private void recordError(String message, FormatContext context) {
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, context.getPropertyPath()));
	}

	private boolean hasOriginalText(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && codedType.getOriginalText() != null;
	}

	private boolean hasQualifier(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && !codedType.getQualifier().isEmpty();
	}

	private boolean hasTranslation(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && !codedType.getTranslation().isEmpty();
	}

	private boolean hasValidTime(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && codedType.getValidTime() != null;
	}

    private boolean hasSimpleValue(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getSimpleValue());
	}

	private boolean hasCodeValue(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getCodeValue());
	}

	private boolean hasCodeSystem(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getCodeSystem());
	}
	
	private boolean hasCodeSystemName(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getCodeSystemName());
	}
	
	private boolean hasCodeSystemVersion(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getCodeSystemVersion());
	}
	
	private boolean hasDisplayName(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && StringUtils.isNotBlank(codedType.getDisplayName());
	}
	
	private boolean hasOperator(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && codedType.getOperator() != null && StringUtils.isNotBlank(codedType.getOperator().getCodeValue());
	}

	private boolean hasValue(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && codedType.getValue() != null;
	}
	
	private boolean hasQty(CodedTypeR2<? extends Code> codedType) {
		return codedType != null && codedType.getQty() != null;
	}


	// subclasses can override these methods to specify what properties they do and don't allow

	protected boolean originalTextAllowed() {
		return false;
	}
	protected boolean qualifierAllowed() {
		return false;
	}
	protected boolean translationAllowed() {
		return false;
	}
	protected boolean validTimeAllowed() {
		return false;
	}
	protected boolean simpleValueAllowed() {
		return false;
	}
	protected boolean codeValueAllowed() {
		return false;
	}
	protected boolean codeSystemAllowed() {
		return false;
	}
	protected boolean codeSystemNameAllowed() {
		return false;
	}
	protected boolean codeSystemVersionAllowed() {
		return false;
	}
	protected boolean displayNameAllowed() {
		return false;
	}
	protected boolean operatorAllowed() {
		return false;
	}
	protected boolean valueAllowed() {
		return false;
	}
	protected boolean qtyAllowed() {
		return false;
	}
}
