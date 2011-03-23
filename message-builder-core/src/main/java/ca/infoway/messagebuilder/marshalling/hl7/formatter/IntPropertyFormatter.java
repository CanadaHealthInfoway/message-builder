package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * INT
 *
 * Represents a INT object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 */
@DataTypeHandler("INT")
class IntPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

	@Override
    protected String getValue(Integer integer, VersionNumber version) throws ModelToXmlTransformationException {
        return integer.toString();
    }
}
