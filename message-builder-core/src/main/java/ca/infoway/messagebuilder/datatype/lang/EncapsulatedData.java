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

import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;

/**
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

	private x_DocumentMediaType mediaType;
	private String reference;
	private String language;
	private byte[] content;

	/**
	 * <p>Constructs an empty ED.
	 */
	public EncapsulatedData() {
	}
	
	/**
	 * <p>Constructs an ED using the supplied parameters.
	 * 
	 * @param mediaType the mediatype
	 * @param reference a reference
	 * @param language
	 * @param content content within a byte array
	 */
	public EncapsulatedData(x_DocumentMediaType mediaType, String reference, String language, byte[] content) {
		this.mediaType = mediaType;
		this.reference = reference;
		this.language = language;
		this.content = content;
	}
	
	/**
	 * <p>Returns the byte array content.
	 * 
	 * @return the byte array content
	 */
	public byte[] getContent() {
		return this.content;
	}
	
	/**
	 * <p>Returns the media type.
	 * 
	 * @return the media type
	 */
	public x_DocumentMediaType getMediaType() {
		return this.mediaType;
	}
	
	/**
	 * <p>Returns the reference.
	 * 
	 * @return the reference
	 */
	public String getReference() {
		return this.reference;
	}
	
	/**
	 * <p>Returns the language.
	 * 
	 * @return the language.
	 */
	public String getLanguage() {
		return this.language;
	}

}
