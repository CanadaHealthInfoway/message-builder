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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.polb_mt004200ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.LabResultReportingProcessStepCode;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.ElectronicResultReceiverBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.ReportSectionSpecimenBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.ReportableHealthIndicatorBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.IncludesBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.RoleChoice;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import java.util.List;



@Hl7PartTypeMapping({"POLB_MT004200CA.ObservationChoice"})
@Hl7RootType
public interface ObservationChoice extends Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.polb_mt004999ca.ResultInstancePayloadChoice, Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.polb_mt001999ca.ResultChoice {


    /**
     * <p>Relationship: POLB_MT004200CA.ObservationChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    public List<ReportSectionSpecimenBean> getSpecimen();


    /**
     * <p>Relationship: POLB_MT004200CA.ObservationChoice.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    public List<ElectronicResultReceiverBean> getReceiver();


    /**
     * <p>Relationship: POLB_MT004200CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<RoleChoice> getPerformerRoleChoice();


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity();

    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity);


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice();


    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT004200CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     */
    public Identifier getPertinentInformation1OutbreakEventId();

    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT004200CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     */
    public void setPertinentInformation1OutbreakEventId(Identifier pertinentInformation1OutbreakEventId);


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component2.reportableTestIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ReportableHealthIndicatorBean> getComponent1ReportableTestIndicator();


    /**
     * <p>Business Name: Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT004200CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     */
    public String getComponent2ResultSortKeyText();

    /**
     * <p>Business Name: Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT004200CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     */
    public void setComponent2ResultSortKeyText(String component2ResultSortKeyText);


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component4.reportLevelObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ReportSectionObservationBean> getComponent3ReportLevelObservationEvent();


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component1.observationChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public List<ObservationChoice> getComponent4ObservationChoice();


    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public VersionInformationBean getSubjectOf1ControlActEvent();

    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent);


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.ObservationChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    public List<IncludesBean> getSubjectOf2();


    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    public LabResultReportingProcessStepCode getSubjectOf3ResultStatusProcessStepCode();

    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    public void setSubjectOf3ResultStatusProcessStepCode(LabResultReportingProcessStepCode subjectOf3ResultStatusProcessStepCode);

}
