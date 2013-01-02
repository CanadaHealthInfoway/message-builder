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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt060040ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.Author4Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.CoverageExtensionsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.DispenseInstructions_1Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.DispenseStatusChangesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.FirstDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.LastDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.PrescriptionDispensesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.PreviousDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.RemainingDispenseInformationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt120600ca.NotesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa.</p><p>Annotation is only 
 * permitted if Annotation Indicator is not present and vice 
 * versa</p>
 * 
 * <p>Information pertaining to a Prescriber's authorization 
 * for a device to be dispensed to a patient, as well as the 
 * instruction on when and how the device is to be used by the 
 * patient.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what devices the patient is 
 * intended to be receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.DeviceRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.Prescription_1 {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DeviceProductBean directTargetManufacturedProduct;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private Author4Bean author;
    private CreatedAtBean location;
    private ParentPrescriptionBean predecessorPriorSupplyRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private List<CoverageExtensionsBean> coverageCoverage = new ArrayList<CoverageExtensionsBean>();
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseInstructions_1Bean component2SupplyRequest;
    private LastDispenseInformationBean fulfillment1SupplyEventLastSummary;
    private FirstDispenseInformationBean fulfillment2SupplyEventFirstSummary;
    private RemainingDispenseInformationBean fulfillment3SupplyEventFutureSummary;
    private PreviousDispenseInformationBean fulfillment4SupplyEventPastSummary;
    private List<PrescriptionDispensesBean> fulfillment5DeviceDispense = new ArrayList<PrescriptionDispensesBean>();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<DispenseStatusChangesBean> subjectOf2ControlActEvent = new ArrayList<DispenseStatusChangesBean>();
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private List<RefusalToFillsBean> subjectOf4RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private BL subjectOf5DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf6AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DeviceRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DeviceRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DeviceRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DeviceRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.DeviceRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider ro request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked') and 'T' (taboo 
     * - denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is required because even if a jurisdiction doesn't 
     * support masking on the way in, it will need to need to 
     * communicate masked data returned from other 
     * jurisdictions.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060040CA.DirectTarget.manufacturedProduct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"directTarget/manufacturedProduct"})
    public DeviceProductBean getDirectTargetManufacturedProduct() {
        return this.directTargetManufacturedProduct;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060040CA.DirectTarget.manufacturedProduct</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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
    public Author4Bean getAuthor() {
        return this.author;
    }

    public void setAuthor(Author4Bean author) {
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


    /**
     * <p>Relationship: 
     * PORX_MT060040CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060040CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Relationship: PORX_MT060040CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060040CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensionsBean> getCoverageCoverage() {
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
    public LastDispenseInformationBean getFulfillment1SupplyEventLastSummary() {
        return this.fulfillment1SupplyEventLastSummary;
    }

    public void setFulfillment1SupplyEventLastSummary(LastDispenseInformationBean fulfillment1SupplyEventLastSummary) {
        this.fulfillment1SupplyEventLastSummary = fulfillment1SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformationBean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }

    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformationBean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventFutureSummary"})
    public RemainingDispenseInformationBean getFulfillment3SupplyEventFutureSummary() {
        return this.fulfillment3SupplyEventFutureSummary;
    }

    public void setFulfillment3SupplyEventFutureSummary(RemainingDispenseInformationBean fulfillment3SupplyEventFutureSummary) {
        this.fulfillment3SupplyEventFutureSummary = fulfillment3SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformationBean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }

    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformationBean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"fulfillment5/deviceDispense"})
    public List<PrescriptionDispensesBean> getFulfillment5DeviceDispense() {
        return this.fulfillment5DeviceDispense;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public List<DispenseStatusChangesBean> getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }


    /**
     * <p>Relationship: PORX_MT060040CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    @Hl7XmlMapping({"subjectOf4/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf4RefusalToFill() {
        return this.subjectOf4RefusalToFill;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060040CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/detectedIssueIndicator"})
    public Boolean getSubjectOf5DetectedIssueIndicator() {
        return this.subjectOf5DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060040CA.Subject2.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf5DetectedIssueIndicator(Boolean subjectOf5DetectedIssueIndicator) {
        this.subjectOf5DetectedIssueIndicator.setValue(subjectOf5DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: PORX_MT060040CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf6/annotationIndicator"})
    public Boolean getSubjectOf6AnnotationIndicator() {
        return this.subjectOf6AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060040CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf6AnnotationIndicator(Boolean subjectOf6AnnotationIndicator) {
        this.subjectOf6AnnotationIndicator.setValue(subjectOf6AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060040CA.Component2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
