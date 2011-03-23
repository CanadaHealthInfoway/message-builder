package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Specifies the mode, immediate versus deferred or queued, by which a receiver 
 * should communicate its receiver responsibilities.
 */
public class ResponseMode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ResponseMode, Describable {
	
	private static final long serialVersionUID = -3314261517693748622L;
	/**
	 * <p>The receiver may respond in a non-immediate manner. Note: this will be 
	 * the default value.
	 */
    public static final ResponseMode DEFERRED = new ResponseMode("D"); 
    /**
     * <p>The receiver is required to assume that the sender is blocking and 
     * behave appropriately by sending an immediate response.
     */
    public static final ResponseMode IMMEDIATE = new ResponseMode("I"); 
    /**
     * <p>The receiver shall keep any application responses in a queue until 
     * such time as the queue is polled.
     */
    public static final ResponseMode QUEUE = new ResponseMode("Q");

    private ResponseMode(String codeValue) {
        super(codeValue);
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_RESPONSE_MODE.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return getName();
    }

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
