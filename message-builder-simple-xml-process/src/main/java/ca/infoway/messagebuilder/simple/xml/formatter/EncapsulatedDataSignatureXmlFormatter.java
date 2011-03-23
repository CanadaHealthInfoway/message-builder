package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class EncapsulatedDataSignatureXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected EncapsulatedDataSignatureXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public ED<String> format(FormatContext formatContext, Element value) throws FormatterException {
		ED<String> result = null;
		
		String signature = (value == null ? null : value.getTextContent());
		
		if (StringUtils.isBlank(signature)) {
			processError(formatContext, "No signature value provided", value);
		} else {
			result = new EDImpl<String>(signature);
		}
		
		return result;
	}
}
