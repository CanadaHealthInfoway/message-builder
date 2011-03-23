package ca.infoway.messagebuilder.j5goodies;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class XPathHelper {
    
    class NamespaceContextImpl implements NamespaceContext {

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

        @SuppressWarnings("unchecked")
		public Iterator getPrefixes(String namespaceURI) {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * <p>Get a single node.
     * @param base - the base node
     * @param xpathExpression - the xpath expression.
     * @return - the node.
     * @throws XPathExpressionException - if the XPath is not valid
     */
    public Node getSingleNode(Node base, String xpathExpression) throws XPathExpressionException {
        XPath xpath = createXpath();
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (Node) expression.evaluate(base, XPathConstants.NODE);
    }

    /**
     * <p>Get a list of nodes.
     * @param base - the base node
     * @param xpathExpression - the xpath expression.
     * @return - the node list.
     * @throws XPathExpressionException - if the XPath is not valid
     */
    public NodeList getNodes(Node base, String xpathExpression) throws XPathExpressionException {
        XPath xpath = createXpath();
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (NodeList) expression.evaluate(base, XPathConstants.NODESET);
    }

    /**
     * <p>Get a list of nodes.
     * @param base - the base node
     * @param xpathExpression - the xpath expression (namespace aware).
     * @param namespace - the namespace.
     * @return - the node list.
     * @throws XPathExpressionException - if the XPath is not valid
     */
    public NodeList getNodes(Node base, String xpathExpression, String namespace) throws XPathExpressionException {
        XPath xpath = createXpath(new NamespaceContextImpl(namespace));
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (NodeList) expression.evaluate(base, XPathConstants.NODESET);
    }

    private XPath createXpath(NamespaceContext namespaceContext) {
    	XPath xpath = createXpath();
    	xpath.setNamespaceContext(namespaceContext);
		return xpath;
	}

    /**
     * <p>Get a single node.
     * @param base - the base node
     * @param xpathExpression - the xpath expression (namespace aware).
     * @param namespace - the namespace.
     * @return - the node.
     * @throws XPathExpressionException - if the XPath is not valid
     */
	public Node getSingleNode(Node base, String xpathExpression, String namespace) throws XPathExpressionException {
        XPath xpath = createXpath();
        xpath.setNamespaceContext(new NamespaceContextImpl(namespace));
        XPathExpression expression = xpath.compile(xpathExpression);
        
        return (Node) expression.evaluate(base, XPathConstants.NODE);
    }

	private XPath createXpath() {
		return XPathFactory.newInstance().newXPath();
	}

    /**
     * <p>Get an attribute value.
     * @param base - the base node
     * @param xpathExpression - the xpath expression (namespace aware).
     * @param namespace - the namespace.
     * @return - the attribute value.
     * @throws XPathExpressionException - if the XPath is not valid
     */
	public String getAttributeValue(Node base, String xpathExpression, String namespace) throws XPathExpressionException {
        XPath xpath = createXpath(new NamespaceContextImpl(namespace));
        XPathExpression expression = xpath.compile(xpathExpression);
		Attr attribute = (Attr) expression.evaluate(base, XPathConstants.NODE);
		return attribute == null ? null : attribute.getValue();
	}
}