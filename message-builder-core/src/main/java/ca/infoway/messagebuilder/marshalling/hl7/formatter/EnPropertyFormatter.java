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

import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * EN - EntityName
 *
 * Represents an EN object as an element:
 *
 * &lt;element-name&gt;This is a trivial name&lt;/element-name&gt;
 *
 * This class makes a decision on which formatter to use based on the actual type of the object.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-EN
 */
@DataTypeHandler("EN")
class EnPropertyFormatter extends AbstractEntityNamePropertyFormatter<EntityName> {

    private final OnPropertyFormatter onPropertyFormatter = new OnPropertyFormatter();
    private final PnPropertyFormatter pnPropertyFormatter = new PnPropertyFormatter();
    private final TnPropertyFormatter tnPropertyFormatter = new TnPropertyFormatter();

    @Override
	protected String formatNonNullValue(FormatContext context, EntityName value, int indentLevel) {
    	
    	// this code is delegating to the appropriate formatter based on the type of the
    	// object set as the value; specializationType needs to also be set, but we can infer it
    	// (note that this is a bit different from how other formatters treat abstract types)
    	
        if (value == null || value.getClass().isAssignableFrom(EntityName.class)) {
            return super.formatNonNullValue(context, value, indentLevel);

        } else if (value.getClass().isAssignableFrom(TrivialName.class)) {
        	context = new FormatContextImpl("TN", true, context);
            return this.tnPropertyFormatter.format(context, new TNImpl((TrivialName) value), indentLevel);

        } else if (value.getClass().isAssignableFrom(PersonName.class)){
        	context = new FormatContextImpl("PN", true, context);
            return this.pnPropertyFormatter.format(context, new PNImpl((PersonName) value), indentLevel);

        } else if (value.getClass().isAssignableFrom(OrganizationName.class)){
        	context = new FormatContextImpl("ON", true, context);
            return this.onPropertyFormatter.format(context, new ONImpl((OrganizationName) value), indentLevel);

        } else {
            throw new IllegalArgumentException("EN can not handle values of type " + value.getClass());
        }
    }
}
