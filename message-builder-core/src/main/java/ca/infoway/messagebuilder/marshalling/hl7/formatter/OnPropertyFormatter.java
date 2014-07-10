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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * ON - OrganizationName
 *
 * Represents an ON object as an element:
 *
 * &lt;element-name&gt;&lt;prefix&gt;prefix&lt;/prefix&gt;Intelliware Development&lt;delimiter&gt;,&lt;/delimiter&gt;&lt;suffix&gt;Inc.&lt;/suffix&gt;&lt;/element-name&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ON
 */
@DataTypeHandler("ON")
class OnPropertyFormatter extends AbstractEntityNamePropertyFormatter<OrganizationName> {
}
