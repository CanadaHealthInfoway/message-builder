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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt002000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt050007ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT002000CA.PromiseChoice"})
@Hl7RootType
public interface PromiseChoice {


    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public ReportSectionSpecimenBean getSpecimen();

    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSpecimen(ReportSectionSpecimenBean specimen);


    /**
     * <p>Relationship: POLB_MT002000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public PatientBean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT002000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(PatientBean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT002000CA.Receiver.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RoleChoice> getReceiverRoleChoice();


    /**
     * <p>Relationship: POLB_MT002000CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RoleChoice> getPerformerRoleChoice();


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity();

    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: POLB_MT002000CA.Component.promiseChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<PromiseChoice> getComponentPromiseChoice();


    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public VersionInformationBean getSubjectOf1ControlActEvent();

    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);


    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf2();


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();

    /**
     * <p>Relationship: 
     * POLB_MT002000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

}
