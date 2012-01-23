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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>PrescribedBy</p>
 * 
 * <p>PORX_MT060040CA.Author4: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT060340CA.Author4: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.Author4: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.Author4","PORX_MT060160CA.Author4","PORX_MT060340CA.Author4"})
public class Author4Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private TS time = new TSImpl();
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();
    private HealthcareWorkerBean assignedEntity;
    private ProviderBean assignedPerson;


    /**
     * <p>PrescribedDate</p>
     * 
     * <p>Prescribed Date</p>
     * 
     * <p><p>The date and time at which the drug was 
     * prescribed/dispensed. This may differ from the date on which 
     * the prescription becomes effective. E.g. A prescription 
     * created today may not be valid to be dispensed or 
     * administered for two weeks.</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * may not be known, as in the case of 'inferred 
     * prescription'.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * may not be known, as in the case of 'inferred 
     * prescription'.</p></p>
     * 
     * <p>Prescribed Date</p>
     * 
     * <p><p>The date at which the device was prescribed/dispensed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or used for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * always be known, except for inferred prescriptions.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * always be known, except for inferred prescriptions.</p></p>
     * 
     * <p>Prescribed Date</p>
     * 
     * <p><p>The date and time at which the drug was 
     * prescribed/dispensed. This may differ from the date on which 
     * the prescription becomes effective. E.g. A prescription 
     * created today may not be valid to be dispensed or 
     * administered for two weeks.</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>PrescriptionTransmissionMethod</p>
     * 
     * <p>Prescription Transmission Method</p>
     * 
     * <p><p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p></p>
     * 
     * <p><p>ZDP.4</p><p>Claim.419-DJ</p></p>
     * 
     * <p><p>ZDP.4</p><p>Claim.419-DJ</p></p>
     * 
     * <p><p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p></p>
     * 
     * <p>Prescription Transmission Method</p>
     * 
     * <p><p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p></p>
     * 
     * <p><p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Signature</p>
     * 
     * <p>Signature</p>
     * 
     * <p><p>An electronic signature of the prescription by the 
     * prescriber.</p></p>
     * 
     * <p><p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p></p>
     * 
     * <p>Signature</p>
     * 
     * <p><p>An electronic signature of the prescription by the 
     * prescriber.</p></p>
     * 
     * <p><p>Signature</p></p>
     * 
     * <p><p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }


    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

}
