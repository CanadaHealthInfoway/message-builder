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

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
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

public class XmlSearchFilterTest extends XmlFilterTest {
	@Rule public ExpectedException exception = ExpectedException.none();
	
	private static String XML_FOR_TESTS =
	        "<outer>" +
	        "   <mid1>" +
	        "       <inner1 ident='1a'/>" +
	        "   </mid1>" +
	        "   <mid3>" +
	        "       <inner1 ident='3a'/>" +
	        "   </mid3>" +
	        "</outer>";

	
	@Test
	public void test_that_if_xpath_doesnt_match_then_filter_does_nothing() throws SAXException, IOException {
		performFilterTest(
			new XmlSearchFilter(null, "//notfound"),
			XML_FOR_TESTS,
			XML_FOR_TESTS,
			new Message[]{});
	}	

	@Test
	public void test_that_filter_outputs_all_matches() throws SAXException, IOException {
		performFilterTest(
			new XmlSearchFilter(null, "//inner1"),
			XML_FOR_TESTS,
			XML_FOR_TESTS,
			new Message[]{
				new Message(INFO, TESTING_CODE, "Found instance of \"//inner1\"", new File("the-file"), null, "/outer/mid1/inner1", null, null, null, null, null, null),
				new Message(INFO, TESTING_CODE, "Found instance of \"//inner1\"", new File("the-file"), null, "/outer/mid3/inner1", null, null, null, null, null, null),
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
