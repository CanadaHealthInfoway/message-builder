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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt001010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.AssignedEntityBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.LabInitiatedOrderIndicatorBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.OrderSortKeyBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ParentTestBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ReferralRedirectIndicatorBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.SpecimenRoleBean;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001010CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice {


    /**
     * <p>Relationship: POLB_MT001010CA.Specimen.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SpecimenRoleBean> getSpecimenSpecimen();


    /**
     * <p>Relationship: POLB_MT001010CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public Patient_1Bean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT001010CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT001010CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001010CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean performerAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<HealthcareOrganizationBean> getCallBackContactAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.InformationRecipient.recipientChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RecipientChoice> getInformationRecipientRecipientChoice();


    /**
     * <p>Relationship: POLB_MT001010CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<AssignedEntityBean> getVerifierAssignedEntity();


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ParentTestBean getOccurrenceOfActParentPointer();

    /**
     * <p>Relationship: 
     * POLB_MT001010CA.OccurrenceOf.actParentPointer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT001010CA.PertinentInformation2.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001010CA.Component1.referralRedirectIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);


    /**
     * <p>Relationship: POLB_MT001010CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OrderSortKeyBean getComponent2RequestSortKey();

    /**
     * <p>Relationship: POLB_MT001010CA.Component2.requestSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();

    /**
     * <p>Relationship: 
     * POLB_MT001010CA.Component.labInitiatedOrderIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);


    /**
     * <p>Relationship: POLB_MT001010CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RequestChoice> getComponent4RequestChoice();


    /**
     * <p>Relationship: POLB_MT001010CA.RequestChoice.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf1();


    /**
     * <p>Relationship: POLB_MT001010CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public VersionInformationBean getSubjectOf2ControlActEvent();

    /**
     * <p>Relationship: POLB_MT001010CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent);


    /**
     * <p>Relationship: POLB_MT001010CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PriorTestRequestBean getComponentOfPriorActRequest();

    /**
     * <p>Relationship: POLB_MT001010CA.Component3.priorActRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
