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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.AssignedEntityBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt980050ca.Indications;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Recommended Administration Instructions</p>
 * 
 * <p>This comprises the route of administration, 
 * maximum/minimum daily dose, and overall use instructions for 
 * the drug.</p>
 * 
 * <p>Gives guidance to prescribers on how the drug might 
 * be/should be used</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private PatientBean subjectPatient;
    private AssignedEntityBean authorAssignedEntity;
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<Indications> reasonIndications = new ArrayList<Indications>();
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: POME_MT010040CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the gender of patient to whom the 
     * dosage</p> <div>specification applies.</div>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: POME_MT010040CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the gender of patient to whom the 
     * dosage</p> <div>specification applies.</div>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntityBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(AssignedEntityBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Option.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Reason.indications</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reason/indications"})
    public List<Indications> getReasonIndications() {
        return this.reasonIndications;
    }


    /**
     * <p>Relationship: 
     * POME_MT010040CA.Precondition.observationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<PatientCharacteristicsBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

}
