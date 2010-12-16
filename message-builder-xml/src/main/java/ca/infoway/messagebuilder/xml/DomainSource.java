package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that represents the vocabulary Source.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class DomainSource extends EnumPattern {
	
	private static final long serialVersionUID = 3259949645508081979L;
	
	/**
	 * <p>A vocabulary source that represents the value set.
	 */
	public static final DomainSource VALUE_SET = new DomainSource("VALUE_SET", "valueSet"); 
	/**
	 * <p>A vocabulary source that represents the code system.
	 */
	public static final DomainSource CODE_SYSTEM = new DomainSource("CODE_SYSTEM", "codeSystem"); 
	/**
	 * <p>A vocabulary source that represents the concept domain (domain name).
	 */
	public static final DomainSource CONCEPT_DOMAIN = new DomainSource("CONCEPT_DOMAIN", "domain"); 

	
	private final String code;

	private DomainSource(String name, String description) {
		super(name);
		this.code = description;
	}

	/**
	 * <p>Gets the code of the vocabulary source.
	 * @return the code.
	 */
	public String getCode() {
		return this.code;
	}
}
