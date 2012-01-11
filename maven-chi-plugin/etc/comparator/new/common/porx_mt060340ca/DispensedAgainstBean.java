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
package ca.infoway.messagebuilder.model.common.porx_mt060340ca;

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
import ca.infoway.messagebuilder.model.merged.AssignedEntityBean;
import ca.infoway.messagebuilder.model.merged.Component2_2Bean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.IssueIndicatorBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.NotesIndicatorBean;
import ca.infoway.messagebuilder.model.merged.PerformsBean;
import ca.infoway.messagebuilder.model.merged.TriggerEventBean;
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
@Hl7PartTypeMapping({"PORX_MT060340CA.InFulfillmentOf1"})
public class DispensedAgainstBean extends MessagePartBean {

    private II prescriptionDispenseNumber = new IIImpl();
    private CS<ActStatus> dispenseStatus = new CSImpl<ActStatus>();
    private AssignedEntityBean medicationDispenseResponsiblePartyAssignedEntity;
    private AssignedEntityBean medicationDispensePerformerAssignedEntity = new AssignedEntityBean();
    private CreatedAtBean medicationDispenseLocation = new CreatedAtBean();
    private List<AdministrationInstructionsBean> medicationDispenseComponent1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private PerformsBean medicationDispenseComponent2;
    private Component2_2Bean medicationDispenseComponent3 = new Component2_2Bean();
    private List<TriggerEventBean> medicationDispenseSubjectOf1ControlActEvent = new ArrayList<TriggerEventBean>();
    private List<NotesBean> medicationDispenseSubjectOf2Annotation = new ArrayList<NotesBean>();
    private IssueIndicatorBean medicationDispenseSubjectOf3;
    private List<IssuesBean> medicationDispenseSubjectOf4DetectedIssueEvent = new ArrayList<IssuesBean>();
    private NotesIndicatorBean medicationDispenseSubjectOf5;

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
    public AssignedEntityBean getMedicationDispenseResponsiblePartyAssignedEntity() {
        return this.medicationDispenseResponsiblePartyAssignedEntity;
    }
    public void setMedicationDispenseResponsiblePartyAssignedEntity(AssignedEntityBean medicationDispenseResponsiblePartyAssignedEntity) {
        this.medicationDispenseResponsiblePartyAssignedEntity = medicationDispenseResponsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"medicationDispense/performer/assignedEntity"})
    public AssignedEntityBean getMedicationDispensePerformerAssignedEntity() {
        return this.medicationDispensePerformerAssignedEntity;
    }
    public void setMedicationDispensePerformerAssignedEntity(AssignedEntityBean medicationDispensePerformerAssignedEntity) {
        this.medicationDispensePerformerAssignedEntity = medicationDispensePerformerAssignedEntity;
    }

    @Hl7XmlMapping({"medicationDispense/location"})
    public CreatedAtBean getMedicationDispenseLocation() {
        return this.medicationDispenseLocation;
    }
    public void setMedicationDispenseLocation(CreatedAtBean medicationDispenseLocation) {
        this.medicationDispenseLocation = medicationDispenseLocation;
    }

    @Hl7XmlMapping({"medicationDispense/component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getMedicationDispenseComponent1DosageInstruction() {
        return this.medicationDispenseComponent1DosageInstruction;
    }

    @Hl7XmlMapping({"medicationDispense/component2"})
    public PerformsBean getMedicationDispenseComponent2() {
        return this.medicationDispenseComponent2;
    }
    public void setMedicationDispenseComponent2(PerformsBean medicationDispenseComponent2) {
        this.medicationDispenseComponent2 = medicationDispenseComponent2;
    }

    @Hl7XmlMapping({"medicationDispense/component3"})
    public Component2_2Bean getMedicationDispenseComponent3() {
        return this.medicationDispenseComponent3;
    }
    public void setMedicationDispenseComponent3(Component2_2Bean medicationDispenseComponent3) {
        this.medicationDispenseComponent3 = medicationDispenseComponent3;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf1/controlActEvent"})
    public List<TriggerEventBean> getMedicationDispenseSubjectOf1ControlActEvent() {
        return this.medicationDispenseSubjectOf1ControlActEvent;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf2/annotation"})
    public List<NotesBean> getMedicationDispenseSubjectOf2Annotation() {
        return this.medicationDispenseSubjectOf2Annotation;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf3"})
    public IssueIndicatorBean getMedicationDispenseSubjectOf3() {
        return this.medicationDispenseSubjectOf3;
    }
    public void setMedicationDispenseSubjectOf3(IssueIndicatorBean medicationDispenseSubjectOf3) {
        this.medicationDispenseSubjectOf3 = medicationDispenseSubjectOf3;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf4/detectedIssueEvent"})
    public List<IssuesBean> getMedicationDispenseSubjectOf4DetectedIssueEvent() {
        return this.medicationDispenseSubjectOf4DetectedIssueEvent;
    }

    @Hl7XmlMapping({"medicationDispense/subjectOf5"})
    public NotesIndicatorBean getMedicationDispenseSubjectOf5() {
        return this.medicationDispenseSubjectOf5;
    }
    public void setMedicationDispenseSubjectOf5(NotesIndicatorBean medicationDispenseSubjectOf5) {
        this.medicationDispenseSubjectOf5 = medicationDispenseSubjectOf5;
    }

}
