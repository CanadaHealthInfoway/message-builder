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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.LabResultReportingProcessStepCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ObservationLabReportType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ElectronicResultReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.ReportableHealthIndicatorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RoleChoice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Observation Report</p>
 * 
 * <p>Used to organize and report results.</p>
 * 
 * <p>This observation report object is used to group multiple 
 * clusters, batteries, or observations into one result 
 * report.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ObservationReport"})
public class ObservationReportBean extends MessagePartBean implements ResultChoice {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private ST title = new STImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private Patient_1Bean recordTargetPatient;
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private PrimaryInformationRecipientBean primaryInformationRecipient;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private II pertinentInformation1OutbreakEventId = new IIImpl();
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private ST component1ResultSortKeyText = new STImpl();
    private List<ReportableHealthIndicatorBean> component2ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private List<ResultChoice> component3ResultChoice = new ArrayList<ResultChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private CD subjectOf3ResultStatusProcessStepCode = new CDImpl();


    /**
     * <p>Business Name: Observation Report Identifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Unique identifiers are required for revisions and 
     * cancels.</p>
     * 
     * <p>Unique identifier for this result report.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Observation Report Identifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Unique identifiers are required for revisions and 
     * cancels.</p>
     * 
     * <p>Unique identifier for this result report.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Lab Observation Report Type</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of this observation report. Used for 
     * queries.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationLabReportType getCode() {
        return (ObservationLabReportType) this.code.getValue();
    }

    /**
     * <p>Business Name: Lab Observation Report Type</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of this observation report. Used for 
     * queries.</p>
     */
    public void setCode(ObservationLabReportType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Observation Report Title</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The title for this report.</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: Observation Report Title</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.title</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The title for this report.</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: Rendered Report</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This attribute is used to send a Rendered Report (or 
     * reference to) which includes only those elements in the 
     * message in a displayable format.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Rendered Report</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ObservationReport.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This attribute is used to send a Rendered Report (or 
     * reference to) which includes only those elements in the 
     * message in a displayable format.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Observation Report Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationReport.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p>
     * 
     * <p>The status or state of the report. The statusCode is not 
     * as fine-grained as lab reporting statuses such as 
     * preliminary. A &quot;preliminary&quot; result is a result 
     * whose statusCode=active and ProcessStep (procedure event) 
     * valued &quot;preliminary&quot;.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Observation Report Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationReport.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The statusCode represents the &quot;state&quot; of the 
     * act e.g. active=in progress or not yet started, 
     * complete=final.</p>
     * 
     * <p>The status or state of the report. The statusCode is not 
     * as fine-grained as lab reporting statuses such as 
     * preliminary. A &quot;preliminary&quot; result is a result 
     * whose statusCode=active and ProcessStep (procedure event) 
     * valued &quot;preliminary&quot;.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Report Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationReport.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date and time this report was 
     * &quot;released&quot;.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Report Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationReport.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The date and time this report was 
     * &quot;released&quot;.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ObservationReport.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>This code allows for privacy control by patients as well 
     * as flagged for 'not for disclosure to patient' by care 
     * providers.</p>
     * 
     * <p>Any piece of information is potentially subject to 
     * 'masking', restricting it's availability from providers who 
     * have not been specifically authorized. Additionally, some 
     * clinical data requires the ability to mark as &quot;not for 
     * direct disclosure to patient&quot;. The values in this 
     * attribute enable the above masking to be represented and 
     * messaged.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: POLB_MT004000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.ResultChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient"})
    public PrimaryInformationRecipientBean getPrimaryInformationRecipient() {
        return this.primaryInformationRecipient;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004000CA.ResultChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPrimaryInformationRecipient(PrimaryInformationRecipientBean primaryInformationRecipient) {
        this.primaryInformationRecipient = primaryInformationRecipient;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.OutbreakEvent.id</p>
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
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent/id"})
    public Identifier getPertinentInformation1OutbreakEventId() {
        return this.pertinentInformation1OutbreakEventId.getValue();
    }

    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.OutbreakEvent.id</p>
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
    public void setPertinentInformation1OutbreakEventId(Identifier pertinentInformation1OutbreakEventId) {
        this.pertinentInformation1OutbreakEventId.setValue(pertinentInformation1OutbreakEventId);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Business Name: Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     */
    @Hl7XmlMapping({"component1/resultSortKey/text"})
    public String getComponent1ResultSortKeyText() {
        return this.component1ResultSortKeyText.getValue();
    }

    /**
     * <p>Business Name: Sort Key Text</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     */
    public void setComponent1ResultSortKeyText(String component1ResultSortKeyText) {
        this.component1ResultSortKeyText.setValue(component1ResultSortKeyText);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004000CA.Component3.reportableTestIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent2ReportableTestIndicator() {
        return this.component2ReportableTestIndicator;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Component1.resultChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/resultChoice"})
    public List<ResultChoice> getComponent3ResultChoice() {
        return this.component3ResultChoice;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT004000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT004000CA.ResultChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep/code"})
    public LabResultReportingProcessStepCode getSubjectOf3ResultStatusProcessStepCode() {
        return (LabResultReportingProcessStepCode) this.subjectOf3ResultStatusProcessStepCode.getValue();
    }

    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    public void setSubjectOf3ResultStatusProcessStepCode(LabResultReportingProcessStepCode subjectOf3ResultStatusProcessStepCode) {
        this.subjectOf3ResultStatusProcessStepCode.setValue(subjectOf3ResultStatusProcessStepCode);
    }

}
