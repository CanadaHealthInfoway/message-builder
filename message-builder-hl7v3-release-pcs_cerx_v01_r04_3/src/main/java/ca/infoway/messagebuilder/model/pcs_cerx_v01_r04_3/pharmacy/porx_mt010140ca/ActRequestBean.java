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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010140CA.ActRequest"})
public class ActRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }

}
