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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt020060ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.DispenseDetailsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.Patient;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.ProcedureRequestBean;



/**
 * <p>Business Name: Prescription Dispense</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Dispensing is an integral part of the overall 
 * prescription process.</p>
 * 
 * <p>This is the detailed information about a device dispense 
 * that has been performed on behalf a patient</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II id = new IIImpl();
    private CV confidentialityCode = new CVImpl();
    private Patient subjectPatient1;
    private PatientBean recordTargetPatient;
    private PrescriptionReferenceBean inFulfillmentOfDeviceRequest;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean component2SupplyEvent;
    private NotesBean subjectOfAnnotation;


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>DispensedItem.masked</p>
     * 
     * <p>Can be used to set a mask for a new dispense, if present 
     * in a new dispense request.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p>
     * 
     * <p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: E:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>DispensedItem.masked</p>
     * 
     * <p>Can be used to set a mask for a new dispense, if present 
     * in a new dispense request.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p>
     * 
     * <p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Subject8.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient1"})
    public Patient getSubjectPatient1() {
        return this.subjectPatient1;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Subject8.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient1(Patient subjectPatient1) {
        this.subjectPatient1 = subjectPatient1;
    }

    public PatientBean getSubjectPatient1AsPatient1() {
        return this.subjectPatient1 instanceof PatientBean ? (PatientBean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient1() {
        return (this.subjectPatient1 instanceof PatientBean);
    }

    public AnimalPatientBean getSubjectPatient1AsPatient2() {
        return this.subjectPatient1 instanceof AnimalPatientBean ? (AnimalPatientBean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient2() {
        return (this.subjectPatient1 instanceof AnimalPatientBean);
    }


    /**
     * <p>Relationship: PORX_MT020060CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: 
     * PORX_MT020060CA.InFulfillmentOf1.deviceRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/deviceRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfDeviceRequest() {
        return this.inFulfillmentOfDeviceRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020060CA.InFulfillmentOf1.deviceRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInFulfillmentOfDeviceRequest(PrescriptionReferenceBean inFulfillmentOfDeviceRequest) {
        this.inFulfillmentOfDeviceRequest = inFulfillmentOfDeviceRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }


    /**
     * <p>Relationship: PORX_MT020060CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    /**
     * <p>Relationship: PORX_MT020060CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
