/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.RealCoordFormat;
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
@DataTypeHandler({"REAL.COORD"})
public class RealCoordPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<BigDecimal>{
	
	private NumberFormatter formatter = new NumberFormatter();
	private RealFormat format = new RealCoordFormat();
	
	@Override
	boolean isInvalidValue(FormatContext context, BigDecimal bigDecimal) {
		String value = bigDecimal.setScale(this.format.getMaxDecimalPartLength(), BigDecimal.ROUND_HALF_UP).toString();
		
		if (this.format.getMaxValueLength() > StringUtils.length(value) ) {
			return true;
		} else {
			return false;
		}
	}
	
    @Override
    protected String getValue(BigDecimal bigDecimal, FormatContext context) {
    	return this.formatter.format(bigDecimal, 
    			this.format.getMaxValueLength(), this.format.getMaxDecimalPartLength(), true);
    }
}
