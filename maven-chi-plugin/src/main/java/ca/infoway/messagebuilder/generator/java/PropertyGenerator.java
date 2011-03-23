package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

public interface PropertyGenerator {

	public void createAttributeDefinition(int indentLevel, Writer writer) throws IOException;
	public void createGettersAndSetters(int indentLevel, Writer writer) throws IOException;
	public void createGettersAndSettersForInterface(int indentLevel, Writer writer) throws IOException;
	public void createDerivedChoiceGetterProperties(int indentLevel, Writer writer) throws IOException;
	/**
	 * <p>Create the initialization of the member variable in the class constructor.
	 * 
	 * <p>For Java classes, initialization happens at the same place as variable
	 * definition, but for .Net/C# classes, the initialization happens in the constructor.
	 * 
	 * @param indentLevel - the number of indents that the code should prefix each line with
	 * @param writer - the writer to which we write the code
	 * @throws IOException
	 */
	public void createConstructorInitialization(int indentLevel, Writer writer) throws IOException;

}