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
package ca.infoway.messagebuilder.model.common.porx_mt060160ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.merged.Component2_2Bean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.IssueIndicatorBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.NotesIndicatorBean;
import ca.infoway.messagebuilder.model.merged.PerformsBean;
import ca.infoway.messagebuilder.model.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>m:dispensed against 
 * 
 * <p>Shows the prescription dispenses that have occurred 
 * against this prescription. 
 * 
 * <p>Helps the prescriber evaluate patient compliance. Allows 
 * the prescriber to see what specific medications have been 
 * dispensed to the patient and provides a more complete view 
 * of the patient's medical profile. 
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.InFulfillmentOf1"})
public class DispensedAgainstBean extends MessagePartBean {

    private II prescriptionDispenseNumber = new IIImpl();
    private CS<ActStatus> dispenseStatus = new CSImpl<ActStatus>();
    private HealthcareWorkerBean medicationDispenseResponsiblePartyAssignedEntity;
    private HealthcareWorkerBean medicationDispensePerformerAssignedEntity = new HealthcareWorkerBean();
    private CreatedAtBean medicationDispenseLocation = new CreatedAtBean();
    private Component2_2Bean medicationDispenseComponent1 = new Component2_2Bean();
    private List<AdministrationInstructionsBean> medicationDispenseComponent2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private PerformsBean medicationDispenseComponent3;
    private List<StatusChangesBean> medicationDispenseSubjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private NotesIndicatorBean medicationDispenseSubjectOf2;
    private IssueIndicatorBean medicationDispenseSubjectOf3;
    private List<NotesBean> medicationDispenseSubjectOf4Annotation = new ArrayList<NotesBean>();
    private List<IssuesBean> medicationDispenseSubjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();

    @Hl7XmlMapping({"medicationDispense/id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({"medicationDispense/statusCode"})
    public ActStatus getDispenseStatus() {
        return this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }

    @Hl7XmlMapping({"medicationDispense/responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getMedicationDispenseResponsiblePartyAssignedEntity() {
        return this.medicationDispenseResponsiblePartyAssignedEntity;
    }
    public void setMedicationDispenseResponsiblePartyAssignedEntity(HealthcareWorkerBean medicationDispenseResponsiblePartyAssignedEntity) {
        this.medicationDispenseResponsiblePartyAssignedEntity = medicationDispenseResponsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"medicationDispense/performer/assignedEntity"})
    public HealthcareWorkerBean getMedicationDispensePerformerAssignedEntity() {
        return this.medicationDispensePerformerAssignedEntity;
    }
    public void setMedicationDispensePerformerAssignedEntity(HealthcareWorkerBean medicationDispensePerformerAssignedEntity) {
        this.medicationDispensePerformerAssignedEntity = medicationDispensePerformerAssignedEntity;
    }

    @Hl7XmlMapping({"medicationDispense/location"})
    public CreatedAtBean getMedicationDispenseLocation() {
        return this.medicationDispenseLocation;
    }
    public void setMedicationDispenseLocation(CreatedAtBean medicationDispenseLocation) {
        this.medicationDispenseLocation = medicationDispenseLocation;
    }

    @Hl7XmlMapping({"medicationDispense/component1"})
    public Component2_2Bean getMedicationDispenseComponent1() {
        return this.medicationDispenseComponent1;
    }
    public void setMedicationDispenseComponent1(Component2_2Bean medicationDispenseComponent1) {
        this.medicationDispenseComponent1 = medicationDispenseComponent1;
    }

    @Hl7XmlMapping({"medicationDispense/component2/dosageInstruction"})
    public List<AdministrationInstructionsBean> getMedicationDispenseComponent2DosageInstruction() {
        return this.medicationDispenseComponent2DosageInstruction;
    }

    @Hl7XmlMapping({"medicationDispense/component3"})
    public PerformsBean getMedicationDispenseComponent3() {
        return this.medicationDispenseComponent3;
    }
    public void setMedicationDispenseComponent3(PerformsBean medicationDispenseComponent3) {
        this.medicationDispenseComponent3 = medicationDispenseComponent3;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getMedicationDispenseSubjectOf1ControlActEvent() {
        return this.medicationDispenseSubjectOf1ControlActEvent;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf2"})
    public NotesIndicatorBean getMedicationDispenseSubjectOf2() {
        return this.medicationDispenseSubjectOf2;
    }
    public void setMedicationDispenseSubjectOf2(NotesIndicatorBean medicationDispenseSubjectOf2) {
        this.medicationDispenseSubjectOf2 = medicationDispenseSubjectOf2;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf3"})
    public IssueIndicatorBean getMedicationDispenseSubjectOf3() {
        return this.medicationDispenseSubjectOf3;
    }
    public void setMedicationDispenseSubjectOf3(IssueIndicatorBean medicationDispenseSubjectOf3) {
        this.medicationDispenseSubjectOf3 = medicationDispenseSubjectOf3;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf4/annotation"})
    public List<NotesBean> getMedicationDispenseSubjectOf4Annotation() {
        return this.medicationDispenseSubjectOf4Annotation;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getMedicationDispenseSubjectOf5DetectedIssueEvent() {
        return this.medicationDispenseSubjectOf5DetectedIssueEvent;
    }

}
