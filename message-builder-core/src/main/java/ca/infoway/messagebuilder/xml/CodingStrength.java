package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that represents the coding strenth.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CodingStrength extends EnumPattern {
	
	private static final long serialVersionUID = 3259949645508081979L;
	
	/**
	 * <p>A coding strength that represents a coded, non-extensible code (CNE).
	 */
	public static final CodingStrength CNE = new CodingStrength("CNE", "coded, non-extensible"); 
	/**
	 * <p>A coding strength that represents a coded with extensibility code (CWE).
	 */
	public static final CodingStrength CWE = new CodingStrength("CWE", "coded with extensibility");
	
	private final String description;

	private CodingStrength(String name, String description) {
		super(name);
		this.description = description;
	}

	/**
	 * <p>Gets a user-readable description of the coding strength.
	 * @return the description.
	 */
	public String getDescription() {
		return this.description;
	}
}
