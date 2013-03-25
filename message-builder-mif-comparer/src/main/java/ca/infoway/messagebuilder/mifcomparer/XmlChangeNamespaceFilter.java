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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * Filter that switches every matched node into a different namespace.
 */
public class XmlChangeNamespaceFilter extends XmlIndependentFilterBase {
	private String newNsURI;
	private String newNsPrefix;
	
	public XmlChangeNamespaceFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException("Expecting 2 args, but got " + args.length);
		else
			initialize(nsContext, args[0], args[1]);
	}
	
	/**
	 * Construct an {@code XmlChangeNamespaceFilter}.
	 * 
	 * Each matching node will be switched into the namespace URI given by {@code newNsURI}.
	 * The corresponding namespace prefix is looked up in {@code nsContext}.
	 * An appropriate {@code xmlns} attribute will be added on the new element if necessary.
 	 *
	 * @param	nsContext	NamespaceContext
	 * @param	newNsURI	the namespace to switch matched nodes into
	 * @param	xpathExpr	XPath expression specifying which nodes are to be switched
	 */
	public XmlChangeNamespaceFilter(NamespaceContext nsContext, String newNsURI, String xpathExpr) {
		initialize(nsContext, newNsURI, xpathExpr);
	}
		
	private void initialize(NamespaceContext nsContext, String newNsURI, String xpathExpr) {
		super.initialize(nsContext, xpathExpr);
		
		this.newNsURI = newNsURI;
		this.newNsPrefix = this.nsContext.getPrefix(this.newNsURI);
	}
	
	@Override
	void filterNode(File f, Node n, MessageList msgs) {
		Document d = n.getOwnerDocument();
		String newQname = this.newNsPrefix + ":" + n.getLocalName();
		
		d.renameNode(n, this.newNsURI, newQname);
	}
}
