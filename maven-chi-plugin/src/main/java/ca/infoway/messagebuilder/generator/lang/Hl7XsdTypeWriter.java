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

package ca.infoway.messagebuilder.generator.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.TypeName;


public abstract class Hl7XsdTypeWriter implements Hl7TypeWriter {

	protected static final String MESSAGEBUILDER_SIMPLEXML_V1 = "urn:ca.infoway.messagebuilder.simplexml.v1";
	protected final Set<String> includes = Collections.synchronizedSet(new HashSet<String>());
	
	protected final TypeAnalysisResult typeResults;

	public Hl7XsdTypeWriter(TypeAnalysisResult typeResults) {
		this.typeResults = typeResults;
	}
	
	protected Type getType(TypeName typeName) {
		return this.typeResults.getTypes().get(typeName);
	}
	
	public void write(Writer writer) throws IOException, GeneratorException {
		Document document = new DocumentFactory().newDocument();
		document.setXmlStandalone(true);
		Element schema = document.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "xs:schema");
		schema.setAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":chi", MESSAGEBUILDER_SIMPLEXML_V1);
		schema.setAttribute("targetNamespace", MESSAGEBUILDER_SIMPLEXML_V1);
		schema.setAttribute("elementFormDefault", "qualified");
	
		writeContents(schema);
	
		document.appendChild(schema);
		writeDocument(writer, document);
	}
	
	protected void writeDocument(Writer writer, Document document)
			throws TransformerFactoryConfigurationError, IOException {
		try {
			DOMSource source = new DOMSource(document);
			StringWriter stringWriter = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, new StreamResult(stringWriter));
			writer.append(stringWriter.toString());
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}	

	protected void addInclude(Element schema, String includeName) {
		if (!includeName.equals(getTypeName()) && this.includes.add(includeName)) {
			Document document = schema.getOwnerDocument();
			Element include = document.createElement("xs:include");
			include.setAttribute("schemaLocation", includeName + ".xsd");
			Node firstChild = schema.getFirstChild();
			schema.insertBefore(include, firstChild);
		}
	}

	protected abstract void writeContents(Element schema) throws GeneratorException;
	protected abstract String getTypeName();
}
