/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt001010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
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
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT001010CA.RequestChoice"})
@Hl7RootType
public interface RequestChoice {


    public List<SpecimenRoleBean> getSpecimenSpecimen();


    public Patient_1Bean getRecordTargetPatient();

    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT001010CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001010CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);


    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();


    public List<RecipientChoice> getInformationRecipientRecipientChoice();


    /**
     * <p>Relationship: POLB_MT001010CA.Verifier.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean> getVerifierAssignedEntity();


    public ParentTestBean getOccurrenceOfActParentPointer();

    public void setOccurrenceOfActParentPointer(ParentTestBean occurrenceOfActParentPointer);


    public OutbreakBean getPertinentInformation1OutbreakEvent();

    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    public ReferralRedirectIndicatorBean getComponent1ReferralRedirectIndicator();

    public void setComponent1ReferralRedirectIndicator(ReferralRedirectIndicatorBean component1ReferralRedirectIndicator);


    public OrderSortKeyBean getComponent2RequestSortKey();

    public void setComponent2RequestSortKey(OrderSortKeyBean component2RequestSortKey);


    public LabInitiatedOrderIndicatorBean getComponent3LabInitiatedOrderIndicator();

    public void setComponent3LabInitiatedOrderIndicator(LabInitiatedOrderIndicatorBean component3LabInitiatedOrderIndicator);


    /**
     * <p>Relationship: POLB_MT001010CA.Component5.requestChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<RequestChoice> getComponent4RequestChoice();


    public List<IncludesBean> getSubjectOf1();


    /**
     * <p>Relationship: POLB_MT001010CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public VersionInformationBean getSubjectOf2ControlActEvent();

    /**
     * <p>Relationship: POLB_MT001010CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ControlActEvent(VersionInformationBean subjectOf2ControlActEvent);


    public PriorTestRequestBean getComponentOfPriorActRequest();

    public void setComponentOfPriorActRequest(PriorTestRequestBean componentOfPriorActRequest);

}
