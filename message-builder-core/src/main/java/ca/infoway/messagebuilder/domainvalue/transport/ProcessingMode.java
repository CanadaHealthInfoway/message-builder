package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ProcessingMode.
 */
public class ProcessingMode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ProcessingMode, Describable {
	
    private static final long serialVersionUID = -4741683761461235584L;
    
	public static final ProcessingMode ARCHIVE = new ProcessingMode("ARCHIVE", "A"); 
    public static final ProcessingMode CURRENT_PROCESSING = new ProcessingMode("CURRENT_PROCESSING", "T"); 
    public static final ProcessingMode INITIAL_LOAD = new ProcessingMode("INITIAL_LOAD", "I");
    public static final ProcessingMode RESTORE_FROM_ARCHIVE = new ProcessingMode("RESTORE_FROM_ARCHIVE", "R");

    private final String codeValue;

    private ProcessingMode(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_PROCESSING_MODE.getRoot();
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
