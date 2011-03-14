package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.DateFormatUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Parses a TS element into a Date. The element looks like this:
 * 
 * <element-name value="formatteddate" />
 * 
 * If a date is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler("TS")
class TsElementParser extends AbstractSingleElementParser<Date> {
	
	private final Map<StandardDataType, List<String>> formats;
	private final Map<String, Map<StandardDataType, List<String>>> versionFormatExceptions;
	
	public TsElementParser() {
		Map<StandardDataType, List<String>> map = new LinkedHashMap<StandardDataType,List<String>>();
		map.put(StandardDataType.TS_FULLDATETIME, Arrays.asList(
				"yyyyMMddHHmmss.SSSZZZZZ", 
				"yyyyMMddHHmmssZZZZZ"
				));
		// this is an abstract type and these formats are only used after issuing a warning (there should be a specializationType)
		map.put(StandardDataType.TS_FULLDATEWITHTIME, Arrays.asList(
				"yyyyMMddHHmmss.SSSZZZZZ", 
				"yyyyMMddHHmmssZZZZZ",
				"yyyyMMdd"
				));
		map.put(StandardDataType.TS_FULLDATE, Arrays.asList(
				"yyyyMMdd"
				));
		map.put(StandardDataType.TS_DATE, Arrays.asList(
				"yyyyMMdd", 
				"yyyyMM", 
				"yyyy"));
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
		map.put(StandardDataType.TS, 
				map.get(StandardDataType.TS_DATETIME));
		
		this.formats = Collections.unmodifiableMap(map);

		// some older versions have slightly different rules for allowable time formats
		
		Map<StandardDataType, List<String>> exceptionMapV02R01 = new LinkedHashMap<StandardDataType,List<String>>();
		exceptionMapV02R01.put(StandardDataType.TS_FULLDATEWITHTIME, Collections.<String>emptyList());
		
		Map<StandardDataType, List<String>> exceptionMapV01R04_3 = new LinkedHashMap<StandardDataType,List<String>>();
		exceptionMapV01R04_3.put(StandardDataType.TS_FULLDATEWITHTIME, Collections.<String>emptyList());
		exceptionMapV01R04_3.put(StandardDataType.TS_FULLDATETIME, Arrays.asList("yyyyMMddHHmmss"));
		exceptionMapV01R04_3.put(StandardDataType.TS_DATETIME, Arrays.asList(
				"yyyyMMddHHmmss",
				"yyyyMMddHHmm", 
				"yyyyMMddHH", 
				"yyyyMMdd", 
				"yyyyMM", 
				"yyyy"));
		
		Map<String, Map<StandardDataType, List<String>>> versionMap = new HashMap<String, Map<StandardDataType,List<String>>>();
		versionMap.put(SpecificationVersion.V02R01.getVersionLiteral(), Collections.unmodifiableMap(exceptionMapV02R01));
		versionMap.put(SpecificationVersion.V01R04_3.getVersionLiteral(), Collections.unmodifiableMap(exceptionMapV01R04_3));

		this.versionFormatExceptions = Collections.unmodifiableMap(versionMap);
	}
	
