package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum for telecom address uses. Used mainly within tests. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class TelecommunicationAddressUse extends EnumPattern implements Describable, 
		ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse {
    private static final long serialVersionUID = -3649151061999838824L;
	public static final TelecommunicationAddressUse HOME = new TelecommunicationAddressUse("HOME", "H");
    public static final TelecommunicationAddressUse PRIMARY_HOME = new TelecommunicationAddressUse("PRIMARY_HOME", "HP"); 
    public static final TelecommunicationAddressUse VACATION_HOME = new TelecommunicationAddressUse("VACATION_HOME", "HV"); 
    public static final TelecommunicationAddressUse WORKPLACE = new TelecommunicationAddressUse("WORKPLACE", "WP"); 
    public static final TelecommunicationAddressUse DIRECT = new TelecommunicationAddressUse("DIRECT", "DIR"); 
    public static final TelecommunicationAddressUse PUBLISHED = new TelecommunicationAddressUse("PUBLISHED", "PUB"); 
    public static final TelecommunicationAddressUse BAD = new TelecommunicationAddressUse("BAD", "BAD"); 
    public static final TelecommunicationAddressUse TEMPORARY = new TelecommunicationAddressUse("TEMPORARY", "TMP"); 
    public static final TelecommunicationAddressUse ANSWERING_MACHINE = new TelecommunicationAddressUse("ANSWERING_MACHINE", "AS");
    public static final TelecommunicationAddressUse EMERGENCY_CONTACT = new TelecommunicationAddressUse("EMERGENCY_CONTACT", "EC"); 
    public static final TelecommunicationAddressUse MOBILE = new TelecommunicationAddressUse("MOBILE", "MC"); 
    public static final TelecommunicationAddressUse PAGER = new TelecommunicationAddressUse("PAGER", "PG");

    private final String codeValue;

    private TelecommunicationAddressUse(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * <p>Returns the code system for this telecom address use.
     * 
     * @return the code system for this telecom address use
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_TELECOMMUNICATION_ADDRESS_USE.getRoot();
    }

    /**
     * <p>Returns the code for this telecome address use.
     * 
     * @return the code for this telecome address use.
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * <p>Returns a description of this telecom address use.
     *  
     * @return a description of this telecom address use. 
     */
    public String getDescription() {
        return DescribableUtil.getDefaultDescription(name());
    }
}
