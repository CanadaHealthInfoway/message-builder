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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.LanguageAbilityMode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Payee Person</p>
 * 
 * <p>Person receiving payment from Payor</p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeePerson"})
public class PayeePersonBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20150326L;
    private PN name = new PNImpl();
    private AD addr = new ADImpl();
    private PayeeRelationshipRoleBean asRole;
    private CV payeeLanguageLanguageCode = new CVImpl();
    private CV payeeLanguageModeCode = new CVImpl();
    private BL payeeLanguagePreferenceInd = new BLImpl();


    /**
     * <p>Business Name: payee name</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeePerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of person who is the payee</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: payee name</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeePerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of person who is the payee</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: payee address</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeePerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: payee address</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeePerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Relationship: COCT_MT110200CA.PayeeChoice.asRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"asRole"})
    public PayeeRelationshipRoleBean getAsRole() {
        return this.asRole;
    }

    /**
     * <p>Relationship: COCT_MT110200CA.PayeeChoice.asRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAsRole(PayeeRelationshipRoleBean asRole) {
        this.asRole = asRole;
    }


    /**
     * <p>Business Name: Payee Person Language</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"payeeLanguage/languageCode"})
    public HumanLanguage getPayeeLanguageLanguageCode() {
        return (HumanLanguage) this.payeeLanguageLanguageCode.getValue();
    }

    /**
     * <p>Business Name: Payee Person Language</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPayeeLanguageLanguageCode(HumanLanguage payeeLanguageLanguageCode) {
        this.payeeLanguageLanguageCode.setValue(payeeLanguageLanguageCode);
    }


    /**
     * <p>Business Name: Language of Communication</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.modeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A value presenting the method of expression of the 
     * language.</p>
     */
    @Hl7XmlMapping({"payeeLanguage/modeCode"})
    public LanguageAbilityMode getPayeeLanguageModeCode() {
        return (LanguageAbilityMode) this.payeeLanguageModeCode.getValue();
    }

    /**
     * <p>Business Name: Language of Communication</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.modeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A value presenting the method of expression of the 
     * language.</p>
     */
    public void setPayeeLanguageModeCode(LanguageAbilityMode payeeLanguageModeCode) {
        this.payeeLanguageModeCode.setValue(payeeLanguageModeCode);
    }


    /**
     * <p>Business Name: Preferred Language Indicator</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"payeeLanguage/preferenceInd"})
    public Boolean getPayeeLanguagePreferenceInd() {
        return this.payeeLanguagePreferenceInd.getValue();
    }

    /**
     * <p>Business Name: Preferred Language Indicator</p>
     * 
     * <p>Relationship: COCT_MT110200CA.PayeeLanguage.preferenceInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPayeeLanguagePreferenceInd(Boolean payeeLanguagePreferenceInd) {
        this.payeeLanguagePreferenceInd.setValue(payeeLanguagePreferenceInd);
    }

}
