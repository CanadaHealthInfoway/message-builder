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

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XmlTextChildTransformerBaseTest extends XmlFilterTest {

	/**
	 * Mock XmlTextChildTransformerBase subclass.  Its constructor
	 * takes a list of replacement strings.  These are used, in order,
	 * as the new content for &lt;inner&gt;'s Text nodes.
	 * To cause a Text to be removed entirely, pass "" for its new value.
	 *
	 * <p>Before running the transform, it removes from the DOM all
	 * &lt;DELETE_ME&gt; elements.  This is a way to create an input
	 * DOM tree with adjacent Text nodes.
	 */
	private static class TestFilter extends XmlTextChildTransformerBase {
		String[] newTexts;
		int newTextIndex;

		public TestFilter(String... newTexts) {
			super.initialize(null, "/outer/inner");
			this.newTexts = newTexts;
		}
		
		@Override
		public void apply(File f, Document dom, MessageList msgs) {
			// get control before super.apply(), to set things up
			Element e = (Element)dom.getFirstChild();
			if (e != null) {
				deleteElements(e, "DELETE_ME");
				e = (Element)e.getFirstChild();
			}

			newTextIndex = 0;
			super.apply(f,  dom,  msgs);
		}
		
		@Override
		void filterNode(File f, Node n, MessageList msgs) {
			transformTextChildren(f, (Element) n, msgs);
		}
			
		public void deleteElements(Element e, String name) {
			NodeList nodes = e.getElementsByTagName(name);
			
			// Subtlety: removing a node from the DOM removes it from the NodeList too
			while (nodes.getLength() > 0) {
				Node n = nodes.item(0);
				Node parent = n.getParentNode();
				parent.removeChild(n);
			}
		}
		
		public Text transformTextNode(File f, Text t, MessageList msgs) {
			return t.replaceWholeText(newTexts[newTextIndex++]);
		}
	}

	
	@Test
	public void test_that_when_only_child_is_text_it_gets_transformed() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("output text"),
			"<outer><inner a=\"b\">input text</inner></outer>",
			"<outer><inner a=\"b\">output text</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_when_only_child_is_nontext_nothing_changes() throws SAXException, IOException {
		String xml = "<outer><inner a=\"b\"><sub/></inner></outer>";
		performFilterTest(
			new TestFilter(),
			xml,
			xml,
			new Message[]{});
	}

	@Test
	public void test_that_two_text_children_get_transformed() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2"),
			"<outer><inner a=\"b\">in1<sub/>in2</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_three_text_children_get_transformed() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2", "out3"),
			"<outer><inner a=\"b\">in1<sub/>in2<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2<sub2/>out3</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_when_only_child_gets_deleted() throws SAXException, IOException {
		performFilterTest(
			new TestFilter(""),
			"<outer><inner a=\"b\">input</inner></outer>",
			"<outer><inner a=\"b\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_when_no_children_at_all() throws SAXException, IOException {
		performFilterTest(
			new TestFilter(),
			"<outer><inner a=\"b\"/></outer>",
			"<outer><inner a=\"b\"/></outer>",
			new Message[]{});
	}

	
	@Test
	public void test_that_a_leading_text_node_disappearing_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("", "out2", "out3"),
			"<outer><inner a=\"b\">in1<sub/>in2<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\"><sub/>out2<sub2/>out3</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_an_interior_text_node_disappearing_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "", "out3"),
			"<outer><inner a=\"b\">in1<sub/>in2<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/><sub2/>out3</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_a_trailing_text_node_disappearing_doesnt_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2", ""),
			"<outer><inner a=\"b\">in1<sub/>in2<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2<sub2/></inner></outer>",
			new Message[]{});
	}
	

	@Test
	public void test_that_multiple_leading_text_nodes_dont_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2", "out3", "ERR1", "ERR2"),
			"<outer><inner a=\"b\">in1a<DELETE_ME/>in1b<DELETE_ME/>in1c<sub/>in2<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2<sub2/>out3</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_multiple_interior_text_nodes_dont_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2", "out3"),
			"<outer><inner a=\"b\">in1a<sub/>in2a<DELETE_ME/>in2b<DELETE_ME/>in2c<sub2/>in3</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2<sub2/>out3</inner></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_multiple_trailing_text_nodes_dont_confuse_things() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2", "out3"),
			"<outer><inner a=\"b\">in1a<sub/>in2<sub2/>in3a<DELETE_ME/>in3b<DELETE_ME/>in3c</inner></outer>",
			"<outer><inner a=\"b\">out1<sub/>out2<sub2/>out3</inner></outer>",
			new Message[]{});
	}


	@Test
	public void test_that_transformation_doesnt_recurse_into_subelements() throws SAXException, IOException {
		performFilterTest(
			new TestFilter("out1", "out2"),
			"<outer><inner a=\"b\">in1<sub>subtext should be left alone</sub>in2</inner></outer>",
			"<outer><inner a=\"b\">out1<sub>subtext should be left alone</sub>out2</inner></outer>",
			new Message[]{});
	}	
	
	@Override
	boolean getIgnoreWhitespace() {
		return false;
	}
}
