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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt060040ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.CoverageExtensions_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DeviceDispenseBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DispenseInstructions_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.FirstDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.LastDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.PreviousDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.RemainingDispenseInformation_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription</p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p></p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p></p>
 * 
 * <p><p>Information pertaining to a Prescriber's authorization 
 * for a device to be dispensed to a patient, as well as the 
 * instruction on when and how the device is to be used by the 
 * patient.</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what devices the patient is 
 * intended to be receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.DeviceRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.Prescription {

    private static final long serialVersionUID = 20110831L;
    private II prescriptionOrderNumber = new IIImpl();
    private CS prescriptionStatus = new CSImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private DeviceProductBean directTargetManufacturedProduct;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;
    private CreatedAtBean location;
    private ParentPrescriptionBean predecessorPriorSupplyRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseInstructions_1Bean component2SupplyRequest;
    private LastDispenseInformation_2Bean fulfillment1SupplyEventLastSummary;
    private FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary;
    private RemainingDispenseInformation_2Bean fulfillment3SupplyEventFutureSummary;
    private PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary;
    private List<DeviceDispenseBean> fulfillment5DeviceDispense = new ArrayList<DeviceDispenseBean>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<StatusChangesBean> subjectOf2ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private List<RefusalToFillsBean> subjectOf4RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private BL subjectOf5DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf6AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p>The Prescription Order Number is a globally unique 
     * number assigned to a prescription by the EHR/DIS 
     * irrespective of the source of the order</p><p>It is created 
     * by the EHR/DIS once the prescription has passed all edits 
     * and validation.</p></p>
     * 
     * <p><p>The Prescription Order Number is a globally unique 
     * number assigned to a prescription by the EHR/DIS 
     * irrespective of the source of the order</p><p>It is created 
     * by the EHR/DIS once the prescription has passed all edits 
     * and validation.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }


    /**
     * <p>C:Prescription Status</p>
     * 
     * <p><p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p></p>
     * 
     * <p><p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p></p>
     * 
     * <p><p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    /**
     * <p>F:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }
    public void setDirectTargetManufacturedProduct(DeviceProductBean directTargetManufacturedProduct) {
        this.directTargetManufacturedProduct = directTargetManufacturedProduct;
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"predecessor/priorSupplyRequest"})
    public ParentPrescriptionBean getPredecessorPriorSupplyRequest() {
        return this.predecessorPriorSupplyRequest;
    }
    public void setPredecessorPriorSupplyRequest(ParentPrescriptionBean predecessorPriorSupplyRequest) {
        this.predecessorPriorSupplyRequest = predecessorPriorSupplyRequest;
    }


    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"component2/supplyRequest"})
    public DispenseInstructions_1Bean getComponent2SupplyRequest() {
        return this.component2SupplyRequest;
    }
    public void setComponent2SupplyRequest(DispenseInstructions_1Bean component2SupplyRequest) {
        this.component2SupplyRequest = component2SupplyRequest;
    }


    @Hl7XmlMapping({"fulfillment1/supplyEventLastSummary"})
    public LastDispenseInformation_2Bean getFulfillment1SupplyEventLastSummary() {
        return this.fulfillment1SupplyEventLastSummary;
    }
    public void setFulfillment1SupplyEventLastSummary(LastDispenseInformation_2Bean fulfillment1SupplyEventLastSummary) {
        this.fulfillment1SupplyEventLastSummary = fulfillment1SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_2Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_2Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventFutureSummary"})
    public RemainingDispenseInformation_2Bean getFulfillment3SupplyEventFutureSummary() {
        return this.fulfillment3SupplyEventFutureSummary;
    }
    public void setFulfillment3SupplyEventFutureSummary(RemainingDispenseInformation_2Bean fulfillment3SupplyEventFutureSummary) {
        this.fulfillment3SupplyEventFutureSummary = fulfillment3SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_2Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_2Bean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"fulfillment5/deviceDispense"})
    public List<DeviceDispenseBean> getFulfillment5DeviceDispense() {
        return this.fulfillment5DeviceDispense;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    @Hl7XmlMapping({"subjectOf4/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf4RefusalToFill() {
        return this.subjectOf4RefusalToFill;
    }


    @Hl7XmlMapping({"subjectOf5/detectedIssueIndicator"})
    public Boolean getSubjectOf5DetectedIssueIndicator() {
        return this.subjectOf5DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf5DetectedIssueIndicator(Boolean subjectOf5DetectedIssueIndicator) {
        this.subjectOf5DetectedIssueIndicator.setValue(subjectOf5DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf6/annotationIndicator"})
    public Boolean getSubjectOf6AnnotationIndicator() {
        return this.subjectOf6AnnotationIndicator.getValue();
    }
    public void setSubjectOf6AnnotationIndicator(Boolean subjectOf6AnnotationIndicator) {
        this.subjectOf6AnnotationIndicator.setValue(subjectOf6AnnotationIndicator);
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
