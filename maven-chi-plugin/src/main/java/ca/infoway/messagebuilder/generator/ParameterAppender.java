package ca.infoway.messagebuilder.generator;

import java.util.List;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;


interface ParameterAppender {

	public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language);
	public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language);
}
