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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.SectionHeadingObservationCode;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Diagnosis or Interpretation Observation</p>
 * 
 * <p>The observation for communicating pathologists 
 * interpretations regarding a specimen. All observations which 
 * support the diagnosis report section(s) directly associated 
 * with the relevant diagnosis section. This structure for 
 * communicating pathology information is different than the 
 * way the sections are formattted in the printed report (each 
 * section contains all specimens with ordinal numbers).</p>
 */
@Hl7PartTypeMapping({"POLB_MT004200CA.SectionLevelObservationEvent"})
public class DiagnosisOrInterpretationObservationBean extends MessagePartBean implements ObservationChoice {

    private static final long serialVersionUID = 20121204L;
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private CD code = new CDImpl();
    private HealthcareWorkerBean primaryInformationRecipientAssignedEntity;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private ST text = new STImpl();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private List<ReportableHealthIndicatorBean> component1ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ResultSortKeyBean component2ResultSortKey;
    private ANY<Object> value = new ANYImpl<Object>();
    private List<ReportSectionObservationBean> component3ReportLevelObservationEvent = new ArrayList<ReportSectionObservationBean>();
    private List<ObservationChoice> component4ObservationChoice = new ArrayList<ObservationChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }


    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    /**
     * <p>Business Name: Section Identifier</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>A unique identifier is mandatory for all updates to any 
     * object.</p>
     * 
     * <p>Unique to identify this section of the report.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Business Name: Section Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of diagnostic observation. For 
     * cytology, LOINC codes are used for this attribute and also 
     * &quot;carry&quot; the specimen source e.g. ear, blood, etc. 
     * For surgical pathology, the specimen is indicated in the 
     * material entity and specimen collection procedure.method and 
     * text.</p>
     */
    @Hl7XmlMapping({"code"})
    public SectionHeadingObservationCode getCode() {
        return (SectionHeadingObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Section Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of diagnostic observation. For 
     * cytology, LOINC codes are used for this attribute and also 
     * &quot;carry&quot; the specimen source e.g. ear, blood, etc. 
     * For surgical pathology, the specimen is indicated in the 
     * material entity and specimen collection procedure.method and 
     * text.</p>
     */
    public void setCode(SectionHeadingObservationCode code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareWorkerBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }

    public void setPrimaryInformationRecipientAssignedEntity(HealthcareWorkerBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Business Name: Section Text</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the value attribute is not text-based (coded, 
     * for instance) and additional text information is required to 
     * be captured and communicated.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Section Text</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when the value attribute is not text-based (coded, 
     * for instance) and additional text information is required to 
     * be captured and communicated.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }

    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Business Name: Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status associated with the Section Level Observation.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Status associated with the Section Level Observation.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Section Reported Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time this section was reported/released for 
     * reporting.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Section Reported Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time this section was reported/released for 
     * reporting.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"component1/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent1ReportableTestIndicator() {
        return this.component1ReportableTestIndicator;
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.confidentialityCode</p>
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


    @Hl7XmlMapping({"component2/resultSortKey"})
    public ResultSortKeyBean getComponent2ResultSortKey() {
        return this.component2ResultSortKey;
    }

    public void setComponent2ResultSortKey(ResultSortKeyBean component2ResultSortKey) {
        this.component2ResultSortKey = component2ResultSortKey;
    }


    /**
     * <p>Business Name: Section Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The value or pathologist's interpretation for the Section 
     * Type provided in SectionLevelObservationEvent.code. If a 
     * coded value applies, values must be selected from 
     * SectionHeadingObservationValue Concept Domain.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Section Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SectionLevelObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The value or pathologist's interpretation for the Section 
     * Type provided in SectionLevelObservationEvent.code. If a 
     * coded value applies, values must be selected from 
     * SectionHeadingObservationValue Concept Domain.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component4.reportLevelObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component3/reportLevelObservationEvent"})
    public List<ReportSectionObservationBean> getComponent3ReportLevelObservationEvent() {
        return this.component3ReportLevelObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component1.observationChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component4/observationChoice"})
    public List<ObservationChoice> getComponent4ObservationChoice() {
        return this.component4ObservationChoice;
    }


    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }

    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }

}
