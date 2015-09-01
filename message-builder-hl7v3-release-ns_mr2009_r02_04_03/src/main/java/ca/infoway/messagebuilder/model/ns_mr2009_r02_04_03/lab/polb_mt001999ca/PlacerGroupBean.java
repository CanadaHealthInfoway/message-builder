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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.polb_mt001999ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt080100ca.SpecimenRoleBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Placer Group</p>
 * 
 * <p>Group(er) of tests requested to be performed.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001999CA.PlacerGroup"})
public class PlacerGroupBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20150901L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<SpecimenRoleBean> specimenSpecimen = new ArrayList<SpecimenRoleBean>();
    private PatientBean recordTargetPatient;
    private HealthcareOrganizationBean performerAssignedEntity;
    private List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean> callBackContactAssignedEntity = new ArrayList<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean>();
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private ParentTestBean occurrenceOfActParentPointer;
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ReferralRedirectIndicatorBean component1ReferralRedirectIndicator;
    private OrderSortKeyBean component2RequestSortKey;
    private LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator;
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private List<ResultChoice> fulfillmentResultChoice1 = new ArrayList<ResultChoice>();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private VersionInformationBean subjectOf2ControlActEvent;
    private PriorTestRequestBean componentOfPriorActRequest;


    /**
     * <p>Business Name: A:Placer Group Identifier</p>
     * 
     * <p>Relationship: POLB_MT001999CA.PlacerGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>This field allows an order placing application to group 
     * sets of requisitions together and subsequently identify 
     * them. Mandatory for create, revise, cancel, and nullify 
     * actions.</p>
     * 
     * <p>Order (requisition) number of placer (requestor). If 
     * electronic order entry is not supported, then the sending 
     * organization must enter an Placer Order Identifier.</p><p>A 
     * unique number assigned to all tests in a requisition.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: B:Placer Group Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.PlacerGroup.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>This code allows for privacy control by patients as well 
     * as flagged for 'not for disclosure to patient' by care 
     * providers.</p>
     * 
     * <p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"specimen/specimen"})
    public List<SpecimenRoleBean> getSpecimenSpecimen() {
        return this.specimenSpecimen;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: POLB_MT001999CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareOrganizationBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Relationship: POLB_MT001999CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"callBackContact/assignedEntity"})
    public List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean> getCallBackContactAssignedEntity() {
        return this.callBackContactAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator() {
        return this.component1ReferralRedirectIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator) {
        this.component1ReferralRedirectIndicator = component1ReferralRedirectIndicator;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/requestSortKey"})
    public OrderSortKeyBean getComponent2RequestSortKey() {
        return this.component2RequestSortKey;
    }

    /**
     * <p>Relationship: POLB_MT001999CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey) {
        this.component2RequestSortKey = component2RequestSortKey;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator() {
        return this.component3LabInitiatedOrderIndicator;
    }

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator) {
        this.component3LabInitiatedOrderIndicator = component3LabInitiatedOrderIndicator;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.InFulfillmentOf.resultChoice1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/resultChoice1"})
    public List<ResultChoice> getFulfillmentResultChoice1() {
        return this.fulfillmentResultChoice1;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.RequestChoice.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/controlActEvent"})
    public VersionInformationBean getSubjectOf2ControlActEvent() {
        return this.subjectOf2ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT001999CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent) {
        this.subjectOf2ControlActEvent = subjectOf2ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT001999CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/priorActRequest"})
    public PriorTestRequestBean getComponentOfPriorActRequest() {
        return this.componentOfPriorActRequest;
    }

    /**
     * <p>Relationship: POLB_MT001999CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest) {
        this.componentOfPriorActRequest = componentOfPriorActRequest;
    }

}
