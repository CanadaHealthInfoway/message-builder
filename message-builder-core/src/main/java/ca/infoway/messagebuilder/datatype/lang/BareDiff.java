package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;

/**
 * .NET base class.
 * 
 * <p>Used to hold a difference value of a given type.   
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the javav type the diff value represents 
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public interface BareDiff extends NullFlavorSupport {
	
	public Object getBareValue();
}
