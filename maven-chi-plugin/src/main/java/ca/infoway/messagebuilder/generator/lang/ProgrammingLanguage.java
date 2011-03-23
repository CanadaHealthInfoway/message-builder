package ca.infoway.messagebuilder.generator.lang;

/**
 * <p>An enum used to identify the programming language that we're trying to 
 * write output for.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public enum ProgrammingLanguage {
	JAVA, C_SHARP;
	
	public boolean isJava() {
		return this == JAVA;
	}
}
