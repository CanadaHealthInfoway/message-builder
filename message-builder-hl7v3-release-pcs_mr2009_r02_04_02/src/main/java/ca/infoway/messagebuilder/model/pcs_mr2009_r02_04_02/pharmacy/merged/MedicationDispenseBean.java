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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;



/**
 * <p>PORX_MT060340CA.MedicationDispense: Prescription 
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
 * <p>PORX_MT060090CA.MedicationDispense: Dispense</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 * 
 * <p>PORX_MT060160CA.MedicationDispense: Prescription 
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
@Hl7PartTypeMapping({"PORX_MT060090CA.MedicationDispense","PORX_MT060160CA.MedicationDispense","PORX_MT060340CA.MedicationDispense"})
@Hl7RootType
public class MedicationDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private OccurredAtBean location;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SubstitutionBean component3SubstitutionMade;
    private SupplyEventBean component1SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IncludesBean> subjectOf4 = new ArrayList<IncludesBean>();
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: PORX_MT060340CA.MedicationDispense.id</p>
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
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.id</p>
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
     * <p>Relationship: PORX_MT060160CA.MedicationDispense.id</p>
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
     * <p>Relationship: PORX_MT060340CA.MedicationDispense.id</p>
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
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.id</p>
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
     * <p>Relationship: PORX_MT060160CA.MedicationDispense.id</p>
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
     * PORX_MT060340CA.MedicationDispense.statusCode</p>
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
     * PORX_MT060090CA.MedicationDispense.statusCode</p>
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
     * PORX_MT060160CA.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If Active it means that the dispense has been 
     * processed but not yet given to the patient. If Complete, it 
     * indicates that the medication has been delivered to the 
     * patient.</p>
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
     * PORX_MT060340CA.MedicationDispense.statusCode</p>
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
     * PORX_MT060090CA.MedicationDispense.statusCode</p>
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
     * PORX_MT060160CA.MedicationDispense.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If Active it means that the dispense has been 
     * processed but not yet given to the patient. If Complete, it 
     * indicates that the medication has been delivered to the 
     * patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Performer3.assignedEntity</p>
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
     * <p>Relationship: PORX_MT060340CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Performer3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.MedicationDispense.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Component11.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction","component2/dosageInstruction"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060090CA.Component11"),
        @Hl7MapByPartType(name="component1", type="PORX_MT060340CA.Component11"),
        @Hl7MapByPartType(name="component1/dosageInstruction", type="COCT_MT270010CA.DosageInstruction"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060160CA.Component11"),
        @Hl7MapByPartType(name="component2/dosageInstruction", type="COCT_MT270010CA.DosageInstruction")})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component2/substitutionMade","component3/substitutionMade"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component2", type="PORX_MT060090CA.Component13"),
        @Hl7MapByPartType(name="component2", type="PORX_MT060340CA.Component13"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060090CA.SubstitutionMade"),
        @Hl7MapByPartType(name="component2/substitutionMade", type="PORX_MT060340CA.SubstitutionMade"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060160CA.Component13"),
        @Hl7MapByPartType(name="component3/substitutionMade", type="PORX_MT060160CA.SubstitutionMade")})
    public SubstitutionBean getComponent3SubstitutionMade() {
        return this.component3SubstitutionMade;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Component13.substitutionMade</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setComponent3SubstitutionMade(SubstitutionBean component3SubstitutionMade) {
        this.component3SubstitutionMade = component3SubstitutionMade;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/supplyEvent","component3/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component1", type="PORX_MT060160CA.Component"),
        @Hl7MapByPartType(name="component1/supplyEvent", type="PORX_MT060160CA.SupplyEvent"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060090CA.Component"),
        @Hl7MapByPartType(name="component3", type="PORX_MT060340CA.Component"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060090CA.SupplyEvent"),
        @Hl7MapByPartType(name="component3/supplyEvent", type="PORX_MT060340CA.SupplyEvent")})
    public SupplyEventBean getComponent1SupplyEvent() {
        return this.component1SupplyEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component.supplyEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1SupplyEvent(SupplyEventBean component1SupplyEvent) {
        this.component1SupplyEvent = component1SupplyEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject10.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.MedicationDispense.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.MedicationDispense.subjectOf3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.MedicationDispense.subjectOf4</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     */
    @Hl7XmlMapping({"subjectOf2","subjectOf3","subjectOf4"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060340CA.Subject7"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060090CA.Subject7"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060160CA.Subject7")})
    public List<IncludesBean> getSubjectOf4() {
        return this.subjectOf4;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator","subjectOf4/detectedIssueIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060160CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060340CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060160CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060340CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060090CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueIndicator", type="PORX_MT060090CA.DetectedIssueIndicator")})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Subject13.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject6.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent","subjectOf4/detectedIssueEvent","subjectOf5/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060090CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="COCT_MT260030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060340CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="COCT_MT260030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060160CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf5/detectedIssueEvent", type="COCT_MT260030CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf5/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060160CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060160CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060090CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf5", type="PORX_MT060340CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060090CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf5/annotationIndicator", type="PORX_MT060340CA.AnnotationIndicator")})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Subject12.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.MedicationDispense.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Cant have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Allows a provider to 
     * request restricted access by the patient.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.InFulfillmentOf.substanceAdministrationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }

}
