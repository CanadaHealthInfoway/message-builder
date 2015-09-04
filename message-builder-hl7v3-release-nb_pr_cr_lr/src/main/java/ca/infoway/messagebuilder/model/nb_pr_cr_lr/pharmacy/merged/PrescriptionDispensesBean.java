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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108nb.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt260030nb.IssuesBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt270010nb.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.IncludesBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: PrescriptionDispenses</p>
 * 
 * <p>PORX_MT060340NB.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 * 
 * <p>PORX_MT060160NB.MedicationDispense: Prescription 
 * Dispenses</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Dispensing is an integral part of the overall medication 
 * process.</p>
 * 
 * <p>This is the detailed information about a medication 
 * dispense that has been performed on behalf of a patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060160NB.MedicationDispense","PORX_MT060340NB.MedicationDispense"})
public class PrescriptionDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private TargetedToPharmacyBean location;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component3SubstitutionMade;
    private SupplyEventBean component1SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IncludesBean> subjectOf4 = new ArrayList<IncludesBean>();
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060340NB.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060160NB.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060340NB.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060160NB.MedicationDispense.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p>
     * 
     * <p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If '''Active''' it means that the dispense has 
     * been processed but not yet given to the patient. If 
     * '''Complete''', it indicates that the medication has been 
     * delivered to the patient.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If '''Active''' it means that the dispense has 
     * been processed but not yet given to the patient. If 
     * '''Complete''', it indicates that the medication has been 
     * delivered to the patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction","component2/dosageInstruction"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060340NB.Component11"),
        @Hl7MapByPartType(name="component1/dosageInstruction", type="COCT_MT270010NB.DosageInstruction"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060160NB.Component11"),
        @Hl7MapByPartType(name="component2/dosageInstruction", type="COCT_MT270010NB.DosageInstruction")})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component2/substitutionMade","component3/substitutionMade"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component2", type="PORX_MT060340NB.Component13"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060340NB.SubstitutionMade"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060160NB.Component13"),
        @Hl7MapByPartType(name="component3/substitutionMade", type="PORX_MT060160NB.SubstitutionMade")})
    public SubstitutionBean getComponent3SubstitutionMade() {
        return this.component3SubstitutionMade;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3SubstitutionMade(SubstitutionBean component3SubstitutionMade) {
        this.component3SubstitutionMade = component3SubstitutionMade;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/supplyEvent","component3/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060160NB.Component"),
        @Hl7MapByPartType(name="component1/supplyEvent", type="PORX_MT060160NB.SupplyEvent"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060340NB.Component"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060340NB.SupplyEvent")})
    public SupplyEventBean getComponent1SupplyEvent() {
        return this.component1SupplyEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1SupplyEvent(SupplyEventBean component1SupplyEvent) {
        this.component1SupplyEvent = component1SupplyEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Subject10.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.MedicationDispense.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.MedicationDispense.subjectOf4</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     */
    @Hl7XmlMapping({"subjectOf2","subjectOf4"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060340NB.Subject7"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060160NB.Subject7")})
    public List<IncludesBean> getSubjectOf4() {
        return this.subjectOf4;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator"})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/detectedIssueEvent","subjectOf5/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060340NB.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="COCT_MT260030NB.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060160NB.Subject6"),
        @Hl7MapByPartType(name="subjectOf5/detectedIssueEvent", type="COCT_MT260030NB.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf5/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060160NB.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060160NB.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060340NB.Subject12"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060340NB.AnnotationIndicator")})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340NB.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160NB.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}