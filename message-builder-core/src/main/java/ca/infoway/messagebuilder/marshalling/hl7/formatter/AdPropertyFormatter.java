/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * AD - Address
 *
 * Represents an Address object as an element:
 *
 * &lt;addr use='WP'&gt;
 *    &lt;houseNumber&gt;1050&lt;/houseNumber&gt;
 *    &lt;direction&gt;W&lt;/direction&gt;
 *    &lt;streetName&gt;Wishard Blvd&lt;/streetName&gt;,
 *    &lt;additionalLocator&gt;RG 5th floor&lt;/additionalLocator&gt;,
 *    &lt;city&gt;Indianapolis&lt;/city&gt;, &lt;state&gt;IN&lt;/state&gt;
 *    &lt;postalCode&gt;46240&lt;/postalCode&gt;
 * &lt;/addr&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 */
@DataTypeHandler("AD")
class AdPropertyFormatter extends AbstractAdPropertyFormatter {
}
