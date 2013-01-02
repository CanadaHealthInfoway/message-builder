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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.simple.xml.formatter;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class DateXmlFormatter extends AbstractSimpleXmlFormatter {
	
	// (almost completely) shamelessly duplicated from TsElementParser (refactor to common validator class later)

	private final Map<StandardDataType, List<String>> formats;
	
	protected DateXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
		Map<StandardDataType, List<String>> map = new LinkedHashMap<StandardDataType,List<String>>();
		map.put(StandardDataType.TS_FULLDATETIME, Arrays.asList("yyyyMMddHHmmss.SSSZZZZZ", "yyyyMMddHHmmssZZZZZ"));
		map.put(StandardDataType.TS_FULLDATE, Arrays.asList("yyyyMMdd"));
		
		ArrayList<String> arrayList = new ArrayList<String>(map.get(StandardDataType.TS_FULLDATETIME));
		arrayList.addAll(map.get(StandardDataType.TS_FULLDATE));
		map.put(StandardDataType.TS_FULLDATEWITHTIME, arrayList);
		
		map.put(StandardDataType.TS_DATE, Arrays.asList("yyyyMMdd", "yyyyMM", "yyyy"));
		map.put(StandardDataType.TS_DATETIME, Arrays.asList(
				"yyyyMMddHHmmss.SSSZZZZZ", 
				"yyyyMMddHHmmss.SSS", 
				"yyyyMMddHHmmssZZZZZ", 
				"yyyyMMddHHmmss",
				"yyyyMMddHHmmZZZZZ", 
				"yyyyMMddHHmm", 
				"yyyyMMddHHZZZZZ", 
				"yyyyMMddHH", 
				"yyyyMMddZZZZZ", 
				"yyyyMMdd", 
				"yyyyMMZZZZZ", 
				"yyyyMM", 
				"yyyyZZZZZ",
				"yyyy"));
		formats = Collections.unmodifiableMap(map);
	}

	public TS format(FormatContext formatContext, Element value) throws FormatterException {
		return new TSImpl(parseNonNullNode(formatContext, value));
	}

	private Date parseNonNullNode(FormatContext formatContext, Element element) throws FormatterException {
		Date result = null;
		String unparsedDate = element.getAttribute("value");
		if (StringUtils.isBlank(unparsedDate)) {
			processError(formatContext, "Timestamp value must be non-blank.", element);
		} else {
            try {
                result = parseDate(unparsedDate, getDateFormats(formatContext.getType()));
            } catch (ParseException e) {
                result = tryEveryFormat(formatContext, unparsedDate, element);
                if (result == null) {
	           		String message = 
	           			"The timestamp " + unparsedDate + " in element " +  XmlDescriber.describeSingleElement(element) + " cannot be parsed.";
	           		processError(formatContext, message, element);
                }
            }
		}
		return result;
	}
    
	private Date tryEveryFormat(FormatContext context, String unparsedDate, Element element) throws FormatterException {
		Date result = null;
		for (StandardDataType type : this.formats.keySet()) {
			try {
				result = parseDate(unparsedDate, getDateFormats(type));
				if (result != null) {
	           		String message = "The timestamp element %s appears to be formatted as type %s, but should be %s.";
	           		processError(
	           			context,  
	            		String.format(message, XmlDescriber.describeSingleElement(element), type.getType(), context.getType().getType()), 
	            		element);
	            	break;
				}
			} catch (ParseException e) {
			}
		}
		return result;
	}
	
	private String[] getDateFormats(StandardDataType type) {
		List<String> formats = this.formats.get(type);
		return CollectionUtils.isEmpty(formats) ? new String[0] : formats.toArray(new String[formats.size()]);
	}


    /**
     * Adapted from org.apache.commons.lang.time.DateUtils, but leniency is turned off. 
     */
    private Date parseDate(String str, String[] parsePatterns) throws ParseException {

    	String dateString = standardizeDate(str);
        SimpleDateFormat parser = null;
        ParsePosition pos = new ParsePosition(0);
        for (int i = 0; i < parsePatterns.length; i++) {
            if (i == 0) {
                parser = new SimpleDateFormat(parsePatterns[0]);
                parser.setLenient(false);
            } else {
                parser.applyPattern(parsePatterns[i]);
            }
            pos.setIndex(0);
            Date date = parser.parse(dateString, pos);
            if (date != null && pos.getIndex() == dateString.length() && parsePatterns[i].length() == dateString.length()) {
                return new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(date, parsePatterns[i]);
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    /*
     * If an incoming date looks like 20080331155857.8620-0400, Java has problems. Since there isn't anything more
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
	
	
}
