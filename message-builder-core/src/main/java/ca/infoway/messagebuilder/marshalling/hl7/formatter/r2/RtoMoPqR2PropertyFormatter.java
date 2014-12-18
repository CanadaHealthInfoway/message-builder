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
 * Last modified: $LastChangedDate: 2012-05-15 20:03:59 -0400 (Tue, 15 May 2012) $
 * Revision:      $LastChangedRevision: 5886 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
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
@DataTypeHandler("RTO<MO,PQ>")
public class RtoMoPqR2PropertyFormatter extends AbstractRtoR2PropertyFormatter<Money, PhysicalQuantity> {

	private PqR2PropertyFormatter pqFormatter = new PqR2PropertyFormatter();
	private MoR2PropertyFormatter moFormatter = new MoR2PropertyFormatter();
	
	@Override
	protected String formatNumerator(FormatContext context, Money numerator, int indentLevel) {
		FormatContext newContext = new FormatContextImpl("MO", ConformanceLevel.OPTIONAL, Cardinality.create("0-1"), "numerator", context);
		return this.moFormatter.format(newContext, new MOImpl(numerator), indentLevel);
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
