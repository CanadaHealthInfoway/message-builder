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
 * Last modified: $LastChangedDate: 2014-02-18 12:27:45 -0500 (Tue, 18 Feb 2014) $
 * Revision:      $LastChangedRevision: 8402 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.platform.DateFormatUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Parses a TS element into a Date (R2). The element looks like this:
 *
 * &lt;element-name value="formatteddate" /&gt;
 *
 * If a date is null, value is replaced by a null flavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TS", "SXCM<TS>"})
public class TsR2ElementParser extends AbstractSingleElementParser<MbDate> {

	private final SxcmR2ElementParserHelper sxcmHelper = new SxcmR2ElementParserHelper();
	
	public TsR2ElementParser() {
	}

	@Override
	protected MbDate parseNonNullNode(ParseContext context, Node node, BareANY bareAny, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element element = (Element) node;
		MbDate result = null;
		String unparsedDate = getAttributeValue(node, "value");
		if (StringUtils.isBlank(unparsedDate)) {
       		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Timestamp value must be non-blank.", element));
		} else {
            try {
                Date parsedDate = parseDate(unparsedDate, getAllDateFormats(context), context);
				result = (parsedDate == null ? null : new MbDate(parsedDate));
            } catch (IllegalArgumentException e) {
           		String message =
           			"The timestamp " + unparsedDate + " in element " +  XmlDescriber.describeSingleElement(element) + " cannot be parsed.";
            	xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, element));
            }
            this.sxcmHelper.handleOperator(element, context, xmlToModelResult, (ANYMetaData) bareAny);
		}
		return result;
	}

	private String[] getAllDateFormats(ParseContext context) {
		// use R020403 as it has no restrictions (and for R2, the acceptable date formats appear to be wide open)
		return TsDateFormats.getAllDateFormats(StandardDataType.TS_DATETIME, SpecificationVersion.R02_04_03);
	}

    /**
     * Adapted from org.apache.commons.lang.time.DateUtils, but leniency is turned off.
     */
    private Date parseDate(String str, String[] parsePatterns, ParseContext context) {
    	String dateString = standardizeDate(str);
    	boolean dateModified = !StringUtils.equals(str, dateString);
        for (int i = 0; i < parsePatterns.length; i++) {
        	String pattern = parsePatterns[i];
			if (DateFormatUtil.isMatchingPattern(dateString, pattern)) {
				Date date = DateFormatUtil.parse(dateString, pattern, getTimeZone(context));
				pattern = expandPatternIfNecessary(pattern, dateModified);
				// SPD: wrap the date in our own Date to remember the chosen parsePattern with the Date
            	return new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(date, pattern);
        	}
        }
        throw new IllegalArgumentException("Unable to parse the date: " + str);
    }

	private String expandPatternIfNecessary(String pattern, boolean dateModified) {
		// TM - do not expand the date pattern if it was not changed
		if (dateModified) {
			pattern = (TsDateFormats.expandedFormats.containsKey(pattern) ? TsDateFormats.expandedFormats.get(pattern) : pattern);
		}
		return pattern;
	}

	private TimeZone getTimeZone(ParseContext context) {
		TimeZone timeZone = null;
		if (noTimeZonesProvided(context)) {
			timeZone = TimeZone.getDefault();
		} else {
			timeZone = getNonNullTimeZone(context.getDateTimeTimeZone());
		}
		return timeZone;
	}

	private boolean noTimeZonesProvided(ParseContext context) {
		return context == null ||
				(context.getDateTimeZone() == null && context.getDateTimeTimeZone() == null);
	}

	private TimeZone getNonNullTimeZone(TimeZone timeZone) {
		return timeZone == null ? TimeZone.getDefault() : timeZone;
	}

    /*
     * If an incoming date looks like 20080331155857.8620-0400, we have problems. Since there isn't anything more
     * precise than milliseconds, the parse utilities can't handle parsing a date that looks like this. So we
     * look for this pattern and remove the 4th digit from the input string.
     */
	private String standardizeDate(String inputDate) {
		String result = inputDate;

		int decimalPointIndex = inputDate.indexOf('.');
		int timezoneDelimiterIndex = inputDate.indexOf('-');
		if (timezoneDelimiterIndex < 0) {
			timezoneDelimiterIndex = inputDate.indexOf('+');
		}

		if (decimalPointIndex >= 0 && timezoneDelimiterIndex >= 0 && timezoneDelimiterIndex > decimalPointIndex) {
			String upToDecimalPoint = inputDate.substring(0, decimalPointIndex + 1);
			String partialSeconds = inputDate.substring(decimalPointIndex + 1, timezoneDelimiterIndex);
			String timezone = inputDate.substring(timezoneDelimiterIndex);

			if (StringUtils.isNumeric(partialSeconds) && partialSeconds.length() > 3) {
				result = upToDecimalPoint + partialSeconds.substring(0, 3) + timezone;
			}
		}
		return result;
	}


	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TS_R2Impl();
	}
}