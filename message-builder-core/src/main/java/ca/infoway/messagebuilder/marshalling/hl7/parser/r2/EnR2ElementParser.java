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
 * Last modified: $LastChangedDate: 2014-02-26 13:53:15 -0500 (Wed, 26 Feb 2014) $
 * Revision:      $LastChangedRevision: 8415 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * EN - EntityName
 * 
 * Parses an EN element into a EntityName. The element looks like this:
 * 
 * <element-name>This is a trivial name</element-name>
 * 
 * This class makes a decision on which parser to use based on the format of the
 * XML.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-EN
 */
@DataTypeHandler("EN")
class EnR2ElementParser extends AbstractNameR2ElementParser<EntityName> {

	@Override
	protected EntityName createEntityName() {
		return new EntityName();
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ENImpl<EntityName>();
	}

}
