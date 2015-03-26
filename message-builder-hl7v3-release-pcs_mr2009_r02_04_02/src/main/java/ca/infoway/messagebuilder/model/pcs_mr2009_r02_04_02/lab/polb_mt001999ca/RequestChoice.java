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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001999ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt080100ca.SpecimenRoleBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001999CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice extends ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.Lab {


    /**
     * <p>Relationship: POLB_MT001999CA.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SpecimenRoleBean> getSpecimenSpecimen();


    /**
     * <p>Relationship: POLB_MT001999CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PatientBean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT001999CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT001999CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001999CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RecipientChoice> getInformationRecipientRecipientChoice();


    /**
     * <p>Relationship: POLB_MT001999CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090102ca.HealthcareWorkerBean> getVerifierAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ParentTestBean getOccurrenceOfActParentPointer();

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);


    /**
     * <p>Relationship: POLB_MT001999CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OrderSortKeyBean getComponent2RequestSortKey();

    /**
     * <p>Relationship: POLB_MT001999CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001999CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);


    /**
     * <p>Relationship: POLB_MT001999CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RequestChoice> getComponent4RequestChoice();


    /**
     * <p>Relationship: 
     * POLB_MT001999CA.InFulfillmentOf.resultChoice1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ResultChoice> getFulfillmentResultChoice1();


    /**
     * <p>Relationship: POLB_MT001999CA.RequestChoice.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf1();


    /**
     * <p>Relationship: POLB_MT001999CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public VersionInformationBean getSubjectOf2ControlActEvent();

    /**
     * <p>Relationship: POLB_MT001999CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent);


    /**
     * <p>Relationship: POLB_MT001999CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PriorTestRequestBean getComponentOfPriorActRequest();

    /**
     * <p>Relationship: POLB_MT001999CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
