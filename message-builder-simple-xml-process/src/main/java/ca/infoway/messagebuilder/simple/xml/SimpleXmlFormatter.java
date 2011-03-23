package ca.infoway.messagebuilder.simple.xml;

import org.w3c.dom.Element;

public interface SimpleXmlFormatter {

    public Object format(FormatContext formatContext, Element value) throws FormatterException;
	
}
