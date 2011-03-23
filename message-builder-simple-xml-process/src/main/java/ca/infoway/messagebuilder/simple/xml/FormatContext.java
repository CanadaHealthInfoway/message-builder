package ca.infoway.messagebuilder.simple.xml;

import java.util.List;

import ca.infoway.messagebuilder.datatype.StandardDataType;

public interface FormatContext {

	public List<ErrorMessage> getErrors();
	public StandardDataType getType();
	public boolean matchesType(StandardDataType type);
	public Class<?> getExpectedReturnType();
	
}
