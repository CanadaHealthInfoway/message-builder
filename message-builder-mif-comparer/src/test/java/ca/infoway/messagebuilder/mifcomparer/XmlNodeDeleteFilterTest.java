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

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlNodeDeleteFilterTest extends XmlFilterTest {
	@Test
	public void test_that_if_xpath_doesnt_match_then_deleter_does_nothing() throws SAXException, IOException {
		String xml = "<outer></outer>";
		
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer/nonexistent-node"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_is_deleted() throws SAXException, IOException {
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\"/></outer>",
			"<outer>                </outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_multiple_matching_elements_are_deleted() throws SAXException, IOException {
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\"/><inner a=\"c\"/><inner a=\"d\"/></outer>",
			"<outer>                                                </outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_attribute_is_deleted() throws SAXException, IOException {
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer/inner/@a"),
			"<outer><inner a=\"b\"/></outer>",
			"<outer><inner        /></outer>",
			new Message[]{});
	}

	@Test
	public void test_that_subscripted_xpath_expr_only_deletes_one_element() throws SAXException, IOException {
		performFilterTest(
			new XmlNodeDeleteFilter(null, "/outer/inner[@a='c']"),
			"<outer><inner a=\"b\"/><inner a=\"c\"/><inner a=\"d\"/></outer>",
			"<outer><inner a=\"b\"/>                <inner a=\"d\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_is_deleted_with_namespaces() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlNodeDeleteFilter(testNsContext, "/x:outer/y:inner"),
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'><x:inner a=\"b\"/><Y_ALT:inner/></x:outer>",
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'><x:inner a=\"b\"/>              </x:outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_matching_element_is_deleted_with_default_namespace() throws SAXException, IOException {
		// Like the preceding case, except that this time the document binds that URI to the default namespace ("xmlns=...").
		performFilterTest(
			new XmlNodeDeleteFilter(testNsContext, "/x:outer/y:inner"),
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns='http://www.example.com/ns/y'><x:inner a=\"b\"/><inner/></x:outer>",
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns='http://www.example.com/ns/y'><x:inner a=\"b\"/>        </x:outer>",
			new Message[]{});
	}
}
