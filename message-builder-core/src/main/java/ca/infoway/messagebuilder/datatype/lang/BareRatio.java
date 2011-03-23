package ca.infoway.messagebuilder.datatype.lang;

/**
 * .NET base class.
 * 
 * <p>Used to hold a difference value of a given type.   
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface BareRatio {
	
    /**
     * <p>Returns the denominator.
     * 
     * @return the denominator
     */
    public Object getBareDenominator();
    
    /**
     * <p>Returns the numerator.
     * 
     * @return the numerator
     */
    public Object getBareNumerator();
	

}
