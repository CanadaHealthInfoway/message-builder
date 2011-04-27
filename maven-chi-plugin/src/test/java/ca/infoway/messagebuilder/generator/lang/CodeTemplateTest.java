/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.lang;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;


public class CodeTemplateTest {

	@Test
	public void shouldIndentEachLine() throws Exception {
		CodeTemplate template = new CodeTemplate("public {0} get{1}() '{'\n     return this.{2};\n'}'");
		
		StringWriter writer = new StringWriter();
		template.write(writer, 2, "String", "Fred", "fred");
		
		String[] lines = StringUtils.split(writer.toString(), LINE_SEPARATOR);
		for (String line : lines) {
			assertTrue(line, line.startsWith("        "));
		}
	}
	
	@Test
	public void shouldSubstitueParameters() throws Exception {
		CodeTemplate template = new CodeTemplate("public {0} get{1}() '{'\n     return this.{2};\n'}'");
		
		StringWriter writer = new StringWriter();
		template.write(writer, 2, "String", "Fred", "fred");
		
		String[] lines = StringUtils.split(writer.toString(), LINE_SEPARATOR);
		assertTrue("line 1", lines[0].contains("public String getFred() {"));
		assertTrue("line 2", lines[1].contains("return this.fred;"));
	}
	
	@Test
	public void shouldHandleWindowsLineBreaks() throws Exception {
		CodeTemplate template = new CodeTemplate("public {0} get{1}() '{'\r\n     return this.{2};\r\n'}'");
		
		StringWriter writer = new StringWriter();
		template.write(writer, 2, "String", "Fred", "fred");
		
		String[] lines = StringUtils.split(writer.toString(), LINE_SEPARATOR);
		assertEquals("number of lines", 3, lines.length);

		assertTrue("line 1", lines[0].contains("public String getFred() {"));
		assertTrue("line 2", lines[1].contains("return this.fred;"));
	}
}
