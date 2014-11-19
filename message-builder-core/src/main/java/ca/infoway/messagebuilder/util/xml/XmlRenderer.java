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

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>A utility that renders a DOM tree into a String representation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class XmlRenderer {

	/**
	 * <p>Render the document to properly-formatted XML. No indenting, includes xml declaration.
	 * @param document - the document to render.
	 * @return - the XML.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static String render(Document document) throws TransformerException {
    	return render(document, false, -1);
    }

	/**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @param omitXmlDeclaration - omit the xml declaration
	 * @param indentLevel - amount to indent xml (-1 for no indenting)
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static String render(Document document, boolean omitXmlDeclaration, int indentLevel) throws TransformerException {
    	StringWriter writer = new StringWriter();
    	render(document, omitXmlDeclaration, indentLevel, writer);
    	return writer.toString();
    }

    /**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @param omitXmlDeclaration - omit the xml declaration
	 * @param indentLevel - amount to indent xml (-1 for no indenting)
	 * @param writer - the writer to which the XML should be rendered.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static void render(Document document, boolean omitXmlDeclaration, int indentLevel, Writer writer) throws TransformerException {
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	if (indentLevel > 0) {
//    		transformerFactory.setAttribute("indent-number", indentLevel);
//    		transformerFactory.setAttribute("indent-spaces ", indentLevel);
    	}
		Transformer transformer = transformerFactory.newTransformer();
        if (omitXmlDeclaration) {
        	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        }
        if (indentLevel > 0) {
        	transformer.setOutputProperty(OutputKeys.INDENT, "yes");        	
//        	transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", ""+indentLevel);
        }
        transformer.transform(new DOMSource(document), new StreamResult(writer));
    }
    
    public static Document obtainDocumentFromNode(Node node, boolean removeNamespaces) throws ParserConfigurationException {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document newDocument = builder.newDocument();
    	Node importedNode = newDocument.importNode(node, true);
    	newDocument.appendChild(importedNode);
    	// clear out any namespace that was brought along by the import (though this may not be desirable in all cases)
    	if (removeNamespaces) {
    		renameNamespaceRecursive(importedNode, null);
    	}
    	return newDocument;
    }
    
    private static void renameNamespaceRecursive(Node node, String namespace) {
        Document document = node.getOwnerDocument();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            document.renameNode(node, namespace, node.getNodeName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); ++i) {
            renameNamespaceRecursive(list.item(i), namespace);
        }
    }
}