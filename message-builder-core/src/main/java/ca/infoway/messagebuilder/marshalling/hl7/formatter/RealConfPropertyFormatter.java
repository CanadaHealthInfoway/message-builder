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

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.RealConfFormat;
import ca.infoway.messagebuilder.marshalling.hl7.RealFormat;
import ca.infoway.messagebuilder.platform.NumberFormatter;
/**
 * REAL.CONF - BigDecimal [0,1]
 *
 * Represents a REAL.CONF object as an element:
 *
 * &lt;element-name value="0.1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-REAL
 *
 * The REAL.CONF variant defined by CHI can only contain positive values between 0 to 1 (inclusive). CHI also 
 * defines maximum length 1 character to the left of the decimal point and 4 characters to the right.
 */
@DataTypeHandler({"REAL.CONF"})
public class RealConfPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<BigDecimal>{

	private NumberFormatter numberFormatter = new NumberFormatter();
	private RealFormat realFormat = new RealConfFormat();
	
    @Override
    protected String getValue(BigDecimal bigDecimal, FormatContext context, BareANY bareAny) {
    	validate(context, bigDecimal);
    	return this.numberFormatter.format(
    			bigDecimal, 
    			this.realFormat.getMaxValueLength(),
    			this.realFormat.getMaxIntegerPartLength(),
    			determineScale(bigDecimal), 
    			true);
    }

	private int determineScale(BigDecimal bigDecimal) {
		boolean useBigDecimalScale = (bigDecimal.scale() >= 0 && bigDecimal.scale() < this.realFormat.getMaxDecimalPartLength());
		return useBigDecimalScale ? bigDecimal.scale() : this.realFormat.getMaxDecimalPartLength();
	}
    
	private void validate(FormatContext context, BigDecimal bigDecimal) {
		ModelToXmlResult modelToXmlResult = context.getModelToXmlResult();
    	if (bigDecimal.compareTo(BigDecimal.ZERO) < 0 || bigDecimal.compareTo(BigDecimal.ONE) > 0){
    		recordValueMustBeBetweenZeroAndOneError(context.getPropertyPath(), modelToXmlResult);
    	}
    	if (bigDecimal.scale() > realFormat.getMaxDecimalPartLength()) {
    		recordTooManyDigitsToRightOfDecimalError(context.getPropertyPath(), modelToXmlResult);
    	}
	}

	private void recordValueMustBeBetweenZeroAndOneError(String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value for REAL.CONF must be between 0 and 1 (inclusive). Value may have been modified to fit format requirements.", propertyPath));
	}
	
	private void recordTooManyDigitsToRightOfDecimalError(String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value for REAL.CONF must have no more than " + realFormat.getMaxDecimalPartLength() + " digits to the right of the decimal. Value has been modified to fit format requirements.", propertyPath));
	}
	
}
