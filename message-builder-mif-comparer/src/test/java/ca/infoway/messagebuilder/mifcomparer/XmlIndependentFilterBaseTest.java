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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.StringContains;
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

		List<Matcher<? super String>> stringFragments = new ArrayList<Matcher<? super String>>();
		stringFragments.add(new StringContains("Error evaluating XPath expr \"/outer(\":"));
		stringFragments.add(new StringContains("Unknown nodetype: outer"));
		Matcher<String> messageMatcher = new AllOf<String>(stringFragments);
		
		exception.expect(FatalConditionException.class);
		exception.expectMessage(messageMatcher);
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer("),								// Intentional XPath error: unmatched paren
			xml,
			xml,
			new Message[]{});
	}
}
