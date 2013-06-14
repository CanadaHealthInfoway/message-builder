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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.polb_mt002000ca;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.LabResultReportingProcessStepCode;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.ElectronicResultReceiverBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.ReportSectionSpecimenBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.IncludesBean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.RoleChoice;
import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT002000CA.PromiseGroup"})
public class PromiseGroupBean extends MessagePartBean implements PromiseChoice {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ReportSectionSpecimenBean specimen;
    private Patient_1Bean recordTargetPatient;
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private PrimaryInformationRecipientBean primaryInformationRecipient;
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private II pertinentInformation1OutbreakEventId = new IIImpl();
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private List<PromiseChoice> componentPromiseChoice = new ArrayList<PromiseChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private CD subjectOf3ResultStatusProcessStepCode = new CDImpl();


    /**
     * <p>Business Name: Promise Grouper Identifier</p>
     * 
     * <p>Relationship: POLB_MT002000CA.PromiseGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Promise Grouper Identifier</p>
     * 
     * <p>Relationship: POLB_MT002000CA.PromiseGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Promise Grouper Date/Time</p>
     * 
     * <p>Relationship: POLB_MT002000CA.PromiseGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Promise Grouper Date/Time</p>
     * 
     * <p>Relationship: POLB_MT002000CA.PromiseGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.PromiseGroup.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public ReportSectionSpecimenBean getSpecimen() {
        return this.specimen;
    }

    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSpecimen(ReportSectionSpecimenBean specimen) {
        this.specimen = specimen;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    /**
     * <p>Relationship: POLB_MT002000CA.RecordTarget.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.Performer.roleChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PromiseChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient"})
    public PrimaryInformationRecipientBean getPrimaryInformationRecipient() {
        return this.primaryInformationRecipient;
    }

    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PromiseChoice.primaryInformationRecipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPrimaryInformationRecipient(PrimaryInformationRecipientBean primaryInformationRecipient) {
        this.primaryInformationRecipient = primaryInformationRecipient;
    }


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.InFulfillmentOf.fulfillmentChoice</p>
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
     * <p>Relationship: POLB_MT002000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent/id"})
    public Identifier getPertinentInformation1OutbreakEventId() {
        return this.pertinentInformation1OutbreakEventId.getValue();
    }

    /**
     * <p>Business Name: Outbreak Identifier</p>
     * 
     * <p>Relationship: POLB_MT002000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPertinentInformation1OutbreakEventId(Identifier pertinentInformation1OutbreakEventId) {
        this.pertinentInformation1OutbreakEventId.setValue(pertinentInformation1OutbreakEventId);
    }


    /**
     * <p>Relationship: 
     * POLB_MT002000CA.PertinentInformation2.supportingClinicalObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.Component.promiseChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/promiseChoice"})
    public List<PromiseChoice> getComponentPromiseChoice() {
        return this.componentPromiseChoice;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1ControlActEvent(VersionInformationBean subjectOf1ControlActEvent) {
        this.subjectOf1ControlActEvent = subjectOf1ControlActEvent;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.PromiseChoice.subjectOf2</p>
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
     * POLB_MT002000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Preliminary or Final.</p>
     */
    @Hl7XmlMapping({"subjectOf3/resultStatusProcessStep/code"})
    public LabResultReportingProcessStepCode getSubjectOf3ResultStatusProcessStepCode() {
        return (LabResultReportingProcessStepCode) this.subjectOf3ResultStatusProcessStepCode.getValue();
    }

    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Preliminary or Final.</p>
     */
    public void setSubjectOf3ResultStatusProcessStepCode(LabResultReportingProcessStepCode subjectOf3ResultStatusProcessStepCode) {
        this.subjectOf3ResultStatusProcessStepCode.setValue(subjectOf3ResultStatusProcessStepCode);
    }

}
