package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum AcknowledgementDetailType. A code distinguishing between errors, 
 * warnings and information messages related to the transmission of the message
 */
public class AcknowledgementDetailType extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType {
    
    private static final long serialVersionUID = -5837485473668582469L;
    
	public static final AcknowledgementDetailType ERROR = new AcknowledgementDetailType("ERROR", "E");
    public static final AcknowledgementDetailType INFORMATION = new AcknowledgementDetailType("INFORMATION", "I"); 
    public static final AcknowledgementDetailType WARNING = new AcknowledgementDetailType("WARNING", "W");

    private final String codeValue;

    private AcknowledgementDetailType(String name, String codeValue) {
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
