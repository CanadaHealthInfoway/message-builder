package ca.infoway.messagebuilder.lang;

import org.apache.commons.lang.math.NumberUtils;

/**
 * 
 * @author administrator
 * @sharpen.ignore
 */
public class NumberUtil {
	
	public static boolean isNumber(String numberAsString) {
		try {
			Number number = NumberUtils.createNumber(numberAsString);
			return number != null;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isInteger(String numberAsString) {
		try {
			Number number = NumberUtils.createNumber(numberAsString);
			return number != null && number instanceof Integer;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static Integer parseAsInteger(String numberAsString) {
		Number number = NumberUtils.createNumber(numberAsString);
		return number == null ? null : number.intValue();
	}
}
