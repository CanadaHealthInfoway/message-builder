package ca.infoway.messagebuilder.datatype.lang;


/**
 * <p>This java datatype is used to back the HL7 datatype IVL.
 * 
 * <p>This data type is used when a continuous range needs to be expressed.
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
	private final Representation representation;
	
	Interval(T low, T high, T centre, Diff<T> width, Representation representation) {
		this.low = low;
		this.high = high;
		this.centre = centre;
		this.width = width;
		this.representation = representation;
	}

	Interval(T value) {
		super(value);
		this.low = null;
		this.high = null;
		this.centre = null;
		this.width = null;
		this.representation = Representation.SIMPLE;
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
}
