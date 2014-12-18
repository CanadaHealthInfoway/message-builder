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

import java.util.Map;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

public class SxcmR2PropertyFormatterHelper {

	public void handleOperator(Map<String, String> attributes, FormatContext context, ANYMetaData wrapper) {
		String type = context == null ? null : context.getType();
		boolean isSxcm = (type != null && type.startsWith("SXCM<"));
		boolean hasOperator = wrapper != null && wrapper.getOperator() != null;
		
		if (hasOperator) {
			if (isSxcm) {
				attributes.put("operator", wrapper.getOperator().getCodeValue());
			} else {
				context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Operator property not applicable for type: " + type, context.getPropertyPath()));
			}
		}
	}
	
}
