/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractValueNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.platform.DateFormatUtil;

/**
 * TS (R2) - Timestamp
 *
 * Represents a TS object as an element:
 *
 * &lt;element-name value="yyyyMMddHHmmss"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TS", "SXCM<TS>"})
public class TsR2PropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Date> {

	public static final String DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME = "messagebuilder.date.format.override.";
	
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ = "yyyyMMddHHmmss.SSS0ZZZZZ";

    private final SxcmR2PropertyFormatterHelper sxcmHelper = new SxcmR2PropertyFormatterHelper();
    
    @Override
    public String getValue(Date date, FormatContext context, BareANY bareAny) {
    	// write out the date using the "full" pattern; clients can override this using a system property or a DateWithPattern date
    	VersionNumber version = getVersion(context);
    	String datePattern = determineDateFormat(date, version);
		validateDatePattern(datePattern, context);
		TimeZone timeZone = context != null && context.getDateTimeTimeZone() != null ? context.getDateTimeTimeZone() : TimeZone.getDefault();
		return DateFormatUtil.format(date, datePattern, timeZone);
    }
    
    @Override
    protected void addOtherAttributesIfNecessary(Date v, Map<String, String> attributes, FormatContext context,	BareANY bareAny) {
    	this.sxcmHelper.handleOperator(attributes, context, (ANYMetaData) bareAny);
    }

	private void validateDatePattern(String datePattern, FormatContext context) {
		String[] allowedDateFormats = TsDateFormats.getAllDateFormats(StandardDataType.TS_DATETIME, context.getVersion());
		if (!arrayContains(allowedDateFormats, datePattern)) {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("Unknown date format {0} supplied for value of type {1}", datePattern, context == null ? "TS" : context.getType()),
							context.getPropertyPath()
							));
		}
	}

	private boolean arrayContains(String[] allowedDateFormats, String datePattern) {
        for (int i = 0; i < allowedDateFormats.length; i++) {
            if (allowedDateFormats[i].equals(datePattern)) {
                return true;
            }
        }
        return false;
	}

	// package level for testing purposes
	String determineDateFormat(Date date, VersionNumber version) {
		// date format precedence:
		//    provided Date is a dateWithPattern
		//    format has been overridden for this version
		//    default format for version/specializationType
    	String datePattern = getPatternFromDateWithPattern(date);
    	if (datePattern == null) {
    		datePattern = getOverrideDatePattern(version);
    		if (datePattern == null) {
    			datePattern = DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ;
    		}
    	}
		return datePattern;
	}

	private String getOverrideDatePattern(VersionNumber version) {
		if (version == null) {
			return null;
		}
		return System.getProperty(DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral());
	}

	private String getPatternFromDateWithPattern(Date date) {
		if (date instanceof ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern) {
			return ((ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern)date).getDatePattern();
		}
		return null;
	}

	private VersionNumber getVersion(FormatContext context) {
		return context == null ? null : context.getVersion();
	}

}
