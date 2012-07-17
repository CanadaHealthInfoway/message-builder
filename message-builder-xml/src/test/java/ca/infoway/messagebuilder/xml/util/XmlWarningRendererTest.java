package ca.infoway.messagebuilder.xml.util;

import static junit.framework.Assert.assertEquals;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

public class XmlWarningRendererTest {

	@Test
	public void shouldOutputWarning() {
		assertEquals("output text without indent", "<!-- WARNING: warning text -->" + SystemUtils.LINE_SEPARATOR, new XmlWarningRenderer().createWarning(0, "warning text"));
	}
	
	@Test
	public void shouldOutputWarningWithIndent() {
		assertEquals("output text without indent", "    <!-- WARNING: warning text -->" + SystemUtils.LINE_SEPARATOR, new XmlWarningRenderer().createWarning(2, "warning text"));
	}
	
	@Test
	public void shouldOutputWarningWithTrueProperty() {
		System.setProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML, "TrUE");
		assertEquals("output text with property true", "    <!-- WARNING: warning text -->" + SystemUtils.LINE_SEPARATOR, new XmlWarningRenderer().createWarning(2, "warning text"));
		System.clearProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML);
	}
	
	@Test
	public void shouldNotOutputWarningWithFalseProperty() {
		System.setProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML, "false");
		assertEquals("output text suppressed", "", new XmlWarningRenderer().createWarning(2, "warning text"));
		System.clearProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML);
	}
	
}
