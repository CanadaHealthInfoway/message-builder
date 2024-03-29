/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml.util;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.util.text.Indenter;

/**
 * <p>A utility to format a valid XML comment, used for displaying 
 * XML warnings.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlWarningRenderer {
	
	public static String MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML = "messagebuilder.output.warnings.in.generated.xml";
	public static String MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML_DEFAULT = "true";
	
	private boolean outputWarnings;
	
	public XmlWarningRenderer() {
		String outputWarningsPropertyValue = System.getProperty(MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML);
		if (outputWarningsPropertyValue == null) {
			outputWarningsPropertyValue = MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML_DEFAULT;
		}
		this.outputWarnings = Boolean.valueOf(outputWarningsPropertyValue);
	}
	
	public String createWarning(int indentLevel, String text) {
		return createWarning(indentLevel, text, "WARNING"); 
	}
	
	public String createWarning(int indentLevel, String text, String errorLevel) {
		return createLog(errorLevel, indentLevel, text); 
	}
	
	public String createLog(String logLevel, int indentLevel, String text) {
		return this.outputWarnings ? 
				Indenter.indent(
				"<!-- " + logLevel + (StringUtils.isBlank(logLevel) ? "" : ": ") + XmlStringEscape.escape(text) 
				+ " -->" + LINE_SEPARATOR, indentLevel)
			:
				StringUtils.EMPTY;
	}
	
}
