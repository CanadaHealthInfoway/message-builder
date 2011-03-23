package ca.infoway.messagebuilder;

/**
 * <p>The Interface Code. Implemented by all classes that supply a code mnemonic and a related code system.
 */
public interface Code {
    
    /**
     * <p>Gets the code value.
     *
     * @return the code value
     */
    public String getCodeValue();
    
    /**
     * <p>Gets the code system.
     *
     * @return the code system
     */
    public String getCodeSystem();
}
