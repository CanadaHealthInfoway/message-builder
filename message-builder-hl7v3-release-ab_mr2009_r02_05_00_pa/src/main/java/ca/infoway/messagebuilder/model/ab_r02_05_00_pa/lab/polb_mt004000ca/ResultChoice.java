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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.RoleChoice;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT004000CA.ResultChoice"})
@Hl7RootType
public interface ResultChoice extends ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt004999ca.ResultInstancePayloadChoice, ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt001999ca.ResultChoice {


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<ReportSectionSpecimenBean> getSpecimen();


    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public Patient_1Bean getRecordTargetPatient();

    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    public List<ElectronicResultReceiverBean> getReceiver();


    /**
     * <p>Relationship: POLB_MT004000CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RoleChoice> getPerformerRoleChoice();


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.ResultChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public PrimaryInformationRecipientBean getPrimaryInformationRecipient();

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.ResultChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPrimaryInformationRecipient(PrimaryInformationRecipientBean primaryInformationRecipient);


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public OutbreakBean getPertinentInformation1OutbreakEvent();

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: POLB_MT004000CA.Component2.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ResultSortKeyBean getComponent1ResultSortKey();

    /**
     * <p>Relationship: POLB_MT004000CA.Component2.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent1ResultSortKey(ResultSortKeyBean component1ResultSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Component3.reportableTestIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ReportableHealthIndicatorBean> getComponent2ReportableTestIndicator();


    /**
     * <p>Relationship: POLB_MT004000CA.Component1.resultChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ResultChoice> getComponent3ResultChoice();


    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public VersionInformationBean getSubjectOf1ControlActEvent();

    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf2();


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

}