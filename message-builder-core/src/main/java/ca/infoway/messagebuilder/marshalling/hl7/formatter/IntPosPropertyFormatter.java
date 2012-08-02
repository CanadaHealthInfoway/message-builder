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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;



/**
 * INT.POS - Integer (Positive)
 *
 * Represents a INT.POS object as an element:
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
 * The INT.POS variant defined by CeRx can only contain positive values. CeRx also defines
 * a maximum length of 10, which is not enforced by this class.
 */
@DataTypeHandler("INT.POS")
class IntPosPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

    @Override
    protected String getValue(Integer integer, FormatContext context, BareANY bareAny) throws ModelToXmlTransformationException {
    	validate(integer, context, bareAny);
        return integer.toString();
    }
    
    private void validate(Integer integer, FormatContext context, BareANY bareAny) {
    	if (integer.intValue() <= 0) {
    		recordMustBeGreaterThanZeroError(integer, context.getModelToXmlResult());
    	}
	}

	private void recordMustBeGreaterThanZeroError(Integer integer, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" must be greater than zero for INT.POS.")); 
	}

}
