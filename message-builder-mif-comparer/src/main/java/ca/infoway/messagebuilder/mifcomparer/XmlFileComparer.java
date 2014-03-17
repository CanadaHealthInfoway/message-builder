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

import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.EXTRA;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.MISSING;
import static ca.infoway.messagebuilder.mifcomparer.Message.DifferenceType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.FILE_SUMMARY;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.INTERNAL_ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.PROGRESS;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_DIFFERENCE;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.ELEMENT;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.TEXT;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.FATAL;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.INFO;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;

import org.custommonkey.xmlunit.NodeDetail;
import org.custommonkey.xmlunit.Difference;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ca.infoway.messagebuilder.mifcomparer.xmlunit.XmlunitAdapter;
import ca.infoway.messagebuilder.mifcomparer.xmlunit.XmlunitResult;

public class XmlFileComparer extends FileComparer {
	Document leftDOM;
	Document rightDOM;

	/**
	 * Construct a {@link XmlFileComparer} that will compare the given
	 * {@link MifFile}s.
	 */
	public XmlFileComparer(MifFile l, MifFile r, MessageList m) {
		super(l, r, m);
	}

	/**
	 * Construct a {@link XmlFileComparer} that will compare the given
	 * {@link File}s.
	 */
	public XmlFileComparer(File l, File r, MessageList m) {
		super(l, r, m);
	}

	/**
	 * Construct a {@link FileComparer} that will compare the two given
	 * {@link String}s. These are <i>not</i> pathnames, but rather the actual
	 * content to be compared. Any resulting {@link Message}s will contain
	 * hardcoded {@link File}s <tt>left-file</tt> and <tt>right-file</tt>.
	 */
	public XmlFileComparer(String l, String r, MessageList m) {
		super(l, r, m);
	}

	// Is return value really useful?  Need more detailed stats anyway, e.g. XML error vs. XML miscompare
	public int compare() {
		messages.add(new Message(DEBUG, PROGRESS, "Comparing using XmlFileComparer", left.getFile(), right.getFile()));
	
		leftDOM = parse(left);
		rightDOM = parse(right);
	
		if (leftDOM == null || rightDOM == null) {
			// parse() already logged an appropriate message 
			return 1;
		}
		
		if (globalConfig != null) {
			globalConfig.xmlFilters.apply(left.getFile(), leftDOM, messages);
			globalConfig.xmlFilters.apply(right.getFile(), rightDOM, messages);
		}

		XmlunitResult result = new XmlunitAdapter().compare(leftDOM, rightDOM);
		for (Difference d : result.getDifferences()) {
			reportDifference(d);
		}

		if (result.isIdentical()) {
			messages.add(new Message(INFO, FILE_SUMMARY, "Files are identical", left.getFile(), right.getFile()));
			return 0;
		} else if (result.isSimilar()) {
			messages.add(new Message(INFO, FILE_SUMMARY, "Files are similar", left.getFile(), right.getFile()));
			return 0;
		} else {
			messages.add(new Message(INFO, FILE_SUMMARY, "Files differ", left.getFile(), right.getFile()));
			return 1;
		}
	}

	public Document parse(XmlDocument side) {
		try {
			return side.getDocument();
		} catch (SAXParseException e) {
			messages.add(new Message(ERROR,
					XML_ERROR,
					"XML error: " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage(),
					side==left ? side.getFile() : null,
					side==left ? null : side.getFile()));
			return null;
		}
	}

