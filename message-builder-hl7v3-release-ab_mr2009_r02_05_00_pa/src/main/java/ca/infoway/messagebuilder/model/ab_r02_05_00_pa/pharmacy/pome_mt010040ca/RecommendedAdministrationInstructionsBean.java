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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.BecauseOfBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Recommended Administration Instructions</p>
 * 
 * <p>Gives guidance to prescribers on how the drug might 
 * be/should be used</p>
 * 
 * <p>This comprises the route of administration, 
 * maximum/minimum daily dose, and overall use instructions for 
 * the drug.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.AdministrationGuideline"})
public class RecommendedAdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private PatientBean subjectPatient;
    private ST authorAssignedEntityAssignedOrganizationName = new STImpl();
    private List<AdministrationInstructionsBean> optionDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<PatientCharacteristicsBean> preconditionObservationEventCriterion = new ArrayList<PatientCharacteristicsBean>();


    /**
     * <p>Relationship: POME_MT010040CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Business Name: Recommending Authority Name</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The source of a recommendation may influence prescriber's 
     * willingness to use the recommended dose and is therefore 
     * mandatory</p>
     * 
     * <p>Indicates the name of the organization or agency that 
     * created the dosage recommendation</p>
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name"})
    public String getAuthorAssignedEntityAssignedOrganizationName() {
        return this.authorAssignedEntityAssignedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: Recommending Authority Name</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The source of a recommendation may influence prescriber's 
     * willingness to use the recommended dose and is therefore 
     * mandatory</p>
     * 
     * <p>Indicates the name of the organization or agency that 
     * created the dosage recommendation</p>
     */
    public void setAuthorAssignedEntityAssignedOrganizationName(String authorAssignedEntityAssignedOrganizationName) {
        this.authorAssignedEntityAssignedOrganizationName.setValue(authorAssignedEntityAssignedOrganizationName);
    }


    /**
     * <p>Relationship: POME_MT010040CA.Option.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"option/dosageInstruction"})
    public List<AdministrationInstructionsBean> getOptionDosageInstruction() {
        return this.optionDosageInstruction;
    }


    /**
     * <p>Relationship: 
     * POME_MT010040CA.AdministrationGuideline.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-250)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * POME_MT010040CA.Precondition.observationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<PatientCharacteristicsBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

}