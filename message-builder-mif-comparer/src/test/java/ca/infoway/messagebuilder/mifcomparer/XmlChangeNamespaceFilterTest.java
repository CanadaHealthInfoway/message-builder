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

public class XmlChangeNamespaceFilterTest extends XmlFilterTest {
	@Test
	public void test_that_if_xpath_doesnt_match_then_filter_does_nothing() throws SAXException, IOException {
		String xml = 
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">this is <x:sub/> a test</x:inner>" +
			"</x:outer>";
		
		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/SHOULD_NOT_BE_USED", "/x:outer/x:no-such-tag"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_with_explicit_prefix_gets_its_namespace_changed() throws SAXException, IOException {
		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/y", "/x:outer/y:inner/z:sub"),

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns:z='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <z:sub/> a test</y:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns:z='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <y:sub/> a test</y:inner>" +
			"</x:outer>",

			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_in_default_namespace_gets_its_namespace_changed_when_xpath_contains_our_nsprefix_for_that_namespace() throws SAXException, IOException {
		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/y", "/x:outer/y:inner/z:sub"),

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <sub/> a test</y:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <y:sub/> a test</y:inner>" +
			"</x:outer>",

			new Message[]{});
	}
	
		@Test
	public void test_that_matching_element_in_no_namespace_gets_its_namespace_changed_when_xpath_contains_no_nsprefix() throws SAXException, IOException {
		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/y", "/x:outer/y:inner/sub"),

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner a=\"b\">this is <sub/> a test</y:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner a=\"b\">this is <y:sub/> a test</y:inner>" +
			"</x:outer>",

			new Message[]{});
	}
	
	@Test
	public void test_that_content_is_preserved_across_change() throws SAXException, IOException {
		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/x", "/x:outer/y:inner"),

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns:z='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <z:sub/> a test</y:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns:z='http://www.example.com/ns/z'>" +
			"	<x:inner a=\"b\">this is <z:sub/> a test</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}
	
	@Test
	public void test_that_element_with_matching_tag_but_wrong_namespace_is_not_changed() throws SAXException, IOException {
		String xml =
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y' xmlns:z='http://www.example.com/ns/z'>" +
			"	<y:inner a=\"b\">this is <z:sub/> a test</y:inner>" +
			"</x:outer>";

		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/SHOULD_NOT_BE_USED", "/x:outer/y:inner/y:sub"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_element_with_correct_tag_but_no_namespace_is_not_changed_when_xpath_specifies_nsprefix() throws SAXException, IOException {
		String xml =
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner a=\"b\">this is <sub/> a test</y:inner>" +
			"</x:outer>";

		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/SHOULD_NOT_BE_USED", "/x:outer/y:inner/x:sub"),
			xml,
			xml,
			new Message[]{});
	}	
	
	@Test
	public void test_that_element_with_correct_tag_and_in_namespace_is_not_changed_when_xpath_specifies_no_nsprefix() throws SAXException, IOException {
		String xml =
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner a=\"b\">this is <x:sub/> a test</y:inner>" +
			"</x:outer>";

		performFilterTest(
			new XmlChangeNamespaceFilter(testNsContext, "http://www.example.com/ns/SHOULD_NOT_BE_USED", "/x:outer/y:inner/sub"),
			xml,
			xml,
			new Message[]{});
	}
}
