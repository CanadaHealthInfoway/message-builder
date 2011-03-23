package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>Allows conversion of an integer value into milliseconds. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public interface DateConverter {
	
	/**
	 * <p>Returns a value converted into milliseconds.
	 * 
	 * @param value the value to convert
	 * @return the value converted into milliseconds
	 */
	public long toMilliseconds(int value);
}
