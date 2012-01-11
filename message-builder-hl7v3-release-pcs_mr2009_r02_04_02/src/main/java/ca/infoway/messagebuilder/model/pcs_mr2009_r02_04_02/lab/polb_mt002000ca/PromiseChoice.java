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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt002000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RoleChoice;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT002000CA.PromiseChoice"})
@Hl7RootType
public interface PromiseChoice {

    public ReportSectionSpecimenBean getSpecimen();
    public void setSpecimen(ReportSectionSpecimenBean specimen);

    public Patient_1Bean getRecordTargetPatient();
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient);

    public List<ElectronicResultReceiverBean> getReceiver();

    public List<RoleChoice> getPerformerRoleChoice();

    public PrimaryInformationRecipientBean getPrimaryInformationRecipient();
    public void setPrimaryInformationRecipient(PrimaryInformationRecipientBean primaryInformationRecipient);

    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();

    public OutbreakBean getPertinentInformation1OutbreakEvent();
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);

    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();

    public List<PromiseChoice> getComponentPromiseChoice();

    public VersionInformationBean getSubjectOf1ControlActEvent();
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);

    public List<IncludesBean> getSubjectOf2();

    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

}
