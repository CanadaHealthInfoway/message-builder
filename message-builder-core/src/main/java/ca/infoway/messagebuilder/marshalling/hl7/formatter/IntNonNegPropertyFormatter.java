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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

/**
 * INT.NONNEG - Integer (Non-negative)
 *
 * Represents a INT.NONNEG object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 *
 * The INT.NONNEG variant defined by CeRx cannot contain negative values. CeRx also defines
 * a maximum length of 10, which is not enforced by this class.
 */
@DataTypeHandler("INT.NONNEG")
class IntNonNegPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

    @Override
    protected String getValue(Integer integer, FormatContext context, BareANY bareAny) {
    	validate(integer, context, bareAny);
        return integer.toString();
    }
    
    private void validate(Integer integer, FormatContext context, BareANY bareAny) {
    	if (integer.intValue() < 0) {
    		recordNotNegativeError(integer, context.getPropertyPath(), context.getModelToXmlResult());
    	}
	}

	private void recordNotNegativeError(Integer integer, String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(
				new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					"The attribute \"value\" must not be negative for INT.NONNEG.",
					propertyPath
					)); 
	}
}
