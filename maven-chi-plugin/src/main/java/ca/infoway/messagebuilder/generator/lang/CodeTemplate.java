package ca.infoway.messagebuilder.generator.lang;

import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

/**
 * <p>A class that encapsulates a code template.  Think of a code template
 * as a snippet of code that includes placeholders for specific types, 
 * variable names, etc.
 * 
 * <p>This template knows how to render itself into a few lines of code, including
 * the necessary indenting logic.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CodeTemplate extends Indenter {

	private final String[] lines;

	/**
	 * <p>Standard constructor.
	 * 
	 * @param template - the code snippet, using the <tt>MessageFormat</tt> markup notation.
	 */
	public CodeTemplate(String template) {
		this.lines = StringUtils.split(StringUtils.replace(template, "\r\n", "\n"), "\n");
	}

	/**
	 * <p>Convert the template into valid code and write the code to a writer.
	 * 
	 * @param writer - the writer to which the code will be written
	 * @param indentLevel - the number of "tabs" to indent each line.
	 * @param parameters - the parameters used to fill the template
	 * @throws IOException if the underlying writer encounters an IO problem.
	 */
	public void write(Writer writer, int indentLevel, Object... parameters) throws IOException {
		for (String line : this.lines) {
			indent(indentLevel, writer);
			writer.write(MessageFormat.format(line, parameters));
			writer.write(SystemUtils.LINE_SEPARATOR);
		}
	}
}
