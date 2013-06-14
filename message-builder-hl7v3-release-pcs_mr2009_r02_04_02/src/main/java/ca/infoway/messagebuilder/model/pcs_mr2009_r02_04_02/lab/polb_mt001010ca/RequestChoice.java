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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ReferralRedirectIndicator;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.PriorTestRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.RecipientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.SpecimenRoleBean;
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
    public HealthcareOrganizationBean getPerformerAssignedEntity();

    /**
     * <p>Relationship: POLB_MT001010CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareOrganizationBean performerAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.CallBackContact.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<HealthcareWorkerBean> getCallBackContactAssignedEntity();


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
    public List<HealthcareWorkerBean> getVerifierAssignedEntity();


    /**
     * <p>Business Name: Parent Test Identifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.ActParentPointer.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     */
    public Identifier getOccurrenceOfActParentPointerId();

    /**
     * <p>Business Name: Parent Test Identifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.ActParentPointer.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     */
    public void setOccurrenceOfActParentPointerId(Identifier occurrenceOfActParentPointerId);


    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    public Identifier getPertinentInformation1OutbreakEventId();

    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    public void setPertinentInformation1OutbreakEventId(Identifier pertinentInformation1OutbreakEventId);


    /**
     * <p>Relationship: 
     * POLB_MT001010CA.PertinentInformation.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Business Name: O:Referral Redirect Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    public ReferralRedirectIndicator getComponent1ReferralRedirectIndicatorCode();

    /**
     * <p>Business Name: O:Referral Redirect Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    public void setComponent1ReferralRedirectIndicatorCode(ReferralRedirectIndicator component1ReferralRedirectIndicatorCode);


    /**
     * <p>Business Name: N:Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT001010CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    public String getComponent2RequestSortKeyText();

    /**
     * <p>Business Name: N:Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT001010CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    public void setComponent2RequestSortKeyText(String component2RequestSortKeyText);


    /**
     * <p>Business Name: Lab Initiated Order Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public Boolean getComponent3LabInitiatedOrderIndicatorNegationInd();

    /**
     * <p>Business Name: Lab Initiated Order Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.LabInitiatedOrderIndicator.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent3LabInitiatedOrderIndicatorNegationInd(Boolean component3LabInitiatedOrderIndicatorNegationInd);


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
