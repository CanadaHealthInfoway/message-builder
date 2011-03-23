package ca.infoway.messagebuilder.generator.dotnet;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.java.ClassNameManager;

public interface DependencyManager extends ClassNameManager {
	public void generate(Writer writer, int indentLevel) throws IOException;	
}
