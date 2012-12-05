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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ResultSortKeyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.WasPerformedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT004200CA.ObservationChoice"})
@Hl7RootType
public interface ObservationChoice extends ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004999ca.ResultInstancePayloadChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt001999ca.ResultChoice {


    public List<ReportSectionSpecimenBean> getSpecimen();


    public List<ElectronicResultReceiverBean> getReceiver();


    public List<WasPerformedByBean> getPerformer();


    public HealthcareWorkerBean getPrimaryInformationRecipientAssignedEntity();

    public void setPrimaryInformationRecipientAssignedEntity(HealthcareWorkerBean primaryInformationRecipientAssignedEntity);


    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();


    public OutbreakBean getPertinentInformation1OutbreakEvent();

    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent);


    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    public List<ReportableHealthIndicatorBean> getComponent1ReportableTestIndicator();


    public ResultSortKeyBean getComponent2ResultSortKey();

    public void setComponent2ResultSortKey(ResultSortKeyBean component2ResultSortKey);


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component4.reportLevelObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<ReportSectionObservationBean> getComponent3ReportLevelObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component1.observationChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public List<ObservationChoice> getComponent4ObservationChoice();


    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public VersionInformationBean getSubjectOf1ControlActEvent();

    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);


    public List<IncludesBean> getSubjectOf2();


    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep();

    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep);

}
