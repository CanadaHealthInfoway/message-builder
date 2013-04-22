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
 * Filter which does regex-based replacement on attribute values.
 */
public class XmlReplaceTextFilter extends XmlTextChildTransformerBase {
	private String pattern;
	private String replacement;
	
	public XmlReplaceTextFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 3)
			throw new IllegalArgumentException("Expecting 3 args, but got " + args.length);
		else
			initialize(nsContext, args[0], args[1], args[2]);
	}
	
	public XmlReplaceTextFilter(NamespaceContext nsContext, String pattern, String replacement, String xpathExpr) {
		initialize(nsContext, pattern, replacement, xpathExpr);
	}

	void initialize(NamespaceContext nsContext, String pattern, String replacement, String xpathExpr) {
		super.initialize(nsContext, xpathExpr);
		//this.pattern = Pattern.compile(pattern);
		this.pattern = pattern;
		this.replacement = replacement;
	}

	@Override
	public void filterNode(File f, Node n, MessageList msgs) {
		switch (n.getNodeType()) {
		case Node.ATTRIBUTE_NODE:
			doReplacement(f, (Attr)n, msgs);
			break;
			
		case Node.ELEMENT_NODE:
			doReplacement(f, (Element)n, msgs);
			break;
			
		case Node.TEXT_NODE:
			doReplacement(f, (Text)n, msgs);
			break;
			
		default:
			msgs.add(new Message(ERROR, FILTER,
					String.format("Attempted to do text replacement on node of type %s", n.getNodeType()),
					f, null));
		}
	}
	
	void doReplacement(File f, Attr a, MessageList msgs) {
		String value = a.getValue();
		value = doReplacement(value);
		a.setValue(value);
	}
	
	/**
	 * Do replacement on an {@link Element} -- specifically, on its direct text content.
	 * Do <i>not</i> recursively squash contained elements.
	 * 	 * 
	 * @param	f		the file we're working on, for message reporting
	 * @param	e		the element whose text content is to be operated on
	 * @param	msgs	destination for message reporting
	 */
	void doReplacement(File f, Element e, MessageList msgs) {
		transformTextChildren(f, e, msgs);
	}

	@Override
	protected Text transformTextNode(File f, Text t, MessageList msgs) {
		return doReplacement(f, t, msgs);
	}
	
	Text doReplacement(File f, Text t, MessageList msgs) {
		return t.replaceWholeText(doReplacement(t.getWholeText()));
	}

	String doReplacement(String s) {
		return s.replaceAll(pattern, replacement);
	}
}
