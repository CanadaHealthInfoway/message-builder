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
 * Last modified: $LastChangedDate: 2013-05-15 19:39:56 -0300 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */

package ca.infoway.messagebuilder.marshalling.hl7;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class CodedStringValidationUtils {

	public void validateCodedString(CodedString<? extends Code> codedString, boolean codeProvided, boolean codeSystemProvided, Element element, String propertyPath, Hl7Errors errors) {

		// must have string
		if (StringUtils.isBlank(codedString.getValue())) {
			createError("SC datatypes must have a string value", element, propertyPath, errors);
		}
		
		// if provide code or code system, must provide other
		if (codeProvided != codeSystemProvided) {
			createError("For SC datatypes, if code or code system is provided then the other value must also be provided", element, propertyPath, errors);
		}
		
		// if provide codeSystemName or codeSystemVersion, must provide code
		if ((!codeProvided && !codeSystemProvided) && StringUtils.isNotBlank(codedString.getCodeSystemName())) {
			createError("For SC datatypes, can only provide a code system name if a code is also provided", element, propertyPath, errors);
		}
		if ((!codeProvided && !codeSystemProvided) && StringUtils.isNotBlank(codedString.getCodeSystemVersion())) {
			createError("For SC datatypes, can only provide a code system version if a code is also provided", element, propertyPath, errors);
		}
		
		// displayName - requires code?? assume no (for now)
	}
	
	private void createError(String errorMessage, Element element, String propertyPath, Hl7Errors errors) {
		Hl7Error error = null;
		if (element != null) {
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage + 	" (" + XmlDescriber.describeSingleElement(element) + ")", 
					element);		
		} else { // assuming this has a property path
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage, 
					propertyPath);		
		}
		
		errors.addHl7Error(error);
	}
	
}
