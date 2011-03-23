package ca.infoway.messagebuilder.datatype.nullflavor;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * 
 * <p>Interface used to define behaviour for any nullable HL7 datatype, java datatype or message part bean.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public interface NullFlavorSupport {
    
	/**
	 * <p>Determines if the object currently has a null flavor set.
	 * 
	 * @return whether the object currently has a null flavor.
	 */
    public boolean hasNullFlavor();
    
    /**
     * <p>Returns the current null flavor state of the object.
     * 
     * @return the null flavor
     */
    public NullFlavor getNullFlavor();
    
    /**
     * <p>Sets a null flavor on the object.
     * 
     * @param nullFlavor the null flavor to set
     */
    public void setNullFlavor(NullFlavor nullFlavor);

}
