package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

interface MethodBody {
	String getBodyFormat(ProgrammingLanguage builder);
}
