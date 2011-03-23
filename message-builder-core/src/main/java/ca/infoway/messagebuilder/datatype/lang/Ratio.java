package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>Java datatype for ratios.
 * 
 * <p>For RTO&lt;PQ.DRUG, PQ.TIME&gt;: Used to express a quantity of drug over a particular time-period.
 * 
 * <p>For RTO&lt;MO.CAD, PQ.BASIC&gt;: Used to express a monetary value over quantity.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> The underlying java datatype for the numerator.
 * @param <U> The underlying java datatype for the denominator.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class Ratio<T,U> implements BareRatio {
    
    private T numerator;
    private U denominator;
    
    /**
     * <p>Constructs an empty Ratio object.
     */
    public Ratio() {
	}
    
    /**
     * <p>Constructs a Ratio object with the given numerator and denominator.
     * 
     * @param numerator the numerator for the ratio
     * @param denominator the denominator for the ratoi
     */
    public Ratio(T numerator, U denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

    /**
     * <p>Returns the denominator.
     * 
     * @return the denominator
     */
    public U getDenominator() {
        return this.denominator;
    }
    
    /**
     * <p>Sets the denominator.
     * 
     * @param denominator the denominator
     */
    public void setDenominator(U denominator) {
        this.denominator = denominator;
    }

    /**
     * <p>Returns the numerator.
     * 
     * @return the numerator
     */
    public T getNumerator() {
        return this.numerator;
    }
    
    /**
     * <p>Sets the numerator.
     * 
     * @param numerator the numerator
     */
    public void setNumerator(T numerator) {
        this.numerator = numerator;
    }

	public Object getBareDenominator() {
		return getDenominator();
	}

	public Object getBareNumerator() {
		return getNumerator();
	}
}
