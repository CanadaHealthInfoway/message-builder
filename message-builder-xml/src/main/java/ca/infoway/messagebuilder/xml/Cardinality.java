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

package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * <p>A class that models the cardinality of a particular HL7 relationship.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Cardinality {

	private final Integer min;
	private final Integer max;

	/**
	 * <p>Get the maximum value.
	 * @return the maximum value.
	 */
	public Integer getMax() {
		return this.max;
	}

	/**
	 * <p>Get the miniumum value.
	 * @return the miniumum value.
	 */
	public Integer getMin() {
		return this.min;
	}
	
	/**
	 * <p>A flag that indicates that the cardinality is at least one.
	 * @return true if the minium cardinality is at least one; false otherwise.
	 */
	public boolean isMandatory() {
		return this.min >= 1;
	}

	/**
	 * <p>Standard constructor.
	 * @param min - the minimum value.
	 * @param max - the maximum value.
	 */
	public Cardinality(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}
	
	/**
	 * <p>A convenience method to see if the cardinality of "1" or "0-1".
	 * @return true if the maximum cardinality is 1; false otherwise.
	 */
	public boolean isSingle() {
		return 1 == this.max;
	}
	
	/**
	 * <p>A convenience method to see if the maximum cardinality is greater than
	 * one.
	 * @return true if the cardinality is not single; false otherwise.
	 */
	public boolean isMultiple() {
		return !isSingle();
	}

	/**
	 * <p>Determine if this cardinality is equal to another object.
	 * @param obj - the other object
	 * @return true if the two objects describe the same cardinality; false otherwise.
	 */
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	} else if (obj.getClass() != getClass()) {
    		return false;
    	} else {
    		Cardinality that = (Cardinality) obj;
    		return new EqualsBuilder()
    				.append(this.min, that.min)
    				.append(this.max, that.max)
    				.isEquals();
    	}
    }
    
    /**
     * <p>Provide a string representation of the cardinality.  (e.g. "0-*", indicating 
     * unbounded cardinality.
     * 
     * @return the string representation of the cardinality.
     */
    @Override
    public String toString() {
    	if (new Integer(1).equals(this.min) && new Integer(Integer.MAX_VALUE).equals(this.max)) {
    		return "*";
    	} else if (new Integer(0).equals(this.min) && new Integer(Integer.MAX_VALUE).equals(this.max)) {
    		return "0-*";
    	} else if (new Integer(Integer.MAX_VALUE).equals(this.max)) {
    		return "" + this.min + "-*";
    	} else if (ObjectUtils.equals(this.min, this.max)) {
    		return "" + this.min;
    	} else {
    		return "" + this.min + "-" + this.max;
    	}
    }
    
    /**
     * <p>Parse a cardinality string (such as "*" or "0-50") into a cardinality object.
     * 
     * @param string - the string representation.
     * @return - the cardinality
     */
	public static Cardinality create(String string) {
		if (StringUtils.isBlank(string)) {
			return null;
		} else if ("*".equals(string)) {
			return new Cardinality(1, Integer.MAX_VALUE);
		} else if (string.contains("-")) {
			int min = Integer.parseInt(StringUtils.substringBefore(string, "-"));
			String maxAsString = StringUtils.substringAfter(string, "-");
			int max = ("*".equals(maxAsString)) 
					? Integer.MAX_VALUE
					: Integer.parseInt(maxAsString);
			return new Cardinality(min, max);
		} else {
			int value = Integer.parseInt(string);
			return new Cardinality(value, value);
		}
	}

	/**
	 * <p>A convenience method to indicate whether a specified value is contained within
	 * the cardinality range.
	 * 
	 * @param value - the value being specified.
	 * @return - true if the cardinality range contains the value; false otherwise.
	 */
	public boolean contains(int value) {
		return (this.min == null || this.min <= value) && 
			(this.max == null || this.max >= value);
	}
}
