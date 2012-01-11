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

package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>A math utility class for operations on various datatypes.
 * 
 * <p>Currently supports Number types, PhysicalQuantity, and Date.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
class GenericMath {

	/**
	 * <p>Adds two values of the same type. 
	 * 
	 * @param <T> the type of the values to be added together. 
	 * @param low first value to be added
	 * @param width second value to be added
	 * @return the sum of the two values
	 * @throws IllegalArgumentException if the type is not supported
	 */
	@SuppressWarnings("unchecked")
	public static <T> T add(T low, T width) {
		
		if (low == null) {
			return width;
		} else if (width == null) {
			return low;
		} else if (low instanceof Integer) {
			return (T) addInteger((Integer) low, (Integer) width);
		} else if (low instanceof Long) {
			return (T) addLong((Long) low, (Long) width);
		} else if (low instanceof Double) {
			return (T) addDouble((Double) low, (Double) width);
		} else if (low instanceof BigDecimal) {
			return (T) addBigDecimal((BigDecimal) low, (BigDecimal) width);
		} else if (low instanceof PhysicalQuantity) {
			return (T) addPhysicalQuantity((PhysicalQuantity) low, (PhysicalQuantity) width);
		} else if (low instanceof Date) {
			return (T) addDate((Date) low, (Date) width);
		} else {
			throw new IllegalArgumentException("Can't determine how to perform addition on " + low.getClass());
		}
	}
	
	private static PhysicalQuantity addPhysicalQuantity(PhysicalQuantity q1, PhysicalQuantity q2) {
		if (q1.getUnit().equals(q2.getUnit())) {
			return new PhysicalQuantity(addBigDecimal(q1.getQuantity(), q2.getQuantity()), q1.getUnit());
		} else {
			throw new IllegalArgumentException(
					"Can't add two quantities of different units: " + q1.getUnit() + 
					" and " +q2.getUnit());
		}
	}

	/**
	 * <p>Averages two values of the same type. 
	 * 
	 * @param <T> the type of the values to be added together. 
	 * @param low first value to be added
	 * @param high second value to be added
	 * @return the average of the two values
	 * @throws IllegalArgumentException if the type is not supported
	 */
	public static <T> T average(T low, T high) {
		return half(add(low, high));
	}
	
	/**
	 * <p>Calculates the differenced between two values of the same type. 
	 * 
	 * @param <T> the type of the values to be differenced. 
	 * @param t first value to be differenced
	 * @param t2 second value to be differenced
	 * @return the diff of the two values
	 * @throws IllegalArgumentException if the type is not supported
	 */
	@SuppressWarnings("unchecked")
	public static <T> Diff<T> diff(T t, T t2) { 
		if (t == null || t2 == null) {
			return null;
		} else if (t instanceof Date) {
			return (Diff<T>) diffDate((Date) t, (Date) t2);
		} else if (t instanceof Long) {
			return (Diff<T>) diffLong((Long) t, (Long) t2);
		} else if (t instanceof BigDecimal) {
			return (Diff<T>) diffBigDecimal((BigDecimal) t, (BigDecimal) t2);
		} else if (t instanceof Integer) {
			return (Diff<T>) diffInteger((Integer) t, (Integer) t2);
		} else if (t instanceof PhysicalQuantity) {
			return (Diff<T>) diffPhysicalQuantity((PhysicalQuantity) t, (PhysicalQuantity) t2);
		} else {
			throw new IllegalArgumentException("Can't determine how to perform diff on " + t.getClass());
		}
	}
	
	private static Diff<PhysicalQuantity> diffPhysicalQuantity(PhysicalQuantity q1, PhysicalQuantity q2) {
		if (q1.getUnit().equals(q2.getUnit())) {
			return new Diff<PhysicalQuantity>(new PhysicalQuantity(
					diffBigDecimal(q1.getQuantity(), q2.getQuantity()).getValue(), q1.getUnit()));
		} else {
			throw new IllegalArgumentException(
					"Can't diff two quantities of different units: " + q1.getUnit() + 
					" and " +q2.getUnit());
		}
	}

