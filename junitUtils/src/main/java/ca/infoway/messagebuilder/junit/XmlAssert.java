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

package ca.infoway.messagebuilder.junit;

import static org.apache.commons.lang.StringUtils.trimToEmpty;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XmlAssert extends Assert {
    static class XmlTree {

        private Document document;
        private Element currentNode;

        public XmlTree(Document document) {
            this.document = document;
            this.currentNode = null;
        }

        public Object elements() {
            return null;
        }

        public Element nextElement() {
            if (this.document != null) {
                this.currentNode = this.document.getDocumentElement();
                this.document = null;
            } else {
                Element temp = nextChildElement();
                if (temp == null) {
                    temp = nextSiblingElement();
                }
                if (temp == null) {
                    temp = nextSiblingOfAncestor();
                }
                this.currentNode = temp;
                
            }
            return this.currentNode;
        }

        private Element nextSiblingOfAncestor() {
            return nextSiblingOfAncestor(this.currentNode);
        }

        private Element nextSiblingOfAncestor(Element element) {
            if (element.getParentNode().getNodeType() == Node.ELEMENT_NODE) {
                Element result = nextSiblingElement(element.getParentNode());
                if (result == null) {
                    return nextSiblingOfAncestor((Element) element.getParentNode());
                } else {
                    return result;
                }
            } else {
                return null;
            }
        }

        private Element nextSiblingElement() {
            return nextSiblingElement(this.currentNode);
        }

        private Element nextSiblingElement(Node node) {
            while (true) {
                node = node.getNextSibling();
                if (node == null || node.getNodeType() == Node.ELEMENT_NODE) {
                    break;
                }
            }
            return (Element) node;
        }

        private Element nextChildElement() {
            Element result = null;
            if (this.currentNode.hasChildNodes()) {
                NodeList children = this.currentNode.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        result = (Element) children.item(i);
                        break;
                    }
                }
            }
            return result;
        }

        public String describe() {
            return describe(this.currentNode);
        }

        private String describe(Node node) {
            if (node instanceof Element) {
                return describe(node.getParentNode()) + "/" + getLocalOrTagName(((Element) node));
            } else {
                return "";
            }
        }

        public boolean isLeaf() {
            if (this.currentNode.hasChildNodes() 
                    && this.currentNode.getChildNodes().getLength() == 1 
                    && (this.currentNode.getFirstChild().getNodeType() == Node.TEXT_NODE ||
                        this.currentNode.getFirstChild().getNodeType() == Node.CDATA_SECTION_NODE)) {
                return true;
            } else {
                return !this.currentNode.hasChildNodes();
            }
        }
    }
    
    public static void assertTreeEquals(Document expected, Document xml) {
        assertTreeEquals(new XmlTree(expected), new XmlTree(xml));
    }

    private static void assertTreeEquals(XmlTree expected, XmlTree actual) {
    	List<String> checkedActualAttributes;
        for (Element expectedNode = expected.nextElement(); expectedNode != null; expectedNode = expected.nextElement()) {
            Element actualNode = actual.nextElement();
            assertNotNull("expected a node " + expected.describe(), actualNode);
            assertEquals(expected.describe(), getLocalOrTagName(expectedNode), getLocalOrTagName(actualNode));
            assertEquals(expected.describe() + " xmlns", trimToEmpty(expectedNode.getNamespaceURI()), trimToEmpty(actualNode.getNamespaceURI()));
            
            NamedNodeMap actualAttributes = actualNode.getAttributes();
            checkedActualAttributes = new ArrayList<String>();
            for( int i = 0; i < actualAttributes.getLength(); i++ ) {
            	checkedActualAttributes.add(((Attr) actualAttributes.item(i)).getName());
            }

            NamedNodeMap expectedAttributes = expectedNode.getAttributes();
            for (int i = 0; i < expectedAttributes.getLength(); i++) {
                Attr attr = (Attr) expectedAttributes.item(i);
                if (!attr.getName().startsWith("xmlns")) {
                    assertEquals(expected.describe() + "/@" + attr.getName(), 
                            attr.getValue(), 
                            actualNode.getAttribute(attr.getName()));
                }
                checkedActualAttributes.remove(attr.getName());
            }
        	assertTrue("Extra attributes present in actual node: " + actual.describe() + ", " + StringUtils.join(checkedActualAttributes, ", "), checkedActualAttributes.size() == 0);

        	if (expected.isLeaf()) {
                assertEquals(expected.describe() + "/text()", 
                        getTextValue(expectedNode, false).trim(), getTextValue(actualNode, false).trim());
                if (expectedNode.getFirstChild() != null && actualNode.getFirstChild() != null) {
                    assertEquals(expected.describe() + " nodeType", 
                            expectedNode.getFirstChild().getNodeType(), 
                            actualNode.getFirstChild().getNodeType());
                }
            }
        }
        assertHasNoMoreElements(actual);
    }

    private static void assertHasNoMoreElements(XmlTree tree) {
    	if (tree.elements() != null) {
    		Element next = tree.nextElement();
    		assertNull("more elements: " + tree.describe(), next);
    	}
    }
    
	/**
	 * <p>Get the local or tag name (depending on whether or not the DOM tree was
	 * parsed with namespace awareness.
	 * 
	 * @param node - the node/element 
	 * @return - the local name, if it is not blank; the tag name otherwise.
	 */
    
	private static String getLocalOrTagName(Node node) {
		return StringUtils.isBlank(node.getLocalName()) ? node.getNodeName() : node.getLocalName();
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
    private static String getTextValue(Node node, boolean recurse) {

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
}
