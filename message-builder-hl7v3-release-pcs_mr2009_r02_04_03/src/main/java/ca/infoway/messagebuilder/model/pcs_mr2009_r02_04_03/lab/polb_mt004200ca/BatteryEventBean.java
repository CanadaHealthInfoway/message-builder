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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareOrganizationBean;
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



@Hl7PartTypeMapping({"POLB_MT004200CA.BatteryEvent"})
public class BatteryEventBean extends MessagePartBean implements ObservationChoice {

    private static final long serialVersionUID = 20131209L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<ReportSectionSpecimenBean> specimen = new ArrayList<ReportSectionSpecimenBean>();
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private List<ReportableHealthIndicatorBean> component1ReportableTestIndicator = new ArrayList<ReportableHealthIndicatorBean>();
    private ResultSortKeyBean component2ResultSortKey;
    private List<ReportSectionObservationBean> component3ReportLevelObservationEvent = new ArrayList<ReportSectionObservationBean>();
    private List<ObservationChoice> component4ObservationChoice = new ArrayList<ObservationChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    /**
     * <p>Business Name: Battery Event Identifier</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Type of Battery Event</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationOrderableLabType getCode() {
        return (ObservationOrderableLabType) this.code.getValue();
    }

    /**
     * <p>Business Name: Type of Battery Event</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCode(ObservationOrderableLabType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Battery Event Status</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Battery Event Status</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Battery Event Effective Time</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time at which the lab order became effective.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Battery Event Effective Time</p>
     * 
     * <p>Relationship: POLB_MT004200CA.BatteryEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Time at which the lab order became effective.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Battery Event Confidentiality</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.BatteryEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: POLB_MT004200CA.ObservationChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public List<ReportSectionSpecimenBean> getSpecimen() {
        return this.specimen;
    }


    /**
     * <p>Relationship: POLB_MT004200CA.ObservationChoice.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    /**
     * <p>Relationship: POLB_MT004200CA.ObservationChoice.performer</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-2)</p>
     */
    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PrimaryInformationRecipient.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.InFulfillmentOf.fulfillmentChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PertinentInformation1.outbreakEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component2.reportableTestIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component1/reportableTestIndicator"})
    public List<ReportableHealthIndicatorBean> getComponent1ReportableTestIndicator() {
        return this.component1ReportableTestIndicator;
    }


    /**
     * <p>Relationship: POLB_MT004200CA.Component3.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/resultSortKey"})
    public ResultSortKeyBean getComponent2ResultSortKey() {
        return this.component2ResultSortKey;
    }

    /**
     * <p>Relationship: POLB_MT004200CA.Component3.resultSortKey</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent2ResultSortKey(ResultSortKeyBean component2ResultSortKey) {
        this.component2ResultSortKey = component2ResultSortKey;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component4.reportLevelObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/reportLevelObservationEvent"})
    public List<ReportSectionObservationBean> getComponent3ReportLevelObservationEvent() {
        return this.component3ReportLevelObservationEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Component1.observationChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component4/observationChoice"})
    public List<ObservationChoice> getComponent4ObservationChoice() {
        return this.component4ObservationChoice;
    }


    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT004200CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.ObservationChoice.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf2"})
    public List<IncludesBean> getSubjectOf2() {
        return this.subjectOf2;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf3ResultStatusProcessStep() {
        return this.subjectOf3ResultStatusProcessStep;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004200CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep) {
        this.subjectOf3ResultStatusProcessStep = subjectOf3ResultStatusProcessStep;
    }

}
