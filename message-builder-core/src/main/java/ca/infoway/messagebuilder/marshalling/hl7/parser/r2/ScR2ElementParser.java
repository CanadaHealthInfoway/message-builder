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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.SC_R2Impl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * SC (R2)
 */
@DataTypeHandler("SC")
class ScR2ElementParser extends CsR2ElementParser {
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new SC_R2Impl();
	}
	
	@Override
	protected boolean codeSystemAllowed() {
		return true;
	}
	
	@Override
	protected boolean codeSystemNameAllowed() {
		return true;
	}
	
	@Override
	protected boolean codeSystemVersionAllowed() {
		return true;
	}
	
	@Override
	protected boolean displayNameAllowed() {
		return true;
	}
	
	@Override
	protected boolean simpleValueAllowed() {
		return true;
	}
	
}
