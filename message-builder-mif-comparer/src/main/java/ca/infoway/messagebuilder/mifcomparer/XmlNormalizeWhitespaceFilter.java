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
 * Filter which takes an XPath expression, and deletes from a DOM tree all nodes matching the expression.
 */
public class XmlNormalizeWhitespaceFilter extends XmlTextChildTransformerBase {
	private static Pattern interiorWhitespacePattern = Pattern.compile("\\s+");
	private static Pattern leadingWhitespacePattern = Pattern.compile("^\\s+");
	private static Pattern trailingWhitespacePattern = Pattern.compile("\\s+$");
	
	public XmlNormalizeWhitespaceFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Expecting 1 args, but got " + args.length);
		else
			initialize(nsContext, args[0]);
	}
	
	public XmlNormalizeWhitespaceFilter(NamespaceContext nsContext, String xpathExpr) {
		initialize(nsContext, xpathExpr);
	}

	@Override
	public void filterNode(File f, Node n, MessageList msgs) {
		switch (n.getNodeType()) {
		case Node.ATTRIBUTE_NODE:
			normalize(f, (Attr)n, msgs);
			break;
			
		case Node.ELEMENT_NODE:
			normalize(f, (Element)n, msgs);
			break;
			
		case Node.TEXT_NODE:
			normalize(f, (Text)n, msgs);
			break;
			
		default:
			msgs.add(new Message(ERROR, FILTER,
					String.format("Attempted to normalize node of type %s", n.getNodeType()),
					f, null));
		}
	}
	
	void normalize(File f, Attr a, MessageList msgs) {
		a.setValue(squashWhitespace(a.getValue().trim()));
	}
	
	/**
	 * Normalize whitespace in an {@link Element} -- specifically, in its direct text content.
	 * Do <i>not</i> recursively squash contained elements.
	 * 	 * 
	 * @param	f		the file we're working on, for message reporting
	 * @param	e		the element whose text content is to be normalized
	 * @param	msgs	destination for message reporting
	 */
	void normalize(File f, Element e, MessageList msgs) {
		transformTextChildren(f, e, msgs);
		trim(f, e, msgs);
	}

	void trim(File f, Element e, MessageList msgs) {
		Node n;
		
		if ((n = e.getFirstChild()) != null && n.getNodeType() == Node.TEXT_NODE) {
			((Text)n).replaceWholeText(stripLeadingWhitespace(((Text)n).getWholeText()));
		}
		
		if ((n = e.getLastChild()) != null && n.getNodeType() == Node.TEXT_NODE) {
			((Text)n).replaceWholeText(stripTrailingWhitespace(((Text)n).getWholeText()));
		}
	}
	
	@Override
	protected Text transformTextNode(File f, Text t, MessageList msgs) {
		return normalize(f, t, msgs);
	}
	
	Text normalize(File f, Text t, MessageList msgs) {
		return t.replaceWholeText(squashWhitespace(t.getWholeText()));
	}
	
	/**
	 * Replaces each run of whitespace in a String with a single blank.
	 * Does <i>not</i> trim leading and trailing whitespace (but does squash it).
	 *
	 * @param	s	string to be squashed
	 * @return		{@code s}, with whitespace squashed
	 */
	String squashWhitespace(String s) {
		s = interiorWhitespacePattern.matcher(s).replaceAll(" ");
		return s;
	}
	
	/**
	 * Strips leading whitespace from a string.
	 * 
	 * @param	s	the string
	 * @return		{@code s}, with leading whitespace removed
	 */
	String stripLeadingWhitespace(String s) {
		return leadingWhitespacePattern.matcher(s).replaceAll("");
	}	
	
	/**
	 * Strips leading whitespace from a string.
	 * 
	 * @param	s	the string
	 * @returns		{@code s}, with leading whitespace removed
	 */
	String stripTrailingWhitespace(String s) {
		return trailingWhitespacePattern.matcher(s).replaceAll("");
	}
}
