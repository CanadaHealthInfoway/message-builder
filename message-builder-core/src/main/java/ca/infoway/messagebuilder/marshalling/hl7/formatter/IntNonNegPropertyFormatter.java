package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * INT.NONNEG - Integer (Non-negative)
 *
 * Represents a INT.NONNEG object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 *
 * The INT.NONNEG variant defined by CeRx cannot contain negative values. CeRx also defines
 * a maximum length of 10, which is not enforced by this class.
 */
@DataTypeHandler("INT.NONNEG")
class IntNonNegPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

	@Override
    protected String getValue(Integer integer, VersionNumber version) throws ModelToXmlTransformationException {
        if (integer==null || integer.intValue() < 0) {
        	return "0";
        } else {
        	return integer.toString();
        }
    }
    
    @Override
    boolean isInvalidValue(FormatContext context, Integer integer) {
    	return integer==null || integer.intValue() < 0;
    }

	@Override
	protected String createWarningText(FormatContext context, Integer t) {
		return "Value " + t + " should be non-negative.";
	}
}
