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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt470002ca.ConsentBean;



/**
 * <p>AuthorizedBy</p>
 * 
 * <p>QUQI_MT120006CA.Subject3: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p>MCAI_MT700210CA.Subject3: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p>MFMI_MT700751CA.Subject1: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a client's 
 * agreement/acceptance to have his/her client identification 
 * and demographic information electronically stored and 
 * shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view client 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view client 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p>MFMI_MT700711CA.Subject3: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a client's (or 
 * provider's)agreement/acceptance to have his/her 
 * client/provider identification and demographic information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view 
 * client/provider information.</p><p>Indicates the consent or 
 * keyword used to authorize access or update, including a 
 * reason for access; May also be used to override access 
 * restriction to the information ('break the glass') on a 
 * message by message basis.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view 
 * client/provider information.</p><p>Indicates the consent or 
 * keyword used to authorize access or update, including a 
 * reason for access; May also be used to override access 
 * restriction to the information ('break the glass') on a 
 * message by message basis.</p></p>
 * 
 * <p>QUQI_MT120008CA.Subject3: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement/acceptance to have his/her clinical information 
 * electronically stored and shared.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>Provides authorization to record and/or view patient 
 * information.</p><p>Indicates the consent or keyword used to 
 * authorize access or update, including a reason for access; 
 * May also be used to override access restriction to the 
 * information ('break the glass') on a message by message 
 * basis.</p><p>May be required on a Prescription Request to 
 * indicate a keyword for drug utilization processing.</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p><p>This will usually only be populated for queries, but 
 * could be used for updates if a jurisdiction requires consent 
 * before recording information in the EHR (e.g. consent to 
 * participate in electronic data exchange).</p><p>Note: 
 * keywords canot be passed from one application to another via 
 * the EHR (e.g. prescriber to dispenser via a Drug Information 
 * System).</p></p>
 * 
 * <p>QUQI_MT020002CA.Subject3: c:authorized by</p>
 * 
 * <p><p>Information pertaining to a patient's 
 * agreement
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject3","MCAI_MT700211CA.Subject3","MCAI_MT700212CA.Subject3","MFMI_MT700711CA.Subject3","MFMI_MT700751CA.Subject1","QUQI_MT020000CA.Subject3","QUQI_MT020002CA.Subject3","QUQI_MT120006CA.Subject3","QUQI_MT120008CA.Subject3"})
public class AuthorizedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private ConsentBean consentEvent;
    private CS contextControlCode = new CSImpl();


    @Hl7XmlMapping({"consentEvent"})
    public ConsentBean getConsentEvent() {
        return this.consentEvent;
    }
    public void setConsentEvent(ConsentBean consentEvent) {
        this.consentEvent = consentEvent;
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }

}
