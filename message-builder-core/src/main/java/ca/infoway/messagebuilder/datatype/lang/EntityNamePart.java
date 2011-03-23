package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>Class to represent an entity name part, containing a name part type and a value. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EntityNamePart {

    private final NamePartType type;
    private final String value;
    private final String qualifier;
    
    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * @param value the name part value
     * @param type the name part type
     * @param qualifier the name part qualifier
     */
	public EntityNamePart(String value, NamePartType type, String qualifier) {
        this.value = value;
        this.type = type;
		this.qualifier = qualifier;
    }

    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * @param value the name part value
     * @param type the name part type
     */
    public EntityNamePart(String value, NamePartType type) {
        this(value, type, null);
    }
    
    /**
     * <p>Constructs an EntityNamePart using only a value.
     * 
     * @param value the name part value
     */
    public EntityNamePart(String value) {
        this(value, null);
    }
    
    /**
     * <p>Returns the name part type.
     * 
     * @return the name part type
     */
    public NamePartType getType() {
        return this.type;
    }
    
    /**
     * <p>Returns the name part value.
     * 
     * @return the name part value
     */
    public String getValue() {
        return this.value;
    }
    
    /**
     * Returns the qualifier value.
     * 
     * @return the qualifier
     */
    public String getQualifier() {
		return this.qualifier;
	}

}
