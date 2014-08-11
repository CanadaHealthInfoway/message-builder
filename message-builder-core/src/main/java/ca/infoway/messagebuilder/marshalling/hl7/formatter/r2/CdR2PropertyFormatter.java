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


import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * CD - Coded Descriptor (R2 datatype variant)
 */
@DataTypeHandler("CD")
class CdR2PropertyFormatter extends CeR2PropertyFormatter {

	protected String createTranslation(CodedTypeR2<Code> translation, int indentLevel, FormatContext newContext) {
		return this.format(newContext, new CD_R2Impl(translation), indentLevel);
	}

	@Override
	protected boolean qualifierAllowed() {
		return true;
	}
	
}
