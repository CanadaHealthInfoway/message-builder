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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.util.Representation;

/**
 * <p>A utility class for handling the Date Interval java datatype.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class IntervalUtil {

	/**
	 * <p>Determines whether an interval contains a point in time. The interval need not have
	 * high and low bounds specified.
	 * 
	 * @param dateInterval the interval to check
	 * @param date the date to apply to the given interval
	 * @return whether the supplied interval contains the supplied date
	 */
	public static boolean contains(Interval<Date> dateInterval, Date date) {
		if (dateInterval==null) {
			return false;
		} else if (date==null) {
			return true;
		} else {
			Date low = dateInterval.getLow();
			Date high = dateInterval.getHigh();
			return (low != null || high != null) 
				 && (low == null || low.getTime() <= date.getTime()) 
			    && (high == null || high.getTime() >= date.getTime()); 
		}
	}

	/**
	 *
	 * <p>Determines if one interval is fully contained within another interval.
	 * 
	 * <p>The comparison of intervals with the representation PERIOD, WIDTH, PHASE, PERIOD_PHASE,
	 * is not supported.
	 *    
	 * @param interval the interval to check
	 * @param otherInterval the interval to apply to the date interval
	 * @return whether the "other" interval is contained within the "date" interval 
	 */
	public static boolean contains(Interval<Date> interval, Interval<Date> otherInterval) {
		if (interval==null) {
			return false;
		} else if (otherInterval==null) {
			return true;
		} else {
			long low = getLow(interval);
			long high = getHigh(interval);
			
			long otherLow = getLow(otherInterval);
			long otherHigh = getHigh(otherInterval);
			
			return low <= otherLow && high >= otherHigh; 
		}
	}

	/**
	 *
	 * <p>Determines if one interval is fully outside the bounds of another interval.
	 * 
	 * @param interval the interval to check
	 * @param otherInterval the interval to apply to the date interval
	 * @return whether the "other" interval is fully outside the "date" interval 
	 */
	public static boolean mutuallyExclusive(Interval<Date> interval, Interval<Date> otherInterval) {
		if (interval==null) {
			return false;
		} else if (otherInterval==null) {
			return true;
		} else {
			long low = getLow(interval);
			long high = getHigh(interval);
			
			long otherLow = getLow(otherInterval);
			long otherHigh = getHigh(otherInterval);
			
			return high < otherLow || otherHigh < low;
		}
	}

	/**
	 * <p>Determines if the current date is contained within a given date interval.
	 * 
	 * @param validTime the interval to check
	 * @return whether the current date is within the supplied interval
	 */
	public static boolean containsCurrentDate(Interval<Date> validTime) {
		if (validTime == null) {
			return true;
		} else {
			long now = System.currentTimeMillis();
			long low = validTime.getLow() == null ? Long.MIN_VALUE : validTime.getLow().getTime();
			long high = validTime.getHigh() == null ? Long.MAX_VALUE : validTime.getHigh().getTime();
			return now < high && now > low;
		}
	}
	
	/**
	 * <p>Constructs a data interval from an upper and lower date range.
	 * 
	 * @param from the low bound of the interval. May be null.
	 * @param to the high bound of the interval. May be null.
	 * @return an interval corresponding to the given bounds.
	 */
	public static <T> Interval<T> createInterval(T from, T to) {
		if (from != null && to != null) {
			return IntervalFactory.<T>createLowHigh(from, to);
		} else if (from != null) {
			return IntervalFactory.<T>createLow(from);
		} else if (to != null) {
			return IntervalFactory.<T>createHigh(to);
		} else {
			return null;
		}
	}

	private static long getHigh(Interval<Date> interval) {
		Date high = interval.getHigh();
		if (high==null) {
			if (Representation.LOW.equals(interval.getRepresentation())) {
				return Long.MAX_VALUE;
			} else if (Representation.SIMPLE.equals(interval.getRepresentation())) {
				return interval.getValue().getTime();
			} else if (Representation.CENTRE.equals(interval.getRepresentation())) {
				return interval.getCentre().getTime();
			} else {
				return Long.MIN_VALUE;
			}
		}
		return high.getTime();
	}

	private static long getLow(Interval<Date> interval) {
		Date low = interval.getLow();
		if (low==null) {
			if (Representation.HIGH.equals(interval.getRepresentation())) {
				return Long.MIN_VALUE;
			} else if (Representation.SIMPLE.equals(interval.getRepresentation())) {
				return interval.getValue().getTime();
			} else if (Representation.CENTRE.equals(interval.getRepresentation())) {
				return interval.getCentre().getTime();
			} else {
				return Long.MAX_VALUE;
			}
		}
		return low.getTime();
	}
	
}
