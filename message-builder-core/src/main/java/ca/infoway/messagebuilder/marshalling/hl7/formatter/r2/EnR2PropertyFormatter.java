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
 * Last modified: $LastChangedDate: 2014-02-14 11:22:06 -0500 (Fri, 14 Feb 2014) $
 * Revision:      $LastChangedRevision: 8399 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import ca.infoway.messagebuilder.datatype.impl.ONImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

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
class EnR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<EntityName> {

    private final OnR2PropertyFormatter onPropertyFormatter = new OnR2PropertyFormatter();
    private final PnR2PropertyFormatter pnPropertyFormatter = new PnR2PropertyFormatter();
    private final TnR2PropertyFormatter tnPropertyFormatter = new TnR2PropertyFormatter();

    @Override
	protected
    String formatNonNullValue(FormatContext context, EntityName value, int indentLevel) {
    	
    	// this code is delegating to the appropriate formatter based on the type of the
    	// object set as the value; specializationType needs to also be set, but we can infer it
    	// (note that this is a bit different from how other formatters treat abstract types)
    	
        if (value == null || value.getClass().isAssignableFrom(TrivialName.class)) {
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
