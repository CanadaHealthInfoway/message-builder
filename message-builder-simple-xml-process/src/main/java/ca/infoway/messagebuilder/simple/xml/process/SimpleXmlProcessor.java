package ca.infoway.messagebuilder.simple.xml.process;

import java.io.IOException;

import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.simple.xml.MarshallingException;

public interface SimpleXmlProcessor {
	public String process(String input) throws IOException, MarshallingException, SAXException;
}
