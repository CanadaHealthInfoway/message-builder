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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt110200ca;

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
 * <p>Payee Person</p>
 * 
 * <p><p>Person receiving payment from Payor</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeePerson"})
public class PayeePersonBean extends MessagePartBean implements PayeeChoice {

    private static final long serialVersionUID = 20110407L;
    private PayeeRelationshipRoleBean asRole;
    private PN payeeName = new PNImpl();
    private AD payeeAddress = new ADImpl();
    private CV payeePersonLanguage = new CVImpl();
    private CV languageOfCommunication = new CVImpl();
    private BL preferredLanguageIndicator = new BLImpl();


    @Hl7XmlMapping({"asRole"})
    public PayeeRelationshipRoleBean getAsRole() {
        return this.asRole;
    }
    public void setAsRole(PayeeRelationshipRoleBean asRole) {
        this.asRole = asRole;
    }


    /**
     * <p>payee name</p>
     * 
     * <p><p>name of person who is the payee</p></p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getPayeeName() {
        return this.payeeName.getValue();
    }
    public void setPayeeName(PersonName payeeName) {
        this.payeeName.setValue(payeeName);
    }


    /**
     * <p>payee address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getPayeeAddress() {
        return this.payeeAddress.getValue();
    }
    public void setPayeeAddress(PostalAddress payeeAddress) {
        this.payeeAddress.setValue(payeeAddress);
    }


    /**
     * <p>Payee Person Language</p>
     */
    @Hl7XmlMapping({"payeeLanguage/languageCode"})
    public HumanLanguage getPayeePersonLanguage() {
        return (HumanLanguage) this.payeePersonLanguage.getValue();
    }
    public void setPayeePersonLanguage(HumanLanguage payeePersonLanguage) {
        this.payeePersonLanguage.setValue(payeePersonLanguage);
    }


    /**
     * <p>Language of Communication</p>
     * 
     * <p><p>A value presenting the method of expression of the 
     * language.</p></p>
     */
    @Hl7XmlMapping({"payeeLanguage/modeCode"})
    public LanguageAbilityMode getLanguageOfCommunication() {
        return (LanguageAbilityMode) this.languageOfCommunication.getValue();
    }
    public void setLanguageOfCommunication(LanguageAbilityMode languageOfCommunication) {
        this.languageOfCommunication.setValue(languageOfCommunication);
    }


    /**
     * <p>Preferred Language Indicator</p>
     */
    @Hl7XmlMapping({"payeeLanguage/preferenceInd"})
    public Boolean getPreferredLanguageIndicator() {
        return this.preferredLanguageIndicator.getValue();
    }
    public void setPreferredLanguageIndicator(Boolean preferredLanguageIndicator) {
        this.preferredLanguageIndicator.setValue(preferredLanguageIndicator);
    }

}
