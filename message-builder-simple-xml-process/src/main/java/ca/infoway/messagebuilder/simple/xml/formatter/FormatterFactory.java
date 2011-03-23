package ca.infoway.messagebuilder.simple.xml.formatter;

import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlFormatter;

public interface FormatterFactory {
	public SimpleXmlFormatter createFormatter(String typeName) throws FormatterException;
	public boolean isSimpleDataType(String typeName);
}
