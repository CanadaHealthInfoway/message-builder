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

package ca.infoway.messagebuilder.mifcomparer;

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.FILTER;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.WARNING;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.xml.sax.SAXException;

public class XmlIndependentFilterBaseTest extends XmlFilterTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_that_bogus_xpath_expr_causes_the_correct_message() throws SAXException, IOException {
		String xml = "<outer></outer>";
		
		exception.expect(FatalConditionException.class);
		exception.expectMessage("Error evaluating XPath expr \"/outer(\": Unknown nodetype: outer");
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer("),								// Intentional XPath error: unmatched paren
			xml,
			xml,
			new Message[]{});
	}
}
