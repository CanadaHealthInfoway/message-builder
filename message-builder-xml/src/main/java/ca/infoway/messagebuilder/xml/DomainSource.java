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
	public static final DomainSource VALUE_SET = new DomainSource("VALUE_SET", "value set"); 
	/**
	 * <p>A vocabulary source that represents the code system.
	 */
	public static final DomainSource CODE_SYSTEM = new DomainSource("CODE_SYSTEM", "code system"); 
	/**
	 * <p>A vocabulary source that represents the concept domain (domain name).
	 */
	public static final DomainSource CONCEPT_DOMAIN = new DomainSource("CONCEPT_DOMAIN", "domain"); 

	
	private final String description;

	private DomainSource(String name, String description) {
		super(name);
		this.description = description;
	}

	/**
	 * <p>Gets a user-readable description of the vocabulary source.
	 * @return the description.
	 */
	public String getDescription() {
		return this.description;
	}
}
