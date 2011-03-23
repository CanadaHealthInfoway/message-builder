package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_TimeUnitsOfMeasure;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum to handle basic time units.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class DefaultTimeUnit extends EnumPattern implements DateConverter, x_TimeUnitsOfMeasure {
	
	private static final long serialVersionUID = 3134130558551921271L;
	
	public static final DefaultTimeUnit YEAR = new DefaultTimeUnit("YEAR", "a", DateUtils.MILLIS_PER_DAY * 365); 
	public static final DefaultTimeUnit MONTH = new DefaultTimeUnit("MONTH", "mo", DateUtils.MILLIS_PER_DAY * 30); 
	public static final DefaultTimeUnit WEEK = new DefaultTimeUnit("WEEK", "wk", DateUtils.MILLIS_PER_DAY * 7);
	public static final DefaultTimeUnit SECOND = new DefaultTimeUnit("SECOND", "s", DateUtils.MILLIS_PER_SECOND); 
	public static final DefaultTimeUnit MINUTE = new DefaultTimeUnit("MINUTE", "min", DateUtils.MILLIS_PER_MINUTE); 
	public static final DefaultTimeUnit HOUR = new DefaultTimeUnit("HOUR", "h", DateUtils.MILLIS_PER_HOUR);
	public static final DefaultTimeUnit DAY = new DefaultTimeUnit("DAY", "d", DateUtils.MILLIS_PER_DAY);

    private final String codeValue;
	private final long conversion;

	private DefaultTimeUnit(String name, String codeValue, long conversion) {
		super(name);
		this.codeValue = codeValue;
		this.conversion = conversion;
    }
	
	/**
	 * <p>Returns the code system for uniform unit of measure.
	 * 
	 * @return the code system for uniform unit of measure.
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot();
	}

	/**
	 * <p>Returns the code value.
	 * 
	 * @return the code value
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * <p>Converts the given value into milliseconds.
	 *  
	 * @param value the value to convert
	 * @return the given value in milliseconds. 
	 */
	public long toMilliseconds(int value) {
		return this.conversion * value;
	}
	
	/**
	 * <p>Converts the given BigDecimal into milliseconds.
	 *  
	 * @param quantity the BigDecimal to convert. 
	 * @return the given value in milliseconds. 
	 */
	public long toMilliseconds(BigDecimal quantity) {
		return quantity == null ? null : quantity.multiply(new BigDecimal(this.conversion)).longValue();
	}
	
	/**
	 * <p>Returns the DefaultTimeUnit that is applicable for the given unit code value.
	 * 
	 * @param unitCodeValue the unit code value
	 * @return the DefaultTimeUnit that is applicable for the given unit code value
	 */
	public static DefaultTimeUnit lookup(String unitCodeValue) {
		DefaultTimeUnit result = null;
		for (DefaultTimeUnit unit : values(DefaultTimeUnit.class)) {
			if (StringUtils.equals(unitCodeValue, unit.getCodeValue())) {
				result = unit;
				break;
			}
		}
		return result;
	}
}
