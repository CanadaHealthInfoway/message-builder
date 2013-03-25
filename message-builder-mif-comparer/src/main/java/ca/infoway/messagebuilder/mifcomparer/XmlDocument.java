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

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.XML_ERROR;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.ERROR;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlDocument {
	private File file;
	private String xml;
	private Document document;
	private NamespaceContext nsContext;


	public XmlDocument(MifFile mf) {
		this.file = mf.getFile();
		this.xml = null;
	}

	public XmlDocument(File f) {
		this.file = f;
		this.xml = null;
	}

	public XmlDocument(String name, String xml) {
		this.file = new File(name);
		this.xml = xml;
	}
	
	public XmlDocument(String xml) {
		this("(explicit xml)", xml);
	}

	public File getFile() {
		return this.file;
	}

	public String readContent() throws IOException {
		if (this.xml == null) {
			this.xml = FileUtils.readFileToString(this.getFile());
		}

		return this.xml;
	}

	public Document getDocument() throws SAXParseException {
		if (document == null) {
			parse();
		}
		
		return document;
	}
	
	private void parse() throws SAXParseException {
		DocumentBuilder db = getDocumentBuilder();

		String xml;
		try {
			xml = this.readContent();
		} catch (IOException e) {
			throw new FatalConditionException(e.getMessage(), e);
		}

		try {
			Reader r = new StringReader(xml);
			InputSource is = new InputSource(r);
			this.document = db.parse(is);
		} catch (SAXParseException e) {
			throw e;
		} catch (SAXException e) {
			throw new FatalConditionException("XML error in "
					+ getFile().toString(), e);
		} catch (IOException e) {
			throw new FatalConditionException("XML error in "
					+ getFile().toString(), e);
		}
	}

	static DocumentBuilder getDocumentBuilder() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			return dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException("Internal error", e);
		}
	}


}
