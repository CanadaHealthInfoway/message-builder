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

package ca.infoway.messagebuilder.domainvalue.basic;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.util.DateConverter;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum to handle basic time units.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class DefaultTimeUnit extends EnumPattern implements DateConverter, x_TimeUnitsOfMeasure {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3134130558551921271L;
	
	public static final DefaultTimeUnit YEAR = new DefaultTimeUnit("YEAR", "a", DateUtils.MILLIS_PER_DAY * 365); 
	public static final DefaultTimeUnit MONTH = new DefaultTimeUnit("MONTH", "mo", DateUtils.MILLIS_PER_DAY * 30); 
	public static final DefaultTimeUnit WEEK = new DefaultTimeUnit("WEEK", "wk", DateUtils.MILLIS_PER_DAY * 7);
	public static final DefaultTimeUnit DAY = new DefaultTimeUnit("DAY", "d", DateUtils.MILLIS_PER_DAY);
	public static final DefaultTimeUnit HOUR = new DefaultTimeUnit("HOUR", "h", DateUtils.MILLIS_PER_HOUR);
	public static final DefaultTimeUnit MINUTE = new DefaultTimeUnit("MINUTE", "min", DateUtils.MILLIS_PER_MINUTE); 
	public static final DefaultTimeUnit SECOND = new DefaultTimeUnit("SECOND", "s", DateUtils.MILLIS_PER_SECOND); 

    private final String codeValue;
	private final long conversion;

	private DefaultTimeUnit(String name, String codeValue, long conversion) {
		super(name);
		this.codeValue = codeValue;
		this.conversion = conversion;
    }
	
	/**
	 * <p>Returns the code system for uniform unit of measure.
	 * 
	 * @return the code system for uniform unit of measure.
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot();
	}

	/**
	 * <p>Returns the code value.
	 * 
	 * @return the code value
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * <p>Converts the given value into milliseconds.
	 *  
	 * @param value the value to convert
	 * @return the given value in milliseconds. 
	 */
	public long toMilliseconds(int value) {
		return this.conversion * value;
	}
	
	/**
	 * <p>Converts the given BigDecimal into milliseconds.
	 *  
	 * @param quantity the BigDecimal to convert. 
	 * @return the given value in milliseconds. 
	 */
	public long toMilliseconds(BigDecimal quantity) {
		return quantity == null ? null : quantity.multiply(new BigDecimal(this.conversion)).longValue();
	}
	
	public static boolean isDayBased(ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive units) {
		if (units == null || units.getCodeValue() == null) {
			return false;
		}
		return  YEAR.getCodeValue().equals(units.getCodeValue()) || 
				MONTH.getCodeValue().equals(units.getCodeValue()) || 
				WEEK.getCodeValue().equals(units.getCodeValue()) || 
				DAY.getCodeValue().equals(units.getCodeValue()); 
	}
	
	/**
	 * <p>Returns the DefaultTimeUnit that is applicable for the given unit code value.
	 * 
	 * @param unitCodeValue the unit code value
	 * @return the DefaultTimeUnit that is applicable for the given unit code value
	 */
	public static DefaultTimeUnit lookup(String unitCodeValue) {
		DefaultTimeUnit result = null;
		for (DefaultTimeUnit unit : values(DefaultTimeUnit.class)) {
			if (StringUtils.equals(unitCodeValue, unit.getCodeValue())) {
				result = unit;
				break;
			}
		}
		return result;
	}
}
