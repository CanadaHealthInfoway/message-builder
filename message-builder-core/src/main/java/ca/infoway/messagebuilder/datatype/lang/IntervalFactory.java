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

package ca.infoway.messagebuilder.datatype.lang;

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
		return new Interval<T>(low, high, GenericMath.average(low, high), GenericMath.diff(low, high), Representation.LOW_HIGH);
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
		T high =  GenericMath.add(low, width);
		return new Interval<T>(low, high, GenericMath.average(low, high), width, Representation.LOW_WIDTH);
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
		T low =  GenericMath.diff(width.getValue(), high).getValue();
		return new Interval<T>(low, high, GenericMath.average(low, high), width, Representation.WIDTH_HIGH);
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
		T half = GenericMath.half(width.getValue());
		T low = GenericMath.diff(half, centre).getValue();
		T high = GenericMath.add(low, width);
		return new Interval<T>(low, high, centre, width, Representation.CENTRE_WIDTH);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param low the low bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createLow(T low) {
		return new Interval<T>(low, null, null, null, Representation.LOW);
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
		return new Interval<T>(null, high, null, null, Representation.HIGH);
	}

	/**
	 * <p>Constructs an Interval using the supplied parameters.
	 * 
	 * @param <T> the java type of the interval
	 * @param centre the centre bound
	 * @return the constructed interval
	 */
	public static <T> Interval<T> createCentre(T centre) {
		return new Interval<T>(null, null, centre, null, Representation.CENTRE);
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
}
