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

import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;


/**
 * <p>This java datatype is used to back the HL7 datatype IVL.
 * 
 * <p>This data type is used when a continuous range needs to be expressed.
 * 
 * <p>Recommended to use the IntervalFactory class for object creation
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java type of the interval (i.e. Date)
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class Interval<T> extends SetComponent<T> {
	
	private final T low;
	private final T high;
	private final T centre;
	private final Diff<T> width;
	private final NullFlavor lowNullFlavor;
	private final NullFlavor highNullFlavor;
	private final NullFlavor centreNullFlavor;
	private final Representation representation;

	/**
	 * <p>Recommended to use the IntervalFactory class for object creation
	 * 
	 * @param low
	 * @param high
	 * @param centre
	 * @param width
	 * @param representation
	 */
	public Interval(T low, T high, T centre, Diff<T> width, Representation representation) {
		this(low, high, centre, width, representation, null, null, null, null);
	}

	/**
	 * <p>Recommended to use the IntervalFactory class for object creation
	 * 
	 * @param low
	 * @param high
	 * @param centre
	 * @param width
	 * @param representation
	 * @param lowNullFlavor
	 * @param highNullFlavor
	 * @param centreNullFlavor
	 */
	public Interval(T low, T high, T centre, Diff<T> width, Representation representation, NullFlavor lowNullFlavor, NullFlavor highNullFlavor, NullFlavor centreNullFlavor) {
		this(low, high, centre, width, representation, lowNullFlavor, highNullFlavor, centreNullFlavor, null);
	}

	/**
	 * <p>Recommended to use the IntervalFactory class for object creation
	 * 
	 * @param value
	 */
	public Interval(T value) {
		this(null, null, null, null, Representation.SIMPLE, null, null, null, value);
	}

	private Interval(T low, T high, T centre, Diff<T> width, Representation representation, NullFlavor lowNullFlavor, NullFlavor highNullFlavor, NullFlavor centreNullFlavor, T value) {
		super(value);
		this.low = low;
		this.high = high;
		this.centre = centre;
		this.width = width;
		this.representation = representation;
		this.lowNullFlavor = lowNullFlavor;
		this.highNullFlavor = highNullFlavor;
		this.centreNullFlavor = centreNullFlavor;
	}

	/**
	 * <p>Returns the centre of this interval.
	 * 
	 * @return the centre of this interval
	 */
    public T getCentre() {
        return this.centre;
    }

    /**
     * <p>Returns the width of this interval as a Diff.
     * 
     * @return the width of this interval as a Diff.
     */
    public Diff<T> getWidth() {
        return this.width;
    }

    /**
     * <p>Returns the high of this interval.
     * 
     * @return the high of this interval.
     */
    public T getHigh() {
        return this.high;
    }
    
    /**
     * <p>Returns the low of this interval.
     * 
     * @return the low of this interval.
     */
    public T getLow() {
        return this.low;
    }

    /**
     * <p>Returns the representation of this interval.
     * 
     * @return the representation of this interval.
     */
    public Representation getRepresentation() {
		return this.representation;
	}
    
    /**
     * 
     * @return the null flavor for low (if any)
     */
	public NullFlavor getLowNullFlavor() {
		return this.lowNullFlavor;
	}

	/**
	 * 
     * @return the null flavor for high (if any)
	 */
	public NullFlavor getHighNullFlavor() {
		return this.highNullFlavor;
	}

	/**
	 * 
     * @return the null flavor for centre (if any)
	 */
	public NullFlavor getCentreNullFlavor() {
		return this.centreNullFlavor;
	}

}
