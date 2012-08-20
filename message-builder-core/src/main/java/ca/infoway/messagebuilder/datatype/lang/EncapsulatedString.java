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

package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.domainvalue.basic.MediaType;

/**
 * <p>Java datatype for HL7 encapsulated string.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EncapsulatedString extends EncapsulatedData {

	private final String text;

	/**
	 * <p>Constructs an EcapsulatedString from the given text. 
	 * 
	 * @param text the initial text
	 */
	public EncapsulatedString(String text) {
		this.text = text;
	}

	/**
	 * <p>Returns this encapsulated string's content as a string.
	 * 
	 * @return the content as a string
	 */
	public String getContentAsString() {
		return this.text;
	}

	/**
	 * <p>Returns the content as an array of bytes.
	 * 
	 * @return the content as an array of bytes
	 */
	@Override
	public byte[] getContent() {
		return this.text == null ? null : this.text.getBytes();
	}

	/**
	 * <p>Returns this object's media type. In this case, it is always plain text.
	 * 
	 * @return the media type
	 */
	@Override
	public MediaType getMediaType() {
		return MediaType.PLAIN_TEXT;
	}
}
