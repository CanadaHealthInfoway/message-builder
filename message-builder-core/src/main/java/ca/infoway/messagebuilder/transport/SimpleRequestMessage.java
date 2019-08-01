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

package ca.infoway.messagebuilder.transport;

import static ca.infoway.messagebuilder.util.xml.NodeUtil.getLocalOrTagName;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.XmlRenderer;

/**
 * <p>A basic implementation of a message that can be sent across a transport layer. Allows the message to be accessed as
 * a string or as a Document. 
 * 
 * <p>Must make use of static creation methods in order to construct a SimpleRequestMessage. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - transport - TBD!
 */
public class SimpleRequestMessage implements RequestMessage {

	private final String message;
	private final Document document;

	private SimpleRequestMessage(String message, Document document) {
		this.message = message;
		this.document = document;
	}

	/**
	 * <p>Obtains the message's interaction id. 
	 * 
	 * @return the message's interaction id
	 * @throws TransportLayerException if the message's interaction id could not be determined
	 */
	public String getInteractionId() throws TransportLayerException {
		return getLocalOrTagName(this.document.getDocumentElement());
	}
	
	/**
	 * <p>Obtains the message as a DOM, converting the underlying structure if necessary (i.e. string -&gt; DOM). 
	 * 
	 * @return the underlying message in a DOM structure
	 * @throws TransportLayerException if there were problems creating the DOM
	 */
	public Document getMessageAsDocument() throws TransportLayerException {
		return this.document;
	}

	/**
	 * <p>Obtains the message as a string, converting the underlying structure if necessary (i.e. DOM -&gt; string). 
	 * 
	 * @return the underlying message rendered as a string
	 * @throws TransportLayerException if a string representation of the message could not be constructed
	 */
	public String getMessageAsString() throws TransportLayerException {
		return this.message;
	}

	/**
	 * <p>Create a message object based on a string.
	 * 
	 * @param message the message as a string
	 * @return the constructed message object
	 * @throws TransportLayerException if the message could not be converted into a Document
	 */
	public static RequestMessage create(String message) throws TransportLayerException {
		try {
			Document document = new DocumentFactory().createFromString(message);
			return new SimpleRequestMessage(message, document);
		} catch (SAXException e) {
			throw new TransportLayerException("Problem parsing string representation of an XML message: " + e.getMessage());
		}
	}
	
	/**
	 * <p>Create a message object based on a Document.
	 * 
	 * @param message the message as a Document
	 * @return the constructed message object
	 * @throws TransportLayerException if the message could not be rendered as a string
	 */
	public static RequestMessage create(Document message) throws TransportLayerException {
		try {
			return new SimpleRequestMessage(message == null ? null : XmlRenderer.render(message), message);
		} catch (TransformerException e) {
			throw new TransportLayerException("Problem rendering document to XML: " + e.getMessage());
		}
	}
	
	/**
	 * <p>Create a message object based on a Document and string representation.
	 * 
	 * @param messageAsDocument the message as a Document
	 * @param messageAsString the message as a string
	 * @return the constructed message object
	 * @throws TransportLayerException if the message could not be constructed
	 */
	public static RequestMessage create(Document messageAsDocument, String messageAsString) throws TransportLayerException {
		return new SimpleRequestMessage(messageAsString, messageAsDocument);
	}
	
}
