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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Base class for {@link XmlFilter}s that:<ol>
 * 		<li>use an XPath expression to decide which nodes to filter, and
 * 		<li>filter each matching node independently
 * </ol>
 * 
 *  By "filter independently" is meant that each matching node is processed in isolation; there's no interaction
 *  between them.  If a filter needs to consider many matched nodes at once, it shouldn't extend this class.
 *  ({@link XmlResequenceFilter} is an example of such a filter.}
 */
public abstract class XmlIndependentFilterBase extends XmlFilterImpl {
	protected NamespaceContext nsContext;
	protected String xpathExpr;
	protected XPath xpath;
	
	void initialize(NamespaceContext nsContext, String xpathExpr) {
		this.nsContext = nsContext;
		this.xpathExpr = xpathExpr;
		
		XPathFactory xpf = XPathFactory.newInstance();
		xpath = xpf.newXPath();
		if (nsContext != null)
			xpath.setNamespaceContext(nsContext);
	}

	/* (non-Javadoc)
	 * @see ca.infoway.messagebuilder.mifcomparer.XmlFilter#apply(java.io.File, org.w3c.dom.Document, ca.infoway.messagebuilder.mifcomparer.MessageList)
	 */
	@Override
	public void apply(File f, Document dom, MessageList msgs) {
		NodeList nodes;
		try {
			nodes = (NodeList)xpath.evaluate(xpathExpr, dom, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new FatalConditionException(
					String.format("Error evaluating XPath expr \"%s\": %s", xpathExpr, getExceptionMessage(e)), e);
		}

		for (int i=0; i<nodes.getLength(); ++i) {
			Node n = nodes.item(i);
			filterNode(f, n, msgs);
		}
	}
	
	abstract void filterNode(File f, Node n, MessageList msgs);
}
