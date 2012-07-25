/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.text.MessageFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.ArrayUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats;
import ca.infoway.messagebuilder.platform.DateFormatUtil;

/**
 * TS.FULLDATETIME - Timestamp (fully-specified date and time only) and TS.DATETIME (partial date/time)
 *
 * Represents a TS.FULLDATETIME/TS.DATETIME object as an element:
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
@DataTypeHandler({"TS.FULLDATETIME", "TS", "TS.DATETIME"})
public class TsFullDateTimePropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Date> {

	public static final String DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME = "messagebuilder.date.format.override.";
	
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ = "yyyyMMddHHmmss.SSS0ZZZZZ";

    @Override
    protected String getValue(Date date, FormatContext context) {
    	// write out the date using the applicable "full" pattern; clients can override this using a system property or a DateWithPattern date
    	VersionNumber version = getVersion(context);
    	String datePattern = determineDateFormat(date, version);
		validateDatePattern(datePattern, context);
		validateSpecializationType(date, context);
		TimeZone timeZone = context != null && context.getDateTimeTimeZone() != null ? context.getDateTimeTimeZone() : TimeZone.getDefault();
		return DateFormatUtil.format(date, datePattern, timeZone);
    }

	private void validateDatePattern(String datePattern, FormatContext context) {
		StandardDataType standardDataType = StandardDataType.getByTypeName(context);
		VersionNumber version = (context == null ? null : context.getVersion());
		String[] allowedDateFormats = TsDateFormats.getAllDateFormats(standardDataType, version);
		if (ArrayUtils.contains(allowedDateFormats, datePattern)) {
			// check if this pattern is missing a timezone
			if (!isCerx(version) && TsDateFormats.datetimeFormatsRequiringWarning.contains(datePattern)) {
				context.getModelToXmlResult().addHl7Error(
						new Hl7Error(
								Hl7ErrorCode.DATA_TYPE_ERROR, 
								MessageFormat.format("Date format {0} supplied for value of type {1} should also have a timezone (ZZZZZ)", datePattern, context == null ? "TS" : context.getType())
								));
			}
		} else {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("Invalid date format {0} supplied for value of type {1}", datePattern, context == null ? "TS" : context.getType())
							));
		}
	}

	private void validateSpecializationType(Date date, FormatContext context) {
		
		// FIXME - VALIDATION - TM - if FULLDATEWITHTIME, check that specializationType provided and that it is FULLDATE or FULLDATETIME
		//                         - this will likely cause a lot of errors to be reported; need to think about impact vs utility
		
	}

	private boolean isCerx(VersionNumber version) {
		return SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX);
	}

	// package level for testing purposes
	String determineDateFormat(Date date, VersionNumber version) {
		// date format precedence:
		//    provided Date is a dateWithPattern
		//    format has been overridden for this version
		//    default format for version
    	String datePattern = getPatternFromDateWithPattern(date);
    	if (datePattern == null) {
    		datePattern = getOverrideDatePattern(version);
    		if (datePattern == null || isFullDateSpecializationType()) {
    			datePattern = getDefaultDatePattern(version);
    		}
    	}
		return datePattern;
	}

	private boolean isFullDateSpecializationType() {
		
		// FIXME - VALIDATION - TM - check if FULLDATEWITHTIME and specializationType is FULLDATE
		
		return false;
	}

	private String getOverrideDatePattern(VersionNumber version) {
		if (version == null) {
			return null;
		}
		return System.getProperty(DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral());
	}

	private String getPatternFromDateWithPattern(Date date) {
		if (date instanceof ca.infoway.messagebuilder.datatype.lang.DateWithPattern) {
			return ((ca.infoway.messagebuilder.datatype.lang.DateWithPattern)date).getDatePattern();
		}
		return null;
	}

	private String getDefaultDatePattern(VersionNumber version) {
		if (isFullDateSpecializationType()) {
			return TsFullDatePropertyFormatter.DATE_FORMAT_YYYYMMDD;
		} else if (SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX)) {
			return DATE_FORMAT_YYYYMMDDHHMMSS;
		}
		return DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ;
	}

	private VersionNumber getVersion(FormatContext context) {
		return context == null ? null : context.getVersion();
	}

}
