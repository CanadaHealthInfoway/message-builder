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

package ca.infoway.messagebuilder.datatype.lang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>DF | GZ | ZL One of these values have to be used if content is compressed
 * (zipped). It is up to implementation organization to decide which format to
 * use. Most likely DF will be acceptable value.
 * 
 * <p>DF - deflate. The "deflate" compressed data format as specified in RFC 1951
 * [http://www.ietf.org/rfc/rfc1951.txt].
 * 
 * <p>GZ - gzip. A compressed data format that is compatible with the widely used
 * GZIP utility as specified in RFC 1952 [http://www.ietf.org/rfc/rfc1952.txt]
 * 
 * <p>ZL - zlib indifferent. A compressed data format that also uses the "deflate"
 * algorithm. Specified as RFC 1950 [http://www.ietf.org/rfc/rfc1952.txt]
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class Compression extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = 2463751994500229084L;
	
	public static final Compression DEFLATE = new Compression("DEFLATE", "DF");
	public static final Compression GZIP = new Compression("GZIP", "GZ");
	public static final Compression ZLIB = new Compression("ZLIB", "ZL");

	private final String compressionType;

	private Compression(String name, String compressionType) {
		super(name);
		this.compressionType = compressionType;
	}

	/**
	 * <p>Returns the compression type.
	 * 
	 * @return the compression type
	 */
	public String getCompressionType() {
		return this.compressionType;
	}

	/**
	 * <p>GZIPs a byte array of data.
	 * 
	 * @param bytes the content  to gzip
	 * @return the zipped input as a byte array
	 * @throws IOException if an error occurred generating the byte array
	 */
	public static byte[] gzip(byte[] bytes) throws IOException {
		if (bytes != null) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
			gzipOutputStream.write(bytes);
			gzipOutputStream.close();
			return outputStream.toByteArray();
		}
		return null;
	}

	/**
	 * <p>GUNZIPs a byte array of data.
	 * 
	 * @param bytes the content to gunzip
	 * @return the unzipped input as a byte array
	 * @throws IOException if an error occurred generating the byte array
	 */
	public static byte[] gunzip(byte[] bytes) throws IOException {
		if (bytes != null) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(bytes));
			byte[] buffer = new byte[1024];
			int len;
			while ((len = gzipInputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.close();
			return outputStream.toByteArray();
		}
		return null;
	}

	/**
	 * <p>Returns a Compression enum that is applicable for the input string.
	 * 
	 * @param compressionType a compression type as a string
	 * @return a Compression enum that matches the input string
	 */
	public static Compression get(String compressionType) {
		Compression result = null;
		for (Compression compression : values(Compression.class)) {
			if (compression.getCompressionType().equals(compressionType)) {
				result = compression;
				break;
			}
		}
		return result;
	}
}
