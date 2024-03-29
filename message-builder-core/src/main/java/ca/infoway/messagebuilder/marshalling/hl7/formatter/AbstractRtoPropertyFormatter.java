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

import ca.infoway.messagebuilder.datatype.lang.BareRatio;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;

public abstract class AbstractRtoPropertyFormatter<T, U> extends AbstractNullFlavorPropertyFormatter<BareRatio> {

	@SuppressWarnings("unchecked")
	@Override
	protected
    String formatNonNullValue(FormatContext context, BareRatio value, int indentLevel) {
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, null, indentLevel, false, true));

        T bareNumerator = (T) value.getBareNumerator();
        U bareDenominator = (U) value.getBareDenominator();
        
        if (bareNumerator == null || bareDenominator == null) {
        	context.getModelToXmlResult().addHl7Error(
        		new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Numerator and denominator must be non-null; both are mandatory for Ratio types.", context.getPropertyPath())
        	);
        }
        
		buffer.append(formatNumerator(context, bareNumerator, indentLevel + 1));
		buffer.append(formatDenominator(context, bareDenominator, indentLevel + 1));
        
        buffer.append(createElementClosure(context.getElementName(), indentLevel, true));
        return buffer.toString();
    }
    
    protected abstract String formatNumerator(FormatContext context, T numerator, int indentLevel);
    protected abstract String formatDenominator(FormatContext context, U denominator, int indentLevel);
}
