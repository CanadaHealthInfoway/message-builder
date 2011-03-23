package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.RealConfFormat;
import ca.infoway.messagebuilder.marshalling.hl7.RealFormat;
import ca.infoway.messagebuilder.platform.NumberFormatter;
/**
 * REAL.CONF - BigDecimal [0,1]
 *
 * Represents a REAL.CONF object as an element:
 *
 * &lt;element-name value="0.1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-REAL
 *
 * The REAL.CONF variant defined by CHI can only contain positive values between 0 to 1 (inclusive). CHI also 
 * defines maximum length 1 character to the left of the decimal point and 4 characters to the right.
 */
@DataTypeHandler({"REAL.CONF"})
public class RealConfPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<BigDecimal>{

	private NumberFormatter formatter = new NumberFormatter();
	private RealFormat format = new RealConfFormat();
	
	@Override
	boolean isInvalidValue(FormatContext context, BigDecimal bigDecimal) {
    	if (bigDecimal.compareTo(BigDecimal.ZERO) < 0 || bigDecimal.compareTo(BigDecimal.ONE) > 0){
    		return true;
    	} else {
    		return false;
    	}
	}
	
    @Override
    protected String getValue(BigDecimal bigDecimal, VersionNumber version) {
    	return this.formatter.format(bigDecimal, 
    			this.format.getMaxValueLength(), this.format.getMaxDecimalPartLength(), true);
    }
}
