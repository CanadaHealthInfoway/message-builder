package ca.infoway.messagebuilder.platform;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

/**
 * @sharpen.ignore platform
 */
public class NumberFormatter {
	
	public String format(BigDecimal b, int maxLength, int maxNumberOfDecimals, boolean padFractions) {
		String base = StringUtils.repeat(padFractions ? "0" : "#", maxNumberOfDecimals);
		String pattern = StringUtils.leftPad("0." +  base, maxLength, '#');
		DecimalFormat format = new DecimalFormat(pattern);
		format.setMaximumIntegerDigits(maxLength - maxNumberOfDecimals - 1); 
		return format.format(b);
	}
}
