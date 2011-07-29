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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import java.util.Date;



/**
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
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>COCT_MT470012CA.Author2: c:consent overridden by</p>
 * 
 * <p><p>Indicates that information access was approved by a 
 * provider rather than a patient, client, or original 
 * provider. I.e. This is an override rather than an actual 
 * consent, and is used for the purposes of 'breaking the 
 * glass' only.</p></p>
 * 
 * <p><p>Authorization.signatory(PROV)</p></p>
 * 
 * <p><p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p></p>
 * 
 * <p>RCMR_MT010001CA.Author2: c:overridden by</p>
 * 
 * <p><p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent.</p></p>
 * 
 * <p><p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p></p>
 * 
 * <p>PORX_MT060160CA.Author4: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT060190CA.Author2: *c:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT060060CA.Author2: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>COCT_MT260010CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 * 
 * <p>COCT_MT470002CA.Author2: c:consent overridden by</p>
 * 
 * <p><p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent, and is used for the purposes 
 * of 'breaking the glass' only.</p></p>
 * 
 * <p><p>Authorization.signatory(PROV)</p></p>
 * 
 * <p><p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p></p>
 * 
 * <p>PORX_MT030040CA.Author2: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT020050CA.Author2: prescribed by</p>
 * 
 * <p><p>The person who ordered the office supply.</p></p>
 * 
 * <p><p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p><p>The attribute is marked as &quot;populated&quot; 
 * as the prescriber must be known or null flavour 
 * specified.</p></p>
 * 
 * <p><p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p><p>The attribute is marked as &quot;populated&quot; 
 * as the prescriber must be known or null flavour 
 * specified.</p></p>
 * 
 * <p>COCT_MT260030CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 * 
 * <p>PORX_MT060020CA.Author2: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 * 
 * <p>COCT_MT260020CA.Author2: is created by</p>
 * 
 * <p><p>Identity of the organization who is responsible for 
 * the contents of the monograph.</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>ZPE.1</p><p>ZDU.5.1</p><p>Contraindication.dataSource</p></p>
 * 
 * <p><p>Provides a means of evaluating accuracy of 
 * content.</p></p>
 * 
 * <p>PORX_MT060100CA.Author2: *b:prescribed by</p>
 * 
 * <p><p>This is the provider who authorized the medication to 
 * be dispensed to the patient.</p></p>
 * 
 * <p><p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Author2","COCT_MT260020CA.Author2","COCT_MT260030CA.Author2","COCT_MT470002CA.Author2","COCT_MT470012CA.Author2","PORX_MT020050CA.Author2","PORX_MT030040CA.Author2","PORX_MT060020CA.Author2","PORX_MT060040CA.Author4","PORX_MT060060CA.Author2","PORX_MT060100CA.Author2","PORX_MT060160CA.Author4","PORX_MT060190CA.Author2","PORX_MT060340CA.Author4","RCMR_MT010001CA.Author2"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private TS time = new TSImpl();
    private CV prescriptionTransmissionMethod = new CVImpl();
    private ED<String> signature = new EDImpl<String>();
    private HealthcareWorkerBean assignedEntity;


    /**
     * <p>Prescription Order Date</p>
     * 
     * <p><p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p></p>
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
     * populated as it will not be there for inferred 
     * prescriptions.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p></p>
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
     * mandatory because the creation date of the prescription will 
     * always be known.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p></p>
     * 
     * <p>Prescription Order Date</p>
     * 
     * <p><p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p></p>
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
     * <p><p>The date at which the drug was prescribed/dispensed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or administered for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * not always be known (as in the case of 'inferred 
     * prescription').</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * not always be known (as in the case of 'inferred 
     * prescription').</p></p>
     * 
     * <p>B:Issue Monograph Effective Date</p>
     * 
     * <p><p>The date and time on which the monograph becomes valid 
     * and applicable.</p></p>
     * 
     * <p><p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>DDIMonograph.EffectiveDate</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Allows detailed matching of local knowledgebase record 
     * with that of the central. (The monograph id may remain the 
     * same, but the effective date will always change).</p></p>
     * 
     * <p>Prescribed Date</p>
     * 
     * <p><p>The date that the prescription was written by the 
     * prescriber.</p></p>
     * 
     * <p><p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p></p>
     * 
     * <p><p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p></p>
     * 
     * <p>Prescribed Date</p>
     * 
     * <p><p>The date at which the drug was prescribed/dispensed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or administered for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription may 
     * not be known, as in the case of 'inferred prescription'.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription may 
     * not be known, as in the case of 'inferred prescription'.</p></p>
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
     * <p><p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getPrescriptionTransmissionMethod() {
        return (ParticipationMode) this.prescriptionTransmissionMethod.getValue();
    }
    public void setPrescriptionTransmissionMethod(ParticipationMode prescriptionTransmissionMethod) {
        this.prescriptionTransmissionMethod.setValue(prescriptionTransmissionMethod);
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
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignature() {
        return this.signature.getValue();
    }
    public void setSignature(String signature) {
        this.signature.setValue(signature);
    }


    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
