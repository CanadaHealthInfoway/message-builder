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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class X_DocumentMediaType extends EnumPattern implements x_DocumentMediaType, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3563081021150491143L;

	/**
	 * <p>For any plain text.
	 */
	public static final X_DocumentMediaType PLAIN_TEXT = new X_DocumentMediaType("PLAIN_TEXT", "text/plain");
	/**
	 * <p>For marked-up text according to the Hypertext Mark-up Language. HTML markup
	 * is sufficient for typographically marking-up most written-text documents.
	 * HTML is platform independent and widely deployed.
	 */
	public static final X_DocumentMediaType HTML_TEXT = new X_DocumentMediaType("HTML_TEXT", "text/html");
	/**
	 * <p>The Portable Document Format is recommended for written text that is completely
	 * laid out and read-only. PDF is a platform independent, widely deployed, and open
	 * specification with freely available creation and rendering tools.
	 */
	public static final X_DocumentMediaType PDF = new X_DocumentMediaType("PDF", "application/pdf");
	/**
	 * <p>For structured character based data. There is a risk that general SGML/XML is too
	 * powerful to allow a sharing of general SGML/XML documents between different
	 * applications.
	 */
	public static final X_DocumentMediaType XML_TEXT = new X_DocumentMediaType("XML_TEXT", "text/xml");
	public static final X_DocumentMediaType HL7_CDA = new X_DocumentMediaType("HL7_CDA", "multipart/x-hl7-cda-level-one");
	
	public static final X_DocumentMediaType DICOM = new X_DocumentMediaType("DICOM", "application/dicom");
	
	private final String mimeType;

	private X_DocumentMediaType(String name, String mimeType) {
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
	 * @return the applicable X_DocumentMediaType
	 */
	public static X_DocumentMediaType get(String mimeType) {
		X_DocumentMediaType result = null;
		for (X_DocumentMediaType X_DocumentMediaType : EnumPattern.values(X_DocumentMediaType.class)) {
			if (X_DocumentMediaType.getMimeType().equals(mimeType)) {
				result = X_DocumentMediaType;
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
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
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
