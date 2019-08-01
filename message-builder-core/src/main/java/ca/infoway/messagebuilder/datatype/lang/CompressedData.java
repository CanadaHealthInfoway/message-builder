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

import static ca.infoway.messagebuilder.datatype.lang.util.Compression.GZIP;

import java.io.IOException;

import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.platform.Base64;

/**
 * <p>Java datatype representing the HL7 Datatype ED. (a specialized class)
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @deprecated
 *
 * @sharpen.ignore - datatype - translated manually
 */
@Deprecated
public class CompressedData extends EncapsulatedData {

	/**
	 * <p>Constructs an empty CompressedData.
	 */
	public CompressedData() {
	}

	/**
	 * <p>Constructs a CompressData object given the supplied parameters.
	 * 
	 * @param mediaType a media type
	 * @param reference a reference
	 * @param content the data content
	 * @param compression a compression type
	 * @param language a language
	 */
	public CompressedData(x_DocumentMediaType mediaType, String reference, byte[] content, Compression compression, String language) {
		super(mediaType, reference, language, content);
		setCompression(compression);
	}

	/**
	 * <p>Returns the uncompressed content as a byte array.
	 * 
	 * @return the uncompressed content as a byte array
	 */
	public byte[] getUncompressedContent() {
		byte[] content = getContent() == null ? null : getContent().getBytes();
		if (content != null && isGzip()) {
			try {
				if (isB64()) {
					content = Base64.decodeBase64(content);
				}
				return Compression.gunzip(content);
			} catch (IOException e) {
				return null;
			}
		} else {
			return content;
		}
	}

	/**
	 * <p>Returns the compressed content as a byte array.
	 * 
	 * @return the compressed content as a byte array.
	 */
	public byte[] getCompressedContent() {
		byte[] content = getContent().getBytes();
		if (isGzip()) {
			try {
				// will callers be expecting this to be B64 encoded?
				return Compression.gzip(content);
			} catch (IOException e) {
				return null;
			}
		} else {
			return content;
		}
	}

	private boolean isGzip() {
		return GZIP.equals(getCompression());
	}

	private boolean isB64() {
		return EdRepresentation.B64.equals(getRepresentation());
	}
}
