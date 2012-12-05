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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged.PatientBean;



/**
 * <p>Business Name: ReferencedRecord</p>
 * 
 * <p>PORX_MT990020CA.ActRequest: Referenced Record</p>
 * 
 * <p>References an existing Request or Order record by 
 * identifier.</p>
 * 
 * <p>As a request message, refers to the order record to be 
 * acted upon or which has been acted upon.</p><p>As a 
 * response, may be used to indicate the identifier assigned to 
 * a created object.</p>
 * 
 * <p>As a request message, refers to the order record to be 
 * acted upon or which has been acted upon.</p><p>As a 
 * response, may be used to indicate the identifier assigned to 
 * a created object.</p>
 * 
 * <p>PORX_MT990010CA.ActEvent: Referenced Record</p>
 * 
 * <p>References an existing event record by identifier.</p>
 * 
 * <p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p>
 * 
 * <p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.ActRequest","PORX_MT990010CA.ActEvent","PORX_MT990020CA.ActRequest"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private PatientBean recordTargetPatient;
    private BL preconditionVerificationEventCriterion = new BLImpl(false);


    /**
     * <p>Other Business Name: RecordId</p>
     * 
     * <p>Relationship: PORX_MT990020CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the Request or Order record being referred to.</p>
     * 
     * <p>Allows the order record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>&nbsp;This uniquely identifies the order from PIN. It 
     * can</p> <div>be stored by the receiving system for 
     * future</div> <div>reference to this order.</div>
     * 
     * <p>Other Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potenti
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Other Business Name: RecordId</p>
     * 
     * <p>Relationship: PORX_MT990020CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the Request or Order record being referred to.</p>
     * 
     * <p>Allows the order record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>&nbsp;This uniquely identifies the order from PIN. It 
     * can</p> <div>be stored by the receiving system for 
     * future</div> <div>reference to this order.</div>
     * 
     * <p>Other Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potenti
     * ... [rest of documentation truncated due to excessive length]
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: PertainsTo</p>
     * 
     * <p>Other Business Name: PertainsTo</p>
     * 
     * <p>Relationship: PORX_MT990020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of the patient who was acted on.&nbsp;</p>
     * 
     * <p>Other Business Name: PertainsTo</p>
     * 
     * <p>Relationship: PORX_MT990010CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of the patient who was acted on.&nbsp;</p>
     */
    @Hl7XmlMapping({"recordTarget/patient","subject/patient"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="recordTarget", type="PORX_MT990010CA.RecordTarget"),
        @Hl7MapByPartType(name="recordTarget/patient", type="COCT_MT050203CA.Patient"),
        @Hl7MapByPartType(name="subject", type="PORX_MT990020CA.Subject"),
        @Hl7MapByPartType(name="subject/patient", type="COCT_MT050203CA.Patient")})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Business Name: PertainsTo</p>
     * 
     * <p>Other Business Name: PertainsTo</p>
     * 
     * <p>Relationship: PORX_MT990020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of the patient who was acted on.&nbsp;</p>
     * 
     * <p>Other Business Name: PertainsTo</p>
     * 
     * <p>Relationship: PORX_MT990010CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of the patient who was acted on.&nbsp;</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Business Name: NonAuthoritative</p>
     * 
     * <p>Other Business Name: NonAuthoritative</p>
     * 
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If this is present, it indicates that the 
     * prescription</p> <div>is non-authoritative.</div>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Business Name: NonAuthoritative</p>
     * 
     * <p>Other Business Name: NonAuthoritative</p>
     * 
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If this is present, it indicates that the 
     * prescription</p> <div>is non-authoritative.</div>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }

}
