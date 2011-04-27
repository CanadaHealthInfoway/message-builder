/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.util.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.j5goodies.XPathHelper;

/**
 * @sharpen.ignore - test - translated manually.
 */
public class XmlDescriberTest {
	
	private static final String XML_SIMPLE = "<outer><child /><child /><fred /></outer>";
	private static final String XML_MORE_COMPLICATED = "<outer><child><grandchild name=\"Junior\" /></child><child /><fred name=\"Flintstone\" /></outer>";
	private static final String XML_REPEATED_NAME_NON_CONTIGUOUS = "<outer><child><grandchild /></child><child />" +
			"<fred /><child><dummy /></child></outer>";

	@Test
	public void shouldDescribePath() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_SIMPLE);
		
		Node node = new XPathHelper().getSingleNode(xml, "//fred");
		assertEquals("path", "/outer/fred", XmlDescriber.describePath(node));
	}
	
	@Test
	public void shouldDescribePathWithMultiples() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_SIMPLE);
		
		Node node = new XPathHelper().getSingleNode(xml, "//child[1]");
		assertEquals("path", "/outer/child[1]", XmlDescriber.describePath(node));
	}

	@Test
	public void shouldDescribePathWithMultiples2() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_SIMPLE);
		
		Node node = new XPathHelper().getSingleNode(xml, "//child[2]");
		assertEquals("path", "/outer/child[2]", XmlDescriber.describePath(node));
	}
	@Test
	public void shouldDescribePathWithMultiplesInParentHierarchy() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_MORE_COMPLICATED);
		
		Node node = new XPathHelper().getSingleNode(xml, "//grandchild");
		assertEquals("path", "/outer/child[1]/grandchild", XmlDescriber.describePath(node));
	}
	@Test
	public void shouldDescribePathWithMultiplesInParentHierarchyAndAttribute() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_MORE_COMPLICATED);
		
		Node node = new XPathHelper().getSingleNode(xml, "//grandchild/@name");
		assertEquals("path", "/outer/child[1]/grandchild/@name", XmlDescriber.describePath(node));
	}
	@Test
	public void shouldDescribePathWithNonContiguousMultiples() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_REPEATED_NAME_NON_CONTIGUOUS);
		
		Node node = new XPathHelper().getSingleNode(xml, "//dummy");
		assertEquals("path", "/outer/child[3]/dummy", XmlDescriber.describePath(node));
	}
	@Test
	public void shouldDescribeAttribute() throws Exception {
		Document xml = new DocumentFactory().createFromString(XML_MORE_COMPLICATED);
		
		Node node = new XPathHelper().getSingleNode(xml, "//fred/@name");
		assertEquals("path", "/outer/fred/@name", XmlDescriber.describePath(node));
	}
}
