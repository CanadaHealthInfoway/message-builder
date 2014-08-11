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
 * Last modified: $LastChangedDate: 2013-12-24 10:07:49 -0500 (Tue, 24 Dec 2013) $
 * Revision:      $LastChangedRevision: 8256 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * PN (R2) - Personal Name
 * 
 * Parses a PN element into a PersonName. The element looks like this:
 * 
 * <element-name use="L">
 *   <prefix>Mr.</prefix>
 *   <given>John</given>
 *   <given>Jimmy</given>
 *   <family>Smith</family>
 *   <suffix>Sr.</suffix>
 * </element-name>
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PN
 *
 */
@DataTypeHandler("PN")
class PnR2ElementParser extends AbstractNameR2ElementParser<PersonName> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PNImpl();
	}

	@Override
	protected PersonName createEntityName() {
		return new PersonName();
	}

}
