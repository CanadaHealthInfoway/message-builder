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

public class XmlNormalizeWhitespaceFilterTest extends XmlFilterTest {
	@Test
	public void test_that_if_xpath_doesnt_match_then_normalizer_does_nothing() throws SAXException, IOException {
		String xml = "<outer></outer>";
		
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/nonexistent-node"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_gets_normalized() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  this     is a    test    </inner></outer>",
			"<outer><inner a=\"b\">this is a test</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_already_normalized_xml_isnt_changed() throws SAXException, IOException {
		String xml = "<outer><inner a=\"b\">leading text <sub/> interior text <sub2/> trailing text</inner></outer>";
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_linebreaks_get_normalized() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  this\ris\na\r\ntest    </inner></outer>",
			"<outer><inner a=\"b\">this is a test</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_subelements_have_blanks_around_them() throws SAXException, IOException {
		String xml = "<outer><inner a=\"b\">this is a test <sub/> and some more</inner></outer>";

		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_we_dont_add_space_where_there_wasnt_any() throws SAXException, IOException {
		String xml = "<outer><inner a=\"b\">this is em<b>bold</b>ened text</inner></outer>";

		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			xml,
			xml,
			new Message[]{});
	}

	@Test
	public void test_that_multiple_text_children_get_normalized() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  this is   a test   <sub/> and   some   more </inner></outer>",
			"<outer><inner a=\"b\">this is a test <sub/> and some more</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_three_text_children_get_normalized() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  leading text   <sub/>  interior text  <sub2/> trailing text </inner></outer>",
			"<outer><inner a=\"b\">leading text <sub/> interior text <sub2/> trailing text</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_allwhitespace_content_turns_into_nothing() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">      </inner></outer>",
			"<outer><inner a=\"b\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_empty_content_stays_empty() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\"/></outer>",
			"<outer><inner a=\"b\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_a_leading_text_node_containing_only_whitespace_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">     <sub/>  interior text  <sub2/> trailing text </inner></outer>",
			"<outer><inner a=\"b\"><sub/> interior text <sub2/> trailing text</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_an_interior_text_node_containing_only_whitespace_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  leading text   <sub/>     <sub2/> trailing text </inner></outer>",
			"<outer><inner a=\"b\">leading text <sub/> <sub2/> trailing text</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_a_trailing_text_node_containing_only_whitespace_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  leading text   <sub/>  interior text  <sub2/>   </inner></outer>",
			"<outer><inner a=\"b\">leading text <sub/> interior text <sub2/></inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_normalization_doesnt_recurse_into_subelements() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner"),
			"<outer><inner a=\"b\">  this is   a test   <sub>    some      spaced     subtext </sub> and   some   more </inner></outer>",
			"<outer><inner a=\"b\">this is a test <sub>    some      spaced     subtext </sub> and some more</inner></outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_normalization_does_effectively_recurse_if_xpath_asks_for_it() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer//*"),
			"<outer><inner a=\"b\">  this is   a test   <sub>  some  spaced   subtext </sub> and   some   more </inner></outer>",
			"<outer><inner a=\"b\">this is a test <sub>some spaced subtext</sub> and some more</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_attribute_value_gets_normalized() throws SAXException, IOException {
		performFilterTest(
			new XmlNormalizeWhitespaceFilter(null, "/outer/inner/@a"),
			"<outer><inner a=\"   this   is a    test   \"/></outer>",
			"<outer><inner a=\"this is a test\"/></outer>",
			new Message[]{});
	}
	
	@Override
	boolean getIgnoreWhitespace() {
		return false;
	}
}
