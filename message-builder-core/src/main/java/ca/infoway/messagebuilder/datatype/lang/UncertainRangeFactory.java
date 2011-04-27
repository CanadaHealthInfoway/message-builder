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

public class UncertainRangeFactory {

	/**
	 * <p>Constructs an uncertain range (low/high).
	 * 
	 * @param <T> the type of the bounds
	 * @param low lower bound
	 * @param high upper bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createLowHigh(T low, T high) {
		return new UncertainRange<T>(low, high, GenericMath.average(low, high), GenericMath.diff(low, high), Representation.LOW_HIGH);
	}

	/**
	 * <p>Constructs an uncertain range (low/width).
	 * 
	 * @param <T> the type of the bounds
	 * @param low lower bound
	 * @param width size of width
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createLowWidth(T low, Diff<T> width) {
		T high =  GenericMath.add(low, width);
		return new UncertainRange<T>(low, high, GenericMath.average(low, high), width, Representation.LOW_WIDTH);
	}
	
	/**
	 * <p>Constructs an uncertain range (width/high).
	 * 
	 * @param <T> the type of the bounds
	 * @param width size of width
	 * @param high higher bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createWidthHigh(Diff<T> width, T high) {
		T low =  GenericMath.diff(width.getValue(), high).getValue();
		return new UncertainRange<T>(low, high, GenericMath.average(low, high), width, Representation.WIDTH_HIGH);
	}
	
	/**
	 * <p>Constructs an uncertain range (centre/width).
	 * 
	 * @param <T> the type of the bounds
	 * @param centre centre bound
	 * @param width size of width
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createCentreWidth(T centre, Diff<T> width) {
		T half = GenericMath.half(width.getValue());
		T low = GenericMath.diff(half, centre).getValue();
		T high = GenericMath.add(low, width);
		return new UncertainRange<T>(low, high, centre, width, Representation.CENTRE_WIDTH);
	}

	/**
	 * <p>Constructs an uncertain range (centre/high).
	 * 
	 * @param <T> the type of the bounds
	 * @param center center bound
	 * @param high higher bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createCentreHigh(T center, T high) {
		T half = GenericMath.diff(center, high).getValue();
		T low = GenericMath.diff(half, center).getValue();
		return new UncertainRange<T>(low, high, center, GenericMath.diff(low, high), Representation.CENTRE_HIGH);
	}
	
	/**
	 * <p>Constructs an uncertain range (low).
	 * 
	 * @param <T> the type of the bounds
	 * @param low lower bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createLow(T low) {
		return new UncertainRange<T>(low, null, null, null, Representation.LOW);
	}
	
	/**
	 * <p>Constructs an uncertain range (low/centre).
	 * 
	 * @param <T> the type of the bounds
	 * @param low lower bound
	 * @param center center bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createLowCenter(T low, T center) {
		return new UncertainRange<T>(low, null, center, null, Representation.LOW_CENTER);
	}

	/**
	 * <p>Constructs an uncertain range (width).
	 * 
	 * @param <T> the type of the bounds
	 * @param diff the width diff
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createWidth(Diff<T> diff) {
		return new UncertainRange<T>(null, null, null, diff, Representation.WIDTH);
	}
	
	/**
	 * <p>Constructs an uncertain range (high).
	 * 
	 * @param <T> the type of the bounds
	 * @param high higher bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createHigh(T high) {
		return new UncertainRange<T>(null, high, null, null, Representation.HIGH);
	}

	/**
	 * <p>Constructs an uncertain range (centre).
	 * 
	 * @param <T> the type of the bounds
	 * @param centre centre bound
	 * @return the constructed uncertain range
	 */
	public static <T> UncertainRange<T> createCentre(T centre) {
		return new UncertainRange<T>(null, null, centre, null, Representation.CENTRE);
	}
}
