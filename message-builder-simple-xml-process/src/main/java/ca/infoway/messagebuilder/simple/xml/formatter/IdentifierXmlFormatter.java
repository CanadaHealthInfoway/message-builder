package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.apache.commons.lang.StringUtils.trimToNull;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class IdentifierXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected IdentifierXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public II format(FormatContext formatContext, Element value) throws FormatterException {
		String root = value.getAttribute("root");
		String extension = value.getAttribute("extension");
	
		// numerous validations done in IiElementParser are _not_ duplicated here - formatter will hopefully catch for now,
		// and we can refactor out common validation at a later date
		
		if (StringUtils.isBlank(root)) {
			processError(formatContext, "Mandatory attribute \"root\" not provided", value);
			return null;
		} else {
			return new IIImpl(new Identifier(root, trimToNull(extension)));
		}
	}
}
