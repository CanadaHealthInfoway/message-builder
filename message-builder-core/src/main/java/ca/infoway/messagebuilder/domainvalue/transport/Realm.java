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
 * Last modified: $LastChangedDate: 2015-03-11 10:40:50 -0400 (Wed, 11 Mar 2015) $
 * Revision:      $LastChangedRevision: 9319 $
 */

package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum Realm.
 * 
 * <p>Coded concepts representing Binding Realms (used for Context Binding of 
 * terminology in HL7 models) and/or Namespace Realms (used to help ensure 
 * unique identification of HL7 artifacts). This code system is partitioned 
 * into three sections: Affiliate realms, Binding realms and Namespace realms.  
 * All affiliate realm codes may automatically be used as both binding realms 
 * and namespace realms.  Furthermore, affiliate realms are the only realms 
 * that have authority over the creation of binding realms.  (Note that 
 * 'affiliate' includes the idea of both international affiliates and the HL7 
 * International organization.)  All other codes must be associated with an 
 * owning affiliate realm and must appear as a specialization of _BindingRealm 
 * or _NamespaceRealm.  For affiliates whose concepts align with nations, the 
 * country codes from ISO 3166-1 2-character alpha are used for the code when 
 * possible so these codes should not be used for other realm types.  It is 
 * recommended that binding realm and namespace codes submitted by affiliates 
 * use the realm code as a prefix to avoid possible collisions with ISO codes.  
 * However, tooling does not currently support namepace realm codes greater 
 * than 2 characters. 
 */
public class Realm extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.Realm {

 	static {
    	/* static init block necessary for translation purposes. Please do not remove. */
    }

 	private static final long serialVersionUID = 349005342052736851L;
   
	public static final Realm ARGENTINA = new Realm("ARGENTINA", "AR"); 
    public static final Realm AUSTRIA = new Realm("AUSTRIA", "AT"); 
    public static final Realm AUSTRALIA = new Realm("AUSTRALIA", "AU"); 
    public static final Realm BRAZIL = new Realm("BRAZIL", "BR");
    public static final Realm CANADA = new Realm("CANADA", "CA"); 
    public static final Realm SWITZERLAND = new Realm("SWITZERLAND", "CH"); 
    public static final Realm CHILE = new Realm("CHILE", "CL");
    public static final Realm CHINA = new Realm("CHINA", "CN"); 
    public static final Realm COLUMBIA = new Realm("COLUMBIA", "CO"); 
    public static final Realm CZECH_REPUBLIC = new Realm("CZECH_REPUBLIC", "CZ"); 
    public static final Realm GERMANY = new Realm("GERMANY", "DE");
    public static final Realm DENMARK = new Realm("DENMARK", "DK"); 
    public static final Realm SPAIN = new Realm("SPAIN", "ES");
    public static final Realm FINLAND = new Realm("FINLAND", "FI");
    public static final Realm FRANCE = new Realm("FRANCE", "FR");
    public static final Realm GREECE = new Realm("GREECE", "GR");
    public static final Realm CROATIA = new Realm("CROATIA", "HR");
    public static final Realm IRELAND = new Realm("IRELAND", "IE");
    public static final Realm INDIA = new Realm("INDIA", "IN");
    public static final Realm ITALY = new Realm("ITALY", "IT");
    public static final Realm JAPAN = new Realm("JAPAN", "JP");
    public static final Realm KOREA = new Realm("KOREA", "KR");
    public static final Realm LITHUANIA = new Realm("LITHUANIA", "LT");
    public static final Realm MEXICO = new Realm("MEXICO", "MX");
    public static final Realm THE_NETHERLANDS = new Realm("THE_NETHERLANDS", "NL");
    public static final Realm NEW_ZEALAND = new Realm("NEW_ZEALAND", "NZ");
    public static final Realm ROMANIA = new Realm("ROMANIA", "RO");
    public static final Realm RUSSIAN_FEDERATION = new Realm("RUSSIAN_FEDERATION", "RU");
    public static final Realm SWEDEN = new Realm("SWEDEN", "SE");
    public static final Realm SINGAPORE = new Realm("SINGAPORE", "SG");
    public static final Realm SOUTHERN_AFRICA = new Realm("SOUTHERN_AFRICA", "SOA");
    public static final Realm TURKEY = new Realm("TURKEY", "TR");
    public static final Realm TAIWAN = new Realm("TAIWAN", "TW");
    public static final Realm UNITED_KINGDOM = new Realm("UNITED_KINGDOM", "UK");
    public static final Realm UNITED_STATES_OF_AMERICA = new Realm("UNITED_STATES_OF_AMERICA", "US");
    public static final Realm UNIVERSAL = new Realm("UNIVERSAL", "UV");
    public static final Realm URUGUAY = new Realm("URUGUAY", "UY");
    public static final Realm UNCLASSIFIED_REALM = new Realm("UNCLASSIFIED_REALM", "C1");
    public static final Realm GREAT_BRITAIN = new Realm("GREAT_BRITAIN", "GB");
    public static final Realm REPRESENTATIVE_REALM = new Realm("REPRESENTATIVE_REALM", "R1");
    public static final Realm EXAMPLE_REALM = new Realm("EXAMPLE_REALM", "X1");
    public static final Realm LOCALIZED_VERSION = new Realm("LOCALIZED_VERSION", "ZZ");
    
    // Extra-normative codes used for Canadian jurisdictions
    public static final Realm ALBERTA = new Realm("ALBERTA", "AB");
    public static final Realm BRITISH_COLUMBIA = new Realm("BRITISH_COLUMBIA", "BC");
    public static final Realm MANITOBA = new Realm("MANITOBA", "MB");
    public static final Realm NEW_BRUNSWICK = new Realm("NEW_BRUNSWICK", "NB");
    public static final Realm NEWFOUNDLAND_AND_LABRADOR = new Realm("NEWFOUNDLAND_AND_LABRADOR", "NL");	// Note conflict with normative code "NL" for The Netherlands.
    public static final Realm NORTHWEST_TERRITORIES = new Realm("NORTHWEST_TERRITORIES", "NT");
    public static final Realm NUNAVUT = new Realm("NUNAVUT", "NU");
    public static final Realm NOVA_SCOTIA = new Realm("NOVA_SCOTIA", "NS");
    public static final Realm ONTARIO = new Realm("ONTARIO", "ON");
    public static final Realm PRINCE_EDWARD_ISLAND = new Realm("PRINCE_EDWARD_ISLAND", "PE");
    public static final Realm QUEBEC = new Realm("QUEBEC", "QC");
    public static final Realm SASKATCHEWAN = new Realm("SASKATCHEWAN", "SK");
    public static final Realm YUKON_TERRITORY = new Realm("YUKON_TERRITORY", "YT");
    
    
    private final String codeValue;

    private Realm(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_HL7_REALM.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
    }
    
}
