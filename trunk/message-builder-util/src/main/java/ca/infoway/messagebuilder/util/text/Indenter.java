/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
