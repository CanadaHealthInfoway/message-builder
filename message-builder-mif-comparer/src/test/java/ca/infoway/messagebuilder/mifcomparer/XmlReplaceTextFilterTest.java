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
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.WARNING;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlReplaceTextFilterTest extends XmlFilterTest {
	@Test
	public void test_that_if_xpath_doesnt_match_then_filter_does_nothing() throws SAXException, IOException {
		String xml = "<outer></outer>";
		
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/@nonexistent-node"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_if_pattern_doesnt_match_then_nothing_is_replaced() throws SAXException, IOException {
		String xml = "<outer><inner a=\"wontmatch\"/></outer>";
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner/@a"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_a_matching_entire_attr_value_is_replaced() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner/@a"),
			"<outer><inner a=\"old\"/></outer>",
			"<outer><inner a=\"new\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_a_matching_substring_is_replaced() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner/@a"),
			"<outer><inner a=\"the old value\"/></outer>",
			"<outer><inner a=\"the new value\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_multiple_occurrances_in_one_value_are_replaced() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner/@a"),
			"<outer><inner a=\"old1 old2\"/></outer>",
			"<outer><inner a=\"new1 new2\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_multiple_attributes_are_replaced() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner/@a"),
			"<outer><inner a=\"old1\"/><inner a=\"old2\"/></outer>",
			"<outer><inner a=\"new1\"/><inner a=\"new2\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_a_regex_matches() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "a*b", "X", "/outer/inner/@a"),
			"<outer><inner a=\"babacaab\"/></outer>",
			"<outer><inner a=\"XXacX\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_capturing_groups_are_inserted() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "^AB([0-9]+)$", "CD$1", "/outer/inner/@a"),
			"<outer><inner a=\"AB12345\"/></outer>",
			"<outer><inner a=\"CD12345\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_original_use_case_bug_14659() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "_*$", "", "/outer/inner/@a"),
			"<outer><inner a=\"CE________\"/></outer>",
			"<outer><inner a=\"CE\"/></outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_elements_text_children_are_modified() throws SAXException, IOException {
		performFilterTest(
			new XmlReplaceTextFilter(null, "old", "new", "/outer/inner"),
			"<outer><inner>some old text<sub>this old won't be replaced</sub>old</inner></outer>",
			"<outer><inner>some new text<sub>this old won't be replaced</sub>new</inner></outer>",
			new Message[]{});
	}	

	@Test
	public void test_that_matching_attribute_is_modified_with_namespaces() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlReplaceTextFilter(testNsContext, "old", "new", "/x:outer/y:inner/@a"),
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'><x:inner a=\"old\"/><Y_ALT:inner a=\"old\"/></x:outer>",
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'><x:inner a=\"old\"/><Y_ALT:inner a=\"new\"/></x:outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_matching_element_is_deleted_with_default_namespace() throws SAXException, IOException {
		// Like the preceding case, except that this time the document binds that URI to the default namespace ("xmlns=...").
		performFilterTest(
			new XmlReplaceTextFilter(testNsContext, "old", "new", "/x:outer/y:inner/@a"),
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns='http://www.example.com/ns/y'><x:inner a=\"old\"/><inner a=\"old\"/></x:outer>",
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns='http://www.example.com/ns/y'><x:inner a=\"old\"/><inner a=\"new\"/></x:outer>",
			new Message[]{});
	}
}
