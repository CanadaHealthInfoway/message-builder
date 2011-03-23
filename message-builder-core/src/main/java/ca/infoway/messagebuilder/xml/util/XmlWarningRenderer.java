package ca.infoway.messagebuilder.xml.util;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.util.text.Indenter;

/**
 * <p>A utility to format a valid XML comment, used for displaying 
 * XML warnings.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlWarningRenderer {
	
	public String createWarning(int indentLevel, String text) {
		return Indenter.indent(
				"<!-- WARNING: " + XmlStringEscape.escape(text) 
				+ " -->" + LINE_SEPARATOR, indentLevel);
	}
}
