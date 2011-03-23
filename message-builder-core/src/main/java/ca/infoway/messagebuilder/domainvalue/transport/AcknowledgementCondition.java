package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The codes identify the conditions under which accept acknowledgements are 
 * required to be returned in response to this message. Note that accept acknowledgement 
 * address two different issues at the same time: reliable transport as well as syntactical correct
 * 
 * @author administrator
 */
public class AcknowledgementCondition extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition, Describable {
	
	private static final long serialVersionUID = 7605543876867112424L;

	/**
	 *  Always send an acknowledgement.
	 */
    public static final AcknowledgementCondition ALWAYS = new AcknowledgementCondition("ALWAYS", "AL"); 
    
    /**
     * Send an acknowledgement for error/reject conditions only.
     */
    public static final AcknowledgementCondition ERRORS_ONLY = new AcknowledgementCondition("ERRORS_ONLY", "ER"); 
    /**
     * Never send an acknowledgement.
     */
    public static final AcknowledgementCondition NEVER = new AcknowledgementCondition("NEVER", "NE");

    private final String codeValue;

    private AcknowledgementCondition(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_CONDITION.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}

}
