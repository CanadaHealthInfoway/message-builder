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

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
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

	private TelecommunicationAddress reference;
	private EncapsulatedData thumbnail;
	
	private EdRepresentation representation;
	private x_DocumentMediaType mediaType;
	private String language;
	private Compression compression;
	private String integrityCheck;
	private IntegrityCheckAlgorithm integrityCheckAlgorithm;

	// at most can provide only one of these three content types
	private String textContent; // must be text or base64 encoded; will be escaped
	private String cdataContent;
	private List<Document> documentContent; // HTML content may not have a single root element

	private final DocumentFactory documentFactory = new DocumentFactory();
	
	/**
	 * <p>Constructs an empty ED.
	 */
	public EncapsulatedData() {
	}
	
	public EncapsulatedData(String textContent) {
		this.textContent = textContent;
	}

	public EncapsulatedData(Document document) {
		this.documentContent = new ArrayList<Document>();
		this.documentContent.add(document);
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
		this.textContent = content == null || content.length == 0 ? null : new String(content);
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
		return StringUtils.isNotBlank(this.textContent) || StringUtils.isNotBlank(this.getCdataContent()) || this.getDocumentContent() != null;
	}
	
	/**
	 * <p>Returns the text content. This content will be escaped when rendered to xml.
	 * 
	 * @return the content
	 */
	public String getTextContent() {
		return this.textContent;
	}
	
	public void setTextContent(String content) {
		this.textContent = content;
	}

	/**
	 * <p>Returns text content as a byte array. Deprecated. Please use appropriate content accessor (text, cdata, or document).
	 * 
	 * @return the byte array content
	 * @deprecated
	 */
	@Deprecated
	public byte[] getContent() {
		return this.textContent == null ? null : this.textContent.getBytes();
	}
	
	/**
	 * CDATA content. This content will be wrapped in a CDATA block and *not* escaped.
	 * 
	 * @return the cdata content
	 */
	public String getCdataContent() {
		return cdataContent;
	}

	public void setCdataContent(String cdataContent) {
		this.cdataContent = cdataContent;
	}

	/**
	 * Document content. ED content may contain multiple root elements 
	 * 
	 * @return the document
	 */
	public List<Document> getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(List<Document> documentContent) {
		this.documentContent = documentContent;
	}
	
	public void addDocumentContent(Document document) {
		if (this.documentContent == null) {
			this.documentContent = new ArrayList<Document>();
		}
		this.documentContent.add(document);
	}

	/**
	 * Convenience method to obtain ED xml content as a String
	 * @param indentLevel amount to indent xml; -1 for no indenting
	 * @return the ED document in a string
	 * @throws TransformerException
	 */
	public String getDocumentContentAsString(int indentLevel) throws TransformerException {
		if (this.documentContent == null) {
			return null;
		}
		String result = "";
		for (Document document : this.documentContent) {
			result += XmlRenderer.render(document, true, indentLevel);
		}
		return result;
	}
	
	/**
	 * Convenience method to pass in xml as a string to add to documentContent
	 * @param documentContentAsString the string to convert to a Document
	 * @throws SAXException
	 */
	public void addDocumentContentFromString(String documentContentAsString) throws SAXException {
		addDocumentContent(this.documentFactory.createFromString(documentContentAsString));
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
		        .append(this.textContent)
		        .append(this.cdataContent)
		        .append(this.documentContent)
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
                .append(this.textContent, that.textContent)
                .append(this.cdataContent, that.cdataContent)
                .append(this.documentContent, that.documentContent)
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
				this.textContent == null &&
				this.cdataContent == null &&
				this.documentContent== null;
	}
}
