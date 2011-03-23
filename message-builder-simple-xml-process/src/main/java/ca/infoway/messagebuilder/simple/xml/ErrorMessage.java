package ca.infoway.messagebuilder.simple.xml;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class ErrorMessage {

	private final String message;
	private final String xpath;

	public ErrorMessage(String message, Element value) {
		this.message = message;
		this.xpath = XmlDescriber.describePath(value);
	}

	public String getMessage() {
		return this.message;
	}

	public String getXpath() {
		return this.xpath;
	}

}
