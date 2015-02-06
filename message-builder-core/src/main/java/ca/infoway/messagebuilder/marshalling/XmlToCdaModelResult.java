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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.TransformError;
import ca.infoway.messagebuilder.error.TransformErrors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class XmlToCdaModelResult  implements TransformErrors {
	private XmlToModelResult delegate;
	List<TransformError> errors = new ArrayList<TransformError>();
	
	XmlToCdaModelResult(XmlToModelResult result) {
		this.delegate = result;
		for (Hl7Error error : result.getHl7Errors()) {
			errors.add(new TransformError(error));
		}
	}

	public Object getClinicalDocumentObject() {
		return this.delegate.getMessageObject();
	}
	
	public boolean isValid() {
		return this.delegate.isValid();
	}
	
	public List<TransformError> getErrors() {
		return this.errors;
	}
}
