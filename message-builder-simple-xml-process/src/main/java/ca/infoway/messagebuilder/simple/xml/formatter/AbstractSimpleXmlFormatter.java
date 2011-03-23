package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.simple.xml.ErrorMessage;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public abstract class AbstractSimpleXmlFormatter implements SimpleXmlFormatter {

	protected final FormatterConfiguration configuration;
	
	public static final String NAMESPACE = "urn:ca.infoway.messagebuilder.simplexml.v1";

	protected AbstractSimpleXmlFormatter(FormatterConfiguration configuration) {
		this.configuration = configuration;
	}
	
	void processError(FormatContext formatContext, String string, Element value) throws FormatterException {
		if (this.configuration.isPermissive()) {
			addErrorMessage(formatContext, string, value);
		} else {
			throw new FormatterException(string);
		}
	}

	private void addErrorMessage(FormatContext formatContext, String string, Element value) {
		formatContext.getErrors().add(new ErrorMessage(string, value));
	}

	protected Element getSingleElement(Element value, String tagName) throws FormatterException {
		NodeList list = value.getElementsByTagNameNS(NAMESPACE, tagName);
		if (list.getLength() > 1) {
			throw new FormatterException("Too many instances of child element " + tagName + " in " + XmlDescriber.describePath(value));
		} else if (list.getLength() == 1) {
			return (Element) list.item(0);
		} else {
			return null;
		}
	}
}
