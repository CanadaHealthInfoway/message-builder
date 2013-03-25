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
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.WARNING;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlWrapContentFilterTest extends XmlFilterTest {
	@Test
	public void test_that_if_xpath_doesnt_match_then_filter_does_nothing() throws SAXException, IOException {
		String xml = "<outer></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/nonexistent-node"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_if_matching_element_is_empty_then_nothing_happens() throws SAXException, IOException {
		String xml = "<outer><inner a=\"b\"/></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_it_wraps_one_subelement() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			"<outer><inner><sub/></inner></outer>",
			"<outer><inner><wrapper><sub/></wrapper></inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_it_wraps_one_text_child() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			"<outer><inner>some text</inner></outer>",
			"<outer><inner><wrapper>some text</wrapper></inner></outer>",
			new Message[]{});
	}
		
	@Test
	public void test_that_it_wraps_multiple_childen_of_one_match() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			"<outer><inner>some text<sub/>some more text</inner></outer>",
			"<outer><inner><wrapper>some text<sub/>some more text</wrapper></inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_it_wraps_each_of_multiple_matches() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			"<outer><inner>a</inner><inner>b</inner><inner>c</inner></outer>",
			"<outer><inner><wrapper>a</wrapper></inner><inner><wrapper>b</wrapper></inner><inner><wrapper>c</wrapper></inner></outer>",
			new Message[]{});
	}

	@Test
	public void test_that_if_one_wrapper_child_then_nothing_happens() throws SAXException, IOException {
		String xml = "<outer><inner><wrapper>a</wrapper></inner></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_if_only_child_is_whitespace_then_nothing_happens() throws SAXException, IOException {
		String xml = "<outer><inner>    </inner></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_if_one_wrapper_child_plus_whitespace_then_nothing_happens() throws SAXException, IOException {
		String xml = "<outer><inner>  <wrapper>a</wrapper>  </inner></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}	
	
	@Test
	public void test_that_if_nonwrapper_child_plus_whitespace_then_they_get_wrapped() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			"<outer><inner>  <sub/>  </inner></outer>",
			"<outer><inner><wrapper>  <sub/>  </wrapper></inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_if_multiple_wrapper_children_then_nothing_happens() throws SAXException, IOException {
		String xml = "<outer><inner><wrapper>a</wrapper><wrapper>b</wrapper></inner></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_if_only_some_children_are_wrapped_then_it_doesnt_wrap_but_does_warn() throws SAXException, IOException {
		String xml = "<outer><inner><wrapper>a</wrapper> foo</inner></outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(null, "", "wrapper", "/outer/inner"),
			xml,
			xml,
			new Message[]{
				new Message(WARNING, FILTER, "Not wrapping children in a (null,wrapper) element, because some are already wrapped", new File("the-file"), null, "/outer/inner", null, ELEMENT, "inner", null, null, null),
			});
	}
	
	@Test
	public void test_that_if_namespace_prefix_is_already_mapped_an_xmlns_attr_is_not_added() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "http://www.example.com/ns/y", "wrapper", "/x:outer/x:inner"),
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">stuff</x:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<y:wrapper>stuff</y:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}	
	
	@Test
	public void test_that_if_namespace_prefix_is_not_already_mapped_an_xmlns_attr_is_added() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "http://www.example.com/ns/y", "wrapper", "/x:outer/x:inner"),
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">stuff</x:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<y:wrapper xmlns:y='http://www.example.com/ns/y'>stuff</y:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}

	@Test
	public void test_that_if_one_wrapper_child_then_nothing_happens_with_namespaces() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "http://www.example.com/ns/y", "wrapper", "/x:outer/x:inner"),
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<Y_ALT:wrapper>stuff</Y_ALT:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<Y_ALT:wrapper>stuff</Y_ALT:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}	
	
	@Test
	public void test_that_zerolength_wrapperNS_matches_unnamespaced_wrapper_element() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		
		String xml =
				"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
				"	<x:inner a=\"b\">" +
				"		<wrapper>stuff</wrapper>" +
				"	</x:inner>" +
				"</x:outer>";
		
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "", "wrapper", "/x:outer/x:inner"),
			
			xml,
			xml,

			new Message[]{});
	}	
	
	@Test
	public void test_that_zerolength_wrapperNS_does_not_match_namespaced_wrapper_element() throws SAXException, IOException {
		// N.B.: The document binds namespace URI http://www.example.com/ns/y to "Y_ALT", while the 
		// combination of (XPath expression + tesNsContext) binds it to "y".  The expression matches anyway
		// because the URI is the same in both cases.
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "", "wrapper", "/x:outer/x:inner"),
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<Y_ALT:wrapper>stuff</Y_ALT:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:Y_ALT='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<wrapper>" +
			"			<Y_ALT:wrapper>stuff</Y_ALT:wrapper>" +
			"		</wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}	
	
	@Test
	public void test_that_nonzerolength_wrapperNS_does_not_match_unnamespaced_wrapper_element() throws SAXException, IOException {
		performFilterTest(
			new XmlWrapContentFilter(testNsContext, "http://www.example.com/ns/y", "wrapper", "/x:outer/x:inner"),
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<wrapper>stuff</wrapper>" +
			"	</x:inner>" +
			"</x:outer>",
			
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<x:inner a=\"b\">" +
			"		<y:wrapper>" +
			"			<wrapper>stuff</wrapper>" +
			"		</y:wrapper>" +
			"	</x:inner>" +
			"</x:outer>",

			new Message[]{});
	}
}
