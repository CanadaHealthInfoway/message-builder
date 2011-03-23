package ca.infoway.messagebuilder.util.telephone;

import org.apache.commons.lang.StringUtils;

/**
 * <p>A utility for working with telephones.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore util.telephone
 */
public class Telephone {

	private static final String EXTENSION_DELIMITER = ";ext=";
	private static final String DELIMITER = "-";
	private static final String PREFIX = "+1-";
    
    private String areaCode;
    private TelephoneLocalNumber phoneNumber = new TelephoneLocalNumber();
    private String extension;

    /**
     * <p>Default constructor.
     */
    public Telephone() {
    }
    /**
     * <p>Standard constructor.
     * @param areaCode - the area code
     * @param phoneNumber - the phone number
     */
    public Telephone(String areaCode, TelephoneLocalNumber phoneNumber) {
		this.areaCode = areaCode;
    	this.phoneNumber = phoneNumber;
    }

    /**
     * <p>Get the area code.
     * @return - the area code.
     */
    public String getAreaCode() {
        return this.areaCode;
    }
    /**
     * <p>Set the area code.
     * @param areaCode - the new value
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * <p>Get the extension.
     * @return - the extension.
     */
    public String getExtension() {
        return this.extension;
    }
    /**
     * <p>Set the extension.
     * @param extension - the new value
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * <p>Get the phone number.
     * @return - the phone number
     */
    public TelephoneLocalNumber getPhoneNumber() {
        return this.phoneNumber;
    }
    /**
     * <p>Set the phone number.
     * @param phoneNumber - the new value.
     */
    public void setPhoneNumber(TelephoneLocalNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * <p>Create a formatted version of the phone number, rendered in an HL7-compliant way.
     * @return - the formatted phone number
     */
    public String getHl7FormattedPhoneNumber() {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotBlank(this.areaCode)) {
            builder.append(PREFIX).append(this.areaCode).append(DELIMITER);
        }
        if (this.phoneNumber != null && StringUtils.isNotBlank(this.phoneNumber.getFormattedTelephoneNumber())) {
            builder.append(this.phoneNumber.getFormattedTelephoneNumber());
        }
        if (StringUtils.isNotBlank(this.extension)) {
            builder.append(EXTENSION_DELIMITER).append(this.extension);
        }
        return builder.toString();
    }
    
}
