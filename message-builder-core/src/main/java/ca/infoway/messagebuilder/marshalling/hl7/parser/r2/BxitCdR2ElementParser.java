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

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BXITImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.marshalling.CodedTypeR2Helper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;

/**
 * BXIT<CD> (R2)
 */
@DataTypeHandler("BXIT<CD>")
class BxitCdR2ElementParser extends CdR2ElementParser {
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new BXITImpl<CodedTypeR2<Code>>();
	}
	
	@Override
	protected BareANY doCreateR2DataTypeInstance(ParseContext context) {
		return CodedTypeR2Helper.createBXITInstance(context.getExpectedReturnType());
	}
	
	@Override
	protected boolean qtyAllowed() {
		return true;
	}
	
}
