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

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * ON (R2) - OrganizationName
 * 
 * Parses an ON element into a OrganizationName. The element looks like this:
 * 
 * <element-name><prefix>prefix</prefix>Intelliware Development<delimiter>,</delimiter><suffix>Inc.</suffix></element-name>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ON
 */
@DataTypeHandler("ON")
class OnR2ElementParser extends AbstractNameR2ElementParser<OrganizationName> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ONImpl();
	}

	@Override
	protected OrganizationName createEntityName() {
		return new OrganizationName();
	}
    
}
