package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Enum for PersonName part types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PersonNamePartType extends EnumPattern implements NamePartType {
	
    private static final long serialVersionUID = 8255492551088946001L;
    
	public static final PersonNamePartType DELIMITER = new PersonNamePartType("DELIMITER", "delimiter"); 
    public static final PersonNamePartType PREFIX = new PersonNamePartType("PREFIX", "prefix"); 
    public static final PersonNamePartType SUFFIX = new PersonNamePartType("SUFFIX", "suffix"); 
    public static final PersonNamePartType FAMILY = new PersonNamePartType("FAMILY", "family"); 
    public static final PersonNamePartType GIVEN = new PersonNamePartType("GIVEN", "given");

	private final String value;

    private PersonNamePartType(String name, String value) {
    	super(name);
		this.value = value;
    }
    
    /**
     * <p>Returns the enum value.
     * 
     * @return the enum value
     */
    public String getValue() {
        return this.value;
    }
}
