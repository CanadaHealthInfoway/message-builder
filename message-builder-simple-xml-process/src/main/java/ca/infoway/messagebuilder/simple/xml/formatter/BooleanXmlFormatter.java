package ca.infoway.messagebuilder.simple.xml.formatter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class BooleanXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected BooleanXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	private static List<String> VALID_BOOLEAN_STRINGS = new ArrayList<String>();
	
	static {
		VALID_BOOLEAN_STRINGS.add("true");
		VALID_BOOLEAN_STRINGS.add("false");
	}

	public BL format(FormatContext formatContext, Element value) throws FormatterException {
		BL result = null;
		Boolean parsedBoolean = parseBooleanValue(value.getTextContent(), value, formatContext);
		if (parsedBoolean != null) {
			result = new BLImpl(parsedBoolean);
		}
		return result;
	}
	
	public Boolean parseBooleanValue(String unparsedBoolean, Element element, FormatContext formatContext) throws FormatterException {
		if (StringUtils.isBlank(unparsedBoolean)) {
			processError(formatContext, "No value provided for boolean", element);
			return null;
		} else if (VALID_BOOLEAN_STRINGS.contains(unparsedBoolean.toLowerCase())) {
			// decided not to record warning in this case (unlike BlElementParser, which warns if case is not matching for boolean values)
			return Boolean.valueOf(unparsedBoolean.toLowerCase());
		} else {
			processError(formatContext, "Invalid value provided for boolean", element);
			return null;
		}
	}

}
