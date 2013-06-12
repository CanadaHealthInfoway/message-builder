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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.datatype.mif;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.apache.xerces.dom.DocumentFragmentImpl;
import org.apache.xerces.xni.parser.XMLDocumentFilter;
import org.cyberneko.html.filters.Purifier;
import org.cyberneko.html.parsers.DOMFragmentParser;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class MifTextConverter implements Converter<MifText> {

	@Override
	public MifText read(InputNode node) throws Exception {
		MifText mifText = new MifText();
		String nodeValue = node.getValue();		
		InputNode childNode = node.getNext();
		if (childNode == null) {
			//mifText.setValue(StringEscapeUtils.escapeXml(nodeValue));
			mifText.setValue(nodeValue);
		} else {
			while(childNode != null) {
				String childValue = childNode.getValue();
				if (childValue != null) {
					String childText = childValue + parseInnerNodes(childNode);
					mifText.getParagraphs().add(new MifHttpParagraph(StringEscapeUtils.escapeXml(childText)));					
				} else {
					String childText = parseInnerNodes(childNode);
					mifText.getParagraphs().add(new MifHttpParagraph(StringEscapeUtils.escapeXml(childText)));
				}
				
				childNode = node.getNext();
			}
		}
		return mifText;
	}
	
	private String parseInnerNodes(InputNode node) throws Exception {
		InputNode childNode = node.getNext();
		String nodeValue = node.getValue();
		String nodeText = nodeValue!=null?nodeValue:"";
		
		while(childNode != null) {
			String childValue = childNode.getValue();
			String childName = childNode.getName();
			NodeMap<InputNode> attributes = childNode.getAttributes();
			nodeText += "<" + childName;
			for (String attributeName : attributes) {
				InputNode attributeNode = attributes.get(attributeName);
				nodeText += " " + attributeName + "='" + attributeNode.getValue() + "'";
			}
				
			String childText = "";
			childText = parseInnerNodes(childNode);
			if (childText != null && childText.trim().length() > 0){
				//Case where there are inner nodes ie. <b><i>Some Text</i><b>
				nodeText += ">";
				nodeText += childText.trim();
				nodeText += "</" + childName + ">";
			} else if (childValue != null && childValue.trim().length() > 0) {
				//Case where there is inner text but not inner nodes <b>Some Text</b>
				nodeText += ">";
				nodeText += childValue.trim();
				nodeText += "</" + childName + ">";
			} else {
				//Case where there is no inner node or inner text <img src='test' />
				nodeText += "/>";
				nodeText += childText.trim();
			}
			
			nodeValue = node.getValue();
			while(nodeValue != null) {				
				nodeText += nodeValue;
				nodeValue = node.getValue();
			}
			
			childNode = node.getNext();
		}
		return nodeText;
	}

	@Override
	public void write(OutputNode node, MifText value) throws Exception {
		List<MifHttpParagraph> paragraphs = value.getParagraphs();
		if (paragraphs.size() > 0) {
			for (MifHttpParagraph mifHttpParagraph : paragraphs) {
				Namespace namespace = mifHttpParagraph.getClass().getAnnotation(Namespace.class);
				OutputNode child = null;
				if (namespace != null) {
					child = node.getChild(namespace.prefix() + ":p");
					child.getNamespaces().put(namespace.reference(), namespace.prefix());
				} else {
					child = node.getChild("p");
				}
				child.setData(true);
				//String html = StringEscapeUtils.unescapeXml(mifHttpParagraph.getValue());
				String html =mifHttpParagraph.getValue();
				String xml = purifyHtmlToXmlFormat(html);
				child.setValue(xml);
			}
		} else {
			if(!StringUtils.isBlank(value.getValue())){
				//String html = StringEscapeUtils.unescapeXml(value.getValue());
				String html = value.getValue();
				String xml = purifyHtmlToXmlFormat(html);
				node.setValue(xml);
			}
		}
	}
	
	String purifyHtmlToXmlFormat(String html) throws Exception {
		Purifier purifier = new Purifier();
		XMLDocumentFilter[] filters = {purifier};
		DOMFragmentParser parser = new DOMFragmentParser();
		parser.setProperty("http://cyberneko.org/html/properties/filters", filters);
		parser.setProperty("http://cyberneko.org/html/properties/default-encoding", "UTF-8");
		parser.setProperty("http://cyberneko.org/html/properties/names/elems", "match");
		DocumentFragment fragment = new DocumentFragmentImpl(new CoreDocumentImpl());
		InputSource source = new InputSource(new StringReader(html));
		parser.parse(source, fragment);
		String xml = nodeToString(fragment);
		
		return xml;
	}
	
    public void print(Node node, String indent) {
        System.out.println(node.getNodeName() + " : " + node.getNodeValue() + "|");
        Node child = node.getFirstChild();
        while (child != null) {
            print(child, indent+" ");
            child = child.getNextSibling();
        }
    }
    
    private String nodeToString(Node node) {
    	StringWriter sw = new StringWriter();
    	try {
    		Transformer t = TransformerFactory.newInstance().newTransformer();
    		t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    		t.transform(new DOMSource(node), new StreamResult(sw));
    	} catch (TransformerException ex) {
    		ex.printStackTrace();
    		return null;
    	}
    	return sw.toString();
    }
}
