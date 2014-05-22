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

package ca.infoway.messagebuilder.datatype.lang.util;

import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

public class IntervalFactory {

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @param high the high bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowHigh(T low, T high) {
		return IntervalFactory.createLowHigh(low, high, null, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @param high the high bound
	 * @param lowNullFlavor
	 * @param highNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowHigh(T low, T high, NullFlavor lowNullFlavor, NullFlavor highNullFlavor) {
		T average = (lowNullFlavor != null || highNullFlavor != null) ? null : GenericMath.average(low, high);
		Diff<T> diff = (lowNullFlavor != null || highNullFlavor != null) ? null : GenericMath.diff(low, high);
		return new Interval<T>(low, high, average, diff, Representation.LOW_HIGH, lowNullFlavor, highNullFlavor, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @param width the width as a Diff object
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowWidth(T low, Diff<T> width) {
		return IntervalFactory.createLowWidth(low, width, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @param width the width as a Diff object
	 * @param lowNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowWidth(T low, Diff<T> width, NullFlavor lowNullFlavor) {
		T high =  GenericMath.add(low, width);
		return new Interval<T>(low, high, GenericMath.average(low, high), width, Representation.LOW_WIDTH, lowNullFlavor, null, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param width the width as a Diff object
	 * @param high the high bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createWidthHigh(Diff<T> width, T high) {
		return IntervalFactory.createWidthHigh(width, high, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param width the width as a Diff object
	 * @param high the high bound
	 * @param highNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createWidthHigh(Diff<T> width, T high, NullFlavor highNullFlavor) {
		boolean widthNull = (width == (Diff<T>) null);
		Diff<T> tempDiff = GenericMath.diff(widthNull ? null : width.getValue(), high);
		boolean tempDiffNull = (tempDiff == (Diff<T>) null);
		T low =  tempDiffNull ? null : tempDiff.getValue();
		return new Interval<T>(low, high, GenericMath.average(low, high), width, Representation.WIDTH_HIGH, null, highNullFlavor, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param centre the centre bound
	 * @param width the width as a Diff object
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentreWidth(T centre, Diff<T> width) {
		return IntervalFactory.createCentreWidth(centre, width, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param centre the centre bound
	 * @param width the width as a Diff object
	 * @param centreNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentreWidth(T centre, Diff<T> width, NullFlavor centreNullFlavor) {
		boolean widthNull = (width == (Diff<T>) null);
		T half = GenericMath.half(widthNull ? null : width.getValue());
		Diff<T> tempDiff = GenericMath.diff(half, centre);
		boolean tempDiffNull = (tempDiff == (Diff<T>) null);
		T low = tempDiffNull ? null : tempDiff.getValue();
		T high = GenericMath.add(low, width);
		return new Interval<T>(low, high, centre, width, Representation.CENTRE_WIDTH, null, null, centreNullFlavor);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param low
	 * @param centre
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowCentre(T low, T centre) {
		return IntervalFactory.createLowCentre(low, centre, null, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param low
	 * @param centre
	 * @param lowNullFlavor
	 * @param centreNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLowCentre(T low, T centre, NullFlavor lowNullFlavor, NullFlavor centreNullFlavor) {
		Diff<T> tempDiff = GenericMath.diff(low, centre);
		boolean tempDiffNull = (tempDiff == (Diff<T>) null);
		T halfDiff = tempDiffNull ? null : tempDiff.getValue();
		T high = GenericMath.add(centre, halfDiff);
		Diff<T> width = GenericMath.diff(low, high);
		return new Interval<T>(low, high, centre, width, Representation.LOW_CENTER, lowNullFlavor, null, centreNullFlavor);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param centre
	 * @param high
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentreHigh(T centre, T high) {
		return IntervalFactory.createCentreHigh(centre, high, null, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param centre
	 * @param high
	 * @param centreNullFlavor
	 * @param highNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentreHigh(T centre, T high, NullFlavor centreNullFlavor, NullFlavor highNullFlavor) {
		Diff<T> tempDiff = GenericMath.diff(centre, high);
		boolean tempDiffNull = (tempDiff == (Diff<T>) null);
		T halfDiff = tempDiffNull ? null : tempDiff.getValue();
		Diff<T> tempDiff2 = GenericMath.diff(halfDiff, centre);
		boolean tempDiff2Null = (tempDiff2 == (Diff<T>) null);
		T low = tempDiff2Null ? null : tempDiff2.getValue();
		Diff<T> width = GenericMath.diff(low, high);
		return new Interval<T>(low, high, centre, width, Representation.CENTRE_HIGH, null, highNullFlavor, centreNullFlavor);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLow(T low) {
		return IntervalFactory.createLow(low, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @param lowNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLow(T low, NullFlavor lowNullFlavor) {
		return new Interval<T>(low, null, null, null, Representation.LOW, lowNullFlavor, null, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param width the width as a Diff object
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createWidth(Diff<T> width) {
		return new Interval<T>(null, null, null, width, Representation.WIDTH);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param high the high bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createHigh(T high) {
		return IntervalFactory.createHigh(high, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param high the high bound
	 * @param highNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createHigh(T high, NullFlavor highNullFlavor) {
		return new Interval<T>(null, high, null, null, Representation.HIGH, null, highNullFlavor, null);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param centre the centre bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentre(T centre) {
		return IntervalFactory.createCentre(centre, null);
	}
	
	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param centre the centre bound
	 * @param centreNullFlavor
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentre(T centre, NullFlavor centreNullFlavor) {
		return new Interval<T>(null, null, centre, null, Representation.CENTRE, null, null, centreNullFlavor);
	}
	
    /**
     * <p>Constructs a simple interval based on a single value.
     * 
     * @param <T> the type of the Interval
     * @param value the simple value for the Interval
     * @return the constructed Interval
     */
	public static <T> Interval<T> createSimple(T value) {
		return new Interval<T>(value);
	}

	/**
	 * Converts an UncertainRange into an Interval.
	 * 
	 * Note that the new Interval will lose any high/low inclusive data from the range.
	 * 
	 * @param the uncertain range
	 * @return an Interval that corresponds to the range
	 */
	public static <T> Interval<T> createFromUncertainRange(UncertainRange<T> urg) {
		return new Interval<T>(urg.getLow(), urg.getHigh(), urg.getCentre(), urg.getWidth(), urg.getRepresentation(), urg.getLowNullFlavor(), urg.getHighNullFlavor(), urg.getCentreNullFlavor());
	}
}
