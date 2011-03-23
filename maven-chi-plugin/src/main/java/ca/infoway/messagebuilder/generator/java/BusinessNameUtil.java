package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.StringUtils.contains;
import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.WordUtils.capitalize;

import org.apache.commons.lang.StringUtils;

public class BusinessNameUtil {

	/**
	 * <p> Takes the businessName String, removes special characters, and 
	 * whitespace--returning a CamelCase business name</p>
	 * 
	 * @param businessName
	 * @return CamelCase business name or null if businessName is empty or null
	 */
	public static String cleanUpBusinessName(String businessName) {
		if (StringUtils.isNotEmpty(businessName)) {
			String tempString = businessName;
			if (contains(tempString, ':')) {
				tempString = substringAfterLast(tempString, ":");
			}
			if (!StringUtils.isAlphaSpace(tempString)) {
				tempString = StringUtils.replace(tempString, "?", " ");
				tempString = StringUtils.replace(tempString, "-", " ");
				tempString = StringUtils.replace(tempString, ",", " ");
				tempString = StringUtils.replace(tempString, ".", " ");
				tempString = StringUtils.replace(tempString, "+", " ");
				tempString = StringUtils.replace(tempString, "(", " ");
				tempString = StringUtils.replace(tempString, ")", " ");
				tempString = StringUtils.replace(tempString, "/", " ");
				tempString = StringUtils.replace(tempString, "*", " ");
				tempString = StringUtils.replace(tempString, "'", " ");
				tempString = StringUtils.replace(tempString, "%", " ");
				tempString = StringUtils.replace(tempString, "\\u00A0", " ");
				tempString = StringUtils.replace(tempString, "\\u2007", " ");
				tempString = StringUtils.replace(tempString, "\\u202F", " ");
			}
			
			// assumes trimming will take place when converting to camel case
			tempString = toCamelCase(tempString);
			
			return tempString;
		} else {
			return null;
		}
	}

	/**
	 * <p> Takes a string and returns a CamelCase name with no whitespace</p>
	 * 
	 * @param string
	 * @return CamelCase name or null if string is empty or null
	 */	
	public static String toCamelCase(String string) {
		if (StringUtils.isNotEmpty(string)) {
			// remove unicode non-breaking spaces
			string = string.replaceAll("[\\u00A0\\u2007\\u202F]+", " ");
			string = capitalize(string);
			string = deleteWhitespace(string);
			return string;
		} else {
			return null;
		}
	}
}