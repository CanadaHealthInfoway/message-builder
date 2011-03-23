package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * BL - Boolean
 *
 * Formats a Boolean into a BL element. The element looks like this:
 *
 * &lt;element-name value="true"/&gt;		&lt;!-- or value="false" --&gt;
 *
 * If a Boolean is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-BL
 */
@DataTypeHandler("BL")
class BlPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Boolean> {

	@Override
	protected String getValue(Boolean booleanValue, VersionNumber version) {
		return booleanValue.booleanValue() ? "true" : "false"; 
	}
}
