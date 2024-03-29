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

package ca.infoway.messagebuilder.generator.util;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.Validate;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


/**
 * <p>A utility to make XPath operations easier.
 * 
 * <p>This utility supports both namespace-based and non-namespaced based operations. 
 * If the provided node was created with a namespace-aware parser, then you must use the
 * namespace version of these methods.
 * 
 * <p>For example:
 * 
 * <pre>
 * NodeList list = new XPathHelper().getNodes(document, 
 *                     "//x:myElement", "urn:mySchema.example.org");
 * </pre>
 * 
 * <p>In this example, the "x" prefix acts as a simple marker for the namespace; it 
 * doesn't matter what the name of the prefix is.
 * 
 * @author BC Holmes
 */
public class XPathHelper {
    
    public class NamespaceContextImpl implements NamespaceContext {

        private final String namespace;

        public NamespaceContextImpl(String namespace) {
            this.namespace = namespace;
        }

        public String getNamespaceURI(String prefix) {
            return this.namespace;
        }

        public String getPrefix(String namespaceURI) {
            throw new UnsupportedOperationException();
        }

		public Iterator getPrefixes(String namespaceURI) {
            throw new UnsupportedOperationException();
        }

    }

    public Node getSingleNode(Node base, String xpathExpression) throws XPathExpressionException {
        XPath xpath = createXpath();
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (Node) expression.evaluate(base, XPathConstants.NODE);
    }

    public Node getSingleNode(Node base, String xpathExpression, Namespace... namespaces) throws XPathExpressionException {
    	XPath xpath = createXpath(new NamespaceContextMap(namespaces));
    	XPathExpression expression = xpath.compile(xpathExpression);
    	
    	return (Node) expression.evaluate(base, XPathConstants.NODE);
    }
    
    public NodeList getNodes(Node base, String xpathExpression) throws XPathExpressionException {
        XPath xpath = createXpath();
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (NodeList) expression.evaluate(base, XPathConstants.NODESET);
    }

    public NodeList getNodes(Node base, String xpathExpression, Namespace... namespaces) throws XPathExpressionException {
    	XPath xpath = createXpath(new NamespaceContextMap(namespaces));
    	XPathExpression expression = xpath.compile(xpathExpression);
    	
    	return (NodeList) expression.evaluate(base, XPathConstants.NODESET);
    }
    
    private XPath createXpath(NamespaceContext namespaceContext) {
    	XPath xpath = createXpath();
    	xpath.setNamespaceContext(namespaceContext);
		return xpath;
	}

	private XPath createXpath() {
		return XPathFactory.newInstance().newXPath();
	}

	public String getAttributeValue(Node base, String xpathExpression) throws XPathExpressionException {
		XPathExpression expression = createXpath().compile(xpathExpression);
        Attr attribute = (Attr) expression.evaluate(base, XPathConstants.NODE);
		return attribute == null ? null : attribute.getValue();
	}
	public String getAttributeValue(Node base, String xpathExpression, Namespace... namespaces) throws XPathExpressionException {
		XPath xpath = createXpath(new NamespaceContextMap(namespaces));
		XPathExpression expression = xpath.compile(xpathExpression);
		Attr attribute = (Attr) expression.evaluate(base, XPathConstants.NODE);
		return attribute == null ? null : attribute.getValue();
	}
	
	public String getTextString(Node base, String xpathExpression) throws XPathExpressionException {
		Validate.notNull(xpathExpression, "xpath expression cannot be null");
		if (!xpathExpression.endsWith("/text()")) {
			xpathExpression += "/text()";
		}
        XPathExpression expression = createXpath().compile(xpathExpression);
		Text text = (Text) expression.evaluate(base, XPathConstants.NODE);
		return text == null ? null : text.getData();
	}
	public String getTextString(Node base, String xpathExpression, Namespace... namespaces) throws XPathExpressionException {
		Validate.notNull(xpathExpression, "xpath expression cannot be null");
		if (!xpathExpression.endsWith("/text()")) {
			xpathExpression += "/text()";
		}
    	XPathExpression expression = createXpath(new NamespaceContextMap(namespaces)).compile(xpathExpression);
		Text text = (Text) expression.evaluate(base, XPathConstants.NODE);
		return text == null ? null : text.getData();
	}
}