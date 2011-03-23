package ca.infoway.messagebuilder.simple.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.datatype.StandardDataType;

public class FormatterContextImpl implements FormatContext {

	private StandardDataType type;
	private Class<?> expectedReturnType;

	private List<ErrorMessage> errors = Collections.synchronizedList(new ArrayList<ErrorMessage>());
	
	public FormatterContextImpl() {
	}
	
	public FormatterContextImpl(StandardDataType type, Class<?> expectedReturnType) {
		this.type = type;
		this.expectedReturnType = expectedReturnType;
	}
	
	public List<ErrorMessage> getErrors() {
		return this.errors;
	}

	public StandardDataType getType() {
		return this.type;
	}

	public Class<?> getExpectedReturnType() {
		return this.expectedReturnType;
	}

	public boolean matchesType(StandardDataType type) {
		boolean matches = false;
		if (this.type != null) {
			matches = this.type.equals(type);
		}
		return matches;
	}

}
