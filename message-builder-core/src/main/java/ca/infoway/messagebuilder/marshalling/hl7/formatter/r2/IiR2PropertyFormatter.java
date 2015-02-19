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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractAttributePropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * II - Installer Identifier
 * 
 * II has two attributes: root, extension
 *
 * CeRx standards claim that both attributes are required, although extension 
 * is sometimes unused. 
 * 
 * The HL7 standard also defines the assigningAuthorityName attribute, but that
 * has been left out of the CeRx implementation.
 * 
 * According to CeRx: Root has a limit of 100 characters, extension of 20 
 * characters. These limits are not currently enforced by this class. 
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
 */
@DataTypeHandler("II")
class IiR2PropertyFormatter extends AbstractAttributePropertyFormatter<Identifier> {

	private static final IiValidationUtils iiValidationUtils = new IiValidationUtils();
	private final IiConstraintsHandler constraintsHandler = new IiConstraintsHandler();
	
    @Override
    protected Map<String,String> getAttributeNameValuePairs(FormatContext context, Identifier ii, BareANY bareAny) {
        VersionNumber version = context.getVersion();

        Map<String, String> result = new HashMap<String, String>();
        
    	String typeFromContext = context.getType();
    	ii = validate(ii, typeFromContext, version, context);
    	addStandardAttributes(ii, result);
        
        return result;
    }

	private Identifier validate(Identifier identifier, String type, VersionNumber version, FormatContext context) {
		
		// must have root or NF, not both (if has NF, will follow different path)
		// extension/assigningAuthorityName/displayable are optional
		// according to R2 schema, "root" is a "uid" and must be one of oid/uuid/ruid
		// 	 oid: "[0-2](\.(0|[1-9][0-9]*))*"
		//   uuid: "[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}"
		//   ruid: "[A-Za-z][A-Za-z0-9\-]*"
		
		handleConstraints(identifier, context);
    	validateRoot(identifier, type, context);
    	return identifier;
	}

	private void handleConstraints(Identifier identifier, final FormatContext context) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				Hl7Errors errors = context.getModelToXmlResult();
				String propertyPath = context.getPropertyPath();
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
		
		this.constraintsHandler.handleConstraints(context.getConstraints(), identifier, logger, isSingleCardinality(context.getCardinality()));
	}

	private boolean isSingleCardinality(Cardinality cardinality) {
		return cardinality == null ? true : cardinality.isSingle();
	}

	private void validateRoot(Identifier ii, String type, FormatContext context) {
		String root = ii.getRoot();
		if (validateMandatoryAttribute("root", root, type, context)) {
			// validate root is one of oid/uuid/ruid; this will likely be constrained to a specific type in some cases
			if (!(iiValidationUtils.isOid(root, true) || iiValidationUtils.isUuid(root) || iiValidationUtils.isRuid(root))) {
				recordError(iiValidationUtils.getRootMustBeUuidRuidOidErrorMessage(root), context);
			}
		}
	}

	private void addStandardAttributes(Identifier ii, Map<String, String> result) {
		result.put("root", ii.getRoot() == null ? StringUtils.EMPTY : ii.getRoot());

    	if (StringUtils.isNotBlank(ii.getExtension())) {
    		result.put("extension", ii.getExtension());
    	}
    	
    	if (StringUtils.isNotBlank(ii.getAssigningAuthorityName())) {
    		result.put("assigningAuthorityName", ii.getAssigningAuthorityName());
    	}
    	
    	if (StringUtils.isNotBlank(ii.getDisplayable())) {
    		result.put("displayable", ii.getDisplayable());
    	}
	}

	private void recordError(String message, FormatContext context) {
		String propertyPath = context.getPropertyPath();
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, propertyPath));
	}

	private boolean validateMandatoryAttribute(String attributeName, String attributeValue, String type, FormatContext context) {
		if (StringUtils.isBlank(attributeValue)) {
			recordError("Attribute \"" + attributeName + "\" must be specified for " + type, context);
			return false; 
		}
		return true;
	}

}
