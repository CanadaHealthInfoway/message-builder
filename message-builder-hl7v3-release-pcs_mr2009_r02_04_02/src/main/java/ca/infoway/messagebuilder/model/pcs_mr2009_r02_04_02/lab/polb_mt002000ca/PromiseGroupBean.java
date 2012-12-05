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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT002000CA.PromiseGroup"})
public class PromiseGroupBean extends MessagePartBean implements PromiseChoice {

    private static final long serialVersionUID = 20121204L;
    private ReportSectionSpecimenBean specimen;
    private Patient_1Bean recordTargetPatient;
    private II id = new IIImpl();
    private List<ElectronicResultReceiverBean> receiver = new ArrayList<ElectronicResultReceiverBean>();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private TS effectiveTime = new TSImpl();
    private PrimaryInformationRecipientBean primaryInformationRecipient;
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private List<SupportingClinicalInformationBean> pertinentInformation2SupportingClinicalObservationEvent = new ArrayList<SupportingClinicalInformationBean>();
    private List<PromiseChoice> componentPromiseChoice = new ArrayList<PromiseChoice>();
    private VersionInformationBean subjectOf1ControlActEvent;
    private List<IncludesBean> subjectOf2 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf3ResultStatusProcessStep;


    @Hl7XmlMapping({"specimen"})
    public ReportSectionSpecimenBean getSpecimen() {
        return this.specimen;
    }

    public void setSpecimen(ReportSectionSpecimenBean specimen) {
        this.specimen = specimen;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public Patient_1Bean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }

    public void setRecordTargetPatient(Patient_1Bean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


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


    @Hl7XmlMapping({"receiver"})
    public List<ElectronicResultReceiverBean> getReceiver() {
        return this.receiver;
    }


    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    /**
     * <p>Business Name: Promise Grouper Date/Time</p>
     * 
     * <p>Relationship: POLB_MT002000CA.PromiseGroup.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
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
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
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


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }

    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.Component.promiseChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component/promiseChoice"})
    public List<PromiseChoice> getComponentPromiseChoice() {
        return this.componentPromiseChoice;
    }


    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    /**
     * <p>Relationship: POLB_MT002000CA.Subject1.controlActEvent</p>
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
