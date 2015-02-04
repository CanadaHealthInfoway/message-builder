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
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class CodedTypesConstraintsHandler {

	private final ConstraintsHandler constraintsHandler = new ConstraintsHandler();
	private final TrivialCodeResolver trivialCodeResolver = new TrivialCodeResolver();

	public CodedTypesConstraintsHandler() {
	}

	// only the following constraints are being handled for now:
	//	qualifier (mandatory)
	//	qualifier.name (mandatory)
	//	qualifier.name.code (mandatory, fixed)
	//	qualifier.name.codeSystem (mandatory, fixed)
	//	qualifier.value (mandatory)
	//	codeSystem (mandatory, fixed)
	public void handleConstraints(ConstrainedDatatype constraints, CodedTypeR2<Code> codedType, ErrorLogger logger) {
		
		if (codedType == null || constraints == null) {
			return;
		}
		
		List<CodeRole> qualifiers = codedType.getQualifier(); 
		int numberOfQualifiers = qualifiers.size();
		
		// check if qualifier fits into constrained number of items (1, 0-1)
		this.constraintsHandler.validateConstraint("qualifier", qualifiers.isEmpty() ? null : "qualifiers", constraints, logger);  // just checks if any qualifiers provided
		if (numberOfQualifiers == 1) {
			// if only one qualifier present, check other qualifier constraints
			CodeRole qualifier = qualifiers.get(0);
			
			CodedTypeR2<Code> qualifierName = qualifier.getName();
			this.constraintsHandler.validateConstraint("qualifier.name", qualifierName == null ? null : "qualifierName", constraints, logger);  // just checks if name provided
			if (qualifierName != null) {
				String nameCode = qualifierName.getCodeValue();
				String newNameCode = this.constraintsHandler.validateConstraint("qualifier.name.code", nameCode, constraints, logger);
				String nameCodeSystem = qualifierName.getCodeSystem();
				String newNameCodeSystem = this.constraintsHandler.validateConstraint("qualifier.name.codeSystem", nameCodeSystem, constraints, logger);
				if (!StringUtils.equals(nameCode, newNameCode) || !StringUtils.equals(nameCodeSystem, newNameCodeSystem)) {
					Code newName = this.trivialCodeResolver.lookup(Code.class, newNameCode, newNameCodeSystem);
					qualifierName.setCode(newName);
				}
			}
			
			CodedTypeR2<Code> qualifierValue = qualifier.getValue();
			this.constraintsHandler.validateConstraint("qualifier.value", qualifierValue == null ? null : "qualifierValue", constraints, logger);  // just checks if value provided
		} else if (numberOfQualifiers > 1) {
			 // (qualifier can be constrained to at most 1 and to exactly 1)
			Relationship qualifierConstraint = constraints.getRelationship("qualifier");
			if (qualifierConstraint != null) {
				Cardinality qualifierConstraintCardinality = qualifierConstraint.getCardinality();
				if (qualifierConstraintCardinality != null && !qualifierConstraintCardinality.contains(numberOfQualifiers)) {
					String message = MessageFormat.format("Property {0} of type {1} is constrained to a cardinality of {2} but contains {3} values",
							"qualifier", constraints.getBaseType(), qualifierConstraintCardinality, numberOfQualifiers);
					logger.logError(Hl7ErrorCode.CDA_CARDINALITY_CONSTRAINT, ErrorLevel.ERROR, message);
				}
			}
		}
		
		String codeSystem = codedType.getCodeSystem();
		codeSystem = StringUtils.isBlank(codeSystem) ? "not provided" : codeSystem;
		String newCodedSystem = this.constraintsHandler.validateConstraint("codeSystem", codeSystem, constraints, logger);
		if (!StringUtils.equals(codeSystem, newCodedSystem)) {
			// String codeValue = codedType.getCodeValue();
			// we have the current code value and new codeSystem, but to create a new value we need the actual code class for the codedType
			// need domain passed in... (see CodeLookupUtils/MessageBeanRegistry)
			// TODO CDA - TM - create new code - this may not be feasible; for now, log a missing constraint error (forced via replacing a missing codeSystem with "not provided")
		}
	}
}
