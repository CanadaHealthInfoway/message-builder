package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActIssuePriority. Indicates the relative importance or priority of a detected issue
 */
public class ActIssuePriority extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActIssuePriority {
	
	private static final long serialVersionUID = 5357530778447095336L;
	
	public static final ActIssuePriority ERROR = new ActIssuePriority("ERROR", "E"); 
	public static final ActIssuePriority INFORMATION = new ActIssuePriority("INFORMATION", "I"); 
	public static final ActIssuePriority WARNING = new ActIssuePriority("WARNING", "W");

    private final String codeValue;

    private ActIssuePriority(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
