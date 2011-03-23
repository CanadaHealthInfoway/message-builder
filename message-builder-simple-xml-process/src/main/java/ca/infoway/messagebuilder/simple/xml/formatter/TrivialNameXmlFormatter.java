package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;


public class TrivialNameXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected TrivialNameXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public TN format(FormatContext formatContext, Element value) throws FormatterException {
		TN result = null;
		
		String string = value.getTextContent();
		
		if (StringUtils.isBlank(string)) {
			processError(formatContext, "No trivial name provided", value);
		} else {
			result = new TNImpl(new TrivialName(string));
		}
		
		return result;
	}
}
