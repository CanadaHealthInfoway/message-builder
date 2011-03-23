package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for organization name part types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class OrganizationNamePartType extends EnumPattern implements NamePartType {
	
    private static final long serialVersionUID = -8005396643000939327L;
    
	public static final OrganizationNamePartType DELIMETER = new OrganizationNamePartType("DELIMETER", "delimiter"); 
    public static final OrganizationNamePartType PREFIX = new OrganizationNamePartType("PREFIX", "prefix");
    public static final OrganizationNamePartType SUFFIX = new OrganizationNamePartType("SUFFIX", "suffix");

	private final String value;

    private OrganizationNamePartType(String name, String value) {
        super(name);
		this.value = value;
    }
    
    /**
     * <p>Returns the value of this enum.
     * 
     * @return the value
     */
    public String getValue() {
        return this.value;
    }
}
