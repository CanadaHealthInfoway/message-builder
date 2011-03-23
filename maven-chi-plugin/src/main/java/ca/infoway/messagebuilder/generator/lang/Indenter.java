package ca.infoway.messagebuilder.generator.lang;

import java.io.IOException;
import java.io.Writer;

/**
 * <p>This class provides basic functionality related to writing out the 
 * type of indentation you see in source code.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Indenter {
    private String indent = "    ";

    /**
     * <p>Write an indent to a StringBuilder.
     * 
     * @param indentLevel - the number of "tabs" to indent
     * @param builder - the StringBuilder to which the tabs are written.
     */
	protected void indent(int indentLevel, StringBuilder builder) {
		for (; indentLevel > 0; indentLevel--) {
			builder.append(this.indent);
		}
	}
    /**
     * <p>Write an indent to a Writer.
     * 
     * @param indentLevel - the number of "tabs" to indent
     * @param writer - the Writer to which the tabs are written.
     */
    protected void indent(int indentLevel, Writer writer) throws IOException {
        for (; indentLevel > 0; indentLevel--) {
            writer.write(this.indent);
        }
    }
}
