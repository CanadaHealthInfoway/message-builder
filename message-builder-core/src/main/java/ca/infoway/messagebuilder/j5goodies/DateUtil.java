package ca.infoway.messagebuilder.j5goodies;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>A class that provides some utilities for date manipulation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class DateUtil {
    
    private static DateUtilThreadLocal instances = new DateUtilThreadLocal() {
    };
    
    static class DateUtilThreadLocal extends ThreadLocal<Map<String, DateFormat>> {
        @Override
        protected Map<String, DateFormat> initialValue() {
            return new HashMap<String, DateFormat>();
        }
    }
    

    /**
     * <p>Get a date format instance.  This method ensures that the instance is local to
     * a thread, to compensate for the fact that DateFormats aren't thread-safe.
     * 
     * @param pattern - the date format pattern.
     * @return - the Date format.
     */
    public static DateFormat instance(String pattern) {
        Map<String, DateFormat> map = DateUtil.instances.get();
        if (!map.containsKey(pattern)) {
            map.put(pattern, new SimpleDateFormat(pattern));
        }
        return map.get(pattern);
    }

    /**
     * <p>Construct a date.
     * @param year - the year
     * @param zeroBasedMonth - the month (e.g. Calendar.JANUARY)
     * @param day - the day of the month
     * @return - the date.
     */
    public static Date getDate(int year, int zeroBasedMonth, int day) {
    	return new GregorianCalendar(year, zeroBasedMonth, day).getTime();
    }
    /**
     * <p>Construct a date.
     * @param year - the year
     * @param zeroBasedMonth - the month (e.g. Calendar.JANUARY)
     * @param day - the day of the month
     * @param hour - the hour in 24-hour notation
     * @param minute - the minute
     * @param second - the second
     * @param subsecond TODO
     * @return - the date.
     */
    public static Date getDate(int year, int zeroBasedMonth, int day, int hour, int minute, int second, int subsecond) {
    	GregorianCalendar calendar = new GregorianCalendar(year, zeroBasedMonth, day, hour, minute, second);
        calendar.set(Calendar.MILLISECOND, subsecond);
		return calendar.getTime();
    }
    /**
     * <p>Get the very last millisecond of the day.
     * @param date - the day
     * @return - the last millisecond of the day.
     */
    public static Date getEndOf(Date date) {
        Date result = null;
        if (date != null) {
            String yyyymmdd = instance("yyyy-M-d").format(date);
            try {
                result = instance("yyyy-M-d-HH:mm:ss.SSS").parse(yyyymmdd + "-23:59:59.999");
            } catch (ParseException e) {
            }
        }
        return result;
    }
    /**
     * <p>Get the very first millisecond of the day.
     * @param date - the day
     * @return - the first millisecond of the day.
     */
    public static Date getStartOf(Date date) {
        Date result = null;
        if (date != null) {
            String yyyymmdd = instance("yyyy-M-d").format(date);
            try {
                result = instance("yyyy-M-d-HH:mm:ss.SSS").parse(yyyymmdd + "-00:00:00.000");
            } catch (ParseException e) {
            }
        }
        return result;
    }

}
