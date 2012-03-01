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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt110200ca;

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

    private static final long serialVersionUID = 20120215L;
    private PayeeRelationshipRoleBean asPayeeRelationshipRole;
    private PN name = new PNImpl();
    private AD addr = new ADImpl();
    private CV payeeLanguageLanguageCode = new CVImpl();
    private CV payeeLanguageModeCode = new CVImpl();
    private BL payeeLanguagePreferenceInd = new BLImpl();


    @Hl7XmlMapping({"asPayeeRelationshipRole"})
    public PayeeRelationshipRoleBean getAsPayeeRelationshipRole() {
        return this.asPayeeRelationshipRole;
    }
    public void setAsPayeeRelationshipRole(PayeeRelationshipRoleBean asPayeeRelationshipRole) {
        this.asPayeeRelationshipRole = asPayeeRelationshipRole;
    }


    /**
     * <p>payee name</p>
     * 
     * <p><p>name of person who is the payee</p></p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>payee address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    @Hl7XmlMapping({"payeeLanguage/languageCode"})
    public HumanLanguage getPayeeLanguageLanguageCode() {
        return (HumanLanguage) this.payeeLanguageLanguageCode.getValue();
    }
    public void setPayeeLanguageLanguageCode(HumanLanguage payeeLanguageLanguageCode) {
        this.payeeLanguageLanguageCode.setValue(payeeLanguageLanguageCode);
    }


    /**
     * <p>Received Written</p>
     */
    @Hl7XmlMapping({"payeeLanguage/modeCode"})
    public LanguageAbilityMode getPayeeLanguageModeCode() {
        return (LanguageAbilityMode) this.payeeLanguageModeCode.getValue();
    }
    public void setPayeeLanguageModeCode(LanguageAbilityMode payeeLanguageModeCode) {
        this.payeeLanguageModeCode.setValue(payeeLanguageModeCode);
    }


    @Hl7XmlMapping({"payeeLanguage/preferenceInd"})
    public Boolean getPayeeLanguagePreferenceInd() {
        return this.payeeLanguagePreferenceInd.getValue();
    }
    public void setPayeeLanguagePreferenceInd(Boolean payeeLanguagePreferenceInd) {
        this.payeeLanguagePreferenceInd.setValue(payeeLanguagePreferenceInd);
    }

}