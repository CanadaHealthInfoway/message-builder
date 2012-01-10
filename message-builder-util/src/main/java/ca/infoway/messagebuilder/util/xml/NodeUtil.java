/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * <p>A variety of utility methods for manipulating nodes.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class NodeUtil {
	
    /**
     *  <p>Scan all immediate children of a node, and append all
     *  text nodes into a string.  Consider the following example:</p>
     *
     *  <pre>
     *  &lt;customer&gt;Joe Schmoe&lt;/customer&gt;
     *  </pre>
     *
     *  <p>  In this case, calling this method on the
     *  <code>customer</code> element returns "Joe Schmoe".</p>
     *  
     *  @param node - the node to scan
     *  @return - the text string
     */
    public static String getTextValue(Node node) {
    	return getTextValue(node, false);
    }

    /**
     *  <p>Scan all immediate children of a node, and append all
     *  text nodes into a string.  Consider the following example:</p>
     *
     *  <pre>
     *  &lt;customer&gt;Joe Schmoe&lt;/customer&gt;
     *  </pre>
     *
     *  <p>  In this case, calling this method on the
     *  <code>customer</code> element returns "Joe Schmoe".</p>
     *  
     *  @param node - the node to scan
     *  @param recurse - a flag to indicate whether or not to recurse into 
     *    sub-elements
     *  @return - the text string
     */
    public static String getTextValue(Node node, boolean recurse) {

        String text = null;
        if (node != null) {
            text = "";
            NodeList textList = node.getChildNodes();
            for (int i = 0; i < textList.getLength(); i++) {
               	Node child = textList.item(i);
               	if (child.getNodeType() == Node.TEXT_NODE 
               			|| child.getNodeType() == Node.CDATA_SECTION_NODE) {
                   	text += ((Text) child).getData();
               	} else if (recurse && child.getNodeType() == Node.ELEMENT_NODE) {
               		text += getTextValue(child, recurse);
               	}
            }
        }
        return text;
    }

    /**
     * <p>Treat the NodeList as a standard list.
     * @param children - the node list
     * @return - the list of nodes
     */
	public static List<Node> asList(NodeList children) {
		List<Node> nodes = new ArrayList<Node>();
		int length = children == null ? 0 : children.getLength();
		for (int i = 0; i < length; i++) {
			nodes.add(children.item(i));
		}
		return nodes;
	}

    /**
     * <p>Get all children of a particular tag name as a list.
     * @param node - the parent node
     * @param tagName - the tag name to select
     * @return - the list of nodes
     */
	public static List<Node> getChildNodes(Node node, String tagName) {
		if (node.getNodeType() != Node.ELEMENT_NODE) {
			return Collections.<Node>emptyList();
		} else {
			return asList(((Element) node).getElementsByTagName(tagName));
		}
	}

    /**
     * <p>Get all child elements of the given node as a list of elements.
     * @param node - the node 
     * @return - the list of child elements
     */
	public static List<Element> toElementList(Node node) {
	    List<Element> elements = new ArrayList<Element>();
	    NodeList childNodes = node.getChildNodes();
	    int length = childNodes == null ? 0 : childNodes.getLength();
	    for (int i = 0; i < length; i++) {
	        Node childNode = childNodes.item(i);
	        if (childNode instanceof Element) {
	            elements.add((Element)childNode);
	        }
	    }
	    return elements;
	}

	/**
	 * <p>Get the local or tag name (depending on whether or not the DOM tree was
	 * parsed with namespace awareness.
	 * 
	 * @param node - the node/element 
	 * @return - the local name, if it is not blank; the tag name otherwise.
	 */
	public static String getLocalOrTagName(Node node) {
		return StringUtils.isBlank(node.getLocalName()) ? node.getNodeName() : node.getLocalName();
	}
}