	private static Diff<BigDecimal> diffBigDecimal(BigDecimal q1, BigDecimal q2) {
		return new Diff<BigDecimal>(q2.subtract(q1));
	}

	private static Diff<Integer> diffInteger(Integer integer1, Integer integer2) {
		return new Diff<Integer>(integer2 - integer1);
	}

	private static Diff<Long> diffLong(Long long1, Long long2) {
		return new Diff<Long>(long2 - long1);
	}

	private static Diff<Date> diffDate(Date date, Date date2) {
		return new Diff<Date>(new Date(date2.getTime() - date.getTime()));
	}

	/**
	 * <p>Halves a given value.
	 * 
	 * @param <T> the type of the value to be halved
	 * @param t the value to be halved
	 * @return the halved value
	 */
	@SuppressWarnings("unchecked")
	public static <T> T half(T t) {
		if (t == null) {
			return null;
		} else if (t instanceof Integer) {
			return (T) half((Integer) t);
		} else if (t instanceof Long) {
			return (T) half((Long) t);
		} else if (t instanceof Date) {
			return (T) half((Date) t);
		} else if (t instanceof PhysicalQuantity) {
			return (T) half((PhysicalQuantity) t);
		} else {
			return null;
		}
	}
	
	private static Integer half(Integer value) {
		return value/2;
	}

	private static PhysicalQuantity half(PhysicalQuantity value) {
		return new PhysicalQuantity(value.getQuantity().multiply(new BigDecimal("0.5")), value.getUnit());
	}
	
	private static Long half(Long value) {
		return value/2L;
	}
	
	private static Date half(Date value) {
		return new Date(value.getTime()/2L);
	}
	
	private static BigDecimal addBigDecimal(BigDecimal value1, BigDecimal value2) {
		return value1.add(value2);
	}

	/**
	 * <p>Adds a value to a diff of the same type. 
	 * 
	 * @param <T> the type of the values to be added together. 
	 * @param low first value to be added
	 * @param width diff value to be added
	 * @return the sum of the two values
	 * @throws IllegalArgumentException if the type is not supported
	 */
	@SuppressWarnings("unchecked")
	public static <T> T add(T low, Diff<T> width) {
		
		if (low instanceof Date && width instanceof DateDiff) {
			return (T) addDate((Date) low, (DateDiff) width);
		} else if (low instanceof Date) {
			return (T) addDate((Date) low, (Diff<Date>) width);
		} else {
			return add(low, width.getValue());
		}
	}
	
	@SuppressWarnings("deprecation")
	private static Date addDate(Date date, DateDiff diff) {
		if (diff.getUnitValue() == null || diff.getUnit() == null) {
			return addDate(date, (Diff<Date>) diff);
		} else {
			Calendar c = new GregorianCalendar();
			c.setTime(date);
			if (diff.getUnit() == null) {
			} else if (DateDiff.SECOND.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.SECOND, diff.getUnitValue());
			} else if (DateDiff.MINUTE.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.MINUTE, diff.getUnitValue());
			} else if (DateDiff.HOUR.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.HOUR, diff.getUnitValue());
			} else if (DateDiff.DAY.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.DATE, diff.getUnitValue());
			} else if (DateDiff.WEEK.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.DATE, 7 * diff.getUnitValue());
			} else if (DateDiff.MONTH.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.MONTH, diff.getUnitValue());
			} else if (DateDiff.YEAR.equals(diff.getUnit().getCodeValue())) {
				c.add(Calendar.YEAR, diff.getUnitValue());
			}
			return c.getTime();
		}
	}

	private static Date addDate(Date date, Diff<Date> diff) {
		Date value = diff.getValue();
		return new Date(date.getTime() + (value != null ? value.getTime() : 0));
	}
	
	private static Date addDate(Date date, Date date2) {
		return new Date(date.getTime() + date2.getTime());
	}

	private static Double addDouble(Double low, Double width) {
		return low + width;
	}

	private static Long addLong(Long low, Long width) {
		return low + width;
	}

	private static Integer addInteger(Integer low, Integer width) {
		return low + width;
	}
}
