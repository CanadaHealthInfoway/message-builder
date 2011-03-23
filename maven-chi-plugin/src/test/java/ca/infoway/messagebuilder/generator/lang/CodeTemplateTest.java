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
