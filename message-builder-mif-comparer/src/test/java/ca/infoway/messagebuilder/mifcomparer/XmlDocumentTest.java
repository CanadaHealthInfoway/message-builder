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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

public class XmlDocumentTest extends TestCase {
	@Test
	public void that_readContent_gets_content_of_an_existing_file() throws IOException {
		File f = getResourceAsFile("disk-based-directory-smoke-test/left-input/dir1/AAAA_AA111111CA - identical.mif");
		XmlDocument obj = new XmlDocument(f);
		
		String actual = obj.readContent();
		
		assertTrue("actual result should contain \"<same-on-both-sides/>\", but does not", actual.contains("<same-on-both-sides/>"));
	}
	
	@Test
	public void that_readContent_with_nonexistent_file_throws_FileNotFoundException_with_useful_message() throws IOException {
		File f = new File("ZZZZ_ZZ999999CA - nonexistent.mif");
		XmlDocument doc = new XmlDocument(f);
		
		exception.expect(FileNotFoundException.class);
		exception.expectMessage("File '" + f + "' does not exist");
		doc.readContent();
	}	
	
	@Test
	public void that_readContent_with_directory_throws_FileNotFoundException_with_useful_message() throws IOException {
		File f = getResourceAsFile("tiny-mif-dir");
		XmlDocument doc = new XmlDocument(f);
		
		exception.expect(IOException.class);
		exception.expectMessage("File '" + f + "' exists but is a directory");
		doc.readContent();
	}
	
	@Test
	public void that_parse_can_parse_an_existing_file() throws IOException, SAXParseException {
		File f = getResourceAsFile("disk-based-directory-smoke-test/left-input/dir1/AAAA_AA111111CA - identical.mif");
		XmlDocument obj = new XmlDocument(f);
		
		Document doc = obj.getDocument();
		
		assertEquals("outer", doc.getFirstChild().getNodeName());
	}
	
	@Test
	public void that_parse_can_parse_explicit_xml() throws IOException, SAXParseException {
		XmlDocument obj = new XmlDocument("fake-file-name", "<rootNode/>");
		
		Document doc = obj.getDocument();
		
		assertEquals("rootNode", doc.getFirstChild().getNodeName());
	}	

	@Test
	public void that_parse_throws_SAXParseException_on_xml_error() throws IOException, SAXParseException {
		XmlDocument obj = new XmlDocument("fake-file-name", "<rootNode>");	// Intentional error; no close tag
		
		exception.expect(SAXParseException.class);
		obj.getDocument();
	}
}