	@Override
	protected Date parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		if (isAbstractFullDateWithTime(context)) {
			context = handleSpecializationType(context, node, xmlToJavaResult);
		}
		return parseNonNullNode(context, (Element) node, xmlToJavaResult);
	}

	private ParseContext handleSpecializationType(ParseContext context, Node node, XmlToModelResult xmlToJavaResult) {
		String specializationType = getAttributeValue(node, SPECIALIZATION_TYPE);
		if (specializationType == null) {
			// TM - RedMine issue 492 - there is some concern over MBT forcing a specialization type for abstract TS types
			//    - I'm relaxing this validation for the time being (the formatter currently ignores specialization type completely)
			// do nothing - fall back to parsing through all allowable date formats for TS.FULLDATEWITHTIME
			// xmlToJavaResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(SPECIALIZATION_TYPE, (Element) node));
		} else if (isValidType(specializationType)) {
			context = ParserContextImpl.create(specializationType, context.getExpectedReturnType(), context.getVersion(), context.getConformance());
		} else {
		    xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
		    		"Invalid specialization type " + specializationType + " (" + XmlDescriber.describeSingleElement((Element) node)
		    		+ ")"));
		}
		return context;
	}

	private boolean isValidType(String specializationType) {
		StandardDataType type = StandardDataType.getByTypeName(specializationType);
		return StandardDataType.TS_FULLDATE.equals(type) || StandardDataType.TS_FULLDATETIME.equals(type);
	}

	private boolean isAbstractFullDateWithTime(ParseContext context) {
		return StandardDataType.TS_FULLDATEWITHTIME.equals(StandardDataType.getByTypeName(context));
	}

	// FIXME - TM - for V02R01, "width" property is allowed (PQ.TIME) - need to add support?
	private Date parseNonNullNode(ParseContext context, Element element, XmlToModelResult xmlToJavaResult) {
		Date result = null;
		String unparsedDate = getAttributeValue(element, "value");
		if (StringUtils.isBlank(unparsedDate)) {
       		xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
       				"Timestamp value must be non-blank.", element));
		} else {
            try {
                result = parseDate(unparsedDate, getAllDateFormats(context));
            } catch (IllegalArgumentException e) {
                result = tryEveryFormat(context, unparsedDate, element, xmlToJavaResult);
                if (result == null) {
	           		String message = 
	           			"The timestamp " + unparsedDate + " in element " +  XmlDescriber.describeSingleElement(element) + " cannot be parsed.";
	            	xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, element));
                }
            }
		}
		return result;
	}
    
	private Date tryEveryFormat(ParseContext context, String unparsedDate, Element element, XmlToModelResult xmlToJavaResult) {
		Date result = null;
		for (StandardDataType type : this.formats.keySet()) {
			try {
				result = parseDate(unparsedDate, getDateFormatsForOtherType(type, context));
				if (result != null) {
	           		String message = 
	           			"The timestamp element {0} appears to be formatted as type {1}, but should be {2}.";
	            	xmlToJavaResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
	            			MessageFormat.format(message, XmlDescriber.describeSingleElement(element), type.getType(), context.getType()), 
	            			element));
	            	break;
				}
			} catch (IllegalArgumentException e) {
			}
		}
		return result;
	}


	private String[] getDateFormatsForOtherType(StandardDataType type, ParseContext context) {
		ParseContext newContext;
		if (context == null) {
			newContext = ParserContextImpl.create(type == null ? null : type.getType(), null, null, null, null, null);
		} else {
			newContext =  ParserContextImpl.create(type == null ? null : type.getType(), context.getExpectedReturnType(), context.getVersion(), context.getConformance());
		}
		return getAllDateFormats(newContext);
	}


	private String[] getAllDateFormats(ParseContext context) {
		
		StandardDataType standardDataType = StandardDataType.getByTypeName(context);		

		Map<StandardDataType, List<String>> exceptionMap = this.versionFormatExceptions.get(context == null ? null : context.getVersion());

		List<String> formats = (exceptionMap == null ? null : exceptionMap.get(standardDataType));
		if (formats == null) {
			formats = this.formats.get(standardDataType);
		}
		
		return CollectionUtils.isEmpty(formats) ? new String[0] : formats.toArray(new String[formats.size()]);
	}


    /**
     * Adapted from org.apache.commons.lang.time.DateUtils, but leniency is turned off. 
     */
    private Date parseDate(String str, String[] parsePatterns) {

    	String dateString = standardizeDate(str);
        for (int i = 0; i < parsePatterns.length; i++) {
        	String pattern = parsePatterns[i];
			if (DateFormatUtil.isMatchingPattern(dateString, pattern)) {
        		Date date = DateFormatUtil.parse(dateString, pattern);
        		// SPD: wrap the date in our own Date to remember the chosen parsePattern with the Date
            	return new ca.infoway.messagebuilder.datatype.lang.DateWithPattern(date, pattern);
        	}
        }
        throw new IllegalArgumentException("Unable to parse the date: " + str);
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


	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TSImpl();
	}
}