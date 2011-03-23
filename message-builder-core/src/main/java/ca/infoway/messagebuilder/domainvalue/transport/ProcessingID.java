package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Codes used to specify whether a message is part of a production, training, 
 * or debugging system.
 */
public class ProcessingID extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ProcessingID, Describable {
	
    private static final long serialVersionUID = -4810533940602682646L;
    
	public static final ProcessingID DEBUGGING  = new ProcessingID("DEBUGGING", "D"); 
    public static final ProcessingID PRODUCTION = new ProcessingID("PRODUCTION", "P"); 
    public static final ProcessingID TRAINING = new ProcessingID("TRAINING", "T");

    private final String codeValue;

    private ProcessingID(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return "";
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
