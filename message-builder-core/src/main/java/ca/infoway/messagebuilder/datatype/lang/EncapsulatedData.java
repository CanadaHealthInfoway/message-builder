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

package ca.infoway.messagebuilder.datatype.lang;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.XmlRenderer;

/**
 * R2-specific ED data type 
 * 
 * <p>This class represents data that is primarily intended for human interpretation
 * or for further machine processing outside the scope of HL7.  Examples include
 * PDF documents, images, XML or other content types.
 *
 * <p>This includes unformatted or formatted written language, multimedia data, or
 * structured information in as defined by a different standard (e.g., XML-signatures.)
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class EncapsulatedData {

	private static final DocumentFactory DOCUMENT_FACTORY = new DocumentFactory();
	
	private TelecommunicationAddress reference;
	private EncapsulatedData thumbnail;
	
	private EdRepresentation representation;
	private x_DocumentMediaType mediaType;
	private String language;
	private Compression compression;
	private String integrityCheck;
	private IntegrityCheckAlgorithm integrityCheckAlgorithm;

	private String content; 

	/**
	 * <p>Constructs an empty ED.
	 */
	public EncapsulatedData() {
	}
	
	public EncapsulatedData(String textContent) throws SAXException {
		setContent(textContent);
	}

	public EncapsulatedData(Node nodeOrDocumentContent) throws TransformerException {
		addContent(nodeOrDocumentContent);
	}

	public EncapsulatedData(List<Node> nodeOrDocumentContents) throws TransformerException {
		for (Node node : nodeOrDocumentContents) {
			addContent(node);
		}
	}

	/**
	 * <p>Constructs an ED using the supplied parameters. Deprecated. Use any other constructor.
	 * 
	 * @param mediaType the mediatype
	 * @param reference a reference
	 * @param language
	 * @param content content within a byte array
	 * @deprecated
	 */
	@Deprecated
	public EncapsulatedData(x_DocumentMediaType mediaType, String reference, String language, byte[] content) {
		this.mediaType = mediaType;
		this.language = language;
		this.content = content == null || content.length == 0 ? null : XmlStringEscape.escape(new String(content));
		if (StringUtils.isNotBlank(reference)) {
			String[] parts = reference.split("://");
			if (parts.length > 0) {
				URLScheme urlsScheme = null; 
				if (parts.length > 1) {
					urlsScheme = URLScheme.valueOf(URLScheme.class, parts[0]);
				}
				String address = (parts.length > 1 ? parts[1] : parts[0]); 
				this.reference = new TelecommunicationAddress(urlsScheme, address);
			}
		}
	}

	/**
	 * <p>Returns the reference.
	 * 
	 * @return the reference
	 */
	public TelecommunicationAddress getReferenceObj() {
		return this.reference;
	}
	
	public void setReferenceObj(TelecommunicationAddress reference) {
		this.reference = reference;
	}
	
	/**
	 * <p>Returns the reference. Deprecated. Use getReferenceObj() instead.
	 * 
	 * @return the reference
	 * @deprecated
	 */
	@Deprecated
	public String getReference() {
		return this.reference == null ? null : this.reference.toString();
	}
	
	public EncapsulatedData getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(EncapsulatedData thumbnail) {
		this.thumbnail = thumbnail;
	}


	public EdRepresentation getRepresentation() {
		return representation;
	}

	public void setRepresentation(EdRepresentation representation) {
		this.representation = representation;
	}

	/**
	 * <p>Returns the media type.
	 * 
	 * @return the media type
	 */
	public x_DocumentMediaType getMediaType() {
		return this.mediaType;
	}
	
	public void setMediaType(x_DocumentMediaType mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * <p>Returns the language.
	 * 
	 * @return the language.
	 */
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Compression getCompression() {
		return compression;
	}
	
	public void setCompression(Compression compression) {
		this.compression = compression;
	}

	public String getIntegrityCheck() {
		return integrityCheck;
	}

	public void setIntegrityCheck(String integrityCheck) {
		this.integrityCheck = integrityCheck;
	}


	public IntegrityCheckAlgorithm getIntegrityCheckAlgorithm() {
		return integrityCheckAlgorithm;
	}

	public void setIntegrityCheckAlgorithm(IntegrityCheckAlgorithm integrityCheckAlgorithm) {
		this.integrityCheckAlgorithm = integrityCheckAlgorithm;
	}

	public boolean hasContent() {
		return StringUtils.isNotBlank(this.content);
	}
	
	/**
	 * <p>Returns the content as a String.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) throws SAXException {
		addContent(content);
	}

	/**
	 * Document content. ED content may contain multiple root elements 
	 * 
	 * @param nodeOrDocumentContents the document content
	 * @throws TransformerException 
	 */
	public void setContent(List<Node> nodeOrDocumentContents) throws TransformerException {
		this.content = null;
		for (Node node : nodeOrDocumentContents) {
			addContent(node);
		}
	}
	
	public void addContent(String newStringContent) throws SAXException {
		addStringContent(newStringContent, true);
	}
	
	public void addContent(Node nodeOrDocument) throws TransformerException {
		// convert to String and add to content
		String newStringContent = convertNodeToString(nodeOrDocument);
		try {
			addStringContent(newStringContent, false);
		} catch (SAXException e) {
			// validation not done for this case; should never get here
		}
	}

	private void addStringContent(String newStringContent, boolean validate) throws SAXException {
		if (validate) {
			validateStringContent(newStringContent);
		}
		if (this.content == null) {
			this.content = newStringContent;
		} else {
			this.content += newStringContent;
		}
	}

	private void validateStringContent(String content) throws SAXException {
		// wrap content in an outer tag and try to convert to document (content such as plain text won't convert to a document but could still be valid)
		if (content != null) {
			DOCUMENT_FACTORY.createFromString("<mbContent>" + content + "</mbContent>");
		}
	}

	private String convertNodeToString(Node node) throws TransformerException {
		Node newNode = node;
		if (!isTextNode(node)) {
			try {
				// convert the node into a document in order to avoid inheriting any namespaces
				// note, this should not remove inner namespaces in the content - may need to revisit
				// this may be very inefficient - better to just search and replace namespaces after converting to string?
				newNode = XmlRenderer.obtainDocumentFromNode(node, true);
			} catch (ParserConfigurationException e) {
				throw new TransformerException("Problem occurred trying to convert Node to a Document", e);
			}
		}
		return XmlRenderer.render(newNode, true, 0);
	}
	
	private boolean isTextNode(Node node) {
		// looking for any types that can not be converted to a document
		short nodeType = node.getNodeType();
		return nodeType == Node.CDATA_SECTION_NODE || nodeType == Node.TEXT_NODE || nodeType == Node.COMMENT_NODE; 
	}

	public void trimContent() {
		this.content = StringUtils.trimToNull(this.content);
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder()
        		.append(this.reference)
        		.append(this.thumbnail)
        		.append(this.representation)
		        .append(this.mediaType)
		        .append(this.language)
		        .append(this.compression)
		        .append(this.integrityCheck)
		        .append(this.integrityCheckAlgorithm)
		        .append(this.content)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((EncapsulatedData) obj);
        }
    }
    
	private boolean equals(EncapsulatedData that) {
        return new EqualsBuilder()
        		.append(this.reference, that.reference)
		        .append(this.thumbnail, that.thumbnail)
		        .append(this.representation, that.representation)
		        .append(this.mediaType, that.mediaType)
		        .append(this.language, that.language)
		        .append(this.compression, that.compression)
		        .append(this.integrityCheck, that.integrityCheck)
		        .append(this.integrityCheckAlgorithm, that.integrityCheckAlgorithm)
                .append(this.content, that.content)
                .isEquals();
    }
	
	public boolean isEmpty() {
		return this.reference == null &&
				this.thumbnail == null &&
				this.representation == null &&
				this.mediaType == null &&
				this.language == null &&
				this.compression == null &&
				this.integrityCheck == null &&
				this.integrityCheckAlgorithm == null &&
				this.content == null
				;
	}

}
