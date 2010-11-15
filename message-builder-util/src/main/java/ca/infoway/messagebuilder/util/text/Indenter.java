package ca.infoway.messagebuilder.util.text;

import java.io.IOException;
import java.io.Writer;

/**
 * <p>This class provides basic functionality related to writing out the 
 * type of indentation you see in source code.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Indenter {

	private static final String INDENT = "  ";
	
    /**
     * <p>Write an indent to a StringBuffer.
     * 
     * @param buffer - the StringBuffer to which the tabs are written.
     * @param indentLevel - the number of "tabs" to indent
     */
	public static void indentBuffer(StringBuffer buffer, int indentLevel) {
		for (; indentLevel > 0; indentLevel--) {
			buffer.append(INDENT);
		}
	}
    /**
     * <p>Write an indent to a StringBuilder.
     * 
     * @param builder - the StringBuilder to which the tabs are written.
     * @param indentLevel - the number of "tabs" to indent
     */
	public static void indentBuilder(StringBuilder builder, int indentLevel) {
		for (; indentLevel > 0; indentLevel--) {
			builder.append(INDENT);
		}
	}
    /**
     * <p>Write an indent to a string.
     * 
     * @param string - the string to which the tabs are written.
     * @param indentLevel - the number of "tabs" to indent
     * @return the indented string
     */
	public static String indent(String string, int indentLevel) {
		StringBuilder builder = new StringBuilder();
		indentBuilder(builder, indentLevel);
		builder.append(string);
		return builder.toString();
	}

    /**
     * <p>Write an indent to a Writer.
     * 
     * @param indentLevel - the number of "tabs" to indent
     * @param writer - the Writer to which the tabs are written.
     */
    protected void indent(int indentLevel, Writer writer) throws IOException {
        for (; indentLevel > 0; indentLevel--) {
            writer.write(INDENT);
        }
    }
}
