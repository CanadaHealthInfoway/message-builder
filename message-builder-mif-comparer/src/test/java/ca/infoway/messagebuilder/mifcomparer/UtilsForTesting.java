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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class UtilsForTesting {
	private static final String NEWLINE = System.getProperty("line.separator");


	/**
	 * Static utility methods, so don't let people instantiate us
	 */
	private UtilsForTesting() {
	}
	
	/**
	 * Sort the given Message objects, convert them to Strings, and concatenate
	 * the results.  This can be used to assert the equality of two Message lists, ignoring order,
	 * in such a way that Eclipse can display the results should the assertion fail.
	 */
	static String messagesToSortedString(Collection<Message> msgs) {
		List<String> strings = new LinkedList<String>();
		for (Message m : msgs) {
			strings.add(m.toString() + NEWLINE);
		}
		
		Collections.sort(strings);
		
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s);
		}
		
		return sb.toString();
	}
	
	static String messagesToSortedString(Message[] msgs) {
		return messagesToSortedString(Arrays.asList(msgs));
	}
	
	/**
	 * Given some XML, turn it into a DOM Document.
	 */
	static Document xml2DOM(String xml) throws SAXException, IOException {
		Reader r = new StringReader(xml);
		InputSource is = new InputSource(r);
		DocumentBuilder db = XmlDocument.getDocumentBuilder();
		Document doc = db.parse(is);
		
		return doc;
	}
	
	static String dom2XML(Document doc) {
		DOMImplementationLS dils = (DOMImplementationLS)doc.getImplementation(); 
		return dils.createLSSerializer().writeToString(doc);
	}
}
