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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeRegistry.CodeTypeRegistry;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.util.DomainTypeHelper;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.CdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.CodedTypesConstraintsHandler;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

/**
 * CS - Coded Simple
 *
 * Formats a enum into a CS element. The element looks like this:
 *
 * &lt;element-name code="RECENT"/&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * HL7 implies that variations on this type may use a different name than "code" for
 * the attribute. The use in the controlActProcess is given as an example.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
abstract class AbstractCodePropertyFormatter extends AbstractAttributePropertyFormatter<Code> {

	private static final CdValidationUtils CD_VALIDATION_UTILS = new CdValidationUtils();
	private CodedTypesConstraintsHandler constraintsHandler = new CodedTypesConstraintsHandler();
	
    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) {

    	boolean isAny = false;
    	CD cd = null;
    	if (hl7Value instanceof CD) {
        	cd = (CD) hl7Value;
    	} else {
    		isAny = true; // bypass some validations
    		cd = convertAnyToCd(hl7Value);
    	}
    	
    	StringBuilder result = new StringBuilder();
    	if (cd != null) {

        	handleConstraints(cd.getValue(), context.getConstraints(), context.getPropertyPath(), context.getModelToXmlResult());
    		
    		// don't bother validating if we don't have anything to validate
    		if (cd.hasNullFlavor() || hasValue(cd, context)) {
	    		Hl7Errors errors = context.getModelToXmlResult();
	    		VersionNumber version = context.getVersion();
	    		String type = context.getType();
	    		boolean isCne = context.getCodingStrength() == CodingStrength.CNE;
	    		boolean isCwe = context.getCodingStrength() == CodingStrength.CWE;
	    		
	    		// we can't lookup a code supplied in an ANY datatype as we don't know the domain
	    		// a "reverse" lookup of domain type by code/codesystem could be possible, but difficult to implement to be 100% correct (MB does not track code systems)
	    		if (!isAny) {
		    		if (cd.getValue() != null && cd.getValue().getCodeValue() != null) {
		    			validateCodeExists(cd.getValue(), context.getDomainType(), version, context.getPropertyPath(), errors);
		    		}
	    		}
	    		
	    		String codeAsString = (cd.getValue() != null ? cd.getValue().getCodeValue() : null);
	    		
	    		CD_VALIDATION_UTILS.validateCodedType(cd, codeAsString, isCwe, isCne, false, context.isFixed(), type, version, null, context.getPropertyPath(), errors);
    		}
        	
    		Map<String, String> attributes = new HashMap<String, String>();
    		
    		ConformanceLevel conformanceLevel = context.getConformanceLevel();
    		Cardinality cardinality = context.getCardinality();
    		
			if (cd.hasNullFlavor()) {
    			if (ConformanceLevelUtil.isMandatory(conformanceLevel, cardinality)) {
    				logMandatoryError(context);
    			} else {
    				attributes.putAll(createNullFlavorAttributes(hl7Value.getNullFlavor()));
    			}
    		} else if (!hasValue(cd, context)) {
    			if (conformanceLevel == null || isMandatoryOrPopulated(context)) {
        			if (ConformanceLevelUtil.isMandatory(conformanceLevel, cardinality)) {
        				logMandatoryError(context);
        			} else {
        				attributes.putAll(NULL_FLAVOR_ATTRIBUTES);
        			}
    			}
    		}
    		
    		// Codes can have other attributes in map even if has NullFlavor
    		attributes.putAll(getAttributeNameValuePairs(context, cd.getValue(), hl7Value));
    		
    		boolean hasChildContent = hasChildContent(cd, context);
    		if (hasChildContent || (!attributes.isEmpty() || ConformanceLevelUtil.isMandatory(conformanceLevel, cardinality))) {
    			result.append(createElement(context, attributes, indentLevel, !hasChildContent, !hasChildContent));
    			if (hasChildContent) {
    				createChildContent(cd, result);
	    			result.append("</").append(context.getElementName()).append(">");
	    			result.append(LINE_SEPARATOR);
    			}
    		}
    		
    	}
        return result.toString();
    }

	private void handleConstraints(Code code, ConstrainedDatatype constraints, final String propertyPath, final Hl7Errors errors) {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>(code);
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};

		this.constraintsHandler.handleConstraints(constraints, codedType, logger);
	}
	
	private CD convertAnyToCd(BareANY hl7Value) {
		ANYMetaData anyCd = (ANYMetaData) hl7Value;
		CD cd = new CDImpl();
		if (anyCd != null) {
			if (hl7Value instanceof ANY<?>) {
				@SuppressWarnings("unchecked")
				ANY<Object> anyObj = (ANY<Object>) hl7Value;
				if (anyObj.getValue() instanceof Code) { 
					cd.setValue((Code) anyObj.getValue());
				}
			}
			
			cd.setDataType(hl7Value.getDataType());
			cd.setNullFlavor(hl7Value.getNullFlavor());
			
			cd.setDisplayName(anyCd.getDisplayName());
			cd.setOriginalText(anyCd.getOriginalText());
			cd.getTranslations().addAll(anyCd.getTranslations());
		}
		return cd;
	}

	private void validateCodeExists(Code value, String domainType, VersionNumber version, String propertyPath, Hl7Errors errors) {
		@SuppressWarnings("unchecked")
		Class<Code> returnType = (Class<Code>) DomainTypeHelper.getReturnType(domainType, version, CodeTypeRegistry.getInstance());
		if (returnType == null) {
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Could not locate a registered domain type to match \"" + domainType + "\"", propertyPath));
		} else if (getCode(returnType, value.getCodeValue(), value.getCodeSystem()) == null) {
			errors.addHl7Error(createCodeValueNotFoundError(value, returnType, propertyPath));
		}
	}

	protected Hl7Error createCodeValueNotFoundError(Code value, Class<? extends Code> type, String propertyPath) {
		String message = "The code, \"" + value.getCodeValue() + "\" "
				+ (value.getCodeSystem() == null ? "" : (" (" + value.getCodeSystem() + ") "))
				+ "is not a valid value for domain type \"" 
				+ ClassUtils.getShortClassName(type) + "\"";
		return new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, message, propertyPath);
	}

	private Code getCode(Class<Code> returnType, String codeValue, String codeSystem) {
		CodeResolver resolver = CodeResolverRegistry.getResolver(returnType);
		return StringUtils.isBlank(codeSystem) 
				? resolver.<Code>lookup(returnType, codeValue)
				: resolver.<Code>lookup(returnType, codeValue, codeSystem);
	}
    
	private void logMandatoryError(FormatContext context) {
		String errorMessage = context.getElementName() + " is a mandatory field, but no value is specified";
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, errorMessage, context.getPropertyPath()));
	}

	protected boolean hasChildContent(CD cd, FormatContext context) {
		return hasOriginalText(cd);
	}

	protected void createChildContent(CD cd, StringBuilder result) {
		if (hasOriginalText(cd)) {
			result.append(createElement("originalText", null, 0, false, false));
			result.append(XmlStringEscape.escape(cd.getOriginalText()));
			result.append("</").append("originalText").append(">");
		}
	}
	
    protected boolean hasValue(CD cd, FormatContext context) {
		return cd != null && (cd.getValue() != null || hasChildContent(cd, context));
	}

	private boolean hasOriginalText(CD cd) {
		return !StringUtils.isEmpty(cd.getOriginalText());
	}

    @Override
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Code code, BareANY bareAny) {
        Map<String, String> result = new HashMap<String, String>();
        if (code != null) {
            String value = code.getCodeValue();
            if (StringUtils.isNotBlank(value)) {
                result.put("code", value);
            }
        }
        return result;
    }
    
}
