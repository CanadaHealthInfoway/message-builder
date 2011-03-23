package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.platform.DateFormatUtil;

/**
 * TS.FULLDATE - Timestamp (fully-specified date only)
 *
 * Represents a TS.FULLDATE object as an element:
 *
 * &lt;element-name value="yyyyMMdd"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TS.FULLDATE", "TS.DATE"})
public class TsFullDatePropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Date> {

    private final static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    @Override
    protected String getValue(Date date, VersionNumber version) {
    	return DateFormatUtil.format(date, DATE_FORMAT_YYYYMMDD);
    }
}
