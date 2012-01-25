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

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>MediaType.
 * 
 * <p>Media types from:
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/datatypes/datatypes.htm#dt-ED
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class MediaType extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.MediaType, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = -1973934802325355773L;
	
	/**
	 * <p>Currently not a valid HL7 media type.
	 */
	public static final MediaType EXCEL = new MediaType("EXCEL", "application/vnd.ms-excel");
	/**
	 * <p>For any plain text.
	 */
	public static final MediaType PLAIN_TEXT = new MediaType("PLAIN_TEXT", "text/plain");
	/**
	 * <p>For compatibility, this represents the HL7 v2.x FT data type. Its use is
	 * recommended only for backward compatibility with HL7 v2.x systems.
	 */
	public static final MediaType HL7_TEXT = new MediaType("HL7_TEXT", "text/x-hl7-ft");
	/**
	 * <p>For marked-up text according to the Hypertext Mark-up Language. HTML markup
	 * is sufficient for typographically marking-up most written-text documents.
	 * HTML is platform independent and widely deployed.
	 */
	public static final MediaType HTML_TEXT = new MediaType("HTML_TEXT", "text/html");
	/**
	 * <p>The Portable Document Format is recommended for written text that is completely
	 * laid out and read-only. PDF is a platform independent, widely deployed, and open
	 * specification with freely available creation and rendering tools.
	 */
	public static final MediaType PDF = new MediaType("PDF", "application/pdf");
	/**
	 * <p>For structured character based data. There is a risk that general SGML/XML is too
	 * powerful to allow a sharing of general SGML/XML documents between different
	 * applications.
	 */
	public static final MediaType XML_TEXT = new MediaType("XML_TEXT", "text/xml");
	/**
	 * <p>The Rich Text Format is widely used to share word-processor documents. However,
	 * RTF does have compatibility problems, as it is quite dependent on the word
	 * processor. May be useful if word processor edit-able text should be shared.
	 */
	public static final MediaType RTF_TEXT = new MediaType("RTF_TEXT", "text/rtf");
	/**
	 * <p>This format is very prone to compatibility problems. If sharing of edit-able text
	 * is required, text/plain, text/html or text/rtf should be used instead.
	 */
	public static final MediaType MSWORD = new MediaType("MSWORD", "application/msword");
	/**
	 * <p>This is a format for single channel audio, encoded using 8bit ISDN mu-law [PCM]
	 * at a sample rate of 8000 Hz. This format is standardized by: CCITT,
	 * Fascicle III.4 -Recommendation G.711. Pulse Code Modulation (PCM) of Voice
	 * Frequencies. Geneva, 1972.
	 */
	public static final MediaType BASIC_AUDIO = new MediaType("BASIC_AUDIO", "audio/basic");
	/**
	 * <p>MPEG-1 Audio layer-3 is an audio compression algorithm and file format defined in
	 * ISO 11172-3 and ISO 13818-3. MP3 has an adjustable sampling frequency for highly
	 * compressed telephone to CD quality audio.
	 */
	public static final MediaType MPEG_AUDIO_LAYER_3 = new MediaType("MPEG_AUDIO_LAYER_3", "audio/mpeg");
	/**
	 * <p>ADPCM allows compressing audio data. It is defined in the Internet specification
	 * RFC 2421 [ftp://ftp.isi.edu/in-notes/rfc2421.txt]. Its implementation base is
	 * unclear.
	 */
	public static final MediaType K32ADPCM_AUDIO = new MediaType("K32ADPCM_AUDIO", "audio/k32adpcm");
	/**
	 * <p>Portable Network Graphics (PNG) [http://www.cdrom.com/pub/png] is a widely
	 * supported lossless image compression standard with open source code available.
	 */
	public static final MediaType PNG_IMAGE = new MediaType("PNG_IMAGE", "image/png");
	/**
	 * <p>GIF is a popular format that is universally well supported. However GIF is patent
	 * encumbered and should therefore be used with caution.
	 */
	public static final MediaType GIF_IMAGE = new MediaType("GIF_IMAGE", "image/gif");
	/**
	 * <p>This format is required for high compression of high color photographs. It is a
	 * "lossy" compression, but the difference to lossless compression is almost
	 * unnoticeable to the human vision.
	 */
	public static final MediaType JPEG_IMAGE = new MediaType("JPEG_IMAGE", "image/jpeg");
	/**
	 * <p>Digital Imaging and Communications in Medicine (DICOM) MIME type defined in
	 * RFC3240 [http://ietf.org/rfc/rfc3240.txt].
	 */
	public static final MediaType DICOM = new MediaType("DICOM", "application/dicom");
	/**
	 * <p>This is recommended only for fax applications.
	 */
	public static final MediaType G3FA_XIMAGE = new MediaType("G3FA_XIMAGE", "image/g3fax");
	/**
	 * <p>Although TIFF (Tag Image File Format) is an international standard it has many
	 * interoperability problems in practice. Too many different versions that are not
	 * handled by all software alike.
	 */
	public static final MediaType TIFF_IMAGE = new MediaType("TIFF_IMAGE", "image/tiff");
	/**
	 * <p>MPEG is an international standard, widely deployed, highly efficient for high
	 * color video; open source code exists; highly interoperable.
	 */
	public static final MediaType MPEG_VIDEO = new MediaType("MPEG_VIDEO", "video/mpeg");
	/**
	 * <p>The AVI file format is just a wrapper for many different codecs; it is a source
	 * of many interoperability problems.
	 */
	public static final MediaType _XAVI_VIDEO = new MediaType("_XAVI_VIDEO", "video/x-avi");
	/**
	 * <p>This is an openly standardized format for 3D models that can be useful for
	 * virtual reality applications such as anatomy or biochemical research
	 * (visualization of the steric structure of macromolecules).
	 */
	public static final MediaType VRML_MODEL = new MediaType("VRML_MODEL", "model/vrml");

	private final String mimeType;

	private MediaType(String name, String mimeType) {
		super(name);
		this.mimeType = mimeType;
	}

	/**
	 * <p>Returns the mime type. 
	 * 
	 * @return the mime type
	 */
	public String getMimeType() {
		return this.mimeType;
	}

	/**
	 * <p>Obtains the media type registered for the supplied mime type.
	 * 
	 * <p>Returns null if no media type could be found.
	 * 
	 * @param mimeType the mimetype to match
	 * @return the applicable MediaType
	 */
	public static MediaType get(String mimeType) {
		MediaType result = null;
		for (MediaType mediaType : EnumPattern.values(MediaType.class)) {
			if (mediaType.getMimeType().equals(mimeType)) {
				result = mediaType;
				break;
			}
		}
		return result;
	}
	
	/**
	 * <p>Returns the media type code system.
	 * 
	 * @return the media type code system
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_DOCUMENT_MEDIA_TYPES.getRoot();
	}

	/**
	 * <p>Returns the code value.
	 * 
	 * @return the code value
	 */
	public String getCodeValue() {
		return this.mimeType;
	}

	/**
	 * <p>Returns the description of the media type.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
	
}
