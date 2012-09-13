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

package ca.infoway.messagebuilder.platform;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

/**
 * @sharpen.ignore platform
 */
public class NumberFormatter {
	
	public String format(BigDecimal b, int maxLength, int maxNumberOfDecimals, boolean padFractions) {
		String base = StringUtils.repeat(padFractions ? "0" : "#", maxNumberOfDecimals);
		String pattern = StringUtils.leftPad("0." +  base, maxLength, '#');
		DecimalFormat format = new DecimalFormat(pattern);
		format.setMaximumIntegerDigits(maxLength - maxNumberOfDecimals - 1); 
		return format.format(b);
	}
}
