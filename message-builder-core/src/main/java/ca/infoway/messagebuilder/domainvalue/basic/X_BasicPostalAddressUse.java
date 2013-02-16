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
 * Last modified: $LastChangedDate: 2012-08-20 19:01:34 -0400 (Mon, 20 Aug 2012) $
 * Revision:      $LastChangedRevision: 6032 $
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
 */
public class X_BasicPostalAddressUse extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.x_BasicPostalAddressUse {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
	private static final long serialVersionUID = -4205269283911237833L;
	
	/**
	 * <p>A communication address at a home, attempted contacts for business purposes 
	 * might intrude privacy and chances are one will contact family or other household 
	 * members instead of the person one wishes to call. Typically used with urgent 
	 * cases, or if no other contacts are available.
	 */
    public static final X_BasicPostalAddressUse HOME = new X_BasicPostalAddressUse("HOME", "H"); 

    /**
     * <p>An office address. First choice for business related contacts during 
     * business hours.
     */
    public static final X_BasicPostalAddressUse WORK_PLACE = new X_BasicPostalAddressUse("WORK_PLACE", "WP"); 

    /**
     * <p>Indicates a work place address or telecommunication address that 
     * reaches the individual or organization directly without intermediaries. 
     * For phones, often referred to as a 'private line'.
     */
    public static final X_BasicPostalAddressUse DIRECT = new X_BasicPostalAddressUse("DIRECT", "DIR");
    
    /**
     * <p>Indicates a confidential address
     */
    public static final X_BasicPostalAddressUse CONFIDENTIAL = new X_BasicPostalAddressUse("CONFIDENTIAL", "CONF"); 

    /**
     * <p>A temporary address, may be good for visit or mailing. Note that an address 
     * history can provide more detailed information.
     */
    public static final X_BasicPostalAddressUse TEMPORARY = new X_BasicPostalAddressUse("TEMPORARY", "TMP"); 

    /**
     * <p>Used primarily to visit an address.
     */
    public static final X_BasicPostalAddressUse PHYSICAL = new X_BasicPostalAddressUse("PHYSICAL", "PHYS");
    
    /**
     * <p>Used to send mail.
     */
    public static final X_BasicPostalAddressUse POSTAL = new X_BasicPostalAddressUse("POSTAL", "PST");
    
    private final String codeValue;

    private X_BasicPostalAddressUse(String name, String codeValue) {
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
     * <p>Returns the code value for this enum.
     * 
     * @return the code value
     */
    public String getCodeValue() {
        return this.codeValue;
    }
}
