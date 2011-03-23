package ca.infoway.messagebuilder.platform;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @sharpen.ignore platform
 */
public class DateFormatUtil {
	public static boolean isMatchingPattern(String str, String pattern) {
		ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        parser.setLenient(false);
        pos.setIndex(0);
        
        Date date = parser.parse(str, pos);
        if (date != null && pos.getIndex() == str.length() && pattern.length() == str.length()) {
        	return true;
        } else {
        	return false;
        }
	}

	public static Date parse(String dateString, String pattern) {
		ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        parser.setLenient(false);
        pos.setIndex(0);
        
        return parser.parse(dateString, pos);
	}

	public static String format(Date date, String datePattern) {
		return new SimpleDateFormat(datePattern, Locale.getDefault()).format(date);
	}

}
