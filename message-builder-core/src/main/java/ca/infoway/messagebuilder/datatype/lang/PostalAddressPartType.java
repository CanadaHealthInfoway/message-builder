/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.AddressPartType;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Enum for Postal Address part Types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PostalAddressPartType extends EnumPattern implements NamePartType, AddressPartType {
	
    private static final long serialVersionUID = 6553215353191315355L;
    
	public static final PostalAddressPartType ADDRESS_LINE = new PostalAddressPartType("ADDRESS_LINE", "AL", "addressLine");
    public static final PostalAddressPartType DELIMITER = new PostalAddressPartType("DELIMITER", "DEL", "delimiter");
    public static final PostalAddressPartType COUNTRY = new PostalAddressPartType("COUNTRY", "CNT", "country"); 
    public static final PostalAddressPartType STATE = new PostalAddressPartType("STATE", "STA", "state"); 
    public static final PostalAddressPartType COUNTY = new PostalAddressPartType("COUNTY", "CPA", "county"); 
    public static final PostalAddressPartType CITY = new PostalAddressPartType("CITY", "CTY", "city"); 
    public static final PostalAddressPartType POSTAL_CODE = new PostalAddressPartType("POSTAL_CODE", "ZIP", "postalCode");
    public static final PostalAddressPartType STREET_ADDRESS_LINE = new PostalAddressPartType("STREET_ADDRESS_LINE", "SAL", "streetAddressLine");
    public static final PostalAddressPartType HOUSE_NUMBER = new PostalAddressPartType("HOUSE_NUMBER", "BNR", "houseNumber"); 
    public static final PostalAddressPartType HOUSE_NUMBER_NUMERIC = new PostalAddressPartType("HOUSE_NUMBER_NUMERIC", "BNN", "houseNumberNumeric"); 
    public static final PostalAddressPartType DIRECTION = new PostalAddressPartType("DIRECTION", "DIR", "direction"); 
    public static final PostalAddressPartType STREET_NAME = new PostalAddressPartType("STREET_NAME", "STR", "streetName"); 
    public static final PostalAddressPartType STREET_NAME_BASE = new PostalAddressPartType("STREET_NAME_BASE", "STB", "streetNameBase");
    public static final PostalAddressPartType STREET_NAME_TYPE = new PostalAddressPartType("STREET_NAME_TYPE", "STTYP", "streetNameType"); 
    public static final PostalAddressPartType ADDITIONAL_LOCATOR = new PostalAddressPartType("ADDITIONAL_LOCATOR", "ADL", "additionalLocator");
    public static final PostalAddressPartType UNIT_ID = new PostalAddressPartType("UNIT_ID", "UNID", "unitID"); 
    public static final PostalAddressPartType UNIT_TYPE = new PostalAddressPartType("UNIT_TYPE", "UNIT", "unitType"); 
    public static final PostalAddressPartType CARE_OF = new PostalAddressPartType("CARE_OF", "CAR", "careOf"); 
    public static final PostalAddressPartType CENSUS_TRACT = new PostalAddressPartType("CENSUS_TRACT", "CEN", "censusTract");
    public static final PostalAddressPartType DELIVERY_ADDRESS_LINE = new PostalAddressPartType("DELIVERY_ADDRESS_LINE", "DAL", "deliveryAddressLine"); 
    public static final PostalAddressPartType DELIVERY_INSTALLATION_TYPE = new PostalAddressPartType("DELIVERY_INSTALLATION_TYPE", "DINST", "deliveryInstallationType"); 
    public static final PostalAddressPartType DELIVERY_INSTALLATION_AREA = new PostalAddressPartType("DELIVERY_INSTALLATION_AREA", "DINSTA", "deliveryInstallationArea");
    public static final PostalAddressPartType DELIVERY_INSTALLATION_QUALIFIER = new PostalAddressPartType("DELIVERY_INSTALLATION_QUALIFIER", "DINSTQ", "deliveryInstallationQualifier"); 
    public static final PostalAddressPartType DELIVERY_MODE = new PostalAddressPartType("DELIVERY_MODE", "DMOD", "deliveryMode"); 
    public static final PostalAddressPartType DELIVERY_MODE_IDENTIFIER = new PostalAddressPartType("DELIVERY_MODE_IDENTIFIER", "DMODID", "deliveryModeIdentifier");
    public static final PostalAddressPartType BUILDING_NUMBER_SUFFIX = new PostalAddressPartType("BUILDING_NUMBER_SUFFIX", "BNS", "buildingNumberSuffix"); 
    public static final PostalAddressPartType POST_BOX = new PostalAddressPartType("POST_BOX", "POB", "postBox"); 
    public static final PostalAddressPartType PRECINCT = new PostalAddressPartType("PRECINCT", "PRE", "precinct");
    public static final PostalAddressPartType INTERSECTION = new PostalAddressPartType("INTERSECTION", "INT", "intersection");
    
    private final String value;
	private final String codeValue;

    private PostalAddressPartType(String name, String codeValue, String value) {
    	super(name);
        this.codeValue = codeValue;
		this.value = value;
    }

    /**
     * <p>This is the label that appears as the element name when the address is 
     * rendered into XML.
     * 
     * @return the enum value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * <p>Returns the code system for the address part type enum.
     * 
     * @return the code system for the address part type enum
     */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ADDRESS_PART_TYPE.getRoot();
	}

	/**
     * <p>Returns the code value for the address part type enum.
     * 
     * @return the code value for the address part type enum
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
