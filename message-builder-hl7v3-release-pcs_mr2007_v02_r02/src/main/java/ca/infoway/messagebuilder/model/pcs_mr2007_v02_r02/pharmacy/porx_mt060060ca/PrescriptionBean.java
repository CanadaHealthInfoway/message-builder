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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt060060ca;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DispenseInstructions_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.FirstDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.LastDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.PreviousDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.RemainingDispenseInformation_2Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what devices the patient is 
 * intended to be receiving.</p>
 * 
 * <p>Information pertaining to a Prescriber's authorization 
 * for a device to be dispensed to a patient, as well as the 
 * instruction on when and how the device is to be used by the 
 * patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060060CA.DevicePrescription"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.Prescription {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DeviceProductBean directTargetManufacturedProduct;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseInstructions_1Bean component2SupplyRequest;
    private RemainingDispenseInformation_2Bean fulfillment1SupplyEventFutureSummary;
    private FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary;
    private LastDispenseInformation_2Bean fulfillment3SupplyEventLastSummary;
    private PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DevicePrescription.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DevicePrescription.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.DevicePrescription.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.DevicePrescription.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060060CA.DevicePrescription.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can't have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.DirectTarget.manufacturedProduct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.DirectTarget.manufacturedProduct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setDirectTargetManufacturedProduct(DeviceProductBean directTargetManufacturedProduct) {
        this.directTargetManufacturedProduct = directTargetManufacturedProduct;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: PORX_MT060060CA.DevicePrescription.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: PORX_MT060060CA.DevicePrescription.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: PORX_MT060060CA.DevicePrescription.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Relationship: PORX_MT060060CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060060CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    /**
     * <p>Relationship: PORX_MT060060CA.Component1.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    /**
     * <p>Relationship: PORX_MT060060CA.Component1.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2/supplyRequest"})
    public DispenseInstructions_1Bean getComponent2SupplyRequest() {
        return this.component2SupplyRequest;
    }

    /**
     * <p>Relationship: PORX_MT060060CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2SupplyRequest(DispenseInstructions_1Bean component2SupplyRequest) {
        this.component2SupplyRequest = component2SupplyRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf4.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public RemainingDispenseInformation_2Bean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf4.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment1SupplyEventFutureSummary(RemainingDispenseInformation_2Bean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf5.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_2Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf5.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf6.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public LastDispenseInformation_2Bean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf6.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment3SupplyEventLastSummary(LastDispenseInformation_2Bean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_2Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    /**
     * <p>Relationship: PORX_MT060060CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060060CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060060CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: PORX_MT060060CA.Subject3.refusalToFill</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf3RefusalToFill() {
        return this.subjectOf3RefusalToFill;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060060CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
