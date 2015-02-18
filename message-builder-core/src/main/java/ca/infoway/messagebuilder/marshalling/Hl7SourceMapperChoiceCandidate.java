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

package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;

class Hl7SourceMapperChoiceCandidate {

		private final Object parsedBean;
		private final List<Hl7Error> storedErrors = new ArrayList<Hl7Error>();

		Hl7SourceMapperChoiceCandidate(Object parsedBean) {
			this.parsedBean = parsedBean;
		}

		Object getParsedBean() {
			return this.parsedBean;
		}

		List<Hl7Error> getStoredErrors() {
			return this.storedErrors;
		}
		
		void addError(Hl7Error error) {
			this.storedErrors.add(error);
		}

		boolean isAcceptableChoiceCandidate(int currentErrorLevel) {
			// to be acceptable can't have any templateId errors in the first two levels past choice
			// to be acceptable can't have any missing mandatory associations in the first level past choice
			for (Hl7Error hl7Error : this.storedErrors) {
				if (hl7Error.getErrorDepth() - currentErrorLevel == 0) {  // a "missing" error actually appears to be one level higher (we never get to the missing node)
					if (hl7Error.getHl7ErrorCode() == Hl7ErrorCode.MANDATORY_ASSOCIATION_NOT_PROVIDED) {
						return false;
					}
				}
				if (hl7Error.getErrorDepth() - currentErrorLevel == 1) {
					if (hl7Error.getHl7ErrorCode() == Hl7ErrorCode.NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY) {
						return false;
					}
				}
				if (hl7Error.getErrorDepth() - currentErrorLevel <= 2) {
					if (hl7Error.getHl7ErrorCode() == Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING) {
						return false;
					}
				}
			}
			return true;
		}
		
		boolean hasTemplateIdMatch(int currentErrorLevel) {
			// to be a match must have correct template id fixed constraint within the first two levels past choice
			for (Hl7Error hl7Error : this.storedErrors) {
				if (hl7Error.getErrorDepth() - currentErrorLevel <= 2) {
					if (hl7Error.getHl7ErrorCode() == Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH) {
						return true;
					}
				}
			}
			return false;
		}
		
}
