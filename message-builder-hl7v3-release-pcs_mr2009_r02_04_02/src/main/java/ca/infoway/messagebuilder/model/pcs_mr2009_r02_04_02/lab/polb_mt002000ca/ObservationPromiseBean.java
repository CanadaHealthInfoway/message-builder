/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ObservationMethod;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt130001ca.VersionInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.OutbreakBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ReportSectionSpecimenBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.SupportingClinicalInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca.BatteryOrPanelBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca.ObservationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca.PlacerGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt001001ca.RequestChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RoleChoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POLB_MT002000CA.ObservationPromise"})
public class ObservationPromiseBean extends MessagePartBean implements PromiseChoice {

    private static final long serialVersionUID = 20110407L;
    private ReportSectionSpecimenBean specimen;
    private Patient_1Bean recordTargetPatient;
    private II labOrderObservationIdentifier = new IIImpl();
    private List<RoleChoice> receiverRoleChoice = new ArrayList<RoleChoice>();
    private CD orderableObservationType = new CDImpl();
    private List<RoleChoice> performerRoleChoice = new ArrayList<RoleChoice>();
    private HealthcareOrganizationBean primaryInformationRecipientAssignedEntity;
    private IVL<TS, Interval<Date>> orderObservationActivatedDateTime = new IVLImpl<TS, Interval<Date>>();
    private List<FulfillmentChoice> inFulfillmentOfFulfillmentChoice = new ArrayList<FulfillmentChoice>();
    private SET<CV, Code> resultMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private OutbreakBean pertinentInformation1OutbreakEvent;
    private CV plannedObservationMethod = new CVImpl();
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
     * <p>Lab Order Observation Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLabOrderObservationIdentifier() {
        return this.labOrderObservationIdentifier.getValue();
    }
    public void setLabOrderObservationIdentifier(Identifier labOrderObservationIdentifier) {
        this.labOrderObservationIdentifier.setValue(labOrderObservationIdentifier);
    }


    @Hl7XmlMapping({"receiver/roleChoice"})
    public List<RoleChoice> getReceiverRoleChoice() {
        return this.receiverRoleChoice;
    }


    /**
     * <p>Orderable Observation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getOrderableObservationType() {
        return (Code) this.orderableObservationType.getValue();
    }
    public void setOrderableObservationType(Code orderableObservationType) {
        this.orderableObservationType.setValue(orderableObservationType);
    }


    @Hl7XmlMapping({"performer/roleChoice"})
    public List<RoleChoice> getPerformerRoleChoice() {
        return this.performerRoleChoice;
    }


    @Hl7XmlMapping({"primaryInformationRecipient/assignedEntity"})
    public HealthcareOrganizationBean getPrimaryInformationRecipientAssignedEntity() {
        return this.primaryInformationRecipientAssignedEntity;
    }
    public void setPrimaryInformationRecipientAssignedEntity(HealthcareOrganizationBean primaryInformationRecipientAssignedEntity) {
        this.primaryInformationRecipientAssignedEntity = primaryInformationRecipientAssignedEntity;
    }


    /**
     * <p>Order Observation Activated Date/Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getOrderObservationActivatedDateTime() {
        return this.orderObservationActivatedDateTime.getValue();
    }
    public void setOrderObservationActivatedDateTime(Interval<Date> orderObservationActivatedDateTime) {
        this.orderObservationActivatedDateTime.setValue(orderObservationActivatedDateTime);
    }


    @Hl7XmlMapping({"inFulfillmentOf/fulfillmentChoice"})
    public List<FulfillmentChoice> getInFulfillmentOfFulfillmentChoice() {
        return this.inFulfillmentOfFulfillmentChoice;
    }


    /**
     * <p>Result Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getResultMaskingIndicator() {
        return this.resultMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"pertinentInformation1/outbreakEvent"})
    public OutbreakBean getPertinentInformation1OutbreakEvent() {
        return this.pertinentInformation1OutbreakEvent;
    }
    public void setPertinentInformation1OutbreakEvent(OutbreakBean pertinentInformation1OutbreakEvent) {
        this.pertinentInformation1OutbreakEvent = pertinentInformation1OutbreakEvent;
    }


    /**
     * <p>Planned Observation Method</p>
     */
    @Hl7XmlMapping({"methodCode"})
    public ObservationMethod getPlannedObservationMethod() {
        return (ObservationMethod) this.plannedObservationMethod.getValue();
    }
    public void setPlannedObservationMethod(ObservationMethod plannedObservationMethod) {
        this.plannedObservationMethod.setValue(plannedObservationMethod);
    }


    @Hl7XmlMapping({"pertinentInformation2/supportingClinicalObservationEvent"})
    public List<SupportingClinicalInformationBean> getPertinentInformation2SupportingClinicalObservationEvent() {
        return this.pertinentInformation2SupportingClinicalObservationEvent;
    }


    @Hl7XmlMapping({"component/promiseChoice"})
    public List<PromiseChoice> getComponentPromiseChoice() {
        return this.componentPromiseChoice;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public VersionInformationBean getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }
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
