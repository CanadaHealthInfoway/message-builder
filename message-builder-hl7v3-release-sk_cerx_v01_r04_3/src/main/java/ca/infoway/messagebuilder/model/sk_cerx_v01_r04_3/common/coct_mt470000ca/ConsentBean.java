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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt470000ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.OverriddenByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Patient_1Bean;



/**
 * <p>Consent</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a patient's agreement/acceptance to have 
 * his/her clinical information electronically stored and 
 * shared.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * authorization to record and/or view patient 
 * information.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Indicates the 
 * consent or keyword used to authorize access or update, 
 * including a reason for access; May also be used to override 
 * access restriction to the information ('break the glass') on 
 * a message by message basis. May be required on a 
 * Prescription Request to indicate a keyword for DUR 
 * processing.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * authorization to record and/or view patient 
 * information.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Indicates the 
 * consent or keyword used to authorize access or update, 
 * including a reason for access; May also be used to override 
 * access restriction to the information ('break the glass') on 
 * a message by message basis. May be required on a 
 * Prescription Request to indicate a keyword for DUR 
 * processing.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The keywords 
 * will not be passed from prescriber to dispenser by the 
 * DIS.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.ConsentEvent"})
@Hl7RootType
public class ConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II consentFormNumber = new IIImpl();
    private IVL<TS, Interval<Date>> consentEffectiveAndEndTime = new IVLImpl<TS, Interval<Date>>();
    private CV consentOverrideReason = new CVImpl();
    private OverriddenByBean author1;
    private ConsentedToByBean author2;
    private Patient_1Bean subject1Patient;
    private AccessTypeBean subject2InformDefinition;


    /**
     * <p>D:Consent Form Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a specific consent for a patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.formNumber</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * traceable audit link between a physical consent form and its 
     * electronic record</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getConsentFormNumber() {
        return this.consentFormNumber.getValue();
    }
    public void setConsentFormNumber(Identifier consentFormNumber) {
        this.consentFormNumber.setValue(consentFormNumber);
    }


    /**
     * <p>C:Consent Effective and End Time</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the time that the consent will expire. 'Low' is effective 
     * time and 'High' is end time.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.endTime 
     * (high)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Most 
     * consents are not open-ended, to ensure the patient retains a 
     * level of control.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsentEffectiveAndEndTime() {
        return this.consentEffectiveAndEndTime.getValue();
    }
    public void setConsentEffectiveAndEndTime(Interval<Date> consentEffectiveAndEndTime) {
        this.consentEffectiveAndEndTime.setValue(consentEffectiveAndEndTime);
    }


    /**
     * <p>E:Consent Override Reason</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates a 
     * reason for overriding a patient's consent rules.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.reason 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.comment 
     * (original text)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.reason 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.comment 
     * (original text)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
     * for audit purposes</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActConsentInformationAccessReason getConsentOverrideReason() {
        return (ActConsentInformationAccessReason) this.consentOverrideReason.getValue();
    }
    public void setConsentOverrideReason(ActConsentInformationAccessReason consentOverrideReason) {
        this.consentOverrideReason.setValue(consentOverrideReason);
    }


    @Hl7XmlMapping({"author1"})
    public OverriddenByBean getAuthor1() {
        return this.author1;
    }
    public void setAuthor1(OverriddenByBean author1) {
        this.author1 = author1;
    }


    @Hl7XmlMapping({"author2"})
    public ConsentedToByBean getAuthor2() {
        return this.author2;
    }
    public void setAuthor2(ConsentedToByBean author2) {
        this.author2 = author2;
    }


    @Hl7XmlMapping({"subject1/patient"})
    public Patient_1Bean getSubject1Patient() {
        return this.subject1Patient;
    }
    public void setSubject1Patient(Patient_1Bean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    @Hl7XmlMapping({"subject2/informDefinition"})
    public AccessTypeBean getSubject2InformDefinition() {
        return this.subject2InformDefinition;
    }
    public void setSubject2InformDefinition(AccessTypeBean subject2InformDefinition) {
        this.subject2InformDefinition = subject2InformDefinition;
    }

}
