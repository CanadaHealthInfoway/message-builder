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

package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>PostalAdressUse enum.
 * 
 * <p>From http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#domain-PostalAddressUse
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PostalAddressUse extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.PostalAddressUse {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
	private static final long serialVersionUID = -4205269283911237833L;
	
	/**
	 * <p>A communication address at a home, attempted contacts for business purposes 
	 * might intrude privacy and chances are one will contact family or other household 
	 * members instead of the person one wishes to call. Typically used with urgent 
	 * cases, or if no other contacts are available.
	 */
    public static final PostalAddressUse HOME = new PostalAddressUse("HOME", "H"); 
    /**
     * <p>The primary home, to reach a person after business hours.
     */
    public static final PostalAddressUse PRIMARY_HOME = new PostalAddressUse("PRIMARY_HOME", "HP"); 
    /**
     * <p>A vacation home, to reach a person while on vacation.
     */
    public static final PostalAddressUse VACATION_HOME = new PostalAddressUse("VACATION_HOME", "HV"); 
    /**
     * <p>An office address. First choice for business related contacts during 
     * business hours.
     */
    public static final PostalAddressUse WORK_PLACE = new PostalAddressUse("WORK_PLACE", "WP"); 
    /**
     * <p>Indicates a work place address or telecommunication address that 
     * reaches the individual or organization directly without intermediaries. 
     * For phones, often referred to as a 'private line'.
     */
    public static final PostalAddressUse DIRECT = new PostalAddressUse("DIRECT", "DIR"); 
    /**
     * <p>Indicates a work place address or telecommunication address that is a 'standard' 
     * address which may reach a reception service, mail-room, or other 
     * intermediary prior to the target entity. 
     */
    public static final PostalAddressUse PUBLIC = new PostalAddressUse("PUBLIC", "PUB");
    /**
     * <p>A flag indicating that the address is bad, in fact, useless.
     */
    public static final PostalAddressUse BAD = new PostalAddressUse("BAD", "BAD"); 
    /**
     * <p>A temporary address, may be good for visit or mailing. Note that an address 
     * history can provide more detailed information.
     */
    public static final PostalAddressUse TEMPORARY = new PostalAddressUse("TEMPORARY", "TMP"); 
    /**
     * <p>Alphabetic transcription of name (Japanese: romaji).
     */
    public static final PostalAddressUse ALPHABETIC = new PostalAddressUse("ALPHABETIC", "ABC"); 
    /**
     * <p>Ideographic representation of name (e.g., Japanese kanji, Chinese characters).
     */
    public static final PostalAddressUse SYLLABIC = new PostalAddressUse("SYLLABIC", "SYL");
    /**
     * <p>Syllabic transcription of name (e.g., Japanese kana, Korean hangul).
     */
    public static final PostalAddressUse IDEOGRAPHIC = new PostalAddressUse("IDEOGRAPHIC", "IDE");
    /**
     * <p>Used primarily to visit an address.
     */
    public static final PostalAddressUse PHYSICAL = new PostalAddressUse("PHYSICAL", "PHYS");
    /**
     * <p>Used to send mail.
     */
    public static final PostalAddressUse POSTAL = new PostalAddressUse("POSTAL", "PST");
    
    private final String codeValue;

    private PostalAddressUse(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }
    
    /**
     * <p>Returns the code system for this postal address enum.
     * 
     * @return the code system for this postal address enum
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_POSTAL_ADDRESS_USE.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
    }
    
    /**
     * <p>Returns the code value for this enum.
     * 
     * @return the code value
     */
    public String getCodeValue() {
        return this.codeValue;
    }
}
