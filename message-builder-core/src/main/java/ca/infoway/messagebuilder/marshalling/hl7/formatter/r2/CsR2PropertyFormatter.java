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
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;


import java.util.Map;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * CS - Coded Simple (R2 datatype variant)
 */
@DataTypeHandler("CS")
class CsR2PropertyFormatter extends AbstractCodedTypeR2PropertyFormatter {

	@Override
	protected boolean codeValueAllowed() {
		return true;
	}
	
	@Override
	protected boolean codeSystemAllowed() {
		// Technically, CS does not allow for a codeSystem. However, we don't want to log an error just because a Code also has a CodeSystem with it (most common case)  
		return true;
	}
	
	@Override
	protected void handleCodeSystem(CodedTypeR2<? extends Code> codedType, Map<String, String> result, FormatContext context) {
		// codes will usually have a codeSystem even if we don't intend to render it in the message
		if (!"CS".equals(context.getType())) {
			super.handleCodeSystem(codedType, result, context);
		}
	}
	
}
