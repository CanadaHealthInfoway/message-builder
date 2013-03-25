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
import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.xml2DOM;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlResequenceFilterTest extends XmlFilterTest {
	@Rule public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test_that_if_xpath_doesnt_match_then_filter_does_nothing() throws SAXException, IOException {
		String xml = "<outer><inner seq='2' value='a'/><inner seq='4' value='c'/><inner seq='3' value='b'/></outer>";
		
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/nonexistent-node"),
			xml,
			xml,
			new Message[]{});
	}
	
	@Test
	public void test_that_matching_element_is_resequenced() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/inner"),

			"<outer>" +
			"	<inner sortKey='2' value='a'/>" +
			"	<inner sortKey='9' value='c'/>" +
			"	<inner sortKey='5' value='b'/>" +
			"</outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<outer>" +
			"	<inner sortKey='1' value='a'/>" +
			"	<inner sortKey='2' value='b'/>" +
			"	<inner sortKey='3' value='c'/>" +
			"</outer>",
			new Message[]{});
	}		
	
	@Test
	public void test_that_elements_with_nonnumeric_keys_are_reordered_but_key_values_are_preserved() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/inner"),

			"<outer>" +
			"	<inner sortKey='QQ' value='a'/>" +
			"	<inner sortKey='SS' value='c'/>" +
			"	<inner sortKey='RR' value='b'/>" +
			"</outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<outer>" +
			"	<inner sortKey='QQ' value='a'/>" +
			"	<inner sortKey='RR' value='b'/>" +
			"	<inner sortKey='SS' value='c'/>" +
			"</outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_resequenced_nodes_are_inserted_in_the_proper_place() throws SAXException, IOException {
		XMLUnit.setCompareUnmatched(true);
		XMLUnit.setIgnoreWhitespace(true);
		
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/inner"),

			"<outer>" +
			"	<predecessor/>" +
			"	<inner sortKey='2' value='a'/>" +
			"	<inner sortKey='9' value='c'/>" +
			"	<inner sortKey='5' value='b'/>" +
			"	<follower/>" +
			"</outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<outer>" +
			"	<predecessor/>" +
			"	<inner sortKey='1' value='a'/>" +
			"	<inner sortKey='2' value='b'/>" +
			"	<inner sortKey='3' value='c'/>" +
			"	<follower/>" +
			"</outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_two_groups_of_nodes_are_resequenced_independently() throws SAXException, IOException {
		XMLUnit.setCompareUnmatched(true);
		XMLUnit.setIgnoreWhitespace(true);
		
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/mid/inner"),

			"<outer>" +
			"	<mid index='1'>" +
			"		<predecessor/>" +
			"		<inner sortKey='2' value='a'/>" +
			"		<inner sortKey='9' value='c'/>" +
			"		<inner sortKey='5' value='b'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='2'>" +
			"		<predecessor/>" +
			"		<inner sortKey='7' value='e'/>" +
			"		<inner sortKey='3' value='d'/>" +
			"		<follower/>" +
			"	</mid>" +
			"</outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<outer>" +
			"	<mid index='1'>" +
			"		<predecessor/>" +
			"		<inner sortKey='1' value='a'/>" +
			"		<inner sortKey='2' value='b'/>" +
			"		<inner sortKey='3' value='c'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='2'>" +
			"		<predecessor/>" +
			"		<inner sortKey='1' value='d'/>" +
			"		<inner sortKey='2' value='e'/>" +
			"		<follower/>" +
			"	</mid>" +
			"</outer>",
			new Message[]{});
	}
		
	@Test
	public void test_that_missing_sort_key_attr_doesnt_prevent_sorting_other_groups() throws SAXException, IOException {
		XMLUnit.setCompareUnmatched(true);
		XMLUnit.setIgnoreWhitespace(true);
		
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/mid/inner"),

			"<outer>" +
			"	<mid index='1'>" +
			"		<predecessor/>" +
			"		<inner sortKey='2' value='a'/>" +
			"		<inner sortKey='9' value='c'/>" +
			"		<inner sortKey='5' value='b'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='2'>" +
			"		<predecessor/>" +
			"		<inner sortKey='6' value='e'/>" +
			"		<inner             value='d'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='3'>" +
			"		<predecessor/>" +
			"		<inner sortKey='7' value='g'/>" +
			"		<inner sortKey='3' value='f'/>" +
			"		<follower/>" +
			"	</mid>" +
			"</outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<outer>" +
			"	<mid index='1'>" +
			"		<predecessor/>" +
			"		<inner sortKey='1' value='a'/>" +
			"		<inner sortKey='2' value='b'/>" +
			"		<inner sortKey='3' value='c'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='2'>" +
			"		<predecessor/>" +
			"		<inner sortKey='6' value='e'/>" +
			"		<inner             value='d'/>" +
			"		<follower/>" +
			"	</mid>" +
			"	<mid index='3'>" +
			"		<predecessor/>" +
			"		<inner sortKey='1' value='f'/>" +
			"		<inner sortKey='2' value='g'/>" +
			"		<follower/>" +
			"	</mid>" +
			"</outer>",
			new Message[]{
				new Message(WARNING, FILTER, "Can't sort \"/outer/mid/inner\" elements due to missing \"sortKey\" attribute; expect spurious differences",
						new File("the-file"), null),
			});
	}
	@Test
	public void test_that_matching_element_is_resequenced_with_namespaces() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(testNsContext, "sortKey", "/x:outer/y:inner"),

			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner sortKey='2' value='a'/>" +
			"	<y:inner sortKey='9' value='c'/>" +
			"	<y:inner sortKey='5' value='b'/>" +
			"</x:outer>",
				
			// N.B.: The sortKey's should get resequenced, and the nodes should also be physically reordered
			// to match the sequence.
			"<x:outer xmlns:x='http://www.example.com/ns/x' xmlns:y='http://www.example.com/ns/y'>" +
			"	<y:inner sortKey='1' value='a'/>" +
			"	<y:inner sortKey='2' value='b'/>" +
			"	<y:inner sortKey='3' value='c'/>" +
			"</x:outer>",
			new Message[]{});
	}	
	
	@Test
	public void test_that_missing_sortKeyAttr_causes_the_correct_message() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/inner"),
			"<outer><inner a=\"1\"/></outer>",
			"<outer><inner a=\"1\"/></outer>",
			new Message[]{
				new Message(WARNING, FILTER, "Can't sort \"/outer/inner\" elements due to missing \"sortKey\" attribute; expect spurious differences",
					new File("the-file"), null),
		});
	}
	
	@Test
	public void test_that_unparseable_sortKeyAttr_causes_the_correct_message() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer/inner"),
			"<outer><inner sortKey=\"not-an-int\"/></outer>",
			"<outer><inner sortKey=\"not-an-int\"/></outer>",
			new Message[]{});
	}
	
	@Test
	public void test_that_bogus_xpath_expr_causes_the_correct_message() throws SAXException, IOException {
		performFilterTest(
			new XmlResequenceFilter(null, "sortKey", "/outer("),								// Intentional XPath error: unmatched paren
			"<outer><inner a=\"b\"/><inner a=\"d\"/></outer>",
			"<outer><inner a=\"b\"/><inner a=\"d\"/></outer>",
			new Message[]{
				new Message(WARNING, FILTER, "Error evaluating XPath expr \"/outer(\": Unknown nodetype: outer",
					new File("the-file"), null),
		});
	}
	
	
	// Utility methods
	
	private List<? extends Node> doXPathQuery(NamespaceContext nsContext, String xpathExpr, Document dom) throws XPathExpressionException {
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();
		if (nsContext != null)
			xpath.setNamespaceContext(nsContext);
				
		NodeList nodes = (NodeList)xpath.evaluate(xpathExpr, dom, XPathConstants.NODESET);
		
		List<Node> list = new ArrayList<Node>(nodes.getLength());
		for (int i=0; i<nodes.getLength(); ++i) {
			list.add(nodes.item(i));
		}
		
		return list;
	}

}
