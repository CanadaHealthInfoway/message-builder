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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.xml.Hl7TypeName;
import ca.infoway.messagebuilder.xml.MessageSet;

public class CdaMessageSetValidator extends MessageSetValidator {

	public CdaMessageSetValidator(MessageSet messageSet) {
		super(messageSet);
	}

	@Override
	protected boolean isTypeValid(String type) {
		boolean result;
		result = isTypeValid(StandardDataType.getByTypeName(type));
		
		if (result && isCollection(type)) {
			// also check the parameter type
			Hl7TypeName typeName = Hl7TypeName.parse(type);
			result = isTypeValid(StandardDataType.getByTypeName(typeName.getParameters().get(0).toString()));
		}
		return result;
	}

	private boolean isTypeValid(StandardDataType type) {
		boolean result = false;
		if (type != null) {
			result = isTypeValidForRelease(type);
		}
		return result;
	}

	private boolean isTypeValidForRelease(StandardDataType type) {
		boolean result;
		if (this.messageSet.isGeneratedAsR2()) {
			result = type.isValidForR2();
		} else {
			result = type.isValidForPCS();
		}
		return result;
	}
}
