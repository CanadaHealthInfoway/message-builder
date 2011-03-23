package ca.infoway.messagebuilder.simple.xml.parser;

import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;

public class SimpleXmlParseContextImpl implements SimpleXmlParseContext {

	private final String elementName;
	
	public SimpleXmlParseContextImpl(String elementName) {
		this.elementName = elementName;
	}

	public String getElementName() {
		return this.elementName;
	}

}
