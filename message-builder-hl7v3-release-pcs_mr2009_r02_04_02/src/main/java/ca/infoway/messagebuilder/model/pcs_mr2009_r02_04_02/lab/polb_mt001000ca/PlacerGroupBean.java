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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001000ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.SpecimenRoleBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Placer Group</p>
 * 
 * <p><p>Group(er) of tests requested to be performed.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.PlacerGroup"})
public class PlacerGroupBean extends MessagePartBean implements RequestChoice {

    private static final long serialVersionUID = 20110729L;
    private List<SpecimenRoleBean> specimenSpecimen = new ArrayList<SpecimenRoleBean>();
    private Patient_1Bean recordTargetPatient;
    private II placerGroupIdentifier = new IIImpl();
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity;
    private List<HealthcareWorkerBean> callBackContactAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private SET<CV, Code> placerGroupMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private List<RecipientChoice> informationRecipientRecipientChoice = new ArrayList<RecipientChoice>();
    private List<HealthcareWorkerBean> verifierAssignedEntity = new ArrayList<HealthcareWorkerBean>();
    private ParentTestBean occurrenceOfActParentPointer;
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ReferralRedirectIndicatorBean component1ReferralRedirectIndicator;
    private OrderSortKeyBean component2RequestSortKey;
    private LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator;
    private List<RequestChoice> component4RequestChoice = new ArrayList<RequestChoice>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();
    private PriorTestRequestBean componentOfPriorActRequest;


    @Hl7XmlMapping({"specimen/specimen"})
    public List<SpecimenRoleBean> getSpecimenSpecimen() {
        return this.specimenSpecimen;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>A:Placer Group Identifier</p>
     * 
     * <p><p>Order (requisition) number of placer (requestor). If 
     * electronic order entry is not supported, then the sending 
     * organization must enter an Placer Order Identifier.</p><p>A 
     * unique number assigned to all tests in a requisition.</p></p>
     * 
     * <p><p>Order (requisition) number of placer (requestor). If 
     * electronic order entry is not supported, then the sending 
     * organization must enter an Placer Order Identifier.</p><p>A 
     * unique number assigned to all tests in a requisition.</p></p>
     * 
     * <p><p>This field allows an order placing application to 
     * group sets of requisitions together and subsequently 
     * identify them. Mandatory for create, revise, cancel, and 
     * nullify actions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPlacerGroupIdentifier() {
        return this.placerGroupIdentifier.getValue();
    }
    public void setPlacerGroupIdentifier(Identifier placerGroupIdentifier) {
        this.placerGroupIdentifier.setValue(placerGroupIdentifier);
    }


    @Hl7XmlMapping({"performer/assignedEntity"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    @Hl7XmlMapping({"callBackContact/assignedEntity"})
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity() {
        return this.callBackContactAssignedEntity;
    }


    /**
     * <p>B:Placer Group Masking Indicator</p>
     * 
     * <p><p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p></p>
     * 
     * <p><p>This code allows for privacy control by patients as 
     * well as flagged for 'not for disclosure to patient' by care 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getPlacerGroupMaskingIndicator() {
        return this.placerGroupMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"informationRecipient/recipientChoice"})
    public List<RecipientChoice> getInformationRecipientRecipientChoice() {
        return this.informationRecipientRecipientChoice;
    }


    @Hl7XmlMapping({"verifier/assignedEntity"})
    public List<HealthcareWorkerBean> getVerifierAssignedEntity() {
        return this.verifierAssignedEntity;
    }


    @Hl7XmlMapping({"occurrenceOf/actParentPointer"})
    public ParentTestBean getOccurrenceOfActParentPointer() {
        return this.occurrenceOfActParentPointer;
    }
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer) {
        this.occurrenceOfActParentPointer = occurrenceOfActParentPointer;
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"component1/referralRedirectIndicator"})
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator() {
        return this.component1ReferralRedirectIndicator;
    }
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator) {
        this.component1ReferralRedirectIndicator = component1ReferralRedirectIndicator;
    }


    @Hl7XmlMapping({"component2/requestSortKey"})
    public OrderSortKeyBean getComponent2RequestSortKey() {
        return this.component2RequestSortKey;
    }
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey) {
        this.component2RequestSortKey = component2RequestSortKey;
    }


    @Hl7XmlMapping({"component3/labInitiatedOrderIndicator"})
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator() {
        return this.component3LabInitiatedOrderIndicator;
    }
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator) {
        this.component3LabInitiatedOrderIndicator = component3LabInitiatedOrderIndicator;
    }


    @Hl7XmlMapping({"component4/requestChoice"})
    public List<RequestChoice> getComponent4RequestChoice() {
        return this.component4RequestChoice;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    @Hl7XmlMapping({"componentOf/priorActRequest"})
    public PriorTestRequestBean getComponentOfPriorActRequest() {
        return this.componentOfPriorActRequest;
    }
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest) {
        this.componentOfPriorActRequest = componentOfPriorActRequest;
    }

}
