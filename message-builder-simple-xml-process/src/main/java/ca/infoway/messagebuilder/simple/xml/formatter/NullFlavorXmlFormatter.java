package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class NullFlavorXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected NullFlavorXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public NullFlavor format(FormatContext formatContext, Element value) throws FormatterException {
		String valueAttribute = value.getAttribute("value");
		NullFlavor nullFlavor = CodeResolverRegistry.lookup(NullFlavor.class, valueAttribute);
		if (nullFlavor == null) {
			processError(formatContext, "Null flavor \"" + valueAttribute + "\" does not appear to be valid", value);
			return NullFlavor.NO_INFORMATION;
		} else {
			return nullFlavor;
		}
	}
}
