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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.polb_mt001000nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050007nb.PatientBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt080100nb.SpecimenRoleBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108nb.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090508nb.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.IncludesBean;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001000NB.RequestChoice"})
@Hl7RootType
public interface RequestChoice {


    /**
     * <p>Relationship: POLB_MT001000NB.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SpecimenRoleBean> getSpecimenSpecimen();


    /**
     * <p>Relationship: POLB_MT001000NB.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PatientBean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT001000NB.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT001000NB.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001000NB.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RecipientChoice> getInformationRecipientRecipientChoice();


    /**
     * <p>Relationship: POLB_MT001000NB.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090102nb.HealthcareWorkerBean> getVerifierAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ParentTestBean getOccurrenceOfActParentPointer();

    /**
     * <p>Relationship: 
     * POLB_MT001000NB.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT001000NB.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001000NB.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);


    /**
     * <p>Relationship: POLB_MT001000NB.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OrderSortKeyBean getComponent2RequestSortKey();

    /**
     * <p>Relationship: POLB_MT001000NB.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT001000NB.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001000NB.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);


    /**
     * <p>Relationship: POLB_MT001000NB.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RequestChoice> getComponent4RequestChoice();


    /**
     * <p>Relationship: POLB_MT001000NB.RequestChoice.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf();


    /**
     * <p>Relationship: POLB_MT001000NB.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PriorTestRequestBean getComponentOfPriorActRequest();

    /**
     * <p>Relationship: POLB_MT001000NB.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
