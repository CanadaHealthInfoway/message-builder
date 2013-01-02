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

package ca.infoway.messagebuilder.util.xml;

import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.lang.XmlStringEscape;

/**
 * <p>Some utilities for describing XML elements.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class XmlDescriber {

	/**
	 * <p>A utility that creates an XPath-like path for a particular node.
	 * 
	 * @param node - the node being described.
	 * @return - the xpath location of the node.
	 */
	public static String describePath(Node node) {
		if (node == null) {
			return StringUtils.EMPTY;
		} else if (node instanceof Attr) {
	        return describePath(((Attr) node).getOwnerElement()) + "/@" + ((Attr) node).getName();
		} else if (node instanceof Element) {
			return describePath(node.getParentNode()) + "/" + describeElement((Element) node);
	    } else {
	        return StringUtils.EMPTY;
	    }
	}

	/**
	 * <p>A utility to provide an element name, with an index number if it is a 
	 * repeating element.
	 * 
	 * @param node - the element
	 * @return - an XML-like repesentation of the element.
	 */
	private static String describeElement(Element node) {
		String index = StringUtils.EMPTY;
		
		if (hasSiblingOfSameName(node)) {
			index = getStringIndexOf(node);
		}
		
		return getLocalOrTagName(((Element) node)) + index;
	}

	private static String getStringIndexOf(Element start) {
		return "[" + getIndexOf(start) + "]";
	}

	/**
	 * <p>A utility to determine which repetition of a particular element name this 
	 * element represents.  This method is used to create an xpath-like index for 
	 * repeating elements.
	 * 
	 * @param start - the element
	 * @return - the index.
	 */
	public static int getIndexOf(Element start) {
		int count = 1;
		for (Node node = start.getPreviousSibling(); node != null; node = node.getPreviousSibling()) {
			if (hasSameName(start, node)) {
				count++;
			}
		}
		return count;
	}

	private static boolean hasSiblingOfSameName(Element node) {
		int count = 0;
		if (node.getParentNode() instanceof Element) {
			NodeList childs = node.getParentNode().getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				Node child = childs.item(i);
				if (hasSameName(node, child)) {
					count++;
				}
				if (count > 1) {
					break;
				}
			}
			return count > 1;
		} else {
			return false;
		}
	}

	private static boolean hasSameName(Element node, Node child) {
		return child.getNodeType() == Node.ELEMENT_NODE
			&& StringUtils.equals(getLocalOrTagName((Element) child),
				getLocalOrTagName((Element) node));
	}

	/**
	 * <p>A utility that creates a representation of the element and its attributes. 
	 * This representation would typically be used in error messages to help the
	 * user recognize which element is a problem.
	 * 
	 * @param element - the element
	 * @return - an XML-like repesentation of the element.
	 */
	public static String describeSingleElement(Element element) {
		StringBuilder builder = new StringBuilder();
		builder.append("<").append(NodeUtil.getLocalOrTagName(element));
		NamedNodeMap attributes = element.getAttributes();
		ArrayList<String> set = new ArrayList<String>();
		for (int i = 0, length = attributes == null ? 0 : attributes.getLength(); i < length; i++) {
			Attr item = (Attr) attributes.item(i);
			set.add(item.getName());
		}
		
		Collections.sort(set);
		
		for (String name : set) {
			Attr item = (Attr) attributes.getNamedItem(name);
			builder.append(" ").append(NodeUtil.getLocalOrTagName(item)).append("=\"").append(XmlStringEscape.escape(item.getValue())).append("\"");
		}
		
		if (element.hasChildNodes()) {
			builder.append(">");
		} else {
			builder.append("/>");
		}
		return builder.toString();
	}
}
