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
 * Last modified: $LastChangedDate: 2013-05-16 20:18:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6877 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * RTO&lt;PQ, PQ&gt; - Ratio R2 (physical quantity, physical quantity)
 *
 * Represents a Ratio of physical quantities as an element:
 *
 * &lt;unitQuanity&gt;
 *    &lt;numerator value="1.0" xsi:type="PQ"/&gt;
 *    &lt;denominator value="64.0" xsi:type="/&gt;
 * &lt;/unitQuanity&gt;
 */
@DataTypeHandler("RTO<PQ,PQ>")
public class RtoPqPqR2PropertyFormatter extends AbstractRtoR2PropertyFormatter<PhysicalQuantity, PhysicalQuantity> {

	private PqR2PropertyFormatter pqFormatter = new PqR2PropertyFormatter();
	
	@Override
	protected String formatNumerator(FormatContext context, PhysicalQuantity numerator, int indentLevel) {
		FormatContext newContext = new FormatContextImpl("PQ", ConformanceLevel.OPTIONAL, Cardinality.create("0-1"), "numerator", context);
		return this.pqFormatter.format(newContext, new PQImpl(numerator), indentLevel);
	}

	@Override
	protected String formatDenominator(FormatContext context, PhysicalQuantity denominator, int indentLevel) {
		if (denominator != null && BigDecimal.ZERO.equals(denominator.getQuantity())) {
			context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Denominator cannot be zero for RTO types.", context.getPropertyPath()));
		}
		FormatContext newContext = new FormatContextImpl("PQ", ConformanceLevel.OPTIONAL, Cardinality.create("0-1"), "denominator", context);
		return this.pqFormatter.format(newContext, new PQImpl(denominator), indentLevel);
	}
	
}
