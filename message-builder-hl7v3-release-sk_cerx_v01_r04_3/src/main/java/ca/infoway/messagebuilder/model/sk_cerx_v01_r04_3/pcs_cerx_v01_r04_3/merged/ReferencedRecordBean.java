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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ReferencedRecord</p>
 * 
 * <p>PORX_MT990020CA.ActRequest: Referenced Record</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">References 
 * an existing Request or Order record by identifier.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a request 
 * message, refers to the order record to be acted upon or 
 * which has been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a request 
 * message, refers to the order record to be acted upon or 
 * which has been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p>COMT_MT001101CA.ActRequest: Referenced Record</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">References 
 * an existing event record by identifier.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p>COMT_MT001103CA.ActEvent: Referenced Record</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">References 
 * an existing event record by identifier.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p>PORX_MT990010CA.ActEvent: Referenced Record</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">References 
 * an existing event record by identifier.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">As a 
 * request, refers to the event to be acted upon or which has 
 * been acted upon.</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">As a response, may 
 * be used to indicate the identifier assigned to a created 
 * object.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT001101CA.ActRequest","COMT_MT001103CA.ActEvent","PORX_MT010140CA.ActRequest","PORX_MT990010CA.ActEvent","PORX_MT990020CA.ActRequest"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II id = new IIImpl();
    private Patient_1Bean recordTargetPatient;
    private CS moodCode = new CSImpl();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);


    /**
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is an 
     * identifier assigned to a specific medication order. The 
     * number remains constant across the lifetime of the order, 
     * regardless of the number of providers or pharmacies involved 
     * in fulfilling the order.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptionExternalKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D53(ID for the 
     * prescription assigned by pharmacy)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D55(ID for the 
     * dispense event)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D99.01</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">X0101(id for 
     * prescription)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.22</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-01(extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.080-02(route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (route)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.456-EN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.454-EK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.prescriptio
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"recordTarget/patient","subject/patient"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="recordTarget", type="COMT_MT001101CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget", type="COMT_MT001103CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget", type="PORX_MT990010CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget/patient", type="COCT_MT050203CA.Patient"),
        @Hl7MapByPartType(name="subject", type="PORX_MT990020CA.Subject"),
        @Hl7MapByPartType(name="subject/patient", type="COCT_MT050203CA.Patient")})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    @Hl7XmlMapping({"moodCode"})
    public Code getMoodCode() {
        return (Code) this.moodCode.getValue();
    }
    public void setMoodCode(Code moodCode) {
        this.moodCode.setValue(moodCode);
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }

}
