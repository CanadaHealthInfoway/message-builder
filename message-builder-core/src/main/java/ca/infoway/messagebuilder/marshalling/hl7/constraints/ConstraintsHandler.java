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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.constraints;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class ConstraintsHandler {

	public ConstraintsHandler() {
	}
	
	public String validateConstraint(String name, String value, boolean isCDA, ConstrainedDatatype constraints, ErrorLogger errorLogger) {
		
		if (!isCDA || constraints == null) {
			// only checking constraints for CDA (non-CDA should not even have constraints)
			return value;
		}
		
		String newValue = value;

		// check fixed constraint
		Relationship constrainedRelationship = obtainConstraint(name, constraints);
		String fixedConstraint = obtainFixedValue(constrainedRelationship);
		boolean hasFixedConstraint = StringUtils.isNotBlank(fixedConstraint);
		if (hasFixedConstraint && !StringUtils.equals(value, fixedConstraint)) {
			if (StringUtils.isBlank(value)) {
				// this is an acceptable case; send back the fixed value to use instead
				newValue = fixedConstraint;
			} else {
				// leave the value as is, but log an error
				logFixedConstraintError(name, value, fixedConstraint, constraints.getBaseType(), errorLogger);
			}
		}
		
		// check cardinality constraint (but only if there wasn't a fixed value constraint) 
		boolean isMandatory = obtainMandatory(constrainedRelationship);
		if (isMandatory && !hasFixedConstraint && StringUtils.isBlank(value)) {
			logMandatoryConstraintError(name, constraints.getBaseType(), errorLogger);
		}
		
		boolean isProhibited = obtainProhibited(constrainedRelationship);
		if (isProhibited && StringUtils.isNotBlank(value)) {
			logProhibitedConstraintError(name, constraints.getBaseType(), errorLogger);
		}
		
		return newValue;
	}

	private void logMandatoryConstraintError(String name, String type, ErrorLogger errorLogger) {
		String message = MessageFormat.format("Property {0} of type {1} is constrained to be mandatory but no value was provided", name, type);
		errorLogger.logError(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, Hl7ErrorLevel.ERROR, message);
	}

	private void logFixedConstraintError(String name, String value, String fixedConstraint, String type, ErrorLogger errorLogger) {
		String message = MessageFormat.format("Property {0} of type {1} is constrained to a fixed value of {2} but was {3}", name, type, fixedConstraint, value);
		errorLogger.logError(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, Hl7ErrorLevel.ERROR, message);
	}

	private void logProhibitedConstraintError(String name, String type, ErrorLogger errorLogger) {
		String message = MessageFormat.format("Property {0} of type {1} is constrained to be prohibited but a value was provided", name, type);
		errorLogger.logError(Hl7ErrorCode.CDA_PROHIBITED_CONSTRAINT, Hl7ErrorLevel.ERROR, message);
	}

	private boolean obtainMandatory(Relationship constrainedRelationship) {
		if (constrainedRelationship != null) {
			Cardinality cardinality = constrainedRelationship.getCardinality();
			return cardinality != null && cardinality.isMandatory(); 
		}
		return false;
	}

	private boolean obtainProhibited(Relationship constrainedRelationship) {
		if (constrainedRelationship != null) {
			Cardinality cardinality = constrainedRelationship.getCardinality();
			return cardinality != null && cardinality.getMax() == 0; 
		}
		return false;
	}

	private String obtainFixedValue(Relationship constrainedRelationship) {
		if (constrainedRelationship != null ) {
			return constrainedRelationship.getFixedValue();
		}
		return null;
	}

	private Relationship obtainConstraint(String name, ConstrainedDatatype constraints) {
		Relationship result = null;
		if (constraints != null) {
			result = constraints.getRelationship(name);
		}
		return result;
	}
	
	
	
}
