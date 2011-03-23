package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Set Operator enum.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class SetOperator extends EnumPattern implements Code {
	
	private static final long serialVersionUID = 3137851858955816030L;
	
	public static final SetOperator CONVEX_HULL = new SetOperator("CONVEX_HULL", "H"); 
	public static final SetOperator INCLUDE = new SetOperator("INCLUDE", "I");
	public static final SetOperator EXCLUDE = new SetOperator("EXCLUDE", "E"); 
	public static final SetOperator INTERSECT = new SetOperator("INTERSECT", "A"); 
	public static final SetOperator PERIODIC_HULL = new SetOperator("PERIODIC_HULL", "P");
	
	private final String codeValue;

	private SetOperator(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}

	/**
	 * <p>Returns an empty string for the code system.
	 * 
	 * @return the code system for this enum (empty string)
	 */
	public String getCodeSystem() {
		return "";
	}

	/**
	 * <p>Returns the value of this enum.
	 * 
	 * @return the value of this enum.
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
