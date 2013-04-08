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

import java.io.File;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * "Filter" to search for nodes matching an XPath expression.
 *
 * This {@link XmlFilter} does <b>not</b> actually modify the
 * XML.  Rather, it simply emits an INFO-level message for every
 * node, in any of the input files, that matches the specified
 * XPath expression.
 */
public class XmlSearchFilter extends XmlIndependentFilterBase {
	public XmlSearchFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Expecting 1 args, but got " + args.length);
		else
			initialize(nsContext, args[0]);
	}
	
	public XmlSearchFilter(NamespaceContext nsContext, String xpathExpr) {
		initialize(nsContext, xpathExpr);
	}

	@Override
	public void filterNode(File f, Node n, MessageList msgs) {
		msgs.add(new Message(INFO, FILTER, "Found instance of \"" + xpathExpr + "\"",
				f, null,
				XmlDescriber.describePath(n), null,
				null, null, null, null, null));
	}
}
