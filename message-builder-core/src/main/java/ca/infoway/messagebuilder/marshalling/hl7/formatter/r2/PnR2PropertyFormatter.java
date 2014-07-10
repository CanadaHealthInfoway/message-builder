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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.PnValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * PN - PersonalName
 *
 * Represents a PN object as an element:
 *
 * &lt;element-name&gt;
 *  &lt;given&gt;Adam&lt;/given&gt;
 *  &lt;given&gt;A.&lt;/given&gt;
 *  &lt;family&gt;Everyman&lt;/family&gt;
 * &lt;/element-name&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PN
 */
@DataTypeHandler({"PN", "PN.FULL", "PN.BASIC", "PN.SEARCH"})
class PnR2PropertyFormatter extends AbstractEntityNameR2PropertyFormatter<PersonName> {
	
    private static final PnValidationUtils PN_VALIDATION_UTILS = new PnValidationUtils();

    @Override
    protected void validateName(PersonName value, FormatContext context) {
		PN_VALIDATION_UTILS.validatePersonName(value, context.getType(), context.getVersion().getBaseVersion(), null, context.getPropertyPath(), context.getModelToXmlResult());
    }
}
