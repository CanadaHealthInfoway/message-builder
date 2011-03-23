package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.GeneratorException;

/**
 * <p>A standard interface to describe a component that writes out the definition
 * of a message type.  There are multiple "formats" that we can use to write the 
 * message type: Java classes, .Net classes or XML XSDs.  Each format has a corresponding
 * Type Writer implementation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Hl7TypeWriter {
	public void write(Writer writer) throws IOException, GeneratorException;
}