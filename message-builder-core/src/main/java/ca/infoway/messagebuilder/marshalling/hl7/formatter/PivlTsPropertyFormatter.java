/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("PIVL<TS>")
class PivlTsPropertyFormatter extends AbstractPivlPropertyFormatter {

	// combine this with super class? the double call of getAttributes will cause duplicate errors to be logged 
	
	@Override
	protected String format(DateDiff period, FormatContext context) throws ModelToXmlTransformationException {
		Map<String, String> attributes = getAttributes(period, context);
		return attributes.get(PqPropertyFormatter.ATTRIBUTE_VALUE);
	}

	@Override
	protected String getUnits(DateDiff period, FormatContext context) throws ModelToXmlTransformationException {
		Map<String, String> attributes = getAttributes(period, context);
		return attributes.get(PqPropertyFormatter.ATTRIBUTE_UNIT);
	}

	private Map<String, String> getAttributes(DateDiff period, FormatContext context) throws ModelToXmlTransformationException {
		PhysicalQuantity quantity = period.getValueAsPhysicalQuantity();
		FormatContext newContext = new FormatContextImpl("PQ.TIME", context);
		// getAttributeNameValuePairs is never called with a null value; directly calling it from here is a bit of a cheat, so ensure no null passed in
		return quantity == null ? new HashMap<String, String>() : new PqPropertyFormatter().getAttributeNameValuePairs(newContext, quantity, null);
	}

}
