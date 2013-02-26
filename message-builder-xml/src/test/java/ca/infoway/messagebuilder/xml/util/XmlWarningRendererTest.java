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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-01-10 18:22:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3229 $
 */

package ca.infoway.messagebuilder.xml.util;

import static org.junit.Assert.assertEquals;

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
		System.setProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML, XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML_DEFAULT);
	}
	
	@Test
	public void shouldNotOutputWarningWithFalseProperty() {
		System.setProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML, "false");
		assertEquals("output text suppressed", "", new XmlWarningRenderer().createWarning(2, "warning text"));
		System.setProperty(XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML, XmlWarningRenderer.MESSAGEBUILDER_OUTPUT_WARNINGS_IN_GENERATED_XML_DEFAULT);
	}
	
}
