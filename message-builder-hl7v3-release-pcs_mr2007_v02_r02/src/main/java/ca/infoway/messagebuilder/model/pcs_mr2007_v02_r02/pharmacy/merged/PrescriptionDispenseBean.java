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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import java.util.Set;



/**
 * <p>PORX_MT020060CA.DeviceDispense: Prescription Dispense</p>
 * 
 * <p>Dispensing is an integral part of the overall 
 * prescription process.</p>
 * 
 * <p>This is the detailed information about a device dispense 
 * that has been performed on behalf a patient</p>
 * 
 * <p>PORX_MT060020CA.DeviceDispense: Dispense</p>
 * 
 * <p>Communicates an overview of a patient's dispenses.</p>
 * 
 * <p>Represents the dispensing of a device to a patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceDispense","PORX_MT060020CA.DeviceDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private BL subject = new BLImpl(false);
    private PrescriptionReferenceBean inFulfillmentOfDeviceRequest;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean componentSupplyEvent;
    private NotesBean subjectOfAnnotation;
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private CreatedAtBean location;
    private SupplyOrderBean fulfillmentSupplyRequest;
    private BL subjectOf1DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows formal tracking of centrally recorded dispenses to 
     * local records for audit and related purposes.</p>
     * 
     * <p>Identifier assigned by the dispensing facility.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Can be used to set a mask for a new dispense, if present 
     * in a new dispense request.</p><p>Allows the patient to have 
     * discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Cant have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p>
     * 
     * <p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p>
     * 
     * <p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Cant have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public Boolean getSubject() {
        return this.subject.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.DeviceDispense.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubject(Boolean subject) {
        this.subject.setValue(subject);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.InFulfillmentOf1.deviceRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInFulfillmentOfDeviceRequest(PrescriptionReferenceBean inFulfillmentOfDeviceRequest) {
        this.inFulfillmentOfDeviceRequest = inFulfillmentOfDeviceRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Component2.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/supplyEvent","component2/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component", type="PORX_MT060020CA.Component2"),
        @Hl7MapByPartType(name="component/supplyEvent", type="PORX_MT060020CA.SupplyEvent"),
        @Hl7MapByPartType(name="component2", type="PORX_MT020060CA.Component"),
        @Hl7MapByPartType(name="component2/supplyEvent", type="PORX_MT020060CA.SupplyEvent")})
    public DispenseDetailsBean getComponentSupplyEvent() {
        return this.componentSupplyEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Component2.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentSupplyEvent(DispenseDetailsBean componentSupplyEvent) {
        this.componentSupplyEvent = componentSupplyEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020060CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }


    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.DeviceDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.Subject4.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.Subject4.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}
