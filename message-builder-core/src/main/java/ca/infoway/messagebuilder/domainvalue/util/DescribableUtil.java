package ca.infoway.messagebuilder.domainvalue.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.Code;

/**
 * <p>Determine a standard description of an object.
 * 
 * <p>This class is ideally designed for enums, which typically have names like 
 * <code>MY_INTERESTING_VALUE</code>.  This utility will convert the description to
 * "My interesting value".
 * 
 * @author BC Holmes
 */
public class DescribableUtil {
    
    /**
     * <p>Gets the default description.
     *
     * @param object the object
     * @return the default description
     */
    public static String getDefaultDescription(Object object) {
    	if (object == null || StringUtils.isBlank(object.toString())) {
    		return "";
    	} else {
	        String temp = object.toString().replace('_', ' ').toLowerCase();
			return temp.substring(0, 1).toUpperCase() + temp.substring(1);
    	}
    }
    
    /**
     * <p>Gets the code description.
     *
     * @param code the code
     * @return the code description
     */
    public static String getCodeDescription(Code code) {
        return WordUtils.capitalizeFully(code.getCodeValue().replace('_', ' '));    
    }
}