	public void reportDifference(Difference d) {
		NodeDetail leftNode = d.getControlNodeDetail();
		NodeDetail rightNode = d.getTestNodeDetail();
		
		String desc = d.getDescription();
		
		if (desc.equals("number of child nodes") ||
            desc.equals("presence of child nodes to be") ||
			desc.equals("sequence of child nodes") ||
			desc.equals("element tag name") ||
			desc.equals("sequence of attributes") ||
			desc.equals("number of element attributes")) {
			// Omit these noise messages
			return;
		}
		

		if (desc.equals("text value")) {
			Message m = new Message(ERROR, XML_DIFFERENCE,
					String.format("For text, expected \"%s\", but got \"%s\"",
						leftNode.getValue(), rightNode.getValue()),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					TEXT, null, VALUE,
					leftNode.getValue(), rightNode.getValue());
			messages.add(m);
			
		} else if (desc.equals("presence of child node")) {
			String nodeName, nodeValue, msgValue;
			NodeDetail nd;
			Message.ObjectType objType;
			Message.DifferenceType diffType;
			boolean isExtra = leftNode.getXpathLocation() == null  ||  leftNode.getXpathLocation().equals("");
			
			if (isExtra) {
				nd = rightNode;
				diffType = EXTRA;
			} else {
				nd = leftNode;
				diffType = MISSING;
			}

			objType = Message.nodeType2ObjectType(nd.getNode());
			
			switch (objType) {
			case ELEMENT:
				nodeName = nd.getValue();
				nodeValue = null;
				msgValue = nodeName;
				break;
					
			case TEXT:
				nodeName = null;
				nodeValue = nd.getNode().getNodeValue();
				msgValue = nodeValue;
				break;
				
			case PROCESSING_INSTRUCTION:
				ProcessingInstruction pi = (ProcessingInstruction) nd.getNode();
				nodeName = null;
				nodeValue = String.format("%s %s", pi.getTarget(), pi.getData());
				msgValue = String.format("<?%s?>", nodeValue);
				break;

			default:
				nodeName = nodeValue = msgValue = String.format("(%s node)", objType);
				break;
			}
			
			Message m = new Message(ERROR, XML_DIFFERENCE,
					String.format("%s %s: \"%s\"", 
							diffType.toString().toLowerCase(), objType.toFriendlyString(),
							msgValue),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					objType, nodeName, diffType,
					isExtra ? null : nodeValue,
					isExtra ? nodeValue : null
					);
			messages.add(m);
			
		} else if (desc.equals("attribute name")) {
			String nodeName;
			Message.DifferenceType diffType;

			boolean isExtra = leftNode.getValue() == null  ||  leftNode.getValue().equals("null");
			if (isExtra) {
				nodeName = rightNode.getValue();
				diffType = EXTRA;
			} else {
				nodeName = leftNode.getValue();
				diffType = MISSING;
			}
			
			Message m = new Message(ERROR, XML_DIFFERENCE,
					diffType.toString().toLowerCase() + " attribute: \"" + nodeName + "\"",
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					ATTRIBUTE, nodeName, diffType,
					null, null
					);
			messages.add(m);

		} else if (desc.equals("attribute value")) {
			String xpath = leftNode.getXpathLocation();
			String attrName = xpath.substring(xpath.lastIndexOf('@') + 1);
					
			Message m = new Message(ERROR, XML_DIFFERENCE,
					String.format("For attribute \"%s\", expected \"%s\", but got \"%s\"",
						attrName, leftNode.getValue(), rightNode.getValue()),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					ATTRIBUTE,
					attrName,
					VALUE,
					leftNode.getValue(), rightNode.getValue()
					);
			messages.add(m);

		} else if (desc.equals("namespace prefix")) {
			String xpath = leftNode.getXpathLocation();
			String attrName = xpath.substring(xpath.lastIndexOf('@') + 1);
					
			Message m = new Message(TRIVIAL, XML_DIFFERENCE,
					String.format("For namespace prefix, expected \"%s\", but got \"%s\"",
						leftNode.getValue(), rightNode.getValue()),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					NAMESPACE_PREFIX,
					null,
					VALUE,
					leftNode.getValue(), rightNode.getValue()
					);
			messages.add(m);

		} else if (desc.equals("processing instruction target")) {
			Message m = new Message(ERROR, XML_DIFFERENCE,
					String.format("For processing instruction, expected target \"%s\", but got \"%s\"",
						leftNode.getValue(), rightNode.getValue()),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					PROCESSING_INSTRUCTION,
					null,
					PI_TARGET,
					leftNode.getValue(), rightNode.getValue()
					);
			messages.add(m);

		} else if (desc.equals("processing instruction data")) {
			Message m = new Message(ERROR, XML_DIFFERENCE,
					String.format("For processing instruction with target \"%s\", expected data \"%s\", but got \"%s\"",
						((ProcessingInstruction) leftNode.getNode()).getTarget(),
						leftNode.getValue(), rightNode.getValue()),
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					PROCESSING_INSTRUCTION,
					null,
					VALUE,
					leftNode.getValue(), rightNode.getValue()
					);
			messages.add(m);

		} else if (desc.equals("xsi:schemaLocation attribute") ||
				   desc.equals("xsi:noNamespaceSchemaLocation attribute")) {
			String nodeName, nodeValue, msgValue;
			String leftValue, rightValue;
			NodeDetail nd;
			Message.ObjectType objType;
			Message.DifferenceType diffType;

			if (leftNode.getNode() == null) {
				diffType = EXTRA;
				leftValue = null;
				rightValue = rightNode.getValue();
				msgValue = rightValue;

			} else if (rightNode.getNode() == null) {
				diffType = MISSING;
				leftValue = leftNode.getValue();
				rightValue = null;
				msgValue = leftValue;

			} else {
				diffType = VALUE;
				leftValue = leftNode.getValue();
				rightValue = rightNode.getValue();
				msgValue = null;
			}

			objType = (desc.equals("xsi:noNamespaceSchemaLocation attribute") ? NO_NAMESPACE_SCHEMA_LOCATION : SCHEMA_LOCATION);

			Message m;

			if (diffType == VALUE) {
				m = new Message(ERROR, XML_DIFFERENCE,
						String.format("For %s, expected value \"%s\", but got \"%s\"", desc, leftValue, rightValue),
						left.getFile(), right.getFile(),
						leftNode.getXpathLocation(), rightNode.getXpathLocation(),
						objType, null, diffType,
						leftValue, rightValue
						);
			} else {
				m = new Message(ERROR, XML_DIFFERENCE,
						String.format("%s %s: \"%s\"", diffType.toString().toLowerCase(), desc, msgValue),
						left.getFile(), right.getFile(),
						leftNode.getXpathLocation(), rightNode.getXpathLocation(),
						objType, null, diffType,
						leftValue, rightValue
						);
			}

			messages.add(m);
			
//TODO DifferenceConstants.SCHEMA_LOCATION,
//TODO DifferenceConstants.NO_NAMESPACE_SCHEMA_LOCATION,

		} else {
			/*
			 * We don't recognize the Difference object.
			 *
			 * But we need to report it even so, so assume that, as its name
			 * implies, it does indeed signify an XML_DIFFERENCE.
			 */
			messages.add(new Message(ERROR, XML_DIFFERENCE,
					desc,
					left.getFile(), right.getFile(),
					leftNode.getXpathLocation(), rightNode.getXpathLocation(),
					null, null, null,
					leftNode.getValue(), rightNode.getValue()));
		}
	}
	
	public static List<Node> getChildNodes(String xpathExpr, Node source) throws XPathException {
		List<Node> children = new LinkedList<Node>();
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xp = xpf.newXPath();
		
		Object res = xp.evaluate(xpathExpr, source, XPathConstants.NODE);
		Node n = (Node)res;

		if (n == null) {
			throw new XPathException("No node found matching XPath expression \"" + xpathExpr + "\"");
		}
		
		NodeList nl = n.getChildNodes();
		
		for (int i=0; i<nl.getLength(); ++i) {
			children.add(nl.item(i));
		}
		
		return children;
	}
}
