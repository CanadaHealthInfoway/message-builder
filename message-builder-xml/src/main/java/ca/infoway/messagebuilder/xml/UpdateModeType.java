package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;


/**
 * <p>Potential update modes.
 * 
 * <p>This enum models the various Update Mode Kinds in the HL7 standards materials.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class UpdateModeType extends EnumPattern {
	
	private static final long serialVersionUID = 3066114109382422542L;

	/** 
	 * <p> The add update mode. 
	 */
	public static final UpdateModeType ADD = new UpdateModeType("ADD", "A"); 
	/**
	 * <p> The remoe update mode.
	 */
	public static final UpdateModeType REMOVE = new UpdateModeType("REMOVE", "D"); 
	/**
	 * <p> The replace update mode.
	 */
	public static final UpdateModeType REPLACE = new UpdateModeType("REPLACE", "R"); 
	/**
	 * <p> The add or update update mode.
	 */
	public static final UpdateModeType ADD_OR_UPDATE = new UpdateModeType("ADD_OR_UPDATE", "N"); 
	/**
	 * <p> The no change update mode.
	 */
	public static final UpdateModeType NO_CHANGE = new UpdateModeType("NO_CHANGE", "N"); 
	/**
	 * <p> The unknown update mode.
	 */
	public static final UpdateModeType UNKNOWN = new UpdateModeType("UNKNOWN", "U"); 

	private final String codeValue;


	private UpdateModeType(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * <p>Gets the code for the update mode.
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
