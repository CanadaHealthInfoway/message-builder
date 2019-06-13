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
import java.util.ArrayList;
import java.util.Collections;
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
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class MifSimpleTextConverter implements Converter<MifSimpleText> {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Override
	public MifSimpleText read(InputNode node) throws Exception {
		MifSimpleText mifText = new MifSimpleText();
		String nodeValue = node.getValue();		
		InputNode childNode = node.getNext();
		if (childNode == null) {
			//mifText.setValue(StringEscapeUtils.escapeXml(nodeValue));
			mifText.setValue(nodeValue);
		} else {
			String text = ""; 
			while(childNode != null) {
				NodeMap<InputNode> attributes = childNode.getAttributes();
				text += "<" + childNode.getName();
				for (String attributeName : sortAttributes(attributes)) {
					InputNode attributeNode = attributes.get(attributeName);
					text += " " + attributeName + "='" + attributeNode.getValue() + "'";
				}
				
				text += ">" + LINE_SEPARATOR;
				String childValue = childNode.getValue();
				if (childValue != null) {
					String childText = parseInnerNodes(childNode, childValue, 1);
					text += "\t" + childText.trim();					
				} else {
					String childText = parseInnerNodes(childNode, "", 1);
					text += "\t" + childText.trim();
				}
				text += LINE_SEPARATOR + "</" + childNode.getName() + ">" + LINE_SEPARATOR;
				childNode = node.getNext();
			}
			mifText.setValue(StringEscapeUtils.escapeXml(text));
		}
		return mifText;
	}
	
	private String parseInnerNodes(InputNode node, String currentInput, Integer indentLevel) throws Exception {
		InputNode childNode = node.getNext();
		String nodeText = new String(currentInput);
		while(childNode != null) {
			String childValue = childNode.getValue();
			String childName = childNode.getName();
			NodeMap<InputNode> attributes = childNode.getAttributes();
			nodeText += getIndent(indentLevel) + "<" + childName;
			for (String attributeName : sortAttributes(attributes)) {
				InputNode attributeNode = attributes.get(attributeName);
				nodeText += " " + attributeName + "='" + attributeNode.getValue() + "'";
			}
				
			String childText = "";
			if (childValue != null && childValue.trim().length() > 0) {
				childText = parseInnerNodes(childNode, childValue, indentLevel+1);
				if (childText != null && childText.trim().length() > 0) {
					nodeText += ">";
					nodeText += childText.trim();
					nodeText += "</" + childName + ">" + LINE_SEPARATOR;
				} else {
					nodeText += "/>" + LINE_SEPARATOR;
					nodeText += childText.trim();
				}
			} else {
				childText = parseInnerNodes(childNode, "", indentLevel+1);
				if (childText != null && childText.trim().length() > 0) {
					nodeText += ">"  + LINE_SEPARATOR + getIndent(indentLevel+1);
					nodeText += childText.trim() + LINE_SEPARATOR + getIndent(indentLevel);
					nodeText += "</" + childName + ">" + LINE_SEPARATOR;
				} else {
					nodeText += "/>" + LINE_SEPARATOR;
					nodeText += childText.trim();
				}
			}
			childNode = node.getNext();
		}
		return nodeText;
	}
	
	private String getIndent(Integer indentLevel) {
		String result = "";
		if (indentLevel != null) {
			for(int i = 0; i<indentLevel; i++) {
				result += "\t";
			}
		}
		return result;
	}
	
	private List<String> sortAttributes(NodeMap<InputNode> attributes) {
		List<String> result = new ArrayList<String>();
		for (String attributeName : attributes) {
			result.add(attributeName);
		}
		Collections.sort(result);
		
		return result;
		
	}

	@Override
	public void write(OutputNode node, MifSimpleText value) throws Exception {
		//FIXME: We only care about reading in DT coremifs right now (this will likely need to be updated to regenerate the dt coremifs properly) 
		if(!StringUtils.isBlank(value.getValue())){
			//String html = StringEscapeUtils.unescapeXml(value.getValue());
			String html = value.getValue();
			String xml = purifyHtmlToXmlFormat(html);
			node.setValue(xml);
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
