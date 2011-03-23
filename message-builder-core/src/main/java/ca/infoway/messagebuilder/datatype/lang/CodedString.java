package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Code;

/**
 * <p>Java datatype backing the Hl7 datatype SC (Coded String).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying code type
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class CodedString<T extends Code> {
    
    private final T code;
    private final String value;
    
    /**
     * <p>Constructs a CodedString based on a value and a code. 
     * 
     * @param value the value of the SC
     * @param code the code for the SC
     */
    public CodedString(String value, T code) {
        this.value = value;
        this.code = code;
    }
    
    /**
     * <p>Returns the code.
     * 
     * @return the code
     */
    public T getCode() {
        return this.code;
    }
    
    /**
     * <p>Returns the value.
     * 
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

}
