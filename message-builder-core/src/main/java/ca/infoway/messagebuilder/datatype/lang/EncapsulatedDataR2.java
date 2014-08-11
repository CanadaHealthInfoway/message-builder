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
 * Last modified: $LastChangedDate: 2013-05-15 18:39:56 -0400 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.datatype.lang.util.IntegrityCheckAlgorithm;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;

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
public class EncapsulatedDataR2 {

	private TelecommunicationAddress reference;
	private EncapsulatedDataR2 thumbnail;
	
	private EdRepresentation representation;
	private x_DocumentMediaType mediaType;
	private String language;
	private Compression compression;
	private String integrityCheck;
	private IntegrityCheckAlgorithm integrityCheckAlgorithm;
	
	private String content; // must be text or base64 encoded

	/**
	 * <p>Constructs an empty ED.
	 */
	public EncapsulatedDataR2() {
	}
	
	/**
	 * <p>Returns the reference.
	 * 
	 * @return the reference
	 */
	public TelecommunicationAddress getReference() {
		return this.reference;
	}
	
	public void setReference(TelecommunicationAddress reference) {
		this.reference = reference;
	}
	
	public EncapsulatedDataR2 getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(EncapsulatedDataR2 thumbnail) {
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

	/**
	 * <p>Returns the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
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
            return equals((EncapsulatedDataR2) obj);
        }
    }
    
	private boolean equals(EncapsulatedDataR2 that) {
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
				this.content == null;
	}
}
