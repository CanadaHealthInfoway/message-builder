/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * <p>A utility that renders a DOM tree into a String representation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class XmlRenderer {

	/**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @return - the XML.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static String render(Document document) throws TransformerException {
    	StringWriter writer = new StringWriter();
    	render(document, writer);
    	return writer.toString();
    }
	/**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @param writer - the writer to which the XML should be rendered.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static void render(Document document, Writer writer) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
    }
}