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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt060010ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt260030ca.IssuesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.DispenseStatusChangesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.TargetedToPharmacyBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.DispenseDetailsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.PrescriptionReference_1Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt120600ca.NotesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present</p><p>One of DetectedIssueIndicator 
 * or Reported Issues detailed info must be returned, but not 
 * both</p><p>One of AnnotationIndicator or Annotation detail 
 * info must be returned, but not both.</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present</p><p>One of DetectedIssueIndicator 
 * or Reported Issues detailed info must be returned, but not 
 * both</p><p>One of AnnotationIndicator or Annotation detail 
 * info must be returned, but not both.</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present</p><p>One of DetectedIssueIndicator 
 * or Reported Issues detailed info must be returned, but not 
 * both</p><p>One of AnnotationIndicator or Annotation detail 
 * info must be returned, but not both.</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p><p>Reported Issue is only permitted if Issue 
 * Indicator is not present</p><p>One of DetectedIssueIndicator 
 * or Reported Issues detailed info must be returned, but not 
 * both</p><p>One of AnnotationIndicator or Annotation detail 
 * info must be returned, but not both.</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.DeviceDispense"})
@Hl7RootType
public class DispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private TargetedToPharmacyBean location;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean component2SupplyEvent;
    private PrescriptionReference_1Bean fulfillmentSupplyRequest;
    private List<DispenseStatusChangesBean> subjectOf1ControlActEvent = new ArrayList<DispenseStatusChangesBean>();
    private List<IssuesBean> subjectOf2DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf3AnnotationIndicator = new BLImpl(false);
    private BL subjectOf4DetectedIssueIndicator = new BLImpl(false);
    private List<NotesBean> subjectOf5Annotation = new ArrayList<NotesBean>();


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Allows dispense events to be uniquely referenced and is 
     * therefore mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Allows dispense events to be uniquely referenced and is 
     * therefore mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B:Dispense Status</p>
     * 
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p>
     * 
     * <p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Dispense Status</p>
     * 
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p>
     * 
     * <p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: E:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.DeviceDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Indicates if a provider has 
     * requested restricted access to a patient or care giver.</p>
     * 
     * <p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Indicates if a provider has 
     * requested restricted access to a patient or care giver.</p>
     * 
     * <p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can&#226;&#128;&#153;t have both 
     * normal and one of the other codes simultaneously.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: PORX_MT060010CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Relationship: PORX_MT060010CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT060010CA.DeviceDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Component11.procedureRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>Relationship: PORX_MT060010CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }

    /**
     * <p>Relationship: PORX_MT060010CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060010CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public PrescriptionReference_1Bean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060010CA.InFulfillmentOf.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setFulfillmentSupplyRequest(PrescriptionReference_1Bean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    /**
     * <p>Relationship: PORX_MT060010CA.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<DispenseStatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: PORX_MT060010CA.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf2DetectedIssueEvent() {
        return this.subjectOf2DetectedIssueEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/annotationIndicator"})
    public Boolean getSubjectOf3AnnotationIndicator() {
        return this.subjectOf3AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf3AnnotationIndicator(Boolean subjectOf3AnnotationIndicator) {
        this.subjectOf3AnnotationIndicator.setValue(subjectOf3AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/detectedIssueIndicator"})
    public Boolean getSubjectOf4DetectedIssueIndicator() {
        return this.subjectOf4DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060010CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf4DetectedIssueIndicator(Boolean subjectOf4DetectedIssueIndicator) {
        this.subjectOf4DetectedIssueIndicator.setValue(subjectOf4DetectedIssueIndicator);
    }


    /**
     * <p>Relationship: PORX_MT060010CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/annotation"})
    public List<NotesBean> getSubjectOf5Annotation() {
        return this.subjectOf5Annotation;
    }

}
