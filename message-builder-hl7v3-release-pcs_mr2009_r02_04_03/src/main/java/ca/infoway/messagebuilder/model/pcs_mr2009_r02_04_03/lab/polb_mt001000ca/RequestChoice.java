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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt001000ca;

import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.SpecimenRoleBean;



@Hl7PartTypeMapping({"POLB_MT001000CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice {


    /**
     * <p>Relationship: POLB_MT001000CA.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<SpecimenRoleBean> getSpecimenSpecimen();


    /**
     * <p>Relationship: POLB_MT001000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public Patient_1Bean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT001000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT001000CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001000CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<RecipientChoice> getInformationRecipientRecipientChoice();


    /**
     * <p>Relationship: POLB_MT001000CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean> getVerifierAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public ParentTestBean getOccurrenceOfActParentPointer();

    /**
     * <p>Relationship: 
     * POLB_MT001000CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT001000CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001000CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);


    /**
     * <p>Relationship: POLB_MT001000CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public OrderSortKeyBean getComponent2RequestSortKey();

    /**
     * <p>Relationship: POLB_MT001000CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT001000CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001000CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);


    /**
     * <p>Relationship: POLB_MT001000CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<RequestChoice> getComponent4RequestChoice();


    /**
     * <p>Relationship: POLB_MT001000CA.RequestChoice.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf();


    /**
     * <p>Relationship: POLB_MT001000CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public PriorTestRequestBean getComponentOfPriorActRequest();

    /**
     * <p>Relationship: POLB_MT001000CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
