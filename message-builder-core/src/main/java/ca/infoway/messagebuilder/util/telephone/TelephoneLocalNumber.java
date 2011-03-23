package ca.infoway.messagebuilder.util.telephone;

import org.apache.commons.lang.StringUtils;

/**
 * <p>The seven-digit part of the telephone number, without area code.
 * 
 * <p>This number is stored as 1234567 but we want to display it as 123-4567
 * 
 * @sharpen.ignore util.telephone
 */
public class TelephoneLocalNumber {

    private String telephoneNumber;

    /**
     * <p>Create a telephone number from a string.
     * @param telephoneLocalNumberString - a phone number in the format (123-4567 or 1234567).
     * @return - a phone number object.
     */
    public static TelephoneLocalNumber create(String telephoneLocalNumberString) {
        TelephoneLocalNumber result = null;
        
        if (!StringUtils.isBlank(telephoneLocalNumberString)) {
            String noHyphenNumber = StringUtils.remove(telephoneLocalNumberString, '-');
            result = new TelephoneLocalNumber();
            result.setTelephoneNumber(noHyphenNumber);
        }
        
        return result;
    }
    
    /**
     * <p>Get the phone number.  The representation has no hyphen.
     * @return - the phone number
     */
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }
    /**
     * <p>Set the phone number with no hyphen.
     * @param telephoneNumber - the new value
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * <p>Provide a human-readable formatted phone number.
     * @return - the formatted phone number
     */
    public String getFormattedTelephoneNumber() {
        String result = getTelephoneNumber();
        if (result != null && result.length() == 7) {
            result = result.substring(0, 3).toUpperCase() + "-" + result.substring(3).toUpperCase();
        }
        return result;
    }
    
    /**
     * <p>Create a copy of the phone number.
     * @return - a copy of the phone number
     * 
     * @sharpen.ignore shallow clonning supported in c# out of the box.
     */
    @Override
	public TelephoneLocalNumber clone() {
        TelephoneLocalNumber clone = new TelephoneLocalNumber();
        clone.setTelephoneNumber(getTelephoneNumber());
        return clone;
    }
}
